package com.qq.e.comm.plugin.o0;

import com.qq.e.comm.plugin.o0.h.f;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements f.o {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.o0.h.e f45024a;

    /* renamed from: b  reason: collision with root package name */
    private final f.o f45025b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f45026c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f45027d;

    /* renamed from: e  reason: collision with root package name */
    private int f45028e;

    public a(com.qq.e.comm.plugin.o0.h.e eVar, f.o oVar, com.qq.e.comm.plugin.g0.e eVar2) {
        this.f45024a = eVar;
        this.f45025b = oVar;
        this.f45026c = com.qq.e.comm.plugin.n0.c.a(eVar2);
        this.f45027d = eVar2;
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void a(int i4, Exception exc) {
        f.o oVar = this.f45025b;
        if (oVar != null) {
            oVar.a(i4, exc);
        }
        e.a(this.f45026c, i4, exc.getMessage(), this.f45027d);
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void b() {
        f.o oVar = this.f45025b;
        if (oVar != null) {
            oVar.b();
        }
        if (this.f45028e > 0) {
            e.b(this.f45026c, this.f45024a.getDuration(), this.f45024a.getCurrentPosition());
        }
        e.a(this.f45026c, this.f45024a.getDuration(), this.f45028e);
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void c() {
        f.o oVar = this.f45025b;
        if (oVar != null) {
            oVar.c();
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoComplete() {
        f.o oVar = this.f45025b;
        if (oVar != null) {
            oVar.onVideoComplete();
        }
        e.a(this.f45026c, this.f45024a.getDuration());
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoPause() {
        f.o oVar = this.f45025b;
        if (oVar != null) {
            oVar.onVideoPause();
        }
        e.a(this.f45026c, this.f45024a.getDuration(), this.f45024a.b(), false);
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoReady() {
        f.o oVar = this.f45025b;
        if (oVar != null) {
            oVar.onVideoReady();
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoResume() {
        f.o oVar = this.f45025b;
        if (oVar != null) {
            oVar.onVideoResume();
        }
        e.b(this.f45026c, this.f45024a.getDuration(), this.f45024a.b(), false);
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoStart() {
        this.f45028e++;
        f.o oVar = this.f45025b;
        if (oVar != null) {
            oVar.onVideoStart();
        }
        if (this.f45028e > 1) {
            e.a(this.f45026c, this.f45024a.getDuration(), this.f45028e, true);
        } else {
            e.a(this.f45026c, this.f45024a.getDuration(), false, this.f45027d);
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoStop() {
        f.o oVar = this.f45025b;
        if (oVar != null) {
            oVar.onVideoStop();
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void a() {
        f.o oVar = this.f45025b;
        if (oVar != null) {
            oVar.a();
        }
    }
}
