package com.kwad.components.p208ad.reward.presenter;

import androidx.annotation.NonNull;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.C7957k;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7881b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.presenter.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8218m extends C8094b {

    /* renamed from: hj */
    private long f27182hj;
    @NonNull

    /* renamed from: oI */
    private InterfaceC7881b f27183oI;

    /* renamed from: su */
    private C9002l f27184su;

    /* renamed from: sv */
    private C9002l f27185sv = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            C8218m c8218m = C8218m.this;
            C7907g c7907g = c8218m.f26957qo;
            if (c7907g.f26544oY && c7907g.f26555pd) {
                c8218m.f27183oI.onVideoSkipToEnd(C8218m.this.f27182hj);
            } else {
                c7907g.f26574pw = true;
                c8218m.f27183oI.onVideoPlayEnd();
            }
            AdInfo m25641dQ = C10487e.m25641dQ(C8218m.this.f26957qo.mAdTemplate);
            if (C10483a.m25947aO(m25641dQ) && C10483a.m25948aN(m25641dQ) == 1) {
                return;
            }
            C8141f.m31459s(C8218m.this.f26957qo);
            C7907g c7907g2 = C8218m.this.f26957qo;
            if (c7907g2.f26574pw) {
                C7957k.m31924h(c7907g2);
            }
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            C8218m c8218m = C8218m.this;
            C7907g c7907g = c8218m.f26957qo;
            c7907g.f26573pv = j2;
            if (c7907g.f26555pd) {
                return;
            }
            c8218m.f27182hj = j2;
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            C8218m.this.f27183oI.onVideoPlayStart();
            C8218m.this.f26957qo.f26574pw = false;
        }
    };

    /* renamed from: gO */
    private final C9002l f27181gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            C8218m c8218m = C8218m.this;
            if (c8218m.f26957qo.f26555pd) {
                c8218m.f27183oI.onVideoSkipToEnd(C8218m.this.f27182hj);
            } else {
                c8218m.f27183oI.onVideoPlayEnd();
            }
            AdInfo m25641dQ = C10487e.m25641dQ(C8218m.this.f26957qo.mAdTemplate);
            if (C10483a.m25947aO(m25641dQ) && C10483a.m25948aN(m25641dQ) == 1) {
                return;
            }
            C8141f.m31459s(C8218m.this.f26957qo);
            C7907g c7907g = C8218m.this.f26957qo;
            if (c7907g.f26574pw) {
                C7957k.m31924h(c7907g);
            }
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayError(int i, int i2) {
            C8218m.this.f27183oI.onVideoPlayError(i, i2);
            C8218m.this.m31613hp();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            C8218m c8218m = C8218m.this;
            C7907g c7907g = c8218m.f26957qo;
            c7907g.f26573pv = j2;
            c7907g.f26574pw = j - j2 < 800;
            if (c7907g.f26555pd) {
                return;
            }
            c8218m.f27182hj = j2;
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            C8218m.this.f27183oI.onVideoPlayStart();
        }
    };

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7907g c7907g = this.f26957qo;
        c7907g.f26573pv = 0L;
        c7907g.f26574pw = false;
        this.f27183oI = c7907g.f26528oI;
        if (c7907g.f26529oJ.m31821jM()) {
            this.f27184su = this.f27185sv;
        } else {
            this.f27184su = this.f27181gO;
        }
        this.f26957qo.f26529oJ.m31828a(this.f27184su);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31826b(this.f27184su);
    }
}
