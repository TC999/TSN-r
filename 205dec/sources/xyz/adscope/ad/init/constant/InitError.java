package xyz.adscope.ad.init.constant;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface InitError {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum INIT_ERROR {
        ERROR_NO_LOCAL_CONFIG(1000, "no local config"),
        ERROR_UNKNOWN(1001, "error unknown"),
        ERROR_INIT_FAIL(1002, "init fail"),
        ERROR_CONFIG_PARSE_FAIL(1003, "config parse fail"),
        ERROR_CONFIG_RESPONSE_ERROR(1004, "config response error");
        
        private int code;
        private String value;

        INIT_ERROR(int i4, String str) {
            this.value = str;
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }

        public String getValue() {
            return this.value;
        }
    }
}
