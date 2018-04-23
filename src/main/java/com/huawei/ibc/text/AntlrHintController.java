package com.huawei.ibc.text;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.message.IntentStatus;
import com.huawei.ibc.model.controller.GraphController;
import com.huawei.ibc.service.WebSockServiceImpl;
import com.huawei.ibc.text.antlr.IntentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AntlrHintController implements HintController{

    @Autowired
    private WebSockServiceImpl webSockService;

    @Autowired
    private GraphController graphController;

    @Override
    public IntentMessage getHint(IntentMessage intentMessage) {

        if (intentMessage.getStatus() == IntentStatus.ENTERED) {
            return this.validateCompleteIntent(intentMessage);
        } else if (intentMessage.getStatus() == IntentStatus.HINT) {
            return null;
        } else if (intentMessage.getStatus() == IntentStatus.INFO) {
            return this.handleInfo(intentMessage);
        }

        throw new RuntimeException("not supported!");
    }

    private IntentMessage validateCompleteIntent(IntentMessage intentMessage) {

        new IntentBuilder(webSockService, graphController, intentMessage);

        return null;
    }

    private IntentMessage handleHint(IntentMessage intentMessage) {

        return null;
    }

    private IntentMessage handleInfo(IntentMessage intentMessage) {


        return null;
    }


}
