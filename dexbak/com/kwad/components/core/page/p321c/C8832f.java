package com.kwad.components.core.page.p321c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.jshandler.C9036aa;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9046ad;
import com.kwad.components.core.webview.jshandler.C9057ag;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.core.webview.jshandler.C9089ao;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9119az;
import com.kwad.components.core.webview.jshandler.C9161l;
import com.kwad.components.core.webview.jshandler.C9163m;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.p332a.C9011b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.webview.C10605b;

/* renamed from: com.kwad.components.core.page.c.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8832f extends AbstractC8828c {

    /* renamed from: NY */
    private WebView f28605NY;

    /* renamed from: OD */
    private int f28606OD = -1;

    /* renamed from: OE */
    private ViewGroup f28607OE;

    /* renamed from: OF */
    private final InterfaceC8835a f28608OF;

    /* renamed from: cN */
    private C9003a f28609cN;

    /* renamed from: cO */
    private C10605b f28610cO;
    private AdTemplate mAdTemplate;
    private final boolean mIsRewardLandPage;

    /* renamed from: com.kwad.components.core.page.c.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8835a {
        /* renamed from: aA */
        void mo29768aA(int i);
    }

    public C8832f(InterfaceC8835a interfaceC8835a, boolean z) {
        this.f28608OF = interfaceC8835a;
        this.mIsRewardLandPage = z;
    }

    /* renamed from: aA */
    private void m29776aA() {
        C9003a c9003a = this.f28609cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f28609cN = null;
        }
    }

    /* renamed from: au */
    private void m29775au(String str) {
        m29773az();
        this.f28605NY.loadUrl(str);
    }

    /* renamed from: ax */
    private void m29774ax() {
        C10605b c10605b = new C10605b();
        this.f28610cO = c10605b;
        c10605b.setAdTemplate(this.mAdTemplate);
        C10605b c10605b2 = this.f28610cO;
        c10605b2.f29621OE = this.f28607OE;
        c10605b2.f29620NY = this.f28605NY;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    /* renamed from: az */
    private void m29773az() {
        m29776aA();
        C9003a c9003a = new C9003a(this.f28605NY);
        this.f28609cN = c9003a;
        m29777a(c9003a);
        this.f28605NY.addJavascriptInterface(this.f28609cN, "KwaiAd");
    }

    private C9089ao.InterfaceC9090a getOpenNewPageListener() {
        return new C9089ao.InterfaceC9090a() { // from class: com.kwad.components.core.page.c.f.2
            @Override // com.kwad.components.core.webview.jshandler.C9089ao.InterfaceC9090a
            /* renamed from: a */
            public final void mo29284a(C9011b c9011b) {
                AdWebViewActivityProxy.launch(C8832f.this.f28605NY.getContext(), new AdWebViewActivityProxy.C8777a.C8778a().m29855as(c9011b.title).m29854at(c9011b.url).m29859aC(true).m29856as(C8832f.this.mAdTemplate).m29851pl());
            }
        };
    }

    /* renamed from: ps */
    private C9092aq.InterfaceC9095b m29769ps() {
        return new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.core.page.c.f.1
            @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
            /* renamed from: a */
            public final void mo28994a(C9092aq.C9094a c9094a) {
                C8832f.this.f28606OD = c9094a.status;
                if (C8832f.this.f28608OF != null) {
                    C8832f.this.f28608OF.mo29768aA(c9094a.status);
                }
                if (c9094a.status == 1) {
                    C8832f.this.f28607OE.setVisibility(0);
                } else {
                    C8832f.this.f28605NY.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.p321c.AbstractC8828c, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdTemplate adTemplate = this.f28603OB.mAdTemplate;
        this.mAdTemplate = adTemplate;
        String m25745cw = C10484b.m25745cw(adTemplate);
        if (!TextUtils.isEmpty(m25745cw)) {
            m29774ax();
            m29775au(m25745cw);
            return;
        }
        InterfaceC8835a interfaceC8835a = this.f28608OF;
        if (interfaceC8835a != null) {
            interfaceC8835a.mo29768aA(this.f28606OD);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f28605NY = (WebView) findViewById(C9659R.C9662id.ksad_landing_page_webview);
        this.f28607OE = (ViewGroup) findViewById(C9659R.C9662id.ksad_web_card_container);
        this.f28605NY.setBackgroundColor(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        m29776aA();
    }

    /* renamed from: a */
    private void m29777a(C9003a c9003a) {
        C10331c.m26254d("LandPageWebViewPresenter", "registerWebCardHandler");
        C8619c c8619c = new C8619c(this.f28603OB.mAdTemplate);
        c9003a.m29403a(new C9046ad(this.f28610cO));
        c9003a.m29403a(new C9057ag(this.f28610cO));
        c9003a.m29403a(new C9119az(this.f28610cO, c8619c));
        c9003a.m29403a(new C9043ac(this.f28610cO));
        c9003a.m29403a(new C9109aw());
        c9003a.m29403a(new C9092aq(m29769ps(), C10484b.m25745cw(this.mAdTemplate)));
        c9003a.m29403a(new C9072ak(this.f28610cO));
        c9003a.m29402b(new C9163m(this.f28610cO));
        c9003a.m29402b(new C9161l(this.f28610cO));
        c9003a.m29403a(new C9089ao(getOpenNewPageListener()));
        c9003a.m29403a(new C9036aa(this.f28610cO, c8619c, null, (byte) 0));
        c9003a.m29403a(new C9185x(this.f28610cO, c8619c, null, 2, this.mIsRewardLandPage));
    }
}
