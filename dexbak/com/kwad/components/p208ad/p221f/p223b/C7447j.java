package com.kwad.components.p208ad.p221f.p223b;

import android.view.View;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.ad.f.b.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7447j extends C7416a {

    /* renamed from: nk */
    private View f25463nk;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: eA */
    public void m33255eA() {
        if (this.f25463nk.getVisibility() == 0) {
            return;
        }
        this.f25463nk.setVisibility(0);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f25463nk.setVisibility(8);
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.j.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                C7447j.this.m33255eA();
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25463nk = findViewById(C9659R.C9662id.ksad_video_error_container);
    }
}
