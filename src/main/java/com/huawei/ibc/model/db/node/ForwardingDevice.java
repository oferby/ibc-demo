package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.db.protocol.EthernetPacket;

public interface ForwardingDevice{

    void rx(ForwardingPort inPort, EthernetPacket packet);

}
