package com.bytedance.sdk.gromore.c.c.f;

import com.bytedance.msdk.core.admanager.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements com.bytedance.sdk.gromore.c.c.ux.f {

    /* renamed from: c  reason: collision with root package name */
    private k f31163c;

    public xv(k kVar) {
        this.f31163c = kVar;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public boolean c() {
        k kVar = this.f31163c;
        if (kVar != null) {
            return kVar.ys();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w f() {
        k kVar = this.f31163c;
        if (kVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.f(kVar.gd());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux.f
    public void r() {
        k kVar = this.f31163c;
        if (kVar != null) {
            kVar.w();
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w sr() {
        k kVar = this.f31163c;
        if (kVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.f(kVar.x());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.w> ux() {
        List<com.bytedance.msdk.api.xv> m4;
        ArrayList arrayList = new ArrayList();
        k kVar = this.f31163c;
        if (kVar != null && (m4 = kVar.m()) != null) {
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
        k kVar = this.f31163c;
        if (kVar != null && (wo = kVar.wo()) != null) {
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
        k kVar = this.f31163c;
        if (kVar != null && (bw = kVar.bw()) != null) {
            for (com.bytedance.msdk.api.xv xvVar : bw) {
                if (xvVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.c.c.sr.f(xvVar));
                }
            }
        }
        return arrayList;
    }
}
