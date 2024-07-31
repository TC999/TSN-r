package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.fence.DistrictItem.1
        /* renamed from: a */
        private static DistrictItem m52168a(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem createFromParcel(Parcel parcel) {
            return m52168a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem[] newArray(int i) {
            return m52169a(i);
        }

        /* renamed from: a */
        private static DistrictItem[] m52169a(int i) {
            return new DistrictItem[i];
        }
    };

    /* renamed from: a */
    private String f6830a;

    /* renamed from: b */
    private String f6831b;

    /* renamed from: c */
    private String f6832c;

    /* renamed from: d */
    private List<DPoint> f6833d;

    public DistrictItem() {
        this.f6830a = "";
        this.f6831b = null;
        this.f6832c = null;
        this.f6833d = null;
    }

    public static Parcelable.Creator<DistrictItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f6832c;
    }

    public String getCitycode() {
        return this.f6831b;
    }

    public String getDistrictName() {
        return this.f6830a;
    }

    public List<DPoint> getPolyline() {
        return this.f6833d;
    }

    public void setAdcode(String str) {
        this.f6832c = str;
    }

    public void setCitycode(String str) {
        this.f6831b = str;
    }

    public void setDistrictName(String str) {
        this.f6830a = str;
    }

    public void setPolyline(List<DPoint> list) {
        this.f6833d = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6830a);
        parcel.writeString(this.f6831b);
        parcel.writeString(this.f6832c);
        parcel.writeTypedList(this.f6833d);
    }

    protected DistrictItem(Parcel parcel) {
        this.f6830a = "";
        this.f6831b = null;
        this.f6832c = null;
        this.f6833d = null;
        this.f6830a = parcel.readString();
        this.f6831b = parcel.readString();
        this.f6832c = parcel.readString();
        this.f6833d = parcel.createTypedArrayList(DPoint.CREATOR);
    }
}
