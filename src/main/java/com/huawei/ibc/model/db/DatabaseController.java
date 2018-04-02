package com.huawei.ibc.model.db;

import com.huawei.ibc.model.common.GroupType;
import com.huawei.ibc.model.db.node.*;
import com.huawei.ibc.service.AddressController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class DatabaseController {

    private long lastId = 0;

    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, AbstractNode> groupMap = new HashMap<>();
    private Map<String, AbstractDevice> nodeMap = new HashMap<>();

    @Autowired
    private AddressController addressController;

    public DatabaseController() {
        this.addInternalNodes();
    }

    public void deleteAll() {
        nodeMap.clear();
        groupMap.clear();
        policyMap.clear();
        this.addInternalNodes();
    }

    public AbstractNode getNodeById(String id) {
        return nodeMap.get(id);
    }

    private void addInternalNodes() {

        String name = "Internet";
        Internet internet = new Internet(name);
        nodeMap.put(name, internet);

        name = "All";
        Group all = new Group(name, GroupType.GENERAL);
        groupMap.put(name, all);
    }

    public VirtualMachine createVirtualMachine(String name) {

        VirtualMachine vm = new VirtualMachine(name);
        nodeMap.put(name, vm);

        return vm;

    }

    public Router createRouter(String name) {
        Router router = new Router(name);
        nodeMap.put(name, router);

        return router;
    }

    public Switch createSwitch(String name) {
        Switch aSwitch = new Switch(name);
        nodeMap.put(name, aSwitch);

        return aSwitch;
    }

    public Firewall createFirewall(String name) {

        Firewall firewall = new Firewall(name);
        nodeMap.put(name, firewall);

        return firewall;

    }

    public Gateway createGateway(String name){
        Gateway gateway = new Gateway(name);
        nodeMap.put(name, gateway);
        return gateway;
    }



    public boolean createNodeConnection(String sourceId, String targetId) {

        AbstractDevice sourceDevice = nodeMap.get(sourceId);
        if (sourceDevice == null)
            return false;

        AbstractDevice targetDevice = nodeMap.get(targetId);
        if (targetDevice == null) {
            return false;
        }

        ForwardingPort port1 = sourceDevice.addPort(addressController.getMacAddress());
        ForwardingPort port2 = targetDevice.addPort(addressController.getMacAddress());

        port1.setConnectedPort(port2);
        port2.setConnectedPort(port1);

        return true;

    }

    public void deleteNodeConnection(String sourceId, String targetId) {

        AbstractDevice sourceDevice = nodeMap.get(sourceId);
        if (sourceDevice == null)
            throw new RuntimeException("source id not found");

        AbstractDevice targetDevice = nodeMap.get(targetId);
        if (targetDevice == null) {
            throw new RuntimeException("target id not found");
        }

        for (ForwardingPort port : sourceDevice.getPortList()) {
            if (port.getConnectedPort().getPortDevice().getId().equals(targetId)) {
                sourceDevice.deletePort(port);
                targetDevice.deletePort(port.getConnectedPort());
                break;
            }
        }

    }

    public Collection<AbstractDevice> getAllDevices() {
        return nodeMap.values();
    }

    public void createGroup(String groupId, GroupType groupType) {
        groupMap.put(groupId, new Group(groupId, groupType));
    }

    public void createGroup(Group group) {
        this.groupMap.put(group.getId(), group);
    }

    public Group getGroup(String id) {
        return (Group) groupMap.get(id);
    }

    public void deleteGroup(String id) {
        groupMap.remove(id);
    }

    public void addNodesToGroup(String groupId, Set<AbstractNode> nodeSet) {

        Group group = (Group) groupMap.get(groupId);
        Set<AbstractNode> nodes = group.getNodeSet();
        if (nodes == null) {
            nodes = new HashSet<>();
        }
        nodes.addAll(nodeSet);
        group.setNodeSet(nodeSet);

    }

    public Set<AbstractNode> getGroupNodes(String groupId) {
        return ((Group) groupMap.get(groupId)).getNodeSet();
    }

    public Policy createPolicy(String policyName) {
        Policy policy = new Policy(policyName);
        policyMap.put(policyName, policy);
        return policy;
    }

    public Policy getPolicy(String name) {
        return policyMap.get(name);
    }

    public Collection<Policy> getAllPolicies(){
        return this.policyMap.values();
    }

    public void deleteTargetPolicy(String targetId) {
        policyMap.remove(targetId);
    }



}
