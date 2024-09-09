package com.bytedance.sdk.gromore.c.c.c;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.api.sr.c.r.k;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.c.xv f31141c;

    public r(com.bytedance.msdk.api.sr.c.c.xv xvVar) {
        this.f31141c = xvVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public boolean a() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.k();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public com.bytedance.sdk.openadsdk.ys.w.w.sr bk() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.a();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String c() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.c();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String ev() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.r();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public double f() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.ux();
        }
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public int gd() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.ev();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.sr k() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar == null || xvVar.p() == null) {
            return null;
        }
        return new f(this.f31141c.p());
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public int p() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.gd();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public List<String> r() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.f();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String sr() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.xv();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String ux() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.sr();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String w() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.c();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String xv() {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.w();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.sr srVar) {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            xvVar.c(activity, viewGroup, list, list2, list3, k.c(srVar));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public ev w(Activity activity) {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.w(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.xv c(Activity activity) {
        com.bytedance.msdk.api.sr.c.c.xv xvVar;
        if (activity == null || (xvVar = this.f31141c) == null) {
            return null;
        }
        return new ux(activity, null, xvVar);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public ev w(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            return xvVar.w(tTDislikeDialogAbstract);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.xv c(Activity activity, Map<String, Object> map) {
        com.bytedance.msdk.api.sr.c.c.xv xvVar;
        if (activity == null || map == null || (xvVar = this.f31141c) == null) {
            return null;
        }
        return new ux(activity, map, xvVar);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            xvVar.c(activity, cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public void c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.msdk.api.sr.c.c.xv xvVar = this.f31141c;
        if (xvVar != null) {
            xvVar.c(tTDislikeDialogAbstract);
        }
    }
}
