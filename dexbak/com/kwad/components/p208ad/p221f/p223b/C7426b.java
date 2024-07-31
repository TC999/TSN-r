package com.kwad.components.p208ad.p221f.p223b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.C10493b;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.f.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7426b extends C7416a {

    /* renamed from: ck */
    private ImageView f25434ck;

    /* renamed from: cl */
    private C10493b f25435cl;

    /* renamed from: cm */
    private Runnable f25436cm = new Runnable() { // from class: com.kwad.components.ad.f.b.b.2
        @Override // java.lang.Runnable
        public final void run() {
            C10751a.m24912d(C7426b.this.f25434ck, C7426b.this.f25435cl.getWidth(), C7426b.this.f25435cl.getHeight());
            C7426b.this.f25434ck.setImageDrawable(null);
            KSImageLoader.loadImage(C7426b.this.f25434ck, C7426b.this.f25435cl.getUrl(), C7426b.this.f25416mN.mAdTemplate);
        }
    };

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C10493b m25862br = C10483a.m25862br(C10487e.m25641dQ(this.f25416mN.mAdTemplate));
        this.f25435cl = m25862br;
        if (TextUtils.isEmpty(m25862br.getUrl())) {
            return;
        }
        getRootView().post(this.f25436cm);
        this.f25434ck.setVisibility(0);
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.b.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (C7426b.this.f25434ck.getVisibility() == 0) {
                    C7426b.this.f25434ck.setVisibility(8);
                }
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25434ck = (ImageView) findViewById(C9659R.C9662id.ksad_video_first_frame);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.f25436cm);
    }
}
