package com.kwad.components.ad.reward.presenter.d;

import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.c;
import com.kwad.components.ad.reward.presenter.s;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends c {
        public a(AdInfo adInfo) {
            super(adInfo);
        }

        @Override // com.kwad.components.ad.reward.presenter.c
        public final int hr() {
            return R.id.ksad_blur_end_cover;
        }

        @Override // com.kwad.components.ad.reward.presenter.c
        public final int hs() {
            return 8;
        }
    }

    public b(AdTemplate adTemplate, boolean z3) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dQ(adTemplate);
        if (z3) {
            it();
        } else {
            iu();
        }
    }

    private void it() {
        if (g.g(this.mAdInfo)) {
            a(new s());
        }
        a(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.b.b.cz(this.mAdTemplate)) {
            a(new com.kwad.components.ad.reward.presenter.d.a.c());
        }
        a(new a(this.mAdInfo));
        if (com.kwad.components.ad.reward.a.b.k(this.mAdInfo) || !com.kwad.sdk.core.response.b.a.as(this.mAdInfo)) {
            return;
        }
        a(new com.kwad.components.ad.reward.presenter.d.a.a());
    }

    private void iu() {
        a(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.b.b.cz(this.mAdTemplate)) {
            a(new com.kwad.components.ad.reward.presenter.d.a.c());
        }
    }
}
