package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.protocol.EthernetPacket;
import com.huawei.ibc.model.db.protocol.IpPacket;
import com.huawei.ibc.model.db.protocol.MACAddress;
import com.huawei.ibc.model.db.protocol.PathDiscoveryPacket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Switch extends AbstractDevice implements ForwardingDevice {

    private Map<MACAddress, ForwardingPort> forwardingPortMap = new HashMap<>();

//    private Map<String,ForwardingPort> forwardingPortMap = new HashMap<>();

    public Switch(String id) {
        super(id, NodeType.SWITCH);
    }


    @Override
    public void rx(ForwardingPort inPort, IpPacket packet) {

        forwardingPortMap.put(packet.getSourceMac(), inPort);

        if (packet.getDestinationMac().isBroadcast()) {

            List<ForwardingPort> portList = super.getPortList();

            for (ForwardingPort port : portList) {
                if (port.equals(inPort))
                    continue;
                port.tx(packet);
                return;
            }

        }

        if (packet instanceof PathDiscoveryPacket) {
            ((PathDiscoveryPacket) packet).addPathNode(this);
        }

        if (forwardingPortMap.containsKey(packet.getDestinationMac())) {
            forwardingPortMap.get(packet.getDestinationMac()).tx(packet);
            return;
        }

        for (ForwardingPort port : this.getPortList()) {
            port.tx(packet);
            if (packet.isAck()) {
                forwardingPortMap.put(packet.getSourceMac(), inPort);
                return;
            }

        }

    }

    @Override
    public void tx(IpPacket packet) {

    }

}
