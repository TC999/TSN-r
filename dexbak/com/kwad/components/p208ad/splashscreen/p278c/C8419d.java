package com.kwad.components.p208ad.splashscreen.p278c;

import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.splashscreen.p283e.C8478a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8419d extends C8421e {

    /* renamed from: cB */
    private List<Integer> f27732cB;
    private final InterfaceC9001k mVideoPlayStateListener = new C9002l() { // from class: com.kwad.components.ad.splashscreen.c.d.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            C8419d.this.m30753ld();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            C8419d.this.m30755c(j2);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            C8419d.this.m30754lc();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m30755c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f27732cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f27732cB.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                C9908c.m27348a(this.f27734Dg.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lc */
    public void m30754lc() {
        C9908c.m27324bK(this.f27734Dg.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ld */
    public void m30753ld() {
        C9908c.m27323bL(this.f27734Dg.mAdTemplate);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27732cB = C10483a.m25867bm(C10487e.m25641dQ(this.f27734Dg.mAdTemplate));
        C8478a c8478a = this.f27734Dg.f27879Cq;
        if (c8478a != null) {
            c8478a.mo31843b(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C8478a c8478a = this.f27734Dg.f27879Cq;
        if (c8478a != null) {
            c8478a.mo31844a(this.mVideoPlayStateListener);
        }
    }
}
