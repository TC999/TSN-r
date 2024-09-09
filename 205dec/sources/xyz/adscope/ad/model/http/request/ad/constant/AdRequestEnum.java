package xyz.adscope.ad.model.http.request.ad.constant;

import xyz.adscope.amps.report.AMPSReportConstants;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdRequestEnum {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum AT_TYPE {
        AT_FIRST_STAGE_TYPE(1),
        AT_SECOND_STAGE_TYPE(2);
        
        private int code;

        AT_TYPE(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum CCPA_TYPE {
        CCPA_ADULT_TYPE(0),
        CCPA_CHILD_TYPE(1);
        
        private int code;

        CCPA_TYPE(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum COPPA_TYPE {
        COPPA_PERMITTED_TYPE(0),
        COPPA_NOT_PERMITTED_TYPE(1);
        
        private int code;

        COPPA_TYPE(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum CURRENCY_TYPE {
        CURRENCY_TYPE_CNY(AMPSReportConstants.CURRENCY),
        CURRENCY_TYPE_USD("USD"),
        CURRENCY_TYPE_JPY("JPY"),
        CURRENCY_TYPE_EUR("EUR"),
        CURRENCY_TYPE_GBP("GBP"),
        CURRENCY_TYPE_IDR("IDR"),
        CURRENCY_TYPE_MYR("MYR"),
        CURRENCY_TYPE_PHP("PHP"),
        CURRENCY_TYPE_KRW("THB");
        
        private String type;

        CURRENCY_TYPE(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum DEVICE_COUNTRY_TYPE {
        COUNTRY_OTHER_TYPE(0, "OTHER"),
        COUNTRY_CHINA_TYPE(1, "CN");
        
        private int code;
        private String country;

        DEVICE_COUNTRY_TYPE(int i4, String str) {
            this.code = i4;
            this.country = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getCountry() {
            return this.country;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum DLVY_TYPE {
        ITEM_DLVY_REAL_TIME(1),
        ITEM_DLVY_PRELOAD(2),
        ITEM_DLVY_ALL(0);
        
        private int code;

        DLVY_TYPE(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum GDPR_TYPE {
        GDPR_PERMITTED_TYPE(0),
        GDPR_NOT_PERMITTED_TYPE(1);
        
        private int code;

        GDPR_TYPE(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum TEST_TYPE {
        TEST_FORMAL_MODEL(0),
        TEST_NO_PRICE_MODEL(1);
        
        private int code;

        TEST_TYPE(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }
}
