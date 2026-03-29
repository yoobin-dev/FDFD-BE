package com.fdfd.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 공통
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "잘못된 입력값입니다."),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "요청한 리소스를 찾을 수 없습니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증이 필요합니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "접근 권한이 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다."),

    // 회원
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),
    DUPLICATE_EMAIL(HttpStatus.CONFLICT, "이미 사용 중인 이메일입니다."),

    // 인증
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다."),

    // 업체/강사
    CORP_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 업체입니다."),
    INSTRUCTOR_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 강사입니다."),

    // 연습반
    CLASS_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 연습반입니다."),
    CLASS_FULL(HttpStatus.CONFLICT, "연습반 정원이 초과되었습니다."),
    ALREADY_REGISTERED(HttpStatus.CONFLICT, "이미 신청한 연습반입니다.");

    private final HttpStatus status;
    private final String message;
}
