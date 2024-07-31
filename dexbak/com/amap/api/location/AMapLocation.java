package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.github.mikephil.charting.utils.Utils;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.UContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AMapLocation extends Location implements Parcelable, Cloneable {
    public static final String COORD_TYPE_GCJ02 = "GCJ02";
    public static final String COORD_TYPE_WGS84 = "WGS84";
    public static final Parcelable.Creator<AMapLocation> CREATOR = new Parcelable.Creator<AMapLocation>() { // from class: com.amap.api.location.AMapLocation.1
        /* renamed from: a */
        private static AMapLocation m52134a(Parcel parcel) {
            AMapLocation aMapLocation = new AMapLocation((Location) Location.CREATOR.createFromParcel(parcel));
            aMapLocation.f6881h = parcel.readString();
            aMapLocation.f6882i = parcel.readString();
            aMapLocation.f6866B = parcel.readString();
            aMapLocation.f6874a = parcel.readString();
            aMapLocation.f6878e = parcel.readString();
            aMapLocation.f6880g = parcel.readString();
            aMapLocation.f6884k = parcel.readString();
            aMapLocation.f6879f = parcel.readString();
            aMapLocation.f6889p = parcel.readInt();
            aMapLocation.f6890q = parcel.readString();
            aMapLocation.f6875b = parcel.readString();
            aMapLocation.f6870F = parcel.readInt() != 0;
            aMapLocation.f6888o = parcel.readInt() != 0;
            aMapLocation.f6893t = parcel.readDouble();
            aMapLocation.f6891r = parcel.readString();
            aMapLocation.f6892s = parcel.readInt();
            aMapLocation.f6894u = parcel.readDouble();
            aMapLocation.f6868D = parcel.readInt() != 0;
            aMapLocation.f6887n = parcel.readString();
            aMapLocation.f6883j = parcel.readString();
            aMapLocation.f6877d = parcel.readString();
            aMapLocation.f6885l = parcel.readString();
            aMapLocation.f6865A = parcel.readInt();
            aMapLocation.f6867C = parcel.readInt();
            aMapLocation.f6886m = parcel.readString();
            aMapLocation.f6869E = parcel.readString();
            aMapLocation.f6871G = parcel.readString();
            aMapLocation.f6872H = parcel.readInt();
            aMapLocation.f6873I = parcel.readInt();
            return aMapLocation;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation createFromParcel(Parcel parcel) {
            return m52134a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation[] newArray(int i) {
            return m52135a(i);
        }

        /* renamed from: a */
        private static AMapLocation[] m52135a(int i) {
            return new AMapLocation[i];
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

    /* renamed from: A */
    private int f6865A;

    /* renamed from: B */
    private String f6866B;

    /* renamed from: C */
    private int f6867C;

    /* renamed from: D */
    private boolean f6868D;

    /* renamed from: E */
    private String f6869E;

    /* renamed from: F */
    private boolean f6870F;

    /* renamed from: G */
    private String f6871G;

    /* renamed from: H */
    private int f6872H;

    /* renamed from: I */
    private int f6873I;

    /* renamed from: a */
    protected String f6874a;

    /* renamed from: b */
    protected String f6875b;

    /* renamed from: c */
    AMapLocationQualityReport f6876c;

    /* renamed from: d */
    private String f6877d;

    /* renamed from: e */
    private String f6878e;

    /* renamed from: f */
    private String f6879f;

    /* renamed from: g */
    private String f6880g;

    /* renamed from: h */
    private String f6881h;

    /* renamed from: i */
    private String f6882i;

    /* renamed from: j */
    private String f6883j;

    /* renamed from: k */
    private String f6884k;

    /* renamed from: l */
    private String f6885l;

    /* renamed from: m */
    private String f6886m;

    /* renamed from: n */
    private String f6887n;

    /* renamed from: o */
    private boolean f6888o;

    /* renamed from: p */
    private int f6889p;

    /* renamed from: q */
    private String f6890q;

    /* renamed from: r */
    private String f6891r;

    /* renamed from: s */
    private int f6892s;

    /* renamed from: t */
    private double f6893t;

    /* renamed from: u */
    private double f6894u;

    /* renamed from: v */
    private double f6895v;

    /* renamed from: w */
    private float f6896w;

    /* renamed from: x */
    private float f6897x;

    /* renamed from: y */
    private Bundle f6898y;

    /* renamed from: z */
    private String f6899z;

    public AMapLocation(String str) {
        super(str);
        this.f6877d = "";
        this.f6878e = "";
        this.f6879f = "";
        this.f6880g = "";
        this.f6881h = "";
        this.f6882i = "";
        this.f6883j = "";
        this.f6884k = "";
        this.f6885l = "";
        this.f6886m = "";
        this.f6887n = "";
        this.f6888o = true;
        this.f6889p = 0;
        this.f6890q = "success";
        this.f6891r = "";
        this.f6892s = 0;
        this.f6893t = Utils.DOUBLE_EPSILON;
        this.f6894u = Utils.DOUBLE_EPSILON;
        this.f6895v = Utils.DOUBLE_EPSILON;
        this.f6896w = 0.0f;
        this.f6897x = 0.0f;
        this.f6898y = null;
        this.f6865A = 0;
        this.f6866B = "";
        this.f6867C = -1;
        this.f6868D = false;
        this.f6869E = "";
        this.f6870F = false;
        this.f6874a = "";
        this.f6875b = "";
        this.f6876c = new AMapLocationQualityReport();
        this.f6871G = COORD_TYPE_GCJ02;
        this.f6872H = 1;
        this.f6899z = str;
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
        return this.f6881h;
    }

    public String getAddress() {
        return this.f6882i;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return this.f6895v;
    }

    public String getAoiName() {
        return this.f6866B;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.f6897x;
    }

    public String getBuildingId() {
        return this.f6874a;
    }

    public String getCity() {
        return this.f6878e;
    }

    public String getCityCode() {
        return this.f6880g;
    }

    public int getConScenario() {
        return this.f6873I;
    }

    public String getCoordType() {
        return this.f6871G;
    }

    public String getCountry() {
        return this.f6884k;
    }

    public String getDescription() {
        return this.f6869E;
    }

    public String getDistrict() {
        return this.f6879f;
    }

    public int getErrorCode() {
        return this.f6889p;
    }

    public String getErrorInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6890q);
        if (this.f6889p != 0) {
            sb.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            sb.append(",错误详细信息:" + this.f6891r);
        }
        return sb.toString();
    }

    @Override // android.location.Location
    public Bundle getExtras() {
        return this.f6898y;
    }

    public String getFloor() {
        return this.f6875b;
    }

    public int getGpsAccuracyStatus() {
        return this.f6867C;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.f6893t;
    }

    public String getLocationDetail() {
        return this.f6891r;
    }

    public AMapLocationQualityReport getLocationQualityReport() {
        return this.f6876c;
    }

    public int getLocationType() {
        return this.f6892s;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.f6894u;
    }

    public String getPoiName() {
        return this.f6883j;
    }

    @Override // android.location.Location
    public String getProvider() {
        return this.f6899z;
    }

    public String getProvince() {
        return this.f6877d;
    }

    public String getRoad() {
        return this.f6885l;
    }

    public int getSatellites() {
        return this.f6865A;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.f6896w;
    }

    public String getStreet() {
        return this.f6886m;
    }

    public String getStreetNum() {
        return this.f6887n;
    }

    public int getTrustedLevel() {
        return this.f6872H;
    }

    public boolean isFixLastLocation() {
        return this.f6870F;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.f6868D;
    }

    public boolean isOffset() {
        return this.f6888o;
    }

    public void setAdCode(String str) {
        this.f6881h = str;
    }

    public void setAddress(String str) {
        this.f6882i = str;
    }

    @Override // android.location.Location
    public void setAltitude(double d) {
        super.setAltitude(d);
        this.f6895v = d;
    }

    public void setAoiName(String str) {
        this.f6866B = str;
    }

    @Override // android.location.Location
    public void setBearing(float f) {
        super.setBearing(f);
        while (f < 0.0f) {
            f += 360.0f;
        }
        while (f >= 360.0f) {
            f -= 360.0f;
        }
        this.f6897x = f;
    }

    public void setBuildingId(String str) {
        this.f6874a = str;
    }

    public void setCity(String str) {
        this.f6878e = str;
    }

    public void setCityCode(String str) {
        this.f6880g = str;
    }

    public void setConScenario(int i) {
        this.f6873I = i;
    }

    public void setCoordType(String str) {
        this.f6871G = str;
    }

    public void setCountry(String str) {
        this.f6884k = str;
    }

    public void setDescription(String str) {
        this.f6869E = str;
    }

    public void setDistrict(String str) {
        this.f6879f = str;
    }

    public void setErrorCode(int i) {
        if (this.f6889p != 0) {
            return;
        }
        this.f6890q = C2432j.m51208a(i);
        this.f6889p = i;
    }

    public void setErrorInfo(String str) {
        this.f6890q = str;
    }

    @Override // android.location.Location
    public void setExtras(Bundle bundle) {
        super.setExtras(bundle);
        this.f6898y = bundle == null ? null : new Bundle(bundle);
    }

    public void setFixLastLocation(boolean z) {
        this.f6870F = z;
    }

    public void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                C2428b.m51299a(th, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.f6875b = str;
    }

    public void setGpsAccuracyStatus(int i) {
        this.f6867C = i;
    }

    @Override // android.location.Location
    public void setLatitude(double d) {
        this.f6893t = d;
    }

    public void setLocationDetail(String str) {
        this.f6891r = str;
    }

    public void setLocationQualityReport(AMapLocationQualityReport aMapLocationQualityReport) {
        if (aMapLocationQualityReport == null) {
            return;
        }
        this.f6876c = aMapLocationQualityReport;
    }

    public void setLocationType(int i) {
        this.f6892s = i;
    }

    @Override // android.location.Location
    public void setLongitude(double d) {
        this.f6894u = d;
    }

    @Override // android.location.Location
    public void setMock(boolean z) {
        this.f6868D = z;
    }

    public void setNumber(String str) {
        this.f6887n = str;
    }

    public void setOffset(boolean z) {
        this.f6888o = z;
    }

    public void setPoiName(String str) {
        this.f6883j = str;
    }

    @Override // android.location.Location
    public void setProvider(String str) {
        super.setProvider(str);
        this.f6899z = str;
    }

    public void setProvince(String str) {
        this.f6877d = str;
    }

    public void setRoad(String str) {
        this.f6885l = str;
    }

    public void setSatellites(int i) {
        this.f6865A = i;
    }

    @Override // android.location.Location
    public void setSpeed(float f) {
        super.setSpeed(f);
        this.f6896w = f;
    }

    public void setStreet(String str) {
        this.f6886m = str;
    }

    public void setTrustedLevel(int i) {
        this.f6872H = i;
    }

    public JSONObject toJson(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i == 1) {
                try {
                    jSONObject.put("altitude", getAltitude());
                    jSONObject.put("speed", getSpeed());
                    jSONObject.put("bearing", getBearing());
                } catch (Throwable unused) {
                }
                jSONObject.put("citycode", this.f6880g);
                jSONObject.put("adcode", this.f6881h);
                jSONObject.put("country", this.f6884k);
                jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, this.f6877d);
                jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.f6878e);
                jSONObject.put(DistrictSearchQuery.KEYWORDS_DISTRICT, this.f6879f);
                jSONObject.put("road", this.f6885l);
                jSONObject.put("street", this.f6886m);
                jSONObject.put("number", this.f6887n);
                jSONObject.put("poiname", this.f6883j);
                jSONObject.put("errorCode", this.f6889p);
                jSONObject.put(MyLocationStyle.ERROR_INFO, this.f6890q);
                jSONObject.put(MyLocationStyle.LOCATION_TYPE, this.f6892s);
                jSONObject.put("locationDetail", this.f6891r);
                jSONObject.put("aoiname", this.f6866B);
                jSONObject.put("address", this.f6882i);
                jSONObject.put("poiid", this.f6874a);
                jSONObject.put("floor", this.f6875b);
                jSONObject.put(SocialConstants.PARAM_COMMENT, this.f6869E);
            } else if (i != 2) {
                if (i != 3) {
                    return jSONObject;
                }
                jSONObject.put(UContent.f38082M, getProvider());
                jSONObject.put("lon", getLongitude());
                jSONObject.put(UContent.f38072C, getLatitude());
                jSONObject.put("accuracy", getAccuracy());
                jSONObject.put("isOffset", this.f6888o);
                jSONObject.put("isFixLastLocation", this.f6870F);
                jSONObject.put("coordType", this.f6871G);
                return jSONObject;
            }
            jSONObject.put(RtspHeaders.Values.TIME, getTime());
            jSONObject.put(UContent.f38082M, getProvider());
            jSONObject.put("lon", getLongitude());
            jSONObject.put(UContent.f38072C, getLatitude());
            jSONObject.put("accuracy", getAccuracy());
            jSONObject.put("isOffset", this.f6888o);
            jSONObject.put("isFixLastLocation", this.f6870F);
            jSONObject.put("coordType", this.f6871G);
            return jSONObject;
        } catch (Throwable th) {
            C2428b.m51299a(th, "AmapLoc", "toStr");
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
            stringBuffer.append("latitude=" + this.f6893t + "#");
            stringBuffer.append("longitude=" + this.f6894u + "#");
            stringBuffer.append("province=" + this.f6877d + "#");
            stringBuffer.append("coordType=" + this.f6871G + "#");
            stringBuffer.append("city=" + this.f6878e + "#");
            stringBuffer.append("district=" + this.f6879f + "#");
            stringBuffer.append("cityCode=" + this.f6880g + "#");
            stringBuffer.append("adCode=" + this.f6881h + "#");
            stringBuffer.append("address=" + this.f6882i + "#");
            stringBuffer.append("country=" + this.f6884k + "#");
            stringBuffer.append("road=" + this.f6885l + "#");
            stringBuffer.append("poiName=" + this.f6883j + "#");
            stringBuffer.append("street=" + this.f6886m + "#");
            stringBuffer.append("streetNum=" + this.f6887n + "#");
            stringBuffer.append("aoiName=" + this.f6866B + "#");
            stringBuffer.append("poiid=" + this.f6874a + "#");
            stringBuffer.append("floor=" + this.f6875b + "#");
            stringBuffer.append("errorCode=" + this.f6889p + "#");
            stringBuffer.append("errorInfo=" + this.f6890q + "#");
            stringBuffer.append("locationDetail=" + this.f6891r + "#");
            stringBuffer.append("description=" + this.f6869E + "#");
            stringBuffer.append("locationType=" + this.f6892s + "#");
            StringBuilder sb = new StringBuilder("conScenario=");
            sb.append(this.f6873I);
            stringBuffer.append(sb.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @Override // android.location.Location, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f6881h);
            parcel.writeString(this.f6882i);
            parcel.writeString(this.f6866B);
            parcel.writeString(this.f6874a);
            parcel.writeString(this.f6878e);
            parcel.writeString(this.f6880g);
            parcel.writeString(this.f6884k);
            parcel.writeString(this.f6879f);
            parcel.writeInt(this.f6889p);
            parcel.writeString(this.f6890q);
            parcel.writeString(this.f6875b);
            int i2 = 1;
            parcel.writeInt(this.f6870F ? 1 : 0);
            parcel.writeInt(this.f6888o ? 1 : 0);
            parcel.writeDouble(this.f6893t);
            parcel.writeString(this.f6891r);
            parcel.writeInt(this.f6892s);
            parcel.writeDouble(this.f6894u);
            if (!this.f6868D) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.f6887n);
            parcel.writeString(this.f6883j);
            parcel.writeString(this.f6877d);
            parcel.writeString(this.f6885l);
            parcel.writeInt(this.f6865A);
            parcel.writeInt(this.f6867C);
            parcel.writeString(this.f6886m);
            parcel.writeString(this.f6869E);
            parcel.writeString(this.f6871G);
            parcel.writeInt(this.f6872H);
            parcel.writeInt(this.f6873I);
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMapLocation", "writeToParcel");
        }
    }

    /* renamed from: clone */
    public AMapLocation m60094clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        AMapLocation aMapLocation = new AMapLocation(this);
        try {
            aMapLocation.setLatitude(this.f6893t);
            aMapLocation.setLongitude(this.f6894u);
            aMapLocation.setAdCode(this.f6881h);
            aMapLocation.setAddress(this.f6882i);
            aMapLocation.setAoiName(this.f6866B);
            aMapLocation.setBuildingId(this.f6874a);
            aMapLocation.setCity(this.f6878e);
            aMapLocation.setCityCode(this.f6880g);
            aMapLocation.setCountry(this.f6884k);
            aMapLocation.setDistrict(this.f6879f);
            aMapLocation.setErrorCode(this.f6889p);
            aMapLocation.setErrorInfo(this.f6890q);
            aMapLocation.setFloor(this.f6875b);
            aMapLocation.setFixLastLocation(this.f6870F);
            aMapLocation.setOffset(this.f6888o);
            aMapLocation.setLocationDetail(this.f6891r);
            aMapLocation.setLocationType(this.f6892s);
            aMapLocation.setMock(this.f6868D);
            aMapLocation.setNumber(this.f6887n);
            aMapLocation.setPoiName(this.f6883j);
            aMapLocation.setProvince(this.f6877d);
            aMapLocation.setRoad(this.f6885l);
            aMapLocation.setSatellites(this.f6865A);
            aMapLocation.setGpsAccuracyStatus(this.f6867C);
            aMapLocation.setStreet(this.f6886m);
            aMapLocation.setDescription(this.f6869E);
            aMapLocation.setExtras(getExtras());
            AMapLocationQualityReport aMapLocationQualityReport = this.f6876c;
            if (aMapLocationQualityReport != null) {
                aMapLocation.setLocationQualityReport(aMapLocationQualityReport.m60096clone());
            }
            aMapLocation.setCoordType(this.f6871G);
            aMapLocation.setTrustedLevel(this.f6872H);
            aMapLocation.setConScenario(this.f6873I);
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMapLocation", "clone");
        }
        return aMapLocation;
    }

    public String toStr(int i) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i);
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public AMapLocation(Location location) {
        super(location);
        this.f6877d = "";
        this.f6878e = "";
        this.f6879f = "";
        this.f6880g = "";
        this.f6881h = "";
        this.f6882i = "";
        this.f6883j = "";
        this.f6884k = "";
        this.f6885l = "";
        this.f6886m = "";
        this.f6887n = "";
        this.f6888o = true;
        this.f6889p = 0;
        this.f6890q = "success";
        this.f6891r = "";
        this.f6892s = 0;
        this.f6893t = Utils.DOUBLE_EPSILON;
        this.f6894u = Utils.DOUBLE_EPSILON;
        this.f6895v = Utils.DOUBLE_EPSILON;
        this.f6896w = 0.0f;
        this.f6897x = 0.0f;
        this.f6898y = null;
        this.f6865A = 0;
        this.f6866B = "";
        this.f6867C = -1;
        this.f6868D = false;
        this.f6869E = "";
        this.f6870F = false;
        this.f6874a = "";
        this.f6875b = "";
        this.f6876c = new AMapLocationQualityReport();
        this.f6871G = COORD_TYPE_GCJ02;
        this.f6872H = 1;
        this.f6893t = location.getLatitude();
        this.f6894u = location.getLongitude();
        this.f6895v = location.getAltitude();
        this.f6897x = location.getBearing();
        this.f6896w = location.getSpeed();
        this.f6899z = location.getProvider();
        this.f6898y = location.getExtras() != null ? new Bundle(location.getExtras()) : null;
    }
}
