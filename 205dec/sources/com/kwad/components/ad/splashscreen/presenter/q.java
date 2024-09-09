package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.h;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class q extends e implements com.kwad.sdk.core.h.c {
    private SkipView Eo;
    private ImageView hp;
    private AdInfo mAdInfo;
    private volatile boolean El = false;
    private boolean Em = false;
    private boolean En = false;
    private h.a hq = new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [com.kwad.components.ad.splashscreen.presenter.q$1$1, java.lang.Runnable] */
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            q.this.El = false;
            if (q.this.hp != null) {
                q.this.hp.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1.1
                    public final void doTask() {
                        q qVar = q.this;
                        com.kwad.components.ad.splashscreen.d.a aVar = qVar.Di.Cr;
                        if (aVar != null) {
                            aVar.setAudioEnabled(qVar.El, false);
                        }
                        com.kwad.components.ad.splashscreen.h hVar = q.this.Di;
                        if (hVar != null) {
                            AdInfo dS = com.kwad.sdk.core.response.b.e.dS(hVar.mAdTemplate);
                            String str = q.this.El ? dS.adSplashInfo.speakerIconUrl : dS.adSplashInfo.speakerMuteIconUrl;
                            if (!TextUtils.isEmpty(str)) {
                                KSImageLoader.loadImage(q.this.hp, str, q.this.Di.mAdTemplate);
                            } else {
                                q.this.hp.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            }
                            q.this.hp.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.core.video.k Ep = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.splashscreen.presenter.q.2
        private boolean Es = false;
        private String Et = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CP);

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            if (this.Es) {
                return;
            }
            q.this.Di.kN();
            this.Es = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i4, int i5) {
            if (q.this.En) {
                return;
            }
            q.this.Di.i(0, "onMediaPlayError");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, final long j5) {
            q.this.Di.X(((int) j5) / 1000);
            final int min = Math.min(q.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j4) / 1000);
            final String str = this.Et;
            q qVar = q.this;
            if (q.a(qVar, qVar.mAdInfo)) {
                q.this.Eo.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.q.2.1
                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        int i4 = (int) (((min * 1000) - j5) / 1000);
                        if (i4 <= 0) {
                            i4 = 1;
                        }
                        q.this.Eo.X(str + i4);
                    }
                });
            }
            float f4 = ((float) j5) / 1000.0f;
            if (min > 0) {
                double d4 = f4;
                Double.isNaN(d4);
                if (d4 + 0.5d <= min - 1 || this.Es) {
                    return;
                }
                q qVar2 = q.this;
                if (q.a(qVar2, qVar2.mAdInfo)) {
                    q.this.Di.kN();
                    this.Es = true;
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            q qVar = q.this;
            com.kwad.components.ad.splashscreen.d.a aVar = qVar.Di.Cr;
            if (aVar != null) {
                aVar.setAudioEnabled(qVar.El, false);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            if (q.this.Em) {
                return;
            }
            q.this.Di.kD();
            com.kwad.components.ad.splashscreen.d.a aVar = q.this.Di.Cr;
            if (aVar != null) {
                aVar.ae(true);
                q qVar = q.this;
                qVar.Di.Cr.setAudioEnabled(qVar.El, true);
            }
            q.b(q.this, true);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
        }
    };

    private static boolean u(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.b.a.cw(adInfo);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.kwad.components.ad.k.b, com.kwad.components.ad.splashscreen.d.a] */
    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        ?? r02 = this.Di.Cr;
        if (r02 != 0) {
            r02.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.kwad.components.ad.k.b, com.kwad.components.ad.splashscreen.d.a] */
    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        int i4;
        super.aj();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate);
        DetailVideoView detailVideoView = (DetailVideoView) this.Di.mRootContainer.findViewById(R.id.ksad_splash_video_player);
        detailVideoView.setVisibility(0);
        if (com.kwad.sdk.core.response.b.a.dg(this.mAdInfo)) {
            a(detailVideoView);
        }
        ?? r02 = this.Di.Cr;
        if (r02 != 0) {
            r02.a(this.Ep);
        }
        this.Di.Ct.a(this);
        AdBaseFrameLayout adBaseFrameLayout = this.Di.mRootContainer;
        if (com.kwad.components.ad.splashscreen.e.c.z(this.mAdInfo)) {
            i4 = R.id.ksad_splash_skip_right_view;
        } else {
            i4 = R.id.ksad_splash_skip_left_view;
        }
        this.Eo = (SkipView) adBaseFrameLayout.findViewById(i4);
        if (u(this.mAdInfo)) {
            a(this.Eo, this.mAdInfo);
        }
        int i5 = this.mAdInfo.adSplashInfo.mute;
        if (i5 == 2) {
            this.El = true;
        } else if (i5 != 3) {
            this.El = false;
        } else {
            this.El = com.kwad.sdk.utils.k.cf(this.Di.mRootContainer.getContext()) > 0;
        }
        if (com.kwad.components.core.s.a.as(getContext()).rA()) {
            this.El = false;
        }
        com.kwad.components.ad.splashscreen.d.a aVar = this.Di.Cr;
        if (aVar != null) {
            aVar.setAudioEnabled(this.El, false);
            this.Di.Cr.a(this.hq);
        }
        this.hp = (ImageView) this.Di.mRootContainer.findViewById(R.id.ksad_splash_sound);
        if (com.kwad.components.ad.splashscreen.e.c.z(this.mAdInfo)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hp.getLayoutParams();
            layoutParams.gravity = 51;
            this.hp.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.hp.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(this.hp.getContext(), 32.0f);
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.hp.getContext(), 16.0f);
            }
        }
        this.hp.setVisibility(0);
        String str = this.El ? this.mAdInfo.adSplashInfo.speakerIconUrl : this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
        if (!TextUtils.isEmpty(str)) {
            KSImageLoader.loadImage(this.hp, str, this.Di.mAdTemplate);
        } else {
            this.hp.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
        }
        this.hp.setSelected(this.El);
        this.hp.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.q.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str2;
                q qVar = q.this;
                qVar.El = !qVar.El;
                if (q.this.El) {
                    str2 = q.this.mAdInfo.adSplashInfo.speakerIconUrl;
                } else {
                    str2 = q.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                }
                if (!TextUtils.isEmpty(str2)) {
                    KSImageLoader.loadImage(q.this.hp, str2, q.this.Di.mAdTemplate);
                } else {
                    q.this.hp.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                q.this.hp.setSelected(q.this.El);
                q qVar2 = q.this;
                qVar2.Di.Cr.setAudioEnabled(qVar2.El, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.En = true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.kwad.components.ad.k.b, com.kwad.components.ad.splashscreen.d.a] */
    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ?? r02 = this.Di.Cr;
        if (r02 != 0) {
            r02.b(this.Ep);
            this.Di.Cr.b(this.hq);
        }
        if (this.Eo.getHandler() != null) {
            this.Eo.getHandler().removeCallbacksAndMessages(null);
        }
        this.Di.Ct.b(this);
    }

    static /* synthetic */ boolean a(q qVar, AdInfo adInfo) {
        return u(adInfo);
    }

    static /* synthetic */ boolean b(q qVar, boolean z3) {
        qVar.Em = true;
        return true;
    }

    private void a(final DetailVideoView detailVideoView) {
        final View findViewById = findViewById(R.id.splash_play_card_view);
        findViewById.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.q.3
            @Override // java.lang.Runnable
            public final void run() {
                AdInfo.AdMaterialInfo.MaterialFeature aU;
                float height = findViewById.getHeight();
                if (findViewById.getWidth() <= 0.0f || height <= 0.0f) {
                    return;
                }
                if (com.kwad.sdk.core.response.b.a.aU(q.this.mAdInfo).videoWidth > 0) {
                    com.kwad.sdk.c.a.a.a(detailVideoView, aU.width, aU.height);
                }
            }
        });
    }

    private static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cz(adInfo));
    }
}
