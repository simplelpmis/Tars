package com.qq.tars.web.controller.auto.dto;


/**
 * @Date 2018/5/22      @Author Simba
 * @Description: 添加发布任务
 */
public class AddDeployTaskReq {
    private int serverId;
    private int patchId;
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

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public int getPatchId() {
        return patchId;
    }

    public void setPatchId(int patchId) {
        this.patchId = patchId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
