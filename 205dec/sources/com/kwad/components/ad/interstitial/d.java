package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.a.h;
import com.kwad.components.core.widget.f;
import com.kwad.components.core.widget.g;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bm;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends com.kwad.components.core.proxy.d {
    private com.kwad.components.ad.interstitial.g.a hZ;
    private boolean ia;
    private com.kwad.components.ad.interstitial.f.b ib;
    @NonNull
    private final KsAdVideoPlayConfig ic;
    private KsInterstitialAd.AdInteractionListener ie;

    /* renamed from: if  reason: not valid java name */
    private final g f1if;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    private bm mTimerHelper;

    public d(@NonNull Activity activity, @NonNull AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        this.f1if = new g() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.core.widget.g
            public final void j(boolean z3) {
                if (d.this.ia) {
                    Activity activity2 = d.this.mActivity;
                    com.kwad.sdk.core.c.b.DD();
                    if (activity2 == com.kwad.sdk.core.c.b.getCurrentActivity()) {
                        com.kwad.sdk.core.adlog.c.i(d.this.mAdTemplate, z3 ? 2 : 1);
                        d.this.cn();
                    }
                }
            }
        };
        this.ie = adInteractionListener;
        this.ic = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.components.ad.interstitial.b.b.cE()).build();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
    }

    private boolean cl() {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        return com.kwad.sdk.core.response.b.a.cr(dQ) && !cm() && com.kwad.components.ad.interstitial.c.a.cM() < com.kwad.sdk.core.response.b.a.cu(dQ);
    }

    private boolean cm() {
        return com.kwad.sdk.core.response.b.b.cg(this.mAdTemplate) && com.kwad.components.ad.interstitial.d.a.cO() < com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.ary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        com.kwad.components.ad.interstitial.g.a bVar = cl() ? new com.kwad.components.ad.interstitial.aggregate.b(this.mContext) : new com.kwad.components.ad.interstitial.g.c(this.mContext);
        this.hZ = bVar;
        bVar.a(this.mAdResultData, this, this.ic, this.ie);
        this.zg.removeAllViews();
        this.zg.addView(this.hZ);
        co();
    }

    private void co() {
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b(this.hZ, 100);
        this.ib = bVar;
        bVar.a(new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.interstitial.d.2
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                d.this.getTimerHelper().No();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                d.this.getTimerHelper().Np();
            }
        });
        this.ib.tw();
    }

    @Override // com.kwad.components.core.proxy.d
    public final float cj() {
        return 0.0f;
    }

    @Override // com.kwad.components.core.proxy.d
    public final ViewGroup ck() {
        f fVar = new f(this.mContext);
        fVar.setOrientationChangeListener(this.f1if);
        return fVar;
    }

    @Override // com.kwad.components.core.proxy.d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            com.kwad.sdk.a.a.c.zM().zP();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.ie;
            if (adInteractionListener != null) {
                adInteractionListener.onPageDismiss();
            }
            com.kwad.components.ad.interstitial.g.a aVar = this.hZ;
            if ((aVar instanceof com.kwad.components.ad.interstitial.g.c) && !((com.kwad.components.ad.interstitial.g.c) aVar).ec() && com.kwad.sdk.core.response.b.a.cM(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate))) {
                com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, (int) Math.ceil(((float) getTimerHelper().getTime()) / 1000.0f));
            }
            h.nm();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.d
    public final void g(View view) {
        h.a(getWindow());
        cn();
        com.kwad.components.ad.interstitial.report.c.dQ().r(this.mAdTemplate);
        com.kwad.sdk.j.a.al("interstitial", "show");
        com.kwad.sdk.commercial.d.c.bz(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.d
    public final int getLayoutId() {
        return 0;
    }

    public final bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bm();
        }
        return this.mTimerHelper;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.b.b.cI()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.f.b bVar = this.ib;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        this.ia = z3;
        com.kwad.components.ad.interstitial.g.a aVar = this.hZ;
        if (aVar != null) {
            if (z3) {
                aVar.cr();
            } else {
                aVar.cs();
            }
        }
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ie = adInteractionListener;
        com.kwad.components.ad.interstitial.g.a aVar = this.hZ;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }
}
