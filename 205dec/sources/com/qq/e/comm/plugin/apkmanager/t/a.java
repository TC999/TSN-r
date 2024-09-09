package com.qq.e.comm.plugin.apkmanager.t;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.apkmanager.t.b.f;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.q0.d;
import com.qq.e.comm.plugin.q0.g;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.t.b;
import com.qq.e.comm.plugin.q0.t.c;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements b, ACTD, g {

    /* renamed from: c  reason: collision with root package name */
    private h f41890c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f41891d;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.apkmanager.t.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static /* synthetic */ class C0785a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41892a;

        static {
            int[] iArr = new int[c.values().length];
            f41892a = iArr;
            try {
                iArr[c.DownloadClosed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public a(Activity activity) {
        this.f41891d = activity;
    }

    private void b() {
        this.f41891d.finish();
    }

    private void c() {
        this.f41890c.loadUrl(a());
    }

    private void d() {
        h a4 = new d(this.f41891d.getApplicationContext(), (e) null, this).d(true).a(this).a();
        this.f41890c = a4;
        a4.c().a(com.qq.e.comm.plugin.apkmanager.t.b.a.b()).a(com.qq.e.comm.plugin.apkmanager.t.b.d.b()).a(com.qq.e.comm.plugin.apkmanager.t.b.b.b()).a(com.qq.e.comm.plugin.apkmanager.t.b.c.b()).a(com.qq.e.comm.plugin.apkmanager.t.b.e.b()).a(f.b());
    }

    @Override // com.qq.e.comm.plugin.q0.t.b
    public void a(com.qq.e.comm.plugin.q0.t.a aVar) {
        if (C0785a.f41892a[aVar.b().ordinal()] != 1) {
            return;
        }
        b();
    }

    @Override // com.qq.e.comm.plugin.q0.g
    public com.qq.e.comm.plugin.b.g g() {
        return null;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i4, int i5, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        d();
        ViewParent parent = this.f41890c.a().getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.f41890c.a());
        }
        this.f41891d.setContentView(this.f41890c.a());
        c();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        b();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        k.e().h();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        h hVar = this.f41890c;
        if (hVar != null) {
            hVar.e();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    private String a() {
        String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("dmpurl", "https://qzonestyle.gtimg.cn/qzone/biz/gdt/mob/sdk/v2/android01/download.html");
        d1.a("DownloadURL=" + b4, new Object[0]);
        return b4;
    }
}
