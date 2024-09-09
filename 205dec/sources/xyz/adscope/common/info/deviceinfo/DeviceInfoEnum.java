package xyz.adscope.common.info.deviceinfo;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DeviceInfoEnum {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum CARRIER_TYPE {
        CARRIER_CMCC("CMCC"),
        CARRIER_CUCC("CUCC"),
        CARRIER_CTCC("CTCC"),
        CARRIER_UNKNOWN("UNKNOW");
        

        /* renamed from: a  reason: collision with root package name */
        public String f64651a;

        CARRIER_TYPE(String str) {
            this.f64651a = str;
        }

        public String getValue() {
            return this.f64651a;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum CONNECT_TYPE {
        CONNECT_TYPE_UNKNOWN(0, "unknown"),
        CONNECT_TYPE_WIFI(1, "wifi"),
        CONNECT_TYPE_2G(2, "2G"),
        CONNECT_TYPE_3G(3, "3G"),
        CONNECT_TYPE_4G(4, "4G"),
        CONNECT_TYPE_5G(5, "5G");
        

        /* renamed from: a  reason: collision with root package name */
        public int f64653a;

        /* renamed from: b  reason: collision with root package name */
        public String f64654b;

        CONNECT_TYPE(int i4, String str) {
            this.f64653a = i4;
            this.f64654b = str;
        }

        public int getCode() {
            return this.f64653a;
        }

        public String getValue() {
            return this.f64654b;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum DEVICE_COUNTRY_TYPE {
        COUNTRY_OTHER_TYPE(0, "OTHER"),
        COUNTRY_CHINA_TYPE(1, "CN");
        

        /* renamed from: a  reason: collision with root package name */
        public int f64656a;

        /* renamed from: b  reason: collision with root package name */
        public String f64657b;

        DEVICE_COUNTRY_TYPE(int i4, String str) {
            this.f64656a = i4;
            this.f64657b = str;
        }

        public int getCode() {
            return this.f64656a;
        }

        public String getCountry() {
            return this.f64657b;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum DEVICE_TYPE {
        TYPE_PHONE(100),
        TYPE_TABLET(101);
        

        /* renamed from: a  reason: collision with root package name */
        public int f64659a;

        DEVICE_TYPE(int i4) {
            this.f64659a = i4;
        }

        public int getCode() {
            return this.f64659a;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum OS_TYPE {
        CONNECT_TYPE_UNKNOWN(0),
        OS_ANDROID(2),
        OS_IOS_TV(3),
        OS_IOS(13),
        OS_PS4(22);
        

        /* renamed from: a  reason: collision with root package name */
        public int f64661a;

        OS_TYPE(int i4) {
            this.f64661a = i4;
        }

        public int getCode() {
            return this.f64661a;
        }
    }
}
