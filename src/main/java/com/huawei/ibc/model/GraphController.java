package com.huawei.ibc.model;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.model.client.EdgeEntity;
import com.huawei.ibc.model.client.GraphEntity;
import com.huawei.ibc.model.client.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GraphController {

    private int nodeNum = 0;

    public List<GraphEntity> getGraphEntity(IntentMessage intentMessage){

        List<GraphEntity>graphEntityList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            GraphEntity graphEntity = new GraphEntity();
            String id = "node"+nodeNum++;
            graphEntity.setId(id);
            graphEntity.setClasses("graphNode computeNode");
            graphEntity.setGroup(Group.NODES);

            graphEntityList.add(graphEntity);
        }

        EdgeEntity edge = new EdgeEntity();
        edge.setGroup(Group.EDGES);
        edge.setId("e1");
        edge.setSource("node1");
        edge.setTraget("node2");
        graphEntityList.add(edge);

        return graphEntityList;

    }


//    private GraphEntity getNode() {
//
//    }
//
//    private GraphEntity getEdge() {
//
//
//    }



}
