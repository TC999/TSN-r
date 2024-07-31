package com.kwad.components.p208ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.jshandler.C9036aa;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9046ad;
import com.kwad.components.core.webview.jshandler.C9057ag;
import com.kwad.components.core.webview.jshandler.C9063ai;
import com.kwad.components.core.webview.jshandler.C9067aj;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9119az;
import com.kwad.components.core.webview.jshandler.C9161l;
import com.kwad.components.core.webview.jshandler.C9163m;
import com.kwad.components.core.webview.tachikoma.p333a.C9200f;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p256i.C7950b;
import com.kwad.components.p208ad.reward.p258k.C7992q;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8276f extends C8094b {
    @Nullable

    /* renamed from: cL */
    private KsAdWebView f27310cL;

    /* renamed from: cM */
    private C9067aj.C9070a f27311cM;

    /* renamed from: cN */
    private C9003a f27312cN;

    /* renamed from: cO */
    private C10605b f27313cO;

    /* renamed from: cQ */
    private C9109aw f27315cQ;

    /* renamed from: cV */
    private ValueAnimator f27320cV;

    /* renamed from: cW */
    private ValueAnimator f27321cW;
    private C8619c mApkDownloadHelper;
    private String mUrl;

    /* renamed from: oM */
    private RewardActionBarControl f27322oM;

    /* renamed from: sr */
    private KsLogoView f27323sr;

    /* renamed from: va */
    private boolean f27325va;

    /* renamed from: vb */
    private long f27326vb;

    /* renamed from: cP */
    private int f27314cP = -1;

    /* renamed from: uI */
    private RewardActionBarControl.InterfaceC8258d f27324uI = new RewardActionBarControl.InterfaceC8258d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
        @Override // com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.InterfaceC8258d
        /* renamed from: f */
        public final boolean mo31093f(InterfaceC8259a interfaceC8259a) {
            C8276f c8276f = C8276f.this;
            c8276f.f27325va = c8276f.m31110f(interfaceC8259a);
            return C8276f.this.f27325va;
        }
    };
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            C8276f.this.release();
        }
    };

    /* renamed from: cR */
    private InterfaceC10635a f27316cR = new InterfaceC10635a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
        @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
        /* renamed from: a */
        public final void mo25245a(C10640a c10640a) {
            C8276f.this.f26957qo.f26528oI.mo32088bJ();
        }
    };

    /* renamed from: cS */
    private C9067aj.InterfaceC9071b f27317cS = new C9067aj.InterfaceC9071b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
        @Override // com.kwad.components.core.webview.jshandler.C9067aj.InterfaceC9071b
        /* renamed from: a */
        public final void mo28995a(C9067aj.C9070a c9070a) {
            C8276f.this.f27311cM = c9070a;
            C8276f.this.f27310cL.setTranslationY(c9070a.height + c9070a.bottomMargin);
        }
    };

    /* renamed from: cT */
    private C9063ai.InterfaceC9066b f27318cT = new C9063ai.InterfaceC9066b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
        @Override // com.kwad.components.core.webview.jshandler.C9063ai.InterfaceC9066b
        /* renamed from: a */
        public final void mo29313a(C9063ai.C9065a c9065a) {
            C8276f.this.f27325va = false;
            C8276f.this.m31122aE();
        }
    };

    /* renamed from: cU */
    private C9092aq.InterfaceC9095b f27319cU = new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
        @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
        /* renamed from: a */
        public final void mo28994a(C9092aq.C9094a c9094a) {
            C8276f.this.f27314cP = c9094a.status;
            long elapsedRealtime = SystemClock.elapsedRealtime() - C8276f.this.f27326vb;
            C10331c.m26248i("RewardActionBarWeb", "load time:" + elapsedRealtime + ", pageStatus: " + C8276f.this.f27314cP);
            if (C8276f.this.f27314cP == 1) {
                C8766a.m29888qi().m29891h(C8276f.this.f26957qo.mAdTemplate, elapsedRealtime);
            } else {
                C8032c.m31773a(C8276f.this.f26957qo.mAdTemplate, C8276f.this.f26957qo.f26544oY, "play_card", C10484b.m25757ck(C8276f.this.f26957qo.mAdTemplate), System.currentTimeMillis() - C8276f.this.f27310cL.getLoadTime(), 3);
            }
            if (C8276f.this.f26957qo.m32011fD()) {
                return;
            }
            C8276f.this.f27322oM.m31188if();
        }
    };

    /* renamed from: O */
    private void m31131O(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        if (!C10483a.m25848cF(C10487e.m25641dQ(adTemplate)) || C11015ai.isOrientationPortrait() || (ksLogoView = this.f27323sr) == null) {
            return;
        }
        ksLogoView.setVisibility(0);
    }

    /* renamed from: aA */
    private void m31124aA() {
        C9003a c9003a = this.f27312cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f27312cN = null;
        }
    }

    /* renamed from: aD */
    private void m31123aD() {
        m31131O(this.f26957qo.mAdTemplate);
        C9109aw c9109aw = this.f27315cQ;
        if (c9109aw != null) {
            c9109aw.m29268sr();
        }
        this.f27310cL.setVisibility(0);
        C9109aw c9109aw2 = this.f27315cQ;
        if (c9109aw2 != null) {
            c9109aw2.m29267ss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aE */
    public void m31122aE() {
        if (this.f27310cL.getVisibility() != 0) {
            return;
        }
        if (this.f27311cM == null) {
            m31121aF();
            return;
        }
        m31120aG();
        KsAdWebView ksAdWebView = this.f27310cL;
        C9067aj.C9070a c9070a = this.f27311cM;
        ValueAnimator m29527c = C8951n.m29527c(ksAdWebView, 0, c9070a.height + c9070a.bottomMargin);
        this.f27321cW = m29527c;
        m29527c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f27321cW.setDuration(300L);
        this.f27321cW.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                C8276f.this.f27310cL.setVisibility(4);
                if (C8276f.this.f27315cQ != null) {
                    C8276f.this.f27315cQ.m29265su();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (C8276f.this.f27315cQ != null) {
                    C8276f.this.f27315cQ.m29266st();
                }
            }
        });
        this.f27321cW.start();
    }

    /* renamed from: aF */
    private void m31121aF() {
        if (this.f27310cL.getVisibility() != 0) {
            return;
        }
        C9109aw c9109aw = this.f27315cQ;
        if (c9109aw != null) {
            c9109aw.m29266st();
        }
        this.f27310cL.setVisibility(4);
        C9109aw c9109aw2 = this.f27315cQ;
        if (c9109aw2 != null) {
            c9109aw2.m29265su();
        }
    }

    /* renamed from: aG */
    private void m31120aG() {
        ValueAnimator valueAnimator = this.f27320cV;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f27320cV.cancel();
        }
        ValueAnimator valueAnimator2 = this.f27321cW;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.f27321cW.cancel();
        }
    }

    /* renamed from: aH */
    private void m31119aH() {
        int i = this.f27314cP;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : "others";
        C10331c.m26246w("RewardActionBarWeb", "show webCard fail, reason: " + str);
    }

    /* renamed from: ax */
    private void m31118ax() {
        C10605b c10605b = new C10605b();
        this.f27313cO = c10605b;
        c10605b.setAdTemplate(this.f26957qo.mAdTemplate);
        C10605b c10605b2 = this.f27313cO;
        C7907g c7907g = this.f26957qo;
        c10605b2.mScreenOrientation = c7907g.mScreenOrientation;
        AdBaseFrameLayout adBaseFrameLayout = c7907g.mRootContainer;
        c10605b2.aDJ = adBaseFrameLayout;
        c10605b2.f29621OE = adBaseFrameLayout;
        c10605b2.f29620NY = this.f27310cL;
    }

    /* renamed from: ay */
    private void m31117ay() {
        this.f27314cP = -1;
        m31116az();
        this.f27310cL.setBackgroundColor(0);
        this.f27310cL.getBackground().setAlpha(0);
        this.f27310cL.setVisibility(4);
        this.f27310cL.setClientConfig(this.f27310cL.getClientConfig().m25331ei(this.f26957qo.mAdTemplate).m25339b(m31104ij()));
        this.f27326vb = SystemClock.elapsedRealtime();
        this.mUrl = C10484b.m25757ck(this.f26957qo.mAdTemplate);
        C10331c.m26254d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
        C7907g c7907g = this.f26957qo;
        C8032c.m31774a(c7907g.mAdTemplate, c7907g.f26544oY, "play_card", this.mUrl);
        this.f27310cL.loadUrl(this.mUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    /* renamed from: az */
    private void m31116az() {
        m31124aA();
        C9003a c9003a = new C9003a(this.f27310cL);
        this.f27312cN = c9003a;
        m31125a(c9003a);
        this.f27310cL.addJavascriptInterface(this.f27312cN, "KwaiAd");
    }

    /* renamed from: ca */
    private void m31113ca() {
        if (this.f27310cL == null || !C10484b.m25755cm(this.f26957qo.mAdTemplate)) {
            return;
        }
        this.mApkDownloadHelper = this.f26957qo.mApkDownloadHelper;
        m31118ax();
        m31117ay();
        this.f26957qo.m32034b(this.mPlayEndPageListener);
    }

    /* renamed from: ij */
    private KsAdWebView.InterfaceC10599d m31104ij() {
        return new KsAdWebView.InterfaceC10599d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageFinished() {
                C8032c.m31761a(C8276f.this.f26957qo.f26544oY, "play_card", C8276f.this.mUrl, System.currentTimeMillis() - C8276f.this.f27310cL.getLoadTime());
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onReceivedHttpError(int i, String str, String str2) {
                C8032c.m31773a(C8276f.this.f26957qo.mAdTemplate, C8276f.this.f26957qo.f26544oY, "play_card", C10484b.m25757ck(C8276f.this.f26957qo.mAdTemplate), System.currentTimeMillis() - C8276f.this.f27310cL.getLoadTime(), 2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.f27314cP = -1;
        KsAdWebView ksAdWebView = this.f27310cL;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        m31124aA();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C8032c.m31762a(this.f26957qo.f26544oY, "play_card");
        RewardActionBarControl rewardActionBarControl = this.f26957qo.f26532oM;
        this.f27322oM = rewardActionBarControl;
        rewardActionBarControl.m31200a(this.f27324uI);
        m31113ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27310cL = (KsAdWebView) findViewById(C9659R.C9662id.ksad_play_web_card_webView);
        this.f27323sr = (KsLogoView) findViewById(C9659R.C9662id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.f27322oM;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.m31200a((RewardActionBarControl.InterfaceC8258d) null);
        }
        this.f26957qo.m32024c(this.mPlayEndPageListener);
        m31120aG();
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m31110f(InterfaceC8259a interfaceC8259a) {
        KsAdWebView ksAdWebView = this.f27310cL;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.f27314cP == 1) {
            m31108g(interfaceC8259a);
            return true;
        }
        m31119aH();
        return false;
    }

    /* renamed from: g */
    private void m31108g(final InterfaceC8259a interfaceC8259a) {
        if (this.f27311cM == null) {
            m31123aD();
            return;
        }
        m31131O(this.f26957qo.mAdTemplate);
        m31120aG();
        this.f27310cL.setVisibility(0);
        KsAdWebView ksAdWebView = this.f27310cL;
        C9067aj.C9070a c9070a = this.f27311cM;
        ValueAnimator m29527c = C8951n.m29527c(ksAdWebView, c9070a.height + c9070a.bottomMargin, 0);
        this.f27320cV = m29527c;
        m29527c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f27320cV.setDuration(500L);
        this.f27320cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (C8276f.this.f27315cQ != null) {
                    C8276f.this.f27315cQ.m29267ss();
                }
                InterfaceC8259a interfaceC8259a2 = interfaceC8259a;
                if (interfaceC8259a2 != null) {
                    interfaceC8259a2.mo31183a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, C8276f.this.f27310cL);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (C8276f.this.f27315cQ != null) {
                    C8276f.this.f27315cQ.m29268sr();
                }
            }
        });
        this.f27320cV.start();
    }

    /* renamed from: a */
    private void m31125a(C9003a c9003a) {
        c9003a.m29403a(new C9036aa(this.f27313cO, this.mApkDownloadHelper, this.f27316cR, (byte) 0));
        c9003a.m29403a(new C9200f());
        c9003a.m29403a(new C7992q(this.f27313cO, this.mApkDownloadHelper, this.f26957qo, -1L, this.f27316cR, null));
        c9003a.m29403a(new C9046ad(this.f27313cO));
        c9003a.m29403a(new C9057ag(this.f27313cO));
        c9003a.m29403a(new C9043ac(this.f27313cO));
        c9003a.m29403a(new C9067aj(this.f27313cO, this.f27317cS));
        c9003a.m29403a(new C9092aq(this.f27319cU, C10484b.m25757ck(this.f26957qo.mAdTemplate)));
        C9109aw c9109aw = new C9109aw();
        this.f27315cQ = c9109aw;
        c9003a.m29403a(c9109aw);
        c9003a.m29403a(new C9119az(this.f27313cO, this.mApkDownloadHelper));
        c9003a.m29403a(new C9063ai(this.f27318cT));
        c9003a.m29403a(new C9072ak(this.f27313cO));
        c9003a.m29402b(new C9163m(this.f27313cO));
        c9003a.m29402b(new C9161l(this.f27313cO));
        c9003a.m29403a(new C7950b(getContext(), this.f26957qo.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }
}
