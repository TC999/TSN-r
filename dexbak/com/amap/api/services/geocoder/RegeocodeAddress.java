package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RegeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<RegeocodeAddress> CREATOR = new Parcelable.Creator<RegeocodeAddress>() { // from class: com.amap.api.services.geocoder.RegeocodeAddress.1
        /* renamed from: a */
        private static RegeocodeAddress m51871a(Parcel parcel) {
            return new RegeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RegeocodeAddress createFromParcel(Parcel parcel) {
            return m51871a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RegeocodeAddress[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7370a;

    /* renamed from: b */
    private String f7371b;

    /* renamed from: c */
    private String f7372c;

    /* renamed from: d */
    private String f7373d;

    /* renamed from: e */
    private String f7374e;

    /* renamed from: f */
    private String f7375f;

    /* renamed from: g */
    private String f7376g;

    /* renamed from: h */
    private StreetNumber f7377h;

    /* renamed from: i */
    private String f7378i;

    /* renamed from: j */
    private String f7379j;

    /* renamed from: k */
    private String f7380k;

    /* renamed from: l */
    private List<RegeocodeRoad> f7381l;

    /* renamed from: m */
    private List<Crossroad> f7382m;

    /* renamed from: n */
    private List<PoiItem> f7383n;

    /* renamed from: o */
    private List<BusinessArea> f7384o;

    /* renamed from: p */
    private List<AoiItem> f7385p;

    /* renamed from: q */
    private String f7386q;

    /* renamed from: r */
    private String f7387r;

    /* synthetic */ RegeocodeAddress(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAdCode() {
        return this.f7379j;
    }

    public final List<AoiItem> getAois() {
        return this.f7385p;
    }

    public final String getBuilding() {
        return this.f7376g;
    }

    public final List<BusinessArea> getBusinessAreas() {
        return this.f7384o;
    }

    public final String getCity() {
        return this.f7372c;
    }

    public final String getCityCode() {
        return this.f7378i;
    }

    public final String getCountry() {
        return this.f7386q;
    }

    public final String getCountryCode() {
        return this.f7387r;
    }

    public final List<Crossroad> getCrossroads() {
        return this.f7382m;
    }

    public final String getDistrict() {
        return this.f7373d;
    }

    public final String getFormatAddress() {
        return this.f7370a;
    }

    public final String getNeighborhood() {
        return this.f7375f;
    }

    public final List<PoiItem> getPois() {
        return this.f7383n;
    }

    public final String getProvince() {
        return this.f7371b;
    }

    public final List<RegeocodeRoad> getRoads() {
        return this.f7381l;
    }

    public final StreetNumber getStreetNumber() {
        return this.f7377h;
    }

    public final String getTowncode() {
        return this.f7380k;
    }

    public final String getTownship() {
        return this.f7374e;
    }

    public final void setAdCode(String str) {
        this.f7379j = str;
    }

    public final void setAois(List<AoiItem> list) {
        this.f7385p = list;
    }

    public final void setBuilding(String str) {
        this.f7376g = str;
    }

    public final void setBusinessAreas(List<BusinessArea> list) {
        this.f7384o = list;
    }

    public final void setCity(String str) {
        this.f7372c = str;
    }

    public final void setCityCode(String str) {
        this.f7378i = str;
    }

    public final void setCountry(String str) {
        this.f7386q = str;
    }

    public final void setCountryCode(String str) {
        this.f7387r = str;
    }

    public final void setCrossroads(List<Crossroad> list) {
        this.f7382m = list;
    }

    public final void setDistrict(String str) {
        this.f7373d = str;
    }

    public final void setFormatAddress(String str) {
        this.f7370a = str;
    }

    public final void setNeighborhood(String str) {
        this.f7375f = str;
    }

    public final void setPois(List<PoiItem> list) {
        this.f7383n = list;
    }

    public final void setProvince(String str) {
        this.f7371b = str;
    }

    public final void setRoads(List<RegeocodeRoad> list) {
        this.f7381l = list;
    }

    public final void setStreetNumber(StreetNumber streetNumber) {
        this.f7377h = streetNumber;
    }

    public final void setTowncode(String str) {
        this.f7380k = str;
    }

    public final void setTownship(String str) {
        this.f7374e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7370a);
        parcel.writeString(this.f7371b);
        parcel.writeString(this.f7372c);
        parcel.writeString(this.f7373d);
        parcel.writeString(this.f7374e);
        parcel.writeString(this.f7375f);
        parcel.writeString(this.f7376g);
        parcel.writeValue(this.f7377h);
        parcel.writeList(this.f7381l);
        parcel.writeList(this.f7382m);
        parcel.writeList(this.f7383n);
        parcel.writeString(this.f7378i);
        parcel.writeString(this.f7379j);
        parcel.writeList(this.f7384o);
        parcel.writeList(this.f7385p);
        parcel.writeString(this.f7380k);
        parcel.writeString(this.f7386q);
        parcel.writeString(this.f7387r);
    }

    public RegeocodeAddress() {
        this.f7381l = new ArrayList();
        this.f7382m = new ArrayList();
        this.f7383n = new ArrayList();
        this.f7384o = new ArrayList();
        this.f7385p = new ArrayList();
    }

    private RegeocodeAddress(Parcel parcel) {
        this.f7381l = new ArrayList();
        this.f7382m = new ArrayList();
        this.f7383n = new ArrayList();
        this.f7384o = new ArrayList();
        this.f7385p = new ArrayList();
        this.f7370a = parcel.readString();
        this.f7371b = parcel.readString();
        this.f7372c = parcel.readString();
        this.f7373d = parcel.readString();
        this.f7374e = parcel.readString();
        this.f7375f = parcel.readString();
        this.f7376g = parcel.readString();
        this.f7377h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.f7381l = parcel.readArrayList(Road.class.getClassLoader());
        this.f7382m = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.f7383n = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.f7378i = parcel.readString();
        this.f7379j = parcel.readString();
        this.f7384o = parcel.readArrayList(BusinessArea.class.getClassLoader());
        this.f7385p = parcel.readArrayList(AoiItem.class.getClassLoader());
        this.f7380k = parcel.readString();
        this.f7386q = parcel.readString();
        this.f7387r = parcel.readString();
    }
}
