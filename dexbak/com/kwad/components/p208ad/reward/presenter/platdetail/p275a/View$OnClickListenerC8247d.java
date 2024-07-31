package com.kwad.components.p208ad.reward.presenter.platdetail.p275a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p263m.InterfaceC8020c;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11096h;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8247d extends C8094b implements View.OnClickListener {

    /* renamed from: hp */
    private ImageView f27243hp;

    /* renamed from: vr */
    private ImageView f27245vr;

    /* renamed from: hq */
    private C11096h.InterfaceC11099a f27244hq = new C11096h.InterfaceC11099a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1
        @Override // com.kwad.sdk.utils.C11096h.InterfaceC11099a
        public final void onAudioBeOccupied() {
            if (View$OnClickListenerC8247d.this.f27243hp == null || C7844b.m32186gs()) {
                return;
            }
            View$OnClickListenerC8247d.this.f27243hp.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    View$OnClickListenerC8247d.this.f27243hp.setSelected(false);
                    View$OnClickListenerC8247d.this.f26957qo.f26529oJ.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.C11096h.InterfaceC11099a
        public final void onAudioBeReleased() {
        }
    };

    /* renamed from: vs */
    private InterfaceC8020c f27246vs = new InterfaceC8020c() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.2
        @Override // com.kwad.components.p208ad.reward.p263m.InterfaceC8020c
        /* renamed from: iq */
        public final void mo31208iq() {
            View$OnClickListenerC8247d.this.m31210io();
        }
    };

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (com.kwad.components.p208ad.reward.C7907g.m32062G(r4.mAdTemplate) != false) goto L5;
     */
    /* renamed from: ca */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m31211ca() {
        /*
            r4 = this;
            boolean r0 = r4.m31612hq()
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L11
            android.widget.ImageView r0 = r4.f27243hp
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r4.f27245vr
            goto L2d
        L11:
            android.widget.ImageView r0 = r4.f27243hp
            com.kwad.sdk.core.response.model.AdTemplate r3 = r4.mAdTemplate
            boolean r3 = com.kwad.components.p208ad.reward.C7907g.m32062G(r3)
            if (r3 == 0) goto L1e
            r3 = 8
            goto L1f
        L1e:
            r3 = 0
        L1f:
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r4.f27245vr
            com.kwad.sdk.core.response.model.AdTemplate r3 = r4.mAdTemplate
            boolean r3 = com.kwad.components.p208ad.reward.C7907g.m32062G(r3)
            if (r3 == 0) goto L2d
            goto L2f
        L2d:
            r1 = 8
        L2f:
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.reward.presenter.platdetail.p275a.View$OnClickListenerC8247d.m31211ca():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io */
    public void m31210io() {
        C7907g c7907g = this.f26957qo;
        KsVideoPlayConfig ksVideoPlayConfig = c7907g.mVideoPlayConfig;
        boolean z = true;
        if (!c7907g.f26527oH && C8932a.m29575ah(getContext()).m29573qW()) {
            this.f27245vr.setSelected(true);
            this.f26957qo.m32017d(false, false);
            z = false;
        } else if (ksVideoPlayConfig != null) {
            z = ksVideoPlayConfig.isVideoSoundEnable();
            this.f27245vr.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.f26957qo.m32017d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.f27245vr.setSelected(true);
            this.f26957qo.m32017d(true, true);
        }
        this.f27243hp.setSelected(z);
        this.f26957qo.f26529oJ.setAudioEnabled(z, false);
    }

    /* renamed from: ip */
    private void m31209ip() {
        this.f27243hp.setOnClickListener(this);
        this.f27245vr.setOnClickListener(this);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26957qo.m32043a(this.f27246vs);
        this.f26957qo.f26529oJ.m31827a(this.f27244hq);
        m31211ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView = this.f27243hp;
        if (view == imageView) {
            this.f26957qo.f26529oJ.setAudioEnabled(!imageView.isSelected(), true);
            ImageView imageView2 = this.f27243hp;
            imageView2.setSelected(!imageView2.isSelected());
            return;
        }
        ImageView imageView3 = this.f27245vr;
        if (view == imageView3) {
            this.f26957qo.f26529oJ.setAudioEnabled(!imageView3.isSelected(), true);
            ImageView imageView4 = this.f27245vr;
            imageView4.setSelected(!imageView4.isSelected());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27243hp = (ImageView) findViewById(C9659R.C9662id.ksad_video_sound_switch);
        this.f27245vr = (ImageView) findViewById(C9659R.C9662id.ksad_reward_deep_task_sound_switch);
        m31209ip();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31825b(this.f27244hq);
        this.f26957qo.m32027b(this.f27246vs);
    }
}
