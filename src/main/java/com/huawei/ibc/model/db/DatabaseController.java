package com.huawei.ibc.model.db;

import com.huawei.ibc.model.common.GroupType;
import com.huawei.ibc.model.db.node.*;
import com.huawei.ibc.service.AddressController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class DatabaseController {

    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Group> groupMap = new HashMap<>();
    private Map<String, AbstractNode> nodeMap = new HashMap<>();

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

    private void validateUniqueName(String name) {
        if (nodeMap.containsKey(name))
            throw new RuntimeException("name already exists");
    }

    public VirtualMachine createVirtualMachine(String name) {

        this.validateUniqueName(name);
        VirtualMachine vm = new VirtualMachine(name);
        nodeMap.put(name, vm);

        return vm;

    }

    public Router createRouter(String name) {

        this.validateUniqueName(name);
        Router router = new Router(name);
        nodeMap.put(name, router);

        return router;
    }

    public Switch createSwitch(String name) {

        this.validateUniqueName(name);
        Switch aSwitch = new Switch(name);
        nodeMap.put(name, aSwitch);
        return aSwitch;
    }

    public Firewall createFirewall(String name) {
        this.validateUniqueName(name);
        Firewall firewall = new Firewall(name);
        nodeMap.put(name, firewall);
        return firewall;

    }

    public Gateway createGateway(String name) {
        this.validateUniqueName(name);
        Gateway gateway = new Gateway(name);
        nodeMap.put(name, gateway);
        return gateway;
    }

    public Application createApplication(String name, Short listerOnPort) {
        Application application = new Application(name);
        application.setListenOnPort(listerOnPort);
        nodeMap.put(name, application);
        return application;
    }


    public boolean createNodeConnection(String sourceId, String targetId) {

        AbstractDevice sourceDevice = (AbstractDevice) nodeMap.get(sourceId);
        if (sourceDevice == null)
            return false;

        AbstractDevice targetDevice = (AbstractDevice) nodeMap.get(targetId);
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

        AbstractDevice sourceDevice = (AbstractDevice) nodeMap.get(sourceId);
        if (sourceDevice == null)
            throw new RuntimeException("source id not found");

        AbstractDevice targetDevice = (AbstractDevice) nodeMap.get(targetId);
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

        Collection<AbstractDevice> devices = new ArrayList<>();
        Collection<AbstractNode> nodes = nodeMap.values();
        nodes.removeIf(node -> !(node instanceof AbstractDevice));
        for (AbstractNode node : nodes) {
            devices.add((AbstractDevice) node);
        }

        return devices;
    }

    public void createGroup(String groupId, GroupType groupType) {

        this.validateUniqueName(groupId);
        groupMap.put(groupId, new Group(groupId, groupType));
    }

    public Group getGroup(String id) {
        return groupMap.get(id);
    }

    public void deleteGroup(String id) {
        groupMap.remove(id);
    }

    public void addNodesToGroup(String groupId, Set<AbstractNode> nodeSet) {

        Group group = groupMap.get(groupId);
        Set<AbstractNode> nodes = group.getNodeSet();
        if (nodes == null) {
            nodes = new HashSet<>();
        }
        nodes.addAll(nodeSet);
        group.setNodeSet(nodeSet);

    }

    public Set<AbstractNode> getGroupNodes(String groupId) {
        return groupMap.get(groupId).getNodeSet();
    }

    public Policy createPolicy(String policyName) {
        Policy policy = new Policy(policyName);
        policyMap.put(policyName, policy);
        return policy;
    }

    public Policy getPolicy(String name) {
        return policyMap.get(name);
    }

    public Collection<Policy> getAllPolicies() {
        return this.policyMap.values();
    }

    public void deleteTargetPolicy(String targetId) {
        policyMap.remove(targetId);
    }


}
