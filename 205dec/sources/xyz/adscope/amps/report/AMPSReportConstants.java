package xyz.adscope.amps.report;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSReportConstants {
    public static final String ACCESS_KEY = "AMPS";
    public static final String ACCESS_TYPE_SDK = "sdk";
    public static final String CURRENCY = "CNY";
    public static final String CUSTOM_ID = "mediation5";
    public static final String CUSTOM_LOGGER = "xyz.adscope.amps";
    public static final String EVENT_TIME_KEY = "eventTime";
    public static final String LMT_NO_PERMIT = "0";
    public static final String LMT_PERMIT = "1";
    public static final String LOG_VERSION = "5.0.0";

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum LOAD_TYPE {
        LOAD_TYPE_NORMAL(0, "normal"),
        LOAD_TYPE_PRELOAD(1, "preload"),
        LOAD_TYPE_AUTO(2, "auto");
        
        private int code;
        private String value;

        LOAD_TYPE(int i4, String str) {
            this.code = i4;
            this.value = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum REPORT_AD_TYPE {
        AD_TYPE_REWARD_VIDEO("1", "rewardVideo"),
        AD_TYPE_SPLASH("2", "splash"),
        AD_TYPE_INTERSTITIAL("3", "interstitial"),
        AD_TYPE_NATIVE_EXPRESS("7", "nativeExpress"),
        AD_TYPE_NATIVE_UNIFIED("6", "nativeUnified"),
        AD_TYPE_BANNER("4", "banner");
        
        private String code;
        private String value;

        REPORT_AD_TYPE(String str, String str2) {
            this.code = str;
            this.value = str2;
        }

        public String getCode() {
            return this.code;
        }

        public String getValue() {
            return this.value;
        }
    }
}
