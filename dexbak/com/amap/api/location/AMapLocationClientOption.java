package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AMapLocationClientOption implements Parcelable, Cloneable {

    /* renamed from: d */
    private static int f6903d = 0;

    /* renamed from: e */
    private static int f6904e = 1;

    /* renamed from: f */
    private static int f6905f = 2;

    /* renamed from: g */
    private static int f6906g = 4;

    /* renamed from: A */
    private boolean f6908A;

    /* renamed from: B */
    private int f6909B;

    /* renamed from: C */
    private int f6910C;

    /* renamed from: D */
    private boolean f6911D;

    /* renamed from: E */
    private boolean f6912E;

    /* renamed from: F */
    private boolean f6913F;

    /* renamed from: G */
    private float f6914G;

    /* renamed from: H */
    private AMapLocationPurpose f6915H;

    /* renamed from: b */
    boolean f6916b;

    /* renamed from: c */
    String f6917c;

    /* renamed from: h */
    private long f6918h;

    /* renamed from: i */
    private long f6919i;

    /* renamed from: j */
    private boolean f6920j;

    /* renamed from: k */
    private boolean f6921k;

    /* renamed from: l */
    private boolean f6922l;

    /* renamed from: m */
    private boolean f6923m;

    /* renamed from: n */
    private boolean f6924n;

    /* renamed from: o */
    private AMapLocationMode f6925o;

    /* renamed from: q */
    private boolean f6926q;

    /* renamed from: r */
    private boolean f6927r;

    /* renamed from: s */
    private boolean f6928s;

    /* renamed from: t */
    private boolean f6929t;

    /* renamed from: u */
    private boolean f6930u;

    /* renamed from: v */
    private boolean f6931v;

    /* renamed from: w */
    private boolean f6932w;

    /* renamed from: x */
    private long f6933x;

    /* renamed from: y */
    private long f6934y;

    /* renamed from: z */
    private GeoLanguage f6935z;

    /* renamed from: p */
    private static AMapLocationProtocol f6907p = AMapLocationProtocol.HTTP;

    /* renamed from: a */
    static String f6902a = "";
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator<AMapLocationClientOption>() { // from class: com.amap.api.location.AMapLocationClientOption.1
        /* renamed from: a */
        private static AMapLocationClientOption m52130a(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption createFromParcel(Parcel parcel) {
            return m52130a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption[] newArray(int i) {
            return m52131a(i);
        }

        /* renamed from: a */
        private static AMapLocationClientOption[] m52131a(int i) {
            return new AMapLocationClientOption[i];
        }
    };
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = 30000;

    /* renamed from: com.amap.api.location.AMapLocationClientOption$2 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static /* synthetic */ class C22362 {

        /* renamed from: a */
        static final /* synthetic */ int[] f6936a;

        static {
            int[] iArr = new int[AMapLocationPurpose.values().length];
            f6936a = iArr;
            try {
                iArr[AMapLocationPurpose.SignIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6936a[AMapLocationPurpose.Transport.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6936a[AMapLocationPurpose.Sport.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);
        

        /* renamed from: a */
        private int f6939a;

        AMapLocationProtocol(int i) {
            this.f6939a = i;
        }

        public final int getValue() {
            return this.f6939a;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public AMapLocationClientOption() {
        this.f6918h = 2000L;
        this.f6919i = C2428b.f8375i;
        this.f6920j = false;
        this.f6921k = true;
        this.f6922l = true;
        this.f6923m = true;
        this.f6924n = true;
        this.f6925o = AMapLocationMode.Hight_Accuracy;
        this.f6926q = false;
        this.f6927r = false;
        this.f6928s = true;
        this.f6929t = true;
        this.f6930u = false;
        this.f6931v = false;
        this.f6932w = true;
        this.f6933x = 30000L;
        this.f6934y = 30000L;
        this.f6935z = GeoLanguage.DEFAULT;
        this.f6908A = false;
        this.f6909B = TTAdConstant.STYLE_SIZE_RADIO_3_2;
        this.f6910C = 21600000;
        this.f6911D = false;
        this.f6912E = true;
        this.f6913F = true;
        this.f6914G = 0.0f;
        this.f6915H = null;
        this.f6916b = false;
        this.f6917c = null;
    }

    /* renamed from: a */
    private AMapLocationClientOption m52132a(AMapLocationClientOption aMapLocationClientOption) {
        this.f6918h = aMapLocationClientOption.f6918h;
        this.f6920j = aMapLocationClientOption.f6920j;
        this.f6925o = aMapLocationClientOption.f6925o;
        this.f6921k = aMapLocationClientOption.f6921k;
        this.f6926q = aMapLocationClientOption.f6926q;
        this.f6927r = aMapLocationClientOption.f6927r;
        this.f6911D = aMapLocationClientOption.f6911D;
        this.f6922l = aMapLocationClientOption.f6922l;
        this.f6923m = aMapLocationClientOption.f6923m;
        this.f6919i = aMapLocationClientOption.f6919i;
        this.f6928s = aMapLocationClientOption.f6928s;
        this.f6929t = aMapLocationClientOption.f6929t;
        this.f6930u = aMapLocationClientOption.f6930u;
        this.f6931v = aMapLocationClientOption.isSensorEnable();
        this.f6932w = aMapLocationClientOption.isWifiScan();
        this.f6933x = aMapLocationClientOption.f6933x;
        setLocationProtocol(aMapLocationClientOption.getLocationProtocol());
        this.f6935z = aMapLocationClientOption.f6935z;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        this.f6914G = aMapLocationClientOption.f6914G;
        this.f6915H = aMapLocationClientOption.f6915H;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(aMapLocationClientOption.getScanWifiInterval());
        this.f6934y = aMapLocationClientOption.f6934y;
        this.f6910C = aMapLocationClientOption.getCacheTimeOut();
        this.f6908A = aMapLocationClientOption.getCacheCallBack();
        this.f6909B = aMapLocationClientOption.getCacheCallBackTime();
        this.f6912E = aMapLocationClientOption.isSelfStartServiceEnable();
        this.f6913F = aMapLocationClientOption.isNoLocReqCgiEnable();
        return this;
    }

    public static String getAPIKEY() {
        return f6902a;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z) {
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        f6907p = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z) {
        OPEN_ALWAYS_SCAN_WIFI = z;
    }

    public static void setScanWifiInterval(long j) {
        SCAN_WIFI_INTERVAL = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getCacheCallBack() {
        return this.f6908A;
    }

    public int getCacheCallBackTime() {
        return this.f6909B;
    }

    public int getCacheTimeOut() {
        return this.f6910C;
    }

    public float getDeviceModeDistanceFilter() {
        return this.f6914G;
    }

    public GeoLanguage getGeoLanguage() {
        return this.f6935z;
    }

    public long getGpsFirstTimeout() {
        return this.f6934y;
    }

    public long getHttpTimeOut() {
        return this.f6919i;
    }

    public long getInterval() {
        return this.f6918h;
    }

    public long getLastLocationLifeCycle() {
        return this.f6933x;
    }

    public AMapLocationMode getLocationMode() {
        return this.f6925o;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return f6907p;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.f6915H;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isBeidouFirst() {
        return this.f6911D;
    }

    public boolean isGpsFirst() {
        return this.f6927r;
    }

    public boolean isKillProcess() {
        return this.f6926q;
    }

    public boolean isLocationCacheEnable() {
        return this.f6929t;
    }

    public boolean isMockEnable() {
        return this.f6921k;
    }

    public boolean isNeedAddress() {
        return this.f6922l;
    }

    public boolean isNoLocReqCgiEnable() {
        return this.f6913F;
    }

    public boolean isOffset() {
        return this.f6928s;
    }

    public boolean isOnceLocation() {
        return this.f6920j;
    }

    public boolean isOnceLocationLatest() {
        return this.f6930u;
    }

    public boolean isSelfStartServiceEnable() {
        return this.f6912E;
    }

    public boolean isSensorEnable() {
        return this.f6931v;
    }

    public boolean isWifiActiveScan() {
        return this.f6923m;
    }

    public boolean isWifiScan() {
        return this.f6932w;
    }

    public AMapLocationClientOption setBeidouFirst(boolean z) {
        this.f6911D = z;
        return this;
    }

    public void setCacheCallBack(boolean z) {
        this.f6908A = z;
    }

    public void setCacheCallBackTime(int i) {
        this.f6909B = i;
    }

    public void setCacheTimeOut(int i) {
        this.f6910C = i;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.f6914G = f;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.f6935z = geoLanguage;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean z) {
        this.f6927r = z;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j) {
        if (j < 5000) {
            j = 5000;
        }
        if (j > 30000) {
            j = 30000;
        }
        this.f6934y = j;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j) {
        this.f6919i = j;
        return this;
    }

    public AMapLocationClientOption setInterval(long j) {
        if (j <= 800) {
            j = 800;
        }
        this.f6918h = j;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z) {
        this.f6926q = z;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j) {
        this.f6933x = j;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z) {
        this.f6929t = z;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.f6925o = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        this.f6915H = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            int i = C22362.f6936a[aMapLocationPurpose.ordinal()];
            if (i == 1) {
                this.f6925o = AMapLocationMode.Hight_Accuracy;
                this.f6920j = true;
                this.f6930u = true;
                this.f6927r = false;
                this.f6911D = false;
                this.f6921k = false;
                this.f6932w = true;
                this.f6912E = true;
                this.f6913F = true;
                int i2 = f6903d;
                int i3 = f6904e;
                if ((i2 & i3) == 0) {
                    this.f6916b = true;
                    f6903d = i2 | i3;
                    this.f6917c = "signin";
                }
            } else if (i == 2) {
                int i4 = f6903d;
                int i5 = f6905f;
                if ((i4 & i5) == 0) {
                    this.f6916b = true;
                    f6903d = i4 | i5;
                    this.f6917c = NotificationCompat.CATEGORY_TRANSPORT;
                }
                this.f6925o = AMapLocationMode.Hight_Accuracy;
                this.f6920j = false;
                this.f6930u = false;
                this.f6927r = true;
                this.f6911D = false;
                this.f6912E = true;
                this.f6913F = true;
                this.f6921k = false;
                this.f6932w = true;
            } else if (i == 3) {
                int i6 = f6903d;
                int i7 = f6906g;
                if ((i6 & i7) == 0) {
                    this.f6916b = true;
                    f6903d = i6 | i7;
                    this.f6917c = "sport";
                }
                this.f6925o = AMapLocationMode.Hight_Accuracy;
                this.f6920j = false;
                this.f6930u = false;
                this.f6927r = true;
                this.f6911D = false;
                this.f6912E = true;
                this.f6913F = true;
                this.f6921k = false;
                this.f6932w = true;
            }
        }
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z) {
        this.f6921k = z;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z) {
        this.f6922l = z;
        return this;
    }

    public void setNoLocReqCgiEnable(boolean z) {
        this.f6913F = z;
    }

    public AMapLocationClientOption setOffset(boolean z) {
        this.f6928s = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z) {
        this.f6920j = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z) {
        this.f6930u = z;
        return this;
    }

    public void setSelfStartServiceEnable(boolean z) {
        this.f6912E = z;
    }

    public AMapLocationClientOption setSensorEnable(boolean z) {
        this.f6931v = z;
        return this;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean z) {
        this.f6923m = z;
        this.f6924n = z;
        return this;
    }

    public AMapLocationClientOption setWifiScan(boolean z) {
        this.f6932w = z;
        if (z) {
            this.f6923m = this.f6924n;
        } else {
            this.f6923m = false;
        }
        return this;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.f6918h) + "#isOnceLocation:" + String.valueOf(this.f6920j) + "#locationMode:" + String.valueOf(this.f6925o) + "#locationProtocol:" + String.valueOf(f6907p) + "#isMockEnable:" + String.valueOf(this.f6921k) + "#isKillProcess:" + String.valueOf(this.f6926q) + "#isGpsFirst:" + String.valueOf(this.f6927r) + "#isBeidouFirst:" + String.valueOf(this.f6911D) + "#isSelfStartServiceEnable:" + String.valueOf(this.f6912E) + "#noLocReqCgiEnable:" + String.valueOf(this.f6913F) + "#isNeedAddress:" + String.valueOf(this.f6922l) + "#isWifiActiveScan:" + String.valueOf(this.f6923m) + "#wifiScan:" + String.valueOf(this.f6932w) + "#httpTimeOut:" + String.valueOf(this.f6919i) + "#isLocationCacheEnable:" + String.valueOf(this.f6929t) + "#isOnceLocationLatest:" + String.valueOf(this.f6930u) + "#sensorEnable:" + String.valueOf(this.f6931v) + "#geoLanguage:" + String.valueOf(this.f6935z) + "#locationPurpose:" + String.valueOf(this.f6915H) + "#callback:" + String.valueOf(this.f6908A) + "#time:" + String.valueOf(this.f6909B) + "#";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f6918h);
        parcel.writeLong(this.f6919i);
        parcel.writeByte(this.f6920j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6921k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6922l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6923m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6924n ? (byte) 1 : (byte) 0);
        AMapLocationMode aMapLocationMode = this.f6925o;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.f6926q ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6927r ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6911D ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6912E ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6913F ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6928s ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6929t ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6930u ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6931v ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6932w ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f6933x);
        parcel.writeInt(f6907p == null ? -1 : getLocationProtocol().ordinal());
        GeoLanguage geoLanguage = this.f6935z;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeFloat(this.f6914G);
        AMapLocationPurpose aMapLocationPurpose = this.f6915H;
        parcel.writeInt(aMapLocationPurpose != null ? aMapLocationPurpose.ordinal() : -1);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.f6934y);
    }

    /* renamed from: clone */
    public AMapLocationClientOption m60095clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new AMapLocationClientOption().m52132a(this);
    }

    protected AMapLocationClientOption(Parcel parcel) {
        this.f6918h = 2000L;
        this.f6919i = C2428b.f8375i;
        this.f6920j = false;
        this.f6921k = true;
        this.f6922l = true;
        this.f6923m = true;
        this.f6924n = true;
        AMapLocationMode aMapLocationMode = AMapLocationMode.Hight_Accuracy;
        this.f6925o = aMapLocationMode;
        this.f6926q = false;
        this.f6927r = false;
        this.f6928s = true;
        this.f6929t = true;
        this.f6930u = false;
        this.f6931v = false;
        this.f6932w = true;
        this.f6933x = 30000L;
        this.f6934y = 30000L;
        GeoLanguage geoLanguage = GeoLanguage.DEFAULT;
        this.f6935z = geoLanguage;
        this.f6908A = false;
        this.f6909B = TTAdConstant.STYLE_SIZE_RADIO_3_2;
        this.f6910C = 21600000;
        this.f6911D = false;
        this.f6912E = true;
        this.f6913F = true;
        this.f6914G = 0.0f;
        this.f6915H = null;
        this.f6916b = false;
        this.f6917c = null;
        this.f6918h = parcel.readLong();
        this.f6919i = parcel.readLong();
        this.f6920j = parcel.readByte() != 0;
        this.f6921k = parcel.readByte() != 0;
        this.f6922l = parcel.readByte() != 0;
        this.f6923m = parcel.readByte() != 0;
        this.f6924n = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.f6925o = readInt != -1 ? AMapLocationMode.values()[readInt] : aMapLocationMode;
        this.f6926q = parcel.readByte() != 0;
        this.f6927r = parcel.readByte() != 0;
        this.f6911D = parcel.readByte() != 0;
        this.f6912E = parcel.readByte() != 0;
        this.f6913F = parcel.readByte() != 0;
        this.f6928s = parcel.readByte() != 0;
        this.f6929t = parcel.readByte() != 0;
        this.f6930u = parcel.readByte() != 0;
        this.f6931v = parcel.readByte() != 0;
        this.f6932w = parcel.readByte() != 0;
        this.f6933x = parcel.readLong();
        int readInt2 = parcel.readInt();
        f6907p = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.f6935z = readInt3 != -1 ? GeoLanguage.values()[readInt3] : geoLanguage;
        this.f6914G = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.f6915H = readInt4 != -1 ? AMapLocationPurpose.values()[readInt4] : null;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0;
        this.f6934y = parcel.readLong();
    }
}
