package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Policy extends AbstractNode {

    private Map<String, AbstractNode> allowMap;
    private Map<String, AbstractNode> denyMap;

    public Policy(String id) {
        super(id, NodeType.POLICY);
    }

    public void addToAllow(AbstractNode node) {
        if (allowMap == null) {
            allowMap = new HashMap<>();
        }

        allowMap.put(node.getId(), node);
    }

    public Collection<AbstractNode> getAllowed() {
        return allowMap.values();
    }

    public void addToDeny(AbstractNode node) {
        if (denyMap == null) {
            denyMap = new HashMap<>();
        }

        denyMap.put(node.getId(), node);
    }

    public Collection<AbstractNode> getDenyed() {
        return denyMap.values();
    }

}
