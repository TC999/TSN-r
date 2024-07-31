package com.kwad.components.p208ad.splashscreen.p278c.p281c;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9214m;
import com.kwad.components.core.webview.tachikoma.p333a.C9225u;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.InterfaceC8482f;
import com.kwad.components.p208ad.splashscreen.monitor.C8495a;
import com.kwad.components.p208ad.splashscreen.monitor.C8497b;
import com.kwad.components.p208ad.splashscreen.p283e.C8478a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;

/* renamed from: com.kwad.components.ad.splashscreen.c.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8407a extends AbstractC8418c implements InterfaceC10385c {

    /* renamed from: Fc */
    private C9214m f27717Fc;

    /* renamed from: ld */
    private FrameLayout f27719ld;

    /* renamed from: wz */
    private C9109aw f27720wz;

    /* renamed from: Ff */
    private boolean f27718Ff = false;

    /* renamed from: ER */
    InterfaceC8482f f27716ER = new InterfaceC8482f() { // from class: com.kwad.components.ad.splashscreen.c.c.a.3
        @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8482f
        /* renamed from: kw */
        public final void mo30643kw() {
            C8407a.this.f27719ld.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    C8407a.this.f27719ld.setVisibility(8);
                }
            }, 500L);
            if (C8407a.this.f27720wz != null) {
                C8407a.this.f27720wz.m29266st();
                C8407a.this.f27720wz.m29265su();
            }
        }
    };

    @NonNull
    /* renamed from: lK */
    private C9214m m30764lK() {
        C9214m c9214m = new C9214m();
        this.f27717Fc = c9214m;
        return c9214m;
    }

    /* renamed from: lL */
    private void m30763lL() {
        C8478a c8478a = this.f27734Dg.f27879Cq;
        if (c8478a != null) {
            c8478a.m30644lO();
        }
    }

    @NonNull
    /* renamed from: lM */
    private C9225u m30762lM() {
        C9225u c9225u = new C9225u();
        c9225u.m29175a(new C9225u.InterfaceC9226a() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9225u.InterfaceC9226a
            /* renamed from: a */
            public final void mo29174a(final C9225u.C9227b c9227b) {
                int i = c9227b.status;
                if (i == 1) {
                    C8407a.this.f27734Dg.mRootContainer.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            if (AlertDialogC8602b.m30267nr()) {
                                C8407a.this.f27734Dg.mRootContainer.postDelayed(this, 1000L);
                            } else {
                                C8407a.this.f27734Dg.m30604kM();
                            }
                        }
                    });
                } else if (i == 2) {
                    C8407a.this.f27734Dg.mRootContainer.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.2
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C8495a.m30585kT().m30584l(C8407a.this.f27734Dg.mAdTemplate);
                            C8407a.this.f27734Dg.m30602kO();
                        }
                    });
                } else if (i == 3) {
                    C8407a.this.f27734Dg.mRootContainer.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.3
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C8407a.this.f27734Dg.m30613kD();
                        }
                    });
                } else if (i == 4) {
                    C8407a.this.f27734Dg.mRootContainer.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.4
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C8489h c8489h = C8407a.this.f27734Dg;
                            C9225u.C9227b c9227b2 = c9227b;
                            c8489h.m30616i(c9227b2.errorCode, c9227b2.errorMsg);
                        }
                    });
                }
            }
        });
        return c9225u;
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        if (this.f27734Dg.f27888Cz) {
            return;
        }
        C9109aw c9109aw = this.f27720wz;
        if (c9109aw != null) {
            c9109aw.m29264sv();
        } else {
            this.f27718Ff = true;
        }
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        C9109aw c9109aw;
        if (this.f27734Dg.f27888Cz || (c9109aw = this.f27720wz) == null) {
            return;
        }
        c9109aw.m29263sw();
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C8497b.m30550kV();
        C8489h c8489h = this.f27734Dg;
        C8497b.m30563b(c8489h.mAdTemplate, c8489h.f27880Cr);
        this.f27734Dg.f27881Cs.mo26187a(this);
        this.f27734Dg.m30623a(this.f27716ER);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        C9109aw c9109aw;
        if (this.f27734Dg.f27888Cz) {
            return;
        }
        C9109aw c9109aw2 = this.f27720wz;
        if (c9109aw2 != null) {
            c9109aw2.m29268sr();
            this.f27720wz.m29267ss();
        }
        if (this.f27718Ff && (c9109aw = this.f27720wz) != null) {
            c9109aw.m29264sv();
        }
        this.f27719ld.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final FrameLayout getTKContainer() {
        return this.f27719ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25763ce(this.f27734Dg.mAdTemplate).splashPlayCardTKInfo.templateId;
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c
    /* renamed from: lJ */
    protected final int mo30759lJ() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C8489h c8489h = this.f27734Dg;
        return (int) (C10484b.m25713de(c8489h.mAdTemplate) - (elapsedRealtime - c8489h.f27868CA));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27719ld = (FrameLayout) findViewById(C9659R.C9662id.splash_full_tk_play_card_view);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        C9109aw c9109aw = this.f27720wz;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27720wz.m29265su();
        }
        super.onUnbind();
        this.f27734Dg.f27881Cs.mo26186b(this);
        this.f27734Dg.m30621b(this.f27716ER);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        C9109aw c9109aw = this.f27720wz;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27720wz.m29265su();
        }
        this.f27719ld.setVisibility(8);
        m30763lL();
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        c9044a.width = C10751a.px2dip(getContext(), this.f27734Dg.mRootContainer.getWidth());
        c9044a.height = C10751a.px2dip(getContext(), this.f27734Dg.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28990a(C9109aw c9109aw) {
        super.mo28990a(c9109aw);
        this.f27720wz = c9109aw;
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        super.mo28983a(interfaceC9876q, c10605b);
        interfaceC9876q.mo27480c(m30776a(c10605b));
        interfaceC9876q.mo27480c(m30764lK());
        interfaceC9876q.mo27480c(m30762lM());
    }

    @NonNull
    /* renamed from: a */
    private C9185x m30776a(C10605b c10605b) {
        return new C9185x(c10605b, this.f27734Dg.mApkDownloadHelper, new InterfaceC10635a() { // from class: com.kwad.components.ad.splashscreen.c.c.a.1
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
            /* renamed from: a */
            public final void mo25245a(C10640a c10640a) {
                if (c10640a != null) {
                    C8407a.this.f27734Dg.mRootContainer.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.c.a.1.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C8407a.this.f27734Dg.m30615kB();
                        }
                    });
                }
            }
        });
    }
}
