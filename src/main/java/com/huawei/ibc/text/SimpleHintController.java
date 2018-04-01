package com.huawei.ibc.text;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.message.IntentStatus;
import javafx.collections.transformation.SortedList;
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
        commandSet.add("build demo");
        commandSet.add("clear");
        commandSet.add("add vm");
        commandSet.add("create vm");
        commandSet.add("add switch");
        commandSet.add("create switch");
        commandSet.add("add router");
        commandSet.add("create router");
        commandSet.add("add firewall");
        commandSet.add("create firewall");
        commandSet.add("connect");
        commandSet.add("disconnect");
        commandSet.add("delete all");
        commandSet.add("show all");

        patternMap.put(Pattern.compile("add\\s+vm.+"), "addVm");
        patternMap.put(Pattern.compile("create\\s+vm.+"), "addVm");
        patternMap.put(Pattern.compile("add\\s+switch.+"), "addSwitch");
        patternMap.put(Pattern.compile("create\\s+switch.+"), "addSwitch");
        patternMap.put(Pattern.compile("add\\s+router.+"), "addRouter");
        patternMap.put(Pattern.compile("create\\s+router.+"), "addRouter");
        patternMap.put(Pattern.compile("add\\s+firewall.+"), "addFirewall");
        patternMap.put(Pattern.compile("create\\s+firewall.+"), "addFirewall");
        patternMap.put(Pattern.compile("build\\s+demo\\s*"), "buildDemo");
        patternMap.put(Pattern.compile("clear\\s*"), "clear");
        patternMap.put(Pattern.compile("delete\\s+all\\s*"), "deleteAll");
        patternMap.put(Pattern.compile("connect.+"), "connect");
        patternMap.put(Pattern.compile("disconnect.+"), "disconnect");
        patternMap.put(Pattern.compile("show\\s+all\\s*"), "showAll");

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
            case "buildDemo":
                intentMessage.setStatus(IntentStatus.DONE);
                intentMessage.setIntent("buildDemo");
                break;
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
            case "showAll":
                intentMessage.setStatus(IntentStatus.DONE);
                intentMessage.setIntent("showAll");
                break;
        }

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

}
