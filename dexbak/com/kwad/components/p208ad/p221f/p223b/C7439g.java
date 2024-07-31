package com.kwad.components.p208ad.p221f.p223b;

import android.widget.ImageView;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.f.b.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7439g extends C7416a {

    /* renamed from: ne */
    private ImageView f25455ne;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ey */
    public void m33266ey() {
        KSImageLoader.loadImage(this.f25455ne, C10483a.m25964X(C10487e.m25641dQ(this.f25416mN.mAdTemplate)), this.f25416mN.mAdTemplate);
        this.f25455ne.setVisibility(0);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.g.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                C7439g.this.m33266ey();
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
        this.f25455ne.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25455ne = (ImageView) findViewById(C9659R.C9662id.ksad_video_cover_image);
    }
}
