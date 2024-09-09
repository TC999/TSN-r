package com.qq.e.comm.plugin.d0.e;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public enum d {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");
    

    /* renamed from: c  reason: collision with root package name */
    private int f42296c;

    /* renamed from: d  reason: collision with root package name */
    private int f42297d;

    /* renamed from: e  reason: collision with root package name */
    private String f42298e;

    d(int i4, int i5, String str) {
        this.f42296c = i4;
        this.f42297d = i5;
        this.f42298e = str;
    }

    public int a() {
        return this.f42296c;
    }

    public String b() {
        return this.f42298e;
    }

    public int c() {
        return this.f42297d;
    }
}
