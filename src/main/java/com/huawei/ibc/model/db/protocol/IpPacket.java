package com.huawei.ibc.model.db.protocol;

import java.net.InetAddress;

public class IpPacket extends EthernetPacket {

    private InetAddress source;
    private InetAddress destination;

    public InetAddress getSource() {
        return source;
    }

    public void setSource(InetAddress source) {
        this.source = source;
    }

    public InetAddress getDestination() {
        return destination;
    }

    public void setDestination(InetAddress destination) {
        this.destination = destination;
    }
}
