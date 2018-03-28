package com.huawei.ibc.model.client;

import com.huawei.ibc.model.common.NodeType;

public class NodeEntity extends GraphEntity{

    public void setType(NodeType type) {

        switch (type) {
            case SUBNET:
                this.setNodeClass("subnet");
                break;
            case ACL:
                this.setNodeClass("acl");
                break;
            case LB:
                this.setNodeClass("loadBalancer");
                break;
            case ROUTER:
                this.setNodeClass("router");
                break;
            case SWITCH:
                this.setNodeClass("switch");
                break;
            case GATEWAY:
                this.setNodeClass("gateway");
                break;
            case FIREWALL:
                this.setNodeClass("firewall");
                break;
            case COMPUTE_NODE:
                this.setNodeClass("computeNode");
                break;
            case INTERNET:
                this.setNodeClass("internet");
            default:
                throw new RuntimeException();
        }

    }

    private void setNodeClass(String nodeClass){
        this.setClasses("graphNode " + nodeClass);
    }

}
