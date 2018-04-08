package com.huawei.ibc.model.controller;

import com.huawei.ibc.model.common.AccessType;
import com.huawei.ibc.model.common.TopologyMessage;
import com.huawei.ibc.model.db.node.*;
import com.huawei.ibc.model.db.protocol.MACAddress;
import com.huawei.ibc.model.db.protocol.PathDiscoveryPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TopologyControllerImpl {

    @Autowired
    private DatabaseControllerImpl databaseController;

    public TopologyMessage findTopology(String source, String destination) {

        TopologyMessage topologyMessage = new TopologyMessage();

        PathDiscoveryPacket packet = this.getDiscoveryPacket(source, destination);

        AbstractNode previousNode = null;
        for (AbstractNode node : packet.getPathNodes()) {
            topologyMessage.addDevice(node);
            if (previousNode != null) {
                topologyMessage.addConnection(previousNode.getId(), node.getId());
            }
            previousNode = node;
        }


        AbstractNode dNode = databaseController.getNodeById(destination);
        if (!packet.getPathNodes().peekLast().equals(dNode)) {
            topologyMessage.addDevice(dNode);
        }

        return topologyMessage;

    }


    private PathDiscoveryPacket getDiscoveryPacket(String source, String destination) {

        AbstractNode sNode = databaseController.getNodeById(source);
        AbstractNode dNode = databaseController.getNodeById(destination);

        assert sNode != null && dNode != null;

        PathDiscoveryPacket packet = new PathDiscoveryPacket();

        EthernetPort startingPort = null;
        VirtualMachine sourceVm = null;

        if (sNode instanceof VirtualMachine) {

            this.addSourceAddresses((VirtualMachine) sNode, packet);
            sourceVm = (VirtualMachine) sNode;
            startingPort = this.addSourceAddresses(sourceVm, packet);

        } else if (sNode instanceof Application) {

            Application app = (Application) sNode;
            sourceVm = app.getHost();
            startingPort = this.addSourceAddresses(sourceVm, packet);

        }

        if (dNode instanceof VirtualMachine) {
            VirtualMachine vm = (VirtualMachine) dNode;
            this.addDestinationAddresses(vm, packet);

        } else if (dNode instanceof Application) {
            Application app = (Application) dNode;
            this.addDestinationAddresses(app.getHost(), packet);
        }

        assert packet.getDestinationIp() != null && packet.getDestinationIp() != null && startingPort != null;

        sourceVm.tx(packet);

        return packet;

    }

    private EthernetPort addSourceAddresses(VirtualMachine vm, PathDiscoveryPacket packet) {
        EthernetPort port = (EthernetPort) vm.getPortList().get(0);
        MACAddress macAddress = port.getMacAddress();
        String ipAddress = port.getSubnetUtils().getInfo().getAddress();

        packet.setSourceMac(macAddress);
        packet.setSourceIp(ipAddress);

        return port;
    }

    private void addDestinationAddresses(VirtualMachine vm, PathDiscoveryPacket packet) {

        EthernetPort port = (EthernetPort) vm.getPortList().get(0);
        MACAddress macAddress = port.getMacAddress();
        String ipAddress = port.getSubnetUtils().getInfo().getAddress();

        packet.setDestinationMac(macAddress);
        packet.setDestinationIp(ipAddress);
    }

    public void addFirewallRule(AccessType type, String fromNode, String toNode) {

        if (type.equals(AccessType.ALLOW)) {

            PathDiscoveryPacket packet = this.getDiscoveryPacket(fromNode, toNode);

            VirtualMachine dNode = (VirtualMachine) databaseController.getNodeById(toNode);
            if (!packet.getPathNodes().peekLast().equals(dNode)) {

                if (packet.getPathNodes().peekLast() instanceof Firewall) {
                    Firewall firewall = (Firewall) packet.getPathNodes().peekLast();
                    int currentPriority = firewall.getFirewallRules().iterator().next().getPriority();
                    firewall.addRule(--currentPriority, type, packet.getSourceIp()+"/32", dNode.getIpAddress() + "/32",null,null);
                    return;
                }

            }


        }

        throw new RuntimeException("not supported!");

    }

}