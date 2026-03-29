package com.fdfd.global.exception;

import lombok.Getter;

@Getter
public class FdfdException extends RuntimeException {

    private final ErrorCode errorCode;

    public FdfdException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
