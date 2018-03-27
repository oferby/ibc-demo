package com.huawei.ibc.text;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.message.IntentRequest;
import com.huawei.ibc.message.IntentStatus;
import org.springframework.stereotype.Controller;

@Controller
public class HintController {

    public IntentMessage getHint(IntentMessage intentRequest) {

        intentRequest.addParam("key1", "val1");
        return intentRequest;
    }


}
