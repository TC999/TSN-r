package com.kwad.components.core.page.p321c;

import android.annotation.SuppressLint;
import com.kwad.components.core.page.recycle.C8850e;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.jshandler.C9046ad;
import com.kwad.components.core.webview.jshandler.C9057ag;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9161l;
import com.kwad.components.core.webview.jshandler.C9163m;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* renamed from: com.kwad.components.core.page.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8826b extends Presenter {

    /* renamed from: cN */
    private C9003a f28599cN;

    /* renamed from: cO */
    private C10605b f28600cO;

    /* renamed from: cU */
    private C9092aq.InterfaceC9095b f28601cU = new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.core.page.c.b.1
        @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
        /* renamed from: a */
        public final void mo28994a(C9092aq.C9094a c9094a) {
        }
    };
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;

    /* renamed from: a */
    private void m29783a(C9003a c9003a) {
        c9003a.m29403a(new C9046ad(this.f28600cO));
        c9003a.m29403a(new C9057ag(this.f28600cO));
        c9003a.m29403a(new C9092aq(this.f28601cU, C10483a.m25943aS(C10487e.m25641dQ(this.mAdTemplate))));
        c9003a.m29403a(new C9072ak(this.f28600cO));
        c9003a.m29402b(new C9163m(this.f28600cO));
        c9003a.m29402b(new C9161l(this.f28600cO));
    }

    /* renamed from: aA */
    private void m29782aA() {
        C9003a c9003a = this.f28599cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f28599cN = null;
        }
    }

    /* renamed from: ax */
    private void m29781ax() {
        C10605b c10605b = new C10605b();
        this.f28600cO = c10605b;
        c10605b.setAdTemplate(this.mAdTemplate);
        C10605b c10605b2 = this.f28600cO;
        c10605b2.mScreenOrientation = 0;
        c10605b2.f29620NY = this.mAdWebView;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    /* renamed from: az */
    private void m29780az() {
        m29782aA();
        C9003a c9003a = new C9003a(this.mAdWebView);
        this.f28599cN = c9003a;
        m29783a(c9003a);
        this.mAdWebView.addJavascriptInterface(this.f28599cN, "KwaiAd");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.mAdTemplate = ((C8850e) m24613Jx()).adTemplate;
        KsAdWebView ksAdWebView = (KsAdWebView) getRootView().findViewById(C9659R.C9662id.ksad_video_webView);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().m25334bw(true).m25331ei(this.mAdTemplate));
        m29781ax();
        m29780az();
        this.mAdWebView.loadUrl(C10483a.m25943aS(C10487e.m25641dQ(this.mAdTemplate)));
        this.mAdWebView.onActivityCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        m29782aA();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
    }
}
