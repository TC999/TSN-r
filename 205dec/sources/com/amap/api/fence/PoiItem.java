package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.fence.PoiItem.1
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
    private String f10577a;

    /* renamed from: b  reason: collision with root package name */
    private String f10578b;

    /* renamed from: c  reason: collision with root package name */
    private String f10579c;

    /* renamed from: d  reason: collision with root package name */
    private String f10580d;

    /* renamed from: e  reason: collision with root package name */
    private String f10581e;

    /* renamed from: f  reason: collision with root package name */
    private double f10582f;

    /* renamed from: g  reason: collision with root package name */
    private double f10583g;

    /* renamed from: h  reason: collision with root package name */
    private String f10584h;

    /* renamed from: i  reason: collision with root package name */
    private String f10585i;

    /* renamed from: j  reason: collision with root package name */
    private String f10586j;

    /* renamed from: k  reason: collision with root package name */
    private String f10587k;

    public PoiItem() {
        this.f10577a = "";
        this.f10578b = "";
        this.f10579c = "";
        this.f10580d = "";
        this.f10581e = "";
        this.f10582f = 0.0d;
        this.f10583g = 0.0d;
        this.f10584h = "";
        this.f10585i = "";
        this.f10586j = "";
        this.f10587k = "";
    }

    public static Parcelable.Creator<PoiItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f10581e;
    }

    public String getAdname() {
        return this.f10587k;
    }

    public String getCity() {
        return this.f10586j;
    }

    public double getLatitude() {
        return this.f10582f;
    }

    public double getLongitude() {
        return this.f10583g;
    }

    public String getPoiId() {
        return this.f10578b;
    }

    public String getPoiName() {
        return this.f10577a;
    }

    public String getPoiType() {
        return this.f10579c;
    }

    public String getProvince() {
        return this.f10585i;
    }

    public String getTel() {
        return this.f10584h;
    }

    public String getTypeCode() {
        return this.f10580d;
    }

    public void setAddress(String str) {
        this.f10581e = str;
    }

    public void setAdname(String str) {
        this.f10587k = str;
    }

    public void setCity(String str) {
        this.f10586j = str;
    }

    public void setLatitude(double d4) {
        this.f10582f = d4;
    }

    public void setLongitude(double d4) {
        this.f10583g = d4;
    }

    public void setPoiId(String str) {
        this.f10578b = str;
    }

    public void setPoiName(String str) {
        this.f10577a = str;
    }

    public void setPoiType(String str) {
        this.f10579c = str;
    }

    public void setProvince(String str) {
        this.f10585i = str;
    }

    public void setTel(String str) {
        this.f10584h = str;
    }

    public void setTypeCode(String str) {
        this.f10580d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10577a);
        parcel.writeString(this.f10578b);
        parcel.writeString(this.f10579c);
        parcel.writeString(this.f10580d);
        parcel.writeString(this.f10581e);
        parcel.writeDouble(this.f10582f);
        parcel.writeDouble(this.f10583g);
        parcel.writeString(this.f10584h);
        parcel.writeString(this.f10585i);
        parcel.writeString(this.f10586j);
        parcel.writeString(this.f10587k);
    }

    protected PoiItem(Parcel parcel) {
        this.f10577a = "";
        this.f10578b = "";
        this.f10579c = "";
        this.f10580d = "";
        this.f10581e = "";
        this.f10582f = 0.0d;
        this.f10583g = 0.0d;
        this.f10584h = "";
        this.f10585i = "";
        this.f10586j = "";
        this.f10587k = "";
        this.f10577a = parcel.readString();
        this.f10578b = parcel.readString();
        this.f10579c = parcel.readString();
        this.f10580d = parcel.readString();
        this.f10581e = parcel.readString();
        this.f10582f = parcel.readDouble();
        this.f10583g = parcel.readDouble();
        this.f10584h = parcel.readString();
        this.f10585i = parcel.readString();
        this.f10586j = parcel.readString();
        this.f10587k = parcel.readString();
    }
}
