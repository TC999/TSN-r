package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m extends b {
    private long hj;
    @NonNull
    private com.kwad.components.ad.reward.e.b oI;
    private com.kwad.components.core.video.l su;
    private com.kwad.components.core.video.l sv = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qo;
            if (gVar.oY && gVar.pd) {
                mVar.oI.onVideoSkipToEnd(m.this.hj);
            } else {
                gVar.pw = true;
                mVar.oI.onVideoPlayEnd();
            }
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(m.this.qo.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(dQ) && com.kwad.sdk.core.response.b.a.aN(dQ) == 1) {
                return;
            }
            f.s(m.this.qo);
            com.kwad.components.ad.reward.g gVar2 = m.this.qo;
            if (gVar2.pw) {
                com.kwad.components.ad.reward.k.h(gVar2);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            super.onMediaPlayProgress(j4, j5);
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qo;
            gVar.pv = j5;
            if (gVar.pd) {
                return;
            }
            mVar.hj = j5;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.oI.onVideoPlayStart();
            m.this.qo.pw = false;
        }
    };
    private final com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            m mVar = m.this;
            if (mVar.qo.pd) {
                mVar.oI.onVideoSkipToEnd(m.this.hj);
            } else {
                mVar.oI.onVideoPlayEnd();
            }
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(m.this.qo.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(dQ) && com.kwad.sdk.core.response.b.a.aN(dQ) == 1) {
                return;
            }
            f.s(m.this.qo);
            com.kwad.components.ad.reward.g gVar = m.this.qo;
            if (gVar.pw) {
                com.kwad.components.ad.reward.k.h(gVar);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i4, int i5) {
            m.this.oI.onVideoPlayError(i4, i5);
            m.this.hp();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qo;
            gVar.pv = j5;
            gVar.pw = j4 - j5 < 800;
            if (gVar.pd) {
                return;
            }
            mVar.hj = j5;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            m.this.oI.onVideoPlayStart();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = this.qo;
        gVar.pv = 0L;
        gVar.pw = false;
        this.oI = gVar.oI;
        if (gVar.oJ.jM()) {
            this.su = this.sv;
        } else {
            this.su = this.gO;
        }
        this.qo.oJ.a(this.su);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.su);
    }
}
