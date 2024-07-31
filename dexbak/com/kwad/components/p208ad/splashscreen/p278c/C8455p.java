package com.kwad.components.p208ad.splashscreen.p278c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.jshandler.C9036aa;
import com.kwad.components.core.webview.jshandler.C9046ad;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9116ay;
import com.kwad.components.core.webview.jshandler.C9119az;
import com.kwad.components.core.webview.jshandler.C9161l;
import com.kwad.components.core.webview.jshandler.C9163m;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.tachikoma.p333a.C9200f;
import com.kwad.components.core.webview.tachikoma.p336d.C9279a;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.InterfaceC8477e;
import com.kwad.components.p208ad.splashscreen.InterfaceC8488g;
import com.kwad.components.p208ad.splashscreen.local.C8494b;
import com.kwad.components.p208ad.splashscreen.monitor.C8498c;
import com.kwad.components.p208ad.splashscreen.p284f.C8484b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p402g.C10380d;
import com.kwad.sdk.core.p402g.InterfaceC10376b;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.C10644f;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.c.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8455p extends C8421e implements InterfaceC8477e, InterfaceC8488g, InterfaceC10385c {

    /* renamed from: DV */
    private C8484b f27799DV;

    /* renamed from: DW */
    private boolean f27800DW;

    /* renamed from: DY */
    private long f27802DY;

    /* renamed from: DZ */
    private C9109aw f27803DZ;

    /* renamed from: Eb */
    private ViewGroup f27805Eb;
    @Nullable

    /* renamed from: cL */
    private KsAdWebView f27807cL;

    /* renamed from: cN */
    private C9003a f27808cN;

    /* renamed from: cO */
    private C10605b f27809cO;

    /* renamed from: eg */
    private C10380d f27810eg;

    /* renamed from: eh */
    private Vibrator f27811eh;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private long mStartTime;

    /* renamed from: DX */
    private boolean f27801DX = false;

    /* renamed from: Ea */
    private boolean f27804Ea = false;

    /* renamed from: Ec */
    private final Runnable f27806Ec = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.1
        @Override // java.lang.Runnable
        public final void run() {
            C8455p.m30702a(C8455p.this, true);
            C8498c.m30547a(C8455p.this.mAdTemplate, C10484b.m25759ci(C8455p.this.mAdTemplate), SystemClock.elapsedRealtime() - C8455p.this.f27802DY, 1, "");
            C8455p.this.m30681lw();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public Vibrator m30708D(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    /* renamed from: aA */
    private void m30697aA() {
        C9003a c9003a = this.f27808cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f27808cN = null;
        }
    }

    /* renamed from: ax */
    private void m30696ax() {
        C10605b c10605b = new C10605b();
        this.f27809cO = c10605b;
        c10605b.setAdTemplate(this.mAdTemplate);
        C10605b c10605b2 = this.f27809cO;
        c10605b2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.f27734Dg.mRootContainer;
        c10605b2.aDJ = adBaseFrameLayout;
        c10605b2.f29621OE = adBaseFrameLayout;
        c10605b2.f29620NY = this.f27807cL;
        c10605b2.mReportExtData = null;
        c10605b2.aDL = false;
        c10605b2.aDM = C8489h.m30597n(this.mAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bu */
    public void m30694bu() {
        if (this.f27810eg != null || this.f27801DX) {
            return;
        }
        C10380d c10380d = new C10380d(C10484b.m25772cT(this.f27734Dg.mAdTemplate));
        this.f27810eg = c10380d;
        c10380d.m26199a(new InterfaceC10376b() { // from class: com.kwad.components.ad.splashscreen.c.p.8
            @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
            /* renamed from: a */
            public final void mo26220a(double d) {
                boolean m30267nr = AlertDialogC8602b.m30267nr();
                if (!C8455p.this.f27734Dg.f27881Cs.mo26185tz() || m30267nr) {
                    return;
                }
                C8455p.this.m30688h(d);
                if (C8455p.this.f27811eh == null) {
                    C8455p c8455p = C8455p.this;
                    c8455p.f27811eh = c8455p.m30708D(c8455p.getContext());
                }
                C11064bn.m23863a(C8455p.this.getContext(), C8455p.this.f27811eh);
                C8455p.this.f27810eg.m26194bj(C8455p.this.getContext());
            }

            @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
            /* renamed from: aV */
            public final void mo26219aV() {
            }
        });
        this.f27810eg.m26195bi(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lw */
    public void m30681lw() {
        this.f27801DX = true;
        KsAdWebView ksAdWebView = this.f27807cL;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ViewGroup viewGroup = this.f27805Eb;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (C10484b.m25676dx(this.mAdInfo)) {
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.10
                @Override // java.lang.Runnable
                public final void run() {
                    C8455p.this.m24611a((Presenter) new View$OnClickListenerC8442m(), true);
                }
            });
        } else if (C10484b.m25672dz(this.mAdInfo)) {
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.11
                @Override // java.lang.Runnable
                public final void run() {
                    C8455p.this.m24611a((Presenter) new View$OnClickListenerC8438l(), true);
                }
            });
        } else if (C10484b.m25738dC(this.mAdInfo)) {
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.12
                @Override // java.lang.Runnable
                public final void run() {
                    C8455p.this.m24611a((Presenter) new C8447n(), true);
                }
            });
        } else {
            m30680lx();
        }
    }

    /* renamed from: lx */
    private void m30680lx() {
        m30682lv();
        boolean m25657dF = C10486d.m25657dF(this.mAdTemplate);
        C8484b c8484b = new C8484b((ViewGroup) getRootView(), (ViewStub) findViewById(C9659R.C9662id.ksad_splash_actionbar_native_stub), m25657dF, this.f27734Dg.mApkDownloadHelper);
        this.f27799DV = c8484b;
        c8484b.m30637ah(this.mAdTemplate);
        this.f27799DV.m30639a(this);
        this.f27799DV.m30634lw();
    }

    /* renamed from: ly */
    private C9185x m30679ly() {
        return new C9185x(this.f27809cO, this.f27734Dg.mApkDownloadHelper, new InterfaceC10635a() { // from class: com.kwad.components.ad.splashscreen.c.p.2
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
            /* renamed from: a */
            public final void mo25245a(C10640a c10640a) {
                if (C10751a.m24929Au()) {
                    return;
                }
                if (c10640a.m25240Hb() || C8489h.m30597n(C8455p.this.mAdInfo)) {
                    C8455p.this.m30698a(false, c10640a.f29644XC, c10640a.f29646kl, c10640a.f29645XD.f29649KG);
                }
            }
        });
    }

    /* renamed from: lz */
    private C9036aa m30678lz() {
        return new C9036aa(this.f27809cO, this.f27734Dg.mApkDownloadHelper, new InterfaceC10635a() { // from class: com.kwad.components.ad.splashscreen.c.p.3
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
            /* renamed from: a */
            public final void mo25245a(C10640a c10640a) {
                if (c10640a.f29643XA || !C8489h.m30597n(C8455p.this.mAdInfo)) {
                    C8455p.this.m30698a(false, c10640a.f29643XA ? 1 : 3, c10640a.f29646kl, "");
                }
            }
        }, (byte) 0);
    }

    @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8488g
    /* renamed from: W */
    public final void mo30629W(int i) {
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        C10380d c10380d = this.f27810eg;
        if (c10380d != null) {
            c10380d.m26195bi(getContext());
        }
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        C10380d c10380d = this.f27810eg;
        if (c10380d != null) {
            c10380d.m26194bj(getContext());
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.f27734Dg.f27881Cs.mo26187a(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(C9659R.C9662id.ksad_splash_webview_container);
        this.f27805Eb = viewGroup;
        viewGroup.setVisibility(0);
        try {
            this.f27807cL = new KsAdWebView(getContext());
            this.f27807cL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f27805Eb.addView(this.f27807cL);
        } catch (Throwable unused) {
        }
        AdTemplate adTemplate = this.f27734Dg.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        this.f27800DW = false;
        this.f27801DX = false;
        String m25759ci = C10484b.m25759ci(this.mAdTemplate);
        if (this.f27807cL != null && !TextUtils.isEmpty(m25759ci) && !this.f27734Dg.f27886Cx) {
            this.f27802DY = SystemClock.elapsedRealtime();
            C8498c.m30545ag(this.mAdTemplate);
            m30699a(this.f27807cL, m25759ci);
            C11064bn.m23862a(this.f27806Ec, null, C10484b.m25734dG(this.mAdInfo));
        } else {
            m30681lw();
        }
        this.f27734Dg.m30622a(this);
    }

    @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8488g
    /* renamed from: kA */
    public final void mo30628kA() {
        C10380d c10380d = this.f27810eg;
        if (c10380d != null) {
            c10380d.m26194bj(getContext());
        }
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: lv */
    public final void m30682lv() {
        if (this.f27800DW) {
            return;
        }
        this.f27800DW = true;
        C9893a.C9894a c9894a = new C9893a.C9894a();
        c9894a.apc = C8494b.m30592s(this.mAdInfo);
        C9908c.m27309d(this.f27734Dg.mAdTemplate, (JSONObject) null, new C9913b().m27264cM(123).m27268b(c9894a));
        C9279a.m29119sY().m29121aW(123);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C8484b c8484b = this.f27799DV;
        if (c8484b != null) {
            c8484b.onUnbind();
        }
        C10380d c10380d = this.f27810eg;
        if (c10380d != null) {
            c10380d.m26194bj(getContext());
        }
        C9109aw c9109aw = this.f27803DZ;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27803DZ.m29265su();
        }
        this.f27734Dg.f27881Cs.mo26186b(this);
        m30697aA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m30688h(final double d) {
        C8489h c8489h = this.f27734Dg;
        if (c8489h != null) {
            c8489h.m30624a(1, getContext(), 157, 2, new C8489h.InterfaceC8492a() { // from class: com.kwad.components.ad.splashscreen.c.p.9
                @Override // com.kwad.components.p208ad.splashscreen.C8489h.InterfaceC8492a
                /* renamed from: b */
                public final void mo30595b(@NonNull C9913b c9913b) {
                    c9913b.m27246l(d);
                }
            });
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8477e
    /* renamed from: h */
    public final void mo30651h(boolean z, boolean z2) {
        C10331c.m26254d("SplashWebViewPresenter", "isClick: " + z + ", isActionBar: " + z2);
        m30698a(!z, z2 ? 1 : 2, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, null);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m30702a(C8455p c8455p, boolean z) {
        c8455p.f27804Ea = true;
        return true;
    }

    /* renamed from: a */
    private void m30699a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.setVisibility(0);
        m30696ax();
        m30707a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().m25331ei(this.f27734Dg.mAdTemplate).m25339b(new C10644f() { // from class: com.kwad.components.ad.splashscreen.c.p.5
            @Override // com.kwad.sdk.core.webview.C10644f, com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageFinished() {
                super.onPageFinished();
                C8498c.m30544b(C8455p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - C8455p.this.f27802DY);
            }

            @Override // com.kwad.sdk.core.webview.C10644f, com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onReceivedHttpError(int i, String str2, String str3) {
                super.onReceivedHttpError(i, str2, str3);
                C11064bn.m23858c(C8455p.this.f27806Ec);
                C8455p.this.m30681lw();
                C8498c.m30547a(C8455p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - C8455p.this.f27802DY, 2, str2);
            }
        }));
        C8498c.m30543d(str, this.mAdTemplate);
        try {
            ksAdWebView.loadUrl(str);
        } catch (Throwable unused) {
            m30681lw();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    /* renamed from: a */
    private void m30707a(WebView webView, String str) {
        m30697aA();
        webView.getSettings().setAllowFileAccess(true);
        C9003a c9003a = new C9003a(webView);
        this.f27808cN = c9003a;
        m30700a(c9003a, str);
        webView.addJavascriptInterface(this.f27808cN, "KwaiAd");
    }

    /* renamed from: a */
    private void m30700a(C9003a c9003a, final String str) {
        c9003a.m29403a(new C9119az(this.f27809cO, this.f27734Dg.mApkDownloadHelper));
        c9003a.m29403a(m30678lz());
        c9003a.m29403a(m30679ly());
        c9003a.m29403a(new C9046ad(this.f27809cO));
        c9003a.m29403a(new C9200f());
        c9003a.m29403a(new C9092aq(new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.ad.splashscreen.c.p.6
            @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
            /* renamed from: a */
            public final void mo28994a(C9092aq.C9094a c9094a) {
                C10331c.m26254d("SplashWebViewPresenter", "updatePageStatus: " + c9094a);
                C11064bn.m23858c(C8455p.this.f27806Ec);
                if (c9094a.status == 1) {
                    C8455p.this.f27734Dg.f27877CJ = SystemClock.elapsedRealtime() - C8455p.this.mStartTime;
                    if (!C8455p.this.f27804Ea) {
                        if (C8455p.this.f27803DZ != null) {
                            C8455p.this.f27803DZ.m29268sr();
                            C8455p.this.f27803DZ.m29267ss();
                        }
                    } else {
                        C8455p.this.f27734Dg.isWebTimeout = true;
                    }
                    if (C10484b.m25736dE(C8455p.this.mAdInfo)) {
                        C8455p.this.m30682lv();
                        return;
                    }
                    return;
                }
                C8498c.m30547a(C8455p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - C8455p.this.f27802DY, 3, "");
                C8455p.this.m30681lw();
            }
        }, str));
        c9003a.m29403a(new C9116ay(new C9116ay.InterfaceC9118a() { // from class: com.kwad.components.ad.splashscreen.c.p.7
            @Override // com.kwad.components.core.webview.jshandler.C9116ay.InterfaceC9118a
            /* renamed from: bB */
            public final void mo29256bB() {
                C8455p.this.m30694bu();
            }
        }));
        c9003a.m29403a(new C9072ak(this.f27809cO));
        c9003a.m29402b(new C9163m(this.f27809cO));
        c9003a.m29402b(new C9161l(this.f27809cO));
        C9109aw c9109aw = new C9109aw();
        this.f27803DZ = c9109aw;
        c9003a.m29403a(c9109aw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m30698a(boolean r10, int r11, int r12, java.lang.String r13) {
        /*
            r9 = this;
            com.kwad.components.ad.splashscreen.h r0 = r9.f27734Dg
            r0.m30615kB()
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            if (r11 != r1) goto L10
            r3 = 1
            goto L11
        L10:
            r3 = 0
        L11:
            if (r0 != 0) goto L4b
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            com.kwad.components.ad.splashscreen.h r5 = r9.f27734Dg     // Catch: org.json.JSONException -> L45
            if (r5 == 0) goto L4b
            com.kwad.components.ad.splashscreen.e.a r5 = r5.f27879Cq     // Catch: org.json.JSONException -> L45
            if (r5 == 0) goto L29
            java.lang.String r6 = "duration"
            long r7 = r5.getCurrentPosition()     // Catch: org.json.JSONException -> L45
            r4.put(r6, r7)     // Catch: org.json.JSONException -> L45
        L29:
            if (r10 == 0) goto L2e
            r2 = 153(0x99, float:2.14E-43)
            goto L32
        L2e:
            if (r3 == 0) goto L32
            r2 = 132(0x84, float:1.85E-43)
        L32:
            com.kwad.sdk.core.adlog.c.b r10 = new com.kwad.sdk.core.adlog.c.b     // Catch: org.json.JSONException -> L43
            r10.<init>()     // Catch: org.json.JSONException -> L43
            com.kwad.sdk.core.adlog.c.b r10 = r10.m27266cK(r2)     // Catch: org.json.JSONException -> L43
            com.kwad.components.ad.splashscreen.h r5 = r9.f27734Dg     // Catch: org.json.JSONException -> L43
            com.kwad.sdk.core.response.model.AdTemplate r5 = r5.mAdTemplate     // Catch: org.json.JSONException -> L43
            com.kwad.sdk.core.adlog.C9908c.m27340a(r5, r10, r4)     // Catch: org.json.JSONException -> L43
            goto L4c
        L43:
            r10 = move-exception
            goto L47
        L45:
            r10 = move-exception
            r2 = r12
        L47:
            com.kwad.sdk.core.p397e.C10331c.printStackTrace(r10)
            goto L4c
        L4b:
            r2 = r12
        L4c:
            com.kwad.components.core.e.d.a$a r10 = new com.kwad.components.core.e.d.a$a
            com.kwad.components.ad.splashscreen.h r4 = r9.f27734Dg
            com.kwad.sdk.core.view.AdBaseFrameLayout r4 = r4.mRootContainer
            android.content.Context r4 = r4.getContext()
            r10.<init>(r4)
            com.kwad.components.ad.splashscreen.h r4 = r9.f27734Dg
            com.kwad.sdk.core.response.model.AdTemplate r4 = r4.mAdTemplate
            com.kwad.components.core.e.d.a$a r10 = r10.m30198aq(r4)
            com.kwad.components.ad.splashscreen.h r4 = r9.f27734Dg
            com.kwad.components.core.e.d.c r4 = r4.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r10 = r10.m30189b(r4)
            com.kwad.components.core.e.d.a$a r10 = r10.m30202ao(r3)
            com.kwad.components.core.e.d.a$a r10 = r10.m30205an(r11)
            if (r0 == 0) goto L74
            goto L75
        L74:
            r12 = r2
        L75:
            com.kwad.components.core.e.d.a$a r10 = r10.m30207am(r12)
            com.kwad.components.core.e.d.a$a r10 = r10.m30212ag(r13)
            com.kwad.components.core.e.d.a$a r10 = r10.m30209al(r1)
            com.kwad.components.core.e.d.a$a r10 = r10.m30197aq(r0)
            com.kwad.components.ad.splashscreen.c.p$4 r11 = new com.kwad.components.ad.splashscreen.c.p$4
            r11.<init>()
            com.kwad.components.core.e.d.a$a r10 = r10.m30216a(r11)
            com.kwad.components.core.p289e.p293d.C8615a.m30233a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.splashscreen.p278c.C8455p.m30698a(boolean, int, int, java.lang.String):void");
    }
}
