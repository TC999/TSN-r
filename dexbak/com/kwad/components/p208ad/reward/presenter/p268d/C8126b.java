package com.kwad.components.p208ad.reward.presenter.p268d;

import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.C8104c;
import com.kwad.components.p208ad.reward.presenter.C8301s;
import com.kwad.components.p208ad.reward.presenter.p268d.p269a.C8113a;
import com.kwad.components.p208ad.reward.presenter.p268d.p269a.C8119b;
import com.kwad.components.p208ad.reward.presenter.p268d.p269a.C8123c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.presenter.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8126b extends C8094b {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.presenter.d.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8127a extends C8104c {
        public C8127a(AdInfo adInfo) {
            super(adInfo);
        }

        @Override // com.kwad.components.p208ad.reward.presenter.C8104c
        /* renamed from: hr */
        public final int mo31501hr() {
            return C9659R.C9662id.ksad_blur_end_cover;
        }

        @Override // com.kwad.components.p208ad.reward.presenter.C8104c
        /* renamed from: hs */
        public final int mo31500hs() {
            return 8;
        }
    }

    public C8126b(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        if (z) {
            m31506it();
        } else {
            m31505iu();
        }
    }

    /* renamed from: it */
    private void m31506it() {
        if (C7907g.m31991g(this.mAdInfo)) {
            m24612a(new C8301s());
        }
        m24612a(new C8119b());
        if (C10484b.m25742cz(this.mAdTemplate)) {
            m24612a(new C8123c());
        }
        m24612a(new C8127a(this.mAdInfo));
        if (C7844b.m32176k(this.mAdInfo) || !C10483a.m25917as(this.mAdInfo)) {
            return;
        }
        m24612a(new C8113a());
    }

    /* renamed from: iu */
    private void m31505iu() {
        m24612a(new C8119b());
        if (C10484b.m25742cz(this.mAdTemplate)) {
            m24612a(new C8123c());
        }
    }
}
