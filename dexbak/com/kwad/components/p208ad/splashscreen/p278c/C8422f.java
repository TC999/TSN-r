package com.kwad.components.p208ad.splashscreen.p278c;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.p208ad.splashscreen.p284f.C8486c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.splashscreen.c.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8422f extends C8421e {

    /* renamed from: cj */
    private ComplianceTextView f27735cj;

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(C8486c.m30630z(C10487e.m25641dQ(this.f27734Dg.mAdTemplate)) ? C9659R.C9662id.ksad_compliance_right_view : C9659R.C9662id.ksad_compliance_left_view);
        this.f27735cj = complianceTextView;
        complianceTextView.setBackgroundColor(0);
        this.f27735cj.setVisibility(0);
        this.f27735cj.setAdTemplate(this.f27734Dg.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
