package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TaxiItemV2 implements Parcelable {
    public static final Parcelable.Creator<TaxiItemV2> CREATOR = new Parcelable.Creator<TaxiItemV2>() { // from class: com.amap.api.services.route.TaxiItemV2.1
        private static TaxiItemV2 a(Parcel parcel) {
            return new TaxiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItemV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItemV2[] newArray(int i4) {
            return a(i4);
        }

        private static TaxiItemV2[] a(int i4) {
            return new TaxiItemV2[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f11542a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f11543b;

    /* renamed from: c  reason: collision with root package name */
    private float f11544c;

    /* renamed from: d  reason: collision with root package name */
    private float f11545d;

    /* renamed from: e  reason: collision with root package name */
    private String f11546e;

    /* renamed from: f  reason: collision with root package name */
    private String f11547f;

    /* renamed from: g  reason: collision with root package name */
    private float f11548g;

    /* renamed from: h  reason: collision with root package name */
    private List<LatLonPoint> f11549h;

    public TaxiItemV2() {
        this.f11549h = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f11543b;
    }

    public float getDistance() {
        return this.f11544c;
    }

    public float getDuration() {
        return this.f11545d;
    }

    public LatLonPoint getOrigin() {
        return this.f11542a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f11549h;
    }

    public float getPrice() {
        return this.f11548g;
    }

    public String getmSname() {
        return this.f11546e;
    }

    public String getmTname() {
        return this.f11547f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f11543b = latLonPoint;
    }

    public void setDistance(float f4) {
        this.f11544c = f4;
    }

    public void setDuration(float f4) {
        this.f11545d = f4;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f11542a = latLonPoint;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f11549h = list;
    }

    public void setPrice(float f4) {
        this.f11548g = f4;
    }

    public void setSname(String str) {
        this.f11546e = str;
    }

    public void setTname(String str) {
        this.f11547f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f11542a, i4);
        parcel.writeParcelable(this.f11543b, i4);
        parcel.writeFloat(this.f11544c);
        parcel.writeFloat(this.f11545d);
        parcel.writeString(this.f11546e);
        parcel.writeString(this.f11547f);
        parcel.writeFloat(this.f11548g);
        parcel.writeTypedList(this.f11549h);
    }

    protected TaxiItemV2(Parcel parcel) {
        this.f11549h = new ArrayList();
        this.f11542a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11543b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11544c = parcel.readFloat();
        this.f11545d = parcel.readFloat();
        this.f11546e = parcel.readString();
        this.f11547f = parcel.readString();
        this.f11548g = parcel.readFloat();
        this.f11549h = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }
}
