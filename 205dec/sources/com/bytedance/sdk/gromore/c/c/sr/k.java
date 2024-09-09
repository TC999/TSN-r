package com.bytedance.sdk.gromore.c.c.sr;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k extends com.bytedance.sdk.openadsdk.mediation.c.w.ev {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.ev f31186c;
    private com.bytedance.sdk.openadsdk.ys.w.c.w ev;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.j.c.w.c.c f31187f;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.j.c.w.c.w f31188r;
    private com.bytedance.sdk.openadsdk.i.c.w.c.w sr;
    private View ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.r.c f31189w;
    private com.bytedance.sdk.openadsdk.i.c.w.c.c xv;

    public k(com.bytedance.msdk.core.admanager.ev evVar, com.bytedance.msdk.api.sr.c.r.c cVar) {
        this.f31186c = evVar;
        this.f31189w = cVar;
        n();
    }

    private void n() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            cVar.c(new com.bytedance.msdk.api.sr.c.r.r() { // from class: com.bytedance.sdk.gromore.c.c.sr.k.1
                @Override // com.bytedance.msdk.api.sr.c.r.r
                public void c(View view, String str, int i4) {
                    if (k.this.f31188r instanceof com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) k.this.f31188r).c(view, str, i4);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.xv
                public void w() {
                    if (k.this.f31188r instanceof com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) k.this.f31188r).w();
                    }
                    if (k.this.f31187f != null) {
                        k.this.f31187f.onAdShow(k.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.r
                public void c(float f4, float f5) {
                    if (k.this.f31188r != null) {
                        k.this.f31188r.onRenderSuccess(null, f4, f5, true);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.xv
                public void c() {
                    if (k.this.f31188r instanceof com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) k.this.f31188r).c();
                    }
                    if (k.this.f31187f != null) {
                        k.this.f31187f.onAdClicked(null, k.this);
                    }
                }
            });
            this.f31189w.c(new com.bytedance.msdk.api.sr.c.r.gd() { // from class: com.bytedance.sdk.gromore.c.c.sr.k.2
                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void c(com.bytedance.msdk.api.c cVar2) {
                    if (cVar2 == null || k.this.xv == null) {
                        return;
                    }
                    k.this.xv.onVideoError(cVar2.f27444c, -1);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void gw() {
                    if (k.this.xv != null) {
                        k.this.xv.onVideoAdContinuePlay(k.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void m() {
                    if (k.this.xv != null) {
                        k.this.xv.onVideoAdPaused(k.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void vc() {
                    if (k.this.xv != null) {
                        k.this.xv.onVideoAdComplete(k.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void x() {
                    if (k.this.xv != null) {
                        k.this.xv.onVideoAdStartPlay(k.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void c(long j4, long j5) {
                    if (k.this.xv != null) {
                        k.this.xv.onProgressUpdate(j4, j5);
                    }
                }
            });
            this.f31189w.c(new com.bytedance.msdk.api.sr.c.w() { // from class: com.bytedance.sdk.gromore.c.c.sr.k.3
                @Override // com.bytedance.msdk.api.sr.c.w
                public void c() {
                    if (k.this.ev != null) {
                        k.this.ev.onIdle();
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void w() {
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void w(long j4, long j5, String str, String str2) {
                    if (k.this.ev != null) {
                        k.this.ev.onDownloadFailed(j4, j5, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void c(long j4, long j5, int i4, int i5) {
                    if (k.this.ev != null) {
                        k.this.ev.onDownloadActive(j4, j5, "", "");
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void c(long j4, long j5, String str, String str2) {
                    if (k.this.ev != null) {
                        k.this.ev.onDownloadPaused(j4, j5, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void c(long j4, String str, String str2) {
                    if (k.this.ev != null) {
                        k.this.ev.onDownloadFinished(j4, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void c(String str, String str2) {
                    if (k.this.ev != null) {
                        k.this.ev.onInstalled(str, str2);
                    }
                }
            });
            this.f31189w.c(new com.bytedance.msdk.api.sr.c.r.p() { // from class: com.bytedance.sdk.gromore.c.c.sr.k.4
                @Override // com.bytedance.msdk.api.sr.c.r.p
                public void c(int i4) {
                    if (k.this.sr != null) {
                        k.this.sr.onFeedRewardCountDown(i4);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int a() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar == null || cVar.sr() == null) {
            return 0;
        }
        return this.f31189w.sr().getAppSize();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String bk() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        return cVar != null ? cVar.ys() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public double c() {
        return 0.0d;
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

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String ev() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        return cVar != null ? cVar.f() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public Bitmap f() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int fp() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            return cVar.u();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.xv fz() {
        return new w(this.f31189w);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux gb() {
        return new p(new a(this.f31186c, this.f31189w));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String gd() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        return cVar != null ? cVar.k() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public View i() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            View a4 = cVar.a();
            this.ux = a4;
            return a4;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int ia() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            return cVar.fz();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void j() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            cVar.gb();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int k() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void ls() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            cVar.xk();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public int p() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            return (int) cVar.bk();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public Map<String, Object> q() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            return com.bytedance.sdk.gromore.c.w.w.c(cVar.i(), this.f31189w.bw());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public String r() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        return cVar != null ? cVar.ux() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.sr s() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            return cVar.getDislikeInfo();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.bk t() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        return new s(cVar != null ? cVar.r() : "");
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.ux u() {
        return new sr(this.f31189w);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.bk ux() {
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
    public List<com.bytedance.sdk.openadsdk.ys.w.w.bk> ys() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        List<String> t3 = cVar != null ? cVar.t() : null;
        com.bytedance.msdk.api.sr.c.r.c cVar2 = this.f31189w;
        String ev = cVar2 != null ? cVar2.ev() : null;
        if (t3 != null) {
            if (t3.size() != 0) {
                for (String str : t3) {
                    arrayList.add(new s(str));
                }
            } else if (!TextUtils.isEmpty(ev)) {
                com.bytedance.msdk.api.sr.c.r.c cVar3 = this.f31189w;
                int gd = cVar3 != null ? cVar3.gd() : 0;
                com.bytedance.msdk.api.sr.c.r.c cVar4 = this.f31189w;
                arrayList.add(new s(ev, gd, cVar4 != null ? cVar4.p() : 0));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public void c(com.bytedance.sdk.openadsdk.i.c.w.c.c cVar) {
        this.xv = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public int sr() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            if (cVar.n()) {
                View view = this.ux;
                if (view != null) {
                    return view.getHeight();
                }
                return 0;
            }
            com.bytedance.msdk.api.sr.c.r.c cVar2 = this.f31189w;
            if (cVar2 != null) {
                return cVar2.j();
            }
            return 0;
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public com.bytedance.sdk.openadsdk.i.c.w.w.c w() {
        return new xv(this.f31189w);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public int xv() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            if (cVar.n()) {
                View view = this.ux;
                if (view != null) {
                    return view.getWidth();
                }
                return 0;
            }
            com.bytedance.msdk.api.sr.c.r.c cVar2 = this.f31189w;
            if (cVar2 != null) {
                return cVar2.q();
            }
            return 0;
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public void c(com.bytedance.sdk.openadsdk.i.c.w.c.w wVar) {
        this.sr = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void w(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            cVar.setDislikeDialog(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar, com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.sr srVar) {
        com.bytedance.msdk.api.sr.c.r.c cVar2 = this.f31189w;
        if (cVar2 != null) {
            this.f31187f = cVar;
            cVar2.c(new com.bytedance.msdk.api.sr.c.r.sr() { // from class: com.bytedance.sdk.gromore.c.c.sr.k.5
                @Override // com.bytedance.msdk.api.sr.c.r.xv
                public void c() {
                    if (k.this.f31188r instanceof com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) k.this.f31188r).c();
                    }
                    if (k.this.f31187f != null) {
                        k.this.f31187f.onAdClicked(null, k.this);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.xv
                public void w() {
                    if (k.this.f31188r instanceof com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux) k.this.f31188r).w();
                    }
                    if (k.this.f31187f != null) {
                        k.this.f31187f.onAdShow(k.this);
                    }
                }
            });
            this.f31189w.c(activity, viewGroup, list, list2, list3, com.bytedance.msdk.api.sr.c.r.k.c(srVar));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        this.ev = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(com.bytedance.sdk.openadsdk.j.c.w.c.w wVar) {
        this.f31188r = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.ev c(Activity activity) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            return cVar.getDislikeDialog(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public com.bytedance.sdk.openadsdk.ys.w.w.ev c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            return cVar.getDislikeDialog(tTDislikeDialogAbstract);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        com.bytedance.msdk.api.sr.c.r.c cVar2 = this.f31189w;
        if (cVar2 == null || activity == null) {
            return;
        }
        cVar2.setDislikeCallback(activity, cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(String str) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31189w;
        if (cVar != null) {
            cVar.uploadDislikeEvent(str);
        }
    }
}
