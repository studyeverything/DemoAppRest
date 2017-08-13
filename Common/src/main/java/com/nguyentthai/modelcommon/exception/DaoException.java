package com.nguyentthai.modelcommon.exception;

public class DaoException extends Exception implements MyException{

    private String resultCode = "";
    private String errorMessage = "";
    private String errorSystem = "";

    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
        this.errorMessage=message;
        this.resultCode=MyException.FAILED;
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage=message;
        this.resultCode=MyException.FAILED;
    }

    //Getter and Setter

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
       this.resultCode=resultCode;
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

    // \Getter and Setter
}