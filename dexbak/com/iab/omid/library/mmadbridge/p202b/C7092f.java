package com.iab.omid.library.mmadbridge.p202b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.mmadbridge.adsession.C7081h;
import com.iab.omid.library.mmadbridge.p202b.C7086b;
import com.iab.omid.library.mmadbridge.walking.C7113a;
import p623n0.C15374b;
import p623n0.C15376d;
import p623n0.C15377e;
import p623n0.InterfaceC15375c;

/* renamed from: com.iab.omid.library.mmadbridge.b.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7092f implements InterfaceC15375c, C7086b.InterfaceC7087a {

    /* renamed from: f */
    private static C7092f f24243f;

    /* renamed from: a */
    private float f24244a = 0.0f;

    /* renamed from: b */
    private final C15377e f24245b;

    /* renamed from: c */
    private final C15374b f24246c;

    /* renamed from: d */
    private C15376d f24247d;

    /* renamed from: e */
    private C7085a f24248e;

    public C7092f(C15377e c15377e, C15374b c15374b) {
        this.f24245b = c15377e;
        this.f24246c = c15374b;
    }

    /* renamed from: b */
    public static C7092f m34717b() {
        if (f24243f == null) {
            f24243f = new C7092f(new C15377e(), new C15374b());
        }
        return f24243f;
    }

    /* renamed from: g */
    private C7085a m34712g() {
        if (this.f24248e == null) {
            this.f24248e = C7085a.m34757a();
        }
        return this.f24248e;
    }

    @Override // p623n0.InterfaceC15375c
    /* renamed from: a */
    public void mo2880a(float f) {
        this.f24244a = f;
        for (C7081h c7081h : m34712g().m34753e()) {
            c7081h.mo34802f().m34650b(f);
        }
    }

    @Override // com.iab.omid.library.mmadbridge.p202b.C7086b.InterfaceC7087a
    /* renamed from: a */
    public void mo34718a(boolean z) {
        if (z) {
            C7113a.m34608q().m34622c();
        } else {
            C7113a.m34608q().m34613l();
        }
    }

    /* renamed from: c */
    public void m34716c(Context context) {
        this.f24247d = this.f24245b.m2874a(new Handler(), context, this.f24246c.m2881a(), this);
    }

    /* renamed from: d */
    public void m34715d() {
        C7086b.m34750a().m34748c(this);
        C7086b.m34750a().m34746e();
        C7113a.m34608q().m34622c();
        this.f24247d.m2879a();
    }

    /* renamed from: e */
    public void m34714e() {
        C7113a.m34608q().m34616i();
        C7086b.m34750a().m34745f();
        this.f24247d.m2877c();
    }

    /* renamed from: f */
    public float m34713f() {
        return this.f24244a;
    }
}
