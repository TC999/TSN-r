package com.kwad.components.ad.interstitial.e;

import android.view.OrientationEventListener;
import android.view.View;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ai;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends b {
    private ComplianceTextView jF;
    private OrientationEventListener jG;
    private KsAutoCloseView jH;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        h(this.jF);
        if (!ai.isOrientationPortrait()) {
            com.kwad.sdk.d.a.a.b(this.jH, 0, 0, 0, 0);
        } else {
            com.kwad.sdk.d.a.a.b(this.jH, 0, com.kwad.sdk.d.a.a.a(getContext(), 25.0f), 0, 0);
        }
        this.jF.setVisibility(0);
        this.jF.setAdTemplate(cVar.mAdTemplate);
    }

    private void h(View view) {
        int a4 = com.kwad.sdk.d.a.a.a(getContext(), 4.0f);
        int a5 = com.kwad.sdk.d.a.a.a(getContext(), 4.0f);
        com.kwad.sdk.d.a.a.b(view, a5, a4, a5, 0);
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        c cVar = (c) Jx();
        b(cVar);
        a(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jF = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        this.jH = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.jG;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    private void a(final c cVar) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(cVar.f38639io.getContext()) { // from class: com.kwad.components.ad.interstitial.e.a.1
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i4) {
                a.this.b(cVar);
            }
        };
        this.jG = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            this.jG.enable();
        } else {
            this.jG.disable();
        }
    }
}
