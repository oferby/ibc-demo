package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.protocol.EthernetPacket;

public class Internet extends AbstractDevice {

    public Internet(String id) {
        super(id, NodeType.INTERNET);
    }

    @Override
    public void rx(ForwardingPort inPort, EthernetPacket packet) {

    }

}
