package com.kwad.components.ad.reward.presenter;

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
import com.kwad.components.ad.k.b;
import com.kwad.components.ad.reward.presenter.RewardPreEndCardPresenter;
import com.kwad.components.core.i.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class s extends b implements com.kwad.components.ad.reward.e.g, a.InterfaceC0636a, w.b {
    @Nullable
    private com.kwad.components.ad.reward.d oP;
    private ImageView sc;
    private View td;
    private KsLogoView te;
    private DetailVideoView tf;
    private int tg;
    private View th;
    private FrameLayout ti;
    private Animator tj;
    private Animator tk;
    private Animator tl;
    private AdTemplate tm;
    private List<com.kwad.components.core.i.c> tn;

    /* renamed from: tv  reason: collision with root package name */
    private boolean f38647tv;
    @RewardPreEndCardPresenter.PreEndPageStatus
    private int tc = 1;
    private long to = 500;
    private long tp = 50;
    private float tq = 1.2254902f;
    private float tr = 0.80472106f;
    private float ts = 0.0f;
    private boolean tt = false;
    private long showTime = -1;
    private long tu = -1;
    private com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            s.this.g(j5);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.s.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null && !com.kwad.sdk.core.response.b.e.c(s.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                com.kwad.components.core.i.c a4 = com.kwad.components.ad.reward.g.a(s.this.tn, aVar.creativeId);
                if (a4 != null) {
                    s.this.qo.a(a4);
                    return;
                }
                return;
            }
            s.this.qo.oI.bJ();
        }
    };

    private boolean I(boolean z3) {
        int b4 = b(hH());
        N(b4);
        com.kwad.components.ad.reward.d dVar = this.oP;
        boolean ar = dVar != null ? dVar.ar() : false;
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "webLoadSuccess: " + ar);
        if (ar) {
            int a4 = a(hH());
            float f4 = -b4;
            this.ts = f4;
            Animator a5 = a(true, f4, a4, true, z3);
            this.tj = a5;
            a5.start();
            Animator hG = hG();
            this.tl = hG;
            hG.start();
            this.tc = 2;
            return true;
        }
        return false;
    }

    private void J(boolean z3) {
        Animator a4 = a(false, (hH() - hI()) + this.ts, a(hI()), false, z3);
        this.tk = a4;
        a4.start();
        com.kwad.sdk.core.d.a.DF();
        com.kwad.sdk.core.d.a.bU(this.tm);
        this.tc = 3;
        com.kwad.components.ad.reward.d dVar = this.oP;
        if (dVar != null) {
            dVar.fl();
        }
    }

    private void N(int i4) {
        ViewGroup.LayoutParams layoutParams = this.td.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i4;
            layoutParams2.bottomMargin = -i4;
            return;
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i4);
        layoutParams3.height = i4;
        layoutParams3.bottomMargin = -i4;
        this.td.setLayoutParams(layoutParams3);
    }

    private void f(List<AdTemplate> list) {
        com.kwad.components.ad.reward.d dVar = new com.kwad.components.ad.reward.d(list, this.qo.mReportExtData, this);
        this.oP = dVar;
        this.qo.oP = dVar;
        dVar.setShowLandingPage(com.kwad.sdk.core.response.b.b.ct(this.mAdTemplate));
        this.oP.a(this.cR);
        com.kwad.components.ad.reward.d dVar2 = this.oP;
        FrameLayout frameLayout = this.ti;
        com.kwad.components.ad.reward.g gVar = this.qo;
        dVar2.a(frameLayout, gVar.mRootContainer, this.mAdTemplate, gVar.mApkDownloadHelper, gVar.mScreenOrientation);
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.oP.a(new b.InterfaceC0582b() { // from class: com.kwad.components.ad.reward.presenter.s.2
            @Override // com.kwad.components.ad.k.b.InterfaceC0582b
            public final void hJ() {
                com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                s.this.qo.pp = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j4) {
        AdTemplate adTemplate = this.tm;
        if (adTemplate == null || this.f38647tv) {
            return;
        }
        if (this.showTime <= 0) {
            this.showTime = com.kwad.sdk.core.response.b.b.cq(adTemplate);
            this.tu = com.kwad.sdk.core.response.b.b.cp(this.tm) + this.showTime;
        }
        long j5 = this.showTime;
        if (j5 > 0 && !this.tt && j4 > j5) {
            this.f38647tv = !I(true);
            com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "showError: " + this.f38647tv);
            if (this.f38647tv) {
                return;
            }
            this.tt = true;
        }
        boolean z3 = this.tc == 3;
        long j6 = this.tu;
        if (j6 <= 0 || z3 || j4 <= j6) {
            return;
        }
        J(true);
    }

    private Animator hG() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.th, "alpha", 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private float hH() {
        return com.kwad.sdk.d.a.a.d(getActivity()) / this.tq;
    }

    private float hI() {
        return com.kwad.sdk.d.a.a.d(getActivity()) / this.tr;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.oJ.a(this.gO);
        this.qo.b((com.kwad.components.ad.reward.e.g) this);
        this.qo.a(this);
        this.tg = com.kwad.sdk.d.a.a.F(this.tf);
        com.kwad.sdk.d.a.a.n(this.tf, 49);
        this.te.aD(this.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        int i4;
        if (this.tm == null || (i4 = this.tc) == 3) {
            return;
        }
        if (i4 == 1) {
            I(false);
            J(false);
        } else if (i4 == 2) {
            J(true);
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0636a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list == null || list.size() == 0) {
            return;
        }
        this.tm = list.get(0).getAdTemplate();
        this.tn = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAdTemplate);
        arrayList.addAll(com.kwad.components.core.i.c.m(list));
        f(arrayList);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.td = findViewById(R.id.ksad_middle_end_card);
        this.tf = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.te = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.sc = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        this.th = findViewById(R.id.ksad_play_web_card_webView);
        this.ti = (FrameLayout) findViewById(R.id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0636a
    public final void onError(int i4, String str) {
        com.kwad.sdk.core.e.c.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0636a
    public final void onRequestResult(int i4) {
        com.kwad.sdk.core.e.c.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i4);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.g gVar = this.qo;
        gVar.pp = false;
        gVar.oJ.b(this.gO);
        this.qo.c(this);
        this.qo.b((a.InterfaceC0636a) this);
        com.kwad.components.ad.reward.d dVar = this.oP;
        if (dVar != null) {
            dVar.lW();
        }
        Animator animator = this.tl;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.tf;
        if (detailVideoView != null) {
            com.kwad.sdk.d.a.a.n(detailVideoView, this.tg);
        }
        Animator animator2 = this.tj;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.tl = null;
        this.tj = null;
    }

    private int b(float f4) {
        return (int) (f4 + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private Animator a(boolean z3, float f4, int i4, boolean z4, boolean z5) {
        ValueAnimator ofFloat;
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f4 + ", videoTargetHeight: " + i4);
        if (z3) {
            ofFloat = ObjectAnimator.ofFloat(this.td, "translationY", f4);
        } else {
            int height = this.td.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.td.getLayoutParams();
            ofFloat = ValueAnimator.ofFloat(height, Math.abs(f4));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.td.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator ofFloat2 = z4 ? ObjectAnimator.ofFloat(this.te, "alpha", 0.0f, 255.0f) : null;
        final ViewGroup.LayoutParams layoutParams2 = this.sc.getLayoutParams();
        ValueAnimator a4 = this.tf.a(this.mAdTemplate, i4, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    s.this.sc.setLayoutParams(layoutParams2);
                }
            }
        });
        long j4 = z5 ? this.to : this.tp;
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j4);
        animatorSet.setInterpolator(create);
        if (ofFloat2 != null) {
            if (z5) {
                animatorSet.playTogether(ofFloat, ofFloat2, a4);
            } else {
                animatorSet.playTogether(ofFloat, ofFloat2);
            }
        } else if (z5) {
            animatorSet.playTogether(ofFloat, a4);
        } else {
            animatorSet.playTogether(ofFloat);
        }
        return animatorSet;
    }

    @Override // com.kwad.components.core.webview.jshandler.w.b
    public final void N(AdTemplate adTemplate) {
        com.kwad.components.core.i.c cVar = new com.kwad.components.core.i.c(adTemplate, com.kwad.components.core.i.e.AGGREGATION);
        com.kwad.components.ad.reward.g gVar = this.qo;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    private int a(float f4) {
        return (int) (com.kwad.sdk.d.a.a.e(getActivity()) - f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
