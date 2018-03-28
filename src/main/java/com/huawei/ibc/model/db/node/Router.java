package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.protocol.EthernetPacket;

public class Router extends AbstractDevice implements ForwardingElement{

    public Router(String id) {
        super(id, NodeType.ROUTER);
    }

    @Override
    public void rx(EthernetPacket packet) {

    }

    @Override
    public void tx(EthernetPacket packet) {

    }
}
