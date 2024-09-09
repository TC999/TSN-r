package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.utils.b;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapLocationClientOption implements Parcelable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static int f10617d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static int f10618e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static int f10619f = 2;

    /* renamed from: g  reason: collision with root package name */
    private static int f10620g = 4;
    private boolean A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private float G;
    private AMapLocationPurpose H;

    /* renamed from: b  reason: collision with root package name */
    boolean f10622b;

    /* renamed from: c  reason: collision with root package name */
    String f10623c;

    /* renamed from: h  reason: collision with root package name */
    private long f10624h;

    /* renamed from: i  reason: collision with root package name */
    private long f10625i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10626j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10627k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10628l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10629m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10630n;

    /* renamed from: o  reason: collision with root package name */
    private AMapLocationMode f10631o;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10632q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10633r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f10634s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f10635t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f10636u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f10637v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f10638w;

    /* renamed from: x  reason: collision with root package name */
    private long f10639x;

    /* renamed from: y  reason: collision with root package name */
    private long f10640y;

    /* renamed from: z  reason: collision with root package name */
    private GeoLanguage f10641z;

    /* renamed from: p  reason: collision with root package name */
    private static AMapLocationProtocol f10621p = AMapLocationProtocol.HTTP;

    /* renamed from: a  reason: collision with root package name */
    static String f10616a = "";
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator<AMapLocationClientOption>() { // from class: com.amap.api.location.AMapLocationClientOption.1
        private static AMapLocationClientOption a(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption[] newArray(int i4) {
            return a(i4);
        }

        private static AMapLocationClientOption[] a(int i4) {
            return new AMapLocationClientOption[i4];
        }
    };
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = PolicyConfig.mServerBusyRetryBaseInternal;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.amap.api.location.AMapLocationClientOption$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10642a;

        static {
            int[] iArr = new int[AMapLocationPurpose.values().length];
            f10642a = iArr;
            try {
                iArr[AMapLocationPurpose.SignIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10642a[AMapLocationPurpose.Transport.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10642a[AMapLocationPurpose.Sport.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);
        

        /* renamed from: a  reason: collision with root package name */
        private int f10645a;

        AMapLocationProtocol(int i4) {
            this.f10645a = i4;
        }

        public final int getValue() {
            return this.f10645a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public AMapLocationClientOption() {
        this.f10624h = 2000L;
        this.f10625i = b.f12013i;
        this.f10626j = false;
        this.f10627k = true;
        this.f10628l = true;
        this.f10629m = true;
        this.f10630n = true;
        this.f10631o = AMapLocationMode.Hight_Accuracy;
        this.f10632q = false;
        this.f10633r = false;
        this.f10634s = true;
        this.f10635t = true;
        this.f10636u = false;
        this.f10637v = false;
        this.f10638w = true;
        this.f10639x = PolicyConfig.mServerBusyRetryBaseInternal;
        this.f10640y = PolicyConfig.mServerBusyRetryBaseInternal;
        this.f10641z = GeoLanguage.DEFAULT;
        this.A = false;
        this.B = 1500;
        this.C = 21600000;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = 0.0f;
        this.H = null;
        this.f10622b = false;
        this.f10623c = null;
    }

    private AMapLocationClientOption a(AMapLocationClientOption aMapLocationClientOption) {
        this.f10624h = aMapLocationClientOption.f10624h;
        this.f10626j = aMapLocationClientOption.f10626j;
        this.f10631o = aMapLocationClientOption.f10631o;
        this.f10627k = aMapLocationClientOption.f10627k;
        this.f10632q = aMapLocationClientOption.f10632q;
        this.f10633r = aMapLocationClientOption.f10633r;
        this.D = aMapLocationClientOption.D;
        this.f10628l = aMapLocationClientOption.f10628l;
        this.f10629m = aMapLocationClientOption.f10629m;
        this.f10625i = aMapLocationClientOption.f10625i;
        this.f10634s = aMapLocationClientOption.f10634s;
        this.f10635t = aMapLocationClientOption.f10635t;
        this.f10636u = aMapLocationClientOption.f10636u;
        this.f10637v = aMapLocationClientOption.isSensorEnable();
        this.f10638w = aMapLocationClientOption.isWifiScan();
        this.f10639x = aMapLocationClientOption.f10639x;
        setLocationProtocol(aMapLocationClientOption.getLocationProtocol());
        this.f10641z = aMapLocationClientOption.f10641z;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        this.G = aMapLocationClientOption.G;
        this.H = aMapLocationClientOption.H;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(aMapLocationClientOption.getScanWifiInterval());
        this.f10640y = aMapLocationClientOption.f10640y;
        this.C = aMapLocationClientOption.getCacheTimeOut();
        this.A = aMapLocationClientOption.getCacheCallBack();
        this.B = aMapLocationClientOption.getCacheCallBackTime();
        this.E = aMapLocationClientOption.isSelfStartServiceEnable();
        this.F = aMapLocationClientOption.isNoLocReqCgiEnable();
        return this;
    }

    public static String getAPIKEY() {
        return f10616a;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z3) {
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        f10621p = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z3) {
        OPEN_ALWAYS_SCAN_WIFI = z3;
    }

    public static void setScanWifiInterval(long j4) {
        SCAN_WIFI_INTERVAL = j4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getCacheCallBack() {
        return this.A;
    }

    public int getCacheCallBackTime() {
        return this.B;
    }

    public int getCacheTimeOut() {
        return this.C;
    }

    public float getDeviceModeDistanceFilter() {
        return this.G;
    }

    public GeoLanguage getGeoLanguage() {
        return this.f10641z;
    }

    public long getGpsFirstTimeout() {
        return this.f10640y;
    }

    public long getHttpTimeOut() {
        return this.f10625i;
    }

    public long getInterval() {
        return this.f10624h;
    }

    public long getLastLocationLifeCycle() {
        return this.f10639x;
    }

    public AMapLocationMode getLocationMode() {
        return this.f10631o;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return f10621p;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.H;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isBeidouFirst() {
        return this.D;
    }

    public boolean isGpsFirst() {
        return this.f10633r;
    }

    public boolean isKillProcess() {
        return this.f10632q;
    }

    public boolean isLocationCacheEnable() {
        return this.f10635t;
    }

    public boolean isMockEnable() {
        return this.f10627k;
    }

    public boolean isNeedAddress() {
        return this.f10628l;
    }

    public boolean isNoLocReqCgiEnable() {
        return this.F;
    }

    public boolean isOffset() {
        return this.f10634s;
    }

    public boolean isOnceLocation() {
        return this.f10626j;
    }

    public boolean isOnceLocationLatest() {
        return this.f10636u;
    }

    public boolean isSelfStartServiceEnable() {
        return this.E;
    }

    public boolean isSensorEnable() {
        return this.f10637v;
    }

    public boolean isWifiActiveScan() {
        return this.f10629m;
    }

    public boolean isWifiScan() {
        return this.f10638w;
    }

    public AMapLocationClientOption setBeidouFirst(boolean z3) {
        this.D = z3;
        return this;
    }

    public void setCacheCallBack(boolean z3) {
        this.A = z3;
    }

    public void setCacheCallBackTime(int i4) {
        this.B = i4;
    }

    public void setCacheTimeOut(int i4) {
        this.C = i4;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f4) {
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        this.G = f4;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.f10641z = geoLanguage;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean z3) {
        this.f10633r = z3;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j4) {
        if (j4 < 5000) {
            j4 = 5000;
        }
        if (j4 > PolicyConfig.mServerBusyRetryBaseInternal) {
            j4 = 30000;
        }
        this.f10640y = j4;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j4) {
        this.f10625i = j4;
        return this;
    }

    public AMapLocationClientOption setInterval(long j4) {
        if (j4 <= 800) {
            j4 = 800;
        }
        this.f10624h = j4;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z3) {
        this.f10632q = z3;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j4) {
        this.f10639x = j4;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z3) {
        this.f10635t = z3;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.f10631o = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        this.H = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            int i4 = AnonymousClass2.f10642a[aMapLocationPurpose.ordinal()];
            if (i4 == 1) {
                this.f10631o = AMapLocationMode.Hight_Accuracy;
                this.f10626j = true;
                this.f10636u = true;
                this.f10633r = false;
                this.D = false;
                this.f10627k = false;
                this.f10638w = true;
                this.E = true;
                this.F = true;
                int i5 = f10617d;
                int i6 = f10618e;
                if ((i5 & i6) == 0) {
                    this.f10622b = true;
                    f10617d = i5 | i6;
                    this.f10623c = "signin";
                }
            } else if (i4 == 2) {
                int i7 = f10617d;
                int i8 = f10619f;
                if ((i7 & i8) == 0) {
                    this.f10622b = true;
                    f10617d = i7 | i8;
                    this.f10623c = "transport";
                }
                this.f10631o = AMapLocationMode.Hight_Accuracy;
                this.f10626j = false;
                this.f10636u = false;
                this.f10633r = true;
                this.D = false;
                this.E = true;
                this.F = true;
                this.f10627k = false;
                this.f10638w = true;
            } else if (i4 == 3) {
                int i9 = f10617d;
                int i10 = f10620g;
                if ((i9 & i10) == 0) {
                    this.f10622b = true;
                    f10617d = i9 | i10;
                    this.f10623c = "sport";
                }
                this.f10631o = AMapLocationMode.Hight_Accuracy;
                this.f10626j = false;
                this.f10636u = false;
                this.f10633r = true;
                this.D = false;
                this.E = true;
                this.F = true;
                this.f10627k = false;
                this.f10638w = true;
            }
        }
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z3) {
        this.f10627k = z3;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z3) {
        this.f10628l = z3;
        return this;
    }

    public void setNoLocReqCgiEnable(boolean z3) {
        this.F = z3;
    }

    public AMapLocationClientOption setOffset(boolean z3) {
        this.f10634s = z3;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z3) {
        this.f10626j = z3;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z3) {
        this.f10636u = z3;
        return this;
    }

    public void setSelfStartServiceEnable(boolean z3) {
        this.E = z3;
    }

    public AMapLocationClientOption setSensorEnable(boolean z3) {
        this.f10637v = z3;
        return this;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean z3) {
        this.f10629m = z3;
        this.f10630n = z3;
        return this;
    }

    public AMapLocationClientOption setWifiScan(boolean z3) {
        this.f10638w = z3;
        if (z3) {
            this.f10629m = this.f10630n;
        } else {
            this.f10629m = false;
        }
        return this;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.f10624h) + "#isOnceLocation:" + String.valueOf(this.f10626j) + "#locationMode:" + String.valueOf(this.f10631o) + "#locationProtocol:" + String.valueOf(f10621p) + "#isMockEnable:" + String.valueOf(this.f10627k) + "#isKillProcess:" + String.valueOf(this.f10632q) + "#isGpsFirst:" + String.valueOf(this.f10633r) + "#isBeidouFirst:" + String.valueOf(this.D) + "#isSelfStartServiceEnable:" + String.valueOf(this.E) + "#noLocReqCgiEnable:" + String.valueOf(this.F) + "#isNeedAddress:" + String.valueOf(this.f10628l) + "#isWifiActiveScan:" + String.valueOf(this.f10629m) + "#wifiScan:" + String.valueOf(this.f10638w) + "#httpTimeOut:" + String.valueOf(this.f10625i) + "#isLocationCacheEnable:" + String.valueOf(this.f10635t) + "#isOnceLocationLatest:" + String.valueOf(this.f10636u) + "#sensorEnable:" + String.valueOf(this.f10637v) + "#geoLanguage:" + String.valueOf(this.f10641z) + "#locationPurpose:" + String.valueOf(this.H) + "#callback:" + String.valueOf(this.A) + "#time:" + String.valueOf(this.B) + "#";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.f10624h);
        parcel.writeLong(this.f10625i);
        parcel.writeByte(this.f10626j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10627k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10628l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10629m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10630n ? (byte) 1 : (byte) 0);
        AMapLocationMode aMapLocationMode = this.f10631o;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.f10632q ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10633r ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.E ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.F ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10634s ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10635t ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10636u ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10637v ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10638w ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f10639x);
        parcel.writeInt(f10621p == null ? -1 : getLocationProtocol().ordinal());
        GeoLanguage geoLanguage = this.f10641z;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeFloat(this.G);
        AMapLocationPurpose aMapLocationPurpose = this.H;
        parcel.writeInt(aMapLocationPurpose != null ? aMapLocationPurpose.ordinal() : -1);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.f10640y);
    }

    /* renamed from: clone */
    public AMapLocationClientOption m16clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new AMapLocationClientOption().a(this);
    }

    protected AMapLocationClientOption(Parcel parcel) {
        this.f10624h = 2000L;
        this.f10625i = b.f12013i;
        this.f10626j = false;
        this.f10627k = true;
        this.f10628l = true;
        this.f10629m = true;
        this.f10630n = true;
        AMapLocationMode aMapLocationMode = AMapLocationMode.Hight_Accuracy;
        this.f10631o = aMapLocationMode;
        this.f10632q = false;
        this.f10633r = false;
        this.f10634s = true;
        this.f10635t = true;
        this.f10636u = false;
        this.f10637v = false;
        this.f10638w = true;
        this.f10639x = PolicyConfig.mServerBusyRetryBaseInternal;
        this.f10640y = PolicyConfig.mServerBusyRetryBaseInternal;
        GeoLanguage geoLanguage = GeoLanguage.DEFAULT;
        this.f10641z = geoLanguage;
        this.A = false;
        this.B = 1500;
        this.C = 21600000;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = 0.0f;
        this.H = null;
        this.f10622b = false;
        this.f10623c = null;
        this.f10624h = parcel.readLong();
        this.f10625i = parcel.readLong();
        this.f10626j = parcel.readByte() != 0;
        this.f10627k = parcel.readByte() != 0;
        this.f10628l = parcel.readByte() != 0;
        this.f10629m = parcel.readByte() != 0;
        this.f10630n = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.f10631o = readInt != -1 ? AMapLocationMode.values()[readInt] : aMapLocationMode;
        this.f10632q = parcel.readByte() != 0;
        this.f10633r = parcel.readByte() != 0;
        this.D = parcel.readByte() != 0;
        this.E = parcel.readByte() != 0;
        this.F = parcel.readByte() != 0;
        this.f10634s = parcel.readByte() != 0;
        this.f10635t = parcel.readByte() != 0;
        this.f10636u = parcel.readByte() != 0;
        this.f10637v = parcel.readByte() != 0;
        this.f10638w = parcel.readByte() != 0;
        this.f10639x = parcel.readLong();
        int readInt2 = parcel.readInt();
        f10621p = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.f10641z = readInt3 != -1 ? GeoLanguage.values()[readInt3] : geoLanguage;
        this.G = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.H = readInt4 != -1 ? AMapLocationPurpose.values()[readInt4] : null;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0;
        this.f10640y = parcel.readLong();
    }
}
