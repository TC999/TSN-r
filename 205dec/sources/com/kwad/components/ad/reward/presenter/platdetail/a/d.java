package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView hp;
    private ImageView vr;
    private h.a hq = new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (d.this.hp == null || com.kwad.components.ad.reward.a.b.gs()) {
                return;
            }
            d.this.hp.post(new ay() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    d.this.hp.setSelected(false);
                    d.this.qo.oJ.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.ad.reward.m.c vs = new com.kwad.components.ad.reward.m.c() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.2
        @Override // com.kwad.components.ad.reward.m.c
        public final void iq() {
            d.this.io();
        }
    };

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (com.kwad.components.ad.reward.g.G(r4.mAdTemplate) != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void ca() {
        /*
            r4 = this;
            boolean r0 = r4.hq()
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L11
            android.widget.ImageView r0 = r4.hp
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r4.vr
            goto L2d
        L11:
            android.widget.ImageView r0 = r4.hp
            com.kwad.sdk.core.response.model.AdTemplate r3 = r4.mAdTemplate
            boolean r3 = com.kwad.components.ad.reward.g.G(r3)
            if (r3 == 0) goto L1e
            r3 = 8
            goto L1f
        L1e:
            r3 = 0
        L1f:
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r4.vr
            com.kwad.sdk.core.response.model.AdTemplate r3 = r4.mAdTemplate
            boolean r3 = com.kwad.components.ad.reward.g.G(r3)
            if (r3 == 0) goto L2d
            goto L2f
        L2d:
            r1 = 8
        L2f:
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.presenter.platdetail.a.d.ca():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io() {
        g gVar = this.qo;
        KsVideoPlayConfig ksVideoPlayConfig = gVar.mVideoPlayConfig;
        boolean z3 = true;
        if (!gVar.oH && com.kwad.components.core.s.a.ah(getContext()).qW()) {
            this.vr.setSelected(true);
            this.qo.d(false, false);
            z3 = false;
        } else if (ksVideoPlayConfig != null) {
            z3 = ksVideoPlayConfig.isVideoSoundEnable();
            this.vr.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.qo.d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.vr.setSelected(true);
            this.qo.d(true, true);
        }
        this.hp.setSelected(z3);
        this.qo.oJ.setAudioEnabled(z3, false);
    }

    private void ip() {
        this.hp.setOnClickListener(this);
        this.vr.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.a(this.vs);
        this.qo.oJ.a(this.hq);
        ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView = this.hp;
        if (view == imageView) {
            this.qo.oJ.setAudioEnabled(!imageView.isSelected(), true);
            ImageView imageView2 = this.hp;
            imageView2.setSelected(!imageView2.isSelected());
            return;
        }
        ImageView imageView3 = this.vr;
        if (view == imageView3) {
            this.qo.oJ.setAudioEnabled(!imageView3.isSelected(), true);
            ImageView imageView4 = this.vr;
            imageView4.setSelected(!imageView4.isSelected());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hp = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.vr = (ImageView) findViewById(R.id.ksad_reward_deep_task_sound_switch);
        ip();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.hq);
        this.qo.b(this.vs);
    }
}
