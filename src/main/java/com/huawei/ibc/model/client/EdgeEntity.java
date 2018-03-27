package com.huawei.ibc.model.client;

public class EdgeEntity extends GraphEntity {

    public EdgeEntity() {
        super();
        super.setGroup(Group.EDGES);
    }

    public void setSource(String sourceId){
        super.addToData("source", sourceId);
    }

    public void setTraget(String targetId){
        super.addToData("target", targetId);
    }
}
