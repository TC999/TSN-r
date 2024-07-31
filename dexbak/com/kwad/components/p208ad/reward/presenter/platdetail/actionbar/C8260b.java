package com.kwad.components.p208ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.p264n.C8074r;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8050h;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.p208ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.p208ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.p208ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8260b extends C8094b {
    @Nullable

    /* renamed from: cV */
    private ValueAnimator f27269cV;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    /* renamed from: oM */
    private RewardActionBarControl f27270oM;

    /* renamed from: sr */
    private KsLogoView f27271sr;
    @Nullable

    /* renamed from: uA */
    private ViewGroup f27273uA;
    @Nullable

    /* renamed from: uB */
    private ViewGroup f27274uB;

    /* renamed from: uC */
    private View$OnClickListenerC8050h f27275uC;

    /* renamed from: uD */
    private boolean f27276uD;

    /* renamed from: uu */
    private ActionBarAppLandscape f27279uu;

    /* renamed from: uv */
    private ActionBarAppPortrait f27280uv;

    /* renamed from: uw */
    private ActionBarH5 f27281uw;

    /* renamed from: uy */
    private boolean f27283uy;
    @Nullable

    /* renamed from: uz */
    private ViewGroup f27284uz;

    /* renamed from: ux */
    private boolean f27282ux = false;

    /* renamed from: sv */
    private final C9002l f27272sv = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8996g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            C8260b.this.f27276uD = true;
            if (!C10483a.m25842cL(C8260b.this.mAdInfo) || C8260b.this.f27274uB == null) {
                return;
            }
            C8260b.this.f27274uB.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            C8260b.this.f27276uD = false;
            if (!C10483a.m25842cL(C8260b.this.mAdInfo) || C8260b.this.f27274uB == null) {
                return;
            }
            C8260b.this.f27274uB.setVisibility(0);
        }
    };

    /* renamed from: uE */
    private RewardActionBarControl.InterfaceC8256b f27277uE = new RewardActionBarControl.InterfaceC8256b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
        @Override // com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.InterfaceC8256b
        /* renamed from: a */
        public final void mo31149a(boolean z, InterfaceC8259a interfaceC8259a) {
            C8260b.this.f27283uy = true;
            C8260b.this.m31177a(z, interfaceC8259a);
        }
    };

    /* renamed from: uF */
    private InterfaceC7886g f27278uF = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            C8260b.this.f27283uy = false;
            C8260b.this.m31182L(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m31182L(boolean z) {
        if (this.f27282ux) {
            this.f27282ux = false;
            this.f27271sr.setVisibility(8);
            ViewGroup viewGroup = this.f27284uz;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.f27274uB;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            if (!C10483a.m25956aF(this.mAdInfo)) {
                if (z) {
                    m31162g(this.f27281uw, C10751a.m24924a(getContext(), 90.0f));
                } else {
                    this.f27281uw.setVisibility(8);
                }
            } else if (this.f26957qo.mScreenOrientation == 1) {
                if (z) {
                    m31157hW();
                } else {
                    m31156hX();
                }
            } else if (z) {
                ActionBarAppPortrait actionBarAppPortrait = this.f27280uv;
                if (actionBarAppPortrait != null) {
                    m31162g(actionBarAppPortrait, C10751a.m24924a(getContext(), 90.0f));
                }
            } else {
                ActionBarAppPortrait actionBarAppPortrait2 = this.f27280uv;
                if (actionBarAppPortrait2 != null) {
                    actionBarAppPortrait2.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: aG */
    private void m31176aG() {
        ValueAnimator valueAnimator = this.f27269cV;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f27269cV.cancel();
        }
    }

    /* renamed from: ca */
    private void m31169ca() {
        if (C10483a.m25848cF(this.mAdInfo)) {
            this.f27284uz = (ViewGroup) findViewById(C9659R.C9662id.ksad_reward_jinniu_root);
        }
        this.f27271sr.m28912aD(this.mAdTemplate);
        C7907g c7907g = this.f26957qo;
        this.mApkDownloadHelper = c7907g.mApkDownloadHelper;
        RewardActionBarControl rewardActionBarControl = c7907g.f26532oM;
        this.f27270oM = rewardActionBarControl;
        rewardActionBarControl.m31202a(this.f27277uE);
        this.f26957qo.m32034b(this.f27278uF);
    }

    /* renamed from: hU */
    private void m31159hU() {
        ViewStub viewStub = (ViewStub) findViewById(C9659R.C9662id.view_stub_action_bar_landscape);
        if (viewStub != null) {
            this.f27279uu = (ActionBarAppLandscape) viewStub.inflate();
        } else {
            this.f27279uu = (ActionBarAppLandscape) findViewById(C9659R.C9662id.ksad_video_play_bar_app_landscape);
        }
    }

    /* renamed from: hV */
    private void m31158hV() {
        ViewStub viewStub = (ViewStub) findViewById(C9659R.C9662id.view_stub_action_bar);
        if (viewStub != null) {
            this.f27280uv = (ActionBarAppPortrait) viewStub.inflate();
        } else {
            this.f27280uv = (ActionBarAppPortrait) findViewById(C9659R.C9662id.ksad_video_play_bar_app_portrait);
        }
    }

    /* renamed from: hW */
    private void m31157hW() {
        m31158hV();
        m31164f(this.f27280uv, C10751a.m24924a(getContext(), 90.0f));
    }

    /* renamed from: hX */
    private void m31156hX() {
        ActionBarAppPortrait actionBarAppPortrait = this.f27280uv;
        if (actionBarAppPortrait != null) {
            actionBarAppPortrait.setVisibility(8);
        }
    }

    /* renamed from: M */
    protected final void m31181M(boolean z) {
        C9913b m27266cK = new C9913b().m27247f(this.f26957qo.mRootContainer.getTouchCoords()).m27266cK(z ? 1 : 153);
        C7907g c7907g = this.f26957qo;
        C7955b.m31927a(c7907g.mAdTemplate, "native_id", (String) null, m27266cK, c7907g.mReportExtData);
        this.f26957qo.f26528oI.mo32088bJ();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdTemplate adTemplate = this.f26957qo.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        this.f26957qo.f26529oJ.m31828a(this.f27272sv);
        m31169ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27271sr = (KsLogoView) findViewById(C9659R.C9662id.ksad_ad_label_play_bar);
        this.f27281uw = (ActionBarH5) findViewById(C9659R.C9662id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.f27270oM;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.m31202a((RewardActionBarControl.InterfaceC8256b) null);
        }
        this.f26957qo.f26529oJ.m31826b(this.f27272sv);
        this.f26957qo.m32024c(this.f27278uF);
        m31176aG();
    }

    /* renamed from: d */
    private void m31167d(boolean z, InterfaceC8259a interfaceC8259a) {
        this.f27281uw.m30942a(this.mAdTemplate, new ActionBarH5.InterfaceC8339a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            @Override // com.kwad.components.p208ad.reward.widget.actionbar.ActionBarH5.InterfaceC8339a
            /* renamed from: N */
            public final void mo30940N(boolean z2) {
                C8260b.this.m31181M(z2);
            }
        });
        if (z) {
            m31164f(this.f27281uw, C10751a.m24924a(getContext(), 90.0f));
        } else {
            this.f27281uw.setVisibility(0);
        }
        RewardActionBarControl.m31196a(interfaceC8259a, this.f27281uw, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    /* renamed from: e */
    private void m31166e(final View view, int i) {
        m31176aG();
        view.setVisibility(0);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ValueAnimator m29527c = C8951n.m29527c(view, i, 0);
        this.f27269cV = m29527c;
        m29527c.setInterpolator(create);
        this.f27269cV.setDuration(500L);
        this.f27269cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.f27269cV.start();
    }

    @Deprecated
    /* renamed from: f */
    private void m31164f(final View view, int i) {
        m31176aG();
        view.setVisibility(0);
        ValueAnimator m29528b = C8951n.m29528b(view, 0, i);
        this.f27269cV = m29528b;
        m29528b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f27269cV.setDuration(500L);
        this.f27269cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.f27269cV.start();
    }

    /* renamed from: g */
    private void m31162g(final View view, int i) {
        m31176aG();
        view.setVisibility(0);
        ValueAnimator m29528b = C8951n.m29528b(view, i, 0);
        this.f27269cV = m29528b;
        m29528b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f27269cV.setDuration(300L);
        this.f27269cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        this.f27269cV.start();
    }

    /* renamed from: b */
    private void m31173b(boolean z, InterfaceC8259a interfaceC8259a) {
        m31159hU();
        this.f27279uu.m30961a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.InterfaceC8334a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            @Override // com.kwad.components.p208ad.reward.widget.actionbar.ActionBarAppLandscape.InterfaceC8334a
            /* renamed from: N */
            public final void mo30954N(boolean z2) {
                C8260b.this.m31181M(z2);
            }
        });
        if (z) {
            m31164f(this.f27279uu, C10751a.m24924a(getContext(), 90.0f));
        } else {
            this.f27279uu.setVisibility(0);
        }
        RewardActionBarControl.m31196a(interfaceC8259a, this.f27279uu, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    /* renamed from: c */
    private void m31170c(boolean z, InterfaceC8259a interfaceC8259a) {
        m31158hV();
        this.f27280uv.m30952a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.InterfaceC8337a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            @Override // com.kwad.components.p208ad.reward.widget.actionbar.ActionBarAppPortrait.InterfaceC8337a
            /* renamed from: N */
            public final void mo30945N(boolean z2) {
                C8260b.this.m31181M(z2);
            }
        });
        if (z) {
            m31164f(this.f27280uv, C10751a.m24924a(getContext(), 90.0f));
        } else {
            this.f27280uv.setVisibility(0);
        }
        RewardActionBarControl.m31196a(interfaceC8259a, this.f27280uv, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m31177a(boolean z, InterfaceC8259a interfaceC8259a) {
        ViewGroup viewGroup;
        if (this.f27282ux) {
            return;
        }
        this.f27282ux = true;
        this.f27271sr.setVisibility(C10483a.m25842cL(this.mAdInfo) ? 8 : 0);
        getContext();
        final boolean z2 = !C11015ai.m24123LZ();
        if (C10483a.m25876bd(this.mAdInfo)) {
            if (this.f27275uC == null) {
                View$OnClickListenerC8050h view$OnClickListenerC8050h = new View$OnClickListenerC8050h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
                    @Override // com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8050h
                    /* renamed from: hY */
                    public final int mo31148hY() {
                        if (z2) {
                            return C9659R.C9662id.ksad_common_app_card_land_stub;
                        }
                        return super.mo31148hY();
                    }
                };
                this.f27275uC = view$OnClickListenerC8050h;
                view$OnClickListenerC8050h.m31708a(new View$OnClickListenerC8050h.InterfaceC8051a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
                    @Override // com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8050h.InterfaceC8051a
                    /* renamed from: hZ */
                    public final void mo31147hZ() {
                        C8260b.this.f26957qo.m32060a(1, C8260b.this.getContext(), 29, 1);
                    }

                    @Override // com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8050h.InterfaceC8051a
                    /* renamed from: ia */
                    public final void mo31146ia() {
                        C8260b.this.f26957qo.m32060a(1, C8260b.this.getContext(), 30, 2);
                    }

                    @Override // com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8050h.InterfaceC8051a
                    /* renamed from: ib */
                    public final void mo31145ib() {
                        C8260b.this.f26957qo.m32060a(1, C8260b.this.getContext(), 31, 2);
                    }

                    @Override // com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8050h.InterfaceC8051a
                    /* renamed from: ic */
                    public final void mo31144ic() {
                        C8260b.this.f26957qo.m32060a(1, C8260b.this.getContext(), 32, 2);
                    }

                    @Override // com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8050h.InterfaceC8051a
                    /* renamed from: id */
                    public final void mo31143id() {
                        C8260b.this.f26957qo.m32060a(1, C8260b.this.getContext(), 84, 2);
                    }

                    @Override // com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8050h.InterfaceC8051a
                    /* renamed from: ie */
                    public final void mo31142ie() {
                        C8260b.this.f26957qo.m32060a(1, C8260b.this.getContext(), 53, 2);
                    }
                });
                this.f27275uC.m31707f((ViewGroup) getRootView());
                this.f27275uC.m31726b(C8074r.m31646a(this.mAdTemplate, this.mApkDownloadHelper));
            }
            this.f27275uC.show();
            RewardActionBarControl.m31196a(interfaceC8259a, this.f27275uC.mo31643gF(), RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        } else if (C10483a.m25881bZ(this.mAdInfo) == 1 && (viewGroup = this.f27284uz) != null) {
            viewGroup.setVisibility(0);
            RewardActionBarControl.m31196a(interfaceC8259a, this.f27284uz, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU);
        } else {
            if (C10483a.m25842cL(this.mAdInfo)) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(C9659R.C9662id.ksad_reward_origin_live_root);
                this.f27274uB = viewGroup2;
                if (viewGroup2 != null) {
                    if (!this.f27276uD) {
                        viewGroup2.setVisibility(0);
                    }
                    RewardActionBarControl.m31196a(interfaceC8259a, this.f27274uB, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORIGIN_LIVE);
                    return;
                }
            }
            if (C10483a.m25824cb(this.mAdTemplate)) {
                ViewGroup viewGroup3 = (ViewGroup) findViewById(C9659R.C9662id.ksad_reward_live_subscribe_root);
                this.f27273uA = viewGroup3;
                if (viewGroup3 != null) {
                    Resources resources = viewGroup3.getResources();
                    m31166e(this.f27273uA, (int) (resources.getDimension(C9659R.dimen.ksad_live_subscribe_card_full_height) + resources.getDimension(C9659R.dimen.ksad_live_subscribe_card_margin)));
                    RewardActionBarControl.m31196a(interfaceC8259a, this.f27273uA, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE);
                    return;
                }
            }
            if (C10483a.m25956aF(this.mAdInfo)) {
                if (this.f26957qo.mScreenOrientation == 1) {
                    m31173b(z, interfaceC8259a);
                    return;
                } else {
                    m31170c(z, interfaceC8259a);
                    return;
                }
            }
            m31167d(z, interfaceC8259a);
        }
    }
}
