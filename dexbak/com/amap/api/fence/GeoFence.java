package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.C2432j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final String BUNDLE_KEY_CUSTOMID = "customId";
    public static final String BUNDLE_KEY_FENCE = "fence";
    public static final String BUNDLE_KEY_FENCEID = "fenceid";
    public static final String BUNDLE_KEY_FENCESTATUS = "event";
    public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final Parcelable.Creator<GeoFence> CREATOR = new Parcelable.Creator<GeoFence>() { // from class: com.amap.api.fence.GeoFence.1
        /* renamed from: a */
        private static GeoFence m52166a(Parcel parcel) {
            return new GeoFence(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence createFromParcel(Parcel parcel) {
            return m52166a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence[] newArray(int i) {
            return m52167a(i);
        }

        /* renamed from: a */
        private static GeoFence[] m52167a(int i) {
            return new GeoFence[i];
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

    /* renamed from: a */
    private String f6834a;

    /* renamed from: b */
    private String f6835b;

    /* renamed from: c */
    private String f6836c;

    /* renamed from: d */
    private PendingIntent f6837d;

    /* renamed from: e */
    private int f6838e;

    /* renamed from: f */
    private PoiItem f6839f;

    /* renamed from: g */
    private List<DistrictItem> f6840g;

    /* renamed from: h */
    private List<List<DPoint>> f6841h;

    /* renamed from: i */
    private float f6842i;

    /* renamed from: j */
    private long f6843j;

    /* renamed from: k */
    private int f6844k;

    /* renamed from: l */
    private float f6845l;

    /* renamed from: m */
    private float f6846m;

    /* renamed from: n */
    private DPoint f6847n;

    /* renamed from: o */
    private int f6848o;

    /* renamed from: p */
    private long f6849p;

    /* renamed from: q */
    private boolean f6850q;

    /* renamed from: r */
    private AMapLocation f6851r;

    public GeoFence() {
        this.f6837d = null;
        this.f6838e = 0;
        this.f6839f = null;
        this.f6840g = null;
        this.f6842i = 0.0f;
        this.f6843j = -1L;
        this.f6844k = 1;
        this.f6845l = 0.0f;
        this.f6846m = 0.0f;
        this.f6847n = null;
        this.f6848o = 0;
        this.f6849p = -1L;
        this.f6850q = true;
        this.f6851r = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GeoFence) {
            GeoFence geoFence = (GeoFence) obj;
            if (TextUtils.isEmpty(this.f6835b)) {
                if (!TextUtils.isEmpty(geoFence.f6835b)) {
                    return false;
                }
            } else if (!this.f6835b.equals(geoFence.f6835b)) {
                return false;
            }
            DPoint dPoint = this.f6847n;
            if (dPoint == null) {
                if (geoFence.f6847n != null) {
                    return false;
                }
            } else if (!dPoint.equals(geoFence.f6847n)) {
                return false;
            }
            if (this.f6842i != geoFence.f6842i) {
                return false;
            }
            List<List<DPoint>> list = this.f6841h;
            return list == null ? geoFence.f6841h == null : list.equals(geoFence.f6841h);
        }
        return false;
    }

    public int getActivatesAction() {
        return this.f6844k;
    }

    public DPoint getCenter() {
        return this.f6847n;
    }

    public AMapLocation getCurrentLocation() {
        return this.f6851r;
    }

    public String getCustomId() {
        return this.f6835b;
    }

    public List<DistrictItem> getDistrictItemList() {
        return this.f6840g;
    }

    public long getEnterTime() {
        return this.f6849p;
    }

    public long getExpiration() {
        return this.f6843j;
    }

    public String getFenceId() {
        return this.f6834a;
    }

    public float getMaxDis2Center() {
        return this.f6846m;
    }

    public float getMinDis2Center() {
        return this.f6845l;
    }

    public PendingIntent getPendingIntent() {
        return this.f6837d;
    }

    public String getPendingIntentAction() {
        return this.f6836c;
    }

    public PoiItem getPoiItem() {
        return this.f6839f;
    }

    public List<List<DPoint>> getPointList() {
        return this.f6841h;
    }

    public float getRadius() {
        return this.f6842i;
    }

    public int getStatus() {
        return this.f6848o;
    }

    public int getType() {
        return this.f6838e;
    }

    public int hashCode() {
        return this.f6835b.hashCode() + this.f6841h.hashCode() + this.f6847n.hashCode() + ((int) (this.f6842i * 100.0f));
    }

    public boolean isAble() {
        return this.f6850q;
    }

    public void setAble(boolean z) {
        this.f6850q = z;
    }

    public void setActivatesAction(int i) {
        this.f6844k = i;
    }

    public void setCenter(DPoint dPoint) {
        this.f6847n = dPoint;
    }

    public void setCurrentLocation(AMapLocation aMapLocation) {
        this.f6851r = aMapLocation.m60094clone();
    }

    public void setCustomId(String str) {
        this.f6835b = str;
    }

    public void setDistrictItemList(List<DistrictItem> list) {
        this.f6840g = list;
    }

    public void setEnterTime(long j) {
        this.f6849p = j;
    }

    public void setExpiration(long j) {
        if (j < 0) {
            this.f6843j = -1L;
        } else {
            this.f6843j = j + C2432j.m51186b();
        }
    }

    public void setFenceId(String str) {
        this.f6834a = str;
    }

    public void setMaxDis2Center(float f) {
        this.f6846m = f;
    }

    public void setMinDis2Center(float f) {
        this.f6845l = f;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.f6837d = pendingIntent;
    }

    public void setPendingIntentAction(String str) {
        this.f6836c = str;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.f6839f = poiItem;
    }

    public void setPointList(List<List<DPoint>> list) {
        this.f6841h = list;
    }

    public void setRadius(float f) {
        this.f6842i = f;
    }

    public void setStatus(int i) {
        this.f6848o = i;
    }

    public void setType(int i) {
        this.f6838e = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6834a);
        parcel.writeString(this.f6835b);
        parcel.writeString(this.f6836c);
        parcel.writeParcelable(this.f6837d, i);
        parcel.writeInt(this.f6838e);
        parcel.writeParcelable(this.f6839f, i);
        parcel.writeTypedList(this.f6840g);
        parcel.writeFloat(this.f6842i);
        parcel.writeLong(this.f6843j);
        parcel.writeInt(this.f6844k);
        parcel.writeFloat(this.f6845l);
        parcel.writeFloat(this.f6846m);
        parcel.writeParcelable(this.f6847n, i);
        parcel.writeInt(this.f6848o);
        parcel.writeLong(this.f6849p);
        List<List<DPoint>> list = this.f6841h;
        if (list != null && !list.isEmpty()) {
            parcel.writeInt(this.f6841h.size());
            for (List<DPoint> list2 : this.f6841h) {
                parcel.writeTypedList(list2);
            }
        }
        parcel.writeByte(this.f6850q ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f6851r, i);
    }

    protected GeoFence(Parcel parcel) {
        this.f6837d = null;
        this.f6838e = 0;
        this.f6839f = null;
        this.f6840g = null;
        this.f6842i = 0.0f;
        this.f6843j = -1L;
        this.f6844k = 1;
        this.f6845l = 0.0f;
        this.f6846m = 0.0f;
        this.f6847n = null;
        this.f6848o = 0;
        this.f6849p = -1L;
        this.f6850q = true;
        this.f6851r = null;
        this.f6834a = parcel.readString();
        this.f6835b = parcel.readString();
        this.f6836c = parcel.readString();
        this.f6837d = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.f6838e = parcel.readInt();
        this.f6839f = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        this.f6840g = parcel.createTypedArrayList(DistrictItem.CREATOR);
        this.f6842i = parcel.readFloat();
        this.f6843j = parcel.readLong();
        this.f6844k = parcel.readInt();
        this.f6845l = parcel.readFloat();
        this.f6846m = parcel.readFloat();
        this.f6847n = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        this.f6848o = parcel.readInt();
        this.f6849p = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt != 0) {
            this.f6841h = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                this.f6841h.add(parcel.createTypedArrayList(DPoint.CREATOR));
            }
        }
        this.f6850q = parcel.readByte() != 0;
        this.f6851r = (AMapLocation) parcel.readParcelable(AMapLocation.class.getClassLoader());
    }
}
