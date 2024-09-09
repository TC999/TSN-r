package xyz.adscope.common.info;

import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.sp.CommonSpUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DeviceInfo {
    public static DeviceInfo I;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String H;

    /* renamed from: a  reason: collision with root package name */
    public Context f64624a;

    /* renamed from: b  reason: collision with root package name */
    public long f64625b;

    /* renamed from: c  reason: collision with root package name */
    public String f64626c;

    /* renamed from: e  reason: collision with root package name */
    public String f64628e;

    /* renamed from: f  reason: collision with root package name */
    public String f64629f;

    /* renamed from: g  reason: collision with root package name */
    public String f64630g;

    /* renamed from: h  reason: collision with root package name */
    public String f64631h;

    /* renamed from: i  reason: collision with root package name */
    public String f64632i;

    /* renamed from: j  reason: collision with root package name */
    public String f64633j;

    /* renamed from: k  reason: collision with root package name */
    public String f64634k;

    /* renamed from: l  reason: collision with root package name */
    public String f64635l;

    /* renamed from: t  reason: collision with root package name */
    public String f64643t;

    /* renamed from: u  reason: collision with root package name */
    public String f64644u;

    /* renamed from: v  reason: collision with root package name */
    public String f64645v;

    /* renamed from: w  reason: collision with root package name */
    public String f64646w;

    /* renamed from: x  reason: collision with root package name */
    public String f64647x;

    /* renamed from: y  reason: collision with root package name */
    public String f64648y;

    /* renamed from: z  reason: collision with root package name */
    public String f64649z;

    /* renamed from: d  reason: collision with root package name */
    public int f64627d = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f64636m = -1;

    /* renamed from: n  reason: collision with root package name */
    public int f64637n = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f64638o = -1;

    /* renamed from: p  reason: collision with root package name */
    public int f64639p = -1;

    /* renamed from: q  reason: collision with root package name */
    public int f64640q = -1;

    /* renamed from: r  reason: collision with root package name */
    public float f64641r = -1.0f;

    /* renamed from: s  reason: collision with root package name */
    public float f64642s = -1.0f;
    public int G = -1;

    public DeviceInfo(Context context) {
        this.f64624a = context;
    }

    public static DeviceInfo getInstance(Context context) {
        if (I == null) {
            synchronized (DeviceInfo.class) {
                if (I == null) {
                    I = new DeviceInfo(context);
                }
            }
        }
        return I;
    }

    public String getAv() {
        if (TextUtils.isEmpty(this.F)) {
            this.F = DeviceInfoUtil.getAndroidVersion();
        }
        return this.F;
    }

    public String getBootMark() {
        if (TextUtils.isEmpty(this.f64643t)) {
            this.f64643t = DeviceInfoUtil.getDeviceBootMark();
        }
        return this.f64643t;
    }

    public String getBrand() {
        if (TextUtils.isEmpty(this.f64629f)) {
            this.f64629f = DeviceInfoUtil.getBrand();
        }
        return this.f64629f;
    }

    public String getCarrier() {
        if (TextUtils.isEmpty(this.f64633j)) {
            this.f64633j = DeviceInfoUtil.getCarrier(this.f64624a);
        }
        return this.f64633j;
    }

    public String getConnectType() {
        if (TextUtils.isEmpty(this.f64634k)) {
            this.f64634k = DeviceInfoUtil.getConnectType(this.f64624a) + "";
        }
        return this.f64634k;
    }

    public String getCountry() {
        if (TextUtils.isEmpty(this.C)) {
            this.C = DeviceInfoUtil.getCountry(this.f64624a);
        }
        return this.C;
    }

    public int getCountry_CN() {
        if (this.G == -1) {
            this.G = DeviceInfoUtil.getCountryCN(this.f64624a);
        }
        return this.G;
    }

    public String getDensity() {
        if (TextUtils.isEmpty(this.B)) {
            this.B = DeviceInfoUtil.getDensity(this.f64624a) + "";
        }
        return this.B;
    }

    public String getDeviceName() {
        if (TextUtils.isEmpty(this.E)) {
            this.E = DeviceInfoUtil.getDeviceName(this.f64624a);
        }
        return this.E;
    }

    public int getDeviceType() {
        if (this.f64627d == -1) {
            this.f64627d = DeviceInfoUtil.getDeviceType(this.f64624a);
        }
        return this.f64627d;
    }

    public String getFileMark() {
        if (TextUtils.isEmpty(this.D)) {
            this.D = DeviceInfoUtil.getFileMark();
        }
        return this.D;
    }

    public String getGaid() {
        if (TextUtils.isEmpty(this.f64648y)) {
            this.f64648y = CommonSpUtil.getString(this.f64624a, CommonConstants.DEVICE_GAID_KEY);
        }
        return this.f64648y;
    }

    public String getHardDiskSize() {
        if (TextUtils.isEmpty(this.f64646w)) {
            this.f64646w = DeviceInfoUtil.getHardDisk();
        }
        return this.f64646w;
    }

    public String getHmsCoreVersion() {
        if (TextUtils.isEmpty(this.H)) {
            this.H = DeviceInfoUtil.getHmsCoreVersion(this.f64624a);
        }
        return this.H;
    }

    public String getLanguage() {
        if (TextUtils.isEmpty(this.f64635l)) {
            this.f64635l = DeviceInfoUtil.getLanguage();
        }
        return this.f64635l;
    }

    public String getManufacturer() {
        if (TextUtils.isEmpty(this.f64628e)) {
            this.f64628e = DeviceInfoUtil.getManufacturer();
        }
        return this.f64628e;
    }

    public String getModel() {
        if (TextUtils.isEmpty(this.f64630g)) {
            this.f64630g = DeviceInfoUtil.getModel();
        }
        return this.f64630g;
    }

    public String getOaid() {
        if (TextUtils.isEmpty(this.f64647x)) {
            this.f64647x = CommonSpUtil.getString(this.f64624a, CommonConstants.DEVICE_OAID_KEY);
        }
        return this.f64647x;
    }

    public int getOrientation() {
        if (this.f64640q == -1) {
            this.f64640q = DeviceInfoUtil.getOrientation(this.f64624a);
        }
        return this.f64640q;
    }

    public String getOs() {
        if (TextUtils.isEmpty(this.f64631h)) {
            this.f64631h = DeviceInfoUtil.getOs() + "";
        }
        return this.f64631h;
    }

    public String getOsVersion() {
        if (TextUtils.isEmpty(this.f64632i)) {
            this.f64632i = DeviceInfoUtil.getOsVersion();
        }
        return this.f64632i;
    }

    public String getPhysicalMemory() {
        if (TextUtils.isEmpty(this.f64645v)) {
            this.f64645v = DeviceInfoUtil.getPhysicalMemory(this.f64624a);
        }
        return this.f64645v;
    }

    public float getPpi() {
        if (this.f64642s < 0.0f) {
            this.f64642s = DeviceInfoUtil.getPPI(this.f64624a);
        }
        return this.f64642s;
    }

    public float getPxRation() {
        if (this.f64641r < 0.0f) {
            this.f64641r = DeviceInfoUtil.getPxRatio(this.f64624a);
        }
        return this.f64641r;
    }

    public int getResolutionHeight() {
        if (this.f64638o == -1) {
            this.f64638o = DeviceInfoUtil.getScreenHeight(this.f64624a);
        }
        return this.f64638o;
    }

    public int getResolutionWidth() {
        if (this.f64639p == -1) {
            this.f64639p = DeviceInfoUtil.getScreenWidth(this.f64624a);
        }
        return this.f64639p;
    }

    public int getScreenHeight() {
        if (this.f64636m == -1) {
            this.f64636m = DeviceInfoUtil.getScreenHeightDp(this.f64624a);
        }
        return this.f64636m;
    }

    public int getScreenWidth() {
        if (this.f64637n == -1) {
            this.f64637n = DeviceInfoUtil.getScreenWidthDp(this.f64624a);
        }
        return this.f64637n;
    }

    public String getSdkid() {
        if (TextUtils.isEmpty(this.A)) {
            this.A = DeviceInfoUtil.getSdkId(this.f64624a);
        }
        return this.A;
    }

    public long getTimeStamp() {
        return DeviceInfoUtil.getTimeStamp();
    }

    public String getTimeZone() {
        if (TextUtils.isEmpty(this.f64649z)) {
            this.f64649z = DeviceInfoUtil.getTimeZone();
        }
        return this.f64649z;
    }

    public String getUpdateMark() {
        if (TextUtils.isEmpty(this.f64644u)) {
            this.f64644u = DeviceInfoUtil.getDeviceUpdateMark();
        }
        return this.f64644u;
    }

    public String getUserAgent() {
        if (TextUtils.isEmpty(this.f64626c)) {
            this.f64626c = DeviceInfoUtil.getUserAgent(this.f64624a);
        }
        return this.f64626c;
    }

    public void setAv(String str) {
        this.F = str;
    }

    public void setBootMark(String str) {
        this.f64643t = str;
    }

    public void setBrand(String str) {
        this.f64629f = str;
    }

    public void setCarrier(String str) {
        this.f64633j = str;
    }

    public void setConnectType(String str) {
        this.f64634k = str;
    }

    public void setCountry(String str) {
        this.C = str;
    }

    public void setCountry_CN(int i4) {
        this.G = i4;
    }

    public void setDensity(String str) {
        this.B = str;
    }

    public void setDeviceName(String str) {
        this.E = str;
    }

    public void setDeviceType(int i4) {
        this.f64627d = i4;
    }

    public void setFileMark(String str) {
        this.D = str;
    }

    public void setGaid(String str) {
        this.f64648y = str;
    }

    public void setHardDiskSize(String str) {
        this.f64646w = str;
    }

    public void setHmsCoreVersion(String str) {
        this.H = str;
    }

    public void setLanguage(String str) {
        this.f64635l = str;
    }

    public void setManufacturer(String str) {
        this.f64628e = str;
    }

    public void setModel(String str) {
        this.f64630g = str;
    }

    public void setOaid(String str) {
        this.f64647x = str;
    }

    public void setOrientation(int i4) {
        this.f64640q = i4;
    }

    public void setOs(String str) {
        this.f64631h = str;
    }

    public void setOsVersion(String str) {
        this.f64632i = str;
    }

    public void setPhysicalMemory(String str) {
        this.f64645v = str;
    }

    public void setPpi(float f4) {
        this.f64642s = f4;
    }

    public void setPxRation(float f4) {
        this.f64641r = f4;
    }

    public void setResolutionHeight(int i4) {
        this.f64638o = i4;
    }

    public void setResolutionWidth(int i4) {
        this.f64639p = i4;
    }

    public void setScreenHeight(int i4) {
        this.f64636m = i4;
    }

    public void setScreenWidth(int i4) {
        this.f64637n = i4;
    }

    public void setSdkid(String str) {
        this.A = str;
    }

    public void setTimeStamp(long j4) {
        this.f64625b = j4;
    }

    public void setTimeZone(String str) {
        this.f64649z = str;
    }

    public void setUpdateMark(String str) {
        this.f64644u = str;
    }

    public void setUserAgent(String str) {
        this.f64626c = str;
    }
}
