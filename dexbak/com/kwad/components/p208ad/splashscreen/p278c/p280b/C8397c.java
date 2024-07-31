package com.kwad.components.p208ad.splashscreen.p278c.p280b;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9214m;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.InterfaceC8482f;
import com.kwad.components.p208ad.splashscreen.InterfaceC8488g;
import com.kwad.components.p208ad.splashscreen.monitor.C8497b;
import com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.splashscreen.c.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8397c extends AbstractC8418c implements InterfaceC8488g, InterfaceC10385c {

    /* renamed from: ER */
    InterfaceC8482f f27698ER = new InterfaceC8482f() { // from class: com.kwad.components.ad.splashscreen.c.b.c.2
        @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8482f
        /* renamed from: kw */
        public final void mo30643kw() {
            C8397c.this.f27700ld.setVisibility(8);
            if (C8397c.this.f27701wz != null) {
                C8397c.this.f27701wz.m29266st();
                C8397c.this.f27701wz.m29265su();
            }
        }
    };

    /* renamed from: Fc */
    private C9214m f27699Fc;

    /* renamed from: ld */
    private FrameLayout f27700ld;

    /* renamed from: wz */
    private C9109aw f27701wz;

    @NonNull
    /* renamed from: lK */
    private C9214m m30789lK() {
        C9214m c9214m = new C9214m();
        this.f27699Fc = c9214m;
        return c9214m;
    }

    @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8488g
    /* renamed from: W */
    public final void mo30629W(int i) {
        C9214m c9214m = this.f27699Fc;
        if (c9214m != null) {
            c9214m.m29181aT(i);
        }
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        C9109aw c9109aw;
        if (this.f27734Dg.f27888Cz || (c9109aw = this.f27701wz) == null) {
            return;
        }
        c9109aw.m29264sv();
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        C9109aw c9109aw;
        if (this.f27734Dg.f27888Cz || (c9109aw = this.f27701wz) == null) {
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
        this.f27734Dg.m30622a(this);
        this.f27734Dg.m30623a(this.f27698ER);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        if (this.f27734Dg.f27888Cz) {
            return;
        }
        C9109aw c9109aw = this.f27701wz;
        if (c9109aw != null) {
            c9109aw.m29268sr();
            this.f27701wz.m29267ss();
        }
        this.f27700ld.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final FrameLayout getTKContainer() {
        return this.f27700ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25687dr(this.f27734Dg.mAdTemplate);
    }

    @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8488g
    /* renamed from: kA */
    public final void mo30628kA() {
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c
    /* renamed from: lJ */
    public final int mo30759lJ() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C8489h c8489h = this.f27734Dg;
        return (int) (C10484b.m25700dl(C10487e.m25641dQ(c8489h.mAdTemplate)) - (elapsedRealtime - c8489h.f27868CA));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27700ld = (FrameLayout) findViewById(C9659R.C9662id.splash_tk_play_card_view);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        C9109aw c9109aw = this.f27701wz;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27701wz.m29265su();
        }
        super.onUnbind();
        this.f27734Dg.f27881Cs.mo26186b(this);
        this.f27734Dg.m30621b(this.f27698ER);
        this.f27734Dg.m30620b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        C9109aw c9109aw = this.f27701wz;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27701wz.m29265su();
        }
        this.f27700ld.setVisibility(8);
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
        this.f27701wz = c9109aw;
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        super.mo28983a(interfaceC9876q, c10605b);
        interfaceC9876q.mo27480c(m30793a(c10605b));
        interfaceC9876q.mo27480c(m30789lK());
    }

    @NonNull
    /* renamed from: a */
    private C9185x m30793a(C10605b c10605b) {
        return new C9185x(c10605b, this.f27734Dg.mApkDownloadHelper, new InterfaceC10635a() { // from class: com.kwad.components.ad.splashscreen.c.b.c.1
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
            /* renamed from: a */
            public final void mo25245a(C10640a c10640a) {
                if (c10640a != null) {
                    C8397c.this.f27734Dg.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C8397c.this.f27734Dg.m30615kB();
                        }
                    });
                }
            }
        });
    }
}
