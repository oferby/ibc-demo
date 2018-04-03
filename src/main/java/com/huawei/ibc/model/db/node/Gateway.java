package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.protocol.EthernetPacket;

public class Gateway extends AbstractDevice {
    public Gateway(String id) {
        super(id, NodeType.GATEWAY);
    }


    @Override
    public void rx(ForwardingPort inPort, EthernetPacket packet) {

    }

}
