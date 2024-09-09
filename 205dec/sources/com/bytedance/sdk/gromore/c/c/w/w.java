package com.bytedance.sdk.gromore.c.c.w;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.api.sr.c.r.gd;
import com.bytedance.msdk.api.sr.c.r.k;
import com.bytedance.sdk.gromore.c.c.sr.p;
import com.bytedance.sdk.gromore.c.c.sr.s;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.mediation.c.w.r;
import com.bytedance.sdk.openadsdk.ys.w.w.bk;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends r {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.ux f31220c;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.c.w.c.c f31221f;
    private com.bytedance.sdk.openadsdk.j.c.w.c.w sr;
    private com.bytedance.sdk.openadsdk.j.c.w.c.c ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.xv.c f31222w;
    private View xv;

    public w(com.bytedance.msdk.core.admanager.ux uxVar, com.bytedance.msdk.api.sr.c.xv.c cVar) {
        this.f31220c = uxVar;
        this.f31222w = cVar;
        n();
    }

    private void n() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            cVar.c(new com.bytedance.msdk.api.sr.c.xv.ux() { // from class: com.bytedance.sdk.gromore.c.c.w.w.1
                @Override // com.bytedance.msdk.api.sr.c.xv.ux
                public void c(View view, String str, int i4) {
                    if (w.this.sr instanceof com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) w.this.sr).c(view, str, i4);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.xv.w
                public void w() {
                    if (w.this.sr instanceof com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) w.this.sr).w();
                    }
                    if (w.this.ux != null) {
                        w.this.ux.onAdShow(w.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.xv.ux
                public void c(float f4, float f5) {
                    if (w.this.sr != null) {
                        w.this.sr.onRenderSuccess(null, f4, f5, true);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.xv.w
                public void c() {
                    if (w.this.sr instanceof com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) w.this.sr).c();
                    }
                    if (w.this.ux != null) {
                        w.this.ux.onAdClicked(null, w.this);
                    }
                }
            });
            this.f31222w.c(new gd() { // from class: com.bytedance.sdk.gromore.c.c.w.w.2
                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void c(com.bytedance.msdk.api.c cVar2) {
                    if (cVar2 == null || w.this.f31221f == null) {
                        return;
                    }
                    w.this.f31221f.onVideoError(cVar2.f27444c, -1);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void gw() {
                    if (w.this.f31221f != null) {
                        w.this.f31221f.onVideoAdContinuePlay(w.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void m() {
                    if (w.this.f31221f != null) {
                        w.this.f31221f.onVideoAdPaused(w.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void vc() {
                    if (w.this.f31221f != null) {
                        w.this.f31221f.onVideoAdComplete(w.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void x() {
                    if (w.this.f31221f != null) {
                        w.this.f31221f.onVideoAdStartPlay(w.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void c(long j4, long j5) {
                    if (w.this.f31221f != null) {
                        w.this.f31221f.onProgressUpdate(j4, j5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int a() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar == null || cVar.w() == null) {
            return 0;
        }
        return this.f31222w.w().getAppSize();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String bk() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        return cVar != null ? cVar.bk() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public double c() {
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.p
    public void c(Bitmap bitmap, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public void c(com.bytedance.sdk.openadsdk.i.c.w.c.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.p
    public void c(com.bytedance.sdk.openadsdk.u.c.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.p
    public void c(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String ev() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        return cVar != null ? cVar.sr() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public Bitmap f() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int fp() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            return cVar.s();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.xv fz() {
        return new c(this.f31222w);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux gb() {
        return new p(new xv(this.f31220c, this.f31222w));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String gd() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        return cVar != null ? cVar.gd() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public View i() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            View p3 = cVar.p();
            this.xv = p3;
            return p3;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int ia() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            return cVar.ia();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void j() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            cVar.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int k() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void ls() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            cVar.z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int p() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            return (int) cVar.k();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public Map<String, Object> q() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            return com.bytedance.sdk.gromore.c.w.w.c(cVar.fz(), this.f31222w.y());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String r() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        return cVar != null ? cVar.xv() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.sr s() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            return cVar.getDislikeInfo();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public int sr() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            if (cVar.ls()) {
                View view = this.xv;
                if (view != null) {
                    return view.getHeight();
                }
                return 0;
            }
            com.bytedance.msdk.api.sr.c.xv.c cVar2 = this.f31222w;
            if (cVar2 != null) {
                return cVar2.i();
            }
            return 0;
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public bk t() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        return new s(cVar != null ? cVar.ux() : "");
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.ux u() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public bk ux() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public com.bytedance.sdk.openadsdk.i.c.w.w.c w() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void w(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void xv(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public List<bk> ys() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        List<String> a4 = cVar != null ? cVar.a() : null;
        com.bytedance.msdk.api.sr.c.xv.c cVar2 = this.f31222w;
        String f4 = cVar2 != null ? cVar2.f() : null;
        if (a4 != null) {
            if (a4.size() != 0) {
                for (String str : a4) {
                    arrayList.add(new s(str));
                }
            } else if (!TextUtils.isEmpty(f4)) {
                com.bytedance.msdk.api.sr.c.xv.c cVar3 = this.f31222w;
                int r3 = cVar3 != null ? cVar3.r() : 0;
                com.bytedance.msdk.api.sr.c.xv.c cVar4 = this.f31222w;
                arrayList.add(new s(f4, r3, cVar4 != null ? cVar4.ev() : 0));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public void c(com.bytedance.sdk.openadsdk.i.c.w.c.c cVar) {
        this.f31221f = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void w(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            cVar.setDislikeDialog(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public int xv() {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            if (cVar.ls()) {
                View view = this.xv;
                if (view != null) {
                    return view.getWidth();
                }
                return 0;
            }
            com.bytedance.msdk.api.sr.c.xv.c cVar2 = this.f31222w;
            if (cVar2 != null) {
                return cVar2.u();
            }
            return 0;
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public ev c(Activity activity) {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            return cVar.getDislikeDialog(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public ev c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            return cVar.getDislikeDialog(tTDislikeDialogAbstract);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar, com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.sr srVar) {
        com.bytedance.msdk.api.sr.c.xv.c cVar2 = this.f31222w;
        if (cVar2 != null) {
            this.ux = cVar;
            cVar2.c(new com.bytedance.msdk.api.sr.c.xv.w() { // from class: com.bytedance.sdk.gromore.c.c.w.w.3
                @Override // com.bytedance.msdk.api.sr.c.xv.w
                public void c() {
                    if (w.this.sr instanceof com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) w.this.sr).c();
                    }
                    if (w.this.ux != null) {
                        w.this.ux.onAdClicked(null, w.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.xv.w
                public void w() {
                    if (w.this.sr instanceof com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) w.this.sr).w();
                    }
                    if (w.this.ux != null) {
                        w.this.ux.onAdShow(w.this);
                    }
                }
            });
            this.f31222w.c(activity, viewGroup, list, list2, k.c(srVar));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(com.bytedance.sdk.openadsdk.j.c.w.c.w wVar) {
        this.sr = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        com.bytedance.msdk.api.sr.c.xv.c cVar2 = this.f31222w;
        if (cVar2 == null || activity == null) {
            return;
        }
        cVar2.setDislikeCallback(activity, cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(String str) {
        com.bytedance.msdk.api.sr.c.xv.c cVar = this.f31222w;
        if (cVar != null) {
            cVar.uploadDislikeEvent(str);
        }
    }
}
