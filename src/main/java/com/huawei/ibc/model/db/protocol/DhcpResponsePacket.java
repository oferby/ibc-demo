package com.huawei.ibc.model.db.protocol;

import org.apache.commons.net.util.SubnetUtils;

public class DhcpResponsePacket extends EthernetPacket{

    private SubnetUtils subnetUtils;

    public DhcpResponsePacket(MACAddress source, MACAddress destination, SubnetUtils subnetUtils) {
        this.subnetUtils = subnetUtils;
        super.setDestinationMac(destination);
        super.setSourceMac(source);
    }

    public SubnetUtils getSubnetUtils() {
        return subnetUtils;
    }

    @Override
    public String toString() {
        return "DhcpResponsePacket{" +
                "subnetUtils=" + subnetUtils +
                '}';
    }
}
