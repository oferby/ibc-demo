package com.huawei.ibc.message;

public class IntentRequest {

    private String text;

    public IntentRequest() {
    }

    public IntentRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
