package com.bytedance.sdk.component.r.w.c;

import android.content.Context;
import com.bytedance.sdk.component.r.w.c.c.w.ev;
import com.bytedance.sdk.component.r.w.c.c.w.r;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements ux {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.component.r.w.sr.w.c f30067a;
    private com.bytedance.sdk.component.r.c.ux bk;

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.component.r.w.c.c.w.sr f30068c;
    private com.bytedance.sdk.component.r.w.sr.w.c ev;

    /* renamed from: f  reason: collision with root package name */
    private ev f30069f;
    private com.bytedance.sdk.component.r.w.sr.w.c gd;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.sdk.component.r.w.sr.w.c f30070k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.component.r.w.sr.w.c f30071p;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.component.r.w.sr.w.c f30072r;
    private r sr;

    /* renamed from: t  reason: collision with root package name */
    private List<com.bytedance.sdk.component.r.w.c.c.w.w> f30073t = new ArrayList();
    private com.bytedance.sdk.component.r.w.c.c.w.c ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.r.w.c.c.w.f f30074w;
    private com.bytedance.sdk.component.r.w.c.c.w.ux xv;

    public sr(com.bytedance.sdk.component.r.c.ux uxVar) {
        this.bk = uxVar;
        Context context = uxVar.getContext();
        if (com.bytedance.sdk.component.r.w.w.c.c(uxVar)) {
            com.bytedance.sdk.component.r.w.sr.w.c r3 = this.bk.r();
            this.f30072r = r3;
            com.bytedance.sdk.component.r.w.c.c.w.sr srVar = new com.bytedance.sdk.component.r.w.c.c.w.sr(context, r3, this.bk);
            this.f30068c = srVar;
            this.f30073t.add(srVar);
        }
        if (com.bytedance.sdk.component.r.w.w.c.ux(uxVar)) {
            if (this.bk.c() != null) {
                this.gd = this.bk.c();
            } else {
                this.gd = this.bk.ev();
            }
            com.bytedance.sdk.component.r.w.c.c.w.ux uxVar2 = new com.bytedance.sdk.component.r.w.c.c.w.ux(context, this.gd, this.bk);
            this.xv = uxVar2;
            this.f30073t.add(uxVar2);
        }
        if (com.bytedance.sdk.component.r.w.w.c.w(uxVar)) {
            com.bytedance.sdk.component.r.w.sr.w.c ev = this.bk.ev();
            this.ev = ev;
            com.bytedance.sdk.component.r.w.c.c.w.f fVar = new com.bytedance.sdk.component.r.w.c.c.w.f(context, ev, this.bk);
            this.f30074w = fVar;
            this.f30073t.add(fVar);
        }
        if (com.bytedance.sdk.component.r.w.w.c.xv(uxVar)) {
            com.bytedance.sdk.component.r.w.sr.w.c ev2 = this.bk.ev();
            this.f30071p = ev2;
            r rVar = new r(context, ev2, this.bk);
            this.sr = rVar;
            this.f30073t.add(rVar);
        }
        if (com.bytedance.sdk.component.r.w.w.c.sr(uxVar)) {
            com.bytedance.sdk.component.r.w.sr.w.c gd = this.bk.gd();
            this.f30070k = gd;
            com.bytedance.sdk.component.r.w.c.c.w.c cVar = new com.bytedance.sdk.component.r.w.c.c.w.c(context, gd, this.bk);
            this.ux = cVar;
            this.f30073t.add(cVar);
        }
        if (com.bytedance.sdk.component.r.w.w.c.f(uxVar)) {
            com.bytedance.sdk.component.r.w.sr.w.c f4 = this.bk.f();
            this.f30067a = f4;
            ev evVar = new ev(context, f4, this.bk);
            this.f30069f = evVar;
            this.f30073t.add(evVar);
        }
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public List<com.bytedance.sdk.component.r.c.w> c(int i4, com.bytedance.sdk.component.r.c.w wVar, String str) {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public void c(com.bytedance.sdk.component.r.c.w wVar, int i4) {
        if (wVar == null) {
            return;
        }
        try {
            wVar.w(System.currentTimeMillis());
            for (com.bytedance.sdk.component.r.w.c.c.w.w wVar2 : this.f30073t) {
                wVar2.w(wVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.xv(), 1, this.bk);
        }
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public w c(int i4, List<com.bytedance.sdk.component.r.c.w> list) {
        com.bytedance.sdk.component.r.w.xv.xv.c("dbCache handleResult start", this.bk);
        w wVar = null;
        for (com.bytedance.sdk.component.r.w.c.c.w.w wVar2 : this.f30073t) {
            wVar = wVar2.c(i4, list);
            if (wVar.c()) {
                break;
            }
        }
        com.bytedance.sdk.component.r.w.xv.xv.c("dbCache handleResult end", this.bk);
        return wVar;
    }

    public List<com.bytedance.sdk.component.r.c.w> c(com.bytedance.sdk.component.r.c.w wVar, int i4, int i5) {
        for (com.bytedance.sdk.component.r.w.c.c.w.w wVar2 : this.f30073t) {
            List<com.bytedance.sdk.component.r.c.w> c4 = wVar2.c(i5, i4, wVar);
            if (c4 != null && c4.size() != 0) {
                return c4;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public List<com.bytedance.sdk.component.r.c.w> c(int i4, com.bytedance.sdk.component.r.c.w wVar, List<String> list) {
        for (com.bytedance.sdk.component.r.w.c.c.w.w wVar2 : this.f30073t) {
            List<com.bytedance.sdk.component.r.c.w> c4 = wVar2.c(i4, wVar, list, "db");
            if (c4 != null && c4.size() != 0) {
                return c4;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public boolean c(int i4, boolean z3, String str, com.bytedance.sdk.component.r.c.w wVar) {
        for (com.bytedance.sdk.component.r.w.c.c.w.w wVar2 : this.f30073t) {
            if (wVar2.c(i4, str, wVar)) {
                return true;
            }
        }
        return false;
    }
}
