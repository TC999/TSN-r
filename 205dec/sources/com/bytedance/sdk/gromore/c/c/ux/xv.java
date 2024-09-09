package com.bytedance.sdk.gromore.c.c.ux;

import com.bytedance.msdk.core.admanager.p;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements f {

    /* renamed from: c  reason: collision with root package name */
    private p f31215c;

    public xv(p pVar) {
        this.f31215c = pVar;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public boolean c() {
        p pVar = this.f31215c;
        if (pVar != null) {
            return pVar.bk();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w f() {
        p pVar = this.f31215c;
        if (pVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.f(pVar.gd());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux.f
    public void r() {
        p pVar = this.f31215c;
        if (pVar != null) {
            pVar.w();
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w sr() {
        p pVar = this.f31215c;
        if (pVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.f(pVar.x());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.w> ux() {
        List<com.bytedance.msdk.api.xv> m4;
        ArrayList arrayList = new ArrayList();
        p pVar = this.f31215c;
        if (pVar != null && (m4 = pVar.m()) != null) {
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
        p pVar = this.f31215c;
        if (pVar != null && (wo = pVar.wo()) != null) {
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
        p pVar = this.f31215c;
        if (pVar != null && (bw = pVar.bw()) != null) {
            for (com.bytedance.msdk.api.xv xvVar : bw) {
                if (xvVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.c.c.sr.f(xvVar));
                }
            }
        }
        return arrayList;
    }
}
