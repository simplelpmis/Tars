package com.qq.tars.web.controller.auto.dto;


/**
 * @Date 2018/5/23      @Author Simba
 * @Description:
 */
public class AutoPatchReq {
    private String application;
    private String moduleName;
    private String patchName;
    private String comment;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AutoPatchReq{");
        sb.append("application='").append(application).append('\'');
        sb.append(", moduleName='").append(moduleName).append('\'');
        sb.append(", patchName='").append(patchName).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getPatchName() {
        return patchName;
    }

    public void setPatchName(String patchName) {
        this.patchName = patchName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
