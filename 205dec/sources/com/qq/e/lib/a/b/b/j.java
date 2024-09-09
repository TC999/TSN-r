package com.qq.e.lib.a.b.b;

import java.io.IOException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class j extends e {

    /* renamed from: f  reason: collision with root package name */
    static final int f47298f = e.a("IHDR");

    /* renamed from: c  reason: collision with root package name */
    int f47299c;

    /* renamed from: d  reason: collision with root package name */
    int f47300d;

    /* renamed from: e  reason: collision with root package name */
    byte[] f47301e = new byte[5];

    @Override // com.qq.e.lib.a.b.b.e
    void a(com.qq.e.lib.a.b.c.a aVar) throws IOException {
        this.f47299c = aVar.d();
        this.f47300d = aVar.d();
        byte[] bArr = this.f47301e;
        aVar.read(bArr, 0, bArr.length);
    }
}
