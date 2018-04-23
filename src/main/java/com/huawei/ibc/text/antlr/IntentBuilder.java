package com.huawei.ibc.text.antlr;

import com.huawei.ibc.message.IntentMessage;
import com.huawei.ibc.message.IntentStatus;
import com.huawei.ibc.model.client.GraphEntity;
import com.huawei.ibc.model.controller.GraphController;
import com.huawei.ibc.service.WebSockServiceImpl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;
import java.util.Map;

public class IntentBuilder {

    private WebSockServiceImpl sockService;
    private GraphController graphController;

    private Map<String, String> values;
    private IntentMessage intentMessage;

    public IntentBuilder(WebSockServiceImpl sockService, GraphController graphController, IntentMessage intentMessage) {
        this.sockService = sockService;
        this.graphController = graphController;
        this.intentMessage = intentMessage;

        this.processHint();

    }

    private void processHint() {

        CharStream stream = CharStreams.fromString(intentMessage.getHint());
        com.huawei.ibc.antlr4.ZtnLexer lexer = new com.huawei.ibc.antlr4.ZtnLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        com.huawei.ibc.antlr4.ZtnParser parser = new com.huawei.ibc.antlr4.ZtnParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ZtnErrorListener());

        com.huawei.ibc.antlr4.ZtnParser.ZnContext znContext = parser.zn();

        this.values = znContext.values;

        switch (this.values.get("operator")) {
            case "show":
                this.showIntent();
                break;
            case "create":
                this.createIntent();
                break;
            case "delete":
                this.deleteIntent();
                break;
            case "findPath":
                this.findPathIntent();
                break;
            case "connect":
                this.connectIntent();
                break;
            case "disconnect":
                this.disconnectIntent();
                break;
            case "allow":
                this.allowIntent();
                break;
            case "deny":
                this.denyIntent();
                break;
            case "demo":
                this.demoIntent();
                break;
            case "clear":
                sockService.sendClearLocalIntent();
                break;

            default:
                throw new RuntimeException("unknown operator");

        }

    }

    private void sendIntent(IntentMessage intentMessage) {

        if (this.sockService != null)
            this.sockService.sendIntent(intentMessage);

    }

    private void showIntent() {

    }

    private void createIntent() {

    }

    private void deleteIntent() {

    }

    private void findPathIntent() {

    }

    private void connectIntent() {


    }

    private void disconnectIntent() {

    }

    private void allowIntent() {

    }

    private void denyIntent() {

    }

    private void demoIntent() {

        String num = this.values.get("num");

        switch (num) {
            case "1":
                intentMessage.setIntent("buildDemo1");
                break;
            case "2":
                intentMessage.setIntent("buildDemo2");
                break;
            default:
                throw new RuntimeException("not supported");
        }

        intentMessage.setStatus(IntentStatus.DONE);
        sockService.sendClearLocalIntent();
        List<GraphEntity> graphEntities = graphController.getGraphEntity(intentMessage);
        sockService.sendGraphEntities(graphEntities);
    }

    private void addVm() {

    }


}
