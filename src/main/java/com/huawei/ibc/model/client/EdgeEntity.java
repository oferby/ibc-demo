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

    public String getSource(){
        return super.getDataEntry("source");
    }

    public String getTarget(){
        return super.getDataEntry("target");
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof EdgeEntity)){
            return false;
        }

        return super.getDataEntry("source").equals(((EdgeEntity) obj).getDataEntry("source")) &&
                super.getDataEntry("target").equals(((EdgeEntity) obj).getDataEntry("target"));

    }

    @Override
    public int hashCode() {
        return this.getSource().hashCode() * 31 + this.getTarget().hashCode();
    }
}
