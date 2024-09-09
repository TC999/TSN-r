package xyz.adscope.amps.common;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSErrorCode {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum ASMPLogicErrorEnum {
        PLATFORM_ERROR_INIT_FAIL("1010001", "init fail"),
        PLATFORM_ERROR_INIT_TIME_OUT("1010002", "init timeout"),
        PLATFORM_ERROR_CONFIG_RESPONSE_ERROR("1020001", "config response error"),
        PLATFORM_ERROR_CONFIG_PARSE_ERROR("1020002", "config parse error"),
        PLATFORM_ERROR_CONFIG_REQUEST_ERROR("1020003", "config request error"),
        PLATFORM_ERROR_CONFIG_REQUEST_TIME_OUT("1020004", "config request timeout"),
        PLATFORM_ERROR_PARAM_ERROR("1030001", "platform param error"),
        PLATFORM_ERROR_FILTER_NOT_PASS("1040001", "platform filter not pass"),
        PLATFORM_ERROR_REQUEST_TIME_OUT("1050001", "request timeout"),
        PLATFORM_ERROR_REQUEST_ERROR("1060001", "request fail"),
        PLATFORM_ERROR_SHOW_ERROR("1070001", "container or ad is null");
        
        private final String errorCode;
        private final String errorMsg;

        ASMPLogicErrorEnum(String str, String str2) {
            this.errorCode = str;
            this.errorMsg = str2;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum ChannelErrorEnum {
        CHANNEL_ERROR_INIT_ERROR("1000001", "channel init error"),
        CHANNEL_ERROR_REQUEST_PARAM_ERROR("1001001", "channel adapter request param error"),
        CHANNEL_ERROR_AD_IS_NULL("1002001", "channel ad is null or empty"),
        CHANNEL_ERROR_AD_CONTAINER_NULL("1003001", "channel ad or container is null"),
        CHANNEL_ERROR_AD_RENDER_FAIL("1004001", "channel ad render fail"),
        CHANNEL_ERROR_REQUEST_TIMEOUT("1005001", "channel ad request timeout"),
        CHANNEL_ERROR_REQUEST_FAIL("1005002", "channel ad request fail"),
        CHANNEL_ERROR_REQUEST_CACHE_FAIL("1005003", "channel ad request cache fail"),
        CHANNEL_ERROR_BZ_LOAD_FAIL("1006001", "channel bz load fail"),
        CHANNEL_ERROR_SDK_NOT_IMPORT("1007001", "channel sdk not import");
        
        private final String errorCode;
        private final String errorMsg;

        ChannelErrorEnum(String str, String str2) {
            this.errorCode = str;
            this.errorMsg = str2;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum ReportLogErrorEnum {
        REPORT_LOG_INIT_FAIL_CONFIG_NULL("100400", "init fail context or config is null"),
        REPORT_LOG_INIT_FAIL_APPID_NULL("100401", "init fail appid is null"),
        REPORT_LOG_MEDIATION_LOAD_FAIL_CODE("210400", "mediation load fail"),
        REPORT_LOG_SPACE_FILTER_FAIL_CODE("220400", "space filter fail"),
        REPORT_LOG_ADSOURCE_FILTER_FAIL("240400", "ad source filter fail"),
        REPORT_LOG_ADSOURCE_INIT_START("240500", "adsource init start"),
        REPORT_LOG_ADSOURCE_INIT_SUCCESS("240501", "adsource init success"),
        REPORT_LOG_ADSOURCE_INIT_FAIL("240502", "adsource init fail"),
        REPORT_LOG_ADSOURCE_BIDDING_FAIL_RESULT_NULL("250400", "biddingResult is null"),
        REPORT_LOG_ADSOURCE_BIDDING_FAIL_RESULT("250401", "biddingResult is fail"),
        REPORT_LOG_ADSOURCE_BIDDING_FAIL_SELECTOR_INIT_NULL("250500", "init sdk is null"),
        REPORT_LOG_ADSOURCE_BIDDING_FAIL_SELECTOR_ADAPTER_NULL("250501", "adapter is null"),
        REPORT_LOG_ADSOURCE_BIDDING_COMPARE_FAIL("251400", "bidding compare fail"),
        REPORT_LOG_ADSOURCE_BIDDING_COMPARE_FAIL_LESS_FLOOR("251401", "bidding less floor ecpm"),
        REPORT_LOG_ADSOURCE_GET_CACHE_FAIL("260400", "get cache fail"),
        REPORT_LOG_ADSOURCE_LOAD_REQUEST_FAIL("270400", "request fail"),
        REPORT_LOG_ADSOURCE_COMPARISON_FAIL("280400", "comparison fail");
        
        private final String errorCode;
        private final String errorMsg;

        ReportLogErrorEnum(String str, String str2) {
            this.errorCode = str;
            this.errorMsg = str2;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }
    }
}
