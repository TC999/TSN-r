package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PolygonHoleOptions extends BaseHoleOptions implements Parcelable {
    @JBindingExclude
    public static final Parcelable.Creator<PolygonHoleOptions> CREATOR = new Parcelable.Creator<PolygonHoleOptions>() { // from class: com.amap.api.maps.model.PolygonHoleOptions.1
        /* renamed from: a */
        private static PolygonHoleOptions m52032a(Parcel parcel) {
            return new PolygonHoleOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PolygonHoleOptions createFromParcel(Parcel parcel) {
            return m52032a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PolygonHoleOptions[] newArray(int i) {
            return m52033a(i);
        }

        /* renamed from: a */
        private static PolygonHoleOptions[] m52033a(int i) {
            return new PolygonHoleOptions[i];
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.points);
    }

    @JBindingExclude
    protected PolygonHoleOptions(Parcel parcel) {
        this.points = parcel.createTypedArrayList(LatLng.CREATOR);
        this.isPolygonHoleOptions = true;
    }
}
