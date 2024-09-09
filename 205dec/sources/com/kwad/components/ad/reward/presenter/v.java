package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class v extends b {
    private DetailVideoView tA;
    private ViewGroup tB;
    private FrameLayout tC;
    private ImageView tD;
    private ViewGroup.LayoutParams tE = null;
    private com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.v.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            v.this.tA.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    v.this.tA.setVisibility(0);
                }
            }, 200L);
        }
    };

    private void O(@LayoutRes int i4) {
        this.tC.addView(com.kwad.sdk.n.l.a(getContext(), i4, this.tC, false), -1, -1);
    }

    private void hK() {
        DevelopMangerComponents developMangerComponents = (DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
    }

    private void hL() {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
        getContext();
        boolean z3 = !ai.LZ();
        boolean bH = com.kwad.sdk.core.response.b.a.bH(dQ);
        boolean z4 = com.kwad.sdk.core.response.b.a.cD(dQ) && com.kwad.components.ad.reward.a.b.gC();
        boolean z5 = com.kwad.components.ad.reward.g.E(this.qo.mAdTemplate) || com.kwad.components.ad.reward.g.F(this.qo.mAdTemplate) || bH || z4;
        if (z3 && z5) {
            this.tB.setVisibility(z4 ? 4 : 0);
            if (bH) {
                this.tD.setVisibility(8);
                O(R.layout.ksad_playable_end_info);
            } else {
                O(R.layout.ksad_activity_apk_info_landscape);
            }
            if (!com.kwad.sdk.core.response.b.a.aY(dQ)) {
                this.tA.updateTextureViewGravity(17);
                return;
            } else {
                this.tA.updateTextureViewGravity(21);
                return;
            }
        }
        this.tB.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        hK();
        ViewGroup.LayoutParams layoutParams = this.tA.getLayoutParams();
        if (layoutParams != null) {
            this.tE = new ViewGroup.LayoutParams(layoutParams);
        }
        this.qo.oJ.a(this.gO);
        hL();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tA = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.tB = (ViewGroup) findViewById(R.id.ksad_play_right_area);
        this.tD = (ImageView) findViewById(R.id.ksad_play_right_area_bg_img);
        this.tC = (FrameLayout) findViewById(R.id.ksad_play_right_area_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.qo.oJ.b(this.gO);
        if (this.tE == null || (detailVideoView = this.tA) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.LayoutParams layoutParams2 = this.tE;
            layoutParams.width = layoutParams2.width;
            layoutParams.height = layoutParams2.height;
            this.tA.setLayoutParams(layoutParams);
        }
        DetailVideoView detailVideoView2 = this.tA;
        if (detailVideoView2 != null) {
            detailVideoView2.setVisibility(4);
        }
        this.tE = null;
    }
}
