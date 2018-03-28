package com.huawei.ibc.text;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.message.IntentStatus;
import javafx.collections.transformation.SortedList;
import org.springframework.stereotype.Controller;

import java.util.Set;
import java.util.TreeSet;

@Controller
public class SimpleHintController implements HintController {

    private Set<String> commandSet;

    public SimpleHintController() {

        commandSet = new TreeSet<>();
        commandSet.add("build demo");
        commandSet.add("clear");
        commandSet.add("add vm");
        commandSet.add("add switch");
        commandSet.add("add router");
        commandSet.add("add firewall");

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

        String command = intentMessage.getHint();
        if (command.equals("build demo")) {
            intentMessage.setStatus(IntentStatus.DONE);
            intentMessage.setIntent("buildDemo");
            return intentMessage;

        } else if (command.equals("clear")) {
            intentMessage.setStatus(IntentStatus.LOCAL);
            intentMessage.setIntent("clear");
            return intentMessage;

        } else if (command.startsWith("add vm")) {
            return this.getCreateNodeIntent(intentMessage, "addVm");

        } else if (command.startsWith("add router")) {
            return this.getCreateNodeIntent(intentMessage, "addRouter");
        } else if (command.startsWith("add switch")) {
            return this.getCreateNodeIntent(intentMessage, "addSwitch");
        } else if (command.startsWith("add firewall")) {
            return this.getCreateNodeIntent(intentMessage, "addFirewall");
        }

        return intentMessage;
    }

    private IntentMessage getCreateNodeIntent(IntentMessage intentMessage, String intent){
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
        if (strings.length == 2) {
            return null;
        }

        return strings[2];
    }

}
