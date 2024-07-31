package com.kwad.components.p208ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.p289e.p290a.C8594h;
import com.kwad.components.core.proxy.AbstractAlertDialogC8887d;
import com.kwad.components.core.widget.C9375f;
import com.kwad.components.core.widget.InterfaceC9376g;
import com.kwad.components.p208ad.interstitial.aggregate.C7697b;
import com.kwad.components.p208ad.interstitial.p239b.C7721b;
import com.kwad.components.p208ad.interstitial.p240c.C7723a;
import com.kwad.components.p208ad.interstitial.p241d.C7728a;
import com.kwad.components.p208ad.interstitial.p244f.C7793b;
import com.kwad.components.p208ad.interstitial.p245g.AbstractC7794a;
import com.kwad.components.p208ad.interstitial.p245g.C7796c;
import com.kwad.components.p208ad.interstitial.report.C7806c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p364a.p365a.C9679c;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11063bm;

/* renamed from: com.kwad.components.ad.interstitial.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class AlertDialogC7725d extends AbstractAlertDialogC8887d {

    /* renamed from: hZ */
    private AbstractC7794a f26133hZ;

    /* renamed from: ia */
    private boolean f26134ia;

    /* renamed from: ib */
    private C7793b f26135ib;
    @NonNull

    /* renamed from: ic */
    private final KsAdVideoPlayConfig f26136ic;

    /* renamed from: ie */
    private KsInterstitialAd.AdInteractionListener f26137ie;

    /* renamed from: if */
    private final InterfaceC9376g f26138if;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    private C11063bm mTimerHelper;

    public AlertDialogC7725d(@NonNull Activity activity, @NonNull AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        this.f26138if = new InterfaceC9376g() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.core.widget.InterfaceC9376g
            /* renamed from: j */
            public final void mo28871j(boolean z) {
                if (AlertDialogC7725d.this.f26134ia) {
                    Activity activity2 = AlertDialogC7725d.this.mActivity;
                    C10232b.m26625DD();
                    if (activity2 == C10232b.getCurrentActivity()) {
                        C9908c.m27299i(AlertDialogC7725d.this.mAdTemplate, z ? 2 : 1);
                        AlertDialogC7725d.this.m32553cn();
                    }
                }
            }
        };
        this.f26137ie = adInteractionListener;
        this.f26136ic = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(C7721b.m32575cE()).build();
        this.mAdResultData = adResultData;
        this.mAdTemplate = C10485c.m25661n(adResultData);
    }

    /* renamed from: cl */
    private boolean m32555cl() {
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        return C10483a.m25808cr(m25641dQ) && !m32554cm() && C7723a.m32564cM() < C10483a.m25805cu(m25641dQ);
    }

    /* renamed from: cm */
    private boolean m32554cm() {
        return C10484b.m25761cg(this.mAdTemplate) && C7728a.m32548cO() < C10251d.m26524a(C10250c.ary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn */
    public void m32553cn() {
        AbstractC7794a c7697b = m32555cl() ? new C7697b(this.mContext) : new C7796c(this.mContext);
        this.f26133hZ = c7697b;
        c7697b.mo32360a(this.mAdResultData, this, this.f26136ic, this.f26137ie);
        this.f28746zg.removeAllViews();
        this.f28746zg.addView(this.f26133hZ);
        m32552co();
    }

    /* renamed from: co */
    private void m32552co() {
        C7793b c7793b = new C7793b(this.f26133hZ, 100);
        this.f26135ib = c7793b;
        c7793b.mo26187a(new InterfaceC10385c() { // from class: com.kwad.components.ad.interstitial.d.2
            @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
            /* renamed from: aM */
            public final void mo26182aM() {
                AlertDialogC7725d.this.getTimerHelper().m23866No();
            }

            @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
            /* renamed from: aN */
            public final void mo26181aN() {
                AlertDialogC7725d.this.getTimerHelper().m23865Np();
            }
        });
        this.f26135ib.m28900tw();
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d
    /* renamed from: cj */
    public final float mo29675cj() {
        return 0.0f;
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d
    /* renamed from: ck */
    public final ViewGroup mo29674ck() {
        C9375f c9375f = new C9375f(this.mContext);
        c9375f.setOrientationChangeListener(this.f26138if);
        return c9375f;
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            C9679c.m28040zM().m28037zP();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.f26137ie;
            if (adInteractionListener != null) {
                adInteractionListener.onPageDismiss();
            }
            AbstractC7794a abstractC7794a = this.f26133hZ;
            if ((abstractC7794a instanceof C7796c) && !((C7796c) abstractC7794a).m32352ec() && C10483a.m25841cM(C10487e.m25641dQ(this.mAdTemplate))) {
                C9908c.m27291m(this.mAdTemplate, (int) Math.ceil(((float) getTimerHelper().getTime()) / 1000.0f));
            }
            C8594h.m30288nm();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d
    /* renamed from: g */
    public final void mo28085g(View view) {
        C8594h.m30294a(getWindow());
        m32553cn();
        C7806c.m32283dQ().m32279r(this.mAdTemplate);
        C10819a.m24738al(MediationConstant.RIT_TYPE_INTERSTITIAL, TTLogUtil.TAG_EVENT_SHOW);
        C9828c.m27588bz(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.AbstractAlertDialogC8887d
    public final int getLayoutId() {
        return 0;
    }

    public final C11063bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new C11063bm();
        }
        return this.mTimerHelper;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (C7721b.m32571cI()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C7793b c7793b = this.f26135ib;
        if (c7793b != null) {
            c7793b.release();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f26134ia = z;
        AbstractC7794a abstractC7794a = this.f26133hZ;
        if (abstractC7794a != null) {
            if (z) {
                abstractC7794a.mo32359cr();
            } else {
                abstractC7794a.mo32358cs();
            }
        }
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f26137ie = adInteractionListener;
        AbstractC7794a abstractC7794a = this.f26133hZ;
        if (abstractC7794a != null) {
            abstractC7794a.setAdInteractionListener(adInteractionListener);
        }
    }
}
