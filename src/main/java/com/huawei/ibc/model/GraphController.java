package com.huawei.ibc.model;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.model.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GraphController {

    private int edgeNum = 0;

    @Autowired
    private SimpMessagingTemplate template;

    public List<GraphEntity> getGraphEntity(IntentMessage intentMessage) {

        if (intentMessage.getIntent().equals("buildDemo")) {
            return buildDemo();
        }

        throw new RuntimeException("not supported!");
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


    private NodeEntity createNodeEntity(String id, NodeType type) {

        NodeEntity graphEntity = new NodeEntity();
        graphEntity.setId(id);
        graphEntity.setType(type);
        graphEntity.setGroup(Group.NODES);

        return graphEntity;

    }


    private EdgeEntity getEdgeEntity(String sourceId, String targetId) {

        String edgeId = "e" + edgeNum++;
        EdgeEntity edge = new EdgeEntity();
        edge.setGroup(Group.EDGES);
        edge.setId(edgeId);
        edge.setSource(sourceId);
        edge.setTraget(targetId);

        return edge;
    }

    public void doThis(){
        this.template.send("", null);
    }

}
