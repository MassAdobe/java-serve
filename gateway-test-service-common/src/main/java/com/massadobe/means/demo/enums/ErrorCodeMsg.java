package com.massadobe.means.demo.enums;

/**
 * @ClassName: ErrorCodeMsg
 * @Author: MassAdobe
 * @Email: massadobe8@gmail.com
 * @Description: TODO
 * @Date: Created in 2019-12-13 11:28
 * @Version: 1.0.0
 * @param: * @param null
 */
public enum ErrorCodeMsg {
    // 系统级别(0,0->999)
    SUCCESS(0, "成功"),
    UNKNOWN_ERROR(999, "未知错误"),
    SERVER_ERROR(998, "服务错误"),
    PARAM_ERROR(997, "参数错误"),
    PAGE_OR_API_ERROR(996, "页面或接口错误"),
    HEADER_USER_ERROR(995, "非过滤接口中头信息不含有用户要素"),
    // 业务错误(xx业务:4000->4999)
    JSON_DECODE_ERROR(2999, "JSON解析错误"),
    RETURN_ERROR_EXAMPLE(2998, "返回错误示范"),
    BASE64_ENCRYPT_ERROR(2997, "Base64加密错误"),
    BASE64_DECRYPT_ERROR(2996, "Base64解密错误"),
    OK_HTTP_ERROR(2995, "okHttp客户端错误"),

    // 数据级别
    ;

    private int code;
    private String message;

    ErrorCodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
