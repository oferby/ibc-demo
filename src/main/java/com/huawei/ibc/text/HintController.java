package com.huawei.ibc.text;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.message.IntentStatus;
import javafx.collections.transformation.SortedList;
import org.springframework.stereotype.Controller;

import java.util.Set;
import java.util.TreeSet;

@Controller
public class HintController {

    private Set<String> commandSet;

    public HintController() {

         commandSet = new TreeSet<>();
         commandSet.add("build demo");
         commandSet.add("clear");

    }

    public IntentMessage getHint(IntentMessage intentMessage) {

        if (intentMessage.getStatus() == IntentStatus.ENTERED){
            return this.validateCompleteIntent(intentMessage);
        } else if (intentMessage.getStatus() == IntentStatus.HINT) {
            return this.buildHint(intentMessage);
        }

        throw new RuntimeException("not supported!");
    }

    private IntentMessage buildHint(IntentMessage intentMessage){

        for (String command : commandSet) {

            if (command.startsWith(intentMessage.getHint())) {
                intentMessage.setHint(command);
                return intentMessage;
            }
        }

        return intentMessage;
    }


    private IntentMessage validateCompleteIntent(IntentMessage intentMessage){

        if (intentMessage.getHint().equals("build demo")){
            intentMessage.setStatus(IntentStatus.DONE);
            return buildIntent(intentMessage);
        } else if (intentMessage.getHint().equals("clear")){
            intentMessage.setStatus(IntentStatus.LOCAL);
            intentMessage.setIntent("clear");
            return intentMessage;
        }

        return intentMessage;
    }

    private IntentMessage buildIntent(IntentMessage intentMessage){

        intentMessage.setIntent("buildDemo");
        return intentMessage;
    }


}
