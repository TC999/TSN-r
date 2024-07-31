package com.kwad.components.p208ad.splashscreen.p278c.p279a;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.p208ad.splashscreen.monitor.C8495a;
import com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11063bm;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.c.a.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8380g extends AbstractC8418c implements InterfaceC10385c {

    /* renamed from: ld */
    private FrameLayout f27671ld;

    /* renamed from: wz */
    private C9109aw f27672wz;

    /* renamed from: Z */
    private void m30857Z(int i) {
        C9893a.C9894a c9894a = new C9893a.C9894a();
        C11063bm c11063bm = this.f27734Dg.mTimerHelper;
        if (c11063bm != null) {
            c9894a.duration = c11063bm.getTime();
        }
        C9913b m27268b = new C9913b().m27257cT(6).m27268b(c9894a);
        if (i == 2) {
            m27268b.m27265cL(14);
        } else {
            m27268b.m27265cL(1);
        }
        C9908c.m27334b(this.f27734Dg.mAdTemplate, m27268b, (JSONObject) null);
    }

    /* renamed from: lE */
    private void m30853lE() {
        this.f27734Dg.mRootContainer.findViewById(C9659R.C9662id.splash_play_card_view).setVisibility(8);
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        C9109aw c9109aw = this.f27672wz;
        if (c9109aw != null) {
            c9109aw.m29264sv();
        }
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        C9109aw c9109aw = this.f27672wz;
        if (c9109aw != null) {
            c9109aw.m29263sw();
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27734Dg.f27881Cs.mo26187a(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        C9109aw c9109aw = this.f27672wz;
        if (c9109aw != null) {
            c9109aw.m29268sr();
            this.f27672wz.m29267ss();
        }
        m30853lE();
        this.f27671ld.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final FrameLayout getTKContainer() {
        return this.f27671ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_splash_end_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25685ds(this.f27734Dg.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27671ld = (FrameLayout) findViewById(C9659R.C9662id.splash_end_card_view);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        C9109aw c9109aw = this.f27672wz;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27672wz.m29265su();
        }
        super.onUnbind();
        this.f27734Dg.f27881Cs.mo26186b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        C9109aw c9109aw = this.f27672wz;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27672wz.m29265su();
        }
        m30853lE();
        this.f27671ld.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        c9044a.width = C10751a.px2dip(getContext(), this.f27734Dg.mRootContainer.getWidth());
        c9044a.height = C10751a.px2dip(getContext(), this.f27734Dg.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28984a(WebCloseStatus webCloseStatus) {
        super.mo28984a(webCloseStatus);
        m30857Z(webCloseStatus.closeType);
        if (webCloseStatus.closeType == 2) {
            this.f27734Dg.m30598kS();
            return;
        }
        C8495a.m30585kT().m30584l(this.f27734Dg.mAdTemplate);
        this.f27734Dg.m30602kO();
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28990a(C9109aw c9109aw) {
        super.mo28990a(c9109aw);
        this.f27672wz = c9109aw;
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.p281c.AbstractC8418c, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        super.mo28983a(interfaceC9876q, c10605b);
        interfaceC9876q.mo27480c(m30855a(c10605b));
    }

    @NonNull
    /* renamed from: a */
    private C9185x m30855a(C10605b c10605b) {
        return new C9185x(c10605b, this.f27734Dg.mApkDownloadHelper, new InterfaceC10635a() { // from class: com.kwad.components.ad.splashscreen.c.a.g.1
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
            /* renamed from: a */
            public final void mo25245a(C10640a c10640a) {
                if (c10640a != null) {
                    C8380g.this.f27734Dg.mRootContainer.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.a.g.1.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C8380g.this.f27734Dg.m30615kB();
                        }
                    });
                }
            }
        });
    }
}
