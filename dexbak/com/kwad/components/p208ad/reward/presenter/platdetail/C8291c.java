package com.kwad.components.p208ad.reward.presenter.platdetail;

import android.graphics.Color;
import android.view.View;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8291c extends C8094b implements InterfaceC11145c {
    private C8619c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m31065K(boolean z) {
        C7955b.m31927a(this.mAdTemplate, "native_id", "videoPlayer", new C9913b().m27266cK(z ? 85 : 153).m27247f(this.f26957qo.mRootContainer.getTouchCoords()), this.f26957qo.mReportExtData);
        this.f26957qo.f26528oI.mo32088bJ();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.mApkDownloadHelper = this.f26957qo.mApkDownloadHelper;
        new GestureDetector$OnGestureListenerC11148f(this.mDetailVideoView, this);
        this.mDetailVideoView.setBackgroundColor(Color.parseColor(C10483a.m25937aY(C10487e.m25641dQ(this.mAdTemplate)) ? "#B3000000" : "#4D000000"));
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m31063b(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(C9659R.C9662id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setClickListener(null);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m31063b(view, true);
    }

    /* renamed from: b */
    private void m31063b(View view, final boolean z) {
        C8615a.m30233a(new C8615a.C8616a(view.getContext()).m30198aq(this.mAdTemplate).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.c.1
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                C8291c.this.m31065K(z);
            }
        }).m30189b(this.mApkDownloadHelper).m30202ao(false).m30158v(this.f26957qo.f26564pm).m30205an(3));
    }
}
