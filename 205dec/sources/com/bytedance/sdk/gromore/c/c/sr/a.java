package com.bytedance.sdk.gromore.c.c.sr;

import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a implements fz {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.r.c f31164c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.ev f31165w;

    public a(com.bytedance.msdk.core.admanager.ev evVar, com.bytedance.msdk.api.sr.c.r.c cVar) {
        this.f31164c = cVar;
        this.f31165w = evVar;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public boolean c() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31164c;
        if (cVar != null) {
            return cVar.xv();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public boolean ev() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31164c;
        if (cVar != null) {
            return cVar.n();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w f() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31164c;
        if (cVar != null) {
            return new f(cVar.ia());
        }
        return new ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void gd() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31164c;
        if (cVar != null) {
            cVar.wv();
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void p() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31164c;
        if (cVar != null) {
            cVar.me();
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public boolean r() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31164c;
        if (cVar != null) {
            return cVar.ck();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w sr() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31164c;
        if (cVar != null) {
            return new f(cVar.s());
        }
        return new ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.w> ux() {
        List<com.bytedance.msdk.api.xv> m4;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.core.admanager.ev evVar = this.f31165w;
        if (evVar != null && (m4 = evVar.m()) != null) {
            for (com.bytedance.msdk.api.xv xvVar : m4) {
                if (xvVar != null) {
                    arrayList.add(new f(xvVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.sr> w() {
        List<com.bytedance.msdk.api.w> wo;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.core.admanager.ev evVar = this.f31165w;
        if (evVar != null && (wo = evVar.wo()) != null) {
            for (com.bytedance.msdk.api.w wVar : wo) {
                if (wVar != null) {
                    arrayList.add(new c(wVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.w> xv() {
        List<com.bytedance.msdk.api.xv> bw;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.core.admanager.ev evVar = this.f31165w;
        if (evVar != null && (bw = evVar.bw()) != null) {
            for (com.bytedance.msdk.api.xv xvVar : bw) {
                if (xvVar != null) {
                    arrayList.add(new f(xvVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void c(boolean z3) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31164c;
        if (cVar != null) {
            cVar.c(z3);
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void c(final u uVar) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31164c;
        if (cVar != null) {
            cVar.c(new com.bytedance.msdk.api.sr.c.sr() { // from class: com.bytedance.sdk.gromore.c.c.sr.a.1
                @Override // com.bytedance.msdk.api.sr.c.sr
                public void c() {
                    u uVar2 = uVar;
                    if (uVar2 != null) {
                        uVar2.c();
                    }
                }
            });
        }
    }
}
