package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.services.core.PoiItem.1
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
    private String A;
    private String B;

    /* renamed from: a  reason: collision with root package name */
    private String f10966a;

    /* renamed from: b  reason: collision with root package name */
    private String f10967b;

    /* renamed from: c  reason: collision with root package name */
    private String f10968c;

    /* renamed from: d  reason: collision with root package name */
    private String f10969d;

    /* renamed from: e  reason: collision with root package name */
    private String f10970e;

    /* renamed from: f  reason: collision with root package name */
    private int f10971f;

    /* renamed from: g  reason: collision with root package name */
    private final LatLonPoint f10972g;

    /* renamed from: h  reason: collision with root package name */
    private final String f10973h;

    /* renamed from: i  reason: collision with root package name */
    private final String f10974i;

    /* renamed from: j  reason: collision with root package name */
    private LatLonPoint f10975j;

    /* renamed from: k  reason: collision with root package name */
    private LatLonPoint f10976k;

    /* renamed from: l  reason: collision with root package name */
    private String f10977l;

    /* renamed from: m  reason: collision with root package name */
    private String f10978m;

    /* renamed from: n  reason: collision with root package name */
    private String f10979n;

    /* renamed from: o  reason: collision with root package name */
    private String f10980o;

    /* renamed from: p  reason: collision with root package name */
    private String f10981p;

    /* renamed from: q  reason: collision with root package name */
    private String f10982q;

    /* renamed from: r  reason: collision with root package name */
    private String f10983r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f10984s;

    /* renamed from: t  reason: collision with root package name */
    private IndoorData f10985t;

    /* renamed from: u  reason: collision with root package name */
    private String f10986u;

    /* renamed from: v  reason: collision with root package name */
    private String f10987v;

    /* renamed from: w  reason: collision with root package name */
    private String f10988w;

    /* renamed from: x  reason: collision with root package name */
    private List<SubPoiItem> f10989x;

    /* renamed from: y  reason: collision with root package name */
    private List<Photo> f10990y;

    /* renamed from: z  reason: collision with root package name */
    private PoiItemExtension f10991z;

    public PoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f10970e = "";
        this.f10971f = -1;
        this.f10989x = new ArrayList();
        this.f10990y = new ArrayList();
        this.f10966a = str;
        this.f10972g = latLonPoint;
        this.f10973h = str2;
        this.f10974i = str3;
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
            String str = this.f10966a;
            if (str == null) {
                if (poiItem.f10966a != null) {
                    return false;
                }
            } else if (!str.equals(poiItem.f10966a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getAdCode() {
        return this.f10968c;
    }

    public String getAdName() {
        return this.f10983r;
    }

    public String getBusinessArea() {
        return this.f10987v;
    }

    public String getCityCode() {
        return this.f10969d;
    }

    public String getCityName() {
        return this.f10982q;
    }

    public String getDirection() {
        return this.f10980o;
    }

    public int getDistance() {
        return this.f10971f;
    }

    public String getEmail() {
        return this.f10979n;
    }

    public LatLonPoint getEnter() {
        return this.f10975j;
    }

    public LatLonPoint getExit() {
        return this.f10976k;
    }

    public IndoorData getIndoorData() {
        return this.f10985t;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f10972g;
    }

    public String getParkingType() {
        return this.f10988w;
    }

    public List<Photo> getPhotos() {
        return this.f10990y;
    }

    public PoiItemExtension getPoiExtension() {
        return this.f10991z;
    }

    public String getPoiId() {
        return this.f10966a;
    }

    public String getPostcode() {
        return this.f10978m;
    }

    public String getProvinceCode() {
        return this.f10986u;
    }

    public String getProvinceName() {
        return this.f10981p;
    }

    public String getShopID() {
        return this.B;
    }

    public String getSnippet() {
        return this.f10974i;
    }

    public List<SubPoiItem> getSubPois() {
        return this.f10989x;
    }

    public String getTel() {
        return this.f10967b;
    }

    public String getTitle() {
        return this.f10973h;
    }

    public String getTypeCode() {
        return this.A;
    }

    public String getTypeDes() {
        return this.f10970e;
    }

    public String getWebsite() {
        return this.f10977l;
    }

    public int hashCode() {
        String str = this.f10966a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public boolean isIndoorMap() {
        return this.f10984s;
    }

    public void setAdCode(String str) {
        this.f10968c = str;
    }

    public void setAdName(String str) {
        this.f10983r = str;
    }

    public void setBusinessArea(String str) {
        this.f10987v = str;
    }

    public void setCityCode(String str) {
        this.f10969d = str;
    }

    public void setCityName(String str) {
        this.f10982q = str;
    }

    public void setDirection(String str) {
        this.f10980o = str;
    }

    public void setDistance(int i4) {
        this.f10971f = i4;
    }

    public void setEmail(String str) {
        this.f10979n = str;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f10975j = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f10976k = latLonPoint;
    }

    public void setIndoorDate(IndoorData indoorData) {
        this.f10985t = indoorData;
    }

    public void setIndoorMap(boolean z3) {
        this.f10984s = z3;
    }

    public void setParkingType(String str) {
        this.f10988w = str;
    }

    public void setPhotos(List<Photo> list) {
        this.f10990y = list;
    }

    public void setPoiExtension(PoiItemExtension poiItemExtension) {
        this.f10991z = poiItemExtension;
    }

    public void setPostcode(String str) {
        this.f10978m = str;
    }

    public void setProvinceCode(String str) {
        this.f10986u = str;
    }

    public void setProvinceName(String str) {
        this.f10981p = str;
    }

    public void setShopID(String str) {
        this.B = str;
    }

    public void setSubPois(List<SubPoiItem> list) {
        this.f10989x = list;
    }

    public void setTel(String str) {
        this.f10967b = str;
    }

    public void setTypeCode(String str) {
        this.A = str;
    }

    public void setTypeDes(String str) {
        this.f10970e = str;
    }

    public void setWebsite(String str) {
        this.f10977l = str;
    }

    public String toString() {
        return this.f10973h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10966a);
        parcel.writeString(this.f10968c);
        parcel.writeString(this.f10967b);
        parcel.writeString(this.f10970e);
        parcel.writeInt(this.f10971f);
        parcel.writeValue(this.f10972g);
        parcel.writeString(this.f10973h);
        parcel.writeString(this.f10974i);
        parcel.writeString(this.f10969d);
        parcel.writeValue(this.f10975j);
        parcel.writeValue(this.f10976k);
        parcel.writeString(this.f10977l);
        parcel.writeString(this.f10978m);
        parcel.writeString(this.f10979n);
        parcel.writeBooleanArray(new boolean[]{this.f10984s});
        parcel.writeString(this.f10980o);
        parcel.writeString(this.f10981p);
        parcel.writeString(this.f10982q);
        parcel.writeString(this.f10983r);
        parcel.writeString(this.f10986u);
        parcel.writeString(this.f10987v);
        parcel.writeString(this.f10988w);
        parcel.writeList(this.f10989x);
        parcel.writeValue(this.f10985t);
        parcel.writeTypedList(this.f10990y);
        parcel.writeParcelable(this.f10991z, i4);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiItem(Parcel parcel) {
        this.f10970e = "";
        this.f10971f = -1;
        this.f10989x = new ArrayList();
        this.f10990y = new ArrayList();
        this.f10966a = parcel.readString();
        this.f10968c = parcel.readString();
        this.f10967b = parcel.readString();
        this.f10970e = parcel.readString();
        this.f10971f = parcel.readInt();
        this.f10972g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f10973h = parcel.readString();
        this.f10974i = parcel.readString();
        this.f10969d = parcel.readString();
        this.f10975j = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f10976k = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f10977l = parcel.readString();
        this.f10978m = parcel.readString();
        this.f10979n = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f10984s = zArr[0];
        this.f10980o = parcel.readString();
        this.f10981p = parcel.readString();
        this.f10982q = parcel.readString();
        this.f10983r = parcel.readString();
        this.f10986u = parcel.readString();
        this.f10987v = parcel.readString();
        this.f10988w = parcel.readString();
        this.f10989x = parcel.readArrayList(SubPoiItem.class.getClassLoader());
        this.f10985t = (IndoorData) parcel.readValue(IndoorData.class.getClassLoader());
        this.f10990y = parcel.createTypedArrayList(Photo.CREATOR);
        this.f10991z = (PoiItemExtension) parcel.readParcelable(PoiItemExtension.class.getClassLoader());
        this.A = parcel.readString();
        this.B = parcel.readString();
    }
}
