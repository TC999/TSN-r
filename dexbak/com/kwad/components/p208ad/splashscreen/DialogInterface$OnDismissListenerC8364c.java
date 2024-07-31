package com.kwad.components.p208ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p301l.AbstractC8692c;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.components.p208ad.splashscreen.monitor.C8497b;
import com.kwad.components.p208ad.splashscreen.p278c.C8435j;
import com.kwad.components.p208ad.splashscreen.p278c.C8437k;
import com.kwad.components.p208ad.splashscreen.p278c.C8453o;
import com.kwad.components.p208ad.splashscreen.p278c.p279a.C8378f;
import com.kwad.components.p208ad.splashscreen.p278c.p280b.C8385a;
import com.kwad.components.p208ad.splashscreen.p283e.C8478a;
import com.kwad.components.p208ad.splashscreen.p284f.C8487d;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p403h.AbstractC10384b;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p364a.p365a.C9679c;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11063bm;

/* renamed from: com.kwad.components.ad.splashscreen.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DialogInterface$OnDismissListenerC8364c extends AbstractC8692c<C8489h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {

    /* renamed from: Ce */
    private KsSplashScreenAd.SplashScreenAdInteractionListener f27630Ce;

    /* renamed from: Cf */
    private C8487d f27631Cf;

    /* renamed from: bT */
    private AbstractC10384b f27632bT;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private boolean mPageDismissCalled;
    private AdBaseFrameLayout mRootContainer;
    private KsVideoPlayConfig mVideoPlayConfig;

    private DialogInterface$OnDismissListenerC8364c(Context context, AdResultData adResultData) {
        super(context);
        this.mAdResultData = adResultData;
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        this.mAdTemplate = m25661n;
        this.mAdScene = m25661n.mAdScene;
        m30011oJ();
    }

    /* renamed from: S */
    private static StyleTemplate m30889S(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = C10484b.m25668k(adTemplate, C10484b.m25687dr(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (m25668k != null) {
            styleTemplate.templateId = m25668k.templateId;
            styleTemplate.templateMd5 = m25668k.templateMd5;
            styleTemplate.templateUrl = m25668k.templateUrl;
            styleTemplate.templateVersionCode = (int) m25668k.templateVersionCode;
        }
        return styleTemplate;
    }

    /* renamed from: T */
    private static Presenter m30888T(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        Presenter presenter = new Presenter();
        m30884a(presenter, m25641dQ);
        if (C8489h.m30626U(adTemplate)) {
            presenter.m24612a(new C8385a());
        } else {
            presenter.m24612a(new C8435j());
        }
        return presenter;
    }

    private int getSplashLayoutId() {
        return C9659R.C9663layout.ksad_splash_screen_layout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.p301l.AbstractC8692c
    /* renamed from: kq */
    public C8489h mo29837kt() {
        C8487d c8487d = new C8487d(this.f28361lD, C10483a.m25853cA(this.mAdInfo));
        this.f27631Cf = c8487d;
        c8487d.mo26187a(this.f27632bT);
        this.f27631Cf.m28900tw();
        if (this.mVideoPlayConfig == null) {
            this.mVideoPlayConfig = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        }
        C8489h c8489h = new C8489h();
        c8489h.m30617d(this.mAdResultData);
        c8489h.setSplashScreenAdListener(this.f27630Ce);
        c8489h.mRootContainer = this.mRootContainer;
        c8489h.mAdScene = this.mAdScene;
        c8489h.mVideoPlayConfig = this.mVideoPlayConfig;
        c8489h.f27881Cs = this.f27631Cf;
        c8489h.mApkDownloadHelper = this.mApkDownloadHelper;
        c8489h.f27880Cr = m30889S(this.mAdTemplate);
        c8489h.mTimerHelper = new C11063bm();
        if (C10483a.m25877bc(this.mAdInfo)) {
            C8478a c8478a = new C8478a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            c8489h.f27879Cq = c8478a;
            c8489h.f27881Cs.mo26187a(c8478a);
        }
        c8489h.f27881Cs.mo26187a(m30885a(c8489h));
        return c8489h;
    }

    /* renamed from: ks */
    private void m30877ks() {
        C9679c.m28040zM().m28037zP();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    /* renamed from: n */
    public static boolean m30876n(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c, com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public final void mo23565ac() {
        super.mo23565ac();
        post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                AdTemplate adTemplate = DialogInterface$OnDismissListenerC8364c.this.mAdTemplate;
                AdInfo unused = DialogInterface$OnDismissListenerC8364c.this.mAdInfo;
                if (C8489h.m30626U(adTemplate) || ((C8489h) DialogInterface$OnDismissListenerC8364c.this.f28360Mu).f27879Cq == null) {
                    return;
                }
                ((C8489h) DialogInterface$OnDismissListenerC8364c.this.f28360Mu).f27879Cq.m30644lO();
            }
        });
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c, com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.setOnDismissListener(null);
            this.mApkDownloadHelper.setOnShowListener(null);
        }
        this.f27631Cf.m28899tx();
        m30877ks();
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c
    public final void initData() {
        this.mAdInfo = C10487e.m25641dQ(this.mAdTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        this.mVideoPlayConfig = build;
        this.mAdTemplate.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        C8619c c8619c = new C8619c(this.mAdTemplate);
        this.mApkDownloadHelper = c8619c;
        c8619c.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c
    /* renamed from: kp */
    public final boolean mo30012kp() {
        return true;
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c
    /* renamed from: kr */
    public final void mo29838kr() {
        this.mRootContainer = (AdBaseFrameLayout) this.f28361lD.findViewById(C9659R.C9662id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.f28361lD.findViewById(C9659R.C9662id.ksad_splash_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.findViewById(C9659R.C9662id.splash_play_card_view).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (C10751a.m24929Au() || !DialogInterface$OnDismissListenerC8364c.m30876n(DialogInterface$OnDismissListenerC8364c.this.mAdInfo) || DialogInterface$OnDismissListenerC8364c.this.f28360Mu == null) {
                    return;
                }
                ((C8489h) DialogInterface$OnDismissListenerC8364c.this.f28360Mu).m30618c(1, view.getContext(), 53, 2);
            }
        });
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c
    @NonNull
    public final Presenter onCreatePresenter() {
        getContext();
        return m30888T(this.mAdTemplate);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean m30266nt = dialogInterface instanceof AlertDialogC8602b ? ((AlertDialogC8602b) dialogInterface).m30266nt() : false;
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27630Ce;
            if (splashScreenAdInteractionListener != null) {
                if (m30266nt) {
                    splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
                } else {
                    splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27630Ce;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
    }

    @Override // android.view.View
    protected final void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public final void setPageExitListener(AbstractC10384b abstractC10384b) {
        this.f27632bT = abstractC10384b;
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f27630Ce = splashScreenAdInteractionListener;
        T t = this.f28360Mu;
        if (t != 0) {
            ((C8489h) t).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }

    /* renamed from: a */
    public static DialogInterface$OnDismissListenerC8364c m30887a(Context context, @NonNull AdResultData adResultData, boolean z, AbstractC10384b abstractC10384b, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        DialogInterface$OnDismissListenerC8364c dialogInterface$OnDismissListenerC8364c;
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        DialogInterface$OnDismissListenerC8364c dialogInterface$OnDismissListenerC8364c2 = null;
        try {
            C10819a.m24739ak(MediationConstant.RIT_TYPE_SPLASH, TTLogUtil.TAG_EVENT_SHOW);
            m25661n.showStartTime = SystemClock.elapsedRealtime();
            C8497b.m30550kV();
            C8497b.m30570aa(m25661n);
            C8497b.m30550kV();
            C8497b.m30575a(m25661n, C10829k.m24699zd().m24677zz(), z);
            dialogInterface$OnDismissListenerC8364c = new DialogInterface$OnDismissListenerC8364c(C10887l.wrapContextIfNeed(context), adResultData);
        } catch (Throwable th) {
            th = th;
        }
        try {
            dialogInterface$OnDismissListenerC8364c.setPageExitListener(abstractC10384b);
            dialogInterface$OnDismissListenerC8364c.setSplashScreenAdListener(splashScreenAdInteractionListener);
            C10819a.m24738al(MediationConstant.RIT_TYPE_SPLASH, TTLogUtil.TAG_EVENT_SHOW);
            return dialogInterface$OnDismissListenerC8364c;
        } catch (Throwable th2) {
            th = th2;
            dialogInterface$OnDismissListenerC8364c2 = dialogInterface$OnDismissListenerC8364c;
            C8497b.m30550kV();
            C8497b.m30572a(m25661n, th.toString(), z);
            if (C10829k.m24699zd().m24703yp()) {
                C8571a.reportSdkCaughtException(th);
                return dialogInterface$OnDismissListenerC8364c2;
            }
            throw th;
        }
    }

    /* renamed from: a */
    private InterfaceC10385c m30885a(final C8489h c8489h) {
        return new InterfaceC10385c() { // from class: com.kwad.components.ad.splashscreen.c.1
            @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
            /* renamed from: aM */
            public final void mo26182aM() {
                C11063bm c11063bm = c8489h.mTimerHelper;
                if (c11063bm != null) {
                    c11063bm.m23866No();
                }
            }

            @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
            /* renamed from: aN */
            public final void mo26181aN() {
                C11063bm c11063bm = c8489h.mTimerHelper;
                if (c11063bm != null) {
                    c11063bm.m23865Np();
                }
            }
        };
    }

    /* renamed from: a */
    private static void m30884a(Presenter presenter, AdInfo adInfo) {
        presenter.m24612a(new C8437k());
        presenter.m24612a(new C8453o());
        if (C8489h.m30596r(adInfo)) {
            presenter.m24612a(new C8378f());
        }
    }
}
