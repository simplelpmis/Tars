package com.qq.tars.web.controller.auto.dto;


/**
 * @Date 2018/5/22      @Author Simba
 * @Description: 添加发布任务
 */
public class AddDeployTaskReq {
    private long serverId;
    private long patchId;
    private String comment;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddDeployTaskReq{");
        sb.append("serverId=").append(serverId);
        sb.append(", patchId=").append(patchId);
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public long getServerId() {
        return serverId;
    }

    public void setServerId(long serverId) {
        this.serverId = serverId;
    }

    public long getPatchId() {
        return patchId;
    }

    public void setPatchId(long patchId) {
        this.patchId = patchId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
