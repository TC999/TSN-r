package com.bytedance.sdk.gromore.c.c.c;

import com.bytedance.msdk.core.admanager.gd;
import com.bytedance.sdk.gromore.c.c.sr.fz;
import com.bytedance.sdk.gromore.c.c.sr.u;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements fz {

    /* renamed from: c  reason: collision with root package name */
    private gd f31145c;

    public w(gd gdVar) {
        this.f31145c = gdVar;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void c(u uVar) {
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void c(boolean z3) {
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public boolean c() {
        gd gdVar = this.f31145c;
        if (gdVar != null) {
            return gdVar.sr();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public boolean ev() {
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w f() {
        gd gdVar = this.f31145c;
        if (gdVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.f(gdVar.k());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void gd() {
        gd gdVar = this.f31145c;
        if (gdVar != null) {
            gdVar.c();
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public void p() {
        gd gdVar = this.f31145c;
        if (gdVar != null) {
            gdVar.w();
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr.fz
    public boolean r() {
        return false;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public com.bytedance.sdk.gromore.c.c.w sr() {
        gd gdVar = this.f31145c;
        if (gdVar != null) {
            return new com.bytedance.sdk.gromore.c.c.sr.f(gdVar.gd());
        }
        return new com.bytedance.sdk.gromore.c.c.sr.ux();
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.w> ux() {
        List<com.bytedance.msdk.api.xv> p3;
        ArrayList arrayList = new ArrayList();
        gd gdVar = this.f31145c;
        if (gdVar != null && (p3 = gdVar.p()) != null) {
            for (com.bytedance.msdk.api.xv xvVar : p3) {
                if (xvVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.c.c.sr.f(xvVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.sr> w() {
        List<com.bytedance.msdk.api.w> r3;
        ArrayList arrayList = new ArrayList();
        gd gdVar = this.f31145c;
        if (gdVar != null && (r3 = gdVar.r()) != null) {
            for (com.bytedance.msdk.api.w wVar : r3) {
                if (wVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.c.c.sr.c(wVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.c.c.xv
    public List<com.bytedance.sdk.gromore.c.c.w> xv() {
        List<com.bytedance.msdk.api.xv> ev;
        ArrayList arrayList = new ArrayList();
        gd gdVar = this.f31145c;
        if (gdVar != null && (ev = gdVar.ev()) != null) {
            for (com.bytedance.msdk.api.xv xvVar : ev) {
                if (xvVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.c.c.sr.f(xvVar));
                }
            }
        }
        return arrayList;
    }
}
