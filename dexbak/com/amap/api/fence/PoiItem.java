package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.fence.PoiItem.1
        /* renamed from: a */
        private static PoiItem m52163a(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem createFromParcel(Parcel parcel) {
            return m52163a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem[] newArray(int i) {
            return m52164a(i);
        }

        /* renamed from: a */
        private static PoiItem[] m52164a(int i) {
            return new PoiItem[i];
        }
    };

    /* renamed from: a */
    private String f6854a;

    /* renamed from: b */
    private String f6855b;

    /* renamed from: c */
    private String f6856c;

    /* renamed from: d */
    private String f6857d;

    /* renamed from: e */
    private String f6858e;

    /* renamed from: f */
    private double f6859f;

    /* renamed from: g */
    private double f6860g;

    /* renamed from: h */
    private String f6861h;

    /* renamed from: i */
    private String f6862i;

    /* renamed from: j */
    private String f6863j;

    /* renamed from: k */
    private String f6864k;

    public PoiItem() {
        this.f6854a = "";
        this.f6855b = "";
        this.f6856c = "";
        this.f6857d = "";
        this.f6858e = "";
        this.f6859f = Utils.DOUBLE_EPSILON;
        this.f6860g = Utils.DOUBLE_EPSILON;
        this.f6861h = "";
        this.f6862i = "";
        this.f6863j = "";
        this.f6864k = "";
    }

    public static Parcelable.Creator<PoiItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f6858e;
    }

    public String getAdname() {
        return this.f6864k;
    }

    public String getCity() {
        return this.f6863j;
    }

    public double getLatitude() {
        return this.f6859f;
    }

    public double getLongitude() {
        return this.f6860g;
    }

    public String getPoiId() {
        return this.f6855b;
    }

    public String getPoiName() {
        return this.f6854a;
    }

    public String getPoiType() {
        return this.f6856c;
    }

    public String getProvince() {
        return this.f6862i;
    }

    public String getTel() {
        return this.f6861h;
    }

    public String getTypeCode() {
        return this.f6857d;
    }

    public void setAddress(String str) {
        this.f6858e = str;
    }

    public void setAdname(String str) {
        this.f6864k = str;
    }

    public void setCity(String str) {
        this.f6863j = str;
    }

    public void setLatitude(double d) {
        this.f6859f = d;
    }

    public void setLongitude(double d) {
        this.f6860g = d;
    }

    public void setPoiId(String str) {
        this.f6855b = str;
    }

    public void setPoiName(String str) {
        this.f6854a = str;
    }

    public void setPoiType(String str) {
        this.f6856c = str;
    }

    public void setProvince(String str) {
        this.f6862i = str;
    }

    public void setTel(String str) {
        this.f6861h = str;
    }

    public void setTypeCode(String str) {
        this.f6857d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6854a);
        parcel.writeString(this.f6855b);
        parcel.writeString(this.f6856c);
        parcel.writeString(this.f6857d);
        parcel.writeString(this.f6858e);
        parcel.writeDouble(this.f6859f);
        parcel.writeDouble(this.f6860g);
        parcel.writeString(this.f6861h);
        parcel.writeString(this.f6862i);
        parcel.writeString(this.f6863j);
        parcel.writeString(this.f6864k);
    }

    protected PoiItem(Parcel parcel) {
        this.f6854a = "";
        this.f6855b = "";
        this.f6856c = "";
        this.f6857d = "";
        this.f6858e = "";
        this.f6859f = Utils.DOUBLE_EPSILON;
        this.f6860g = Utils.DOUBLE_EPSILON;
        this.f6861h = "";
        this.f6862i = "";
        this.f6863j = "";
        this.f6864k = "";
        this.f6854a = parcel.readString();
        this.f6855b = parcel.readString();
        this.f6856c = parcel.readString();
        this.f6857d = parcel.readString();
        this.f6858e = parcel.readString();
        this.f6859f = parcel.readDouble();
        this.f6860g = parcel.readDouble();
        this.f6861h = parcel.readString();
        this.f6862i = parcel.readString();
        this.f6863j = parcel.readString();
        this.f6864k = parcel.readString();
    }
}
