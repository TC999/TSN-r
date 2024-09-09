package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.j;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapLocation extends Location implements Parcelable, Cloneable {
    public static final String COORD_TYPE_GCJ02 = "GCJ02";
    public static final String COORD_TYPE_WGS84 = "WGS84";
    public static final Parcelable.Creator<AMapLocation> CREATOR = new Parcelable.Creator<AMapLocation>() { // from class: com.amap.api.location.AMapLocation.1
        private static AMapLocation a(Parcel parcel) {
            AMapLocation aMapLocation = new AMapLocation((Location) Location.CREATOR.createFromParcel(parcel));
            aMapLocation.f10595h = parcel.readString();
            aMapLocation.f10596i = parcel.readString();
            aMapLocation.B = parcel.readString();
            aMapLocation.f10588a = parcel.readString();
            aMapLocation.f10592e = parcel.readString();
            aMapLocation.f10594g = parcel.readString();
            aMapLocation.f10598k = parcel.readString();
            aMapLocation.f10593f = parcel.readString();
            aMapLocation.f10603p = parcel.readInt();
            aMapLocation.f10604q = parcel.readString();
            aMapLocation.f10589b = parcel.readString();
            aMapLocation.F = parcel.readInt() != 0;
            aMapLocation.f10602o = parcel.readInt() != 0;
            aMapLocation.f10607t = parcel.readDouble();
            aMapLocation.f10605r = parcel.readString();
            aMapLocation.f10606s = parcel.readInt();
            aMapLocation.f10608u = parcel.readDouble();
            aMapLocation.D = parcel.readInt() != 0;
            aMapLocation.f10601n = parcel.readString();
            aMapLocation.f10597j = parcel.readString();
            aMapLocation.f10591d = parcel.readString();
            aMapLocation.f10599l = parcel.readString();
            aMapLocation.A = parcel.readInt();
            aMapLocation.C = parcel.readInt();
            aMapLocation.f10600m = parcel.readString();
            aMapLocation.E = parcel.readString();
            aMapLocation.G = parcel.readString();
            aMapLocation.H = parcel.readInt();
            aMapLocation.I = parcel.readInt();
            return aMapLocation;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation[] newArray(int i4) {
            return a(i4);
        }

        private static AMapLocation[] a(int i4) {
            return new AMapLocation[i4];
        }
    };
    public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_COARSE_LOCATION = 20;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
    public static final int ERROR_CODE_NO_COMPENSATION_CACHE = 33;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final int LOCATION_COMPENSATION = 10;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_COARSE_LOCATION = 11;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    public static final int TRUSTED_LEVEL_BAD = 4;
    public static final int TRUSTED_LEVEL_HIGH = 1;
    public static final int TRUSTED_LEVEL_LOW = 3;
    public static final int TRUSTED_LEVEL_NORMAL = 2;
    private int A;
    private String B;
    private int C;
    private boolean D;
    private String E;
    private boolean F;
    private String G;
    private int H;
    private int I;

    /* renamed from: a  reason: collision with root package name */
    protected String f10588a;

    /* renamed from: b  reason: collision with root package name */
    protected String f10589b;

    /* renamed from: c  reason: collision with root package name */
    AMapLocationQualityReport f10590c;

    /* renamed from: d  reason: collision with root package name */
    private String f10591d;

    /* renamed from: e  reason: collision with root package name */
    private String f10592e;

    /* renamed from: f  reason: collision with root package name */
    private String f10593f;

    /* renamed from: g  reason: collision with root package name */
    private String f10594g;

    /* renamed from: h  reason: collision with root package name */
    private String f10595h;

    /* renamed from: i  reason: collision with root package name */
    private String f10596i;

    /* renamed from: j  reason: collision with root package name */
    private String f10597j;

    /* renamed from: k  reason: collision with root package name */
    private String f10598k;

    /* renamed from: l  reason: collision with root package name */
    private String f10599l;

    /* renamed from: m  reason: collision with root package name */
    private String f10600m;

    /* renamed from: n  reason: collision with root package name */
    private String f10601n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10602o;

    /* renamed from: p  reason: collision with root package name */
    private int f10603p;

    /* renamed from: q  reason: collision with root package name */
    private String f10604q;

    /* renamed from: r  reason: collision with root package name */
    private String f10605r;

    /* renamed from: s  reason: collision with root package name */
    private int f10606s;

    /* renamed from: t  reason: collision with root package name */
    private double f10607t;

    /* renamed from: u  reason: collision with root package name */
    private double f10608u;

    /* renamed from: v  reason: collision with root package name */
    private double f10609v;

    /* renamed from: w  reason: collision with root package name */
    private float f10610w;

    /* renamed from: x  reason: collision with root package name */
    private float f10611x;

    /* renamed from: y  reason: collision with root package name */
    private Bundle f10612y;

    /* renamed from: z  reason: collision with root package name */
    private String f10613z;

    public AMapLocation(String str) {
        super(str);
        this.f10591d = "";
        this.f10592e = "";
        this.f10593f = "";
        this.f10594g = "";
        this.f10595h = "";
        this.f10596i = "";
        this.f10597j = "";
        this.f10598k = "";
        this.f10599l = "";
        this.f10600m = "";
        this.f10601n = "";
        this.f10602o = true;
        this.f10603p = 0;
        this.f10604q = "success";
        this.f10605r = "";
        this.f10606s = 0;
        this.f10607t = 0.0d;
        this.f10608u = 0.0d;
        this.f10609v = 0.0d;
        this.f10610w = 0.0f;
        this.f10611x = 0.0f;
        this.f10612y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.f10588a = "";
        this.f10589b = "";
        this.f10590c = new AMapLocationQualityReport();
        this.G = "GCJ02";
        this.H = 1;
        this.f10613z = str;
    }

    @Override // android.location.Location, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.f10595h;
    }

    public String getAddress() {
        return this.f10596i;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return this.f10609v;
    }

    public String getAoiName() {
        return this.B;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.f10611x;
    }

    public String getBuildingId() {
        return this.f10588a;
    }

    public String getCity() {
        return this.f10592e;
    }

    public String getCityCode() {
        return this.f10594g;
    }

    public int getConScenario() {
        return this.I;
    }

    public String getCoordType() {
        return this.G;
    }

    public String getCountry() {
        return this.f10598k;
    }

    public String getDescription() {
        return this.E;
    }

    public String getDistrict() {
        return this.f10593f;
    }

    public int getErrorCode() {
        return this.f10603p;
    }

    public String getErrorInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10604q);
        if (this.f10603p != 0) {
            sb.append(" \u8bf7\u5230http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/\u67e5\u770b\u9519\u8bef\u7801\u8bf4\u660e");
            sb.append(",\u9519\u8bef\u8be6\u7ec6\u4fe1\u606f:" + this.f10605r);
        }
        return sb.toString();
    }

    @Override // android.location.Location
    public Bundle getExtras() {
        return this.f10612y;
    }

    public String getFloor() {
        return this.f10589b;
    }

    public int getGpsAccuracyStatus() {
        return this.C;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.f10607t;
    }

    public String getLocationDetail() {
        return this.f10605r;
    }

    public AMapLocationQualityReport getLocationQualityReport() {
        return this.f10590c;
    }

    public int getLocationType() {
        return this.f10606s;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.f10608u;
    }

    public String getPoiName() {
        return this.f10597j;
    }

    @Override // android.location.Location
    public String getProvider() {
        return this.f10613z;
    }

    public String getProvince() {
        return this.f10591d;
    }

    public String getRoad() {
        return this.f10599l;
    }

    public int getSatellites() {
        return this.A;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.f10610w;
    }

    public String getStreet() {
        return this.f10600m;
    }

    public String getStreetNum() {
        return this.f10601n;
    }

    public int getTrustedLevel() {
        return this.H;
    }

    public boolean isFixLastLocation() {
        return this.F;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.D;
    }

    public boolean isOffset() {
        return this.f10602o;
    }

    public void setAdCode(String str) {
        this.f10595h = str;
    }

    public void setAddress(String str) {
        this.f10596i = str;
    }

    @Override // android.location.Location
    public void setAltitude(double d4) {
        super.setAltitude(d4);
        this.f10609v = d4;
    }

    public void setAoiName(String str) {
        this.B = str;
    }

    @Override // android.location.Location
    public void setBearing(float f4) {
        super.setBearing(f4);
        while (f4 < 0.0f) {
            f4 += 360.0f;
        }
        while (f4 >= 360.0f) {
            f4 -= 360.0f;
        }
        this.f10611x = f4;
    }

    public void setBuildingId(String str) {
        this.f10588a = str;
    }

    public void setCity(String str) {
        this.f10592e = str;
    }

    public void setCityCode(String str) {
        this.f10594g = str;
    }

    public void setConScenario(int i4) {
        this.I = i4;
    }

    public void setCoordType(String str) {
        this.G = str;
    }

    public void setCountry(String str) {
        this.f10598k = str;
    }

    public void setDescription(String str) {
        this.E = str;
    }

    public void setDistrict(String str) {
        this.f10593f = str;
    }

    public void setErrorCode(int i4) {
        if (this.f10603p != 0) {
            return;
        }
        this.f10604q = j.a(i4);
        this.f10603p = i4;
    }

    public void setErrorInfo(String str) {
        this.f10604q = str;
    }

    @Override // android.location.Location
    public void setExtras(Bundle bundle) {
        super.setExtras(bundle);
        this.f10612y = bundle == null ? null : new Bundle(bundle);
    }

    public void setFixLastLocation(boolean z3) {
        this.F = z3;
    }

    public void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                b.a(th, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.f10589b = str;
    }

    public void setGpsAccuracyStatus(int i4) {
        this.C = i4;
    }

    @Override // android.location.Location
    public void setLatitude(double d4) {
        this.f10607t = d4;
    }

    public void setLocationDetail(String str) {
        this.f10605r = str;
    }

    public void setLocationQualityReport(AMapLocationQualityReport aMapLocationQualityReport) {
        if (aMapLocationQualityReport == null) {
            return;
        }
        this.f10590c = aMapLocationQualityReport;
    }

    public void setLocationType(int i4) {
        this.f10606s = i4;
    }

    @Override // android.location.Location
    public void setLongitude(double d4) {
        this.f10608u = d4;
    }

    @Override // android.location.Location
    public void setMock(boolean z3) {
        this.D = z3;
    }

    public void setNumber(String str) {
        this.f10601n = str;
    }

    public void setOffset(boolean z3) {
        this.f10602o = z3;
    }

    public void setPoiName(String str) {
        this.f10597j = str;
    }

    @Override // android.location.Location
    public void setProvider(String str) {
        super.setProvider(str);
        this.f10613z = str;
    }

    public void setProvince(String str) {
        this.f10591d = str;
    }

    public void setRoad(String str) {
        this.f10599l = str;
    }

    public void setSatellites(int i4) {
        this.A = i4;
    }

    @Override // android.location.Location
    public void setSpeed(float f4) {
        super.setSpeed(f4);
        this.f10610w = f4;
    }

    public void setStreet(String str) {
        this.f10600m = str;
    }

    public void setTrustedLevel(int i4) {
        this.H = i4;
    }

    public JSONObject toJson(int i4) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i4 == 1) {
                try {
                    jSONObject.put("altitude", getAltitude());
                    jSONObject.put("speed", getSpeed());
                    jSONObject.put("bearing", getBearing());
                } catch (Throwable unused) {
                }
                jSONObject.put("citycode", this.f10594g);
                jSONObject.put("adcode", this.f10595h);
                jSONObject.put("country", this.f10598k);
                jSONObject.put("province", this.f10591d);
                jSONObject.put("city", this.f10592e);
                jSONObject.put("district", this.f10593f);
                jSONObject.put("road", this.f10599l);
                jSONObject.put("street", this.f10600m);
                jSONObject.put("number", this.f10601n);
                jSONObject.put("poiname", this.f10597j);
                jSONObject.put("errorCode", this.f10603p);
                jSONObject.put("errorInfo", this.f10604q);
                jSONObject.put("locationType", this.f10606s);
                jSONObject.put("locationDetail", this.f10605r);
                jSONObject.put("aoiname", this.B);
                jSONObject.put("address", this.f10596i);
                jSONObject.put("poiid", this.f10588a);
                jSONObject.put("floor", this.f10589b);
                jSONObject.put("description", this.E);
            } else if (i4 != 2) {
                if (i4 != 3) {
                    return jSONObject;
                }
                jSONObject.put("provider", getProvider());
                jSONObject.put("lon", getLongitude());
                jSONObject.put("lat", getLatitude());
                jSONObject.put("accuracy", getAccuracy());
                jSONObject.put("isOffset", this.f10602o);
                jSONObject.put("isFixLastLocation", this.F);
                jSONObject.put("coordType", this.G);
                return jSONObject;
            }
            jSONObject.put("time", getTime());
            jSONObject.put("provider", getProvider());
            jSONObject.put("lon", getLongitude());
            jSONObject.put("lat", getLatitude());
            jSONObject.put("accuracy", getAccuracy());
            jSONObject.put("isOffset", this.f10602o);
            jSONObject.put("isFixLastLocation", this.F);
            jSONObject.put("coordType", this.G);
            return jSONObject;
        } catch (Throwable th) {
            b.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public String toStr() {
        return toStr(1);
    }

    @Override // android.location.Location
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.f10607t + "#");
            stringBuffer.append("longitude=" + this.f10608u + "#");
            stringBuffer.append("province=" + this.f10591d + "#");
            stringBuffer.append("coordType=" + this.G + "#");
            stringBuffer.append("city=" + this.f10592e + "#");
            stringBuffer.append("district=" + this.f10593f + "#");
            stringBuffer.append("cityCode=" + this.f10594g + "#");
            stringBuffer.append("adCode=" + this.f10595h + "#");
            stringBuffer.append("address=" + this.f10596i + "#");
            stringBuffer.append("country=" + this.f10598k + "#");
            stringBuffer.append("road=" + this.f10599l + "#");
            stringBuffer.append("poiName=" + this.f10597j + "#");
            stringBuffer.append("street=" + this.f10600m + "#");
            stringBuffer.append("streetNum=" + this.f10601n + "#");
            stringBuffer.append("aoiName=" + this.B + "#");
            stringBuffer.append("poiid=" + this.f10588a + "#");
            stringBuffer.append("floor=" + this.f10589b + "#");
            stringBuffer.append("errorCode=" + this.f10603p + "#");
            stringBuffer.append("errorInfo=" + this.f10604q + "#");
            stringBuffer.append("locationDetail=" + this.f10605r + "#");
            stringBuffer.append("description=" + this.E + "#");
            stringBuffer.append("locationType=" + this.f10606s + "#");
            StringBuilder sb = new StringBuilder("conScenario=");
            sb.append(this.I);
            stringBuffer.append(sb.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @Override // android.location.Location, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        try {
            super.writeToParcel(parcel, i4);
            parcel.writeString(this.f10595h);
            parcel.writeString(this.f10596i);
            parcel.writeString(this.B);
            parcel.writeString(this.f10588a);
            parcel.writeString(this.f10592e);
            parcel.writeString(this.f10594g);
            parcel.writeString(this.f10598k);
            parcel.writeString(this.f10593f);
            parcel.writeInt(this.f10603p);
            parcel.writeString(this.f10604q);
            parcel.writeString(this.f10589b);
            int i5 = 1;
            parcel.writeInt(this.F ? 1 : 0);
            parcel.writeInt(this.f10602o ? 1 : 0);
            parcel.writeDouble(this.f10607t);
            parcel.writeString(this.f10605r);
            parcel.writeInt(this.f10606s);
            parcel.writeDouble(this.f10608u);
            if (!this.D) {
                i5 = 0;
            }
            parcel.writeInt(i5);
            parcel.writeString(this.f10601n);
            parcel.writeString(this.f10597j);
            parcel.writeString(this.f10591d);
            parcel.writeString(this.f10599l);
            parcel.writeInt(this.A);
            parcel.writeInt(this.C);
            parcel.writeString(this.f10600m);
            parcel.writeString(this.E);
            parcel.writeString(this.G);
            parcel.writeInt(this.H);
            parcel.writeInt(this.I);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "writeToParcel");
        }
    }

    /* renamed from: clone */
    public AMapLocation m15clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        AMapLocation aMapLocation = new AMapLocation(this);
        try {
            aMapLocation.setLatitude(this.f10607t);
            aMapLocation.setLongitude(this.f10608u);
            aMapLocation.setAdCode(this.f10595h);
            aMapLocation.setAddress(this.f10596i);
            aMapLocation.setAoiName(this.B);
            aMapLocation.setBuildingId(this.f10588a);
            aMapLocation.setCity(this.f10592e);
            aMapLocation.setCityCode(this.f10594g);
            aMapLocation.setCountry(this.f10598k);
            aMapLocation.setDistrict(this.f10593f);
            aMapLocation.setErrorCode(this.f10603p);
            aMapLocation.setErrorInfo(this.f10604q);
            aMapLocation.setFloor(this.f10589b);
            aMapLocation.setFixLastLocation(this.F);
            aMapLocation.setOffset(this.f10602o);
            aMapLocation.setLocationDetail(this.f10605r);
            aMapLocation.setLocationType(this.f10606s);
            aMapLocation.setMock(this.D);
            aMapLocation.setNumber(this.f10601n);
            aMapLocation.setPoiName(this.f10597j);
            aMapLocation.setProvince(this.f10591d);
            aMapLocation.setRoad(this.f10599l);
            aMapLocation.setSatellites(this.A);
            aMapLocation.setGpsAccuracyStatus(this.C);
            aMapLocation.setStreet(this.f10600m);
            aMapLocation.setDescription(this.E);
            aMapLocation.setExtras(getExtras());
            AMapLocationQualityReport aMapLocationQualityReport = this.f10590c;
            if (aMapLocationQualityReport != null) {
                aMapLocation.setLocationQualityReport(aMapLocationQualityReport.m17clone());
            }
            aMapLocation.setCoordType(this.G);
            aMapLocation.setTrustedLevel(this.H);
            aMapLocation.setConScenario(this.I);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "clone");
        }
        return aMapLocation;
    }

    public String toStr(int i4) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i4);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public AMapLocation(Location location) {
        super(location);
        this.f10591d = "";
        this.f10592e = "";
        this.f10593f = "";
        this.f10594g = "";
        this.f10595h = "";
        this.f10596i = "";
        this.f10597j = "";
        this.f10598k = "";
        this.f10599l = "";
        this.f10600m = "";
        this.f10601n = "";
        this.f10602o = true;
        this.f10603p = 0;
        this.f10604q = "success";
        this.f10605r = "";
        this.f10606s = 0;
        this.f10607t = 0.0d;
        this.f10608u = 0.0d;
        this.f10609v = 0.0d;
        this.f10610w = 0.0f;
        this.f10611x = 0.0f;
        this.f10612y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.f10588a = "";
        this.f10589b = "";
        this.f10590c = new AMapLocationQualityReport();
        this.G = "GCJ02";
        this.H = 1;
        this.f10607t = location.getLatitude();
        this.f10608u = location.getLongitude();
        this.f10609v = location.getAltitude();
        this.f10611x = location.getBearing();
        this.f10610w = location.getSpeed();
        this.f10613z = location.getProvider();
        this.f10612y = location.getExtras() != null ? new Bundle(location.getExtras()) : null;
    }
}
