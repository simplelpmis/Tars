package com.qq.tars.web.controller.auto.dto;


/**
 * @Date 2018/5/23      @Author Simba
 * @Description:
 */
public class PushConfigReq {
    private String application;
    private String moduleName;
    private String fileName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PushConfigReq{");
        sb.append("application='").append(application).append('\'');
        sb.append(", moduleName='").append(moduleName).append('\'');
        sb.append(", fileName='").append(fileName).append('\'');
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
