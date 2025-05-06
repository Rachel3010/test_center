package org.iav.common.result;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "Success"),
    FAIL(201, "Fail"),
    PARAM_ERROR(202, "Parameter incorrect"),
    SERVICE_ERROR(203, "Service exception"),
    DATA_ERROR(204, "Data exception"),
    ILLEGAL_REQUEST(205, "Illegal request"),
    REPEAT_SUBMIT(206, "Duplicate submission"),
    DELETE_ERROR(207, "Please delete subset first"),

    ADMIN_ACCOUNT_EXIST_ERROR(301, "Account already exists"),
    ADMIN_CAPTCHA_CODE_ERROR(302, "Verification code error"),
    ADMIN_CAPTCHA_CODE_EXPIRED(303, "Verification code expired"),
    ADMIN_CAPTCHA_CODE_NOT_FOUND(304, "Verification code not entered"),


    ADMIN_LOGIN_AUTH(305, "Not logged in"),
    ADMIN_ACCOUNT_NOT_EXIST_ERROR(306, "Account does not exist"),
    ADMIN_ACCOUNT_ERROR(307, "Username or password error"),
    ADMIN_ACCOUNT_DISABLED_ERROR(308, "This user has been disabled"),
    ADMIN_ACCESS_FORBIDDEN(309, "No access permission"),

    APP_LOGIN_AUTH(501, "Not logged in"),
    APP_ACCOUNT_DISABLED_ERROR(502, "This user has been disabled"),


    TOKEN_EXPIRED(601, "Token expired"),
    TOKEN_INVALID(602, "Token invalid");


    private final Integer code;

    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}