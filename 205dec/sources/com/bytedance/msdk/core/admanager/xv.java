package com.bytedance.msdk.core.admanager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.core.gd.a;
import com.bytedance.msdk.core.gd.bk;
import com.bytedance.msdk.f.fp;
import com.bytedance.msdk.f.i;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends sr implements com.bytedance.msdk.adapter.w.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.c.c f27824c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.c.w f27825w;
    private boolean xv;
    private com.bytedance.msdk.api.sr.c.c.sr yu;

    public xv(Context context, String str) {
        super(context, str, 1);
        this.xv = false;
    }

    private void w(boolean z3) {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null && uxVar.canAdReuse() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, this.bm.getAdNetworkSlotId(), u())) {
            com.bytedance.msdk.core.ux.c.c.c().c(this.bm.getAdNetworkSlotId(), this.f28155k, this.f28153i, z3, this.xu, this.gb, this.vc.get());
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.c.c
    public void a_(com.bytedance.msdk.api.c cVar) {
        String str;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        if (i.c(this.bm)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j4 = -1;
        }
        com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, cVar, 1, 0, str, j4);
        ux(cVar);
    }

    public boolean f() {
        List<com.bytedance.msdk.core.k.p> list;
        try {
            list = be();
        } catch (Throwable th) {
            th.printStackTrace();
            list = null;
        }
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        return fp.c(this.f28162u, this.fz, this.f28160s, this.f28155k, this.au, this.ux, pr(), u(), list, wVar != null ? wVar.mt() : null);
    }

    @Override // com.bytedance.msdk.core.r.ux
    public com.bytedance.msdk.api.xv gd() {
        if (this.xv) {
            return super.gd();
        }
        return null;
    }

    public void h_() {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            uxVar.onPause();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.c.c
    public void i_() {
        com.bytedance.msdk.api.sr.c.c.c cVar = this.f27824c;
        if (cVar != null) {
            cVar.i_();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.c.c
    public void j_() {
        com.bytedance.msdk.api.sr.c.c.c cVar = this.f27824c;
        if (cVar != null) {
            cVar.j_();
        }
        String str = null;
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = -1;
        if (i.c(this.bm)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        }
        com.bytedance.msdk.core.w.c.ux(this.f28155k.u());
        com.bytedance.msdk.c.ux uxVar = this.bm;
        com.bytedance.msdk.xv.r.w(uxVar, this.f28155k, 0, str, j4, uxVar.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.sr.c.c.c
    public void k_() {
        this.xv = true;
        if (this.f27824c != null) {
            bk c4 = bk.c();
            c4.r(this.gd + "");
            bk c5 = bk.c();
            c5.w(this.gd + "");
            this.f27824c.k_();
        }
        if (this.bm != null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + this.bm.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(this.bm.getAdNetworkPlatformId()));
            com.bytedance.msdk.core.gd.k.c().w(this.gd, this.bm.getAdNetworkSlotId());
            a.c().w(this.gd, this.bm.getAdNetworkSlotId());
        }
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            com.bytedance.msdk.core.xv.xv.c(uxVar.getAdnName(), this.gd, this.bm.getAdNetworkSlotId());
        }
        w(true);
        String str = null;
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = -1;
        if (i.c(this.bm)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        }
        com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 0, str, j4, false);
        com.bytedance.msdk.core.w.c.r(this.f28155k.u());
        com.bytedance.msdk.core.w.c.xv(this.f28155k.u());
        com.bytedance.msdk.core.p.sr.c(1, this.f28155k.u(), this.bm.getAdType(), this.bm.getCpm());
        com.bytedance.msdk.core.r.r.c(this.gd, this.bm);
    }

    public com.bytedance.sdk.openadsdk.ys.w.w.sr p() {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            return uxVar.getDislikeInfo();
        }
        return null;
    }

    public void r() {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            uxVar.onResume();
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void sr() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.bytedance.msdk.core.k.w ux() {
        com.bytedance.msdk.core.fp.xv xvVar;
        if (this.f28159r == null && (xvVar = this.gw) != null) {
            this.f28159r = xvVar.c(this.gd, 1, 100);
            bm();
        }
        return this.f28159r;
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void xv() {
        com.bytedance.msdk.api.sr.c.c.w wVar = this.f27825w;
        if (wVar != null) {
            wVar.c();
        }
    }

    public void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.c.w wVar2) {
        if (k()) {
            this.f28155k = wVar;
            this.f27825w = wVar2;
            this.up = this;
            g_();
        }
    }

    private com.bytedance.msdk.api.sr.c.c.xv xv(final com.bytedance.msdk.c.ux uxVar) {
        return new com.bytedance.msdk.api.sr.c.c.xv() { // from class: com.bytedance.msdk.core.admanager.xv.3
            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public com.bytedance.sdk.openadsdk.ys.w.w.sr a() {
                com.bytedance.msdk.c.ux uxVar2 = uxVar;
                if (uxVar2 != null) {
                    return uxVar2.getDislikeInfo();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            @Nullable
            public String c() {
                return uxVar.getAdTitle();
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public int ev() {
                return uxVar.getImageMode();
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            @Nullable
            public List<String> f() {
                return uxVar.getImages();
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public int gd() {
                return uxVar.getInteractionType();
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public boolean k() {
                return uxVar.hasDislike();
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public com.bytedance.msdk.api.sr.c.r.w p() {
                if (uxVar.hasAppInfo()) {
                    com.bytedance.msdk.api.sr.c.r.w wVar = new com.bytedance.msdk.api.sr.c.r.w();
                    wVar.w(uxVar.getAppName());
                    wVar.xv(uxVar.getAuthorName());
                    wVar.c(uxVar.getPackageSizeBytes());
                    wVar.sr(uxVar.getPermissionsUrl());
                    wVar.ux(uxVar.getPrivacyAgreement());
                    wVar.f(uxVar.getVersionName());
                    wVar.c(uxVar.getPermissionsMap());
                    wVar.w(uxVar.getAppInfoExtra());
                    wVar.c(uxVar.getFunctionDescUrl());
                    return wVar;
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            @Nullable
            public String r() {
                return uxVar.getSource();
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            @Nullable
            public String sr() {
                return uxVar.getActionText();
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public double ux() {
                return uxVar.getStarRating();
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            @Nullable
            public String w() {
                return uxVar.getIconUrl();
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            @Nullable
            public String xv() {
                return uxVar.getImageUrl();
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public void c(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable List<View> list3, com.bytedance.msdk.api.sr.c.r.k kVar) {
                uxVar.registerViewForInteraction(activity, viewGroup, list, list2, list3, kVar);
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public com.bytedance.sdk.openadsdk.ys.w.w.ev w(Activity activity) {
                com.bytedance.msdk.c.ux uxVar2 = uxVar;
                if (uxVar2 != null) {
                    return uxVar2.getDislikeDialog(activity);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            @Nullable
            public com.bytedance.msdk.api.sr.w c(Activity activity) {
                return c(activity, (Map<String, Object>) null);
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            @Nullable
            public com.bytedance.msdk.api.sr.w c(Activity activity, Map<String, Object> map) {
                final com.bytedance.sdk.openadsdk.ys.w.w.ev dislikeDialog = uxVar.getDislikeDialog(activity);
                return new com.bytedance.msdk.api.sr.w() { // from class: com.bytedance.msdk.core.admanager.xv.3.1
                    @Override // com.bytedance.msdk.api.sr.w
                    public void c() {
                        com.bytedance.sdk.openadsdk.ys.w.w.ev evVar = dislikeDialog;
                        if (evVar != null) {
                            evVar.c();
                        }
                    }

                    @Override // com.bytedance.msdk.api.sr.w
                    public void c(final com.bytedance.msdk.api.sr.r rVar) {
                        com.bytedance.sdk.openadsdk.ys.w.w.ev evVar = dislikeDialog;
                        if (evVar != null) {
                            evVar.c(new com.bytedance.sdk.openadsdk.s.c.w.c.c(null) { // from class: com.bytedance.msdk.core.admanager.xv.3.1.1
                                @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                                public void onCancel() {
                                    com.bytedance.msdk.api.sr.r rVar2 = rVar;
                                    if (rVar2 != null) {
                                        rVar2.c();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                                public void onSelected(int i4, String str, boolean z3) {
                                    com.bytedance.msdk.api.sr.r rVar2 = rVar;
                                    if (rVar2 != null) {
                                        rVar2.c(i4, str);
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                                public void onShow() {
                                    com.bytedance.msdk.api.sr.r rVar2 = rVar;
                                    if (rVar2 != null) {
                                        rVar2.w();
                                    }
                                }
                            });
                        }
                    }
                };
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public com.bytedance.sdk.openadsdk.ys.w.w.ev w(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
                com.bytedance.msdk.c.ux uxVar2 = uxVar;
                if (uxVar2 != null) {
                    return uxVar2.getDislikeDialog(tTDislikeDialogAbstract);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
                com.bytedance.msdk.c.ux uxVar2 = uxVar;
                if (uxVar2 != null) {
                    uxVar2.setDislikeCallback(activity, cVar);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.c.xv
            public void c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
                com.bytedance.msdk.c.ux uxVar2 = uxVar;
                if (uxVar2 != null) {
                    uxVar2.setDislikeDialog(tTDislikeDialogAbstract);
                }
            }
        };
    }

    private void ux(final com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.admanager.xv.2
            @Override // java.lang.Runnable
            public void run() {
                if (xv.this.f27824c != null) {
                    xv.this.f27824c.a_(cVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.core.r.ux
    public void w() {
        if (!this.au) {
            com.bytedance.msdk.core.ux.c.c.c().c(gw(), this.gd, this.f28155k, u(), this.bm);
        }
        super.w();
        this.f27824c = null;
        this.f27825w = null;
    }

    public void c(com.bytedance.msdk.api.sr.c.c.sr srVar) {
        this.yu = srVar;
    }

    public void a_(String str) {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            uxVar.uploadDislikeEvent(str);
        }
    }

    public void c(com.bytedance.msdk.api.sr.c.c.c cVar) {
        this.f27824c = cVar;
    }

    private View c(Context context, com.bytedance.msdk.c.ux uxVar) {
        this.bm = uxVar;
        uxVar.setHasShown(true);
        this.bm.setTTAdatperCallback(this.up);
        if (this.bm.canAdReuse() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, this.bm.getAdNetworkSlotId(), u())) {
            com.bytedance.msdk.c.ux uxVar2 = this.bm;
            c(uxVar2, uxVar2.getAdNetworkSlotId());
        }
        w(false);
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd, "show") + "\u5c55\u793a\u7684\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(this.bm.getAdNetworkPlatformId()) + ",slotId\uff1a" + this.bm.getAdNetworkSlotId() + ",slotType:" + this.bm.getAdNetworkSlotType());
        final View adView = this.bm.getAdView();
        if (!this.bm.isCustomAd() && this.bm.getSubAdType() == 4 && this.bm.getOriginType() == 2 && !this.bm.isExpressAd()) {
            com.bytedance.msdk.api.sr.c.c.sr srVar = this.yu;
            if (srVar != null) {
                try {
                    adView = srVar.c(xv(this.bm));
                    if (adView == null) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- banner\u6df7\u51fa\u81ea\u6e32\u67d3\u4fe1\u606f\u6d41\uff0cgetGMBannerViewFromNativeAd()\u8fd4\u56denull\uff0c\u5c06\u65e0\u6cd5\u5c55\u793a\u8be5\u5e7f\u544a");
                    }
                } catch (Throwable th) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- banner\u6df7\u51fa\u81ea\u6e32\u67d3\u4fe1\u606f\u6d41\uff0cgetGMBannerViewFromNativeAd()\u53d1\u751f\u5f02\u5e38\uff0c\u5c06\u65e0\u6cd5\u5c55\u793a\u8be5\u5e7f\u544a\uff0c\u4fe1\u606f\u5982\u4e0b\uff1a");
                    th.printStackTrace();
                }
            } else {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- banner\u6df7\u51fa\u81ea\u6e32\u67d3\u4fe1\u606f\u6d41\uff0c\u4f46\u672a\u63d0\u4f9bGMNativeToBannerListener\uff0c\u5c06\u65e0\u6cd5\u5c55\u793a\u8be5\u5e7f\u544a");
            }
        }
        if (this.bm.hasDislike() && context != null) {
            this.bm.setDislikeCallback((Activity) context, new com.bytedance.sdk.openadsdk.s.c.w.c.c(null) { // from class: com.bytedance.msdk.core.admanager.xv.1
                @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                public void onSelected(int i4, String str, boolean z3) {
                    View view = adView;
                    if (view != null) {
                        View view2 = (View) view.getParent();
                        if (view2 instanceof ViewGroup) {
                            ((ViewGroup) view2).removeViewInLayout(adView);
                        }
                    }
                }
            });
        }
        return adView;
    }

    public synchronized View c(Context context) {
        View view;
        com.bytedance.msdk.c.ux uxVar;
        com.bytedance.msdk.c.ux next;
        List<com.bytedance.msdk.core.ux.w.ev> c4;
        com.bytedance.msdk.c.ux uxVar2;
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        com.bytedance.msdk.xv.r.c(this.f28155k, wVar != null ? wVar.mt() : null);
        if (this.au) {
            com.bytedance.msdk.xv.r.c((List<com.bytedance.msdk.c.ux>) null, this.f28155k, 0);
            ux(new com.bytedance.msdk.api.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, com.bytedance.msdk.api.c.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
            return null;
        }
        int w3 = sr.w(this.gd);
        if (w3 != 0) {
            com.bytedance.msdk.xv.r.c((List<com.bytedance.msdk.c.ux>) null, this.f28155k, w3);
            ux(new com.bytedance.msdk.api.c(w3, com.bytedance.msdk.api.c.c(w3)));
            return null;
        }
        List<com.bytedance.msdk.c.ux> gw = gw();
        List<com.bytedance.msdk.core.k.p> be = be();
        if (be != null && be.size() > 0) {
            HashMap<String, com.bytedance.msdk.c.ux> f4 = f(gw);
            view = null;
            for (com.bytedance.msdk.core.k.p pVar : be) {
                if (pVar != null) {
                    String ia = pVar.ia();
                    com.bytedance.msdk.c.ux uxVar3 = f4.get(ia);
                    if (uxVar3 != null && uxVar3.isReady(this.gd) && !uxVar3.isHasShown() && (view = c(context, uxVar3)) != null) {
                        break;
                    } else if (pVar.fz() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, ia, u()) && com.bytedance.msdk.core.ux.c.c.c().c(ia, this.f28155k, false) == 3 && (c4 = com.bytedance.msdk.core.ux.c.c.c().c(ia, this.f28155k, u())) != null && c4.size() > 0 && (uxVar2 = c4.get(0).f28224c) != null && uxVar2.isReady(this.gd) && !uxVar2.isHasShown()) {
                        sr(uxVar2);
                        view = c(context, uxVar2);
                        if (view != null) {
                            break;
                        }
                    }
                }
            }
        } else {
            view = null;
        }
        if (view == null && gw != null && gw.size() > 0) {
            Iterator<com.bytedance.msdk.c.ux> it = gw.iterator();
            while (it.hasNext() && ((next = it.next()) == null || !next.isReady(this.gd) || next.isHasShown() || (view = c(context, next)) == null)) {
            }
        }
        if (view != null) {
            this.au = true;
            com.bytedance.msdk.core.ux.c.c.c().c(gw(), this.gd, this.f28155k, u(), this.bm);
            if (this.bm != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.bm);
                w(arrayList);
            }
            com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, false, 0);
            if (this.f27824c != null && (uxVar = this.bm) != null && uxVar.getAdNetworkPlatformId() == 2) {
                com.bytedance.msdk.adapter.sr.xv.c("ADMOB_EVENT", com.bytedance.msdk.adapter.sr.ux.w(this.gd, this.bm.getAdNetworkSlotId()) + "mTTAdBannerListener-->Admob--->onAdShow......");
                bk.c().r(this.gd + "");
                bk.c().w(this.gd + "");
                this.f27824c.k_();
                if (this.bm != null) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + this.bm.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(this.bm.getAdNetworkPlatformId()));
                    com.bytedance.msdk.core.gd.k.c().w(this.gd, this.bm.getAdNetworkSlotId());
                    a.c().w(this.gd, this.bm.getAdNetworkSlotId());
                }
                com.bytedance.msdk.c.ux uxVar4 = this.bm;
                if (uxVar4 != null) {
                    com.bytedance.msdk.core.xv.xv.c(uxVar4.getAdnName(), this.gd, this.bm.getAdNetworkSlotId());
                }
                w(true);
                com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 0, (String) null, 0L, false);
                com.bytedance.msdk.core.r.r.c(this.gd, this.bm);
            }
            return view;
        }
        com.bytedance.msdk.xv.r.c(gw, this.f28155k, 0);
        ux(new com.bytedance.msdk.api.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, com.bytedance.msdk.api.c.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        return null;
    }

    public void c(boolean z3) {
        this.f28153i.put(TTRequestExtraParams.PARAM_BANNER_ALLOW_SHOW_CLOSE_BTN, Boolean.valueOf(z3));
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void c(com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.api.sr.c.c.w wVar = this.f27825w;
        if (wVar != null) {
            wVar.c(cVar);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.c.c
    public void c() {
        com.bytedance.msdk.api.sr.c.c.c cVar = this.f27824c;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            uxVar.setDislikeCallback(activity, cVar);
        }
    }

    public void c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            uxVar.setDislikeDialog(tTDislikeDialogAbstract);
        }
    }

    public com.bytedance.sdk.openadsdk.ys.w.w.ev c(Activity activity) {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            return uxVar.getDislikeDialog(activity);
        }
        return null;
    }
}
