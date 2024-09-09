package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Doorway implements Parcelable {
    public static final Parcelable.Creator<Doorway> CREATOR = new Parcelable.Creator<Doorway>() { // from class: com.amap.api.services.route.Doorway.1
        private static Doorway a(Parcel parcel) {
            return new Doorway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Doorway createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Doorway[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11301a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f11302b;

    public Doorway(Parcel parcel) {
        this.f11301a = parcel.readString();
        this.f11302b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f11302b;
    }

    public String getName() {
        return this.f11301a;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f11302b = latLonPoint;
    }

    public void setName(String str) {
        this.f11301a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11301a);
        parcel.writeParcelable(this.f11302b, i4);
    }

    public Doorway() {
    }
}
