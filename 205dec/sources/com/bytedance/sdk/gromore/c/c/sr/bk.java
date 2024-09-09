package com.bytedance.sdk.gromore.c.c.sr;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk extends com.bytedance.sdk.openadsdk.ys.w.w.ys {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.ev f31168c;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ys.w.c.w f31169f;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.w f31170r;
    private com.bytedance.sdk.openadsdk.ls.c.w.c.xv sr;
    private com.bytedance.sdk.openadsdk.ls.c.w.c.w ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.r.c f31171w;
    private View xv;

    public bk(com.bytedance.msdk.core.admanager.ev evVar, com.bytedance.msdk.api.sr.c.r.c cVar, com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.w wVar) {
        this.f31168c = evVar;
        this.f31170r = wVar;
        this.f31171w = cVar;
        gd();
    }

    private void gd() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            cVar.c(new com.bytedance.msdk.api.sr.c.r.r() { // from class: com.bytedance.sdk.gromore.c.c.sr.bk.1
                @Override // com.bytedance.msdk.api.sr.c.r.r
                public void c(View view, String str, int i4) {
                    if (bk.this.ux != null) {
                        bk.this.ux.onRenderFail(view, str, i4);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.xv
                public void w() {
                    if (bk.this.ux != null) {
                        bk.this.ux.onAdShow(null, 0);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.r
                public void c(float f4, float f5) {
                    if (bk.this.ux != null) {
                        bk.this.ux.onRenderSuccess(null, f4, f5);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.xv
                public void c() {
                    if (bk.this.ux != null) {
                        bk.this.ux.onAdClicked(null, 0);
                    }
                }
            });
            this.f31171w.c(new com.bytedance.msdk.api.sr.c.r.gd() { // from class: com.bytedance.sdk.gromore.c.c.sr.bk.2
                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void c(com.bytedance.msdk.api.c cVar2) {
                    if (cVar2 == null || bk.this.sr == null) {
                        return;
                    }
                    bk.this.sr.onVideoError(cVar2.f27444c, -1);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void gw() {
                    if (bk.this.sr != null) {
                        bk.this.sr.onVideoAdContinuePlay();
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void m() {
                    if (bk.this.sr != null) {
                        bk.this.sr.onVideoAdPaused();
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void vc() {
                    if (bk.this.sr != null) {
                        bk.this.sr.onVideoAdComplete();
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void x() {
                    if (bk.this.sr != null) {
                        bk.this.sr.onVideoAdStartPlay();
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.gd
                public void c(long j4, long j5) {
                    if (bk.this.sr != null) {
                        bk.this.sr.onProgressUpdate(j4, j5);
                    }
                }
            });
            this.f31171w.c(new com.bytedance.msdk.api.sr.c.w() { // from class: com.bytedance.sdk.gromore.c.c.sr.bk.3
                @Override // com.bytedance.msdk.api.sr.c.w
                public void c() {
                    if (bk.this.f31169f != null) {
                        bk.this.f31169f.onIdle();
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void w() {
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void w(long j4, long j5, String str, String str2) {
                    if (bk.this.f31169f != null) {
                        bk.this.f31169f.onDownloadFailed(j4, j5, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void c(long j4, long j5, int i4, int i5) {
                    if (bk.this.f31169f != null) {
                        bk.this.f31169f.onDownloadActive(j4, j5, "", "");
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void c(long j4, long j5, String str, String str2) {
                    if (bk.this.f31169f != null) {
                        bk.this.f31169f.onDownloadPaused(j4, j5, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void c(long j4, String str, String str2) {
                    if (bk.this.f31169f != null) {
                        bk.this.f31169f.onDownloadFinished(j4, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.w
                public void c(String str, String str2) {
                    if (bk.this.f31169f != null) {
                        bk.this.f31169f.onInstalled(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(int i4) {
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

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux ev() {
        return new p(new a(this.f31168c, this.f31171w));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.ys.w.w.sr f() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            return cVar.getDislikeInfo();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public Map<String, Object> r() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            return com.bytedance.sdk.gromore.c.w.w.c(cVar.i(), this.f31171w.bw());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void sr() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            if (cVar.n()) {
                this.f31171w.gb();
                return;
            }
            com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.w wVar = this.f31170r;
            if (wVar != null) {
                try {
                    View c4 = wVar.c(new gd(this.f31171w));
                    this.xv = c4;
                    if (c4 == null) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u81ea\u6e32\u67d3\u4fe1\u606f\u6d41\u8f6c\u6a21\u677f\uff0cgetMediationBannerViewFromNativeAd()\u8fd4\u56denull\uff0c\u5c06\u65e0\u6cd5\u5c55\u793a\u8be5\u5e7f\u544a");
                        com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar2 = this.ux;
                        if (wVar2 != null) {
                            wVar2.onRenderFail(null, "\u6e32\u67d3\u5931\u8d25", -99999);
                        }
                    } else {
                        com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar3 = this.ux;
                        if (wVar3 != null) {
                            wVar3.onRenderSuccess(c4, 0.0f, 0.0f);
                        }
                    }
                    return;
                } catch (Throwable th) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u81ea\u6e32\u67d3\u4fe1\u606f\u6d41\u8f6c\u6a21\u677f\uff0cgetMediationBannerViewFromNativeAd()\u53d1\u751f\u5f02\u5e38\uff0c\u5c06\u65e0\u6cd5\u5c55\u793a\u8be5\u5e7f\u544a\uff0c\u4fe1\u606f\u5982\u4e0b\uff1a");
                    th.printStackTrace();
                    return;
                }
            }
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u81ea\u6e32\u67d3\u4fe1\u606f\u6d41\u8f6c\u6a21\u677f\uff0c\u5f00\u53d1\u8005\u672a\u63d0\u4f9bMediationNativeToBannerListener\uff0c\u5c06\u65e0\u6cd5\u5c55\u793a\u8be5\u5e7f\u544a");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void ux() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            cVar.xk();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void w(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public View c() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            if (cVar.n()) {
                this.xv = this.f31171w.a();
            }
            return this.xv;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int w() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            return cVar.fz();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public int xv() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            return cVar.u();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar) {
        this.ux = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar) {
        this.ux = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        this.f31169f = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public com.bytedance.sdk.openadsdk.ys.w.w.ev c(Activity activity) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            return cVar.getDislikeDialog(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        com.bytedance.msdk.api.sr.c.r.c cVar2 = this.f31171w;
        if (cVar2 == null || activity == null) {
            return;
        }
        cVar2.setDislikeCallback(activity, cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            cVar.setDislikeDialog(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(String str) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31171w;
        if (cVar != null) {
            cVar.uploadDislikeEvent(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar) {
        this.sr = xvVar;
    }
}
