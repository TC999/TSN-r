package com.qq.e.comm.plugin.s;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends Exception {

    /* renamed from: c  reason: collision with root package name */
    private int f46006c;

    public b(String str, Throwable th, int i4) {
        super(str, th);
        this.f46006c = i4;
    }

    public int a() {
        return this.f46006c;
    }

    public b(Throwable th, int i4) {
        super(th);
        this.f46006c = i4;
    }

    public b(String str, int i4) {
        super(str);
        this.f46006c = i4;
    }
}
