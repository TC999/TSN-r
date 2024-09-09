package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i4) {
            return new UserInfoBean[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public long f50719a;

    /* renamed from: b  reason: collision with root package name */
    public int f50720b;

    /* renamed from: c  reason: collision with root package name */
    public String f50721c;

    /* renamed from: d  reason: collision with root package name */
    public String f50722d;

    /* renamed from: e  reason: collision with root package name */
    public long f50723e;

    /* renamed from: f  reason: collision with root package name */
    public long f50724f;

    /* renamed from: g  reason: collision with root package name */
    public long f50725g;

    /* renamed from: h  reason: collision with root package name */
    public long f50726h;

    /* renamed from: i  reason: collision with root package name */
    public long f50727i;

    /* renamed from: j  reason: collision with root package name */
    public String f50728j;

    /* renamed from: k  reason: collision with root package name */
    public long f50729k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f50730l;

    /* renamed from: m  reason: collision with root package name */
    public String f50731m;

    /* renamed from: n  reason: collision with root package name */
    public String f50732n;

    /* renamed from: o  reason: collision with root package name */
    public int f50733o;

    /* renamed from: p  reason: collision with root package name */
    public int f50734p;

    /* renamed from: q  reason: collision with root package name */
    public int f50735q;

    /* renamed from: r  reason: collision with root package name */
    public Map<String, String> f50736r;

    /* renamed from: s  reason: collision with root package name */
    public Map<String, String> f50737s;

    public UserInfoBean() {
        this.f50729k = 0L;
        this.f50730l = false;
        this.f50731m = "unknown";
        this.f50734p = -1;
        this.f50735q = -1;
        this.f50736r = null;
        this.f50737s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f50720b);
        parcel.writeString(this.f50721c);
        parcel.writeString(this.f50722d);
        parcel.writeLong(this.f50723e);
        parcel.writeLong(this.f50724f);
        parcel.writeLong(this.f50725g);
        parcel.writeLong(this.f50726h);
        parcel.writeLong(this.f50727i);
        parcel.writeString(this.f50728j);
        parcel.writeLong(this.f50729k);
        parcel.writeByte(this.f50730l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f50731m);
        parcel.writeInt(this.f50734p);
        parcel.writeInt(this.f50735q);
        ap.b(parcel, this.f50736r);
        ap.b(parcel, this.f50737s);
        parcel.writeString(this.f50732n);
        parcel.writeInt(this.f50733o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f50729k = 0L;
        this.f50730l = false;
        this.f50731m = "unknown";
        this.f50734p = -1;
        this.f50735q = -1;
        this.f50736r = null;
        this.f50737s = null;
        this.f50720b = parcel.readInt();
        this.f50721c = parcel.readString();
        this.f50722d = parcel.readString();
        this.f50723e = parcel.readLong();
        this.f50724f = parcel.readLong();
        this.f50725g = parcel.readLong();
        this.f50726h = parcel.readLong();
        this.f50727i = parcel.readLong();
        this.f50728j = parcel.readString();
        this.f50729k = parcel.readLong();
        this.f50730l = parcel.readByte() == 1;
        this.f50731m = parcel.readString();
        this.f50734p = parcel.readInt();
        this.f50735q = parcel.readInt();
        this.f50736r = ap.b(parcel);
        this.f50737s = ap.b(parcel);
        this.f50732n = parcel.readString();
        this.f50733o = parcel.readInt();
    }
}
