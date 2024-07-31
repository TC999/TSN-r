package com.kwad.components.p208ad.reward.presenter.p268d.p269a;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.C8874a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.p208ad.p247k.C7824b;
import com.kwad.components.p208ad.reward.C7845b;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7892l;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.p264n.C8059k;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.widget.tailframe.InterfaceC8348b;
import com.kwad.components.p208ad.reward.widget.tailframe.TailFrameView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.presenter.d.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8119b extends C8094b implements C9092aq.InterfaceC9095b {
    @Nullable

    /* renamed from: ci */
    private C7824b f27003ci;
    private AdInfo mAdInfo;
    private DetailVideoView mDetailVideoView;

    /* renamed from: vC */
    private TailFrameView f27005vC;

    /* renamed from: vD */
    private volatile boolean f27006vD;

    /* renamed from: vE */
    private boolean f27007vE;

    /* renamed from: vF */
    private C8059k f27008vF;

    /* renamed from: vI */
    private Drawable f27011vI;

    /* renamed from: sR */
    private boolean f27004sR = false;

    /* renamed from: vG */
    private int f27009vG = Integer.MIN_VALUE;

    /* renamed from: vH */
    private int f27010vH = Integer.MIN_VALUE;
    private final InterfaceC7892l mRewardVerifyListener = new InterfaceC7892l() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7892l
        public final void onRewardVerify() {
            C8119b.this.m31522iw();
            if (C8119b.this.f27005vC == null || !C7907g.m32062G(C8119b.this.mAdTemplate)) {
                return;
            }
            C8119b.this.f27005vC.m30931jQ();
        }
    };
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.2
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            if ((!C10487e.m25628ed(C8119b.this.mAdTemplate) && C8119b.this.f27004sR && !C8119b.this.f26957qo.m32007fH()) || C8119b.this.f26957qo.f26561pj || C8119b.this.f26957qo.f26567pp) {
                return;
            }
            C8119b.this.f27007vE = true;
            if (C8119b.this.f27003ci != null && C8119b.this.f27003ci.m32217ar()) {
                C8119b.this.f27007vE = false;
            }
            C8119b.this.f26957qo.f26546pA = true ^ C8119b.this.f27007vE;
            if (C8119b.this.f27007vE) {
                if (C8119b.this.f26957qo.f26533oN != null) {
                    C8032c.m31773a(C8119b.this.f26957qo.mAdTemplate, C8119b.this.f26957qo.f26544oY, "end_card", C10484b.m25743cy(C8119b.this.mAdTemplate), System.currentTimeMillis() - C8119b.this.f26957qo.f26533oN.getLoadTime(), 1);
                }
                C8119b.this.m31532aI();
            }
        }

        @Override // com.kwad.components.p208ad.reward.p252e.AbstractC7880a, com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        public final int getPriority() {
            return -1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m31536K(boolean z) {
        C7955b.m31927a(this.mAdTemplate, "native_id", (String) null, new C9913b().m27247f(this.f26957qo.mRootContainer.getTouchCoords()).m27266cK(z ? 2 : 153), this.f26957qo.mReportExtData);
        this.f26957qo.f26528oI.mo32088bJ();
    }

    /* renamed from: P */
    private void m31535P(int i) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aI */
    public void m31532aI() {
        m31522iw();
        this.f27005vC.m30933a(new InterfaceC8348b() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.3
            @Override // com.kwad.components.p208ad.reward.widget.tailframe.InterfaceC8348b
            /* renamed from: N */
            public final void mo30917N(boolean z) {
                C8119b.this.m31536K(z);
            }
        });
        this.f27005vC.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iw */
    public void m31522iw() {
        if (this.f27006vD) {
            return;
        }
        m31521ix();
    }

    /* renamed from: ix */
    private void m31521ix() {
        C10331c.m26254d("RewardPlayEndNativeCardPresenter", "initTailView");
        this.f27005vC.m30934a(getContext(), this.f26957qo.mScreenOrientation == 0, m31519iz());
        this.f27006vD = true;
    }

    /* renamed from: iy */
    private void m31520iy() {
        if (this.f27007vE) {
            m31522iw();
            this.f27005vC.destroy();
            this.f27005vC.setVisibility(8);
            this.f27008vF.hide();
        }
    }

    /* renamed from: iz */
    private boolean m31519iz() {
        AdInfo.AdMaterialInfo.MaterialFeature m25938aX = C10483a.m25938aX(this.mAdInfo);
        return m25938aX.height > m25938aX.width;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C8874a c8874a = this.f26957qo.f26531oL;
        if (c8874a != null) {
            c8874a.m29699a(this);
        }
        this.mAdInfo = C10487e.m25641dQ(this.mAdTemplate);
        C7907g c7907g = this.f26957qo;
        this.f27003ci = c7907g.f26533oN;
        c7907g.m32034b(this.mPlayEndPageListener);
        C7845b.m32173fb().m32175a(this.mRewardVerifyListener);
        this.f27005vC.setCallerContext(this.f26957qo);
        ViewStub viewStub = (ViewStub) findViewById(C9659R.C9662id.ksad_playend_native_jinniu);
        if (viewStub != null) {
            this.f27008vF = new C8059k(this.f26957qo, viewStub);
            return;
        }
        this.f27008vF = new C8059k(this.f26957qo, (ViewGroup) findViewById(C9659R.C9662id.ksad_reward_jinniu_end_card_root));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27005vC = (TailFrameView) findViewById(C9659R.C9662id.ksad_video_tail_frame);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(C9659R.C9662id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C8874a c8874a = this.f26957qo.f26531oL;
        if (c8874a != null) {
            c8874a.m29690b(this);
        }
        C7845b.m32173fb().m32174b(this.mRewardVerifyListener);
        m31520iy();
        this.f26957qo.m32024c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i = this.f27010vH;
            if (i != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i);
            }
            C10331c.m26254d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.f27009vG);
            int i2 = this.f27009vG;
            if (i2 != Integer.MIN_VALUE) {
                m31535P(i2);
            }
            Drawable drawable = this.f27011vI;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
    /* renamed from: a */
    public final void mo28994a(C9092aq.C9094a c9094a) {
        this.f27004sR = c9094a.isSuccess();
    }
}
