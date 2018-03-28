package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.db.protocol.EthernetPacket;

public class Firewall extends AbstractDevice implements ForwardingElement{

    public Firewall(String id) {
        super(id, NodeType.FIREWALL);
    }

    @Override
    public void rx(EthernetPacket packet) {

    }

    @Override
    public void tx(EthernetPacket packet) {

    }
}
