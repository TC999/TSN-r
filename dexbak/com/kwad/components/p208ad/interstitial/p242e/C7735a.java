package com.kwad.components.p208ad.interstitial.p242e;

import android.view.OrientationEventListener;
import android.view.View;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.interstitial.e.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7735a extends C7760b {

    /* renamed from: jF */
    private ComplianceTextView f26155jF;

    /* renamed from: jG */
    private OrientationEventListener f26156jG;

    /* renamed from: jH */
    private KsAutoCloseView f26157jH;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m32545b(C7761c c7761c) {
        m32544h(this.f26155jF);
        if (!C11015ai.isOrientationPortrait()) {
            C10751a.m24917b(this.f26157jH, 0, 0, 0, 0);
        } else {
            C10751a.m24917b(this.f26157jH, 0, C10751a.m24924a(getContext(), 25.0f), 0, 0);
        }
        this.f26155jF.setVisibility(0);
        this.f26155jF.setAdTemplate(c7761c.mAdTemplate);
    }

    /* renamed from: h */
    private void m32544h(View view) {
        int m24924a = C10751a.m24924a(getContext(), 4.0f);
        int m24924a2 = C10751a.m24924a(getContext(), 4.0f);
        C10751a.m24917b(view, m24924a2, m24924a, m24924a2, 0);
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.C7760b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7761c c7761c = (C7761c) m24613Jx();
        m32545b(c7761c);
        m32546a(c7761c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f26155jF = (ComplianceTextView) findViewById(C9659R.C9662id.ksad_compliance_view);
        this.f26157jH = (KsAutoCloseView) findViewById(C9659R.C9662id.ksad_interstitial_auto_close);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.f26156jG;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    /* renamed from: a */
    private void m32546a(final C7761c c7761c) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(c7761c.f26202io.getContext()) { // from class: com.kwad.components.ad.interstitial.e.a.1
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i) {
                C7735a.this.m32545b(c7761c);
            }
        };
        this.f26156jG = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            this.f26156jG.enable();
        } else {
            this.f26156jG.disable();
        }
    }
}
