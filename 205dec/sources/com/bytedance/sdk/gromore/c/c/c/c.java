package com.bytedance.sdk.gromore.c.c.c;

import android.app.Activity;
import android.view.View;
import com.bytedance.msdk.core.admanager.gd;
import com.bytedance.sdk.gromore.c.c.sr.p;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import com.bytedance.sdk.openadsdk.ys.w.w.ys;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends ys {

    /* renamed from: c  reason: collision with root package name */
    private gd f31137c;
    private com.bytedance.sdk.openadsdk.ls.c.w.c.w sr;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.s.c.w.c.c f31138w;
    private com.bytedance.sdk.openadsdk.ls.c.w.c.c xv;

    public c(gd gdVar) {
        this.f31137c = gdVar;
        gd();
    }

    private void gd() {
        gd gdVar = this.f31137c;
        if (gdVar != null) {
            gdVar.c(new com.bytedance.msdk.api.sr.c.c.c() { // from class: com.bytedance.sdk.gromore.c.c.c.c.1
                @Override // com.bytedance.msdk.api.sr.c.c.c
                public void a_(com.bytedance.msdk.api.c cVar) {
                }

                @Override // com.bytedance.msdk.api.sr.c.c.c
                public void c() {
                }

                @Override // com.bytedance.msdk.api.sr.c.c.c
                public void i_() {
                    if (c.this.f31138w != null) {
                        c.this.f31138w.onSelected(0, "ad closed", true);
                    }
                    if (c.this.xv != null) {
                        c.this.xv.c();
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.c.c
                public void j_() {
                    if (c.this.sr != null) {
                        c.this.sr.onAdClicked(null, 0);
                    }
                    if (c.this.xv != null) {
                        c.this.xv.onAdClicked(null, 0);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.c.c
                public void k_() {
                    if (c.this.sr != null) {
                        c.this.sr.onAdShow(null, 0);
                    }
                    if (c.this.xv != null) {
                        c.this.xv.onAdShow(null, 0);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux ev() {
        return new p(new w(this.f31137c));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.ys.w.w.sr f() {
        gd gdVar = this.f31137c;
        if (gdVar != null) {
            return gdVar.bk();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public Map<String, Object> r() {
        gd gdVar = this.f31137c;
        if (gdVar != null) {
            return gdVar.f();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void sr() {
        com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar = this.sr;
        if (wVar != null) {
            wVar.onRenderSuccess(null, 0.0f, 0.0f);
        }
        com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar = this.xv;
        if (cVar != null) {
            cVar.onRenderSuccess(null, 0.0f, 0.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void ux() {
        gd gdVar = this.f31137c;
        if (gdVar != null) {
            gdVar.xv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int w() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void w(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public View c() {
        gd gdVar = this.f31137c;
        if (gdVar != null) {
            return gdVar.ux();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int xv() {
        gd gdVar = this.f31137c;
        if (gdVar != null) {
            return gdVar.a();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar) {
        this.sr = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar) {
        this.xv = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        this.f31138w = cVar;
        gd gdVar = this.f31137c;
        if (gdVar != null) {
            gdVar.c(activity, cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        gd gdVar = this.f31137c;
        if (gdVar != null) {
            gdVar.c(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(String str) {
        gd gdVar = this.f31137c;
        if (gdVar != null) {
            gdVar.c(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public ev c(Activity activity) {
        gd gdVar = this.f31137c;
        if (gdVar != null) {
            return gdVar.c(activity);
        }
        return null;
    }
}
