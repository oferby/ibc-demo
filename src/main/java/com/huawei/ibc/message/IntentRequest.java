package com.huawei.ibc.message;

public class IntentRequest {

    private String text;
    private IntentStatus status;

    public IntentRequest() {
    }

    public IntentRequest(String text) {
        this.text = text;
    }

    public IntentRequest(String text, IntentStatus status) {
        this.text = text;
        this.status = status;
    }

    public IntentStatus getStatus() {
        return status;
    }

    public void setStatus(IntentStatus status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
