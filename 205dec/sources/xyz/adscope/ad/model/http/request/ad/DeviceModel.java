package xyz.adscope.ad.model.http.request.ad;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DeviceModel {
    private String an;
    private String brand;
    private String carrier;
    private String contype;
    private JSONObject ext;

    /* renamed from: h  reason: collision with root package name */
    private int f64523h;
    private String hmsCoreVersion;
    private String lang;
    private int lmt;
    private String make;
    private String model;
    private int os;
    private String osv;
    private String ppi;
    private String pxratio;
    private int type;
    private String ua;

    /* renamed from: w  reason: collision with root package name */
    private int f64524w;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum DEVICE_TYPE {
        TYPE_PHONE_PAD(1),
        TYPE_PC(2),
        TYPE_INTERNET_TV(3),
        TYPE_TELEPHONE(4),
        TYPE_TABLET(5),
        TYPE_LINK_DEVICE(6),
        TYPE_STB(7),
        TYPE_OUTING_DEVICE(8),
        TYPE_PHONE(100),
        TYPE_PAD(101);
        
        private int code;

        DEVICE_TYPE(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum LMT_TYPE {
        LMT_NO_LIMIT(0),
        LMT_LIMIT(1);
        
        private int code;

        LMT_TYPE(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    public String getAn() {
        return this.an;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getContype() {
        return this.contype;
    }

    public JSONObject getExt() {
        return this.ext;
    }

    public int getH() {
        return this.f64523h;
    }

    public String getHmsCoreVersion() {
        return this.hmsCoreVersion;
    }

    public String getLang() {
        return this.lang;
    }

    public int getLmt() {
        return this.lmt;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getOs() {
        return this.os;
    }

    public String getOsv() {
        return this.osv;
    }

    public String getPpi() {
        return this.ppi;
    }

    public String getPxratio() {
        return this.pxratio;
    }

    public int getType() {
        return this.type;
    }

    public String getUa() {
        return this.ua;
    }

    public int getW() {
        return this.f64524w;
    }

    public void setAn(String str) {
        this.an = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCarrier(String str) {
        this.carrier = str;
    }

    public void setContype(String str) {
        this.contype = str;
    }

    public void setExt(JSONObject jSONObject) {
        this.ext = jSONObject;
    }

    public void setH(int i4) {
        this.f64523h = i4;
    }

    public void setHmsCoreVersion(String str) {
        this.hmsCoreVersion = str;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setLmt(int i4) {
        this.lmt = i4;
    }

    public void setMake(String str) {
        this.make = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setOs(int i4) {
        this.os = i4;
    }

    public void setOsv(String str) {
        this.osv = str;
    }

    public void setPpi(String str) {
        this.ppi = str;
    }

    public void setPxratio(String str) {
        this.pxratio = str;
    }

    public void setType(int i4) {
        this.type = i4;
    }

    public void setUa(String str) {
        this.ua = str;
    }

    public void setW(int i4) {
        this.f64524w = i4;
    }

    public String toString() {
        return "{\"type\":" + this.type + ", \"ua\":\"" + this.ua + "\", \"lmt\":" + this.lmt + ", \"make\":\"" + this.make + "\", \"brand\":\"" + this.brand + "\", \"model\":\"" + this.model + "\", \"os\":" + this.os + ", \"osv\":\"" + this.osv + "\", \"h\":" + this.f64523h + ", \"w\":" + this.f64524w + ", \"ppi\":\"" + this.ppi + "\", \"pxratio\":\"" + this.pxratio + "\", \"lang\":\"" + this.lang + "\", \"carrier\":\"" + this.carrier + "\", \"contype\":\"" + this.contype + "\", \"hmsCoreVersion\":\"" + this.hmsCoreVersion + "\", \"an\":\"" + this.an + "\", \"ext\":" + this.ext + '}';
    }
}
