package com.kwad.components.p208ad.reward.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.ad.reward.presenter.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8111d extends C8094b {

    /* renamed from: cj */
    private ComplianceTextView f26990cj;

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26990cj.setVisibility(0);
        this.f26990cj.setAdTemplate(this.f26957qo.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f26990cj = (ComplianceTextView) findViewById(C9659R.C9662id.ksad_compliance_view);
    }
}
