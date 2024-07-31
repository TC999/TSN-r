package com.kwad.components.p208ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.presenter.RewardPreEndCardPresenter;
import com.kwad.components.core.p298i.C8665a;
import com.kwad.components.core.p298i.C8674c;
import com.kwad.components.core.p298i.C8676e;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.C9182w;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.p247k.C7824b;
import com.kwad.components.p208ad.reward.C7872d;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p392d.C10274a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.presenter.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8301s extends C8094b implements InterfaceC7886g, C8665a.InterfaceC8672a, C9182w.InterfaceC9184b {
    @Nullable

    /* renamed from: oP */
    private C7872d f27390oP;

    /* renamed from: sc */
    private ImageView f27391sc;

    /* renamed from: td */
    private View f27393td;

    /* renamed from: te */
    private KsLogoView f27394te;

    /* renamed from: tf */
    private DetailVideoView f27395tf;

    /* renamed from: tg */
    private int f27396tg;

    /* renamed from: th */
    private View f27397th;

    /* renamed from: ti */
    private FrameLayout f27398ti;

    /* renamed from: tj */
    private Animator f27399tj;

    /* renamed from: tk */
    private Animator f27400tk;

    /* renamed from: tl */
    private Animator f27401tl;

    /* renamed from: tm */
    private AdTemplate f27402tm;

    /* renamed from: tn */
    private List<C8674c> f27403tn;

    /* renamed from: tv */
    private boolean f27411tv;
    @RewardPreEndCardPresenter.PreEndPageStatus

    /* renamed from: tc */
    private int f27392tc = 1;

    /* renamed from: to */
    private long f27404to = 500;

    /* renamed from: tp */
    private long f27405tp = 50;

    /* renamed from: tq */
    private float f27406tq = 1.2254902f;

    /* renamed from: tr */
    private float f27407tr = 0.80472106f;

    /* renamed from: ts */
    private float f27408ts = 0.0f;

    /* renamed from: tt */
    private boolean f27409tt = false;
    private long showTime = -1;

    /* renamed from: tu */
    private long f27410tu = -1;

    /* renamed from: gO */
    private C9002l f27389gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            C8301s.this.m31030g(j2);
        }
    };

    /* renamed from: cR */
    private InterfaceC10635a f27388cR = new InterfaceC10635a() { // from class: com.kwad.components.ad.reward.presenter.s.5
        @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
        /* renamed from: a */
        public final void mo25245a(C10640a c10640a) {
            if (c10640a != null && !C10487e.m25650c(C8301s.this.mAdTemplate, c10640a.creativeId, c10640a.adStyle)) {
                C8674c m32039a = C7907g.m32039a(C8301s.this.f27403tn, c10640a.creativeId);
                if (m32039a != null) {
                    C8301s.this.f26957qo.m32041a(m32039a);
                    return;
                }
                return;
            }
            C8301s.this.f26957qo.f26528oI.mo32088bJ();
        }
    };

    /* renamed from: I */
    private boolean m31042I(boolean z) {
        int m31034b = m31034b(m31028hH());
        m31040N(m31034b);
        C7872d c7872d = this.f27390oP;
        boolean m32217ar = c7872d != null ? c7872d.m32217ar() : false;
        C10331c.m26254d("RewardPreEndCardPresenter", "webLoadSuccess: " + m32217ar);
        if (m32217ar) {
            int m31039a = m31039a(m31028hH());
            float f = -m31034b;
            this.f27408ts = f;
            Animator m31035a = m31035a(true, f, m31039a, true, z);
            this.f27399tj = m31035a;
            m31035a.start();
            Animator m31029hG = m31029hG();
            this.f27401tl = m31029hG;
            m31029hG.start();
            this.f27392tc = 2;
            return true;
        }
        return false;
    }

    /* renamed from: J */
    private void m31041J(boolean z) {
        Animator m31035a = m31035a(false, (m31028hH() - m31027hI()) + this.f27408ts, m31039a(m31027hI()), false, z);
        this.f27400tk = m31035a;
        m31035a.start();
        C10274a.m26475DF();
        C10274a.m26468bU(this.f27402tm);
        this.f27392tc = 3;
        C7872d c7872d = this.f27390oP;
        if (c7872d != null) {
            c7872d.m32114fl();
        }
    }

    /* renamed from: N */
    private void m31040N(int i) {
        ViewGroup.LayoutParams layoutParams = this.f27393td.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = -i;
            return;
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
        layoutParams3.height = i;
        layoutParams3.bottomMargin = -i;
        this.f27393td.setLayoutParams(layoutParams3);
    }

    /* renamed from: f */
    private void m31031f(List<AdTemplate> list) {
        C7872d c7872d = new C7872d(list, this.f26957qo.mReportExtData, this);
        this.f27390oP = c7872d;
        this.f26957qo.f26535oP = c7872d;
        c7872d.setShowLandingPage(C10484b.m25748ct(this.mAdTemplate));
        this.f27390oP.m32220a(this.f27388cR);
        C7872d c7872d2 = this.f27390oP;
        FrameLayout frameLayout = this.f27398ti;
        C7907g c7907g = this.f26957qo;
        c7872d2.mo32119a(frameLayout, c7907g.mRootContainer, this.mAdTemplate, c7907g.mApkDownloadHelper, c7907g.mScreenOrientation);
        C10331c.m26254d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.f27390oP.m32223a(new C7824b.InterfaceC7829b() { // from class: com.kwad.components.ad.reward.presenter.s.2
            @Override // com.kwad.components.p208ad.p247k.C7824b.InterfaceC7829b
            /* renamed from: hJ */
            public final void mo31026hJ() {
                C10331c.m26254d("RewardPreEndCardPresenter", "onPreloadSuccess");
                C8301s.this.f26957qo.f26567pp = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m31030g(long j) {
        AdTemplate adTemplate = this.f27402tm;
        if (adTemplate == null || this.f27411tv) {
            return;
        }
        if (this.showTime <= 0) {
            this.showTime = C10484b.m25751cq(adTemplate);
            this.f27410tu = C10484b.m25752cp(this.f27402tm) + this.showTime;
        }
        long j2 = this.showTime;
        if (j2 > 0 && !this.f27409tt && j > j2) {
            this.f27411tv = !m31042I(true);
            C10331c.m26254d("RewardPreEndCardPresenter", "showError: " + this.f27411tv);
            if (this.f27411tv) {
                return;
            }
            this.f27409tt = true;
        }
        boolean z = this.f27392tc == 3;
        long j3 = this.f27410tu;
        if (j3 <= 0 || z || j <= j3) {
            return;
        }
        m31041J(true);
    }

    /* renamed from: hG */
    private Animator m31029hG() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f27397th, "alpha", 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    /* renamed from: hH */
    private float m31028hH() {
        return C10751a.m24913d(getActivity()) / this.f27406tq;
    }

    /* renamed from: hI */
    private float m31027hI() {
        return C10751a.m24913d(getActivity()) / this.f27407tr;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26957qo.f26529oJ.m31828a(this.f27389gO);
        this.f26957qo.m32034b((InterfaceC7886g) this);
        this.f26957qo.m32042a(this);
        this.f27396tg = C10751a.m24925F(this.f27395tf);
        C10751a.m24906n(this.f27395tf, 49);
        this.f27394te.m28912aD(this.mAdTemplate);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    /* renamed from: bL */
    public final void mo31009bL() {
        int i;
        if (this.f27402tm == null || (i = this.f27392tc) == 3) {
            return;
        }
        if (i == 1) {
            m31042I(false);
            m31041J(false);
        } else if (i == 2) {
            m31041J(true);
        }
    }

    @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
    /* renamed from: e */
    public final void mo30038e(@Nullable List<C8674c> list) {
        C10331c.m26254d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list == null || list.size() == 0) {
            return;
        }
        this.f27402tm = list.get(0).getAdTemplate();
        this.f27403tn = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAdTemplate);
        arrayList.addAll(C8674c.m30037m(list));
        m31031f(arrayList);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27393td = findViewById(C9659R.C9662id.ksad_middle_end_card);
        this.f27395tf = (DetailVideoView) findViewById(C9659R.C9662id.ksad_video_player);
        this.f27394te = (KsLogoView) findViewById(C9659R.C9662id.ksad_splash_logo_container);
        this.f27391sc = (ImageView) findViewById(C9659R.C9662id.ksad_blur_video_cover);
        this.f27397th = findViewById(C9659R.C9662id.ksad_play_web_card_webView);
        this.f27398ti = (FrameLayout) findViewById(C9659R.C9662id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
    public final void onError(int i, String str) {
        C10331c.m26246w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
    public final void onRequestResult(int i) {
        C10331c.m26246w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C7907g c7907g = this.f26957qo;
        c7907g.f26567pp = false;
        c7907g.f26529oJ.m31826b(this.f27389gO);
        this.f26957qo.m32024c(this);
        this.f26957qo.m32026b((C8665a.InterfaceC8672a) this);
        C7872d c7872d = this.f27390oP;
        if (c7872d != null) {
            c7872d.m32213lW();
        }
        Animator animator = this.f27401tl;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.f27395tf;
        if (detailVideoView != null) {
            C10751a.m24906n(detailVideoView, this.f27396tg);
        }
        Animator animator2 = this.f27399tj;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.f27401tl = null;
        this.f27399tj = null;
    }

    /* renamed from: b */
    private int m31034b(float f) {
        return (int) (f + getContext().getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    /* renamed from: a */
    private Animator m31035a(boolean z, float f, int i, boolean z2, boolean z3) {
        ValueAnimator ofFloat;
        C10331c.m26254d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f + ", videoTargetHeight: " + i);
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(this.f27393td, "translationY", f);
        } else {
            int height = this.f27393td.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.f27393td.getLayoutParams();
            ofFloat = ValueAnimator.ofFloat(height, Math.abs(f));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    C8301s.this.f27393td.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator ofFloat2 = z2 ? ObjectAnimator.ofFloat(this.f27394te, "alpha", 0.0f, 255.0f) : null;
        final ViewGroup.LayoutParams layoutParams2 = this.f27391sc.getLayoutParams();
        ValueAnimator m29520a = this.f27395tf.m29520a(this.mAdTemplate, i, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    C8301s.this.f27391sc.setLayoutParams(layoutParams2);
                }
            }
        });
        long j = z3 ? this.f27404to : this.f27405tp;
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(create);
        if (ofFloat2 != null) {
            if (z3) {
                animatorSet.playTogether(ofFloat, ofFloat2, m29520a);
            } else {
                animatorSet.playTogether(ofFloat, ofFloat2);
            }
        } else if (z3) {
            animatorSet.playTogether(ofFloat, m29520a);
        } else {
            animatorSet.playTogether(ofFloat);
        }
        return animatorSet;
    }

    @Override // com.kwad.components.core.webview.jshandler.C9182w.InterfaceC9184b
    /* renamed from: N */
    public final void mo29210N(AdTemplate adTemplate) {
        C8674c c8674c = new C8674c(adTemplate, C8676e.AGGREGATION);
        C7907g c7907g = this.f26957qo;
        if (c7907g != null) {
            c7907g.m32025b(c8674c);
        }
    }

    /* renamed from: a */
    private int m31039a(float f) {
        return (int) (C10751a.m24911e(getActivity()) - f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC7886g interfaceC7886g) {
        return getPriority() - interfaceC7886g.getPriority();
    }
}
