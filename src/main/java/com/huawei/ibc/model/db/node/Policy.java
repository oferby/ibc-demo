package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.client.AccessType;
import com.huawei.ibc.model.common.NodeType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Policy extends AbstractNode {

    private AccessType accessType;
    private AbstractNode from;
    private AbstractNode to;

    public Policy(String id) {
        super(id, NodeType.POLICY);
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public AbstractNode getFrom() {
        return from;
    }

    public void setFrom(AbstractNode from) {
        this.from = from;
    }

    public AbstractNode getTo() {
        return to;
    }

    public void setTo(AbstractNode to) {
        this.to = to;
    }
}
