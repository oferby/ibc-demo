package com.huawei.ibc.web;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.model.GraphController;
import com.huawei.ibc.model.client.GraphEntity;
import com.huawei.ibc.text.HintController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class IntentWebController {

    @Autowired
    private HintController hintController;

    @Autowired
    private GraphController graphController;

    @MessageMapping("/getHint")
    @SendTo("/topic/hint")
    public IntentMessage getHint(IntentMessage intentRequest){

        return hintController.getHint(intentRequest);
    }



    @MessageMapping("/intent")
    @SendTo("/topic/graph")
    public List<GraphEntity> getIntent(IntentMessage intentMessage){

        return graphController.getGraphEntity(intentMessage);

    }

}
