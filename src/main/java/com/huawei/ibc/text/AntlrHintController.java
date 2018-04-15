package com.huawei.ibc.text;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.service.WebSockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class AntlrHintController implements HintController{

    @Autowired
    private WebSockServiceImpl webSockService;


    @Override
    public IntentMessage getHint(IntentMessage intentMessage) {



//        ZtnListenerImpl listener = new ZtnListenerImpl();
//        ParseTreeWalker walker = new ParseTreeWalker();
//        walker.walk(listener, znContext);


        return null;
    }
}
