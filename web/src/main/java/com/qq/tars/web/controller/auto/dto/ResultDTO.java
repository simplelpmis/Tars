package com.qq.tars.web.controller.auto.dto;


/**
 * @Date 2018/5/23      @Author Simba
 * @Description:
 */
public class ResultDTO<T> {
    private int resultCode = 0;
    private String errMsg = "";
    private T data;

    public ResultDTO() {
    }

    public ResultDTO(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultDTO{");
        sb.append("resultCode=").append(resultCode);
        sb.append(", errMsg='").append(errMsg).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    public boolean isSuccess() {
        return resultCode == 0;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
