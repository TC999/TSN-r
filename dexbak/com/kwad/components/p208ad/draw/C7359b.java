package com.kwad.components.p208ad.draw;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.components.p208ad.draw.p214a.C7358b;
import com.kwad.components.p208ad.draw.p215b.C7363a;
import com.kwad.components.p208ad.draw.p215b.C7367b;
import com.kwad.components.p208ad.draw.p215b.C7394d;
import com.kwad.components.p208ad.draw.p215b.View$OnClickListenerC7386c;
import com.kwad.components.p208ad.draw.p215b.p216a.C7364a;
import com.kwad.components.p208ad.draw.p215b.p217b.C7370a;
import com.kwad.components.p208ad.draw.p215b.p217b.C7373b;
import com.kwad.components.p208ad.draw.p215b.p217b.C7377c;
import com.kwad.components.p208ad.draw.p215b.p218c.C7390a;
import com.kwad.components.p208ad.draw.p215b.p218c.C7392b;
import com.kwad.components.p208ad.draw.p219c.C7399a;
import com.kwad.components.p208ad.p247k.C7824b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p403h.AbstractC10384b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.draw.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7359b extends KSFrameLayout {
    @Nullable

    /* renamed from: bN */
    private KsDrawAd.AdInteractionListener f25278bN;

    /* renamed from: bO */
    private C7358b f25279bO;

    /* renamed from: bP */
    private C7399a f25280bP;

    /* renamed from: bQ */
    private C9366b f25281bQ;

    /* renamed from: bR */
    private boolean f25282bR;

    /* renamed from: bS */
    private ImageView f25283bS;

    /* renamed from: bT */
    private AbstractC10384b f25284bT;

    /* renamed from: bU */
    private View.OnClickListener f25285bU;

    /* renamed from: bV */
    private InterfaceC9001k f25286bV;
    private AdInfo mAdInfo;
    @NonNull
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private Presenter mPresenter;
    private AdBaseFrameLayout mRootContainer;

    public C7359b(@NonNull Context context) {
        super(context);
        this.f25285bU = new View.OnClickListener() { // from class: com.kwad.components.ad.draw.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8615a.m30233a(new C8615a.C8616a(C7359b.this.f25279bO.mRootContainer.getContext()).m30198aq(C7359b.this.f25279bO.mAdTemplate).m30189b(C7359b.this.f25279bO.mApkDownloadHelper).m30202ao(false).m30205an(3).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.draw.b.1.1
                    @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                    public final void onAdClicked() {
                    }
                }));
                if (3 == C10483a.m25858bv(C10487e.m25641dQ(C7359b.this.f25279bO.mAdTemplate))) {
                    C7359b.this.m33438ab();
                }
            }
        };
        this.f25286bV = new C9002l() { // from class: com.kwad.components.ad.draw.b.2
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                C7359b.this.f25283bS.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                C7359b.this.f25283bS.setVisibility(8);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                C7359b.this.f25283bS.setVisibility(8);
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ab */
    public void m33438ab() {
        this.f25280bP.m33339f(!this.f25282bR);
        if (!this.f25282bR) {
            this.f25280bP.pause();
        } else {
            this.f25280bP.resume();
        }
        this.f25282bR = !this.f25282bR;
    }

    /* renamed from: ae */
    private C7358b m33437ae() {
        C7358b c7358b = new C7358b();
        c7358b.f25274bN = this.f25278bN;
        c7358b.mRootContainer = this.mRootContainer;
        c7358b.mAdTemplate = this.mAdTemplate;
        if (C10483a.m25956aF(this.mAdInfo)) {
            c7358b.mApkDownloadHelper = new C8619c(this.mAdTemplate);
        }
        c7358b.f25275bP = this.f25280bP;
        c7358b.f25276ch = new C7370a(this.mAdTemplate);
        if (C10484b.m25742cz(this.mAdTemplate)) {
            c7358b.f25277ci = new C7824b();
        }
        return c7358b;
    }

    /* renamed from: af */
    private Presenter m33436af() {
        Presenter presenter = new Presenter();
        presenter.m24612a(new C7364a());
        presenter.m24612a(new C7367b());
        presenter.m24612a(new C7394d());
        presenter.m24612a(new View$OnClickListenerC7386c());
        presenter.m24612a(new C7373b());
        if (C10484b.m25755cm(this.mAdTemplate)) {
            presenter.m24612a(new C7377c());
        }
        presenter.m24612a(new C7390a());
        if (C10484b.m25742cz(this.mAdTemplate)) {
            presenter.m24612a(new C7392b());
        }
        if (C10483a.m25946aP(this.mAdInfo)) {
            presenter.m24612a(new C7363a());
        }
        return presenter;
    }

    private void initView() {
        C10887l.inflate(this.mContext, C9659R.C9663layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        this.f25283bS = (ImageView) adBaseFrameLayout.findViewById(C9659R.C9662id.ksad_video_control_button);
        DetailVideoView detailVideoView = (DetailVideoView) this.mRootContainer.findViewById(C9659R.C9662id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.m29516g(true, C10251d.m26559CC());
        this.mDetailVideoView.setOnClickListener(this.f25285bU);
        this.f25283bS.setOnClickListener(this.f25285bU);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public final void mo23565ac() {
        super.mo23565ac();
        this.f25279bO = m33437ae();
        Presenter m33436af = m33436af();
        this.mPresenter = m33436af;
        m33436af.m24616G(this.mRootContainer);
        this.mPresenter.m24605k(this.f25279bO);
        this.f25281bQ.mo26187a(this.f25284bT);
        this.f25281bQ.m28900tw();
        this.f25280bP.m33346aJ();
        this.f25280bP.mo31843b(this.f25286bV);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        C9366b c9366b = this.f25281bQ;
        if (c9366b != null) {
            c9366b.release();
        }
        C7399a c7399a = this.f25280bP;
        if (c7399a != null) {
            c7399a.m33345aK();
            this.f25280bP.mo31844a(this.f25286bV);
        }
        C7358b c7358b = this.f25279bO;
        if (c7358b != null) {
            c7358b.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f25278bN = adInteractionListener;
    }

    public final void setPageExitListener(AbstractC10384b abstractC10384b) {
        this.f25284bT = abstractC10384b;
    }

    /* renamed from: a */
    public final void m33439a(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        C9366b c9366b = new C9366b(this, 70);
        this.f25281bQ = c9366b;
        this.f25280bP = new C7399a(this.mAdTemplate, c9366b, this.mDetailVideoView);
    }
}
