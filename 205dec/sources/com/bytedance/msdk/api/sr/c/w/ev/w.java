package com.bytedance.msdk.api.sr.c.w.ev;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.sr.c.w.w.w;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w extends c {

    /* renamed from: f  reason: collision with root package name */
    private List<View> f27546f;
    private Activity ux;

    /* renamed from: w  reason: collision with root package name */
    private int f27547w = 0;
    private int xv = 0;
    private boolean sr = false;

    /* JADX INFO: Access modifiers changed from: private */
    public MediationConstant.AdIsReadyStatus ng() {
        return ev();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ok() {
        try {
            this.ux = null;
            r();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ox() {
        try {
            ux();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xu() {
        try {
            f();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Nullable
    public List<View> a() {
        return this.f27546f;
    }

    public void au() {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.f() == null) {
            return;
        }
        this.f27602c.f().onCancel();
    }

    public void b() {
    }

    public void bj() {
    }

    public final void bk() {
        try {
            t();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void bm() {
    }

    public void c() {
    }

    public void c(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.msdk.api.sr.c.r.k kVar) {
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
        c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ev.w.9
            @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
            public void c() {
                if (((com.bytedance.msdk.api.sr.c.w.w.c) w.this).f27602c == null || ((com.bytedance.msdk.api.sr.c.w.w.c) w.this).f27602c.c() == null) {
                    return;
                }
                ((com.bytedance.msdk.api.sr.c.w.w.c) w.this).f27602c.c().w();
            }
        });
    }

    public void gb() {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.f() == null) {
            return;
        }
        this.f27602c.f().onShow();
    }

    @Nullable
    public Activity getActivity() {
        return this.ux;
    }

    public void i() {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().m();
    }

    @Nullable
    public final com.bytedance.msdk.api.sr.c.r.f ia() {
        try {
            return xv();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void j() {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().vc();
    }

    public void ls() {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.xv() == null) {
            return;
        }
        this.f27602c.xv().c();
    }

    public void q() {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().gw();
    }

    public void r() {
    }

    public void s() {
        w(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ev.w.8
            @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
            public void c() {
                if (((com.bytedance.msdk.api.sr.c.w.w.c) w.this).f27602c == null || ((com.bytedance.msdk.api.sr.c.w.w.c) w.this).f27602c.c() == null) {
                    return;
                }
                ((com.bytedance.msdk.api.sr.c.w.w.c) w.this).f27602c.c().c();
            }
        });
    }

    public boolean sr() {
        return false;
    }

    public void t() {
    }

    public void u() {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
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

    public int wo() {
        return -1;
    }

    @Nullable
    public com.bytedance.msdk.api.sr.c.r.f xv() {
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

    @Override // com.bytedance.msdk.api.sr.c.w.w.c
    public com.bytedance.msdk.api.sr.c.w.xv p() {
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
        this.f27602c.c(new sr() { // from class: com.bytedance.msdk.api.sr.c.w.ev.w.1
            @Override // com.bytedance.msdk.api.sr.c.w.ev.sr
            public void c(@Nullable Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.sr.c.r.k kVar) {
                w.this.c(activity, viewGroup, list, list2, list3, kVar);
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.sr
            public void c() {
                w.this.bk();
            }
        });
        this.f27602c.c(new gd() { // from class: com.bytedance.msdk.api.sr.c.w.ev.w.2
            @Override // com.bytedance.msdk.api.sr.c.w.ev.gd
            public void c() {
                w.this.ys();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.gd
            public View w() {
                return w.this.fp();
            }
        });
        this.f27602c.c(new k() { // from class: com.bytedance.msdk.api.sr.c.w.ev.w.3
            @Override // com.bytedance.msdk.api.sr.c.w.ev.k
            public void c() {
                w.this.ox();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.k
            public void w() {
                w.this.xu();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.k
            public void xv() {
                w.this.ok();
            }
        });
        this.f27602c.c(new f() { // from class: com.bytedance.msdk.api.sr.c.w.ev.w.4
            @Override // com.bytedance.msdk.api.sr.c.w.ev.f
            public boolean c() {
                return w.this.sr();
            }
        });
        if (n() > 0.0d) {
            this.f27602c.setCpm(n());
        }
        this.f27602c.c(new p() { // from class: com.bytedance.msdk.api.sr.c.w.ev.w.5
            @Override // com.bytedance.msdk.api.sr.c.w.ev.p
            public MediationConstant.AdIsReadyStatus c() {
                return w.this.ng();
            }
        });
        this.f27602c.c(new ux() { // from class: com.bytedance.msdk.api.sr.c.w.ev.w.6
            @Override // com.bytedance.msdk.api.sr.c.w.ev.ux
            public String c() {
                return w.this.oo();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.ux
            public com.bytedance.msdk.api.sr.c.r.f w() {
                return w.this.ia();
            }
        });
        this.f27602c.c(new ev() { // from class: com.bytedance.msdk.api.sr.c.w.ev.w.7
            @Override // com.bytedance.msdk.api.sr.c.w.ev.ev
            public void c() {
                w.this.bj();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.ev
            public int sr() {
                return w.this.wo();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.ev
            public void w() {
                w.this.bm();
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.ev
            public void xv() {
                w.this.b();
            }
        });
        return this.f27602c;
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

    public void xv(long j4, long j5, String str, String str2) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.xv() == null) {
            return;
        }
        this.f27602c.xv().w(j4, j5, str, str2);
    }

    public final void c(w.c cVar) {
        if (this.sr) {
            int i4 = this.f27547w;
            if (i4 < 2) {
                this.f27547w = i4 + 1;
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

    public void w(long j4, long j5, String str, String str2) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.xv() == null) {
            return;
        }
        this.f27602c.xv().c(j4, j5, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.sr.c.r.k kVar) {
        try {
            this.ux = activity;
            this.sr = true;
            this.f27546f = list3;
            c(viewGroup, list, list2, kVar);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(float f4, float f5) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.c() == null) {
            return;
        }
        try {
            ((com.bytedance.msdk.api.sr.c.r.r) this.f27602c.c()).c(f4, f5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(View view, String str, int i4) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.c() == null) {
            return;
        }
        try {
            ((com.bytedance.msdk.api.sr.c.r.r) this.f27602c.c()).c(view, str, i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(com.bytedance.msdk.api.sr.c.w.c cVar) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().c(new com.bytedance.msdk.api.c(49012, com.bytedance.msdk.api.c.c(49012), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.w()));
    }

    public void c(long j4, long j5) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.w() == null) {
            return;
        }
        this.f27602c.w().c(j4, j5);
    }

    public void c(long j4, long j5, String str, String str2) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.xv() == null) {
            return;
        }
        this.f27602c.xv().c(j4, j5, -1, 1);
    }

    public void c(long j4, String str, String str2) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.xv() == null) {
            return;
        }
        this.f27602c.xv().c(j4, str, str2);
    }

    public void c(String str, String str2) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.xv() == null) {
            return;
        }
        this.f27602c.xv().c(str, str2);
    }

    public void c(int i4, String str) {
        com.bytedance.msdk.api.sr.c.w.xv xvVar = this.f27602c;
        if (xvVar == null || xvVar.f() == null) {
            return;
        }
        this.f27602c.c(str);
        this.f27602c.f().onSelected(i4, str, false);
    }
}
