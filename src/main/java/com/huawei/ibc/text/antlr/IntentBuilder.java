package com.huawei.ibc.text.antlr;

import com.huawei.ibc.service.WebSockServiceImpl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.Map;

public class IntentBuilder {

    private WebSockServiceImpl sockService;
    private Map<String, String> values;
    private String hint;

    public IntentBuilder(String hint, WebSockServiceImpl webSockService) {

        this.sockService = webSockService;
        this.hint = hint;

        try {

            this.processHint();


        } catch (ParseException ps) {

        }


    }


    private void processHint() {

        CharStream stream = CharStreams.fromString(hint);
        com.huawei.ibc.antlr4.ZtnLexer lexer = new com.huawei.ibc.antlr4.ZtnLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        com.huawei.ibc.antlr4.ZtnParser parser = new com.huawei.ibc.antlr4.ZtnParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ZtnErrorListener());


        com.huawei.ibc.antlr4.ZtnParser.ZnContext znContext = parser.zn();

        this.values = znContext.values;
    }


}
