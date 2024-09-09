package com.bytedance.sdk.gromore.c.c.xv;

import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements com.bytedance.sdk.gromore.c.c.ux.f {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.c f31231c;

    public f(com.bytedance.msdk.core.admanager.c cVar) {
        this.f31231c = cVar;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public boolean c() {
        com.bytedance.msdk.core.admanager.c cVar = this.f31231c;
        if (cVar != null) {
            return cVar.bk();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w f() {
        com.bytedance.msdk.core.admanager.c cVar = this.f31231c;
        if (cVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.f(cVar.gd());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux.f
    public void r() {
        com.bytedance.msdk.core.admanager.c cVar = this.f31231c;
        if (cVar != null) {
            cVar.w();
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w sr() {
        com.bytedance.msdk.core.admanager.c cVar = this.f31231c;
        if (cVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.f(cVar.x());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.w> ux() {
        List<com.bytedance.msdk.api.xv> m4;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.core.admanager.c cVar = this.f31231c;
        if (cVar != null && (m4 = cVar.m()) != null) {
            for (com.bytedance.msdk.api.xv xvVar : m4) {
                if (xvVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.c.c.sr.f(xvVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.sr> w() {
        List<com.bytedance.msdk.api.w> wo;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.core.admanager.c cVar = this.f31231c;
        if (cVar != null && (wo = cVar.wo()) != null) {
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
        com.bytedance.msdk.core.admanager.c cVar = this.f31231c;
        if (cVar != null && (bw = cVar.bw()) != null) {
            for (com.bytedance.msdk.api.xv xvVar : bw) {
                if (xvVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.c.c.sr.f(xvVar));
                }
            }
        }
        return arrayList;
    }
}
