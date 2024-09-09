package com.qq.e.comm.plugin.p;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends Exception {

    /* renamed from: c  reason: collision with root package name */
    private final String f45205c;

    /* renamed from: d  reason: collision with root package name */
    private final int f45206d;

    public d(int i4, String str) {
        super(str);
        this.f45206d = i4;
        this.f45205c = str;
    }

    public int a() {
        return this.f45206d;
    }

    public String b() {
        return this.f45205c;
    }

    public d(int i4, String str, Throwable th) {
        super(str, th);
        this.f45206d = i4;
        this.f45205c = str;
    }
}
