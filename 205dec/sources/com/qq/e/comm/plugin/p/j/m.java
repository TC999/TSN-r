package com.qq.e.comm.plugin.p.j;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class m implements h {

    /* renamed from: a  reason: collision with root package name */
    private final String f45264a;

    /* renamed from: b  reason: collision with root package name */
    private final File f45265b;

    /* renamed from: c  reason: collision with root package name */
    private final long f45266c;

    /* renamed from: d  reason: collision with root package name */
    private final long f45267d;

    /* renamed from: e  reason: collision with root package name */
    private final com.qq.e.comm.plugin.p.j.o.b f45268e;

    /* renamed from: f  reason: collision with root package name */
    private int f45269f;

    /* renamed from: g  reason: collision with root package name */
    private String f45270g;

    /* renamed from: h  reason: collision with root package name */
    private com.qq.e.comm.plugin.p.j.o.a f45271h;

    /* renamed from: i  reason: collision with root package name */
    private AtomicBoolean f45272i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private e f45273j;

    public m(String str, File file, long j4, long j5, com.qq.e.comm.plugin.p.j.o.b bVar) {
        this.f45264a = str;
        this.f45265b = file;
        this.f45266c = j4;
        this.f45267d = j5;
        this.f45268e = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c2, code lost:
        if (r14 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f1, code lost:
        if (r14 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f3, code lost:
        r14.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f8, code lost:
        return r13.f45269f;
     */
    @Override // com.qq.e.comm.plugin.p.j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.qq.e.comm.plugin.p.j.c r14) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.p.j.m.a(com.qq.e.comm.plugin.p.j.c):int");
    }

    @Override // com.qq.e.comm.plugin.p.j.h
    public int b() {
        return this.f45269f;
    }

    @Override // com.qq.e.comm.plugin.p.j.h
    public void pause() {
        this.f45272i.compareAndSet(false, true);
        e eVar = this.f45273j;
        if (eVar != null) {
            eVar.pause();
        }
        com.qq.e.comm.plugin.p.j.o.a aVar = this.f45271h;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.qq.e.comm.plugin.p.j.h
    public String a() {
        return this.f45270g;
    }
}
