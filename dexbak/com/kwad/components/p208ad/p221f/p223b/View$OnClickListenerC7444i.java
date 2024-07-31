package com.kwad.components.p208ad.p221f.p223b;

import android.view.View;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;

/* renamed from: com.kwad.components.ad.f.b.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7444i extends C7416a implements View.OnClickListener {
    private DetailVideoView mDetailVideoView;

    /* renamed from: ez */
    private void m33257ez() {
        C8615a.m30233a(new C8615a.C8616a(this.mDetailVideoView.getContext()).m30198aq(this.f25416mN.mAdTemplate).m30189b(this.f25416mN.mApkDownloadHelper).m30158v(this.f25416mN.f25418mO.getPlayDuration()).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.f.b.i.2
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                C9908c.m27349a(View$OnClickListenerC7444i.this.f25416mN.mAdTemplate, 2, View$OnClickListenerC7444i.this.f25416mN.f25417mI.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.f25416mN.f25420mw.mo33198l(this.mDetailVideoView);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.i.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                View$OnClickListenerC7444i.this.mDetailVideoView.setOnClickListener(View$OnClickListenerC7444i.this);
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.mDetailVideoView) {
            m33257ez();
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(C9659R.C9662id.ksad_video_player);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setOnClickListener(null);
    }
}
