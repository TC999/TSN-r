package com.kwad.components.core.page.p321c.p322a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.p321c.p322a.C8814f;
import com.kwad.components.core.webview.AbstractC9028c;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.C9013b;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9102at;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9127bc;
import com.kwad.components.core.webview.tachikoma.p333a.C9194b;
import com.kwad.components.core.webview.tachikoma.p333a.C9201g;
import com.kwad.components.core.webview.tachikoma.p334b.C9250k;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.commercial.p378g.C9835a;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p391c.InterfaceC10246c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10636b;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.core.page.c.a.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8818g extends AbstractC8803a {

    /* renamed from: Os */
    public AdWebViewActivityProxy.C8777a f28584Os;

    /* renamed from: Pk */
    private C9109aw f28587Pk;

    /* renamed from: Pl */
    private C9102at f28588Pl;

    /* renamed from: fX */
    private C9013b f28589fX;
    public AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;

    /* renamed from: Pi */
    private boolean f28585Pi = false;

    /* renamed from: Pj */
    private boolean f28586Pj = false;

    /* renamed from: wT */
    private final InterfaceC10246c f28591wT = new AbstractC10247d() { // from class: com.kwad.components.core.page.c.a.g.1
        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
        /* renamed from: onActivityDestroyed */
        public final void mo24589b(Activity activity) {
            super.mo24589b(activity);
            if (C8818g.this.mAdWebView == null || C8818g.this.getActivity() == null || !C8818g.this.getActivity().equals(activity)) {
                return;
            }
            C8818g.this.mAdWebView.onActivityDestroy();
            C8818g.m29791a(C8818g.this, (KsAdWebView) null);
        }

        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
        /* renamed from: onActivityPaused */
        public final void mo26607c(Activity activity) {
            super.mo26607c(activity);
            C8818g.this.hide();
        }

        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
        /* renamed from: onActivityResumed */
        public final void mo26606d(Activity activity) {
            super.mo26606d(activity);
            C8818g.this.show();
        }
    };

    /* renamed from: OM */
    private C9102at.InterfaceC9104b f28583OM = new C9102at.InterfaceC9104b() { // from class: com.kwad.components.core.page.c.a.g.2
        @Override // com.kwad.components.core.webview.jshandler.C9102at.InterfaceC9104b
        /* renamed from: pF */
        public final void mo29273pF() {
            if (C8818g.this.f28588Pl != null) {
                C8818g.this.f28588Pl.m29274sq();
            }
        }
    };

    /* renamed from: fY */
    private AbstractC9028c f28590fY = new AbstractC9028c() { // from class: com.kwad.components.core.page.c.a.g.3
        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29355a(C9003a c9003a, C10605b c10605b) {
            c9003a.m29403a(new C9127bc(new C9127bc.InterfaceC9130b() { // from class: com.kwad.components.core.page.c.a.g.3.1
                @Override // com.kwad.components.core.webview.jshandler.C9127bc.InterfaceC9130b
                /* renamed from: a */
                public final void mo29246a(C9127bc.C9129a c9129a) {
                    C8814f.InterfaceC8817a interfaceC8817a = C8818g.this.f28548OH.f28551OL;
                    if (interfaceC8817a == null || c9129a == null) {
                        return;
                    }
                    interfaceC8817a.mo29795aB(c9129a.visibility);
                }
            }));
            C8818g.this.f28588Pl = new C9102at(new C9102at.InterfaceC9105c() { // from class: com.kwad.components.core.page.c.a.g.3.2
                @Override // com.kwad.components.core.webview.jshandler.C9102at.InterfaceC9105c
                /* renamed from: pI */
                public final void mo29272pI() {
                    C8818g c8818g = C8818g.this;
                    c8818g.f28548OH.m29830a(c8818g.f28583OM);
                }
            });
            c9003a.m29403a(C8818g.this.f28588Pl);
            c9003a.m29403a(new C9194b(c10605b, C8818g.this.f28548OH.mAdTemplate));
            C9250k c9250k = new C9250k();
            c9250k.aam = C8818g.this.f28548OH.mAutoShow ? 1 : 0;
            c9003a.m29403a(new C9201g(c9250k));
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: g */
        public final void mo29348g(int i, String str) {
            C8818g.this.f28585Pi = false;
            C8818g c8818g = C8818g.this;
            C9835a.m27558a(c8818g.mAdTemplate, c8818g.f28584Os.m29863ph(), C8818g.this.f28584Os.m29864pg(), i, str);
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        public final void onPageFinished() {
            C8818g.this.f28585Pi = true;
            if (!C8818g.this.f28586Pj) {
                C8818g.m29788b(C8818g.this, true);
                C8818g c8818g = C8818g.this;
                C9835a.m27551m(c8818g.mAdTemplate, c8818g.f28584Os.m29863ph(), C8818g.this.f28584Os.m29864pg());
            }
            if (C8818g.this.f28548OH.m29824pu()) {
                C8818g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: pG */
        public final boolean mo29347pG() {
            return true;
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: pH */
        public final boolean mo29346pH() {
            return true;
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29351a(C9109aw c9109aw) {
            C8818g.this.f28587Pk = c9109aw;
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29352a(C9092aq.C9094a c9094a) {
            C8818g.this.f28548OH.f28553ON = c9094a.isSuccess();
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29350a(WebCloseStatus webCloseStatus) {
            InterfaceC10636b interfaceC10636b = C8818g.this.f28548OH.mWebCardCloseListener;
            if (interfaceC10636b != null) {
                interfaceC10636b.mo25244b(webCloseStatus);
            }
        }
    };

    /* renamed from: es */
    private void m29785es() {
        this.f28589fX = new C9013b();
        this.f28589fX.m29391a(new C9013b.C9027a().m29368az(this.f28548OH.mAdTemplate).m29370aF(this.f28548OH.mPageUrl).m29366d(this.mAdWebView).m29362k(this.f28548OH.f28556gS).m29371a(this.f28590fY).m29367b(this.f28548OH.f28550OJ));
        m29784pE();
        C9835a.m27552l(this.mAdTemplate, this.f28584Os.m29863ph(), this.f28584Os.m29864pg());
        this.mAdWebView.loadUrl(this.f28548OH.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: pE */
    private void m29784pE() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().m25334bw(true).m25331ei(this.f28548OH.mAdTemplate).m25336bu(false));
        if (C10483a.m25899bI(C10487e.m25641dQ(this.f28548OH.mAdTemplate)) > 0) {
            C11064bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.g.4
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    if (C8818g.this.mAdWebView != null) {
                        C8818g.this.mAdWebView.getClientConfig().m25336bu(true);
                    }
                }
            }, C10483a.m25899bI(C10487e.m25641dQ(this.f28548OH.mAdTemplate)));
        } else if (C10483a.m25899bI(C10487e.m25641dQ(this.f28548OH.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().m25336bu(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.c.a.g.5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    C8818g.this.mAdWebView.getClientConfig().m25336bu(true);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.kwad.components.core.page.p321c.p322a.AbstractC8803a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C8804b c8804b = this.f28548OH;
        this.f28584Os = c8804b.f28555Os;
        this.mAdTemplate = c8804b.mAdTemplate;
        m29785es();
        C10232b.m26625DD();
        C10232b.m26622a(this.f28591wT);
    }

    public final void hide() {
        C9109aw c9109aw = this.f28587Pk;
        if (c9109aw != null) {
            c9109aw.m29266st();
        }
        KsAdWebView ksAdWebView = this.f28548OH.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        C9109aw c9109aw2 = this.f28587Pk;
        if (c9109aw2 != null) {
            c9109aw2.m29265su();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(C9659R.C9662id.ksad_video_webview);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f28589fX.m29378jp();
        C10232b.m26625DD();
        C10232b.m26621b(this.f28591wT);
    }

    public final void show() {
        if (this.f28585Pi) {
            C9109aw c9109aw = this.f28587Pk;
            if (c9109aw != null) {
                c9109aw.m29268sr();
            }
            try {
                KsAdWebView ksAdWebView = this.f28548OH.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(0);
                }
            } catch (Exception e) {
                C8571a.reportSdkCaughtException(e);
            }
            C9109aw c9109aw2 = this.f28587Pk;
            if (c9109aw2 != null) {
                c9109aw2.m29267ss();
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ boolean m29788b(C8818g c8818g, boolean z) {
        c8818g.f28586Pj = true;
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ KsAdWebView m29791a(C8818g c8818g, KsAdWebView ksAdWebView) {
        c8818g.mAdWebView = null;
        return null;
    }
}
