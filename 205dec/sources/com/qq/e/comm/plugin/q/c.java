package com.qq.e.comm.plugin.q;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.apkmanager.w.b;
import com.qq.e.comm.plugin.dysi.IGDTADM;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.util.j0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements IGDTADM {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f45364a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f45365b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f45366c;

    public c(com.qq.e.comm.plugin.g0.e eVar, y yVar) {
        this.f45366c = com.qq.e.comm.plugin.d0.a.d().f().a("dfwrdtmd", 1) == 1;
        this.f45364a = eVar;
        this.f45365b = com.qq.e.comm.plugin.n0.c.a(eVar, yVar);
    }

    private String a(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.g0.b q3 = eVar.q();
        if (q3 == null) {
            return null;
        }
        return q3.e();
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTADM
    public void pause() {
        ApkDownloadTask c4;
        String a4 = a(this.f45364a);
        if (TextUtils.isEmpty(a4) || (c4 = k.e().c(a4)) == null) {
            return;
        }
        k.e().a(c4);
        com.qq.e.comm.plugin.n0.w.b.b(4001004, c4, 1, 103);
        com.qq.e.comm.plugin.apkmanager.x.d.a(a4, 1100954, this.f45365b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTADM
    public void remove() {
        ApkDownloadTask c4;
        String a4 = a(this.f45364a);
        if (TextUtils.isEmpty(a4) || (c4 = k.e().c(a4)) == null) {
            return;
        }
        com.qq.e.comm.plugin.n0.w.b.a(a4).f44822b = 2;
        com.qq.e.comm.plugin.n0.w.b.a(4001074, c4, 1);
        if (k.e().a(c4, this.f45366c)) {
            com.qq.e.comm.plugin.n0.w.b.a(4001075, c4, 1);
        }
        com.qq.e.comm.plugin.apkmanager.x.d.a(a4, 1100956, this.f45365b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTADM
    public void resume() {
        ApkDownloadTask c4;
        String a4 = a(this.f45364a);
        if (TextUtils.isEmpty(a4) || (c4 = k.e().c(a4)) == null) {
            return;
        }
        k.e().b(c4);
        com.qq.e.comm.plugin.n0.w.b.b(4001005, c4, 1, 103);
        com.qq.e.comm.plugin.apkmanager.x.d.a(a4, 1100955, this.f45365b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTADM
    public String status() {
        j0 j0Var = new j0();
        String a4 = a(this.f45364a);
        if (TextUtils.isEmpty(a4)) {
            j0Var.a("status", 0);
            j0Var.a("totalSize", 0);
            j0Var.a("progress", 0);
            return j0Var.toString();
        }
        Context a5 = com.qq.e.comm.plugin.d0.a.d().a();
        b.c b4 = com.qq.e.comm.plugin.apkmanager.w.b.a().b(a5, a4);
        j0Var.a("status", com.qq.e.comm.plugin.apkmanager.w.b.a().d(a5, a4));
        j0Var.a("totalSize", Long.toString(this.f45364a.q().f()));
        j0Var.a("progress", b4.f41935b);
        return j0Var.toString();
    }
}
