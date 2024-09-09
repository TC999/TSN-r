package com.iab.omid.library.mmadbridge.adsession;

import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final h f37672a;

    private a(h hVar) {
        this.f37672a = hVar;
    }

    public static a a(b bVar) {
        h hVar = (h) bVar;
        com.iab.omid.library.mmadbridge.d.e.d(bVar, "AdSession is null");
        com.iab.omid.library.mmadbridge.d.e.i(hVar);
        com.iab.omid.library.mmadbridge.d.e.g(hVar);
        a aVar = new a(hVar);
        hVar.f().d(aVar);
        return aVar;
    }

    public void b() {
        com.iab.omid.library.mmadbridge.d.e.g(this.f37672a);
        com.iab.omid.library.mmadbridge.d.e.k(this.f37672a);
        if (!this.f37672a.x()) {
            try {
                this.f37672a.k();
            } catch (Exception unused) {
            }
        }
        if (this.f37672a.x()) {
            this.f37672a.s();
        }
    }

    public void c() {
        com.iab.omid.library.mmadbridge.d.e.h(this.f37672a);
        com.iab.omid.library.mmadbridge.d.e.k(this.f37672a);
        this.f37672a.u();
    }

    public void d(@NonNull com.iab.omid.library.mmadbridge.adsession.media.b bVar) {
        com.iab.omid.library.mmadbridge.d.e.d(bVar, "VastProperties is null");
        com.iab.omid.library.mmadbridge.d.e.h(this.f37672a);
        com.iab.omid.library.mmadbridge.d.e.k(this.f37672a);
        this.f37672a.p(bVar.a());
    }
}
