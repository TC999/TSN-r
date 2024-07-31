package com.kwad.components.core.webview;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.C9036aa;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9046ad;
import com.kwad.components.core.webview.jshandler.C9057ag;
import com.kwad.components.core.webview.jshandler.C9059ah;
import com.kwad.components.core.webview.jshandler.C9067aj;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.core.webview.jshandler.C9091ap;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9098as;
import com.kwad.components.core.webview.jshandler.C9106au;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9119az;
import com.kwad.components.core.webview.jshandler.C9122b;
import com.kwad.components.core.webview.jshandler.C9131bd;
import com.kwad.components.core.webview.jshandler.C9140c;
import com.kwad.components.core.webview.jshandler.C9143d;
import com.kwad.components.core.webview.jshandler.C9149g;
import com.kwad.components.core.webview.jshandler.C9154i;
import com.kwad.components.core.webview.jshandler.C9155j;
import com.kwad.components.core.webview.jshandler.C9157k;
import com.kwad.components.core.webview.jshandler.C9161l;
import com.kwad.components.core.webview.jshandler.C9163m;
import com.kwad.components.core.webview.jshandler.C9166o;
import com.kwad.components.core.webview.jshandler.C9169p;
import com.kwad.components.core.webview.jshandler.C9170q;
import com.kwad.components.core.webview.jshandler.C9173r;
import com.kwad.components.core.webview.jshandler.C9174s;
import com.kwad.components.core.webview.jshandler.C9176t;
import com.kwad.components.core.webview.jshandler.C9179u;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.jshandler.C9189y;
import com.kwad.components.core.webview.p332a.C9006a;
import com.kwad.components.core.webview.tachikoma.p333a.AbstractC9196d;
import com.kwad.components.core.webview.tachikoma.p333a.C9200f;
import com.kwad.components.core.webview.tachikoma.p333a.C9207j;
import com.kwad.components.core.webview.tachikoma.p333a.C9208k;
import com.kwad.components.core.webview.tachikoma.p333a.C9213l;
import com.kwad.components.core.webview.tachikoma.p333a.C9221s;
import com.kwad.components.core.webview.tachikoma.p334b.C9241b;
import com.kwad.components.core.webview.tachikoma.p334b.C9246g;
import com.kwad.components.core.webview.tachikoma.p334b.C9253n;
import com.kwad.components.core.webview.tachikoma.p334b.C9258s;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.download.C10303b;
import com.kwad.sdk.core.download.C10326d;
import com.kwad.sdk.core.download.C10327e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10636b;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.utils.C11128v;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9013b {

    /* renamed from: Hx */
    private KsAdWebView f29035Hx;

    /* renamed from: OJ */
    private KsAdWebView.InterfaceC10598c f29036OJ;

    /* renamed from: VA */
    private C9106au f29037VA;

    /* renamed from: VB */
    private C10326d f29038VB;

    /* renamed from: VC */
    private boolean f29039VC;

    /* renamed from: VD */
    private C9092aq.InterfaceC9095b f29040VD = new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.core.webview.b.13
        @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
        /* renamed from: a */
        public final void mo28994a(C9092aq.C9094a c9094a) {
            if (C9013b.this.f29045fY != null) {
                C9013b.this.f29045fY.mo29352a(c9094a);
            }
        }
    };

    /* renamed from: Vy */
    private ViewGroup f29041Vy;

    /* renamed from: Vz */
    private C9006a f29042Vz;

    /* renamed from: cN */
    private C9003a f29043cN;

    /* renamed from: cO */
    private C10605b f29044cO;

    /* renamed from: fY */
    private AbstractC9028c f29045fY;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    private String mPageUrl;

    /* renamed from: com.kwad.components.core.webview.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9027a {

        /* renamed from: Hx */
        private KsAdWebView f29060Hx;

        /* renamed from: OJ */
        private KsAdWebView.InterfaceC10598c f29061OJ;

        /* renamed from: VC */
        private boolean f29062VC;

        /* renamed from: Vy */
        private ViewGroup f29063Vy;

        /* renamed from: fY */
        private AbstractC9028c f29064fY;
        private AdTemplate mAdTemplate;
        private C8619c mApkDownloadHelper;
        private String mPageUrl;
        private JSONObject mReportExtData;

        @Nullable
        /* renamed from: a */
        public final C9027a m29371a(AbstractC9028c abstractC9028c) {
            this.f29064fY = abstractC9028c;
            return this;
        }

        @NonNull
        /* renamed from: aF */
        public final C9027a m29370aF(String str) {
            this.mPageUrl = str;
            return this;
        }

        /* renamed from: aS */
        public final C9027a m29369aS(boolean z) {
            this.f29062VC = z;
            return this;
        }

        @Nullable
        /* renamed from: az */
        public final C9027a m29368az(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        @Nullable
        /* renamed from: b */
        public final C9027a m29367b(KsAdWebView.InterfaceC10598c interfaceC10598c) {
            this.f29061OJ = interfaceC10598c;
            return this;
        }

        @NonNull
        /* renamed from: d */
        public final C9027a m29366d(KsAdWebView ksAdWebView) {
            this.f29060Hx = ksAdWebView;
            return this;
        }

        /* renamed from: e */
        public final C9027a m29365e(JSONObject jSONObject) {
            this.mReportExtData = jSONObject;
            return this;
        }

        /* renamed from: f */
        public final C9027a m29364f(C8619c c8619c) {
            this.mApkDownloadHelper = c8619c;
            return this;
        }

        /* renamed from: gZ */
        public final C8619c m29363gZ() {
            return this.mApkDownloadHelper;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        @NonNull
        /* renamed from: k */
        public final C9027a m29362k(ViewGroup viewGroup) {
            this.f29063Vy = viewGroup;
            return this;
        }

        /* renamed from: pB */
        public final KsAdWebView.InterfaceC10598c m29361pB() {
            return this.f29061OJ;
        }

        /* renamed from: pg */
        public final String m29360pg() {
            return this.mPageUrl;
        }

        /* renamed from: si */
        public final ViewGroup m29359si() {
            return this.f29063Vy;
        }

        /* renamed from: sj */
        public final KsAdWebView m29358sj() {
            return this.f29060Hx;
        }

        /* renamed from: sk */
        public final AbstractC9028c m29357sk() {
            return this.f29064fY;
        }

        /* renamed from: sl */
        public final boolean m29356sl() {
            return this.f29062VC;
        }
    }

    /* renamed from: aA */
    private void m29387aA() {
        C9003a c9003a = this.f29043cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f29043cN = null;
        }
        C9006a c9006a = this.f29042Vz;
        if (c9006a != null) {
            c9006a.destroy();
            this.f29042Vz = null;
        }
    }

    /* renamed from: ax */
    private void m29386ax() {
        C10605b c10605b = new C10605b();
        this.f29044cO = c10605b;
        c10605b.setAdTemplate(this.mAdTemplate);
        C10605b c10605b2 = this.f29044cO;
        c10605b2.mScreenOrientation = 0;
        c10605b2.f29620NY = this.f29035Hx;
        c10605b2.f29621OE = this.f29041Vy;
    }

    /* renamed from: es */
    private void m29379es() {
        this.f29035Hx.setClientConfig(this.f29035Hx.getClientConfig().m25331ei(this.mAdTemplate).m25332dx(m29372sg()).m25339b(m29373sf()).m25341a(m29374se()).m25333c(this.f29036OJ));
    }

    @NonNull
    private InterfaceC10635a getClickListener() {
        return new InterfaceC10635a() { // from class: com.kwad.components.core.webview.b.2
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
            /* renamed from: a */
            public final void mo25245a(C10640a c10640a) {
                if (C9013b.this.f29045fY != null) {
                    C9013b.this.f29045fY.mo29349a(c10640a);
                }
            }
        };
    }

    /* renamed from: sb */
    private boolean m29377sb() {
        AbstractC9028c abstractC9028c = this.f29045fY;
        if (abstractC9028c == null) {
            return false;
        }
        return abstractC9028c.mo29346pH();
    }

    /* renamed from: sc */
    private boolean m29376sc() {
        return false;
    }

    /* renamed from: sd */
    private C9072ak.InterfaceC9073a m29375sd() {
        return new C9072ak.InterfaceC9073a() { // from class: com.kwad.components.core.webview.b.3
            @Override // com.kwad.components.core.webview.jshandler.C9072ak.InterfaceC9073a
            public final void onAdShow() {
                if (C9013b.this.f29045fY != null) {
                    C9013b.this.f29045fY.onAdShow();
                }
            }
        };
    }

    @NonNull
    /* renamed from: se */
    private KsAdWebView.InterfaceC10597b m29374se() {
        return new KsAdWebView.InterfaceC10597b() { // from class: com.kwad.components.core.webview.b.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10597b
            public final void onFailed() {
                if (C9013b.this.f29037VA != null) {
                    C9013b.this.f29037VA.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10597b
            public final void onSuccess() {
                if (C9013b.this.f29037VA != null) {
                    C9013b.this.f29037VA.onSuccess();
                }
            }
        };
    }

    /* renamed from: sf */
    private KsAdWebView.InterfaceC10599d m29373sf() {
        return new KsAdWebView.InterfaceC10599d() { // from class: com.kwad.components.core.webview.b.5
            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageFinished() {
                if (C9013b.this.f29045fY != null) {
                    C9013b.this.f29045fY.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onReceivedHttpError(int i, String str, String str2) {
                if (C9013b.this.f29045fY != null) {
                    C9013b.this.f29045fY.mo29348g(i, str);
                }
            }
        };
    }

    /* renamed from: sg */
    private int m29372sg() {
        return C10483a.m25968T(C10487e.m25641dQ(this.mAdTemplate)) ? 5 : 1;
    }

    /* renamed from: jp */
    public final void m29378jp() {
        m29387aA();
        if (this.f29038VB != null) {
            C10303b.m26364De().m26357a(this.f29038VB);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    /* renamed from: b */
    private void m29383b(KsAdWebView ksAdWebView) {
        m29387aA();
        C9003a c9003a = new C9003a(ksAdWebView);
        this.f29043cN = c9003a;
        m29385b(c9003a, this.f29044cO);
        AbstractC9028c abstractC9028c = this.f29045fY;
        if (abstractC9028c != null) {
            abstractC9028c.mo29355a(this.f29043cN, this.f29044cO);
        }
        ksAdWebView.addJavascriptInterface(this.f29043cN, "KwaiAd");
    }

    /* renamed from: c */
    private void m29381c(KsAdWebView ksAdWebView) {
        m29387aA();
        C9006a c9006a = new C9006a(ksAdWebView, this.f29044cO);
        this.f29042Vz = c9006a;
        ksAdWebView.addJavascriptInterface(c9006a, "KwaiAdForThird");
    }

    /* renamed from: a */
    public final void m29391a(C9027a c9027a) {
        this.mPageUrl = c9027a.m29360pg();
        this.mAdTemplate = c9027a.getAdTemplate();
        this.f29041Vy = c9027a.m29359si();
        this.f29035Hx = c9027a.m29358sj();
        this.f29045fY = c9027a.m29357sk();
        this.mApkDownloadHelper = c9027a.m29363gZ();
        this.f29039VC = c9027a.m29356sl();
        this.f29036OJ = c9027a.m29361pB();
        m29379es();
        m29389a(this.f29045fY, this.f29035Hx);
        m29386ax();
        if (C10483a.m25972P(C10487e.m25641dQ(this.mAdTemplate))) {
            m29381c(this.f29035Hx);
        } else if (C10484b.m25670ep(this.mPageUrl)) {
            m29383b(this.f29035Hx);
        }
    }

    /* renamed from: b */
    private void m29385b(C9003a c9003a, C10605b c10605b) {
        C9109aw c9109aw = new C9109aw();
        c9003a.m29403a(c9109aw);
        m29388a(c9109aw);
        c9003a.m29403a(new C9176t());
        c9003a.m29403a(new C9122b());
        c9003a.m29403a(new C9179u());
        c9003a.m29403a(new C9166o());
        c9003a.m29403a(new C9169p());
        C9072ak c9072ak = new C9072ak(c10605b);
        c9003a.m29402b(new C9163m(c10605b));
        c9003a.m29402b(new C9161l(c10605b));
        c9072ak.m29308a(m29375sd());
        c9003a.m29403a(c9072ak);
        c9003a.m29403a(new C9046ad(c10605b));
        c9003a.m29403a(new C9200f());
        if (this.mApkDownloadHelper == null) {
            this.mApkDownloadHelper = new C8619c(this.mAdTemplate);
        }
        if (!this.f29039VC) {
            c9003a.m29403a(new C9036aa(this.f29044cO, this.mApkDownloadHelper, getClickListener(), m29377sb(), false, true));
            c9003a.m29403a(new C9185x(this.f29044cO, this.mApkDownloadHelper, getClickListener(), m29377sb(), 0, m29376sc(), true));
        }
        c9003a.m29403a(new C9119az(this.f29044cO, this.mApkDownloadHelper));
        c9003a.m29403a(new C9098as(this.f29044cO));
        c9003a.m29403a(new C9091ap(this.f29044cO.f29620NY.getContext(), this.mAdTemplate));
        c9003a.m29403a(new C9131bd(new C9131bd.InterfaceC9133a() { // from class: com.kwad.components.core.webview.b.1
            @Override // com.kwad.components.core.webview.jshandler.C9131bd.InterfaceC9133a
            /* renamed from: sh */
            public final void mo29243sh() {
                if (C10484b.m25768cX(C9013b.this.mAdTemplate)) {
                    AlertDialogC8602b.m30269a(C9013b.this.f29044cO.f29620NY.getContext(), new AlertDialogC8602b.C8604a().m30261ap(C9013b.this.mAdTemplate).m30262ae(C10484b.m25769cW(C9013b.this.mAdTemplate)).m30256nu());
                }
            }
        }));
        c9003a.m29403a(new C9059ah(this.f29044cO));
        c9003a.m29403a(new C9092aq(this.f29040VD, this.mPageUrl));
        C9106au c9106au = new C9106au();
        this.f29037VA = c9106au;
        c9003a.m29403a(c9106au);
        c9003a.m29403a(new C9189y(new InterfaceC10636b() { // from class: com.kwad.components.core.webview.b.6
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10636b
            /* renamed from: b */
            public final void mo25244b(WebCloseStatus webCloseStatus) {
                if (C9013b.this.f29045fY != null) {
                    C9013b.this.f29045fY.mo29350a(webCloseStatus);
                }
            }
        }));
        C9221s c9221s = new C9221s();
        c9221s.m29177a(new C9221s.InterfaceC9222a() { // from class: com.kwad.components.core.webview.b.7
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9221s.InterfaceC9222a
            /* renamed from: a */
            public final void mo28997a(C9258s c9258s) {
                if (TextUtils.isEmpty(c9258s.message)) {
                    return;
                }
                C11128v.m23667d(C9013b.this.f29044cO.f29620NY.getContext(), c9258s.message, 0L);
            }
        });
        c9003a.m29403a(c9221s);
        c9003a.m29403a(new C9208k());
        c9003a.m29403a(new C9057ag(c10605b));
        if (C10483a.m25956aF(C10487e.m25641dQ(this.mAdTemplate))) {
            final C9213l c9213l = new C9213l();
            c9003a.m29403a(c9213l);
            this.f29038VB = new C10326d(this.mAdTemplate) { // from class: com.kwad.components.core.webview.b.8
                @Override // com.kwad.sdk.core.download.C10326d, com.kwad.sdk.core.download.InterfaceC10325c
                /* renamed from: b */
                public final void mo26277b(String str, String str2, C10327e c10327e) {
                    super.mo26277b(str, str2, c10327e);
                    C9241b c9241b = new C9241b();
                    c9241b.aaf = 1;
                    c9213l.m29182a(c9241b);
                }
            };
            C10303b.m26364De().m26356a(this.f29038VB, this.mAdTemplate);
        }
        c9003a.m29403a(new AbstractC9196d() { // from class: com.kwad.components.core.webview.b.9
            @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9196d
            /* renamed from: a */
            public final void mo29001a(C9246g c9246g) {
                C8766a.m29888qi().m29918a(c9246g.actionType, C9013b.this.mAdTemplate, c9246g.f29315KG);
            }
        });
        c9003a.m29403a(new C9207j() { // from class: com.kwad.components.core.webview.b.10
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9207j
            /* renamed from: a */
            public final void mo29000a(C9253n c9253n) {
                super.mo29000a(c9253n);
                AdWebViewActivityProxy.launch(C9013b.this.f29044cO.f29620NY.getContext(), new AdWebViewActivityProxy.C8777a.C8778a().m29855as(c9253n.title).m29854at(c9253n.url).m29859aC(true).m29856as(C9013b.this.mAdTemplate).m29851pl());
            }
        });
        c9003a.m29403a(new C9143d());
        c9003a.m29403a(new C9149g());
        c9003a.m29403a(new C9155j());
        c9003a.m29403a(new C9140c());
        C9043ac c9043ac = new C9043ac(this.f29044cO);
        c9043ac.m29330a(new C9043ac.InterfaceC9045b() { // from class: com.kwad.components.core.webview.b.11
            @Override // com.kwad.components.core.webview.jshandler.C9043ac.InterfaceC9045b
            /* renamed from: c */
            public final void mo28996c(C9043ac.C9044a c9044a) {
                if (C9013b.this.f29045fY != null) {
                    C9013b.this.f29045fY.mo29354a(c9044a);
                }
            }
        });
        c9003a.m29403a(c9043ac);
        c9003a.m29403a(new C9157k(this.f29044cO.f29620NY.getContext(), this.mAdTemplate));
        c9003a.m29403a(new C9067aj(this.f29044cO, new C9067aj.InterfaceC9071b() { // from class: com.kwad.components.core.webview.b.12
            @Override // com.kwad.components.core.webview.jshandler.C9067aj.InterfaceC9071b
            /* renamed from: a */
            public final void mo28995a(C9067aj.C9070a c9070a) {
                if (C9013b.this.f29045fY != null) {
                    C9013b.this.f29045fY.mo29353a(c9070a);
                }
            }
        }));
        c9003a.m29403a(new C9154i());
        c9003a.m29403a(new C9174s());
        c9003a.m29403a(new C9173r());
        c9003a.m29403a(new C9170q());
    }

    /* renamed from: a */
    private void m29388a(C9109aw c9109aw) {
        AbstractC9028c abstractC9028c = this.f29045fY;
        if (abstractC9028c == null) {
            return;
        }
        abstractC9028c.mo29351a(c9109aw);
    }

    /* renamed from: a */
    private static void m29389a(AbstractC9028c abstractC9028c, WebView webView) {
        if (abstractC9028c == null || !abstractC9028c.mo29347pG()) {
            return;
        }
        webView.getSettings().setAllowFileAccess(true);
    }
}
