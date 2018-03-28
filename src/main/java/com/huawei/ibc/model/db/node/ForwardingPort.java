package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.db.protocol.EthernetPacket;

public interface ForwardingPort extends ForwardingElement{

    ForwardingPort getConnectedPort();
    AbstractDevice getPortDevice();

}
