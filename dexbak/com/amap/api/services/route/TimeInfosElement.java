package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TimeInfosElement implements Parcelable {
    public static final Parcelable.Creator<TimeInfosElement> CREATOR = new Parcelable.Creator<TimeInfosElement>() { // from class: com.amap.api.services.route.TimeInfosElement.1
        /* renamed from: a */
        private static TimeInfosElement m51759a(Parcel parcel) {
            return new TimeInfosElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfosElement createFromParcel(Parcel parcel) {
            return m51759a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfosElement[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    int f7858a;

    /* renamed from: b */
    float f7859b;

    /* renamed from: c */
    float f7860c;

    /* renamed from: d */
    int f7861d;

    /* renamed from: e */
    private List<TMC> f7862e;

    public TimeInfosElement(Parcel parcel) {
        this.f7862e = new ArrayList();
        this.f7858a = parcel.readInt();
        this.f7859b = parcel.readFloat();
        this.f7860c = parcel.readFloat();
        this.f7861d = parcel.readInt();
        this.f7862e = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDuration() {
        return this.f7859b;
    }

    public int getPathindex() {
        return this.f7858a;
    }

    public int getRestriction() {
        return this.f7861d;
    }

    public List<TMC> getTMCs() {
        return this.f7862e;
    }

    public float getTolls() {
        return this.f7860c;
    }

    public void setDuration(float f) {
        this.f7859b = f;
    }

    public void setPathindex(int i) {
        this.f7858a = i;
    }

    public void setRestriction(int i) {
        this.f7861d = i;
    }

    public void setTMCs(List<TMC> list) {
        this.f7862e = list;
    }

    public void setTolls(float f) {
        this.f7860c = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7858a);
        parcel.writeFloat(this.f7859b);
        parcel.writeFloat(this.f7860c);
        parcel.writeInt(this.f7861d);
        parcel.writeTypedList(this.f7862e);
    }

    public TimeInfosElement() {
        this.f7862e = new ArrayList();
    }
}
