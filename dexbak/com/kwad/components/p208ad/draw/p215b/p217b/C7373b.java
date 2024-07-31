package com.kwad.components.p208ad.draw.p215b.p217b;

import android.view.ViewGroup;
import com.kwad.components.p208ad.draw.p214a.C7357a;
import com.kwad.components.p208ad.draw.p215b.p217b.C7370a;
import com.kwad.components.p208ad.draw.view.playcard.DrawCardApp;
import com.kwad.components.p208ad.draw.view.playcard.DrawCardH5;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.draw.b.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7373b extends C7357a {

    /* renamed from: cF */
    private C7370a.InterfaceC7371a f25305cF = new C7370a.InterfaceC7371a() { // from class: com.kwad.components.ad.draw.b.b.b.1
        @Override // com.kwad.components.p208ad.draw.p215b.p217b.C7370a.InterfaceC7371a
        /* renamed from: aq */
        public final void mo33400aq() {
            C7373b.this.m33406aq();
        }
    };

    /* renamed from: cI */
    private DrawCardApp f25306cI;

    /* renamed from: cJ */
    private DrawCardH5 f25307cJ;

    /* renamed from: co */
    private ViewGroup f25308co;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aq */
    public void m33406aq() {
        if (C10483a.m25956aF(this.mAdInfo)) {
            m33405as();
        } else {
            m33404at();
        }
    }

    /* renamed from: as */
    private void m33405as() {
        this.f25308co.setVisibility(8);
        this.f25306cI.m33334a(this.mAdTemplate, new DrawCardApp.InterfaceC7409a() { // from class: com.kwad.components.ad.draw.b.b.b.2
            @Override // com.kwad.components.p208ad.draw.view.playcard.DrawCardApp.InterfaceC7409a
            /* renamed from: av */
            public final void mo33326av() {
                C7373b.this.f25308co.setVisibility(0);
            }

            @Override // com.kwad.components.p208ad.draw.view.playcard.DrawCardApp.InterfaceC7409a
            /* renamed from: aw */
            public final void mo33325aw() {
                C7373b.this.m33403au();
            }
        });
        this.f25306cI.setVisibility(0);
        this.f25306cI.m33332aO();
    }

    /* renamed from: at */
    private void m33404at() {
        this.f25308co.setVisibility(8);
        this.f25307cJ.m33322a(this.mAdTemplate, new DrawCardH5.InterfaceC7411a() { // from class: com.kwad.components.ad.draw.b.b.b.3
            @Override // com.kwad.components.p208ad.draw.view.playcard.DrawCardH5.InterfaceC7411a
            /* renamed from: av */
            public final void mo33317av() {
                C7373b.this.f25308co.setVisibility(0);
            }

            @Override // com.kwad.components.p208ad.draw.view.playcard.DrawCardH5.InterfaceC7411a
            /* renamed from: aw */
            public final void mo33316aw() {
                C7373b.this.m33403au();
            }
        });
        this.f25307cJ.setVisibility(0);
        this.f25307cJ.m33320aO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: au */
    public void m33403au() {
        C9908c.m27349a(this.mAdTemplate, 29, this.f25273bO.mRootContainer.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = this.f25273bO.f25274bN;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.components.p208ad.draw.p214a.C7357a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdTemplate adTemplate = this.f25273bO.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        this.f25273bO.f25276ch.m33410a(this.f25305cF);
        this.f25306cI.setVisibility(8);
        this.f25307cJ.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25308co = (ViewGroup) findViewById(C9659R.C9662id.ksad_ad_normal_container);
        this.f25306cI = (DrawCardApp) findViewById(C9659R.C9662id.ksad_card_app_container);
        this.f25307cJ = (DrawCardH5) findViewById(C9659R.C9662id.ksad_card_h5_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f25306cI.release();
        this.f25307cJ.release();
        this.f25273bO.f25276ch.m33410a((C7370a.InterfaceC7371a) null);
    }
}
