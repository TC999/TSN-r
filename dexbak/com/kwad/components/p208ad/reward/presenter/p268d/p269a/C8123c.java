package com.kwad.components.p208ad.reward.presenter.p268d.p269a;

import android.widget.FrameLayout;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.p208ad.p247k.C7824b;
import com.kwad.components.p208ad.reward.C7845b;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.C7951j;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7892l;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.reward.presenter.d.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8123c extends C8094b implements C7824b.InterfaceC7828a {

    /* renamed from: ci */
    private C7824b f27016ci;

    /* renamed from: da */
    private FrameLayout f27017da;
    private DetailVideoView mDetailVideoView;

    /* renamed from: tg */
    private int f27018tg = Integer.MIN_VALUE;
    private final InterfaceC7892l mRewardVerifyListener = new InterfaceC7892l() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7892l
        public final void onRewardVerify() {
            if (C8123c.this.f27016ci == null || !C7907g.m32062G(C8123c.this.f26957qo.mAdTemplate)) {
                return;
            }
            C8123c.this.f27016ci.m32218ag(true);
        }
    };

    /* renamed from: cR */
    private InterfaceC10635a f27015cR = new InterfaceC10635a() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.2
        @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
        /* renamed from: a */
        public final void mo25245a(C10640a c10640a) {
            C8123c.this.f26957qo.f26528oI.mo32088bJ();
        }
    };

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7907g c7907g = this.f26957qo;
        AdTemplate adTemplate = c7907g.mAdTemplate;
        C7951j c7951j = c7907g.f26533oN;
        this.f27016ci = c7951j;
        if (c7951j == null) {
            return;
        }
        C7845b.m32173fb().m32175a(this.mRewardVerifyListener);
        this.f27016ci.m32220a(this.f27015cR);
        C7824b c7824b = this.f27016ci;
        FrameLayout frameLayout = this.f27017da;
        C7907g c7907g2 = this.f26957qo;
        c7824b.mo32119a(frameLayout, c7907g2.mRootContainer, adTemplate, c7907g2.mApkDownloadHelper, c7907g2.mScreenOrientation);
        this.f27016ci.m32223a((C7824b.InterfaceC7829b) null);
        C7824b c7824b2 = this.f27016ci;
        if (c7824b2 != null) {
            c7824b2.m32224a(this);
        }
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b.InterfaceC7828a
    /* renamed from: iA */
    public final void mo31507iA() {
        m31613hp();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27017da = (FrameLayout) findViewById(C9659R.C9662id.ksad_web_card_container);
        this.mDetailVideoView = (DetailVideoView) findViewById(C9659R.C9662id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i;
        super.onUnbind();
        C7824b c7824b = this.f27016ci;
        if (c7824b != null) {
            c7824b.m32212mj();
            this.f27016ci.m32213lW();
        }
        C7845b.m32173fb().m32174b(this.mRewardVerifyListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView == null || (i = this.f27018tg) == Integer.MIN_VALUE) {
            return;
        }
        C10751a.m24906n(detailVideoView, i);
    }
}
