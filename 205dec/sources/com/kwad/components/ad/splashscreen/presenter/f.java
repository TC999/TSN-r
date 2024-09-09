package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class f extends e {
    private ComplianceTextView cj;

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(com.kwad.components.ad.splashscreen.e.c.z(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate)) ? R.id.ksad_compliance_right_view : R.id.ksad_compliance_left_view);
        this.cj = complianceTextView;
        complianceTextView.setBackgroundColor(0);
        this.cj.setVisibility(0);
        this.cj.setAdTemplate(this.Di.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
