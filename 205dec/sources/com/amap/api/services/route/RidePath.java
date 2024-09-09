package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RidePath extends Path implements Parcelable {
    public static final Parcelable.Creator<RidePath> CREATOR = new Parcelable.Creator<RidePath>() { // from class: com.amap.api.services.route.RidePath.1
        private static RidePath a(Parcel parcel) {
            return new RidePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RidePath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RidePath[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<RideStep> f11376a;

    public RidePath(Parcel parcel) {
        super(parcel);
        this.f11376a = new ArrayList();
        this.f11376a = parcel.createTypedArrayList(RideStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RideStep> getSteps() {
        return this.f11376a;
    }

    public void setSteps(List<RideStep> list) {
        this.f11376a = list;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f11376a);
    }

    public RidePath() {
        this.f11376a = new ArrayList();
    }
}
