package com.huawei.ibc.model.db.protocol;

public class EthernetPacket {

    private MACAddress sourceMac;
    private MACAddress destinationMac;

    public MACAddress getSourceMac() {
        return sourceMac;
    }

    public void setSourceMac(MACAddress sourceMac) {
        this.sourceMac = sourceMac;
    }

    public MACAddress getDestinationMac() {
        return destinationMac;
    }

    public void setDestinationMac(MACAddress destinationMac) {
        this.destinationMac = destinationMac;
    }
}
