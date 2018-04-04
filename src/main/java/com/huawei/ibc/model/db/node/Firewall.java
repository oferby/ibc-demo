package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.protocol.DhcpRequestPacket;
import com.huawei.ibc.model.db.protocol.EthernetPacket;
import com.huawei.ibc.model.db.protocol.IpPacket;
import com.huawei.ibc.model.db.protocol.PathDiscoveryPacket;

import javax.sound.sampled.Port;

public class Firewall extends AbstractDevice {

    public Firewall(String id) {
        super(id, NodeType.FIREWALL);
    }


    @Override
    public void rx(ForwardingPort inPort, IpPacket packet) {


        if (packet instanceof DhcpRequestPacket) {

            ForwardingPort port = this.getOtherPort(inPort);
            port.tx(packet);

        } else if (packet instanceof PathDiscoveryPacket) {
            PathDiscoveryPacket discoveryPacket = (PathDiscoveryPacket) packet;
            discoveryPacket.addPathNode(this);
            getOtherPort(inPort).tx(discoveryPacket);

        }

    }

    @Override
    public void tx(IpPacket packet) {

    }

    private ForwardingPort getOtherPort(ForwardingPort port) {
        ForwardingPort otherPort = null;
        for (ForwardingPort forwardingPort : this.getPortList()) {
            if (!forwardingPort.equals(port)) {
                otherPort = forwardingPort;
                break;
            }
        }

        return otherPort;
    }

}
