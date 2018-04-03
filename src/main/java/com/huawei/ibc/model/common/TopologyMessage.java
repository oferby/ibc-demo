package com.huawei.ibc.model.common;

import com.huawei.ibc.model.db.node.AbstractDevice;

import java.util.HashSet;
import java.util.Set;

public class TopologyMessage {

    private Set<AbstractDevice> devices = new HashSet<>();
    private Set<ConnectionMessage>connectionSet = new HashSet<>();

    public Set<AbstractDevice> getDevices() {
        return devices;
    }

    public void setDevices(Set<AbstractDevice> devices) {
        this.devices = devices;
    }

    public void addDevice(AbstractDevice device){
        devices.add(device);
    }

    public Set<ConnectionMessage> getConnectionSet() {
        return connectionSet;
    }

    public void setConnectionSet(Set<ConnectionMessage> connectionSet) {
        this.connectionSet = connectionSet;
    }

    public void addConnection(String source, String destination) {
        connectionSet.add(new ConnectionMessage(source, destination));
    }
}
