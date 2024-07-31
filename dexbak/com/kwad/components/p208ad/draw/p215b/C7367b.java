package com.kwad.components.p208ad.draw.p215b;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.draw.p214a.C7357a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.C10493b;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.draw.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7367b extends C7357a {

    /* renamed from: ck */
    private ImageView f25297ck;

    /* renamed from: cl */
    private C10493b f25298cl;
    private InterfaceC9001k mVideoPlayStateListener = new C9002l() { // from class: com.kwad.components.ad.draw.b.b.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (C7367b.this.f25297ck.getVisibility() == 0) {
                C7367b.this.f25297ck.setVisibility(8);
            }
        }
    };

    /* renamed from: cm */
    private Runnable f25299cm = new Runnable() { // from class: com.kwad.components.ad.draw.b.b.2
        @Override // java.lang.Runnable
        public final void run() {
            int width = C7367b.this.getRootView().getWidth();
            ViewGroup.LayoutParams layoutParams = C7367b.this.f25297ck.getLayoutParams();
            int width2 = C7367b.this.f25298cl.getWidth();
            int height = C7367b.this.f25298cl.getHeight();
            if (width2 != 0 && height != 0 && height <= width2) {
                layoutParams.width = width;
                layoutParams.height = (int) ((height / (width2 * 1.0f)) * width);
                C7367b.this.f25297ck.setLayoutParams(layoutParams);
                C7367b.this.f25297ck.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -1;
                C7367b.this.f25297ck.setLayoutParams(layoutParams);
            }
            C7367b.this.f25297ck.setImageDrawable(null);
            KSImageLoader.loadImage(C7367b.this.f25297ck, C7367b.this.f25298cl.getUrl(), C7367b.this.f25273bO.mAdTemplate);
        }
    };

    @Override // com.kwad.components.p208ad.draw.p214a.C7357a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C10493b m25862br = C10483a.m25862br(C10487e.m25641dQ(this.f25273bO.mAdTemplate));
        this.f25298cl = m25862br;
        if (TextUtils.isEmpty(m25862br.getUrl())) {
            return;
        }
        getRootView().post(this.f25299cm);
        this.f25297ck.setVisibility(0);
        this.f25273bO.f25275bP.mo31843b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25297ck = (ImageView) findViewById(C9659R.C9662id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.f25299cm);
        this.f25273bO.f25275bP.mo31844a(this.mVideoPlayStateListener);
    }
}
