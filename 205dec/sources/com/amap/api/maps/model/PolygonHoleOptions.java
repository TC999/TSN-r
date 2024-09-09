package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PolygonHoleOptions extends BaseHoleOptions implements Parcelable {
    @JBindingExclude
    public static final Parcelable.Creator<PolygonHoleOptions> CREATOR = new Parcelable.Creator<PolygonHoleOptions>() { // from class: com.amap.api.maps.model.PolygonHoleOptions.1
        private static PolygonHoleOptions a(Parcel parcel) {
            return new PolygonHoleOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PolygonHoleOptions createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PolygonHoleOptions[] newArray(int i4) {
            return a(i4);
        }

        private static PolygonHoleOptions[] a(int i4) {
            return new PolygonHoleOptions[i4];
        }
    };
    private final List<LatLng> points;

    public PolygonHoleOptions() {
        this.points = new ArrayList();
        this.isPolygonHoleOptions = true;
    }

    public PolygonHoleOptions addAll(Iterable<LatLng> iterable) {
        try {
            for (LatLng latLng : iterable) {
                this.points.add(latLng);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<LatLng> getPoints() {
        return this.points;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.points);
    }

    @JBindingExclude
    protected PolygonHoleOptions(Parcel parcel) {
        this.points = parcel.createTypedArrayList(LatLng.CREATOR);
        this.isPolygonHoleOptions = true;
    }
}
