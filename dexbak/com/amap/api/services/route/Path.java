package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new Parcelable.Creator<Path>() { // from class: com.amap.api.services.route.Path.1
        /* renamed from: a */
        private static Path m51813a(Parcel parcel) {
            return new Path(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Path createFromParcel(Parcel parcel) {
            return m51813a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Path[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private float f7667a;

    /* renamed from: b */
    private long f7668b;

    /* renamed from: c */
    private List<LatLonPoint> f7669c;

    public Path(Parcel parcel) {
        this.f7669c = new ArrayList();
        this.f7667a = parcel.readFloat();
        this.f7668b = parcel.readLong();
        this.f7669c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f7667a;
    }

    public long getDuration() {
        return this.f7668b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f7669c;
    }

    public void setDistance(float f) {
        this.f7667a = f;
    }

    public void setDuration(long j) {
        this.f7668b = j;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f7669c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f7667a);
        parcel.writeLong(this.f7668b);
        parcel.writeTypedList(this.f7669c);
    }

    public Path() {
        this.f7669c = new ArrayList();
    }
}
