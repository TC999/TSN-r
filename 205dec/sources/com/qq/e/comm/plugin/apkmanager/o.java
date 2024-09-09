package com.qq.e.comm.plugin.apkmanager;

import com.qq.e.comm.plugin.apkmanager.a;
import com.qq.e.comm.plugin.apkmanager.c;
import com.qq.e.comm.plugin.i.u;
import com.qq.e.comm.plugin.util.d0;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class o implements a.InterfaceC0780a, c.a {

    /* renamed from: a  reason: collision with root package name */
    private final c f41866a;

    /* renamed from: b  reason: collision with root package name */
    private final a f41867b;

    /* renamed from: c  reason: collision with root package name */
    private final ApkDownloadTask f41868c;

    public o(a aVar, c cVar, ApkDownloadTask apkDownloadTask) {
        this.f41866a = cVar;
        this.f41867b = aVar;
        this.f41868c = apkDownloadTask;
        aVar.a(this);
        cVar.a(this);
    }

    public void a(int i4, String str) {
        throw null;
    }

    @Override // com.qq.e.comm.plugin.apkmanager.c.a
    public void a(int i4, String str, boolean z3) {
        if (i4 == 0) {
            if (!z3) {
                u.a(this.f41868c, 2);
            }
            com.qq.e.comm.plugin.n0.w.b.a(this.f41868c.r()).f41953i = 2;
            u.a(this.f41868c);
        }
        a(i4, str);
    }

    @Override // com.qq.e.comm.plugin.apkmanager.a.InterfaceC0780a
    public void a(long j4, long j5) {
    }

    @Override // com.qq.e.comm.plugin.apkmanager.c.a
    public boolean a() {
        return false;
    }

    public void b() {
        d0.f46406b.submit(this.f41867b);
    }

    @Override // com.qq.e.comm.plugin.apkmanager.a.InterfaceC0780a
    public void onStatusChanged(int i4) {
        if (i4 == 3) {
            u.a(this.f41868c, 0);
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.a.InterfaceC0780a
    public void a(int i4, String str, File file) {
        if (i4 == 0) {
            u.a(this.f41868c, 1);
        }
        if (i4 == 9 || (i4 == 0 && this.f41868c.a("autoInstall"))) {
            this.f41866a.a(file, i4 == 0);
        }
        a(i4, str);
    }
}
