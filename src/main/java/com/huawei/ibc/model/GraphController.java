package com.huawei.ibc.model;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.model.client.*;
import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.DatabaseController;
import com.huawei.ibc.model.db.node.AbstractDevice;
import com.huawei.ibc.model.db.node.Router;
import com.huawei.ibc.model.db.node.Switch;
import com.huawei.ibc.model.db.node.VirtualMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GraphController {

    private int numId = 0;

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private DatabaseController databaseController;

    public List<GraphEntity> getGraphEntity(IntentMessage intentMessage) {

        String intent = intentMessage.getIntent();
        List<GraphEntity> graphEntityList = new ArrayList<>();
        switch (intent) {
            case "buildDemo":
                return buildDemo();
            case "addVm":
                graphEntityList.add(addVm(intentMessage));
                return graphEntityList;
            case "addRouter":
                graphEntityList.add(addRouter(intentMessage));
                return graphEntityList;
            case "addSwitch":
                graphEntityList.add(addSwitch(intentMessage));
                return graphEntityList;
            case "connectNodes":
                graphEntityList.add(createNodeConnection(intentMessage));
                return graphEntityList;
            case "deleteAll":
                this.deleteAll();
                return null;
        }

        throw new RuntimeException("not supported!");
    }

    private void deleteAll(){

        databaseController.deleteAll();


    }


    private EdgeEntity createNodeConnection(IntentMessage intentMessage) {

        String source = intentMessage.getParamValue("source");
        String target = intentMessage.getParamValue("target");
        boolean nodeConnection = databaseController.createNodeConnection(source, target);

        if (!nodeConnection){
            throw new RuntimeException("could not connect " + source + " and " + target);
        }

        return this.getEdgeEntity(source, target);

    }


    private GraphEntity addVm(IntentMessage intentMessage) {

        VirtualMachine vm = databaseController.createVirtualMachine(this.getNodeName(intentMessage));
        return this.createNodeEntity(vm);

    }

    private GraphEntity addRouter(IntentMessage intentMessage) {

        Router router = databaseController.createRouter(this.getNodeName(intentMessage));
        return this.createNodeEntity(router);

    }

    private GraphEntity addSwitch(IntentMessage intentMessage) {

        Switch aSwitch = databaseController.createSwitch(this.getNodeName(intentMessage));
        return this.createNodeEntity(aSwitch);
    }

    private String getNodeName(IntentMessage intentMessage) {

        String name = intentMessage.getParamValue("name");
        if (name == null) {
            name = "node" + numId++;
        }

        return name;

    }


    private List<GraphEntity> buildDemo() {

        List<GraphEntity> graphEntityList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            NodeEntity entity = this.createNodeEntity("node" + i, NodeType.COMPUTE_NODE);
            graphEntityList.add(entity);
        }

        for (int i = 0; i < 4; i++) {
            NodeEntity entity = this.createNodeEntity("sw" + i, NodeType.SWITCH);
            graphEntityList.add(entity);
        }

        for (int i = 0; i < 4; i++) {
            NodeEntity entity = this.createNodeEntity("r" + i, NodeType.ROUTER);
            graphEntityList.add(entity);
        }

        graphEntityList.add(getEdgeEntity("node1", "sw1"));
        graphEntityList.add(getEdgeEntity("node2", "sw1"));
        graphEntityList.add(getEdgeEntity("node3", "sw1"));
        graphEntityList.add(getEdgeEntity("r0", "sw0"));
        graphEntityList.add(getEdgeEntity("r0", "sw1"));
        graphEntityList.add(getEdgeEntity("r1", "sw2"));
        graphEntityList.add(getEdgeEntity("r1", "sw3"));


        return graphEntityList;
    }


    private NodeEntity createNodeEntity(AbstractDevice device) {

        return this.createNodeEntity(device.getId(), device.getNodeType());

    }

    private NodeEntity createNodeEntity(String id, NodeType type) {

        NodeEntity graphEntity = new NodeEntity();
        graphEntity.setId(id);
        graphEntity.setType(type);
        graphEntity.setGroup(Group.NODES);

        return graphEntity;

    }


    private EdgeEntity getEdgeEntity(String sourceId, String targetId) {

        String edgeId = sourceId + "-" + targetId;
        EdgeEntity edge = new EdgeEntity();
        edge.setGroup(Group.EDGES);
        edge.setId(edgeId);
        edge.setSource(sourceId);
        edge.setTraget(targetId);

        return edge;
    }

}
