package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TimeInfo implements Parcelable {
    public static final Parcelable.Creator<TimeInfo> CREATOR = new Parcelable.Creator<TimeInfo>() { // from class: com.amap.api.services.route.TimeInfo.1
        /* renamed from: a */
        private static TimeInfo m51760a(Parcel parcel) {
            return new TimeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfo createFromParcel(Parcel parcel) {
            return m51760a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfo[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private long f7856a;

    /* renamed from: b */
    private List<TimeInfosElement> f7857b;

    public TimeInfo(Parcel parcel) {
        this.f7857b = new ArrayList();
        this.f7856a = parcel.readInt();
        this.f7857b = parcel.createTypedArrayList(TimeInfosElement.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TimeInfosElement> getElements() {
        return this.f7857b;
    }

    public long getStartTime() {
        return this.f7856a;
    }

    public void setElements(List<TimeInfosElement> list) {
        this.f7857b = list;
    }

    public void setStartTime(long j) {
        this.f7856a = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7856a);
        parcel.writeTypedList(this.f7857b);
    }

    public TimeInfo() {
        this.f7857b = new ArrayList();
    }
}
