package com.qq.e.comm.plugin.gdtnativead.p.b;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements e {

    /* renamed from: h  reason: collision with root package name */
    private static final String f43956h = "b";

    /* renamed from: a  reason: collision with root package name */
    private final d f43957a;

    /* renamed from: b  reason: collision with root package name */
    private f f43958b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f43959c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f43960d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f43961e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f43962f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f43963g;

    public b(d dVar) {
        this.f43957a = dVar;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.e
    public void a(f fVar) {
        this.f43958b = fVar;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.e
    public void b() {
        a(this.f43957a.e(), a());
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.e
    public boolean c() {
        return a(g(), a());
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.e
    public com.qq.e.comm.plugin.g0.e d() {
        return this.f43957a.d();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.e
    public void destroy() {
        if (!this.f43961e && !this.f43959c) {
            this.f43957a.g();
        }
        if (!this.f43962f || this.f43963g) {
            return;
        }
        this.f43957a.i();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.e
    public void e() {
        a(g());
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.e
    public void f() {
        this.f43963g = true;
        this.f43957a.f();
    }

    boolean g() {
        return this.f43959c;
    }

    boolean h() {
        return this.f43960d;
    }

    void a(boolean z3) {
        if (z3) {
            return;
        }
        if (!this.f43961e) {
            this.f43957a.h();
        }
        this.f43961e = true;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.e
    public void a(String str) {
        a(str, g(), h());
    }

    void a(String str, boolean z3, boolean z4) {
        f fVar;
        if (z3) {
            return;
        }
        this.f43957a.a(str);
        this.f43959c = true;
        if (z4 || (fVar = this.f43958b) == null) {
            return;
        }
        fVar.loadUrl(str);
        this.f43960d = true;
    }

    void a(String str, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            d1.b(f43956h, "load, Url isEmpty");
        } else if (z3) {
            String str2 = f43956h;
            d1.a(str2, "load, has loaded:" + z3);
        } else {
            this.f43961e = false;
            this.f43960d = false;
            this.f43959c = false;
            if (this.f43958b != null) {
                this.f43957a.k();
                this.f43962f = true;
                this.f43958b.loadUrl(str);
            }
        }
    }

    boolean a(boolean z3, boolean z4) {
        if (z3) {
            d1.b(f43956h, "show(), mWebViewReceivedError = true");
            this.f43957a.a(9001);
            return false;
        } else if (!z4) {
            d1.b(f43956h, "show(), mHasLoaded = false");
            this.f43957a.a(9000);
            return false;
        } else {
            this.f43957a.j();
            return true;
        }
    }

    boolean a() {
        return this.f43961e;
    }
}
