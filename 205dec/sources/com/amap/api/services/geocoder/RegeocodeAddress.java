package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class RegeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<RegeocodeAddress> CREATOR = new Parcelable.Creator<RegeocodeAddress>() { // from class: com.amap.api.services.geocoder.RegeocodeAddress.1
        private static RegeocodeAddress a(Parcel parcel) {
            return new RegeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RegeocodeAddress createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RegeocodeAddress[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11064a;

    /* renamed from: b  reason: collision with root package name */
    private String f11065b;

    /* renamed from: c  reason: collision with root package name */
    private String f11066c;

    /* renamed from: d  reason: collision with root package name */
    private String f11067d;

    /* renamed from: e  reason: collision with root package name */
    private String f11068e;

    /* renamed from: f  reason: collision with root package name */
    private String f11069f;

    /* renamed from: g  reason: collision with root package name */
    private String f11070g;

    /* renamed from: h  reason: collision with root package name */
    private StreetNumber f11071h;

    /* renamed from: i  reason: collision with root package name */
    private String f11072i;

    /* renamed from: j  reason: collision with root package name */
    private String f11073j;

    /* renamed from: k  reason: collision with root package name */
    private String f11074k;

    /* renamed from: l  reason: collision with root package name */
    private List<RegeocodeRoad> f11075l;

    /* renamed from: m  reason: collision with root package name */
    private List<Crossroad> f11076m;

    /* renamed from: n  reason: collision with root package name */
    private List<PoiItem> f11077n;

    /* renamed from: o  reason: collision with root package name */
    private List<BusinessArea> f11078o;

    /* renamed from: p  reason: collision with root package name */
    private List<AoiItem> f11079p;

    /* renamed from: q  reason: collision with root package name */
    private String f11080q;

    /* renamed from: r  reason: collision with root package name */
    private String f11081r;

    /* synthetic */ RegeocodeAddress(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAdCode() {
        return this.f11073j;
    }

    public final List<AoiItem> getAois() {
        return this.f11079p;
    }

    public final String getBuilding() {
        return this.f11070g;
    }

    public final List<BusinessArea> getBusinessAreas() {
        return this.f11078o;
    }

    public final String getCity() {
        return this.f11066c;
    }

    public final String getCityCode() {
        return this.f11072i;
    }

    public final String getCountry() {
        return this.f11080q;
    }

    public final String getCountryCode() {
        return this.f11081r;
    }

    public final List<Crossroad> getCrossroads() {
        return this.f11076m;
    }

    public final String getDistrict() {
        return this.f11067d;
    }

    public final String getFormatAddress() {
        return this.f11064a;
    }

    public final String getNeighborhood() {
        return this.f11069f;
    }

    public final List<PoiItem> getPois() {
        return this.f11077n;
    }

    public final String getProvince() {
        return this.f11065b;
    }

    public final List<RegeocodeRoad> getRoads() {
        return this.f11075l;
    }

    public final StreetNumber getStreetNumber() {
        return this.f11071h;
    }

    public final String getTowncode() {
        return this.f11074k;
    }

    public final String getTownship() {
        return this.f11068e;
    }

    public final void setAdCode(String str) {
        this.f11073j = str;
    }

    public final void setAois(List<AoiItem> list) {
        this.f11079p = list;
    }

    public final void setBuilding(String str) {
        this.f11070g = str;
    }

    public final void setBusinessAreas(List<BusinessArea> list) {
        this.f11078o = list;
    }

    public final void setCity(String str) {
        this.f11066c = str;
    }

    public final void setCityCode(String str) {
        this.f11072i = str;
    }

    public final void setCountry(String str) {
        this.f11080q = str;
    }

    public final void setCountryCode(String str) {
        this.f11081r = str;
    }

    public final void setCrossroads(List<Crossroad> list) {
        this.f11076m = list;
    }

    public final void setDistrict(String str) {
        this.f11067d = str;
    }

    public final void setFormatAddress(String str) {
        this.f11064a = str;
    }

    public final void setNeighborhood(String str) {
        this.f11069f = str;
    }

    public final void setPois(List<PoiItem> list) {
        this.f11077n = list;
    }

    public final void setProvince(String str) {
        this.f11065b = str;
    }

    public final void setRoads(List<RegeocodeRoad> list) {
        this.f11075l = list;
    }

    public final void setStreetNumber(StreetNumber streetNumber) {
        this.f11071h = streetNumber;
    }

    public final void setTowncode(String str) {
        this.f11074k = str;
    }

    public final void setTownship(String str) {
        this.f11068e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11064a);
        parcel.writeString(this.f11065b);
        parcel.writeString(this.f11066c);
        parcel.writeString(this.f11067d);
        parcel.writeString(this.f11068e);
        parcel.writeString(this.f11069f);
        parcel.writeString(this.f11070g);
        parcel.writeValue(this.f11071h);
        parcel.writeList(this.f11075l);
        parcel.writeList(this.f11076m);
        parcel.writeList(this.f11077n);
        parcel.writeString(this.f11072i);
        parcel.writeString(this.f11073j);
        parcel.writeList(this.f11078o);
        parcel.writeList(this.f11079p);
        parcel.writeString(this.f11074k);
        parcel.writeString(this.f11080q);
        parcel.writeString(this.f11081r);
    }

    public RegeocodeAddress() {
        this.f11075l = new ArrayList();
        this.f11076m = new ArrayList();
        this.f11077n = new ArrayList();
        this.f11078o = new ArrayList();
        this.f11079p = new ArrayList();
    }

    private RegeocodeAddress(Parcel parcel) {
        this.f11075l = new ArrayList();
        this.f11076m = new ArrayList();
        this.f11077n = new ArrayList();
        this.f11078o = new ArrayList();
        this.f11079p = new ArrayList();
        this.f11064a = parcel.readString();
        this.f11065b = parcel.readString();
        this.f11066c = parcel.readString();
        this.f11067d = parcel.readString();
        this.f11068e = parcel.readString();
        this.f11069f = parcel.readString();
        this.f11070g = parcel.readString();
        this.f11071h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.f11075l = parcel.readArrayList(Road.class.getClassLoader());
        this.f11076m = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.f11077n = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.f11072i = parcel.readString();
        this.f11073j = parcel.readString();
        this.f11078o = parcel.readArrayList(BusinessArea.class.getClassLoader());
        this.f11079p = parcel.readArrayList(AoiItem.class.getClassLoader());
        this.f11074k = parcel.readString();
        this.f11080q = parcel.readString();
        this.f11081r = parcel.readString();
    }
}
