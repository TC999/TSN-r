package com.bytedance.msdk.api.sr.c.w.sr;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.sr.c.r.k;
import com.bytedance.msdk.api.sr.c.w.ev.f;
import com.bytedance.msdk.api.sr.c.w.ev.gd;
import com.bytedance.msdk.api.sr.c.w.ev.p;
import com.bytedance.msdk.api.sr.c.w.ev.ux;
import com.bytedance.msdk.api.sr.c.w.w.w;
import com.bytedance.msdk.api.sr.c.w.xv;
import com.bytedance.msdk.api.sr.c.xv.sr;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c extends com.bytedance.msdk.api.sr.c.w.ev.c {
    private List<View> ux;

    /* renamed from: w  reason: collision with root package name */
    private int f27582w = 0;
    private int xv = 0;
    private boolean sr = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final void au() {
        try {
            ux();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bj() {
        try {
            f();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bm() {
        try {
            r();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public List<View> a() {
        return this.ux;
    }

    public final void bk() {
        try {
            t();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c() {
    }

    public void c(@Nullable Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, k kVar) {
    }

    public void f() {
    }

    @Nullable
    public final View fp() {
        try {
            return w();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void fz() {
        c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.sr.c.8
            @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
            public void c() {
                if (((com.bytedance.msdk.api.sr.c.w.w.c) c.this).f27602c == null || ((com.bytedance.msdk.api.sr.c.w.w.c) c.this).f27602c.ux() == null) {
                    return;
                }
                ((com.bytedance.msdk.api.sr.c.w.w.c) c.this).f27602c.ux().w();
            }
        });
    }

    public void gb() {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.f() == null) {
            return;
        }
        this.f27602c.f().onCancel();
    }

    public void i() {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().m();
    }

    @Nullable
    public final sr ia() {
        try {
            return xv();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void j() {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().vc();
    }

    public void ls() {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.f() == null) {
            return;
        }
        this.f27602c.f().onShow();
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.c
    public xv p() {
        this.f27602c.setTitle(ck());
        this.f27602c.setAdDescription(z());
        this.f27602c.setIconUrl(ba());
        this.f27602c.setImageUrl(y());
        this.f27602c.setImageWidth(eq());
        this.f27602c.setImageHeight(me());
        this.f27602c.setVideoWidth(wv());
        this.f27602c.setVideoHeight(xk());
        this.f27602c.setActionText(yu());
        this.f27602c.setPackageName(wx());
        this.f27602c.setRating(pr());
        this.f27602c.setImages(bw());
        this.f27602c.setSource(x());
        this.f27602c.setImageMode(m());
        this.f27602c.setInteractionType(gw());
        if (vc() != null) {
            this.f27602c.setAppName(vc().w());
            this.f27602c.setAuthorName(vc().xv());
            this.f27602c.setPackageSizeBytes(vc().sr());
            this.f27602c.setPermissionsUrl(vc().ux());
            this.f27602c.setPrivacyAgreement(vc().r());
            this.f27602c.setVersionName(vc().ev());
            this.f27602c.setPermissionsMap(vc().f());
        }
        this.f27602c.c(new com.bytedance.msdk.api.sr.c.w.ev.sr() { // from class: com.bytedance.msdk.api.sr.c.w.sr.c.1
            @Override // com.bytedance.msdk.api.sr.c.w.ev.sr
            public void c(@Nullable Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, k kVar) {
                c.this.c(activity, viewGroup, list, list2, list3, kVar);
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.sr
            public void c() {
                c.this.bk();
            }
        });
        this.f27602c.c(new gd() { // from class: com.bytedance.msdk.api.sr.c.w.sr.c.2
            @Override // com.bytedance.msdk.api.sr.c.w.ev.gd
            public void c() {
                c.this.ys();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.gd
            public View w() {
                return c.this.fp();
            }
        });
        this.f27602c.c(new com.bytedance.msdk.api.sr.c.w.ev.k() { // from class: com.bytedance.msdk.api.sr.c.w.sr.c.3
            @Override // com.bytedance.msdk.api.sr.c.w.ev.k
            public void c() {
                c.this.au();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.k
            public void w() {
                c.this.bj();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.k
            public void xv() {
                c.this.bm();
            }
        });
        this.f27602c.c(new f() { // from class: com.bytedance.msdk.api.sr.c.w.sr.c.4
            @Override // com.bytedance.msdk.api.sr.c.w.ev.f
            public boolean c() {
                return c.this.sr();
            }
        });
        if (n() > 0.0d) {
            this.f27602c.setCpm(n());
        }
        this.f27602c.c(new ux() { // from class: com.bytedance.msdk.api.sr.c.w.sr.c.5
            @Override // com.bytedance.msdk.api.sr.c.w.ev.ux
            public String c() {
                return c.this.oo();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.ux
            public com.bytedance.msdk.api.sr.c.r.f w() {
                return c.this.ia();
            }
        });
        this.f27602c.c(new p() { // from class: com.bytedance.msdk.api.sr.c.w.sr.c.6
            @Override // com.bytedance.msdk.api.sr.c.w.ev.p
            public MediationConstant.AdIsReadyStatus c() {
                return c.this.ev();
            }
        });
        return this.f27602c;
    }

    public void q() {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().gw();
    }

    public void r() {
    }

    public void s() {
        w(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.sr.c.7
            @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
            public void c() {
                if (((com.bytedance.msdk.api.sr.c.w.w.c) c.this).f27602c == null || ((com.bytedance.msdk.api.sr.c.w.w.c) c.this).f27602c.ux() == null) {
                    return;
                }
                ((com.bytedance.msdk.api.sr.c.w.w.c) c.this).f27602c.ux().c();
            }
        });
    }

    public boolean sr() {
        return false;
    }

    public void t() {
    }

    public void u() {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().x();
    }

    public void ux() {
    }

    @Override // com.bytedance.msdk.api.sr.c.w.ev.c
    @Nullable
    public View w() {
        return null;
    }

    @Nullable
    public sr xv() {
        return null;
    }

    public final void ys() {
        try {
            this.sr = true;
            c();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public MediationConstant.AdIsReadyStatus ev() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public final void w(w.c cVar) {
        int i4 = this.xv;
        if (i4 < 60) {
            this.xv = i4 + 1;
            if (cVar != null) {
                cVar.c();
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter click\u65b9\u6cd5\u56de\u8c03\u6b21\u6570\u9700\u8981\u5c0f\u4e8e60\u6b21");
    }

    public final void c(w.c cVar) {
        if (this.sr) {
            int i4 = this.f27582w;
            if (i4 < 2) {
                this.f27582w = i4 + 1;
                if (cVar != null) {
                    cVar.c();
                    return;
                }
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter show\u65b9\u6cd5\u56de\u8c03\u6b21\u6570\u9700\u8981\u5c0f\u4e8e2\u6b21");
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter show\u65b9\u6cd5\u56de\u8c03\u5fc5\u987b\u7531GroMore\u89e6\u53d1show\u65f6\u624d\u4f1a\u751f\u6548");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, k kVar) {
        try {
            this.sr = true;
            this.ux = list3;
            c(activity, viewGroup, list, list2, kVar);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(float f4, float f5) {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.ux() == null) {
            return;
        }
        try {
            ((com.bytedance.msdk.api.sr.c.xv.ux) this.f27602c.ux()).c(f4, f5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(View view, String str, int i4) {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.ux() == null) {
            return;
        }
        try {
            ((com.bytedance.msdk.api.sr.c.xv.ux) this.f27602c.ux()).c(view, str, i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(com.bytedance.msdk.api.sr.c.w.c cVar) {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().c(new com.bytedance.msdk.api.c(49016, com.bytedance.msdk.api.c.c(49016), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.w()));
    }

    public void c(long j4, long j5) {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().c(j4, j5);
    }

    public void c(int i4, String str) {
        xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.f() == null) {
            return;
        }
        this.f27602c.f().onSelected(i4, str, false);
    }
}
