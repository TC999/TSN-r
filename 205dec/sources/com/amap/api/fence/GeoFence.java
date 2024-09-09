package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.j;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final String BUNDLE_KEY_CUSTOMID = "customId";
    public static final String BUNDLE_KEY_FENCE = "fence";
    public static final String BUNDLE_KEY_FENCEID = "fenceid";
    public static final String BUNDLE_KEY_FENCESTATUS = "event";
    public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final Parcelable.Creator<GeoFence> CREATOR = new Parcelable.Creator<GeoFence>() { // from class: com.amap.api.fence.GeoFence.1
        private static GeoFence a(Parcel parcel) {
            return new GeoFence(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence[] newArray(int i4) {
            return a(i4);
        }

        private static GeoFence[] a(int i4) {
            return new GeoFence[i4];
        }
    };
    public static final int ERROR_CODE_EXISTS = 17;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int ERROR_NO_VALIDFENCE = 16;
    public static final int STATUS_IN = 1;
    public static final int STATUS_LOCFAIL = 4;
    public static final int STATUS_OUT = 2;
    public static final int STATUS_STAYED = 3;
    public static final int STATUS_UNKNOWN = 0;
    public static final int TYPE_AMAPPOI = 2;
    public static final int TYPE_DISTRICT = 3;
    public static final int TYPE_POLYGON = 1;
    public static final int TYPE_ROUND = 0;

    /* renamed from: a  reason: collision with root package name */
    private String f10557a;

    /* renamed from: b  reason: collision with root package name */
    private String f10558b;

    /* renamed from: c  reason: collision with root package name */
    private String f10559c;

    /* renamed from: d  reason: collision with root package name */
    private PendingIntent f10560d;

    /* renamed from: e  reason: collision with root package name */
    private int f10561e;

    /* renamed from: f  reason: collision with root package name */
    private PoiItem f10562f;

    /* renamed from: g  reason: collision with root package name */
    private List<DistrictItem> f10563g;

    /* renamed from: h  reason: collision with root package name */
    private List<List<DPoint>> f10564h;

    /* renamed from: i  reason: collision with root package name */
    private float f10565i;

    /* renamed from: j  reason: collision with root package name */
    private long f10566j;

    /* renamed from: k  reason: collision with root package name */
    private int f10567k;

    /* renamed from: l  reason: collision with root package name */
    private float f10568l;

    /* renamed from: m  reason: collision with root package name */
    private float f10569m;

    /* renamed from: n  reason: collision with root package name */
    private DPoint f10570n;

    /* renamed from: o  reason: collision with root package name */
    private int f10571o;

    /* renamed from: p  reason: collision with root package name */
    private long f10572p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10573q;

    /* renamed from: r  reason: collision with root package name */
    private AMapLocation f10574r;

    public GeoFence() {
        this.f10560d = null;
        this.f10561e = 0;
        this.f10562f = null;
        this.f10563g = null;
        this.f10565i = 0.0f;
        this.f10566j = -1L;
        this.f10567k = 1;
        this.f10568l = 0.0f;
        this.f10569m = 0.0f;
        this.f10570n = null;
        this.f10571o = 0;
        this.f10572p = -1L;
        this.f10573q = true;
        this.f10574r = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GeoFence) {
            GeoFence geoFence = (GeoFence) obj;
            if (TextUtils.isEmpty(this.f10558b)) {
                if (!TextUtils.isEmpty(geoFence.f10558b)) {
                    return false;
                }
            } else if (!this.f10558b.equals(geoFence.f10558b)) {
                return false;
            }
            DPoint dPoint = this.f10570n;
            if (dPoint == null) {
                if (geoFence.f10570n != null) {
                    return false;
                }
            } else if (!dPoint.equals(geoFence.f10570n)) {
                return false;
            }
            if (this.f10565i != geoFence.f10565i) {
                return false;
            }
            List<List<DPoint>> list = this.f10564h;
            return list == null ? geoFence.f10564h == null : list.equals(geoFence.f10564h);
        }
        return false;
    }

    public int getActivatesAction() {
        return this.f10567k;
    }

    public DPoint getCenter() {
        return this.f10570n;
    }

    public AMapLocation getCurrentLocation() {
        return this.f10574r;
    }

    public String getCustomId() {
        return this.f10558b;
    }

    public List<DistrictItem> getDistrictItemList() {
        return this.f10563g;
    }

    public long getEnterTime() {
        return this.f10572p;
    }

    public long getExpiration() {
        return this.f10566j;
    }

    public String getFenceId() {
        return this.f10557a;
    }

    public float getMaxDis2Center() {
        return this.f10569m;
    }

    public float getMinDis2Center() {
        return this.f10568l;
    }

    public PendingIntent getPendingIntent() {
        return this.f10560d;
    }

    public String getPendingIntentAction() {
        return this.f10559c;
    }

    public PoiItem getPoiItem() {
        return this.f10562f;
    }

    public List<List<DPoint>> getPointList() {
        return this.f10564h;
    }

    public float getRadius() {
        return this.f10565i;
    }

    public int getStatus() {
        return this.f10571o;
    }

    public int getType() {
        return this.f10561e;
    }

    public int hashCode() {
        return this.f10558b.hashCode() + this.f10564h.hashCode() + this.f10570n.hashCode() + ((int) (this.f10565i * 100.0f));
    }

    public boolean isAble() {
        return this.f10573q;
    }

    public void setAble(boolean z3) {
        this.f10573q = z3;
    }

    public void setActivatesAction(int i4) {
        this.f10567k = i4;
    }

    public void setCenter(DPoint dPoint) {
        this.f10570n = dPoint;
    }

    public void setCurrentLocation(AMapLocation aMapLocation) {
        this.f10574r = aMapLocation.m15clone();
    }

    public void setCustomId(String str) {
        this.f10558b = str;
    }

    public void setDistrictItemList(List<DistrictItem> list) {
        this.f10563g = list;
    }

    public void setEnterTime(long j4) {
        this.f10572p = j4;
    }

    public void setExpiration(long j4) {
        if (j4 < 0) {
            this.f10566j = -1L;
        } else {
            this.f10566j = j4 + j.b();
        }
    }

    public void setFenceId(String str) {
        this.f10557a = str;
    }

    public void setMaxDis2Center(float f4) {
        this.f10569m = f4;
    }

    public void setMinDis2Center(float f4) {
        this.f10568l = f4;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.f10560d = pendingIntent;
    }

    public void setPendingIntentAction(String str) {
        this.f10559c = str;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.f10562f = poiItem;
    }

    public void setPointList(List<List<DPoint>> list) {
        this.f10564h = list;
    }

    public void setRadius(float f4) {
        this.f10565i = f4;
    }

    public void setStatus(int i4) {
        this.f10571o = i4;
    }

    public void setType(int i4) {
        this.f10561e = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10557a);
        parcel.writeString(this.f10558b);
        parcel.writeString(this.f10559c);
        parcel.writeParcelable(this.f10560d, i4);
        parcel.writeInt(this.f10561e);
        parcel.writeParcelable(this.f10562f, i4);
        parcel.writeTypedList(this.f10563g);
        parcel.writeFloat(this.f10565i);
        parcel.writeLong(this.f10566j);
        parcel.writeInt(this.f10567k);
        parcel.writeFloat(this.f10568l);
        parcel.writeFloat(this.f10569m);
        parcel.writeParcelable(this.f10570n, i4);
        parcel.writeInt(this.f10571o);
        parcel.writeLong(this.f10572p);
        List<List<DPoint>> list = this.f10564h;
        if (list != null && !list.isEmpty()) {
            parcel.writeInt(this.f10564h.size());
            for (List<DPoint> list2 : this.f10564h) {
                parcel.writeTypedList(list2);
            }
        }
        parcel.writeByte(this.f10573q ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f10574r, i4);
    }

    protected GeoFence(Parcel parcel) {
        this.f10560d = null;
        this.f10561e = 0;
        this.f10562f = null;
        this.f10563g = null;
        this.f10565i = 0.0f;
        this.f10566j = -1L;
        this.f10567k = 1;
        this.f10568l = 0.0f;
        this.f10569m = 0.0f;
        this.f10570n = null;
        this.f10571o = 0;
        this.f10572p = -1L;
        this.f10573q = true;
        this.f10574r = null;
        this.f10557a = parcel.readString();
        this.f10558b = parcel.readString();
        this.f10559c = parcel.readString();
        this.f10560d = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.f10561e = parcel.readInt();
        this.f10562f = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        this.f10563g = parcel.createTypedArrayList(DistrictItem.CREATOR);
        this.f10565i = parcel.readFloat();
        this.f10566j = parcel.readLong();
        this.f10567k = parcel.readInt();
        this.f10568l = parcel.readFloat();
        this.f10569m = parcel.readFloat();
        this.f10570n = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        this.f10571o = parcel.readInt();
        this.f10572p = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt != 0) {
            this.f10564h = new ArrayList();
            for (int i4 = 0; i4 < readInt; i4++) {
                this.f10564h.add(parcel.createTypedArrayList(DPoint.CREATOR));
            }
        }
        this.f10573q = parcel.readByte() != 0;
        this.f10574r = (AMapLocation) parcel.readParcelable(AMapLocation.class.getClassLoader());
    }
}
