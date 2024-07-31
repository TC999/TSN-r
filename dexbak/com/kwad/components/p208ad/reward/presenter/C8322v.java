package com.kwad.components.p208ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.reward.presenter.v */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8322v extends C8094b {

    /* renamed from: tA */
    private DetailVideoView f27453tA;

    /* renamed from: tB */
    private ViewGroup f27454tB;

    /* renamed from: tC */
    private FrameLayout f27455tC;

    /* renamed from: tD */
    private ImageView f27456tD;

    /* renamed from: tE */
    private ViewGroup.LayoutParams f27457tE = null;

    /* renamed from: gO */
    private C9002l f27452gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.v.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            C8322v.this.f27453tA.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    C8322v.this.f27453tA.setVisibility(0);
                }
            }, 200L);
        }
    };

    /* renamed from: O */
    private void m31008O(@LayoutRes int i) {
        this.f27455tC.addView(C10887l.m24563a(getContext(), i, this.f27455tC, false), -1, -1);
    }

    /* renamed from: hK */
    private void m31006hK() {
        DevelopMangerComponents developMangerComponents = (DevelopMangerComponents) C9861c.m27501f(DevelopMangerComponents.class);
    }

    /* renamed from: hL */
    private void m31005hL() {
        AdInfo m25641dQ = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
        getContext();
        boolean z = !C11015ai.m24123LZ();
        boolean m25900bH = C10483a.m25900bH(m25641dQ);
        boolean z2 = C10483a.m25850cD(m25641dQ) && C7844b.m32192gC();
        boolean z3 = C7907g.m32065E(this.f26957qo.mAdTemplate) || C7907g.m32063F(this.f26957qo.mAdTemplate) || m25900bH || z2;
        if (z && z3) {
            this.f27454tB.setVisibility(z2 ? 4 : 0);
            if (m25900bH) {
                this.f27456tD.setVisibility(8);
                m31008O(C9659R.C9663layout.ksad_playable_end_info);
            } else {
                m31008O(C9659R.C9663layout.ksad_activity_apk_info_landscape);
            }
            if (!C10483a.m25937aY(m25641dQ)) {
                this.f27453tA.updateTextureViewGravity(17);
                return;
            } else {
                this.f27453tA.updateTextureViewGravity(21);
                return;
            }
        }
        this.f27454tB.setVisibility(8);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m31006hK();
        ViewGroup.LayoutParams layoutParams = this.f27453tA.getLayoutParams();
        if (layoutParams != null) {
            this.f27457tE = new ViewGroup.LayoutParams(layoutParams);
        }
        this.f26957qo.f26529oJ.m31828a(this.f27452gO);
        m31005hL();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27453tA = (DetailVideoView) findViewById(C9659R.C9662id.ksad_video_player);
        this.f27454tB = (ViewGroup) findViewById(C9659R.C9662id.ksad_play_right_area);
        this.f27456tD = (ImageView) findViewById(C9659R.C9662id.ksad_play_right_area_bg_img);
        this.f27455tC = (FrameLayout) findViewById(C9659R.C9662id.ksad_play_right_area_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.f26957qo.f26529oJ.m31826b(this.f27452gO);
        if (this.f27457tE == null || (detailVideoView = this.f27453tA) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.LayoutParams layoutParams2 = this.f27457tE;
            layoutParams.width = layoutParams2.width;
            layoutParams.height = layoutParams2.height;
            this.f27453tA.setLayoutParams(layoutParams);
        }
        DetailVideoView detailVideoView2 = this.f27453tA;
        if (detailVideoView2 != null) {
            detailVideoView2.setVisibility(4);
        }
        this.f27457tE = null;
    }
}
