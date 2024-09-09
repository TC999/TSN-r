package xyz.adscope.ad.advertisings.constants;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ErrorCode {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum ErrorCodeAdListener {
        ERROR_CODE_AD_LISTENER_PARSE_JSON_EXCEPTION(10010, "json parse exception"),
        ERROR_CODE_AD_LISTENER_NET_REQUEST_EXCEPTION(10011, "net request exception"),
        ERROR_CODE_INIT_TIME_OUT_EXCEPTION(10012, "init timeout"),
        ERROR_CODE_CONFIG_TIME_OUT_EXCEPTION(10013, "config request timeout"),
        ERROR_CODE_AD_LISTENER_REQUEST_TIME_OUT_EXCEPTION(10014, "request ad timeout"),
        ERROR_CODE_AD_LISTENER_REQUEST_NATIVE_TIME_OUT_EXCEPTION(10015, "request native ad timeout"),
        ERROR_CODE_SERVER_REQUEST_ERROR(10016, "server request error"),
        ERROR_CODE_AD_NOT_EXIST_ERROR(10018, "server ad not exist"),
        ERROR_CODE_AD_BEEN_COMPLAIN(10019, "ad has been complain"),
        ERROR_CODE_AD_VIDEO_CACHE_FAIL(10020, "video ad cache fail"),
        ERROR_CODE_REQUEST_FREQUENT(10021, "ad request frequent"),
        ERROR_CODE_UNITE_CONTROL(10022, "unite control"),
        ERROR_CODE_UNKNOWN(19999, "unknown error");
        
        public int code;
        public String message;

        ErrorCodeAdListener(int i4, String str) {
            this.code = i4;
            this.message = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }
}
