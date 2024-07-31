package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItemV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.services.core.PoiItemV2.1
        /* renamed from: a */
        private static PoiItem m51883a(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem createFromParcel(Parcel parcel) {
            return m51883a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem[] newArray(int i) {
            return m51884a(i);
        }

        /* renamed from: a */
        private static PoiItem[] m51884a(int i) {
            return new PoiItem[i];
        }
    };

    /* renamed from: a */
    private String f7298a;

    /* renamed from: b */
    private String f7299b;

    /* renamed from: c */
    private String f7300c;

    /* renamed from: d */
    private String f7301d;

    /* renamed from: e */
    private final LatLonPoint f7302e;

    /* renamed from: f */
    private final String f7303f;

    /* renamed from: g */
    private final String f7304g;

    /* renamed from: h */
    private String f7305h;

    /* renamed from: i */
    private String f7306i;

    /* renamed from: j */
    private String f7307j;

    /* renamed from: k */
    private String f7308k;

    /* renamed from: l */
    private String f7309l;

    /* renamed from: m */
    private List<SubPoiItemV2> f7310m;

    /* renamed from: n */
    private Business f7311n;

    /* renamed from: o */
    private IndoorDataV2 f7312o;

    /* renamed from: p */
    private PoiNavi f7313p;

    /* renamed from: q */
    private List<Photo> f7314q;

    public PoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f7301d = "";
        this.f7310m = new ArrayList();
        this.f7314q = new ArrayList();
        this.f7298a = str;
        this.f7302e = latLonPoint;
        this.f7303f = str2;
        this.f7304g = str3;
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
            PoiItemV2 poiItemV2 = (PoiItemV2) obj;
            String str = this.f7298a;
            if (str == null) {
                if (poiItemV2.f7298a != null) {
                    return false;
                }
            } else if (!str.equals(poiItemV2.f7298a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getAdCode() {
        return this.f7299b;
    }

    public String getAdName() {
        return this.f7308k;
    }

    public Business getBusiness() {
        return this.f7311n;
    }

    public String getCityCode() {
        return this.f7300c;
    }

    public String getCityName() {
        return this.f7307j;
    }

    public IndoorDataV2 getIndoorData() {
        return this.f7312o;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f7302e;
    }

    public List<Photo> getPhotos() {
        return this.f7314q;
    }

    public String getPoiId() {
        return this.f7298a;
    }

    public PoiNavi getPoiNavi() {
        return this.f7313p;
    }

    public String getProvinceCode() {
        return this.f7309l;
    }

    public String getProvinceName() {
        return this.f7306i;
    }

    public String getSnippet() {
        return this.f7304g;
    }

    public List<SubPoiItemV2> getSubPois() {
        return this.f7310m;
    }

    public String getTitle() {
        return this.f7303f;
    }

    public String getTypeCode() {
        return this.f7305h;
    }

    public String getTypeDes() {
        return this.f7301d;
    }

    public int hashCode() {
        String str = this.f7298a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f7299b = str;
    }

    public void setAdName(String str) {
        this.f7308k = str;
    }

    public void setBusiness(Business business) {
        this.f7311n = business;
    }

    public void setCityCode(String str) {
        this.f7300c = str;
    }

    public void setCityName(String str) {
        this.f7307j = str;
    }

    public void setIndoorData(IndoorDataV2 indoorDataV2) {
        this.f7312o = indoorDataV2;
    }

    public void setPhotos(List<Photo> list) {
        this.f7314q = list;
    }

    public void setPoiNavi(PoiNavi poiNavi) {
        this.f7313p = poiNavi;
    }

    public void setProvinceCode(String str) {
        this.f7309l = str;
    }

    public void setProvinceName(String str) {
        this.f7306i = str;
    }

    public void setSubPois(List<SubPoiItemV2> list) {
        this.f7310m = list;
    }

    public void setTypeCode(String str) {
        this.f7305h = str;
    }

    public void setTypeDes(String str) {
        this.f7301d = str;
    }

    public String toString() {
        return this.f7303f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7298a);
        parcel.writeString(this.f7299b);
        parcel.writeString(this.f7301d);
        parcel.writeValue(this.f7302e);
        parcel.writeString(this.f7303f);
        parcel.writeString(this.f7304g);
        parcel.writeString(this.f7300c);
        parcel.writeString(this.f7306i);
        parcel.writeString(this.f7307j);
        parcel.writeString(this.f7308k);
        parcel.writeString(this.f7309l);
        parcel.writeString(this.f7305h);
        parcel.writeList(this.f7310m);
        parcel.writeValue(this.f7311n);
        parcel.writeValue(this.f7312o);
        parcel.writeValue(this.f7313p);
        parcel.writeTypedList(this.f7314q);
    }

    protected PoiItemV2(Parcel parcel) {
        this.f7301d = "";
        this.f7310m = new ArrayList();
        this.f7314q = new ArrayList();
        this.f7298a = parcel.readString();
        this.f7299b = parcel.readString();
        this.f7301d = parcel.readString();
        this.f7302e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7303f = parcel.readString();
        this.f7304g = parcel.readString();
        this.f7300c = parcel.readString();
        this.f7306i = parcel.readString();
        this.f7307j = parcel.readString();
        this.f7308k = parcel.readString();
        this.f7309l = parcel.readString();
        this.f7305h = parcel.readString();
        this.f7310m = parcel.readArrayList(SubPoiItemV2.class.getClassLoader());
        this.f7311n = (Business) parcel.readValue(Business.class.getClassLoader());
        this.f7312o = (IndoorDataV2) parcel.readValue(IndoorDataV2.class.getClassLoader());
        this.f7313p = (PoiNavi) parcel.readValue(PoiNavi.class.getClassLoader());
        this.f7314q = parcel.createTypedArrayList(Photo.CREATOR);
    }
}
