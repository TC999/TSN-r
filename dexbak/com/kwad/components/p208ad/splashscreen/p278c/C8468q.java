package com.kwad.components.p208ad.splashscreen.p278c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.p277b.C8363a;
import com.kwad.components.p208ad.splashscreen.p283e.C8478a;
import com.kwad.components.p208ad.splashscreen.p284f.C8486c;
import com.kwad.components.p208ad.splashscreen.widget.SkipView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11096h;
import com.kwad.sdk.utils.C11102k;

/* renamed from: com.kwad.components.ad.splashscreen.c.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8468q extends C8421e implements InterfaceC10385c {

    /* renamed from: Ei */
    private SkipView f27830Ei;

    /* renamed from: hp */
    private ImageView f27832hp;
    private AdInfo mAdInfo;

    /* renamed from: Ef */
    private volatile boolean f27827Ef = false;

    /* renamed from: Eg */
    private boolean f27828Eg = false;

    /* renamed from: Eh */
    private boolean f27829Eh = false;

    /* renamed from: hq */
    private C11096h.InterfaceC11099a f27833hq = new C11096h.InterfaceC11099a() { // from class: com.kwad.components.ad.splashscreen.c.q.1
        @Override // com.kwad.sdk.utils.C11096h.InterfaceC11099a
        public final void onAudioBeOccupied() {
            C8468q.this.f27827Ef = false;
            if (C8468q.this.f27832hp != null) {
                C8468q.this.f27832hp.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.q.1.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C8468q c8468q = C8468q.this;
                        C8478a c8478a = c8468q.f27734Dg.f27879Cq;
                        if (c8478a != null) {
                            c8478a.setAudioEnabled(c8468q.f27827Ef, false);
                        }
                        C8489h c8489h = C8468q.this.f27734Dg;
                        if (c8489h != null) {
                            AdInfo m25641dQ = C10487e.m25641dQ(c8489h.mAdTemplate);
                            boolean z = C8468q.this.f27827Ef;
                            AdInfo.AdSplashInfo adSplashInfo = m25641dQ.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (!TextUtils.isEmpty(str)) {
                                KSImageLoader.loadImage(C8468q.this.f27832hp, str, C8468q.this.f27734Dg.mAdTemplate);
                            } else {
                                C8468q.this.f27832hp.setImageDrawable(C8468q.this.getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_splash_sound_selector));
                            }
                            C8468q.this.f27832hp.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.C11096h.InterfaceC11099a
        public final void onAudioBeReleased() {
        }
    };

    /* renamed from: Ej */
    private InterfaceC9001k f27831Ej = new C9002l() { // from class: com.kwad.components.ad.splashscreen.c.q.2

        /* renamed from: Em */
        private boolean f27837Em = false;

        /* renamed from: En */
        private String f27838En = C10251d.m26522a(C8363a.f27625CN);

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            if (this.f27837Em) {
                return;
            }
            C8468q.this.f27734Dg.m30604kM();
            this.f27837Em = true;
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayError(int i, int i2) {
            if (C8468q.this.f27829Eh) {
                return;
            }
            C8468q.this.f27734Dg.m30616i(0, "onMediaPlayError");
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayPaused() {
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, final long j2) {
            C8468q.this.f27734Dg.m30625X(((int) j2) / 1000);
            final int min = Math.min(C8468q.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j) / 1000);
            final String str = this.f27838En;
            C8468q c8468q = C8468q.this;
            if (C8468q.m30674a(c8468q, c8468q.mAdInfo)) {
                C8468q.this.f27830Ei.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.q.2.1
                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        int i = (int) (((min * 1000) - j2) / 1000);
                        if (i <= 0) {
                            i = 1;
                        }
                        C8468q.this.f27830Ei.m30495W(str + i);
                    }
                });
            }
            float f = ((float) j2) / 1000.0f;
            if (min > 0) {
                double d = f;
                Double.isNaN(d);
                if (d + 0.5d <= min - 1 || this.f27837Em) {
                    return;
                }
                C8468q c8468q2 = C8468q.this;
                if (C8468q.m30674a(c8468q2, c8468q2.mAdInfo)) {
                    C8468q.this.f27734Dg.m30604kM();
                    this.f27837Em = true;
                }
            }
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            C8468q c8468q = C8468q.this;
            C8478a c8478a = c8468q.f27734Dg.f27879Cq;
            if (c8478a != null) {
                c8478a.setAudioEnabled(c8468q.f27827Ef, false);
            }
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlaying() {
            if (C8468q.this.f27828Eg) {
                return;
            }
            C8468q.this.f27734Dg.m30614kC();
            C8478a c8478a = C8468q.this.f27734Dg.f27879Cq;
            if (c8478a != null) {
                c8478a.m30647ae(true);
                C8468q c8468q = C8468q.this;
                c8468q.f27734Dg.f27879Cq.setAudioEnabled(c8468q.f27827Ef, true);
            }
            C8468q.m30670b(C8468q.this, true);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC9001k
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC9001k
        public final void onVideoPlayBufferingPlaying() {
        }
    };

    /* renamed from: u */
    private static boolean m30663u(AdInfo adInfo) {
        return !C10483a.m25804cv(adInfo);
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        C8478a c8478a = this.f27734Dg.f27879Cq;
        if (c8478a != null) {
            c8478a.pause();
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.mAdInfo = C10487e.m25641dQ(this.f27734Dg.mAdTemplate);
        ((DetailVideoView) this.f27734Dg.mRootContainer.findViewById(C9659R.C9662id.ksad_splash_video_player)).setVisibility(0);
        C8478a c8478a = this.f27734Dg.f27879Cq;
        if (c8478a != null) {
            c8478a.mo31843b(this.f27831Ej);
        }
        this.f27734Dg.f27881Cs.mo26187a(this);
        this.f27830Ei = (SkipView) this.f27734Dg.mRootContainer.findViewById(C8486c.m30630z(this.mAdInfo) ? C9659R.C9662id.ksad_splash_skip_right_view : C9659R.C9662id.ksad_splash_skip_left_view);
        if (m30663u(this.mAdInfo)) {
            m30672a(this.f27830Ei, this.mAdInfo);
        }
        int i = this.mAdInfo.adSplashInfo.mute;
        if (i == 2) {
            this.f27827Ef = true;
        } else if (i != 3) {
            this.f27827Ef = false;
        } else {
            this.f27827Ef = C11102k.m23778bS(this.f27734Dg.mRootContainer.getContext()) > 0;
        }
        if (C8932a.m29575ah(getContext()).m29573qW()) {
            this.f27827Ef = false;
        }
        C8478a c8478a2 = this.f27734Dg.f27879Cq;
        if (c8478a2 != null) {
            c8478a2.setAudioEnabled(this.f27827Ef, false);
            this.f27734Dg.f27879Cq.m30649a(this.f27833hq);
        }
        this.f27832hp = (ImageView) this.f27734Dg.mRootContainer.findViewById(C9659R.C9662id.ksad_splash_sound);
        if (C8486c.m30630z(this.mAdInfo)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f27832hp.getLayoutParams();
            layoutParams.gravity = 51;
            this.f27832hp.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.f27832hp.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.topMargin = C10751a.m24924a(this.f27832hp.getContext(), 32.0f);
                marginLayoutParams.leftMargin = C10751a.m24924a(this.f27832hp.getContext(), 16.0f);
            }
        }
        this.f27832hp.setVisibility(0);
        String str = this.f27827Ef ? this.mAdInfo.adSplashInfo.speakerIconUrl : this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
        if (!TextUtils.isEmpty(str)) {
            KSImageLoader.loadImage(this.f27832hp, str, this.f27734Dg.mAdTemplate);
        } else {
            this.f27832hp.setImageDrawable(getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_splash_sound_selector));
        }
        this.f27832hp.setSelected(this.f27827Ef);
        this.f27832hp.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.q.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str2;
                C8468q c8468q = C8468q.this;
                c8468q.f27827Ef = !c8468q.f27827Ef;
                if (C8468q.this.f27827Ef) {
                    str2 = C8468q.this.mAdInfo.adSplashInfo.speakerIconUrl;
                } else {
                    str2 = C8468q.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                }
                if (!TextUtils.isEmpty(str2)) {
                    KSImageLoader.loadImage(C8468q.this.f27832hp, str2, C8468q.this.f27734Dg.mAdTemplate);
                } else {
                    C8468q.this.f27832hp.setImageDrawable(C8468q.this.getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_splash_sound_selector));
                }
                C8468q.this.f27832hp.setSelected(C8468q.this.f27827Ef);
                C8468q c8468q2 = C8468q.this;
                c8468q2.f27734Dg.f27879Cq.setAudioEnabled(c8468q2.f27827Ef, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.f27829Eh = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C8478a c8478a = this.f27734Dg.f27879Cq;
        if (c8478a != null) {
            c8478a.mo31844a(this.f27831Ej);
            this.f27734Dg.f27879Cq.m30645b(this.f27833hq);
        }
        if (this.f27830Ei.getHandler() != null) {
            this.f27830Ei.getHandler().removeCallbacksAndMessages(null);
        }
        this.f27734Dg.f27881Cs.mo26186b(this);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m30674a(C8468q c8468q, AdInfo adInfo) {
        return m30663u(adInfo);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m30670b(C8468q c8468q, boolean z) {
        c8468q.f27828Eg = true;
        return true;
    }

    /* renamed from: a */
    private static void m30672a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(C10483a.m25801cy(adInfo));
    }
}
