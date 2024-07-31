package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.C12828ap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i) {
            return new UserInfoBean[i];
        }
    };

    /* renamed from: a */
    public long f36269a;

    /* renamed from: b */
    public int f36270b;

    /* renamed from: c */
    public String f36271c;

    /* renamed from: d */
    public String f36272d;

    /* renamed from: e */
    public long f36273e;

    /* renamed from: f */
    public long f36274f;

    /* renamed from: g */
    public long f36275g;

    /* renamed from: h */
    public long f36276h;

    /* renamed from: i */
    public long f36277i;

    /* renamed from: j */
    public String f36278j;

    /* renamed from: k */
    public long f36279k;

    /* renamed from: l */
    public boolean f36280l;

    /* renamed from: m */
    public String f36281m;

    /* renamed from: n */
    public String f36282n;

    /* renamed from: o */
    public int f36283o;

    /* renamed from: p */
    public int f36284p;

    /* renamed from: q */
    public int f36285q;

    /* renamed from: r */
    public Map<String, String> f36286r;

    /* renamed from: s */
    public Map<String, String> f36287s;

    public UserInfoBean() {
        this.f36279k = 0L;
        this.f36280l = false;
        this.f36281m = "unknown";
        this.f36284p = -1;
        this.f36285q = -1;
        this.f36286r = null;
        this.f36287s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f36270b);
        parcel.writeString(this.f36271c);
        parcel.writeString(this.f36272d);
        parcel.writeLong(this.f36273e);
        parcel.writeLong(this.f36274f);
        parcel.writeLong(this.f36275g);
        parcel.writeLong(this.f36276h);
        parcel.writeLong(this.f36277i);
        parcel.writeString(this.f36278j);
        parcel.writeLong(this.f36279k);
        parcel.writeByte(this.f36280l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f36281m);
        parcel.writeInt(this.f36284p);
        parcel.writeInt(this.f36285q);
        C12828ap.m15819b(parcel, this.f36286r);
        C12828ap.m15819b(parcel, this.f36287s);
        parcel.writeString(this.f36282n);
        parcel.writeInt(this.f36283o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f36279k = 0L;
        this.f36280l = false;
        this.f36281m = "unknown";
        this.f36284p = -1;
        this.f36285q = -1;
        this.f36286r = null;
        this.f36287s = null;
        this.f36270b = parcel.readInt();
        this.f36271c = parcel.readString();
        this.f36272d = parcel.readString();
        this.f36273e = parcel.readLong();
        this.f36274f = parcel.readLong();
        this.f36275g = parcel.readLong();
        this.f36276h = parcel.readLong();
        this.f36277i = parcel.readLong();
        this.f36278j = parcel.readString();
        this.f36279k = parcel.readLong();
        this.f36280l = parcel.readByte() == 1;
        this.f36281m = parcel.readString();
        this.f36284p = parcel.readInt();
        this.f36285q = parcel.readInt();
        this.f36286r = C12828ap.m15820b(parcel);
        this.f36287s = C12828ap.m15820b(parcel);
        this.f36282n = parcel.readString();
        this.f36283o = parcel.readInt();
    }
}
