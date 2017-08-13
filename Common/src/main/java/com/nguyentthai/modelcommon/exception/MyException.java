package com.nguyentthai.modelcommon.exception;

public interface MyException {
    String insertDuplicateKey = "Insert duplicate key primary.";
    String insertResualtFailed = "Insert failed.";
    String insertNotFoundForeign = "Insert cannot found foreign key.";
    String errorUnknow = "Error Unkown.";

    String OK = "OK";
    String FAILED = "FAILED";
    String NOT_REGISTER = "NOT_REGISTER";
    String UNKNOWN = "UNKNOWN";

}