package com.kwad.components.core.p289e.p292c;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p326q.C8898a;
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
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.download.p395a.C10302c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11128v;
import com.kwad.sdk.utils.C11130w;

/* renamed from: com.kwad.components.core.e.c.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8608e extends C8606c implements View.OnClickListener {
    @Nullable

    /* renamed from: Ke */
    public AlertDialogC8602b f28191Ke;

    /* renamed from: Kf */
    public AlertDialogC8602b.C8605b f28192Kf;

    /* renamed from: Kn */
    private Runnable f28193Kn;

    /* renamed from: cL */
    private KsAdWebView f28195cL;

    /* renamed from: cN */
    private C9003a f28196cN;

    /* renamed from: cO */
    private C10605b f28197cO;

    /* renamed from: cQ */
    private C9109aw f28198cQ;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    /* renamed from: Ko */
    private boolean f28194Ko = false;

    /* renamed from: cR */
    private InterfaceC10635a f28199cR = new InterfaceC10635a() { // from class: com.kwad.components.core.e.c.e.1
        @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
        /* renamed from: a */
        public final void mo25245a(C10640a c10640a) {
            C10331c.m26254d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + View$OnClickListenerC8608e.this.f28194Ko);
            View$OnClickListenerC8608e.m30254a(View$OnClickListenerC8608e.this, true);
        }
    };

    /* renamed from: cS */
    private C9067aj.InterfaceC9071b f28200cS = new C9067aj.InterfaceC9071b() { // from class: com.kwad.components.core.e.c.e.4
        @Override // com.kwad.components.core.webview.jshandler.C9067aj.InterfaceC9071b
        /* renamed from: a */
        public final void mo28995a(C9067aj.C9070a c9070a) {
            C10331c.m26254d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + c9070a);
            View$OnClickListenerC8608e.this.f28195cL.setTranslationY((float) (c9070a.height + c9070a.bottomMargin));
        }
    };

    /* renamed from: cT */
    private C9063ai.InterfaceC9066b f28201cT = new C9063ai.InterfaceC9066b() { // from class: com.kwad.components.core.e.c.e.5
        @Override // com.kwad.components.core.webview.jshandler.C9063ai.InterfaceC9066b
        /* renamed from: a */
        public final void mo29313a(C9063ai.C9065a c9065a) {
            C10331c.m26254d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            View$OnClickListenerC8608e.this.m30251aF();
        }
    };

    /* renamed from: cU */
    private C9092aq.InterfaceC9095b f28202cU = new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.core.e.c.e.6
        @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
        /* renamed from: a */
        public final void mo28994a(C9092aq.C9094a c9094a) {
            C10331c.m26248i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + c9094a);
            if (c9094a.status == 1) {
                View$OnClickListenerC8608e.this.m30235nx();
                return;
            }
            View$OnClickListenerC8608e.this.m30251aF();
            if (View$OnClickListenerC8608e.this.getContext() != null) {
                C11128v.m23672O(View$OnClickListenerC8608e.this.getContext(), C11130w.m23665bY(View$OnClickListenerC8608e.this.getContext()));
            }
        }
    };

    /* renamed from: aA */
    private void m30252aA() {
        C9003a c9003a = this.f28196cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f28196cN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aF */
    public void m30251aF() {
        C10331c.m26254d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.f28194Ko);
        if (this.f28195cL.getVisibility() != 0) {
            return;
        }
        C9109aw c9109aw = this.f28198cQ;
        if (c9109aw != null) {
            c9109aw.m29266st();
        }
        this.f28195cL.setVisibility(4);
        C9109aw c9109aw2 = this.f28198cQ;
        if (c9109aw2 != null) {
            c9109aw2.m29265su();
        }
        if (this.f28194Ko) {
            C9908c.m27320bO(this.mAdTemplate);
        }
        AlertDialogC8602b alertDialogC8602b = this.f28191Ke;
        if (alertDialogC8602b == null || !alertDialogC8602b.isShowing()) {
            return;
        }
        this.f28191Ke.m30268aj(this.f28194Ko);
    }

    /* renamed from: ax */
    private void m30250ax() {
        C10605b c10605b = new C10605b();
        this.f28197cO = c10605b;
        c10605b.setAdTemplate(this.f28188Kg.mAdTemplate);
        C10605b c10605b2 = this.f28197cO;
        AdBaseFrameLayout adBaseFrameLayout = this.f28188Kg.mRootContainer;
        c10605b2.aDJ = adBaseFrameLayout;
        c10605b2.f29621OE = adBaseFrameLayout;
        c10605b2.f29620NY = this.f28195cL;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    /* renamed from: az */
    private void m30249az() {
        C10331c.m26254d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        m30252aA();
        C9003a c9003a = new C9003a(this.f28195cL);
        this.f28196cN = c9003a;
        m30253a(c9003a);
        this.f28195cL.addJavascriptInterface(this.f28196cN, "KwaiAd");
    }

    /* renamed from: nv */
    private void m30237nv() {
        m30249az();
        this.f28195cL.loadUrl(this.f28192Kf.url);
        this.f28195cL.postDelayed(m30236nw(), 1500L);
        this.f28195cL.setBackgroundColor(0);
        this.f28195cL.getBackground().setAlpha(0);
        this.f28195cL.setVisibility(0);
    }

    /* renamed from: nw */
    private Runnable m30236nw() {
        if (this.f28193Kn == null) {
            this.f28193Kn = new Runnable() { // from class: com.kwad.components.core.e.c.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    View$OnClickListenerC8608e.this.m30251aF();
                    if (View$OnClickListenerC8608e.this.getContext() != null) {
                        C11128v.m23672O(View$OnClickListenerC8608e.this.getContext(), C11130w.m23665bY(View$OnClickListenerC8608e.this.getContext()));
                    }
                }
            };
        }
        return this.f28193Kn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: nx */
    public void m30235nx() {
        Runnable runnable = this.f28193Kn;
        if (runnable != null) {
            this.f28195cL.removeCallbacks(runnable);
        }
    }

    private void release() {
        this.f28195cL.setVisibility(8);
        this.f28195cL.release();
        m30252aA();
    }

    @Override // com.kwad.components.core.p289e.p292c.C8606c, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C8607d c8607d = this.f28188Kg;
        this.f28191Ke = c8607d.f28189Ke;
        this.f28192Kf = c8607d.f28190Kf;
        this.mAdTemplate = c8607d.mAdTemplate;
        c8607d.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.f28188Kg.mApkDownloadHelper;
        m30250ax();
        m30237nv();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C9908c.m27320bO(this.mAdTemplate);
        AlertDialogC8602b alertDialogC8602b = this.f28191Ke;
        if (alertDialogC8602b != null) {
            alertDialogC8602b.dismiss();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f28195cL = (KsAdWebView) findViewById(C9659R.C9662id.ksad_download_tips_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        m30235nx();
    }

    /* renamed from: a */
    static /* synthetic */ boolean m30254a(View$OnClickListenerC8608e view$OnClickListenerC8608e, boolean z) {
        view$OnClickListenerC8608e.f28194Ko = true;
        return true;
    }

    /* renamed from: a */
    private void m30253a(C9003a c9003a) {
        c9003a.m29403a(new C9036aa(this.f28197cO, this.mApkDownloadHelper, this.f28199cR));
        c9003a.m29403a(new C9185x(this.f28197cO, this.mApkDownloadHelper, this.f28199cR, 1));
        c9003a.m29403a(new C9046ad(this.f28197cO));
        c9003a.m29403a(new C9057ag(this.f28197cO));
        c9003a.m29403a(new C9043ac(this.f28197cO));
        c9003a.m29403a(new C9067aj(this.f28197cO, this.f28200cS));
        c9003a.m29403a(new C9092aq(this.f28202cU, this.f28192Kf.url));
        C9109aw c9109aw = new C9109aw();
        this.f28198cQ = c9109aw;
        c9003a.m29403a(c9109aw);
        c9003a.m29403a(new C9119az(this.f28197cO, this.mApkDownloadHelper, new C10302c() { // from class: com.kwad.components.core.e.c.e.3
            @Override // com.kwad.sdk.core.download.p395a.C10302c, com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                super.onInstalled();
                AdInfo m25641dQ = C10487e.m25641dQ(View$OnClickListenerC8608e.this.mAdTemplate);
                String m25911ay = C10483a.m25911ay(m25641dQ);
                if (C10483a.m25947aO(m25641dQ) && C10483a.m25956aF(m25641dQ) && C11017ak.m24114an(View$OnClickListenerC8608e.this.getContext(), m25911ay) && C8898a.m29651qH().m29647qL() && C10483a.m25948aN(m25641dQ) == 1) {
                    View$OnClickListenerC8608e.this.f28191Ke.dismiss();
                }
            }
        }));
        c9003a.m29403a(new C9063ai(this.f28201cT));
        c9003a.m29403a(new C9072ak(this.f28197cO));
        c9003a.m29402b(new C9163m(this.f28197cO));
        c9003a.m29402b(new C9161l(this.f28197cO));
    }
}
