package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i4) {
            return new PlugInBean[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f50738a;

    /* renamed from: b  reason: collision with root package name */
    public final String f50739b;

    /* renamed from: c  reason: collision with root package name */
    public final String f50740c;

    public PlugInBean(String str, String str2, String str3) {
        this.f50738a = str;
        this.f50739b = str2;
        this.f50740c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f50738a + " plV:" + this.f50739b + " plUUID:" + this.f50740c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f50738a);
        parcel.writeString(this.f50739b);
        parcel.writeString(this.f50740c);
    }

    public PlugInBean(Parcel parcel) {
        this.f50738a = parcel.readString();
        this.f50739b = parcel.readString();
        this.f50740c = parcel.readString();
    }
}
