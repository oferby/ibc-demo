package com.huawei.ibc.model.controller;

import com.huawei.ibc.model.common.TopologyMessage;
import com.huawei.ibc.model.db.node.AbstractNode;
import com.huawei.ibc.model.db.node.ForwardingDevice;
import com.huawei.ibc.model.db.node.VirtualMachine;
import com.huawei.ibc.model.db.topology.ServiceTopology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TopologyControllerImpl {

    @Autowired
    private DatabaseControllerImpl databaseController;

    public TopologyMessage findTopology(String source, String destination){


        return null;

    }

}
