package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.protocol.DhcpRequestPacket;
import com.huawei.ibc.model.db.protocol.DhcpResponsePacket;
import com.huawei.ibc.model.db.protocol.EthernetPacket;

public class Firewall extends AbstractDevice{

    public Firewall(String id) {
        super(id, NodeType.FIREWALL);
    }


    @Override
    public void rx(ForwardingPort inPort, EthernetPacket packet) {

        if (packet instanceof DhcpResponsePacket || packet instanceof DhcpRequestPacket ) {
            for (ForwardingPort port : super.getPortList()) {
                if (port.equals(inPort))
                    continue;
                port.tx(packet);
            }

        }

    }

}
