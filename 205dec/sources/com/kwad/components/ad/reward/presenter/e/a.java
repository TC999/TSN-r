package com.kwad.components.ad.reward.presenter.e;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends g implements com.kwad.components.ad.reward.k.a {
    private AdMatrixInfo.PreLandingPageTKInfo vY;
    private aw vZ;
    private boolean nX = false;
    private com.kwad.components.ad.reward.e.g wa = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.e.a.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            c.d("TKPreFormPresenter", "handleToSkip PlayEndPageListener onPlayEndPageShow: " + a.this.qo.pd);
            if (a.this.qo.pd) {
                return;
            }
            a.this.iI();
        }
    };

    private void S(final boolean z3) {
        c.d("TKPreFormPresenter", "switchPreForm: " + z3);
        this.wD.post(new ay() { // from class: com.kwad.components.ad.reward.presenter.e.a.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.wD.setVisibility(z3 ? 0 : 4);
                a.this.wD.setClickable(z3);
                if (a.this.vZ != null) {
                    if (z3) {
                        a.this.vZ.sr();
                        a.this.vZ.ss();
                        return;
                    }
                    a.this.vZ.st();
                    a.this.vZ.su();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iI() {
        if (!this.nX || this.vY == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip handleToPlayEnd isPlayEndShow: " + this.vY.isPlayEndShow());
        if (this.vY.isPlayEndShow()) {
            S(true);
        }
    }

    private void iJ() {
        if (!this.nX || this.vY == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip mPreLandingPageData isSkipShow: " + this.vY.isSkipShow());
        if (this.vY.isSkipShow()) {
            S(true);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.vY = b.di(this.qo.mAdTemplate);
        this.qo.b(this.wa);
        this.qo.a((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        super.bF();
        c.d("TKPreFormPresenter", "onTkLoadSuccess");
        this.nX = true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_pre_landing_page";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.dz(this.qo.mAdTemplate);
    }

    public final BackPressHandleResult gn() {
        KSFrameLayout kSFrameLayout;
        if (this.wk != null && (kSFrameLayout = this.wD) != null) {
            if (kSFrameLayout.getVisibility() == 0) {
                return this.wk.gn();
            }
            return BackPressHandleResult.NOT_HANDLED;
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int hM() {
        return R.id.ksad_pre_form_card;
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void iK() {
        c.d("TKPreFormPresenter", "onPlayComplete: ");
        iI();
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void iL() {
        c.d("TKPreFormPresenter", "onSkipClick: ");
        iJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.c(this.wa);
        this.qo.b((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final void a(FrameLayout frameLayout) {
        frameLayout.setVisibility(4);
        frameLayout.setClickable(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aJ = com.kwad.sdk.d.a.a.aJ(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aJ) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aJ) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.vZ = awVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        this.nX = false;
        c.d("TKPreFormPresenter", "onTkLoadFailed");
        S(false);
    }
}
