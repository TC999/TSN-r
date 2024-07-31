package com.iab.omid.library.mmadbridge.adsession;

import androidx.annotation.NonNull;
import com.iab.omid.library.mmadbridge.adsession.media.C7083b;
import com.iab.omid.library.mmadbridge.p204d.C7105e;

/* renamed from: com.iab.omid.library.mmadbridge.adsession.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7074a {

    /* renamed from: a */
    private final C7081h f24190a;

    private C7074a(C7081h c7081h) {
        this.f24190a = c7081h;
    }

    /* renamed from: a */
    public static C7074a m34839a(AbstractC7075b abstractC7075b) {
        C7081h c7081h = (C7081h) abstractC7075b;
        C7105e.m34671d(abstractC7075b, "AdSession is null");
        C7105e.m34666i(c7081h);
        C7105e.m34668g(c7081h);
        C7074a c7074a = new C7074a(c7081h);
        c7081h.mo34802f().m34648d(c7074a);
        return c7074a;
    }

    /* renamed from: b */
    public void m34838b() {
        C7105e.m34668g(this.f24190a);
        C7105e.m34664k(this.f24190a);
        if (!this.f24190a.m34784x()) {
            try {
                this.f24190a.mo34797k();
            } catch (Exception unused) {
            }
        }
        if (this.f24190a.m34784x()) {
            this.f24190a.m34789s();
        }
    }

    /* renamed from: c */
    public void m34837c() {
        C7105e.m34667h(this.f24190a);
        C7105e.m34664k(this.f24190a);
        this.f24190a.m34787u();
    }

    /* renamed from: d */
    public void m34836d(@NonNull C7083b c7083b) {
        C7105e.m34671d(c7083b, "VastProperties is null");
        C7105e.m34667h(this.f24190a);
        C7105e.m34664k(this.f24190a);
        this.f24190a.m34792p(c7083b.m34765a());
    }
}
