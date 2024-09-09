package com.qq.e.comm.plugin.p.j;

import java.io.File;
import java.io.IOException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class e implements h {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.p.j.o.a f45219a;

    /* renamed from: b  reason: collision with root package name */
    private final File f45220b;

    /* renamed from: c  reason: collision with root package name */
    private final long f45221c;

    /* renamed from: d  reason: collision with root package name */
    private String f45222d;

    /* renamed from: e  reason: collision with root package name */
    private int f45223e;

    /* renamed from: f  reason: collision with root package name */
    private a f45224f;

    public e(com.qq.e.comm.plugin.p.j.o.a aVar, File file, long j4) {
        this.f45219a = aVar;
        this.f45220b = file;
        this.f45221c = j4;
    }

    @Override // com.qq.e.comm.plugin.p.j.h
    public int a(c cVar) {
        long length;
        try {
            length = this.f45221c - this.f45220b.length();
        } catch (IOException e4) {
            this.f45223e |= 4194304;
            this.f45222d = "UnknownNetworkExceptionWhileDoMainPartitionDownloaderWork" + e4.getMessage();
        } catch (IllegalStateException unused) {
            this.f45223e |= 8388608;
            this.f45222d = "IllegalStateExceptionWhileDoMainPartitionDownloaderWork";
        }
        if (length == 0 && this.f45221c > 0) {
            cVar.a(this.f45220b.length());
            return 0;
        }
        if (this.f45221c <= 0) {
            this.f45224f = new k(this.f45219a.i(), this.f45220b, cVar);
        } else {
            this.f45224f = new j(this.f45219a.i(), length, this.f45220b, cVar);
        }
        this.f45223e |= this.f45224f.a();
        this.f45222d = this.f45224f.b();
        return this.f45223e;
    }

    @Override // com.qq.e.comm.plugin.p.j.h
    public int b() {
        return this.f45223e;
    }

    @Override // com.qq.e.comm.plugin.p.j.h
    public void pause() {
        a aVar = this.f45224f;
        if (aVar != null) {
            aVar.c();
        }
        com.qq.e.comm.plugin.p.j.o.a aVar2 = this.f45219a;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @Override // com.qq.e.comm.plugin.p.j.h
    public String a() {
        return this.f45222d;
    }
}
