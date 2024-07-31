package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: BUGLY */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i) {
            return new PlugInBean[i];
        }
    };

    /* renamed from: a */
    public final String f36288a;

    /* renamed from: b */
    public final String f36289b;

    /* renamed from: c */
    public final String f36290c;

    public PlugInBean(String str, String str2, String str3) {
        this.f36288a = str;
        this.f36289b = str2;
        this.f36290c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f36288a + " plV:" + this.f36289b + " plUUID:" + this.f36290c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f36288a);
        parcel.writeString(this.f36289b);
        parcel.writeString(this.f36290c);
    }

    public PlugInBean(Parcel parcel) {
        this.f36288a = parcel.readString();
        this.f36289b = parcel.readString();
        this.f36290c = parcel.readString();
    }
}
