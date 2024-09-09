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
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new Parcelable.Creator<Path>() { // from class: com.amap.api.services.route.Path.1
        private static Path a(Parcel parcel) {
            return new Path(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Path createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Path[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f11361a;

    /* renamed from: b  reason: collision with root package name */
    private long f11362b;

    /* renamed from: c  reason: collision with root package name */
    private List<LatLonPoint> f11363c;

    public Path(Parcel parcel) {
        this.f11363c = new ArrayList();
        this.f11361a = parcel.readFloat();
        this.f11362b = parcel.readLong();
        this.f11363c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f11361a;
    }

    public long getDuration() {
        return this.f11362b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f11363c;
    }

    public void setDistance(float f4) {
        this.f11361a = f4;
    }

    public void setDuration(long j4) {
        this.f11362b = j4;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f11363c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.f11361a);
        parcel.writeLong(this.f11362b);
        parcel.writeTypedList(this.f11363c);
    }

    public Path() {
        this.f11363c = new ArrayList();
    }
}
