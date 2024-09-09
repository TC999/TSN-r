package com.bytedance.sdk.gromore.c.c.f;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.core.admanager.k;
import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.r;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.sdk.openadsdk.ys.w.w.w {

    /* renamed from: c  reason: collision with root package name */
    private k f31156c;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.gd.ux f31157f = new com.bytedance.msdk.api.sr.c.gd.ux() { // from class: com.bytedance.sdk.gromore.c.c.f.w.2
        @Override // com.bytedance.msdk.api.sr.c.gd.ux
        public void c() {
            if (w.this.xv != null) {
                w.this.xv.onSplashClickEyeReadyToShow(w.this);
            }
        }

        @Override // com.bytedance.msdk.api.sr.c.gd.ux
        public void w() {
            if (w.this.xv != null) {
                w.this.xv.onSplashClickEyeClose();
            }
        }
    };

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.gd.sr f31158r = new com.bytedance.msdk.api.sr.c.gd.sr() { // from class: com.bytedance.sdk.gromore.c.c.f.w.3
        @Override // com.bytedance.msdk.api.sr.c.gd.sr
        public void c() {
            if (w.this.sr != null) {
                w.this.sr.onSplashCardReadyToShow(w.this);
            }
        }

        @Override // com.bytedance.msdk.api.sr.c.gd.sr
        public void c(boolean z3) {
        }

        @Override // com.bytedance.msdk.api.sr.c.gd.sr
        public Activity getActivity() {
            return null;
        }

        @Override // com.bytedance.msdk.api.sr.c.gd.sr
        public void sr() {
            if (w.this.xv != null) {
                w.this.xv.onSplashClickEyeClick();
            }
        }

        @Override // com.bytedance.msdk.api.sr.c.gd.sr
        public void w() {
            if (w.this.sr != null) {
                w.this.sr.onSplashCardClose();
            }
        }

        @Override // com.bytedance.msdk.api.sr.c.gd.sr
        public void xv() {
            if (w.this.sr != null) {
                w.this.sr.onSplashCardClick();
            }
        }
    };
    private com.bytedance.sdk.openadsdk.sr.c.w.c.w sr;
    private com.bytedance.sdk.openadsdk.fz.c.w.c.c ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.sr.c.w.c.c f31159w;
    private com.bytedance.sdk.openadsdk.sr.c.w.c.xv xv;

    public w(k kVar, com.bytedance.sdk.openadsdk.fz.c.w.c.c cVar) {
        this.f31156c = kVar;
        this.ux = cVar;
        p();
    }

    private void p() {
        this.f31156c.c(new com.bytedance.msdk.api.sr.c.gd.w() { // from class: com.bytedance.sdk.gromore.c.c.f.w.1
            @Override // com.bytedance.msdk.api.sr.c.gd.w
            public void c(int i4) {
                if (w.this.f31159w != null) {
                    w.this.f31159w.onSplashAdClose(w.this, i4);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.gd.w
            public void d_(com.bytedance.msdk.api.c cVar) {
                if (w.this.ux == null || cVar == null) {
                    return;
                }
                w.this.ux.onSplashRenderFail(w.this, new com.bytedance.sdk.gromore.c.c.c(cVar.f27444c, cVar.f27445w));
            }

            @Override // com.bytedance.msdk.api.sr.c.gd.w
            public void r() {
                if (w.this.f31159w != null) {
                    w.this.f31159w.onSplashAdClick(w.this);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.gd.w
            public void u_() {
                if (w.this.f31159w != null) {
                    w.this.f31159w.onSplashAdShow(w.this);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.gd.w
            public void w(int i4) {
                if (w.this.f31159w != null) {
                    w.this.f31159w.onSplashAdClose(w.this, i4);
                }
            }
        });
        this.f31156c.c(this.f31157f);
        this.f31156c.c(this.f31158r);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void L_() {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public int[] f() {
        k kVar = this.f31156c;
        return kVar != null ? kVar.t() : new int[0];
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public r gd() {
        return new c(new xv(this.f31156c));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void r() {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public Map<String, Object> ux() {
        k kVar = this.f31156c;
        if (kVar != null) {
            return kVar.ta();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w, com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.k(super.values()).e(1, com.bytedance.sdk.gromore.init.c.c()).l();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public View c() {
        k kVar = this.f31156c;
        if (kVar != null) {
            return kVar.fp();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public int sr() {
        k kVar = this.f31156c;
        if (kVar != null) {
            return kVar.eu();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public View w() {
        k kVar = this.f31156c;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public View xv() {
        k kVar = this.f31156c;
        if (kVar != null) {
            return kVar.bk();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(com.bytedance.sdk.openadsdk.sr.c.w.c.c cVar) {
        this.f31159w = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void w(ViewGroup viewGroup) {
        k kVar = this.f31156c;
        if (kVar != null) {
            kVar.w(viewGroup);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(com.bytedance.sdk.openadsdk.sr.c.w.c.xv xvVar) {
        this.xv = xvVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(com.bytedance.sdk.openadsdk.sr.c.w.c.w wVar) {
        this.sr = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(ViewGroup viewGroup) {
        k kVar = this.f31156c;
        if (kVar == null || viewGroup == null) {
            return;
        }
        kVar.c(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(ViewGroup viewGroup, Activity activity) {
        k kVar = this.f31156c;
        if (kVar == null || viewGroup == null || activity == null) {
            return;
        }
        kVar.c(viewGroup, activity);
    }
}
