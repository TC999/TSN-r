package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TimeInfo implements Parcelable {
    public static final Parcelable.Creator<TimeInfo> CREATOR = new Parcelable.Creator<TimeInfo>() { // from class: com.amap.api.services.route.TimeInfo.1
        private static TimeInfo a(Parcel parcel) {
            return new TimeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfo createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfo[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private long f11550a;

    /* renamed from: b  reason: collision with root package name */
    private List<TimeInfosElement> f11551b;

    public TimeInfo(Parcel parcel) {
        this.f11551b = new ArrayList();
        this.f11550a = parcel.readInt();
        this.f11551b = parcel.createTypedArrayList(TimeInfosElement.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TimeInfosElement> getElements() {
        return this.f11551b;
    }

    public long getStartTime() {
        return this.f11550a;
    }

    public void setElements(List<TimeInfosElement> list) {
        this.f11551b = list;
    }

    public void setStartTime(long j4) {
        this.f11550a = j4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.f11550a);
        parcel.writeTypedList(this.f11551b);
    }

    public TimeInfo() {
        this.f11551b = new ArrayList();
    }
}
