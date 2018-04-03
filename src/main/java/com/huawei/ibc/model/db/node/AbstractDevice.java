package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.protocol.EthernetPacket;
import com.huawei.ibc.model.db.protocol.MACAddress;
import com.huawei.ibc.model.db.protocol.PromiscuousPort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractDevice extends AbstractNode implements ForwardingDevice {

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

    public List<String> getConnectedDevice() {

        List<String> connectedDeviceList = new ArrayList<>();
        for (ForwardingPort port : portList) {
            connectedDeviceList.add(port.getConnectedPort().getPortDevice().getId());
        }

        return connectedDeviceList;

    }

    public ForwardingPort addPort(MACAddress macAddress) {

        ForwardingPort port;
        if (this instanceof Switch || this instanceof Internet || this instanceof Firewall) {
            port = new PromiscuousPort(this);
        } else {
            port = new EthernetPort(macAddress, this);
        }

        portList.add(port);


        return port;
    }

    public void deletePort(ForwardingPort port) {

        portList.removeIf(next -> next == port);

    }

    @Override
    public abstract void rx(ForwardingPort inPort, EthernetPacket packet);

}
