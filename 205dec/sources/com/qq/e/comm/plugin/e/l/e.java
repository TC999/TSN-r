package com.qq.e.comm.plugin.e.l;

import android.content.Context;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    private final String f42767b;

    public e(String str) {
        this.f42767b = str;
    }

    @Override // com.qq.e.comm.plugin.e.l.a
    protected com.qq.e.comm.plugin.e.c a() {
        return new com.qq.e.comm.plugin.e.c();
    }

    @Override // com.qq.e.comm.plugin.e.l.a
    protected com.qq.e.comm.plugin.e.c b(int i4) {
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        return new com.qq.e.comm.plugin.e.i.c(this.f42767b, new com.qq.e.comm.plugin.e.i.e(a4, new com.qq.e.comm.plugin.e.i.b(a4))).a();
    }
}
