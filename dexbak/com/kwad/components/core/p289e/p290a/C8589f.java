package com.kwad.components.core.p289e.p290a;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.tachikoma.C9305i;
import com.kwad.components.core.webview.tachikoma.InterfaceC9339j;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.widget.InterfaceC11147e;

/* renamed from: com.kwad.components.core.e.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8589f extends Presenter implements InterfaceC9339j, InterfaceC10385c {

    /* renamed from: JI */
    private C9366b f28152JI;

    /* renamed from: JS */
    private C8579a f28153JS;

    /* renamed from: cQ */
    private C9109aw f28154cQ;

    /* renamed from: gj */
    private C9305i f28155gj;
    private AdTemplate mAdTemplate;

    /* renamed from: ai */
    private void m30298ai(boolean z) {
        if (!z) {
            this.f28153JS.m30322nc();
        }
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.e.a.f.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8589f.this.f28153JS.f28138JJ.mo30289ne();
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28991a(C9031a.C9033a c9033a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28988a(C9216o c9216o) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28987a(C9218p c9218p) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28986a(C9252m c9252m) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28985a(C9259t c9259t) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        C10331c.m26254d("InstalledActivatePresenter", "onPageVisible");
        C9109aw c9109aw = this.f28154cQ;
        if (c9109aw != null) {
            c9109aw.m29264sv();
        }
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        C10331c.m26254d("InstalledActivatePresenter", "onPageInvisible");
        C9109aw c9109aw = this.f28154cQ;
        if (c9109aw != null) {
            c9109aw.m29263sw();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C8579a c8579a = (C8579a) m24613Jx();
        this.f28153JS = c8579a;
        this.mAdTemplate = c8579a.mAdTemplate;
        this.f28152JI = c8579a.f28137JI;
        this.f28155gj = new C9305i(getContext()) { // from class: com.kwad.components.core.e.a.f.1
            @Override // com.kwad.components.core.webview.tachikoma.C9305i
            /* renamed from: nk */
            public final boolean mo29024nk() {
                return true;
            }
        };
        this.f28155gj.mo29075a((Activity) null, C10485c.m25662dB(this.mAdTemplate), this);
        this.f28152JI.mo26187a(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        float m24919aJ = C10751a.m24919aJ(getContext());
        c9044a.width = (int) ((C10751a.getScreenWidth(getContext()) / m24919aJ) + 0.5f);
        c9044a.height = (int) ((C10751a.getScreenHeight(getContext()) / m24919aJ) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        C10331c.m26254d("InstalledActivatePresenter", "onTkLoadSuccess");
        this.f28153JS.m30323bv();
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bG */
    public final void mo28979bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final FrameLayout getTKContainer() {
        return this.f28153JS.f28136JH;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_installed_activate";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25763ce(this.mAdTemplate).installedActivateInfo.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final InterfaceC11147e getTouchCoordsView() {
        return this.f28153JS.f28136JH;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f28155gj.mo29029jp();
        this.f28152JI.mo26186b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        C10331c.m26254d("InstalledActivatePresenter", "onTkLoadFailed");
        m30298ai(true);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28982a(@Nullable C10640a c10640a) {
        C10331c.m26254d("InstalledActivatePresenter", "onAdClicked");
        m30298ai(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28984a(WebCloseStatus webCloseStatus) {
        m30298ai(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28990a(C9109aw c9109aw) {
        this.f28154cQ = c9109aw;
        this.f28153JS.f28139cQ = c9109aw;
    }
}
