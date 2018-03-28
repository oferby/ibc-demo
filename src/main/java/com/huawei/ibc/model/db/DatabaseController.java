package com.huawei.ibc.model.db;

import com.huawei.ibc.model.db.node.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DatabaseController {

    private Map<String, AbstractDevice> nodeMap = new HashMap<>();

    public DatabaseController() {
        String name = "Internet";
        Internet internet = new Internet(name);
        nodeMap.put(name, internet);
    }

    public VirtualMachine createVirtualMachine(String name){

        VirtualMachine vm = new VirtualMachine(name);
        nodeMap.put(name, vm);

        return vm;

    }

    public Router createRouter(String name){
        Router router = new Router(name);
        nodeMap.put(name,router);

        return router;
    }

    public Switch createSwitch(String name){
        Switch aSwitch = new Switch(name);
        nodeMap.put(name, aSwitch);

        return aSwitch;
    }

    public Firewall createFirewall(String name){

        Firewall firewall = new Firewall(name);
        nodeMap.put(name, firewall);

        return firewall;

    }


}
