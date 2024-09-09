package com.kwad.components.ad.splashscreen.presenter;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class d extends e {
    private List<Integer> cB;
    private final com.kwad.components.core.video.k mVideoPlayStateListener = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.splashscreen.presenter.d.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.le();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            d.this.c(j5);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.ld();
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
                com.kwad.sdk.core.adlog.c.a(this.Di.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld() {
        com.kwad.sdk.core.adlog.c.bM(this.Di.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le() {
        com.kwad.sdk.core.adlog.c.bN(this.Di.mAdTemplate);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.kwad.components.ad.k.b, com.kwad.components.ad.splashscreen.d.a] */
    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.cB = com.kwad.sdk.core.response.b.a.bn(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate));
        ?? r02 = this.Di.Cr;
        if (r02 != 0) {
            r02.a(this.mVideoPlayStateListener);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.kwad.components.ad.k.b, com.kwad.components.ad.splashscreen.d.a] */
    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ?? r02 = this.Di.Cr;
        if (r02 != 0) {
            r02.b(this.mVideoPlayStateListener);
        }
    }
}
