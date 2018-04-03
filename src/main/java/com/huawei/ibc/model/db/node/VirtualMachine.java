package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.protocol.EthernetPacket;

public class VirtualMachine extends AbstractDevice implements ForwardingDevice {

    public VirtualMachine(String id) {
        super(id, NodeType.COMPUTE_NODE);
    }


    @Override
    public void rx(ForwardingPort inPort, EthernetPacket packet) {

    }

}
