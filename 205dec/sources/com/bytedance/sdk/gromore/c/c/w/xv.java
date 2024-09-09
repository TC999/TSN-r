package com.bytedance.sdk.gromore.c.c.w;

import com.bytedance.sdk.gromore.c.c.sr.f;
import com.bytedance.sdk.gromore.c.c.sr.fz;
import com.bytedance.sdk.gromore.c.c.sr.u;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements fz {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.xv.c f31226c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.ux f31227w;

    public xv(com.bytedance.msdk.core.admanager.ux uxVar, com.bytedance.msdk.api.sr.c.xv.c cVar) {
        this.f31226c = cVar;
        this.f31227w = uxVar;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void c(u uVar) {
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public boolean c() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31226c;
        if (cVar != null) {
            return cVar.c();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public boolean ev() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31226c;
        if (cVar != null) {
            return cVar.ls();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w f() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31226c;
        if (cVar != null) {
            return new f(cVar.ys());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void gd() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31226c;
        if (cVar != null) {
            cVar.ck();
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void p() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31226c;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public boolean r() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31226c;
        if (cVar != null) {
            return cVar.gb();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w sr() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31226c;
        if (cVar != null) {
            return new f(cVar.fp());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.w> ux() {
        List<com.bytedance.msdk.api.xv> m4;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.core.admanager.ux uxVar = this.f31227w;
        if (uxVar != null && (m4 = uxVar.m()) != null) {
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
        com.bytedance.msdk.core.admanager.ux uxVar = this.f31227w;
        if (uxVar != null && (wo = uxVar.wo()) != null) {
            for (com.bytedance.msdk.api.w wVar : wo) {
                if (wVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.c.c.sr.c(wVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.w> xv() {
        List<com.bytedance.msdk.api.xv> bw;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.core.admanager.ux uxVar = this.f31227w;
        if (uxVar != null && (bw = uxVar.bw()) != null) {
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
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31226c;
        if (cVar != null) {
            cVar.c(z3);
        }
    }
}
