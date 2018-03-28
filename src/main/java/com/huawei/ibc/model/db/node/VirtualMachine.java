package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.db.protocol.EthernetPacket;

public class VirtualMachine extends AbstractDevice implements ForwardingDevice {


    public VirtualMachine(String id) {
        super(id, NodeType.VIRTUAL_MACHINE);
    }

    @Override
    public void rx(EthernetPacket packet) {

    }

    @Override
    public void tx(EthernetPacket packet) {

    }
}
