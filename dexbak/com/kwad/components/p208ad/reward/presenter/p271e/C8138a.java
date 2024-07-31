package com.kwad.components.p208ad.reward.presenter.p271e;

import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p258k.InterfaceC7958a;
import com.kwad.components.p208ad.reward.page.BackPressHandleResult;
import com.kwad.components.p208ad.reward.presenter.p272f.AbstractC8188g;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.reward.presenter.e.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8138a extends AbstractC8188g implements InterfaceC7958a {

    /* renamed from: vY */
    private AdMatrixInfo.PreLandingPageTKInfo f27038vY;

    /* renamed from: vZ */
    private C9109aw f27039vZ;

    /* renamed from: nX */
    private boolean f27037nX = false;

    /* renamed from: wa */
    private InterfaceC7886g f27040wa = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.e.a.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            C10331c.m26254d("TKPreFormPresenter", "handleToSkip PlayEndPageListener onPlayEndPageShow: " + C8138a.this.f26957qo.f26555pd);
            if (C8138a.this.f26957qo.f26555pd) {
                return;
            }
            C8138a.this.m31479iI();
        }
    };

    /* renamed from: S */
    private void m31487S(final boolean z) {
        C10331c.m26254d("TKPreFormPresenter", "switchPreForm: " + z);
        this.f27116wD.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.e.a.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8138a.this.f27116wD.setVisibility(z ? 0 : 4);
                C8138a.this.f27116wD.setClickable(z);
                if (C8138a.this.f27039vZ != null) {
                    if (z) {
                        C8138a.this.f27039vZ.m29268sr();
                        C8138a.this.f27039vZ.m29267ss();
                        return;
                    }
                    C8138a.this.f27039vZ.m29266st();
                    C8138a.this.f27039vZ.m29265su();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iI */
    public void m31479iI() {
        if (!this.f27037nX || this.f27038vY == null) {
            return;
        }
        C10331c.m26254d("TKPreFormPresenter", "handleToSkip handleToPlayEnd isPlayEndShow: " + this.f27038vY.isPlayEndShow());
        if (this.f27038vY.isPlayEndShow()) {
            m31487S(true);
        }
    }

    /* renamed from: iJ */
    private void m31478iJ() {
        if (!this.f27037nX || this.f27038vY == null) {
            return;
        }
        C10331c.m26254d("TKPreFormPresenter", "handleToSkip mPreLandingPageData isSkipShow: " + this.f27038vY.isSkipShow());
        if (this.f27038vY.isSkipShow()) {
            m31487S(true);
        }
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27038vY = C10484b.m25705di(this.f26957qo.mAdTemplate);
        this.f26957qo.m32034b(this.f27040wa);
        this.f26957qo.m32045a((InterfaceC7958a) this);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        super.mo28980bF();
        C10331c.m26254d("TKPreFormPresenter", "onTkLoadSuccess");
        this.f27037nX = true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_pre_landing_page";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25671dz(this.f26957qo.mAdTemplate);
    }

    /* renamed from: gn */
    public final BackPressHandleResult m31480gn() {
        KSFrameLayout kSFrameLayout;
        if (this.f27071wk != null && (kSFrameLayout = this.f27116wD) != null) {
            if (kSFrameLayout.getVisibility() == 0) {
                return this.f27071wk.m31915gn();
            }
            return BackPressHandleResult.NOT_HANDLED;
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractC8188g
    /* renamed from: hM */
    public final int mo31278hM() {
        return C9659R.C9662id.ksad_pre_form_card;
    }

    @Override // com.kwad.components.p208ad.reward.p258k.InterfaceC7958a
    /* renamed from: iK */
    public final void mo31477iK() {
        C10331c.m26254d("TKPreFormPresenter", "onPlayComplete: ");
        m31479iI();
    }

    @Override // com.kwad.components.p208ad.reward.p258k.InterfaceC7958a
    /* renamed from: iL */
    public final void mo31476iL() {
        C10331c.m26254d("TKPreFormPresenter", "onSkipClick: ");
        m31478iJ();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.m32024c(this.f27040wa);
        this.f26957qo.m32029b((InterfaceC7958a) this);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractC8188g
    /* renamed from: a */
    public final void mo31320a(FrameLayout frameLayout) {
        frameLayout.setVisibility(4);
        frameLayout.setClickable(false);
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
    public final void mo28990a(C9109aw c9109aw) {
        super.mo28990a(c9109aw);
        this.f27039vZ = c9109aw;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        super.mo28989a(tKRenderFailReason);
        this.f27037nX = false;
        C10331c.m26254d("TKPreFormPresenter", "onTkLoadFailed");
        m31487S(false);
    }
}
