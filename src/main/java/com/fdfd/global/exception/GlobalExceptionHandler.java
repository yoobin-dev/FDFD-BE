package com.fdfd.global.exception;

import com.fdfd.global.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FdfdException.class)
    public ResponseEntity<ApiResponse<Void>> handleFdfdException(FdfdException e) {
        log.warn("FdfdException: {}", e.getMessage());
        ErrorCode code = e.getErrorCode();
        return ResponseEntity.status(code.getStatus()).body(ApiResponse.fail(code.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidation(MethodArgumentNotValidException e) {
        BindingResult br = e.getBindingResult();
        String message = br.getFieldErrors().stream()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .findFirst()
                .orElse(ErrorCode.INVALID_INPUT.getMessage());
        return ResponseEntity.badRequest().body(ApiResponse.fail(message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e) {
        log.error("Unhandled exception", e);
        return ResponseEntity.internalServerError()
                .body(ApiResponse.fail(ErrorCode.INTERNAL_SERVER_ERROR.getMessage()));
    }
}
