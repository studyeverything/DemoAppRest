package com.nguyentthai.modelcommon.response;

public class BaseResponse {
    public static final String OK = "OK";
    public static final String FAILED = "FAILED";
    public static final String NOT_REGISTER = "NOT_REGISTER";
    public static final String UNKNOWN = "UNKNOWN";

    private String resultCode = "";
    private String errorMessage = "";
    private String errorSystem = "";

    //Getter and Setter
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorSystem() {
        return errorSystem;
    }

    public void setErrorSystem(String errorSystem) {
        this.errorSystem = errorSystem;
    }
    //\Getter and Setter
}
