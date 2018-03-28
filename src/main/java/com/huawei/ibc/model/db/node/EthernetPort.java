package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.db.protocol.EthernetPacket;
import com.huawei.ibc.model.db.protocol.MACAddress;

public class EthernetPort implements ForwardingPort{

    private EthernetPort connectedTo;
    private MACAddress macAddress;
    private AbstractDevice device;

    public EthernetPort(MACAddress macAddress, AbstractDevice device) {
        this.macAddress = macAddress;
        this.device = device;
    }

    @Override
    public void rx(EthernetPacket packet) {


    }

    @Override
    public void tx(EthernetPacket packet) {

    }

    @Override
    public ForwardingPort getConnectedPort() {
        return null;
    }

    @Override
    public AbstractDevice getPortDevice() {
        return null;
    }

    public EthernetPort getConnectedTo() {
        return connectedTo;
    }

    public MACAddress getMacAddress() {
        return macAddress;
    }

    public AbstractDevice getDevice() {
        return device;
    }

    public void setConnectedTo(EthernetPort connectedTo) {
        this.connectedTo = connectedTo;
    }
}
