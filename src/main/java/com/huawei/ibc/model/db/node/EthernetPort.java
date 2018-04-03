package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.db.protocol.*;
import org.apache.commons.net.util.SubnetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EthernetPort extends PromiscuousPort {

    private static final Logger logger = LoggerFactory.getLogger(EthernetPacket.class);

    private MACAddress macAddress;
    private SubnetUtils subnetUtils;
    private String[] ipAddressAllocation;
    private Set<String> allocatedIpAddress;



    public EthernetPort(MACAddress macAddress, AbstractDevice device) {
        super(device);
        this.macAddress = macAddress;
    }

    @Override
    public void rx(EthernetPacket packet) {

        logger.debug("got packet: " + packet);

        if (packet.getDestinationMac().isBroadcast()) {
            if (packet instanceof DhcpRequestPacket && super.device instanceof Router) {
                if ( ipAddressAllocation == null) {
                    ipAddressAllocation = subnetUtils.getInfo().getAllAddresses();
                    allocatedIpAddress = new HashSet<>();
                }

                for (String ipAddress : ipAddressAllocation) {
                    if (!allocatedIpAddress.contains(ipAddress)) {
                        allocatedIpAddress.add(ipAddress);
                        DhcpResponsePacket responsePacket = new DhcpResponsePacket(macAddress, packet.getSourceMac(),
                                new SubnetUtils(ipAddress,subnetUtils.getInfo().getNetmask()));
                        this.tx(responsePacket);
                        return;
                    }
                }

            }
        } else if (packet.getDestinationMac().equals(macAddress)) {

            if (packet instanceof DhcpResponsePacket) {
                subnetUtils = ((DhcpResponsePacket) packet).getSubnetUtils();
            }

        }

    }

    @Override
    public void tx(EthernetPacket packet) {

        packet.setSourceMac(this.macAddress);
        super.tx(packet);

    }

    public MACAddress getMacAddress() {
        return macAddress;
    }

    public void setIpAddress(String cidr){
        subnetUtils = new SubnetUtils(cidr);
    }

    public void setIpAddress(SubnetUtils address){
        subnetUtils = address;

    }

    public SubnetUtils getSubnetUtils() {
        return subnetUtils;
    }

}
