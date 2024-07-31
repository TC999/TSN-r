package com.kwad.components.core.p289e.p290a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.kwad.components.core.e.a.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8592g extends KSFrameLayout {

    /* renamed from: JJ */
    private final InterfaceC8582d f28158JJ;

    /* renamed from: JS */
    private C8579a f28159JS;

    /* renamed from: JU */
    private final InterfaceC8582d f28160JU;

    /* renamed from: bQ */
    private final C9366b f28161bQ;
    private final AdTemplate mAdTemplate;
    private Presenter mPresenter;

    /* renamed from: nZ */
    private boolean f28162nZ;

    public C8592g(@NonNull Context context, AdTemplate adTemplate, InterfaceC8582d interfaceC8582d) {
        super(context);
        this.f28160JU = new InterfaceC8582d() { // from class: com.kwad.components.core.e.a.g.1
            @Override // com.kwad.components.core.p289e.p290a.InterfaceC8582d
            /* renamed from: ne */
            public final void mo30289ne() {
                C8592g.this.m30296dJ();
            }
        };
        this.mAdTemplate = adTemplate;
        this.f28158JJ = interfaceC8582d;
        this.f28161bQ = new C9366b(this, 70);
        initMVP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dJ */
    public void m30296dJ() {
        if (this.f28162nZ) {
            return;
        }
        this.f28162nZ = true;
        this.f28158JJ.mo30289ne();
    }

    private void initMVP() {
        this.f28159JS = m30295nl();
        Presenter onCreatePresenter = onCreatePresenter();
        this.mPresenter = onCreatePresenter;
        onCreatePresenter.m24616G(this);
        this.mPresenter.m24605k(this.f28159JS);
    }

    /* renamed from: nl */
    private C8579a m30295nl() {
        C8579a c8579a = new C8579a();
        c8579a.f28136JH = this;
        c8579a.mAdTemplate = this.mAdTemplate;
        c8579a.f28137JI = this.f28161bQ;
        c8579a.f28138JJ = this.f28160JU;
        return c8579a;
    }

    private static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.m24612a(new C8589f());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public final void mo23565ac() {
        super.mo23565ac();
        C10331c.m26254d("InstalledActivateView", "onViewAttached");
        this.f28161bQ.m28900tw();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        C10331c.m26254d("InstalledActivateView", "onViewDetached");
        this.f28161bQ.release();
        this.mPresenter.destroy();
        this.f28159JS.release();
        m30296dJ();
    }
}
