package com.kwad.components.p208ad.splashscreen.p278c;

import com.kwad.components.p208ad.splashscreen.p278c.p280b.C8391b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.splashscreen.c.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8435j extends C8421e {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bQ */
    public void m30734bQ() {
        AdInfo m25641dQ = C10487e.m25641dQ(this.f27734Dg.mAdTemplate);
        m24611a(new C8383b(), true);
        m24611a(new C8401c(), true);
        if (C10483a.m25877bc(m25641dQ)) {
            m24611a(new C8419d(), true);
            m24611a(new C8468q(), true);
        } else {
            m24611a(new C8425h(), true);
        }
        if (this.f27734Dg.f27887Cy) {
            m24611a(new C8455p(), true);
        } else {
            boolean m25682du = C10484b.m25682du(m25641dQ);
            boolean m25674dy = C10484b.m25674dy(m25641dQ);
            boolean m25737dD = C10484b.m25737dD(m25641dQ);
            if (C10484b.m25741dA(m25641dQ)) {
                m24611a(new C8447n(), true);
            } else if (m25682du) {
                m24611a(new View$OnClickListenerC8442m(), true);
            } else if (m25674dy) {
                m24611a(new View$OnClickListenerC8438l(), true);
            } else if (m25737dD) {
                m24611a(new C8455p(), true);
            }
        }
        if (C10483a.m25946aP(m25641dQ)) {
            m24611a(new C8422f(), true);
        }
        if (!this.f27734Dg.f27888Cz) {
            m24611a(new C8391b(), true);
        }
        m24611a(new C8368a(), true);
        m24611a(new C8423g(), true);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.j.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8435j.this.m30734bQ();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        findViewById(C9659R.C9662id.splash_play_card_view).setVisibility(0);
    }
}
