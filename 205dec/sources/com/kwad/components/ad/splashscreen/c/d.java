package com.kwad.components.ad.splashscreen.c;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends e {
    private List<Integer> cB;
    private final com.kwad.components.core.video.k mVideoPlayStateListener = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.splashscreen.c.d.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.ld();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            d.this.c(j5);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.lc();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j4) {
        int ceil = (int) Math.ceil(((float) j4) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cB.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.Dg.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lc() {
        com.kwad.sdk.core.adlog.c.bK(this.Dg.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld() {
        com.kwad.sdk.core.adlog.c.bL(this.Dg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.cB = com.kwad.sdk.core.response.b.a.bm(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate));
        com.kwad.components.ad.splashscreen.e.a aVar = this.Dg.Cq;
        if (aVar != null) {
            aVar.b(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.a aVar = this.Dg.Cq;
        if (aVar != null) {
            aVar.a(this.mVideoPlayStateListener);
        }
    }
}
