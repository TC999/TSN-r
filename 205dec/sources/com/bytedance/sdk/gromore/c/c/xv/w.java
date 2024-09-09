package com.bytedance.sdk.gromore.c.c.xv;

import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements com.bytedance.sdk.gromore.c.c.ux.f {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.r f31239c;

    public w(com.bytedance.msdk.core.admanager.r rVar) {
        this.f31239c = rVar;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public boolean c() {
        com.bytedance.msdk.core.admanager.r rVar = this.f31239c;
        if (rVar != null) {
            return rVar.bk();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w f() {
        com.bytedance.msdk.core.admanager.r rVar = this.f31239c;
        if (rVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.f(rVar.gd());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux.f
    public void r() {
        com.bytedance.msdk.core.admanager.r rVar = this.f31239c;
        if (rVar != null) {
            rVar.w();
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w sr() {
        com.bytedance.msdk.core.admanager.r rVar = this.f31239c;
        if (rVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.f(rVar.x());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.w> ux() {
        List<com.bytedance.msdk.api.xv> m4;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.core.admanager.r rVar = this.f31239c;
        if (rVar != null && (m4 = rVar.m()) != null) {
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
        com.bytedance.msdk.core.admanager.r rVar = this.f31239c;
        if (rVar != null && (wo = rVar.wo()) != null) {
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
        com.bytedance.msdk.core.admanager.r rVar = this.f31239c;
        if (rVar != null && (bw = rVar.bw()) != null) {
            for (com.bytedance.msdk.api.xv xvVar : bw) {
                if (xvVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.c.c.sr.f(xvVar));
                }
            }
        }
        return arrayList;
    }
}
