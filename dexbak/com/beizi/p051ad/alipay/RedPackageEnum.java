package com.beizi.p051ad.alipay;

/* renamed from: com.beizi.ad.alipay.RedPackageEnum */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RedPackageEnum {

    /* renamed from: com.beizi.ad.alipay.RedPackageEnum$RedPackageError */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum RedPackageError {
        ERROR_REQUEST_PARAM_ERROR(10011, "request param error"),
        ERROR_REQUEST_EXCEPTION(10012, "request exception"),
        ERROR_PARSE_EXCEPTION(10013, "parse exception"),
        ERROR_CONFIG_URL_EXCEPTION(10014, "config url not exist"),
        ERROR_AUTH_USER_INFO_NOT_EXIST(10015, "auth user info not exist"),
        ERROR_GET_USER_INFO_FAIL(10016, "get user info fail"),
        ERROR_AUTH_INFO_FAIL(10017, "auth info fail"),
        ERROR_ALIPAY_SDK_NOT_EXIST(10018, "alipay sdk not exist"),
        ERROR_EXCEPTION_SHOW(10019, "exception error"),
        ERROR_UNKNOWN_EXCEPTION(10099, "unknown exception");
        
        private int code;
        private String msg;

        RedPackageError(int i, String str) {
            this.code = i;
            this.msg = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
