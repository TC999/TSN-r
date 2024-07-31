package com.kwad.components.p208ad.reward.presenter.p268d.p269a;

import android.widget.FrameLayout;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.p247k.C7815a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.C8141f;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;

/* renamed from: com.kwad.components.ad.reward.presenter.d.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8113a extends C8094b implements C7815a.InterfaceC7823b {

    /* renamed from: da */
    private FrameLayout f26992da;

    /* renamed from: su */
    private C9002l f26994su;

    /* renamed from: vz */
    private volatile long f26997vz = 0;

    /* renamed from: vA */
    private volatile boolean f26996vA = false;

    /* renamed from: sv */
    private C9002l f26995sv = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8996g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            C8113a.this.f26996vA = false;
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            C8113a.this.f26996vA = true;
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            C8113a.this.f26997vz = j2;
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            C8113a.this.f26996vA = false;
        }
    };

    /* renamed from: gO */
    private C9002l f26993gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.2
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            C8113a.this.f26997vz = j2;
            C8113a.this.f26996vA = j - j2 < 800;
        }
    };
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.4
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            if (C8113a.this.f26957qo.f26567pp || C8113a.this.f26957qo.f26534oO == null) {
                return;
            }
            C8113a.this.f26957qo.f26534oO.m32245ar();
        }
    };

    /* renamed from: cR */
    private InterfaceC10635a f26991cR = new InterfaceC10635a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.5
        @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
        /* renamed from: a */
        public final void mo25245a(C10640a c10640a) {
            C8113a.this.f26957qo.f26528oI.mo32088bJ();
        }
    };

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26997vz = 0L;
        this.f26996vA = false;
        C7907g c7907g = this.f26957qo;
        AdTemplate adTemplate = c7907g.mAdTemplate;
        C7815a c7815a = c7907g.f26534oO;
        this.f26994su = c7907g.f26529oJ.m31821jM() ? this.f26995sv : this.f26993gO;
        if (c7815a != null) {
            this.f26957qo.f26561pj = true;
            c7815a.m32251a(this);
            c7815a.m32247a(this.f26991cR);
            c7815a.m32253a(this.f26992da, this.f26957qo.mRootContainer, adTemplate);
            c7815a.m32252a(new C7815a.InterfaceC7822a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.3
                @Override // com.kwad.components.p208ad.p247k.C7815a.InterfaceC7822a
                /* renamed from: R */
                public final void mo31537R(boolean z) {
                    C8113a.this.f26957qo.f26561pj = z;
                }
            });
            c7815a.setActivity(this.f26957qo.getActivity());
            c7815a.m32244ay();
            this.f26957qo.m32034b(this.mPlayEndPageListener);
            this.f26957qo.f26529oJ.m31828a(this.f26994su);
        }
    }

    @Override // com.kwad.components.p208ad.p247k.C7815a.InterfaceC7823b
    /* renamed from: iv */
    public final void mo31538iv() {
        C8141f.m31460r(this.f26957qo);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f26992da = (FrameLayout) findViewById(C9659R.C9662id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.m32024c(this.mPlayEndPageListener);
        this.f26957qo.f26529oJ.m31826b(this.f26994su);
    }
}
