package com.iab.omid.library.mmadbridge.b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.mmadbridge.adsession.h;
import com.iab.omid.library.mmadbridge.b.b;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f implements n0.c, b.a {

    /* renamed from: f  reason: collision with root package name */
    private static f f37725f;

    /* renamed from: a  reason: collision with root package name */
    private float f37726a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private final n0.e f37727b;

    /* renamed from: c  reason: collision with root package name */
    private final n0.b f37728c;

    /* renamed from: d  reason: collision with root package name */
    private n0.d f37729d;

    /* renamed from: e  reason: collision with root package name */
    private a f37730e;

    public f(n0.e eVar, n0.b bVar) {
        this.f37727b = eVar;
        this.f37728c = bVar;
    }

    public static f b() {
        if (f37725f == null) {
            f37725f = new f(new n0.e(), new n0.b());
        }
        return f37725f;
    }

    private a g() {
        if (this.f37730e == null) {
            this.f37730e = a.a();
        }
        return this.f37730e;
    }

    @Override // n0.c
    public void a(float f4) {
        this.f37726a = f4;
        for (h hVar : g().e()) {
            hVar.f().b(f4);
        }
    }

    @Override // com.iab.omid.library.mmadbridge.b.b.a
    public void a(boolean z3) {
        if (z3) {
            com.iab.omid.library.mmadbridge.walking.a.q().c();
        } else {
            com.iab.omid.library.mmadbridge.walking.a.q().l();
        }
    }

    public void c(Context context) {
        this.f37729d = this.f37727b.a(new Handler(), context, this.f37728c.a(), this);
    }

    public void d() {
        b.a().c(this);
        b.a().e();
        com.iab.omid.library.mmadbridge.walking.a.q().c();
        this.f37729d.a();
    }

    public void e() {
        com.iab.omid.library.mmadbridge.walking.a.q().i();
        b.a().f();
        this.f37729d.c();
    }

    public float f() {
        return this.f37726a;
    }
}
