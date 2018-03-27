package com.huawei.ibc.web;

import com.huawei.ibc.IntentResponse;
import com.huawei.ibc.message.IntentRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class IntentWebController {


    @MessageMapping("/intent")
    @SendTo("/topic/hint")
    public IntentResponse getIntent(IntentRequest intentRequest){

        return new IntentResponse(intentRequest.getText() + ": try this");
    }


}
