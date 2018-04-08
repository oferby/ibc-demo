package com.huawei.ibc.service;

import com.huawei.ibc.model.common.AccessType;
import com.huawei.ibc.model.controller.DatabaseControllerImpl;
import com.huawei.ibc.model.db.node.AbstractNode;
import com.huawei.ibc.model.db.node.Group;
import com.huawei.ibc.model.db.node.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PolicyController {

    @Autowired
    private DatabaseControllerImpl databaseController;

    public boolean verifyPolicy(String sourceId, String targetId) {

        AbstractNode fromNode = null;
        AbstractNode toNode = null;
        AccessType type = null;
        AbstractNode node = null;
        for (Policy policy : databaseController.getAllPolicies()) {

            node = policy.getTo();

            if (node instanceof Group) {

                for (AbstractNode gNode : ((Group) node).getNodeSet()) {

                    if (gNode.getId().toLowerCase().equals(targetId.toLowerCase())) {
                        toNode = gNode;
                        break;
                    }

                }

            } else {

                if (node.getId().toLowerCase().equals(targetId.toLowerCase()))
                    toNode = node;

            }

            node = policy.getFrom();

            if (node instanceof Group) {

                for (AbstractNode gNode : ((Group) node).getNodeSet()) {

                    if (gNode.getId().toLowerCase().equals(sourceId.toLowerCase())) {
                        fromNode = gNode;
                        break;
                    }

                }

            } else {

                if (node.getId().toLowerCase().equals(sourceId.toLowerCase()))
                    fromNode = node;

            }

            if (toNode != null) {
                type = policy.getAccessType();
                break;

            }

            toNode = null;
            fromNode = null;


        }

        if (type == null || (type == AccessType.ALLOW && fromNode != null))
            return true;

//        if (type == AccessType.DENY )
        return false;

    }


}
