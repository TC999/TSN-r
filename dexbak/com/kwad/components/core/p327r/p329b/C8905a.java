package com.kwad.components.core.p327r.p329b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.p301l.p302a.InterfaceC8689a;
import com.kwad.components.core.p327r.p328a.C8904b;
import com.kwad.components.core.proxy.AbstractC8886c;
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
import com.kwad.sdk.C9659R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9871l;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10631g;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.widget.InterfaceC11147e;

/* renamed from: com.kwad.components.core.r.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8905a extends Presenter implements InterfaceC9339j {

    /* renamed from: SK */
    private FrameLayout f28783SK;

    /* renamed from: SL */
    private C9109aw f28784SL;

    /* renamed from: SM */
    protected boolean f28785SM;

    /* renamed from: SN */
    protected C8904b f28786SN;

    /* renamed from: SO */
    private InterfaceC8689a f28787SO = new InterfaceC8689a() { // from class: com.kwad.components.core.r.b.a.1
        @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
        /* renamed from: c */
        public final void mo29623c(AbstractC8886c abstractC8886c) {
            C8905a.this.m29627qT();
        }

        @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
        /* renamed from: d */
        public final void mo29622d(AbstractC8886c abstractC8886c) {
            C8905a.this.m29626qU();
        }

        @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
        /* renamed from: fP */
        public final void mo29621fP() {
        }

        @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
        /* renamed from: fQ */
        public final void mo29620fQ() {
            C8905a.this.m29625qV();
        }
    };

    /* renamed from: gj */
    private C9305i f28788gj;

    /* renamed from: qS */
    private void m29628qS() {
        C9109aw c9109aw = this.f28784SL;
        if (c9109aw == null) {
            return;
        }
        if (!this.f28785SM) {
            c9109aw.m29268sr();
            this.f28784SL.m29267ss();
            this.f28785SM = true;
            return;
        }
        c9109aw.m29264sv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: qT */
    public void m29627qT() {
        m29628qS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: qU */
    public void m29626qU() {
        C9109aw c9109aw = this.f28784SL;
        if (c9109aw == null || !this.f28785SM) {
            return;
        }
        c9109aw.m29263sw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: qV */
    public void m29625qV() {
        C9109aw c9109aw = this.f28784SL;
        if (c9109aw == null || !this.f28785SM) {
            return;
        }
        c9109aw.m29266st();
        this.f28784SL.m29265su();
        InterfaceC9871l interfaceC9871l = this.f28786SN.f28781SD;
        if (interfaceC9871l != null) {
            interfaceC9871l.callbackDismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28991a(C9031a.C9033a c9033a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
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

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28982a(@Nullable C10640a c10640a) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f28786SN = (C8904b) m24613Jx();
        this.f28783SK = (FrameLayout) findViewById(C9659R.C9662id.ksad_js_container);
        C9305i c9305i = new C9305i(getContext(), 1000, 0);
        this.f28788gj = c9305i;
        c9305i.m29060a(this.f28786SN.f28780SA);
        InterfaceC9871l interfaceC9871l = this.f28786SN.f28781SD;
        if (interfaceC9871l != null) {
            interfaceC9871l.mo27489a(this.f28788gj);
            this.f28788gj.m29055a(new InterfaceC10631g() { // from class: com.kwad.components.core.r.b.a.2
                @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10631g
                public final void callTKBridge(String str) {
                    InterfaceC9871l interfaceC9871l2 = C8905a.this.f28786SN.f28781SD;
                    if (interfaceC9871l2 != null) {
                        interfaceC9871l2.callTKBridge(str);
                    }
                }
            });
            this.f28788gj.m29054a("hasTKBridge", Boolean.TRUE);
        }
        this.f28788gj.mo29075a(getActivity(), this.f28786SN.mAdResultData, this);
        this.f28786SN.f28358Ms.add(this.f28787SO);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        m29628qS();
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bG */
    public final void mo28979bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final FrameLayout getTKContainer() {
        return this.f28783SK;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_activity";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return this.f28786SN.f28780SA.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final InterfaceC11147e getTouchCoordsView() {
        return this.f28786SN.mRootContainer;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        m29625qV();
        this.f28788gj.mo29029jp();
        this.f28786SN.f28358Ms.remove(this.f28787SO);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28984a(WebCloseStatus webCloseStatus) {
        getActivity().finish();
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
    public final void mo28990a(C9109aw c9109aw) {
        this.f28784SL = c9109aw;
    }
}
