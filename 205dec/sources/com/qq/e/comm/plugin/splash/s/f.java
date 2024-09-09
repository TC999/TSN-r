package com.qq.e.comm.plugin.splash.s;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.splash.s.b;
import com.qq.e.comm.plugin.splash.s.c;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements b, View.OnClickListener, c.a {

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.splash.h f46212c;

    /* renamed from: d  reason: collision with root package name */
    private final b.a f46213d;

    /* renamed from: e  reason: collision with root package name */
    private final b.InterfaceC0895b f46214e;

    /* renamed from: f  reason: collision with root package name */
    private com.qq.e.comm.plugin.o0.h.f f46215f;

    /* renamed from: g  reason: collision with root package name */
    private c f46216g;

    public f(com.qq.e.comm.plugin.splash.h hVar, b.InterfaceC0895b interfaceC0895b) {
        this.f46212c = hVar;
        this.f46214e = interfaceC0895b;
        this.f46213d = new b.a(hVar);
        c0 b4 = hVar.b();
        if (b4.n0() <= b4.o0()) {
            this.f46213d.setBackgroundColor(-16777216);
        }
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public ViewGroup a() {
        return this.f46213d;
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public com.qq.e.comm.plugin.o0.h.f b() {
        return this.f46215f;
    }

    @Override // com.qq.e.comm.plugin.f0.g.b
    public void c() {
        this.f46214e.c();
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public void d() {
        g gVar = new g(this.f46212c, this);
        this.f46213d.addView(gVar.a(), b.f46186b);
        this.f46216g = gVar;
    }

    @Override // com.qq.e.comm.plugin.f0.g.b
    public void h() {
        this.f46214e.h();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f46214e.a(0, view.getId(), 0);
    }

    private void b(boolean z3) {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f46215f;
        if (fVar != null) {
            if (!z3) {
                fVar.pause();
                this.f46215f.a((f.o) null);
                this.f46215f.i();
            }
            this.f46215f = null;
        }
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (this.f46213d.getChildCount() > 0) {
            this.f46213d.removeAllViews();
        }
        b(false);
        e eVar = new e(this.f46213d.getContext());
        eVar.a(file);
        this.f46213d.addView(eVar, b.f46186b);
    }

    @Override // com.qq.e.comm.plugin.splash.s.c.a
    public void b(int i4) {
        this.f46214e.a(0, i4, 0);
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public void a(String str, f.o oVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c0 b4 = this.f46212c.b();
        com.qq.e.comm.plugin.o0.h.f fVar = new com.qq.e.comm.plugin.o0.h.f(this.f46213d.getContext().getApplicationContext());
        fVar.c();
        fVar.setId(5);
        this.f46213d.addView(fVar, b.f46186b);
        fVar.a(b4);
        fVar.a(oVar);
        fVar.a(str);
        fVar.play();
        if (b4.Y0()) {
            fVar.a(f.r.f45183d);
        } else if (b4.N0() > b4.R0()) {
            fVar.a(f.r.f45184e);
        }
        this.f46215f = fVar;
        this.f46213d.f46188d = fVar;
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public void a(long j4) {
        c cVar = this.f46216g;
        if (cVar != null) {
            cVar.a(j4);
        }
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public void a(boolean z3) {
        b(z3);
        this.f46213d.a();
    }
}
