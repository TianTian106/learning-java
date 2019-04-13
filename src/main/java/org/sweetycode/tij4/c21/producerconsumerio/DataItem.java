package org.sweetycode.tij4.c21.producerconsumerio;

/**
 * Created by tiantian on 2019/4/12.
 */
public class DataItem {
    private String id;
    private String groupId;
    private Float quota;

    public DataItem(String id, String groupId, Float quota) {
        this.id = id;
        this.groupId = groupId;
        this.quota = quota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Float getQuota() {
        return quota;
    }

    public void setQuota(Float quota) {
        this.quota = quota;
    }
}
