package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = new Parcelable.Creator<Road>() { // from class: com.amap.api.services.road.Road.1
        private static Road a(Parcel parcel) {
            return new Road(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Road createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Road[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11233a;

    /* renamed from: b  reason: collision with root package name */
    private String f11234b;

    /* renamed from: c  reason: collision with root package name */
    private String f11235c;

    /* renamed from: d  reason: collision with root package name */
    private float f11236d;

    /* renamed from: e  reason: collision with root package name */
    private String f11237e;

    /* renamed from: f  reason: collision with root package name */
    private LatLonPoint f11238f;

    public Road() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f11238f;
    }

    public String getCityCode() {
        return this.f11235c;
    }

    public String getId() {
        return this.f11233a;
    }

    public String getName() {
        return this.f11234b;
    }

    public float getRoadWidth() {
        return this.f11236d;
    }

    public String getType() {
        return this.f11237e;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f11238f = latLonPoint;
    }

    public void setCityCode(String str) {
        this.f11235c = str;
    }

    public void setId(String str) {
        this.f11233a = str;
    }

    public void setName(String str) {
        this.f11234b = str;
    }

    public void setRoadWidth(float f4) {
        this.f11236d = f4;
    }

    public void setType(String str) {
        this.f11237e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11233a);
        parcel.writeString(this.f11234b);
        parcel.writeString(this.f11235c);
        parcel.writeFloat(this.f11236d);
        parcel.writeString(this.f11237e);
        parcel.writeValue(this.f11238f);
    }

    public Road(String str, String str2) {
        this.f11233a = str;
        this.f11234b = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Road(Parcel parcel) {
        this.f11233a = parcel.readString();
        this.f11234b = parcel.readString();
        this.f11235c = parcel.readString();
        this.f11236d = parcel.readFloat();
        this.f11237e = parcel.readString();
        this.f11238f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
