package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.fence.DistrictItem.1
        private static DistrictItem a(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem[] newArray(int i4) {
            return a(i4);
        }

        private static DistrictItem[] a(int i4) {
            return new DistrictItem[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10553a;

    /* renamed from: b  reason: collision with root package name */
    private String f10554b;

    /* renamed from: c  reason: collision with root package name */
    private String f10555c;

    /* renamed from: d  reason: collision with root package name */
    private List<DPoint> f10556d;

    public DistrictItem() {
        this.f10553a = "";
        this.f10554b = null;
        this.f10555c = null;
        this.f10556d = null;
    }

    public static Parcelable.Creator<DistrictItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f10555c;
    }

    public String getCitycode() {
        return this.f10554b;
    }

    public String getDistrictName() {
        return this.f10553a;
    }

    public List<DPoint> getPolyline() {
        return this.f10556d;
    }

    public void setAdcode(String str) {
        this.f10555c = str;
    }

    public void setCitycode(String str) {
        this.f10554b = str;
    }

    public void setDistrictName(String str) {
        this.f10553a = str;
    }

    public void setPolyline(List<DPoint> list) {
        this.f10556d = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10553a);
        parcel.writeString(this.f10554b);
        parcel.writeString(this.f10555c);
        parcel.writeTypedList(this.f10556d);
    }

    protected DistrictItem(Parcel parcel) {
        this.f10553a = "";
        this.f10554b = null;
        this.f10555c = null;
        this.f10556d = null;
        this.f10553a = parcel.readString();
        this.f10554b = parcel.readString();
        this.f10555c = parcel.readString();
        this.f10556d = parcel.createTypedArrayList(DPoint.CREATOR);
    }
}
