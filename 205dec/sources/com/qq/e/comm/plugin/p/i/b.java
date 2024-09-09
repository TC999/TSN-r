package com.qq.e.comm.plugin.p.i;

import com.qq.e.comm.plugin.p.e;
import com.qq.e.comm.plugin.util.v0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private int f45212a;

    /* renamed from: b  reason: collision with root package name */
    private int f45213b;

    public b(int i4) {
        this.f45213b = i4;
    }

    @Override // com.qq.e.comm.plugin.p.i.c
    public boolean a(int i4) {
        int i5 = this.f45212a + 1;
        this.f45212a = i5;
        return i5 < 30 && e.d(i4) && !e.e(i4) && !e.a(i4);
    }

    @Override // com.qq.e.comm.plugin.p.i.c
    public int b() {
        return this.f45212a;
    }

    @Override // com.qq.e.comm.plugin.p.i.c
    public long c() {
        return 3000L;
    }

    @Override // com.qq.e.comm.plugin.p.i.c
    public boolean a() {
        return this.f45213b != 0 && v0.e() && this.f45213b < com.qq.e.comm.plugin.d0.a.d().c().n().a();
    }
}
