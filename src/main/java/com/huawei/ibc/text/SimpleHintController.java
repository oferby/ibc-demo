package com.huawei.ibc.text;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.message.IntentStatus;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class SimpleHintController implements HintController {

    private Set<String> commandSet;
    private Map<Pattern, String> patternMap = new HashMap<>();

    public SimpleHintController() {

        commandSet = new TreeSet<>();
        commandSet.add("build demo 1");
        commandSet.add("add demo 1");
        commandSet.add("create demo 1");
        commandSet.add("start demo 1");
        commandSet.add("add demo 2");
        commandSet.add("build demo 2");
        commandSet.add("create demo 2");
        commandSet.add("start demo 2");

        commandSet.add("add vm");
        commandSet.add("create vm");

        commandSet.add("add switch");
        commandSet.add("create switch");

        commandSet.add("add router");
        commandSet.add("create router");

        commandSet.add("add firewall");
        commandSet.add("create firewall");

        commandSet.add("add service");
        commandSet.add("create service");
        commandSet.add("show service");
        commandSet.add("display service");
        commandSet.add("show all services");

        commandSet.add("add policy");
        commandSet.add("create policy");
        commandSet.add("set policy");
        commandSet.add("show policy");
        commandSet.add("show all policies");
        commandSet.add("display policy");

        commandSet.add("add application");
        commandSet.add("create application");

        commandSet.add("connect");
        commandSet.add("disconnect");

        commandSet.add("clear");
        commandSet.add("delete all");

        commandSet.add("show all");

        patternMap.put(Pattern.compile("(build|create|start|add)\\s+demo\\s+1\\s*"), "buildDemo1");
        patternMap.put(Pattern.compile("(build|create|start|add)\\s+demo\\s+2\\s*"), "buildDemo2");

        patternMap.put(Pattern.compile("(add|create)\\s+vm.+"), "addVm");
        patternMap.put(Pattern.compile("(add|create)\\s+switch.+"), "addSwitch");
        patternMap.put(Pattern.compile("(add|create)\\s+router.+"), "addRouter");
        patternMap.put(Pattern.compile("(add|create)\\s+firewall.+"), "addFirewall");
        patternMap.put(Pattern.compile("(add|create)\\s+service.+"), "addService");
        patternMap.put(Pattern.compile("(add|create)\\s+application.+"), "addApplication");
        patternMap.put(Pattern.compile("(add|create)\\s+policy.+"), "addPolicy");

        patternMap.put(Pattern.compile("(show|display)\\s+(all\\s+)?services\\s*"), "showService");
        patternMap.put(Pattern.compile("(show|display)\\s+(all\\s+)?(policies|policy)\\s*"), "showPolicies");
        patternMap.put(Pattern.compile("show\\s+all\\s*"), "showAll");

        patternMap.put(Pattern.compile("set\\s+policy.+"), "setPolicy");

        patternMap.put(Pattern.compile("clear\\s*"), "clear");
        patternMap.put(Pattern.compile("delete\\s+all\\s*"), "deleteAll");

        patternMap.put(Pattern.compile("connect.+"), "connect");
        patternMap.put(Pattern.compile("disconnect.+"), "disconnect");

    }

    public IntentMessage getHint(IntentMessage intentMessage) {

        if (intentMessage.getStatus() == IntentStatus.ENTERED) {
            return this.validateCompleteIntent(intentMessage);
        } else if (intentMessage.getStatus() == IntentStatus.HINT) {
            return this.buildHint(intentMessage);
        }

        throw new RuntimeException("not supported!");
    }

    private IntentMessage buildHint(IntentMessage intentMessage) {

        String hint = intentMessage.getHint();
        int numOfWords = hint.split(" ").length;


        for (String command : commandSet) {

            if (command.startsWith(hint)) {

                String[] commandWords = command.split(" ");
                int numOfWordsInCommand = commandWords.length;
                if (numOfWords == numOfWordsInCommand) {
                    intentMessage.setHint(command);
                } else {

                    StringBuilder newHint = new StringBuilder();
                    for (int i = 0; i < numOfWords; i++) {
                        newHint.append(commandWords[i]);
                        newHint.append(" ");
                    }

                    intentMessage.setHint(newHint.toString().trim());

                }

                return intentMessage;
            }
        }

        return intentMessage;
    }


    private IntentMessage validateCompleteIntent(IntentMessage intentMessage) {

        String command = intentMessage.getHint().trim();

        String intent = null;
        for (Pattern p : patternMap.keySet()) {
            Matcher m = p.matcher(command);
            if (m.matches()) {
                intent = patternMap.get(p);
                break;
            }

        }

        if (intent == null) {
            return intentMessage;
        }

        switch (intent) {
            case "buildDemo1":
            return this.buildDemo2(intentMessage, "buildDemo1");
            case "buildDemo2":
                return this.buildDemo2(intentMessage, "buildDemo2");
            case "clear":
                intentMessage.setStatus(IntentStatus.LOCAL);
                intentMessage.setIntent("clear");
                break;
            case "connect":
                return this.createNodeConnectionIntent(intentMessage);
            case "disconnect":
                return this.removeNodeConnectionIntent(intentMessage);
            case "deleteAll":
                return this.getCreateNodeIntent(intentMessage, "deleteAll");
            case "addVm":
                return this.getCreateNodeIntent(intentMessage, "addVm");
            case "addRouter":
                return this.getCreateNodeIntent(intentMessage, "addRouter");
            case "addSwitch":
                return this.getCreateNodeIntent(intentMessage, "addSwitch");
            case "addFirewall":
                return this.getCreateNodeIntent(intentMessage, "addFirewall");
            case "addService":
                return this.getCreateNodeIntent(intentMessage, "addService");
            case "addPolicy":
                return this.getCreateNodeIntent(intentMessage, "addPolicy");
            case "showAll":
                return this.getShowAllIntent(intentMessage, "showAll");
            case "showPolicies":
                return this.getShowAllIntent(intentMessage, "showPolicies");
            case "showService":
                return this.getShowAllIntent(intentMessage, "showService");
            case "setPolicy":
                return this.getSetPolicyIntent(intentMessage);
            case "addApplication":
                return this.createApplication(intentMessage);



        }

        return intentMessage;
    }

    private IntentMessage getShowAllIntent(IntentMessage intentMessage, String intent) {
        intentMessage.setStatus(IntentStatus.DONE);
        intentMessage.setIntent(intent);
        return intentMessage;
    }

    private IntentMessage removeNodeConnectionIntent(IntentMessage intentMessage) {

        String command = intentMessage.getHint();
        String[] strings = command.split(" ");

        List<String> list = new ArrayList<String>(Arrays.asList(strings));
        list.removeAll(Collections.singletonList(""));
        strings = list.toArray(strings);

        if (strings.length == 3) {
            intentMessage.addParam("target", strings[2]);
        } else if (strings.length == 4) {
            intentMessage.addParam("target", strings[3]);
        } else {
            throw new RuntimeException("invalid number of parameters");
        }

        intentMessage.setIntent("disconnectNodes");
        intentMessage.addParam("source", strings[1]);
        intentMessage.setStatus(IntentStatus.DONE);

        return intentMessage;

    }


    private IntentMessage createNodeConnectionIntent(IntentMessage intentMessage) {

        String command = intentMessage.getHint();
        String[] strings = command.split(" ");

        List<String> list = new ArrayList<String>(Arrays.asList(strings));
        list.removeAll(Collections.singletonList(""));
        strings = list.toArray(strings);

        if (strings.length == 3) {
            intentMessage.addParam("target", strings[2]);
        } else if (strings.length == 4) {
            intentMessage.addParam("target", strings[3]);
        } else {
            throw new RuntimeException("invalid number of parameters");
        }

        intentMessage.setIntent("connectNodes");
        intentMessage.addParam("source", strings[1]);
        intentMessage.setStatus(IntentStatus.DONE);

        return intentMessage;

    }


    private IntentMessage getCreateNodeIntent(IntentMessage intentMessage, String intent) {
        String command = intentMessage.getHint();
        intentMessage.setStatus(IntentStatus.DONE);
        intentMessage.setIntent(intent);
        String nodeName = this.getNodeName(command);
        if (nodeName != null) {
            intentMessage.addParam("name", nodeName);
        }
        return intentMessage;

    }

    private IntentMessage getSetPolicyIntent(IntentMessage intentMessage){

        String command = intentMessage.getHint();
        Pattern p = Pattern.compile("set\\s+policy\\s+([a-z0-9]+)\\s+(allow|deny).*?(from|to)\\s+([a-z0-9]+).*?(from|to)\\s+([a-z0-9]+)");
        Matcher m = p.matcher(command);

        if (!m.find() ) {
            throw new RuntimeException("could not find parameters in command");
        }

        int groupCount = m.groupCount();

        if (groupCount < 6)
            throw new RuntimeException("invalid number of parameters");

        String policyName = m.group(1);
        intentMessage.addParam("name", policyName);

        String grant1 = m.group(2);
        intentMessage.addParam("operation", grant1);

        String toFrom = m.group(3);
        String node1 = m.group(4);
        intentMessage.addParam(toFrom, node1);


        String toFrom2 = m.group(5);
        String node2 = m.group(6);
        intentMessage.addParam(toFrom2, node2);

        intentMessage.setIntent("setPolicy");
        intentMessage.setStatus(IntentStatus.DONE);
        return intentMessage;
    }

    private IntentMessage createApplication(IntentMessage intentMessage){

        Pattern p = Pattern.compile("(add|create)\\s+application\\s+([a-z0-9]+).*port\\s+([0-9]+)");
        Matcher m = p.matcher(intentMessage.getHint());

        boolean found = m.find();
        if (!found)
            throw new RuntimeException("invalid parameter for create application");

        intentMessage.addParam("name", m.group(2));
        intentMessage.addParam("port", m.group(3));

        p = Pattern.compile(".*(host|vm)\\s+([a-z0-9]+).*");
        m = p.matcher(intentMessage.getHint());
        found = m.find();
        if (found) {
            intentMessage.addParam("host", m.group(2));
        }

        intentMessage.setIntent("addApplication");
        intentMessage.setStatus(IntentStatus.DONE);
        return intentMessage;
    }

    private String getNodeName(String command) {
        String[] strings = command.split(" ");

        List<String> list = new ArrayList<String>(Arrays.asList(strings));
        list.removeAll(Collections.singletonList(""));
        strings = list.toArray(strings);

        if (strings.length == 2) {
            return null;
        }

        return strings[2];
    }

    private IntentMessage buildDemo2(IntentMessage intentMessage, String demoIntent) {
        intentMessage.setIntent(demoIntent);
        intentMessage.setStatus(IntentStatus.DONE);
        return intentMessage;
    }

}
