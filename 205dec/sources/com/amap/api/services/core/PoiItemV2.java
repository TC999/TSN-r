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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.services.core.PoiItemV2.1
        private static PoiItem a(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem[] newArray(int i4) {
            return a(i4);
        }

        private static PoiItem[] a(int i4) {
            return new PoiItem[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10992a;

    /* renamed from: b  reason: collision with root package name */
    private String f10993b;

    /* renamed from: c  reason: collision with root package name */
    private String f10994c;

    /* renamed from: d  reason: collision with root package name */
    private String f10995d;

    /* renamed from: e  reason: collision with root package name */
    private final LatLonPoint f10996e;

    /* renamed from: f  reason: collision with root package name */
    private final String f10997f;

    /* renamed from: g  reason: collision with root package name */
    private final String f10998g;

    /* renamed from: h  reason: collision with root package name */
    private String f10999h;

    /* renamed from: i  reason: collision with root package name */
    private String f11000i;

    /* renamed from: j  reason: collision with root package name */
    private String f11001j;

    /* renamed from: k  reason: collision with root package name */
    private String f11002k;

    /* renamed from: l  reason: collision with root package name */
    private String f11003l;

    /* renamed from: m  reason: collision with root package name */
    private List<SubPoiItemV2> f11004m;

    /* renamed from: n  reason: collision with root package name */
    private Business f11005n;

    /* renamed from: o  reason: collision with root package name */
    private IndoorDataV2 f11006o;

    /* renamed from: p  reason: collision with root package name */
    private PoiNavi f11007p;

    /* renamed from: q  reason: collision with root package name */
    private List<Photo> f11008q;

    public PoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f10995d = "";
        this.f11004m = new ArrayList();
        this.f11008q = new ArrayList();
        this.f10992a = str;
        this.f10996e = latLonPoint;
        this.f10997f = str2;
        this.f10998g = str3;
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
            String str = this.f10992a;
            if (str == null) {
                if (poiItemV2.f10992a != null) {
                    return false;
                }
            } else if (!str.equals(poiItemV2.f10992a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getAdCode() {
        return this.f10993b;
    }

    public String getAdName() {
        return this.f11002k;
    }

    public Business getBusiness() {
        return this.f11005n;
    }

    public String getCityCode() {
        return this.f10994c;
    }

    public String getCityName() {
        return this.f11001j;
    }

    public IndoorDataV2 getIndoorData() {
        return this.f11006o;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f10996e;
    }

    public List<Photo> getPhotos() {
        return this.f11008q;
    }

    public String getPoiId() {
        return this.f10992a;
    }

    public PoiNavi getPoiNavi() {
        return this.f11007p;
    }

    public String getProvinceCode() {
        return this.f11003l;
    }

    public String getProvinceName() {
        return this.f11000i;
    }

    public String getSnippet() {
        return this.f10998g;
    }

    public List<SubPoiItemV2> getSubPois() {
        return this.f11004m;
    }

    public String getTitle() {
        return this.f10997f;
    }

    public String getTypeCode() {
        return this.f10999h;
    }

    public String getTypeDes() {
        return this.f10995d;
    }

    public int hashCode() {
        String str = this.f10992a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f10993b = str;
    }

    public void setAdName(String str) {
        this.f11002k = str;
    }

    public void setBusiness(Business business) {
        this.f11005n = business;
    }

    public void setCityCode(String str) {
        this.f10994c = str;
    }

    public void setCityName(String str) {
        this.f11001j = str;
    }

    public void setIndoorData(IndoorDataV2 indoorDataV2) {
        this.f11006o = indoorDataV2;
    }

    public void setPhotos(List<Photo> list) {
        this.f11008q = list;
    }

    public void setPoiNavi(PoiNavi poiNavi) {
        this.f11007p = poiNavi;
    }

    public void setProvinceCode(String str) {
        this.f11003l = str;
    }

    public void setProvinceName(String str) {
        this.f11000i = str;
    }

    public void setSubPois(List<SubPoiItemV2> list) {
        this.f11004m = list;
    }

    public void setTypeCode(String str) {
        this.f10999h = str;
    }

    public void setTypeDes(String str) {
        this.f10995d = str;
    }

    public String toString() {
        return this.f10997f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10992a);
        parcel.writeString(this.f10993b);
        parcel.writeString(this.f10995d);
        parcel.writeValue(this.f10996e);
        parcel.writeString(this.f10997f);
        parcel.writeString(this.f10998g);
        parcel.writeString(this.f10994c);
        parcel.writeString(this.f11000i);
        parcel.writeString(this.f11001j);
        parcel.writeString(this.f11002k);
        parcel.writeString(this.f11003l);
        parcel.writeString(this.f10999h);
        parcel.writeList(this.f11004m);
        parcel.writeValue(this.f11005n);
        parcel.writeValue(this.f11006o);
        parcel.writeValue(this.f11007p);
        parcel.writeTypedList(this.f11008q);
    }

    protected PoiItemV2(Parcel parcel) {
        this.f10995d = "";
        this.f11004m = new ArrayList();
        this.f11008q = new ArrayList();
        this.f10992a = parcel.readString();
        this.f10993b = parcel.readString();
        this.f10995d = parcel.readString();
        this.f10996e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f10997f = parcel.readString();
        this.f10998g = parcel.readString();
        this.f10994c = parcel.readString();
        this.f11000i = parcel.readString();
        this.f11001j = parcel.readString();
        this.f11002k = parcel.readString();
        this.f11003l = parcel.readString();
        this.f10999h = parcel.readString();
        this.f11004m = parcel.readArrayList(SubPoiItemV2.class.getClassLoader());
        this.f11005n = (Business) parcel.readValue(Business.class.getClassLoader());
        this.f11006o = (IndoorDataV2) parcel.readValue(IndoorDataV2.class.getClassLoader());
        this.f11007p = (PoiNavi) parcel.readValue(PoiNavi.class.getClassLoader());
        this.f11008q = parcel.createTypedArrayList(Photo.CREATOR);
    }
}
