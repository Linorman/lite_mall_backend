package com.softwarelearn.lite_mall_backend.constant;

/**
 * 结果编码枚举类
 * @author linorman
 * @data 2023/04/16
 */
public enum ResultCode {
    /**
     * 一般返回结果
     */
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),

    /**
     * 注册相关结果
     */
    USER_REGISTER_SUCCESS(1000, "注册成功"),
    USER_EXISTS(1001, "用户已存在");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ResultCode getResultCode(int code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.getCode() == code) {
                return resultCode;
            }
        }
        return null;
    }
}
