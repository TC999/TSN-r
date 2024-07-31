package com.kwad.components.p208ad.draw.p215b.p217b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
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
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.p208ad.draw.p214a.C7357a;
import com.kwad.components.p208ad.draw.p214a.C7358b;
import com.kwad.components.p208ad.draw.p215b.p217b.C7370a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;

/* renamed from: com.kwad.components.ad.draw.b.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7377c extends C7357a {

    /* renamed from: cL */
    private KsAdWebView f25313cL;

    /* renamed from: cM */
    private C9067aj.C9070a f25314cM;

    /* renamed from: cN */
    private C9003a f25315cN;

    /* renamed from: cO */
    private C10605b f25316cO;

    /* renamed from: cQ */
    private C9109aw f25318cQ;

    /* renamed from: cV */
    private ValueAnimator f25323cV;

    /* renamed from: cW */
    private ValueAnimator f25324cW;

    /* renamed from: co */
    private ViewGroup f25325co;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    /* renamed from: cP */
    private int f25317cP = -1;
    private InterfaceC9001k mVideoPlayStateListener = new C9002l() { // from class: com.kwad.components.ad.draw.b.b.c.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            C7377c.this.release();
        }
    };

    /* renamed from: cG */
    private C7370a.InterfaceC7372b f25312cG = new C7370a.InterfaceC7372b() { // from class: com.kwad.components.ad.draw.b.b.c.2
        @Override // com.kwad.components.p208ad.draw.p215b.p217b.C7370a.InterfaceC7372b
        /* renamed from: ar */
        public final boolean mo33377ar() {
            return C7377c.this.m33394aB();
        }
    };

    /* renamed from: cR */
    private InterfaceC10635a f25319cR = new InterfaceC10635a() { // from class: com.kwad.components.ad.draw.b.b.c.3
        @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
        /* renamed from: a */
        public final void mo25245a(C10640a c10640a) {
            if (C7377c.this.f25273bO.f25274bN != null) {
                C7377c.this.f25273bO.f25274bN.onAdClicked();
            }
        }
    };

    /* renamed from: cS */
    private C9067aj.InterfaceC9071b f25320cS = new C9067aj.InterfaceC9071b() { // from class: com.kwad.components.ad.draw.b.b.c.4
        @Override // com.kwad.components.core.webview.jshandler.C9067aj.InterfaceC9071b
        /* renamed from: a */
        public final void mo28995a(C9067aj.C9070a c9070a) {
            C7377c.this.f25314cM = c9070a;
            C7377c.this.f25313cL.setTranslationY(c9070a.height + c9070a.bottomMargin);
        }
    };

    /* renamed from: cT */
    private C9063ai.InterfaceC9066b f25321cT = new C9063ai.InterfaceC9066b() { // from class: com.kwad.components.ad.draw.b.b.c.5
        @Override // com.kwad.components.core.webview.jshandler.C9063ai.InterfaceC9066b
        /* renamed from: a */
        public final void mo29313a(C9063ai.C9065a c9065a) {
            C7377c.this.m33391aE();
        }
    };

    /* renamed from: cU */
    private C9092aq.InterfaceC9095b f25322cU = new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.ad.draw.b.b.c.6
        @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
        /* renamed from: a */
        public final void mo28994a(C9092aq.C9094a c9094a) {
            C7377c.this.f25317cP = c9094a.status;
            C10331c.m26248i("DrawPlayWebCard", "updatePageStatus mPageState: " + c9094a);
        }
    };

    /* renamed from: aA */
    private void m33395aA() {
        C9003a c9003a = this.f25315cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f25315cN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aB */
    public boolean m33394aB() {
        if (this.f25317cP == 1) {
            m33393aC();
            return true;
        }
        m33388aH();
        return false;
    }

    /* renamed from: aC */
    private void m33393aC() {
        if (this.f25314cM == null) {
            m33392aD();
            return;
        }
        m33389aG();
        this.f25325co.setVisibility(8);
        this.f25313cL.setVisibility(0);
        KsAdWebView ksAdWebView = this.f25313cL;
        C9067aj.C9070a c9070a = this.f25314cM;
        ValueAnimator m29527c = C8951n.m29527c(ksAdWebView, c9070a.height + c9070a.bottomMargin, 0);
        this.f25323cV = m29527c;
        m29527c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f25323cV.setDuration(300L);
        this.f25323cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.b.b.c.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (C7377c.this.f25318cQ != null) {
                    C7377c.this.f25318cQ.m29267ss();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (C7377c.this.f25318cQ != null) {
                    C7377c.this.f25318cQ.m29268sr();
                }
            }
        });
        this.f25323cV.start();
    }

    /* renamed from: aD */
    private void m33392aD() {
        C9109aw c9109aw = this.f25318cQ;
        if (c9109aw != null) {
            c9109aw.m29268sr();
        }
        this.f25325co.setVisibility(8);
        this.f25313cL.setVisibility(0);
        C9109aw c9109aw2 = this.f25318cQ;
        if (c9109aw2 != null) {
            c9109aw2.m29267ss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aE */
    public void m33391aE() {
        if (this.f25313cL.getVisibility() != 0) {
            return;
        }
        if (this.f25314cM == null) {
            m33390aF();
            return;
        }
        m33389aG();
        KsAdWebView ksAdWebView = this.f25313cL;
        C9067aj.C9070a c9070a = this.f25314cM;
        ValueAnimator m29527c = C8951n.m29527c(ksAdWebView, 0, c9070a.height + c9070a.bottomMargin);
        this.f25324cW = m29527c;
        m29527c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f25324cW.setDuration(300L);
        this.f25324cW.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.b.b.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                C7377c.this.f25313cL.setVisibility(4);
                C7377c.this.f25325co.setVisibility(0);
                if (C7377c.this.f25318cQ != null) {
                    C7377c.this.f25318cQ.m29265su();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (C7377c.this.f25318cQ != null) {
                    C7377c.this.f25318cQ.m29266st();
                }
            }
        });
        this.f25324cW.start();
    }

    /* renamed from: aF */
    private void m33390aF() {
        if (this.f25313cL.getVisibility() != 0) {
            return;
        }
        C9109aw c9109aw = this.f25318cQ;
        if (c9109aw != null) {
            c9109aw.m29266st();
        }
        this.f25313cL.setVisibility(4);
        this.f25325co.setVisibility(0);
        C9109aw c9109aw2 = this.f25318cQ;
        if (c9109aw2 != null) {
            c9109aw2.m29265su();
        }
    }

    /* renamed from: aG */
    private void m33389aG() {
        ValueAnimator valueAnimator = this.f25323cV;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f25323cV.cancel();
        }
        ValueAnimator valueAnimator2 = this.f25324cW;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.f25324cW.cancel();
        }
    }

    /* renamed from: aH */
    private void m33388aH() {
        int i = this.f25317cP;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : "others";
        C10331c.m26246w("DrawPlayWebCard", "show webCard fail, reason: " + str);
    }

    /* renamed from: ax */
    private void m33387ax() {
        C10605b c10605b = new C10605b();
        this.f25316cO = c10605b;
        c10605b.setAdTemplate(this.f25273bO.mAdTemplate);
        C10605b c10605b2 = this.f25316cO;
        c10605b2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.f25273bO.mRootContainer;
        c10605b2.aDJ = adBaseFrameLayout;
        c10605b2.f29621OE = adBaseFrameLayout;
        c10605b2.f29620NY = this.f25313cL;
    }

    /* renamed from: ay */
    private void m33386ay() {
        this.f25317cP = -1;
        m33385az();
        this.f25313cL.setBackgroundColor(0);
        this.f25313cL.getBackground().setAlpha(0);
        this.f25313cL.setVisibility(4);
        this.f25313cL.loadUrl(C10484b.m25757ck(this.mAdTemplate));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    /* renamed from: az */
    private void m33385az() {
        m33395aA();
        C9003a c9003a = new C9003a(this.f25313cL);
        this.f25315cN = c9003a;
        m33396a(c9003a);
        this.f25313cL.addJavascriptInterface(this.f25315cN, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.f25317cP = -1;
        this.f25313cL.setVisibility(8);
        m33395aA();
    }

    @Override // com.kwad.components.p208ad.draw.p214a.C7357a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7358b c7358b = this.f25273bO;
        this.mAdTemplate = c7358b.mAdTemplate;
        c7358b.f25276ch.m33409a(this.f25312cG);
        C7358b c7358b2 = this.f25273bO;
        this.mApkDownloadHelper = c7358b2.mApkDownloadHelper;
        c7358b2.f25275bP.mo31843b(this.mVideoPlayStateListener);
        m33387ax();
        m33386ay();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25325co = (ViewGroup) findViewById(C9659R.C9662id.ksad_ad_normal_container);
        this.f25313cL = (KsAdWebView) findViewById(C9659R.C9662id.ksad_play_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f25273bO.f25276ch.m33409a((C7370a.InterfaceC7372b) null);
        this.f25273bO.f25275bP.mo31844a(this.mVideoPlayStateListener);
        m33389aG();
        release();
    }

    /* renamed from: a */
    private void m33396a(C9003a c9003a) {
        c9003a.m29403a(new C9036aa(this.f25316cO, this.mApkDownloadHelper, this.f25319cR, (byte) 0));
        c9003a.m29403a(new C9185x(this.f25316cO, this.mApkDownloadHelper, this.f25319cR));
        c9003a.m29403a(new C9046ad(this.f25316cO));
        c9003a.m29403a(new C9057ag(this.f25316cO));
        c9003a.m29403a(new C9043ac(this.f25316cO));
        c9003a.m29403a(new C9067aj(this.f25316cO, this.f25320cS));
        c9003a.m29403a(new C9092aq(this.f25322cU, C10484b.m25757ck(this.mAdTemplate)));
        C9109aw c9109aw = new C9109aw();
        this.f25318cQ = c9109aw;
        c9003a.m29403a(c9109aw);
        c9003a.m29403a(new C9119az(this.f25316cO, this.mApkDownloadHelper));
        c9003a.m29403a(new C9063ai(this.f25321cT));
        c9003a.m29403a(new C9072ak(this.f25316cO));
        c9003a.m29402b(new C9163m(this.f25316cO));
        c9003a.m29402b(new C9161l(this.f25316cO));
    }
}
