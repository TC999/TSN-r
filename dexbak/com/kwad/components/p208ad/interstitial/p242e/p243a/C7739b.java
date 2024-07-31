package com.kwad.components.p208ad.interstitial.p242e.p243a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p330s.C8947j;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.C8791a;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9063ai;
import com.kwad.components.core.webview.jshandler.C9089ao;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9116ay;
import com.kwad.components.core.webview.jshandler.C9138bf;
import com.kwad.components.core.webview.jshandler.C9180v;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.p332a.C9011b;
import com.kwad.components.core.webview.tachikoma.C9238b;
import com.kwad.components.core.webview.tachikoma.C9265c;
import com.kwad.components.core.webview.tachikoma.C9287e;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9201g;
import com.kwad.components.core.webview.tachikoma.p333a.C9215n;
import com.kwad.components.core.webview.tachikoma.p333a.C9219q;
import com.kwad.components.core.webview.tachikoma.p334b.C9240a;
import com.kwad.components.core.webview.tachikoma.p334b.C9242c;
import com.kwad.components.core.webview.tachikoma.p334b.C9243d;
import com.kwad.components.core.webview.tachikoma.p334b.C9250k;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.core.webview.tachikoma.p334b.C9263x;
import com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e;
import com.kwad.components.p208ad.interstitial.AlertDialogC7725d;
import com.kwad.components.p208ad.interstitial.p239b.C7721b;
import com.kwad.components.p208ad.interstitial.p240c.C7724b;
import com.kwad.components.p208ad.interstitial.p241d.C7728a;
import com.kwad.components.p208ad.interstitial.p242e.C7761c;
import com.kwad.components.p208ad.interstitial.p244f.C7791a;
import com.kwad.components.p208ad.interstitial.p244f.C7793b;
import com.kwad.components.p208ad.interstitial.report.C7802a;
import com.kwad.components.p208ad.interstitial.report.C7806c;
import com.kwad.components.p208ad.p233g.p234a.p235a.C7661a;
import com.kwad.components.p208ad.p233g.p234a.p235a.C7662b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.p402g.C10380d;
import com.kwad.sdk.core.p402g.InterfaceC10376b;
import com.kwad.sdk.core.p403h.C10386d;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11067bq;
import java.io.File;

/* renamed from: com.kwad.components.ad.interstitial.e.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7739b extends AbstractC7737a {

    /* renamed from: le */
    private static long f26162le = 400;

    /* renamed from: eg */
    private C10380d f26164eg;

    /* renamed from: eh */
    private Vibrator f26165eh;

    /* renamed from: fD */
    private C9109aw f26166fD;
    @Nullable

    /* renamed from: lc */
    private C7662b f26168lc;

    /* renamed from: ld */
    private FrameLayout f26169ld;

    /* renamed from: lg */
    private boolean f26171lg;

    /* renamed from: lh */
    private C9287e f26172lh;

    /* renamed from: lf */
    private boolean f26170lf = false;

    /* renamed from: jP */
    private final C7761c.InterfaceC7768a f26167jP = new C7761c.InterfaceC7768a() { // from class: com.kwad.components.ad.interstitial.e.a.b.1
        @Override // com.kwad.components.p208ad.interstitial.p242e.C7761c.InterfaceC7768a
        /* renamed from: b */
        public final void mo32411b(long j, long j2) {
            C7802a.m32299dM().m32300b(C7739b.this.f26196jK.mAdTemplate, j, j2);
            if (C7739b.this.f26172lh != null) {
                C9240a c9240a = new C9240a();
                c9240a.aae = C7739b.this.f26196jK.f26204jM ? 1 : 0;
                C7739b.this.f26172lh.m29103b(c9240a);
            }
        }
    };

    /* renamed from: df */
    private InterfaceC10385c f26163df = new C10386d() { // from class: com.kwad.components.ad.interstitial.e.a.b.9
        @Override // com.kwad.sdk.core.p403h.C10386d, com.kwad.sdk.core.p403h.InterfaceC10385c
        /* renamed from: aM */
        public final void mo26182aM() {
            if (C7739b.this.f26166fD != null && !C7739b.this.f26170lf) {
                C7739b.m32513a(C7739b.this, true);
                C7739b.this.f26166fD.m29268sr();
                C7739b.this.f26166fD.m29267ss();
            }
            if (C7739b.this.f26166fD != null) {
                C7739b.this.f26166fD.m29264sv();
            }
            if (C7739b.this.f26168lc != null) {
                C7739b.this.f26168lc.m32703eH();
            }
            if (!C7739b.this.f26171lg) {
                C7739b.this.f26196jK.f26202io.getTimerHelper().startTiming();
            }
            if (C7739b.this.f26171lg || C7739b.this.f26196jK.f26206jO || C7739b.this.f26196jK.f26201ie == null) {
                return;
            }
            C7739b.this.f26196jK.f26201ie.onAdShow();
            C7806c.m32283dQ().m32288a(C7739b.this.f26196jK.mAdTemplate, 3);
            C7739b.m32507b(C7739b.this, true);
        }

        @Override // com.kwad.sdk.core.p403h.C10386d, com.kwad.sdk.core.p403h.InterfaceC10385c
        /* renamed from: aN */
        public final void mo26181aN() {
            if (C7739b.this.f26166fD != null) {
                C7739b.this.f26166fD.m29263sw();
            }
            if (C7739b.this.f26168lc != null) {
                C7739b.this.f26168lc.m32704eG();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bu */
    public void m32506bu() {
        if (getContext() != null) {
            this.f26165eh = (Vibrator) getContext().getSystemService("vibrator");
        }
        float m25774cR = C10484b.m25774cR(this.f26196jK.mAdTemplate);
        if (this.f26164eg == null) {
            C10380d c10380d = new C10380d(m25774cR);
            this.f26164eg = c10380d;
            c10380d.m26199a(new InterfaceC10376b() { // from class: com.kwad.components.ad.interstitial.e.a.b.7
                @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
                /* renamed from: a */
                public final void mo26220a(double d) {
                    if (C11067bq.m23850o(C7739b.this.getTKContainer(), 100)) {
                        C7739b.this.m32504d(d);
                    }
                    C11064bn.m23862a(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.a.b.7.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C7739b.this.f26164eg.m26202Fu();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
                /* renamed from: aV */
                public final void mo26219aV() {
                }
            });
        }
        this.f26164eg.m26192e(m25774cR);
        this.f26164eg.m26195bi(getContext());
    }

    /* renamed from: dB */
    private C9265c m32502dB() {
        return new C9265c() { // from class: com.kwad.components.ad.interstitial.e.a.b.14
            @Override // com.kwad.components.core.webview.tachikoma.C9265c, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
            /* renamed from: a */
            public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
                super.mo25241a(str, interfaceC10627c);
                C9242c c9242c = new C9242c();
                c9242c.aag = C7728a.m32548cO();
                interfaceC10627c.mo25251a(c9242c);
            }
        };
    }

    /* renamed from: dC */
    private C9287e m32501dC() {
        return new C9287e() { // from class: com.kwad.components.ad.interstitial.e.a.b.15
            @Override // com.kwad.components.core.webview.tachikoma.C9287e, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
            /* renamed from: a */
            public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
                super.mo25241a(str, interfaceC10627c);
                C9240a c9240a = new C9240a();
                c9240a.aae = C7739b.this.f26196jK.f26204jM ? 1 : 0;
                interfaceC10627c.mo25251a(c9240a);
            }
        };
    }

    /* renamed from: dD */
    private C9201g m32500dD() {
        C9250k c9250k = new C9250k();
        c9250k.aal = this.f26196jK.f26217jZ;
        return new C9201g(c9250k);
    }

    /* renamed from: dE */
    private C7661a m32499dE() {
        final C7661a c7661a = new C7661a();
        this.f26196jK.f26212jU.add(new C7761c.InterfaceC7770c() { // from class: com.kwad.components.ad.interstitial.e.a.b.16
            @Override // com.kwad.components.p208ad.interstitial.p242e.C7761c.InterfaceC7770c
            /* renamed from: cZ */
            public final void mo32410cZ() {
                c7661a.m32709eE();
            }
        });
        return c7661a;
    }

    /* renamed from: dF */
    private C9138bf m32498dF() {
        C9138bf c9138bf = new C9138bf(getContext(), this.f26196jK.mAdTemplate);
        c9138bf.m29240a(new C9138bf.InterfaceC9139a() { // from class: com.kwad.components.ad.interstitial.e.a.b.3
            @Override // com.kwad.components.core.webview.jshandler.C9138bf.InterfaceC9139a
            /* renamed from: dK */
            public final boolean mo29239dK() {
                C8791a.launch(C7739b.this.getContext(), C7739b.this.f26196jK.mAdTemplate);
                C7739b.this.f26196jK.m32457a(true, -1, null);
                C11064bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.a.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C7739b.this.m32493dt();
                    }
                }, 0L);
                return false;
            }
        });
        return c9138bf;
    }

    @NonNull
    /* renamed from: dG */
    private C9215n m32497dG() {
        return new C9215n() { // from class: com.kwad.components.ad.interstitial.e.a.b.4
            @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
            /* renamed from: a */
            public final void mo25241a(String str, @NonNull final InterfaceC10627c interfaceC10627c) {
                super.mo25241a(str, interfaceC10627c);
                C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.a.b.4.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C9243d c9243d = new C9243d();
                        c9243d.aah = C11013ag.isWifiConnected(C7739b.this.getContext()) || C7739b.this.f26196jK.f26197dU.isDataFlowAutoStart() || C7739b.m32485k(C7739b.this.f26196jK.mAdTemplate);
                        interfaceC10627c.mo25251a(c9243d);
                    }
                }, 0L);
            }
        };
    }

    @NonNull
    /* renamed from: dH */
    private C9063ai m32496dH() {
        return new C9063ai(new C9063ai.InterfaceC9066b() { // from class: com.kwad.components.ad.interstitial.e.a.b.5
            @Override // com.kwad.components.core.webview.jshandler.C9063ai.InterfaceC9066b
            /* renamed from: a */
            public final void mo29313a(final C9063ai.C9065a c9065a) {
                if (C7739b.this.f26196jK.f26202io != null) {
                    C7739b.this.f26196jK.f26210jS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.a.b.5.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            if (c9065a.type == 0 && !C7739b.this.f26196jK.f26204jM && !C7739b.this.f26196jK.f26205jN && C7791a.m32366d(C7739b.this.f26196jK)) {
                                C7739b.this.f26196jK.f26205jN = true;
                                C7724b.m32562I(C7739b.this.getContext());
                                return;
                            }
                            C7739b.this.m32494dJ();
                            C7761c c7761c = C7739b.this.f26196jK;
                            C9063ai.C9065a c9065a2 = c9065a;
                            c7761c.m32457a(c9065a2.type == 3, c9065a2.f29144Xn, null);
                            C7739b.this.m32493dt();
                        }
                    });
                }
            }
        });
    }

    /* renamed from: dI */
    private C9180v m32495dI() {
        return new C9180v() { // from class: com.kwad.components.ad.interstitial.e.a.b.6
            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: a */
            public final void mo29216a(C9263x c9263x) {
                super.mo29216a(c9263x);
                if (C7739b.this.f26196jK.f26206jO || C7739b.this.f26196jK.f26201ie == null) {
                    return;
                }
                C7739b.this.f26196jK.f26201ie.onVideoPlayStart();
            }

            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: c */
            public final void mo29214c(C9263x c9263x) {
                super.mo29214c(c9263x);
                if (C7739b.this.f26196jK.f26206jO || C7739b.this.f26196jK.f26201ie == null) {
                    return;
                }
                C7739b.this.f26196jK.f26201ie.onVideoPlayEnd();
            }

            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: d */
            public final void mo29213d(C9263x c9263x) {
                super.mo29213d(c9263x);
                C7739b.this.f26196jK.mAdTemplate.setmCurPlayTime(c9263x.f29320nE);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dJ */
    public void m32494dJ() {
        C9109aw c9109aw = this.f26166fD;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f26166fD.m29265su();
        }
        C7662b c7662b = this.f26168lc;
        if (c7662b != null) {
            c7662b.m32704eG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dt */
    public void m32493dt() {
        C7761c c7761c = this.f26196jK;
        if (c7761c == null) {
            return;
        }
        AlertDialogC7725d alertDialogC7725d = c7761c.f26202io;
        if (alertDialogC7725d != null && m32516a(alertDialogC7725d)) {
            this.f26196jK.f26202io.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.f26196jK.f26201ie;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th) {
            C8571a.reportSdkCaughtException(th);
        }
    }

    private C9089ao.InterfaceC9090a getOpenNewPageListener() {
        return new C9089ao.InterfaceC9090a() { // from class: com.kwad.components.ad.interstitial.e.a.b.8
            @Override // com.kwad.components.core.webview.jshandler.C9089ao.InterfaceC9090a
            /* renamed from: a */
            public final void mo29284a(C9011b c9011b) {
                AdWebViewActivityProxy.launch(C7739b.this.getContext(), new AdWebViewActivityProxy.C8777a.C8778a().m29855as(c9011b.title).m29854at(c9011b.url).m29859aC(true).m29852m(C7739b.this.f26196jK.mAdResultData).m29851pl());
            }
        };
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.p243a.AbstractC7737a, com.kwad.components.p208ad.interstitial.p242e.C7760b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        C7806c.m32283dQ().m32278s(this.f26196jK.mAdTemplate);
        AbstractC9293e abstractC9293e = this.f26196jK.f26209jR;
        if (abstractC9293e != null) {
            abstractC9293e.mo29094a(getTkTemplateId(), 0L, 0L, 0L);
        }
        if (this.f26166fD != null && this.f26196jK.f26200ib.mo28897dW()) {
            this.f26170lf = true;
            this.f26166fD.m29268sr();
            this.f26166fD.m29267ss();
        }
        this.f26196jK.f26200ib.mo26187a(this.f26163df);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bG */
    public final void mo28979bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final FrameLayout getTKContainer() {
        return this.f26169ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_interstitial";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25683dt(this.f26196jK.mAdTemplate);
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.p243a.AbstractC7737a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(C9659R.C9662id.ksad_tk_view);
        this.f26169ld = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.p243a.AbstractC7737a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26170lf = false;
        this.f26171lg = false;
        C11064bn.m23861b(getContext(), this.f26165eh);
        C10380d c10380d = this.f26164eg;
        if (c10380d != null) {
            c10380d.m26194bj(getContext());
        }
        C7793b c7793b = this.f26196jK.f26200ib;
        if (c7793b != null) {
            c7793b.mo26186b(this.f26163df);
        }
        this.f26196jK.m32454b(this.f26167jP);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m32507b(C7739b c7739b, boolean z) {
        c7739b.f26171lg = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m32504d(double d) {
        this.f26196jK.m32461a(new C7761c.C7769b(getContext()).m32434l(true).m32443c(d).m32432z(2).m32444a(this.f26196jK.f26210jS.getTouchCoords()).m32445A(157));
        C11064bn.vibrate(getContext(), this.f26165eh, f26162le);
    }

    /* renamed from: k */
    public static boolean m32485k(@NonNull AdTemplate adTemplate) {
        File m26391bV = C10291a.m26395Dc().m26391bV(C10483a.m25977K(C10487e.m25641dQ(adTemplate)));
        return m26391bV != null && m26391bV.exists();
    }

    /* renamed from: a */
    static /* synthetic */ boolean m32513a(C7739b c7739b, boolean z) {
        c7739b.f26170lf = true;
        return true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        float m24919aJ = C10751a.m24919aJ(getContext());
        c9044a.width = (int) ((C11059bi.getScreenWidth(getContext()) / m24919aJ) + 0.5f);
        c9044a.height = (int) ((C11059bi.getScreenHeight(getContext()) / m24919aJ) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        this.f26169ld.setVisibility(8);
        AbstractC9293e abstractC9293e = this.f26196jK.f26209jR;
        if (abstractC9293e != null) {
            getTkTemplateId();
            abstractC9293e.mo29101q(getTKReaderScene());
        }
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.p243a.AbstractC7737a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        super.mo28983a(interfaceC9876q, c10605b);
        C7662b m32701z = C7662b.m32701z(this.f26196jK.mAdTemplate);
        this.f26168lc = m32701z;
        if (m32701z != null) {
            m32701z.m32707a(new C7662b.InterfaceC7665b() { // from class: com.kwad.components.ad.interstitial.e.a.b.10
                @Override // com.kwad.components.p208ad.p233g.p234a.p235a.C7662b.InterfaceC7665b
                /* renamed from: E */
                public final void mo32469E(int i) {
                    if (i == C7662b.f25966nu) {
                        C7739b.this.f26196jK.m32455b(C7739b.this.getContext(), C7739b.this.f26196jK.mAdTemplate);
                        C7739b.this.f26196jK.m32457a(true, -1, null);
                    }
                    C7739b.this.m32493dt();
                }
            });
            interfaceC9876q.mo27480c(this.f26168lc);
            this.f26168lc.m32705eF();
        }
        interfaceC9876q.mo27480c(m32496dH());
        interfaceC9876q.mo27480c(new C9089ao(getOpenNewPageListener()));
        if (C10484b.m25694do(C10487e.m25641dQ(this.f26196jK.mAdTemplate))) {
            interfaceC9876q.mo27480c(new C9116ay(new C9116ay.InterfaceC9118a() { // from class: com.kwad.components.ad.interstitial.e.a.b.11
                @Override // com.kwad.components.core.webview.jshandler.C9116ay.InterfaceC9118a
                /* renamed from: bB */
                public final void mo29256bB() {
                    C7739b.this.m32506bu();
                }
            }));
        }
        interfaceC9876q.mo27480c(m32497dG());
        interfaceC9876q.mo27480c(m32498dF());
        interfaceC9876q.mo27480c(m32500dD());
        interfaceC9876q.mo27480c(m32512a(c10605b));
        interfaceC9876q.mo27480c(m32495dI());
        interfaceC9876q.mo27480c(m32499dE());
        interfaceC9876q.mo27480c(new C9219q() { // from class: com.kwad.components.ad.interstitial.e.a.b.12
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9219q, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
            /* renamed from: a */
            public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
                super.mo25241a(str, interfaceC10627c);
                C8947j.m29548e(C7739b.this.getContext(), C7739b.this.f26196jK.mAdTemplate);
            }
        });
        this.f26172lh = m32501dC();
        this.f26196jK.m32462a(this.f26167jP);
        interfaceC9876q.mo27480c(this.f26172lh);
        interfaceC9876q.mo27480c(new C9238b(new C9238b.InterfaceC9239a() { // from class: com.kwad.components.ad.interstitial.e.a.b.13
            @Override // com.kwad.components.core.webview.tachikoma.C9238b.InterfaceC9239a
            /* renamed from: dL */
            public final void mo29166dL() {
                C7728a.m32550J(C7739b.this.getContext());
            }
        }));
        interfaceC9876q.mo27480c(m32502dB());
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.p243a.AbstractC7737a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28990a(C9109aw c9109aw) {
        super.mo28990a(c9109aw);
        this.f26166fD = c9109aw;
    }

    @NonNull
    /* renamed from: a */
    private C9185x m32512a(C10605b c10605b) {
        return new C9185x(c10605b, this.f26196jK.mApkDownloadHelper, new InterfaceC10635a() { // from class: com.kwad.components.ad.interstitial.e.a.b.2
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
            /* renamed from: a */
            public final void mo25245a(C10640a c10640a) {
                if (c10640a != null) {
                    C7802a.m32299dM().m32302a(C7739b.this.f26196jK.mAdTemplate, c10640a.aEM, c10640a.f29646kl);
                    C7739b.this.f26196jK.f26204jM = true;
                    if (!C7739b.this.f26196jK.f26206jO) {
                        C7739b.this.f26196jK.m32456b(c10640a.aEM, c10640a.f29646kl);
                    }
                    if (C7739b.this.f26196jK.f26202io == null || !C7721b.m32569cK()) {
                        return;
                    }
                    C7739b.this.f26196jK.m32457a(false, -1, C7739b.this.f26196jK.f26198eN);
                    C7739b.this.f26196jK.f26202io.dismiss();
                }
            }
        });
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.p243a.AbstractC7737a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28985a(C9259t c9259t) {
        super.mo28985a(c9259t);
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f26196jK.f26201ie;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
    }

    /* renamed from: a */
    private static boolean m32516a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.p243a.AbstractC7737a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28984a(WebCloseStatus webCloseStatus) {
        this.f26196jK.m32457a(webCloseStatus.closeType == 2, -1, null);
        m32493dt();
    }
}
