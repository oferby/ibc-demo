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
                return buildDemo(intentMessage);
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
                return showAll(intentMessage, graphEntityList);
            case "addFirewall":
                graphEntityList.add(addFirewall(intentMessage));
                return graphEntityList;
            case "addPolicy":
                graphEntityList.add(this.addPolicy(intentMessage));
                return graphEntityList;
            case "setPolicy":
                return this.setPolicy(intentMessage);
            case "showPolicies":
                graphEntityList.addAll(this.showAllPolicies(intentMessage));
                return graphEntityList;
            case "addApplication":
                graphEntityList.add(this.createApplication(intentMessage));
                return graphEntityList;
        }

        throw new RuntimeException("not supported!");
    }

    private GraphEntity addPolicy(IntentMessage intentMessage) {

        Policy policy = databaseController.createPolicy(intentMessage.getParamValue("name"));
        return this.createGraphNode(policy);

    }

    private List<GraphEntity> setPolicy(IntentMessage intentMessage) {

        List<GraphEntity> graphEntityList = new ArrayList<>();

        String policyName = intentMessage.getParamValue("name");
        Policy policy = databaseController.getPolicy(policyName);
        if (policy == null)
            throw new RuntimeException("policy name not found");
        graphEntityList.add(this.createGraphNode(policy));

        String fromNodeId = intentMessage.getParamValue("from");
        AbstractNode fromNode = databaseController.getNodeById(fromNodeId);
        if (fromNode == null)
            throw new RuntimeException("invalid from node id");
        policy.setFrom(fromNode);
        graphEntityList.add(this.createGraphNode(fromNode));
        graphEntityList.add(this.createGraphEdge(fromNode.getId(),policy.getId()));

        String toNodeId = intentMessage.getParamValue("to");
        AbstractNode toNode = databaseController.getNodeById(toNodeId);
        if (toNode == null)
            throw new RuntimeException("invalid to node id");
        policy.setTo(toNode);
        graphEntityList.add(this.createGraphNode(toNode));
        graphEntityList.add(this.createGraphEdge(toNode.getId(),policy.getId()));

        switch (intentMessage.getParamValue("operation")) {

            case "allow":
                policy.setAccessType(AccessType.ALLOW);
                break;

            case "deny":
                policy.setAccessType(AccessType.DENY);
                break;

            default:
                throw new RuntimeException("invalid policy operation");

        }

        return graphEntityList;
    }

    private Set<GraphEntity> showAllPolicies(IntentMessage intentMessage) {

        this.sendClearLocalIntent(intentMessage);

        Collection<Policy> policies = databaseController.getAllPolicies();

        Set<GraphEntity> graphEntities = new HashSet<>();
        for (Policy policy : policies) {
            graphEntities.add(this.createGraphNode(policy.getId(), NodeType.POLICY));
            AbstractNode from = policy.getFrom();
            if (from != null) {
                graphEntities.add(this.createGraphNode(from.getId(), from.getNodeType()));
                graphEntities.add(this.createGraphEdge(from.getId(), policy.getId()));

            }
            AbstractNode to = policy.getTo();
            if (to != null) {
                graphEntities.add(this.createGraphNode(to.getId(), to.getNodeType()));
                graphEntities.add(this.createGraphEdge(to.getId(), policy.getId()));
            }
        }

        return graphEntities;

    }

    private void disconnectNodes(IntentMessage intentMessage) {

        String sourceId = intentMessage.getParamValue("source");
        String targetId = intentMessage.getParamValue("target");
        databaseController.deleteNodeConnection(sourceId, targetId);

        intentMessage.setStatus(IntentStatus.LOCAL);
        String id = this.createGraphEdge(sourceId, targetId).getId();
        intentMessage.addParam("id", id);
        template.convertAndSend("/topic/hint", intentMessage);

    }

    private void deleteAll(IntentMessage intentMessage) {

        databaseController.deleteAll();
        this.sendClearLocalIntent(intentMessage);

    }

    private void sendClearLocalIntent(IntentMessage intentMessage) {

        intentMessage.setStatus(IntentStatus.LOCAL);
        intentMessage.setIntent("clear");
        template.convertAndSend("/topic/hint", intentMessage);
    }


    private List<GraphEntity> showAll(IntentMessage intentMessage, List<GraphEntity> graphEntityList) {

        this.sendClearLocalIntent(intentMessage);

        Collection<AbstractDevice> devices = databaseController.getAllDevices();
        Set<GraphEdge> graphEdgeSet = new HashSet<>();

        for (AbstractDevice device : devices) {
            graphEntityList.add(this.createGraphNode(device));

            for (ForwardingPort port : device.getPortList()) {

                graphEdgeSet.add(createGraphEdge(device.getId(),
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

        return this.createGraphEdge(source, target);

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

    private List<GraphEntity> buildDemo(IntentMessage intentMessage) {

        this.sendClearLocalIntent(intentMessage);

        List<GraphEntity> graphEntityList = new ArrayList<>();
        List<Router> routerList = new ArrayList<>();
        for (int h = 0; h < 5; h++) {

            Router router = databaseController.createRouter("r" + h);
            graphEntityList.add(this.createGraphNode(router));
            routerList.add(router);

            for (int i = 0; i < 3; i++) {
                Switch sw = databaseController.createSwitch("sw" + (i + h * 10));
                graphEntityList.add(this.createGraphNode(sw));
                databaseController.createNodeConnection(router.getId(), sw.getId());
                graphEntityList.add(this.createGraphEdge(router.getId(), sw.getId()));

                for (int j = 0; j < 5; j++) {
                    VirtualMachine vm = databaseController.createVirtualMachine("vm" + (i * 10 + j + h * 100));
                    graphEntityList.add(this.createGraphNode(vm));
                    databaseController.createNodeConnection(sw.getId(), vm.getId());
                    graphEntityList.add(this.createGraphEdge(sw.getId(), vm.getId()));
                }
            }
        }

        Set<GraphEdge> graphEdgeSet = new HashSet<>();
        for (Router router : routerList) {
            for (Router router1 : routerList) {
                if (!router.getId().equals(router1.getId())) {
                    databaseController.createNodeConnection(router1.getId(), router.getId());
                    graphEdgeSet.add(this.createGraphEdge(router1.getId(), router.getId()));
                }
            }
        }

        graphEntityList.addAll(graphEdgeSet);


        Internet internet = (Internet) databaseController.getNodeById("Internet");
        graphEntityList.add(this.createGraphNode(internet));
        Gateway gateway = databaseController.createGateway("gw1");
        graphEntityList.add(this.createGraphNode(gateway));
        databaseController.createNodeConnection(gateway.getId(), internet.getId());
        graphEntityList.add(this.createGraphEdge(gateway.getId(), internet.getId()));

        databaseController.createNodeConnection(gateway.getId(), "r1");
        databaseController.createNodeConnection(gateway.getId(), "r2");
        databaseController.createNodeConnection(gateway.getId(), "r3");
        databaseController.createNodeConnection(gateway.getId(), "r4");
        graphEntityList.add(this.createGraphEdge(gateway.getId(), "r1"));
        graphEntityList.add(this.createGraphEdge(gateway.getId(), "r2"));
        graphEntityList.add(this.createGraphEdge(gateway.getId(), "r3"));
        graphEntityList.add(this.createGraphEdge(gateway.getId(), "r4"));

        return graphEntityList;
    }

    private GraphNode createGraphNode(AbstractNode node) {

        return this.createGraphNode(node.getId(), node.getNodeType());

    }

    private GraphNode createGraphNode(String id, NodeType type) {

        GraphNode graphEntity = new GraphNode();
        graphEntity.setId(id);
        graphEntity.setType(type);
        graphEntity.setGroup(Group.NODES);

        return graphEntity;

    }


    private GraphEdge createGraphEdge(String sourceId, String targetId) {

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


    private GraphNode createApplication(IntentMessage intentMessage){

        String name = intentMessage.getParamValue("name");
        String port = intentMessage.getParamValue("port");
        Application application = databaseController.createApplication(name, Short.valueOf(port));

        return this.createGraphNode(application);

    }
}
