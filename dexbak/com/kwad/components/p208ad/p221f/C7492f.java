package com.kwad.components.p208ad.p221f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.components.p208ad.p221f.DialogInterface$OnDismissListenerC7465d;
import com.kwad.components.p208ad.p221f.p222a.C7417b;
import com.kwad.components.p208ad.p221f.p223b.C7426b;
import com.kwad.components.p208ad.p221f.p223b.C7429c;
import com.kwad.components.p208ad.p221f.p223b.C7431d;
import com.kwad.components.p208ad.p221f.p223b.C7433e;
import com.kwad.components.p208ad.p221f.p223b.C7439g;
import com.kwad.components.p208ad.p221f.p223b.C7447j;
import com.kwad.components.p208ad.p221f.p223b.C7449k;
import com.kwad.components.p208ad.p221f.p223b.View$OnClickListenerC7424a;
import com.kwad.components.p208ad.p221f.p223b.View$OnClickListenerC7435f;
import com.kwad.components.p208ad.p221f.p223b.View$OnClickListenerC7441h;
import com.kwad.components.p208ad.p221f.p223b.View$OnClickListenerC7444i;
import com.kwad.components.p208ad.p221f.p224c.C7459a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.C11103l;
import com.kwad.sdk.widget.InterfaceC11154j;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.f.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7492f extends KSFrameLayout {

    /* renamed from: bQ */
    private C9366b f25581bQ;

    /* renamed from: cD */
    private InterfaceC11154j f25582cD;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;

    /* renamed from: mI */
    private AdBasePvFrameLayout f25583mI;

    /* renamed from: mN */
    private C7417b f25584mN;

    /* renamed from: mO */
    public C7459a f25585mO;

    /* renamed from: mP */
    private KsAdVideoPlayConfig f25586mP;
    private Presenter mPresenter;

    /* renamed from: mr */
    private KsNativeAd.VideoPlayListener f25587mr;

    /* renamed from: mw */
    private DialogInterface$OnDismissListenerC7465d.InterfaceC7476a f25588mw;

    public C7492f(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: B */
    private void m33153B(Context context) {
        C10887l.inflate(context, C9659R.C9663layout.ksad_native_video_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
        this.f25583mI = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(C9659R.C9662id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    /* renamed from: af */
    private Presenter m33150af() {
        Presenter presenter = new Presenter();
        presenter.m24612a(new C7433e());
        presenter.m24612a(new C7429c());
        presenter.m24612a(new View$OnClickListenerC7444i());
        presenter.m24612a(new C7447j());
        presenter.m24612a(new C7431d());
        presenter.m24612a(new C7426b());
        presenter.m24612a(new C7449k());
        presenter.m24612a(new View$OnClickListenerC7424a(this.f25586mP));
        presenter.m24612a(new C7439g());
        if (C10483a.m25956aF(C10487e.m25641dQ(this.mAdTemplate))) {
            presenter.m24612a(new View$OnClickListenerC7435f());
        } else {
            presenter.m24612a(new View$OnClickListenerC7441h());
        }
        return presenter;
    }

    /* renamed from: eu */
    private C7417b m33149eu() {
        C7417b c7417b = new C7417b();
        c7417b.f25417mI = this.f25583mI;
        AdTemplate adTemplate = this.mAdTemplate;
        c7417b.mAdTemplate = adTemplate;
        c7417b.f25420mw = this.f25588mw;
        c7417b.f25419mr = this.f25587mr;
        if (C10483a.m25956aF(C10487e.m25641dQ(adTemplate))) {
            C8619c c8619c = this.mApkDownloadHelper;
            if (c8619c == null) {
                c7417b.mApkDownloadHelper = new C8619c(this.mAdTemplate);
            } else {
                c8619c.m30143nU();
                c7417b.mApkDownloadHelper = this.mApkDownloadHelper;
            }
        }
        c7417b.f25418mO = this.f25585mO;
        return c7417b;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public final void mo23565ac() {
        super.mo23565ac();
        if (this.f25585mO == null) {
            this.f25585mO = new C7459a(this.mAdTemplate, this.f25581bQ, this.mDetailVideoView, this.f25586mP);
        }
        this.f25584mN = m33149eu();
        Presenter m33150af = m33150af();
        this.mPresenter = m33150af;
        m33150af.m24616G(this.f25583mI);
        this.mPresenter.m24605k(this.f25584mN);
        this.f25581bQ.m28900tw();
        this.f25585mO.m33248aJ();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        C9366b c9366b = this.f25581bQ;
        if (c9366b != null) {
            c9366b.release();
        }
        C7459a c7459a = this.f25585mO;
        if (c7459a != null) {
            c7459a.m33247aK();
        }
        C7417b c7417b = this.f25584mN;
        if (c7417b != null) {
            c7417b.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void setInnerAdInteractionListener(DialogInterface$OnDismissListenerC7465d.InterfaceC7476a interfaceC7476a) {
        this.f25588mw = interfaceC7476a;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f25587mr = videoPlayListener;
    }

    private C7492f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    /* renamed from: a */
    public final void m33151a(@NonNull AdTemplate adTemplate, @Nullable C8619c c8619c, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = c8619c;
        this.f25586mP = ksAdVideoPlayConfig;
        this.f25583mI.setVisibleListener(this.f25582cD);
        this.f25581bQ = new C9366b(getParent() == null ? this : (View) getParent(), 30);
    }

    private C7492f(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.f25582cD = new InterfaceC11154j() { // from class: com.kwad.components.ad.f.f.1
            @Override // com.kwad.sdk.widget.InterfaceC11154j
            /* renamed from: ao */
            public final void mo23526ao() {
                C11103l.m23773el(C7492f.this.mAdTemplate);
            }
        };
        m33153B(context);
    }
}
