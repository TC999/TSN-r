package com.kwad.components.p208ad.draw.p215b;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.p208ad.draw.p214a.C7357a;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.ad.draw.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7363a extends C7357a {

    /* renamed from: cj */
    private ComplianceTextView f25290cj;

    @Override // com.kwad.components.p208ad.draw.p214a.C7357a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f25290cj.setVisibility(0);
        this.f25290cj.setAdTemplate(this.f25273bO.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25290cj = (ComplianceTextView) findViewById(C9659R.C9662id.ksad_compliance_view);
    }
}
