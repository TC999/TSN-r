package com.kwad.components.ad.reward.presenter.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bq;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends g implements j {
    private i gj;
    private AdInfo mAdInfo;
    private long tH;
    private long tI;
    private boolean tJ;
    private boolean tK;
    private g.b tL = new g.b() { // from class: com.kwad.components.ad.reward.presenter.a.a.1
        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.wD != null && a.this.wD.getVisibility() == 0;
        }
    };
    private final l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.a.a.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            super.onMediaPlayProgress(j4, j5);
            long a4 = com.kwad.components.ad.reward.g.a(j4, a.this.mAdInfo);
            if (j5 <= a.this.tH || a4 - j5 <= a.this.tI || a.this.tJ) {
                return;
            }
            a.a(a.this, true);
            a.this.gj.a(a.this.qo.getActivity(), a.this.qo.mAdResultData, a.this);
        }
    };

    private i hN() {
        return new i(-1L, getContext());
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.gj == null) {
            this.gj = hN();
        }
        AdInfo dQ = e.dQ(this.qo.mAdTemplate);
        this.mAdInfo = dQ;
        this.tH = com.kwad.sdk.core.response.b.a.aJ(dQ) * 1000;
        this.tI = com.kwad.sdk.core.response.b.a.aK(this.mAdInfo) * 1000;
        this.qo.oJ.a(this.gO);
        this.qo.a(this.tL);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        c.d("TkRewardInteractPresenter", "onTkLoadSuccess: ");
        getContext();
        if (ai.LZ()) {
            this.wD.setVisibility(0);
            com.kwad.components.ad.reward.d.a.N(this.qo.mContext);
            this.qo.oJ.pause();
            this.tK = true;
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_interact_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.dx(this.qo.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.qo.mRootContainer;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int hM() {
        return R.id.ksad_js_interact;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.gO);
        this.qo.b(this.tL);
        this.gj.jp();
        this.gj = null;
        this.wD.setVisibility(8);
        this.tJ = false;
        this.tK = false;
    }

    static /* synthetic */ boolean a(a aVar, boolean z3) {
        aVar.tJ = true;
        return true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aJ = com.kwad.sdk.d.a.a.aJ(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aJ) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aJ) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        c.d("TkRewardInteractPresenter", "onTkLoadFailed: ");
        this.wD.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        com.kwad.components.ad.reward.g gVar = this.qo;
        qVar.c(new com.kwad.components.ad.reward.k.q(bVar, gVar.mApkDownloadHelper, gVar, -1L, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.a.a.3
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                if (a.this.qo.oI != null) {
                    a.this.qo.oI.bJ();
                }
            }
        }, null));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        com.kwad.components.ad.reward.g gVar = this.qo;
        boolean z3 = webCloseStatus != null && webCloseStatus.interactSuccess;
        gVar.pb = z3;
        if (z3) {
            gVar.oJ.jJ();
        }
        if (this.tK && bq.o(this.wD, 30)) {
            this.qo.oJ.resume();
        }
        this.wD.setVisibility(8);
    }
}
