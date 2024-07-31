package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.services.core.PoiItem.1
        /* renamed from: a */
        private static PoiItem m51885a(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem createFromParcel(Parcel parcel) {
            return m51885a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem[] newArray(int i) {
            return m51886a(i);
        }

        /* renamed from: a */
        private static PoiItem[] m51886a(int i) {
            return new PoiItem[i];
        }
    };

    /* renamed from: A */
    private String f7270A;

    /* renamed from: B */
    private String f7271B;

    /* renamed from: a */
    private String f7272a;

    /* renamed from: b */
    private String f7273b;

    /* renamed from: c */
    private String f7274c;

    /* renamed from: d */
    private String f7275d;

    /* renamed from: e */
    private String f7276e;

    /* renamed from: f */
    private int f7277f;

    /* renamed from: g */
    private final LatLonPoint f7278g;

    /* renamed from: h */
    private final String f7279h;

    /* renamed from: i */
    private final String f7280i;

    /* renamed from: j */
    private LatLonPoint f7281j;

    /* renamed from: k */
    private LatLonPoint f7282k;

    /* renamed from: l */
    private String f7283l;

    /* renamed from: m */
    private String f7284m;

    /* renamed from: n */
    private String f7285n;

    /* renamed from: o */
    private String f7286o;

    /* renamed from: p */
    private String f7287p;

    /* renamed from: q */
    private String f7288q;

    /* renamed from: r */
    private String f7289r;

    /* renamed from: s */
    private boolean f7290s;

    /* renamed from: t */
    private IndoorData f7291t;

    /* renamed from: u */
    private String f7292u;

    /* renamed from: v */
    private String f7293v;

    /* renamed from: w */
    private String f7294w;

    /* renamed from: x */
    private List<SubPoiItem> f7295x;

    /* renamed from: y */
    private List<Photo> f7296y;

    /* renamed from: z */
    private PoiItemExtension f7297z;

    public PoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f7276e = "";
        this.f7277f = -1;
        this.f7295x = new ArrayList();
        this.f7296y = new ArrayList();
        this.f7272a = str;
        this.f7278g = latLonPoint;
        this.f7279h = str2;
        this.f7280i = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PoiItem poiItem = (PoiItem) obj;
            String str = this.f7272a;
            if (str == null) {
                if (poiItem.f7272a != null) {
                    return false;
                }
            } else if (!str.equals(poiItem.f7272a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getAdCode() {
        return this.f7274c;
    }

    public String getAdName() {
        return this.f7289r;
    }

    public String getBusinessArea() {
        return this.f7293v;
    }

    public String getCityCode() {
        return this.f7275d;
    }

    public String getCityName() {
        return this.f7288q;
    }

    public String getDirection() {
        return this.f7286o;
    }

    public int getDistance() {
        return this.f7277f;
    }

    public String getEmail() {
        return this.f7285n;
    }

    public LatLonPoint getEnter() {
        return this.f7281j;
    }

    public LatLonPoint getExit() {
        return this.f7282k;
    }

    public IndoorData getIndoorData() {
        return this.f7291t;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f7278g;
    }

    public String getParkingType() {
        return this.f7294w;
    }

    public List<Photo> getPhotos() {
        return this.f7296y;
    }

    public PoiItemExtension getPoiExtension() {
        return this.f7297z;
    }

    public String getPoiId() {
        return this.f7272a;
    }

    public String getPostcode() {
        return this.f7284m;
    }

    public String getProvinceCode() {
        return this.f7292u;
    }

    public String getProvinceName() {
        return this.f7287p;
    }

    public String getShopID() {
        return this.f7271B;
    }

    public String getSnippet() {
        return this.f7280i;
    }

    public List<SubPoiItem> getSubPois() {
        return this.f7295x;
    }

    public String getTel() {
        return this.f7273b;
    }

    public String getTitle() {
        return this.f7279h;
    }

    public String getTypeCode() {
        return this.f7270A;
    }

    public String getTypeDes() {
        return this.f7276e;
    }

    public String getWebsite() {
        return this.f7283l;
    }

    public int hashCode() {
        String str = this.f7272a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public boolean isIndoorMap() {
        return this.f7290s;
    }

    public void setAdCode(String str) {
        this.f7274c = str;
    }

    public void setAdName(String str) {
        this.f7289r = str;
    }

    public void setBusinessArea(String str) {
        this.f7293v = str;
    }

    public void setCityCode(String str) {
        this.f7275d = str;
    }

    public void setCityName(String str) {
        this.f7288q = str;
    }

    public void setDirection(String str) {
        this.f7286o = str;
    }

    public void setDistance(int i) {
        this.f7277f = i;
    }

    public void setEmail(String str) {
        this.f7285n = str;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f7281j = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f7282k = latLonPoint;
    }

    public void setIndoorDate(IndoorData indoorData) {
        this.f7291t = indoorData;
    }

    public void setIndoorMap(boolean z) {
        this.f7290s = z;
    }

    public void setParkingType(String str) {
        this.f7294w = str;
    }

    public void setPhotos(List<Photo> list) {
        this.f7296y = list;
    }

    public void setPoiExtension(PoiItemExtension poiItemExtension) {
        this.f7297z = poiItemExtension;
    }

    public void setPostcode(String str) {
        this.f7284m = str;
    }

    public void setProvinceCode(String str) {
        this.f7292u = str;
    }

    public void setProvinceName(String str) {
        this.f7287p = str;
    }

    public void setShopID(String str) {
        this.f7271B = str;
    }

    public void setSubPois(List<SubPoiItem> list) {
        this.f7295x = list;
    }

    public void setTel(String str) {
        this.f7273b = str;
    }

    public void setTypeCode(String str) {
        this.f7270A = str;
    }

    public void setTypeDes(String str) {
        this.f7276e = str;
    }

    public void setWebsite(String str) {
        this.f7283l = str;
    }

    public String toString() {
        return this.f7279h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7272a);
        parcel.writeString(this.f7274c);
        parcel.writeString(this.f7273b);
        parcel.writeString(this.f7276e);
        parcel.writeInt(this.f7277f);
        parcel.writeValue(this.f7278g);
        parcel.writeString(this.f7279h);
        parcel.writeString(this.f7280i);
        parcel.writeString(this.f7275d);
        parcel.writeValue(this.f7281j);
        parcel.writeValue(this.f7282k);
        parcel.writeString(this.f7283l);
        parcel.writeString(this.f7284m);
        parcel.writeString(this.f7285n);
        parcel.writeBooleanArray(new boolean[]{this.f7290s});
        parcel.writeString(this.f7286o);
        parcel.writeString(this.f7287p);
        parcel.writeString(this.f7288q);
        parcel.writeString(this.f7289r);
        parcel.writeString(this.f7292u);
        parcel.writeString(this.f7293v);
        parcel.writeString(this.f7294w);
        parcel.writeList(this.f7295x);
        parcel.writeValue(this.f7291t);
        parcel.writeTypedList(this.f7296y);
        parcel.writeParcelable(this.f7297z, i);
        parcel.writeString(this.f7270A);
        parcel.writeString(this.f7271B);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiItem(Parcel parcel) {
        this.f7276e = "";
        this.f7277f = -1;
        this.f7295x = new ArrayList();
        this.f7296y = new ArrayList();
        this.f7272a = parcel.readString();
        this.f7274c = parcel.readString();
        this.f7273b = parcel.readString();
        this.f7276e = parcel.readString();
        this.f7277f = parcel.readInt();
        this.f7278g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7279h = parcel.readString();
        this.f7280i = parcel.readString();
        this.f7275d = parcel.readString();
        this.f7281j = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7282k = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7283l = parcel.readString();
        this.f7284m = parcel.readString();
        this.f7285n = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f7290s = zArr[0];
        this.f7286o = parcel.readString();
        this.f7287p = parcel.readString();
        this.f7288q = parcel.readString();
        this.f7289r = parcel.readString();
        this.f7292u = parcel.readString();
        this.f7293v = parcel.readString();
        this.f7294w = parcel.readString();
        this.f7295x = parcel.readArrayList(SubPoiItem.class.getClassLoader());
        this.f7291t = (IndoorData) parcel.readValue(IndoorData.class.getClassLoader());
        this.f7296y = parcel.createTypedArrayList(Photo.CREATOR);
        this.f7297z = (PoiItemExtension) parcel.readParcelable(PoiItemExtension.class.getClassLoader());
        this.f7270A = parcel.readString();
        this.f7271B = parcel.readString();
    }
}
