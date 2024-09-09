package cn.jiguang.common.m;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class h extends g {
    public static final Parcelable.Creator<h> CREATOR = new Parcelable.Creator<h>() { // from class: cn.jiguang.common.m.h.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public h[] newArray(int i4) {
            return new h[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String[] f3535a;

    private h(Parcel parcel) {
        super(parcel);
        this.f3535a = parcel.createStringArray();
    }

    private h(String str) {
        super(str);
        this.f3535a = this.f3534b.split("\\s+");
    }

    public static h a(int i4) {
        return new h(String.format(Locale.ENGLISH, "/proc/%d/stat", Integer.valueOf(i4)));
    }

    public String a() {
        return this.f3535a[1].replace("(", "").replace(")", "");
    }

    public char b() {
        return this.f3535a[2].charAt(0);
    }

    public int c() {
        return Integer.parseInt(this.f3535a[7]);
    }

    public long d() {
        return Long.parseLong(this.f3535a[13]);
    }

    public long e() {
        return Long.parseLong(this.f3535a[14]);
    }

    public long f() {
        return Long.parseLong(this.f3535a[15]);
    }

    public long g() {
        return Long.parseLong(this.f3535a[16]);
    }

    public long h() {
        return Long.parseLong(this.f3535a[17]);
    }

    public long i() {
        return Long.parseLong(this.f3535a[19]);
    }

    public long j() {
        return Long.parseLong(this.f3535a[21]);
    }

    public long k() {
        return Long.parseLong(this.f3535a[22]);
    }

    public int l() {
        return Integer.parseInt(this.f3535a[39]);
    }

    public int m() {
        return Integer.parseInt(this.f3535a[40]);
    }

    @Override // cn.jiguang.common.m.g, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeStringArray(this.f3535a);
    }
}
