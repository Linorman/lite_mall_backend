package com.softwarelearn.lite_mall_backend.constant;

/**
 * 结果编码枚举类
 *
 * @author linorman tt ww
 * @data 2023/04/16
 */
public enum ResultCode {
    /**
     * 一般返回结果
     */
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),

    /**
     * 注册相关结果和查询结果
     */
    USER_REGISTER_SUCCESS(1000, "注册成功"),
    USER_EXISTS(1001, "用户已存在"),
    USER_PHONENUMBER_EXISTS(1002, "手机号已存在"),

    GOODS_NOT_EXISTS(1021, "商品不存在"),

    GOODS_SEARCH_SUCCESS(1022, "查找成功"),

    /**
     * 登录/登出相关结果
     */
    USER_SIGHIN_SUCCESS(2000, "登录成功"),
    USER_NOT_EXISTS(2001, "用户不存在"),
    USER_NAME_PHONE_NOT_MATCH(2002, "用户名与手机号不匹配"),
    USER_PASSWORD_WRONG(2003, "密码错误"),
    USER_ALREADY_LOGINED(2004, "用户已登录"),
    USER_LOGOUT_SUCCESS(2005, "登出成功"),
    USER_ALREADY_LOGOUT(2006, "用户已登出"),
    USER_NOT_LOGIN(2007, "用户未登录"),

    /**
     * 订单相关结果
     */
    ORDERNUM_SEARCH_SUCCESS(3001, "订单不存在"),
    ORDERNUM_INCREASE_SUCCESS(3002, "订单量增加成功"),
    VISITNUM_INCREASE_SUCCESS(3003, "订单量增加成功"),
    VISITNUM_SEARCH_SUCCESS(3004, "查找访问量成功");


    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultCode getResultCode(int code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.getCode() == code) {
                return resultCode;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
