package com.kwad.components.p208ad.reward.presenter.p265a;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.tachikoma.C9305i;
import com.kwad.components.core.webview.tachikoma.InterfaceC9339j;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p251d.C7874a;
import com.kwad.components.p208ad.reward.p258k.C7992q;
import com.kwad.components.p208ad.reward.presenter.p272f.AbstractC8188g;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.utils.C11067bq;
import com.kwad.sdk.widget.InterfaceC11147e;

/* renamed from: com.kwad.components.ad.reward.presenter.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8090a extends AbstractC8188g implements InterfaceC9339j {

    /* renamed from: gj */
    private C9305i f26948gj;
    private AdInfo mAdInfo;

    /* renamed from: tH */
    private long f26949tH;

    /* renamed from: tI */
    private long f26950tI;

    /* renamed from: tJ */
    private boolean f26951tJ;

    /* renamed from: tK */
    private boolean f26952tK;

    /* renamed from: tL */
    private C7907g.InterfaceC7921b f26953tL = new C7907g.InterfaceC7921b() { // from class: com.kwad.components.ad.reward.presenter.a.a.1
        @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7921b
        public final boolean interceptPlayCardResume() {
            return C8090a.this.f27116wD != null && C8090a.this.f27116wD.getVisibility() == 0;
        }
    };

    /* renamed from: gO */
    private final C9002l f26947gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.a.a.2
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            long m32055a = C7907g.m32055a(j, C8090a.this.mAdInfo);
            if (j2 <= C8090a.this.f26949tH || m32055a - j2 <= C8090a.this.f26950tI || C8090a.this.f26951tJ) {
                return;
            }
            C8090a.m31625a(C8090a.this, true);
            C8090a.this.f26948gj.mo29075a(C8090a.this.f26957qo.getActivity(), C8090a.this.f26957qo.mAdResultData, C8090a.this);
        }
    };

    /* renamed from: hN */
    private C9305i m31617hN() {
        return new C9305i(-1L, getContext());
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28990a(C9109aw c9109aw) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28988a(C9216o c9216o) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28987a(C9218p c9218p) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28986a(C9252m c9252m) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28985a(C9259t c9259t) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28982a(@Nullable C10640a c10640a) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        if (this.f26948gj == null) {
            this.f26948gj = m31617hN();
        }
        AdInfo m25641dQ = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
        this.mAdInfo = m25641dQ;
        this.f26949tH = C10483a.m25952aJ(m25641dQ) * 1000;
        this.f26950tI = C10483a.m25951aK(this.mAdInfo) * 1000;
        this.f26957qo.f26529oJ.m31828a(this.f26947gO);
        this.f26957qo.m32048a(this.f26953tL);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        C10331c.m26254d("TkRewardInteractPresenter", "onTkLoadSuccess: ");
        getContext();
        if (C11015ai.m24123LZ()) {
            this.f27116wD.setVisibility(0);
            C7874a.m32113N(this.f26957qo.mContext);
            this.f26957qo.f26529oJ.pause();
            this.f26952tK = true;
        }
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bG */
    public final void mo28979bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_reward_interact_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25675dx(this.f26957qo.mAdTemplate);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final InterfaceC11147e getTouchCoordsView() {
        return this.f26957qo.mRootContainer;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractC8188g
    /* renamed from: hM */
    public final int mo31278hM() {
        return C9659R.C9662id.ksad_js_interact;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31826b(this.f26947gO);
        this.f26957qo.m32032b(this.f26953tL);
        this.f26948gj.mo29029jp();
        this.f26948gj = null;
        this.f27116wD.setVisibility(8);
        this.f26951tJ = false;
        this.f26952tK = false;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m31625a(C8090a c8090a, boolean z) {
        c8090a.f26951tJ = true;
        return true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        float m24919aJ = C10751a.m24919aJ(getContext());
        c9044a.width = (int) ((C11059bi.getScreenWidth(getContext()) / m24919aJ) + 0.5f);
        c9044a.height = (int) ((C11059bi.getScreenHeight(getContext()) / m24919aJ) + 0.5f);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        C10331c.m26254d("TkRewardInteractPresenter", "onTkLoadFailed: ");
        this.f27116wD.setVisibility(8);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        C7907g c7907g = this.f26957qo;
        interfaceC9876q.mo27480c(new C7992q(c10605b, c7907g.mApkDownloadHelper, c7907g, -1L, new InterfaceC10635a() { // from class: com.kwad.components.ad.reward.presenter.a.a.3
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
            /* renamed from: a */
            public final void mo25245a(@Nullable C10640a c10640a) {
                if (C8090a.this.f26957qo.f26528oI != null) {
                    C8090a.this.f26957qo.f26528oI.mo32088bJ();
                }
            }
        }, null));
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28984a(WebCloseStatus webCloseStatus) {
        C7907g c7907g = this.f26957qo;
        boolean z = webCloseStatus != null && webCloseStatus.interactSuccess;
        c7907g.f26553pb = z;
        if (z) {
            c7907g.f26529oJ.m31823jJ();
        }
        if (this.f26952tK && C11067bq.m23850o(this.f27116wD, 30)) {
            this.f26957qo.f26529oJ.resume();
        }
        this.f27116wD.setVisibility(8);
    }
}
