package com.huawei.ibc.model.db.protocol;

import com.huawei.ibc.model.db.node.AbstractDevice;
import com.huawei.ibc.model.db.node.EthernetPort;

public class DhcpRequestPacket extends EthernetPacket{

    public DhcpRequestPacket() {
        super.setDestinationMac(MACAddress.valueOf("FF:FF:FF:FF:FF:FF"));
    }

    public DhcpRequestPacket(MACAddress source) {

        super.setSourceMac(source);

    }
}
