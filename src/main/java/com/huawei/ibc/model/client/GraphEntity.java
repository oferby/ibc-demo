package com.huawei.ibc.model.client;

import java.util.HashMap;
import java.util.Map;

public class GraphEntity {

    private String group;
    private String classes;
    private Map<String, String> data = new HashMap<>();

    public String getGroup() {
        return group;
    }

    public String getClasses() {
        return classes;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setId(String id) {
        data.put("id", id);
    }

    void addToData(String key, String value) {
        data.put(key, value);
    }

    void setClasses(String classes) {
        this.classes = classes;
    }

    public void setGroup(Group group) {
        this.group = group.toString();
    }

}
