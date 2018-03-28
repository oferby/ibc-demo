package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.db.protocol.EthernetPacket;

public class Gateway extends AbstractDevice implements ForwardingElement{
    public Gateway(String id) {
        super(id, NodeType.GATEWAY);
    }

    @Override
    public void rx(EthernetPacket packet) {

    }

    @Override
    public void tx(EthernetPacket packet) {

    }
}
