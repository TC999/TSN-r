package com.kwad.components.p208ad.interstitial.p242e;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.View$OnClickListenerC8966a;
import com.kwad.components.p208ad.interstitial.p239b.C7721b;
import com.kwad.components.p208ad.interstitial.p245g.C7798d;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.video.videoview.TextureView$SurfaceTextureListenerC10537a;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.interstitial.e.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7781e extends C7760b implements View$OnClickListenerC8966a.InterfaceC8970c {

    /* renamed from: kD */
    private static long f26264kD = 1000;

    /* renamed from: jK */
    private C7761c f26265jK;
    @Nullable

    /* renamed from: kE */
    private RunnableC7782a f26266kE;

    /* renamed from: kF */
    private int f26267kF;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m32409D(int i) {
        C7761c c7761c = this.f26265jK;
        C7798d c7798d = c7761c.f26203jL;
        if (c7798d == null) {
            return;
        }
        if (i == 0) {
            if (c7761c.m32447cT()) {
                return;
            }
            this.f26265jK.m32455b(getContext(), this.mAdTemplate);
            m32404dt();
            C7761c c7761c2 = this.f26265jK;
            c7761c2.m32457a(true, -1, c7761c2.f26198eN);
            return;
        }
        c7798d.m32344b(true, i);
    }

    /* renamed from: dt */
    private void m32404dt() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f26265jK.f26198eN;
        if (textureView$SurfaceTextureListenerC10537a != null) {
            textureView$SurfaceTextureListenerC10537a.release();
        }
        this.f26265jK.f26202io.dismiss();
        C7761c c7761c = this.f26265jK;
        if (c7761c.f26206jO || (adInteractionListener = c7761c.f26201ie) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.C7760b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C10331c.m26254d("InterstitialPlayablePresenter", this + " onBind");
        C7761c c7761c = (C7761c) m24613Jx();
        this.f26265jK = c7761c;
        AdTemplate adTemplate = c7761c.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        long j = m25641dQ.adInsertScreenInfo.autoCloseTime;
        if (j > 0) {
            this.f26267kF = (int) Math.min(C7721b.m32576b(m25641dQ), j);
        } else {
            this.f26267kF = C7721b.m32576b(m25641dQ);
        }
        C7798d c7798d = this.f26265jK.f26203jL;
        if (c7798d != null) {
            c7798d.m32344b(true, this.f26267kF);
        }
        if (C10483a.m25877bc(m25641dQ)) {
            this.f26266kE = null;
            this.f26265jK.m32459a(this);
            return;
        }
        RunnableC7782a runnableC7782a = new RunnableC7782a(this, (byte) 0);
        this.f26266kE = runnableC7782a;
        C11064bn.m23862a(runnableC7782a, null, 1000L);
    }

    @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
    /* renamed from: bl */
    public final void mo28935bl() {
    }

    @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
    /* renamed from: bm */
    public final void mo28934bm() {
        if (this.f26265jK.m32447cT()) {
            return;
        }
        this.f26265jK.m32455b(getContext(), this.mAdTemplate);
        m32404dt();
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.C7760b
    /* renamed from: cP */
    public final void mo32406cP() {
        super.mo32406cP();
        RunnableC7782a runnableC7782a = this.f26266kE;
        if (runnableC7782a != null) {
            runnableC7782a.m32401r(false);
        }
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.C7760b
    /* renamed from: cQ */
    public final void mo32405cQ() {
        super.mo32405cQ();
        RunnableC7782a runnableC7782a = this.f26266kE;
        if (runnableC7782a != null) {
            runnableC7782a.m32401r(true);
        }
    }

    @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
    /* renamed from: e */
    public final void mo28933e(long j) {
        m32409D(this.f26267kF - ((int) (j / 1000)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C10331c.m26254d("InterstitialPlayablePresenter", this + " onUnbind");
        this.f26265jK.m32452b(this);
        RunnableC7782a runnableC7782a = this.f26266kE;
        if (runnableC7782a != null) {
            runnableC7782a.m32402q(true);
            C11064bn.m23858c(this.f26266kE);
            this.f26266kE = null;
        }
    }

    @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
    public final void onVideoPlayStart() {
    }

    /* renamed from: com.kwad.components.ad.interstitial.e.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class RunnableC7782a implements Runnable {

        /* renamed from: kG */
        private int f26268kG;

        /* renamed from: kH */
        private boolean f26269kH;

        /* renamed from: kI */
        private boolean f26270kI;

        private RunnableC7782a() {
            this.f26268kG = Integer.MIN_VALUE;
            this.f26269kH = false;
            this.f26270kI = false;
        }

        /* renamed from: q */
        public final void m32402q(boolean z) {
            this.f26270kI = true;
        }

        /* renamed from: r */
        public final void m32401r(boolean z) {
            this.f26269kH = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f26270kI) {
                return;
            }
            if (this.f26269kH) {
                C11064bn.m23862a(this, null, C7781e.f26264kD);
                return;
            }
            if (this.f26268kG == Integer.MIN_VALUE) {
                this.f26268kG = C7781e.this.f26267kF;
            }
            if (this.f26268kG < 0) {
                return;
            }
            C10331c.m26254d("InterstitialPlayablePresenter", C7781e.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.f26268kG);
            C7781e.this.m32409D(this.f26268kG);
            this.f26268kG = this.f26268kG + (-1);
            C11064bn.m23862a(this, null, C7781e.f26264kD);
        }

        /* synthetic */ RunnableC7782a(C7781e c7781e, byte b) {
            this();
        }
    }
}
