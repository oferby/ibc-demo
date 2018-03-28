package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.db.protocol.EthernetPacket;

public class Switch extends AbstractDevice implements ForwardingElement{

    public Switch(String id) {
        super(id, NodeType.SWITCH);
    }

    @Override
    public void rx(EthernetPacket packet) {

    }

    @Override
    public void tx(EthernetPacket packet) {

    }
}
