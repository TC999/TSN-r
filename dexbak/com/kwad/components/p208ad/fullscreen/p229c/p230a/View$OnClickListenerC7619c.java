package com.kwad.components.p208ad.fullscreen.p229c.p230a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11096h;

/* renamed from: com.kwad.components.ad.fullscreen.c.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7619c extends C8094b implements View.OnClickListener {

    /* renamed from: hp */
    private ImageView f25878hp;

    /* renamed from: hq */
    private C11096h.InterfaceC11099a f25879hq = new C11096h.InterfaceC11099a() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1
        @Override // com.kwad.sdk.utils.C11096h.InterfaceC11099a
        public final void onAudioBeOccupied() {
            if (View$OnClickListenerC7619c.this.f25878hp == null || C7844b.m32186gs()) {
                return;
            }
            View$OnClickListenerC7619c.this.f25878hp.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    View$OnClickListenerC7619c.this.f25878hp.setSelected(false);
                    View$OnClickListenerC7619c.this.f26957qo.f26529oJ.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.C11096h.InterfaceC11099a
        public final void onAudioBeReleased() {
        }
    };

    /* renamed from: ca */
    private void m32761ca() {
        this.f25878hp.setVisibility(0);
        C7907g c7907g = this.f26957qo;
        KsVideoPlayConfig ksVideoPlayConfig = c7907g.mVideoPlayConfig;
        if (!c7907g.f26527oH && C8932a.m29575ah(getContext()).m29573qW()) {
            this.f25878hp.setSelected(false);
            this.f26957qo.m32017d(false, false);
        } else if (ksVideoPlayConfig != null) {
            this.f25878hp.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.f26957qo.m32017d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.f25878hp.setSelected(true);
            this.f26957qo.m32017d(true, true);
        }
        this.f26957qo.f26529oJ.m31827a(this.f25879hq);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m32761ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView = this.f25878hp;
        if (view == imageView) {
            this.f26957qo.f26529oJ.setAudioEnabled(!imageView.isSelected(), true);
            ImageView imageView2 = this.f25878hp;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(C9659R.C9662id.ksad_video_sound_switch);
        this.f25878hp = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31825b(this.f25879hq);
    }
}
