package com.huawei.ibc.model.db.protocol;

import com.huawei.ibc.model.db.node.AbstractNode;

import java.util.LinkedList;
import java.util.List;

public class PathDiscoveryPacket extends TcpPacket{

    private List<AbstractNode> pathNodes = new LinkedList<>();

    public PathDiscoveryPacket() {
    }

    public PathDiscoveryPacket(MACAddress sourceMac, String sourceIp, MACAddress destinationMac, String destinationIP) {
        super.destinationIp = destinationIP;
        super.sourceIp = sourceIp;
        super.sourceMac = sourceMac;
        super.destinationMac = destinationMac;

    }

    public List<AbstractNode> getPathNodes() {
        return pathNodes;
    }

    public void addPathNode(AbstractNode node){
        pathNodes.add(node);
    }
}
