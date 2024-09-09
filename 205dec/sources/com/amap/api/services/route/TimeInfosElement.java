package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TimeInfosElement implements Parcelable {
    public static final Parcelable.Creator<TimeInfosElement> CREATOR = new Parcelable.Creator<TimeInfosElement>() { // from class: com.amap.api.services.route.TimeInfosElement.1
        private static TimeInfosElement a(Parcel parcel) {
            return new TimeInfosElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfosElement createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfosElement[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    int f11552a;

    /* renamed from: b  reason: collision with root package name */
    float f11553b;

    /* renamed from: c  reason: collision with root package name */
    float f11554c;

    /* renamed from: d  reason: collision with root package name */
    int f11555d;

    /* renamed from: e  reason: collision with root package name */
    private List<TMC> f11556e;

    public TimeInfosElement(Parcel parcel) {
        this.f11556e = new ArrayList();
        this.f11552a = parcel.readInt();
        this.f11553b = parcel.readFloat();
        this.f11554c = parcel.readFloat();
        this.f11555d = parcel.readInt();
        this.f11556e = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDuration() {
        return this.f11553b;
    }

    public int getPathindex() {
        return this.f11552a;
    }

    public int getRestriction() {
        return this.f11555d;
    }

    public List<TMC> getTMCs() {
        return this.f11556e;
    }

    public float getTolls() {
        return this.f11554c;
    }

    public void setDuration(float f4) {
        this.f11553b = f4;
    }

    public void setPathindex(int i4) {
        this.f11552a = i4;
    }

    public void setRestriction(int i4) {
        this.f11555d = i4;
    }

    public void setTMCs(List<TMC> list) {
        this.f11556e = list;
    }

    public void setTolls(float f4) {
        this.f11554c = f4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f11552a);
        parcel.writeFloat(this.f11553b);
        parcel.writeFloat(this.f11554c);
        parcel.writeInt(this.f11555d);
        parcel.writeTypedList(this.f11556e);
    }

    public TimeInfosElement() {
        this.f11556e = new ArrayList();
    }
}
