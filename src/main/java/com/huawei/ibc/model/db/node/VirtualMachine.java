package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.protocol.DhcpRequestPacket;
import com.huawei.ibc.model.db.protocol.IpPacket;
import com.huawei.ibc.model.db.protocol.MACAddress;
import com.huawei.ibc.model.db.protocol.PathDiscoveryPacket;

public class VirtualMachine extends AbstractDevice implements ForwardingDevice {

    public VirtualMachine(String id) {
        super(id, NodeType.COMPUTE_NODE);
    }


    @Override
    public void rx(ForwardingPort inPort, IpPacket packet) {

        if (packet instanceof PathDiscoveryPacket){
            this.handleDiscoveryPacket((PathDiscoveryPacket) packet);
            return;
        }
    }

    @Override
    public void tx(IpPacket packet) {

        if (packet instanceof PathDiscoveryPacket){
            this.handleDiscoveryPacket((PathDiscoveryPacket) packet);
            return;
        }

    }

    public void tx(IpPacket packet, EthernetPort port){

        if (packet instanceof DhcpRequestPacket) {
            port.tx(packet);
            DhcpRequestPacket dhcpRequestPacket = (DhcpRequestPacket) packet;
            port.setIpAddress(dhcpRequestPacket.getSubnetUtils());
            port.routerIp = packet.getSourceIp();
        }

    }


    private void handleDiscoveryPacket(PathDiscoveryPacket packet){

        packet.addPathNode(this);

        if (this.isForMyIp(packet))
            return;

        EthernetPort port = getPort(0);

        if (port.isInRange(packet.getDestinationIp())) {
            port.tx(packet);
            return;
        } else {
            MACAddress routerMac = this.arpTable.get(port.routerIp);
            packet.setDestinationMac(routerMac);
            port.tx(packet);
            return;
        }


    }


}
