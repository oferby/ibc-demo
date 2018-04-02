package com.huawei.ibc.model;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.message.IntentStatus;
import com.huawei.ibc.model.client.*;
import com.huawei.ibc.model.client.Group;
import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.db.DatabaseController;
import com.huawei.ibc.model.db.node.*;
import com.huawei.ibc.service.AddressController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class GraphController {

    private int numId = 0;

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private DatabaseController databaseController;

    @Autowired
    private AddressController addressController;

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
            case "disconnectNodes":
                this.disconnectNodes(intentMessage);
                return null;
            case "deleteAll":
                this.deleteAll(intentMessage);
                return null;
            case "showAll":
                return showAll(graphEntityList);
            case "addFirewall":
                graphEntityList.add(addFirewall(intentMessage));
                return graphEntityList;
        }

        throw new RuntimeException("not supported!");
    }

    private void disconnectNodes(IntentMessage intentMessage) {

        String sourceId = intentMessage.getParamValue("source");
        String targetId = intentMessage.getParamValue("target");
        databaseController.deleteNodeConnection(sourceId, targetId);

        intentMessage.setStatus(IntentStatus.LOCAL);
        String id = this.getEdgeEntity(sourceId, targetId).getId();
        intentMessage.addParam("id", id);
        template.convertAndSend("/topic/hint", intentMessage);

    }

    private void deleteAll(IntentMessage intentMessage) {

        databaseController.deleteAll();
        intentMessage.setStatus(IntentStatus.LOCAL);
        intentMessage.setIntent("clear");

        template.convertAndSend("/topic/hint", intentMessage);

    }

    private List<GraphEntity> showAll(List<GraphEntity> graphEntityList) {

        Collection<AbstractDevice> devices = databaseController.getAllDevices();
        Set<GraphEdge> graphEdgeSet = new HashSet<>();

        for (AbstractDevice device : devices) {
            graphEntityList.add(this.createGraphNode(device));

            for (ForwardingPort port : device.getPortList()) {

                graphEdgeSet.add(getEdgeEntity(device.getId(),
                        port.getConnectedPort().getPortDevice().getId()));

            }

        }

        graphEntityList.addAll(graphEdgeSet);

        return graphEntityList;
    }


    private GraphEdge createNodeConnection(IntentMessage intentMessage) {

        String source = intentMessage.getParamValue("source");
        String target = intentMessage.getParamValue("target");
        boolean nodeConnection = databaseController.createNodeConnection(source, target);

        if (!nodeConnection) {
            throw new RuntimeException("could not connect " + source + " and " + target);
        }

        return this.getEdgeEntity(source, target);

    }


    private GraphEntity addVm(IntentMessage intentMessage) {

        VirtualMachine vm = databaseController.createVirtualMachine(this.getNodeName(intentMessage));
        return this.createGraphNode(vm);

    }

    private GraphEntity addRouter(IntentMessage intentMessage) {

        Router router = databaseController.createRouter(this.getNodeName(intentMessage));
        return this.createGraphNode(router);

    }

    private GraphEntity addSwitch(IntentMessage intentMessage) {

        Switch aSwitch = databaseController.createSwitch(this.getNodeName(intentMessage));
        return this.createGraphNode(aSwitch);
    }

    private GraphEntity addFirewall(IntentMessage intentMessage) {
        Firewall firewall = databaseController.createFirewall(this.getNodeName(intentMessage));
        return this.createGraphNode(firewall);
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
        List<Router> routerList = new ArrayList<>();
        for (int h = 0; h < 5; h++) {

            Router router = databaseController.createRouter("r" + h);
            graphEntityList.add(this.createGraphNode(router));
            routerList.add(router);

            for (int i = 0; i < 3; i++) {
                Switch sw = databaseController.createSwitch("sw" + (i + h * 10));
                graphEntityList.add(this.createGraphNode(sw));
                databaseController.createNodeConnection(router.getId(),sw.getId());
                graphEntityList.add(this.getEdgeEntity(router.getId(),sw.getId()));

                for (int j = 0; j < 5; j++) {
                    VirtualMachine vm = databaseController.createVirtualMachine("vm" + (i * 10 + j + h * 100));
                    graphEntityList.add(this.createGraphNode(vm));
                    databaseController.createNodeConnection(sw.getId(), vm.getId());
                    graphEntityList.add(this.getEdgeEntity(sw.getId(), vm.getId()));
                }
            }
        }

        Set<GraphEdge> graphEdgeSet = new HashSet<>();
        for (Router router : routerList) {
            for (Router router1 : routerList) {
                if (!router.getId().equals(router1.getId())) {
                    databaseController.createNodeConnection(router1.getId(),router.getId());
                    graphEdgeSet.add(this.getEdgeEntity(router1.getId(),router.getId()));
                }
            }
        }

        graphEntityList.addAll(graphEdgeSet);


        Internet internet = (Internet) databaseController.getNodeById("Internet");
        graphEntityList.add(this.createGraphNode(internet));
        Gateway gateway = new Gateway("gw1");
        graphEntityList.add(this.createGraphNode(gateway));
        databaseController.createNodeConnection(gateway.getId(), internet.getId());
        graphEntityList.add(this.getEdgeEntity(gateway.getId(), internet.getId()));

        databaseController.createNodeConnection(gateway.getId(), "r1");
        databaseController.createNodeConnection(gateway.getId(), "r2");
        databaseController.createNodeConnection(gateway.getId(), "r3");
        databaseController.createNodeConnection(gateway.getId(), "r4");
        graphEntityList.add(this.getEdgeEntity(gateway.getId(), "r1"));
        graphEntityList.add(this.getEdgeEntity(gateway.getId(), "r2"));
        graphEntityList.add(this.getEdgeEntity(gateway.getId(), "r3"));
        graphEntityList.add(this.getEdgeEntity(gateway.getId(), "r4"));

        return graphEntityList;
    }

    private GraphNode createGraphNode(AbstractDevice device) {

        return this.createGraphNode(device.getId(), device.getNodeType());

    }

    private GraphNode createGraphNode(String id, NodeType type) {

        GraphNode graphEntity = new GraphNode();
        graphEntity.setId(id);
        graphEntity.setType(type);
        graphEntity.setGroup(Group.NODES);

        return graphEntity;

    }


    private GraphEdge getEdgeEntity(String sourceId, String targetId) {

        GraphEdge edge = new GraphEdge();
        edge.setGroup(Group.EDGES);

        if (sourceId.compareTo(targetId) > 0) {
            String temp = sourceId;
            sourceId = targetId;
            targetId = temp;
        }

        edge.setSource(sourceId);
        edge.setTraget(targetId);

        String edgeId = sourceId + "-" + targetId;
        edge.setId(edgeId);

        return edge;
    }

}
