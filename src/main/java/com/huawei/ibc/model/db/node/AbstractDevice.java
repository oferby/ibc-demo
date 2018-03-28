package com.huawei.ibc.model.db.node;

import java.util.ArrayList;
import java.util.List;

public class AbstractDevice extends AbstractNode{

    private List<ForwardingPort> portList = new ArrayList<>();

    public AbstractDevice(String id, NodeType nodeType) {
        super(id, nodeType);
    }

    public List<ForwardingPort> getPortList() {
        return portList;
    }

    public void setPortList(List<ForwardingPort> portList) {
        this.portList = portList;
    }

    public List<String> getConnectedDevice(){

        List<String>connectedDeviceList = new ArrayList<>();
        for (ForwardingPort port : portList) {
            connectedDeviceList.add(port.getConnectedPort().getPortDevice().getId());
        }

        return connectedDeviceList;

    }
}
