package com.huawei.ibc.model.db.protocol;

public class EthernetPacket {

    private MACAddress sourceMac;
    private MACAddress destinationMac;
    private short ttl = 10;

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

    public short getTtl() {
        return ttl;
    }

    public void setTtl() {
        this.ttl-- ;
        if (this.ttl == 0)
            throw new RuntimeException("TTL expired");
    }

    @Override
    public String toString() {
        return "EthernetPacket{" +
                "sourceMac=" + sourceMac +
                ", destinationMac=" + destinationMac +
                ", ttl=" + ttl +
                '}';
    }
}
