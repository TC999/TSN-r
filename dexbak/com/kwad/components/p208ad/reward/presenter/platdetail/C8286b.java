package com.kwad.components.p208ad.reward.presenter.platdetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.reward.p263m.C8019b;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11049bd;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8286b extends C8094b {

    /* renamed from: uc */
    private View f27341uc;

    /* renamed from: ud */
    private View f27342ud;

    /* renamed from: ue */
    private View f27343ue;

    /* renamed from: uf */
    private View f27344uf;

    /* renamed from: ui */
    private Animator f27347ui;

    /* renamed from: uj */
    private Animator f27348uj;

    /* renamed from: uk */
    private Animator f27349uk;

    /* renamed from: un */
    private C11049bd f27352un;

    /* renamed from: uo */
    private C11049bd f27353uo;

    /* renamed from: tZ */
    private final long f27338tZ = 1600;

    /* renamed from: ua */
    private final long f27339ua = 3000;

    /* renamed from: ub */
    private final long f27340ub = 5000;

    /* renamed from: ug */
    private boolean f27345ug = false;

    /* renamed from: uh */
    private boolean f27346uh = false;

    /* renamed from: ul */
    private Animator f27350ul = null;

    /* renamed from: um */
    private long f27351um = 3000;

    /* renamed from: up */
    private Interpolator f27354up = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);

    /* renamed from: gO */
    private C9002l f27337gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1

        /* renamed from: uq */
        private boolean f27355uq = false;

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            C8286b.this.f27345ug = true;
            C10331c.m26254d("RewardImagePlayerPresenter", "onMediaPlayPaused : ");
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            if (j2 < C8286b.this.f27351um || this.f27355uq) {
                return;
            }
            this.f27355uq = true;
            C8286b.this.m31069hT();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            C8286b.this.f27345ug = false;
            C10331c.m26254d("RewardImagePlayerPresenter", "onMediaPlayStart : ");
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            C8286b.this.f27345ug = false;
            C10331c.m26254d("RewardImagePlayerPresenter", "onMediaPlaying : ");
            if (C8286b.this.f27350ul == null || C8286b.this.f27350ul.isRunning()) {
                return;
            }
            C8286b.this.f27350ul.start();
            C8286b.m31087a(C8286b.this, (Animator) null);
        }
    };

    /* renamed from: b */
    static /* synthetic */ View m31081b(C8286b c8286b, View view) {
        c8286b.f27342ud = null;
        return null;
    }

    /* renamed from: hR */
    private void m31071hR() {
        this.f27352un = new C11049bd(getContext().getResources().getDimensionPixelSize(C9659R.dimen.ksad_image_player_sweep_wave_width_start), getContext().getResources().getDimensionPixelSize(C9659R.dimen.ksad_image_player_sweep_wave_height_start));
        this.f27353uo = new C11049bd(getContext().getResources().getDimensionPixelSize(C9659R.dimen.ksad_image_player_sweep_wave_width_end), getContext().getResources().getDimensionPixelSize(C9659R.dimen.ksad_image_player_sweep_wave_height_end));
    }

    /* renamed from: hS */
    private View m31070hS() {
        ImageView imageView = new ImageView(getContext());
        imageView.setClickable(false);
        imageView.setFocusable(false);
        imageView.setFocusableInTouchMode(false);
        imageView.setLongClickable(false);
        imageView.setBackgroundColor(Color.parseColor("#222222"));
        imageView.setAlpha(0.2f);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hT */
    public void m31069hT() {
        this.f27347ui = m31090a(this.f27341uc, 1600L);
        this.f27348uj = m31089a(this.f27343ue, this.f27344uf);
        this.f27349uk = m31084b(this.f27341uc, 1600L);
        this.f27347ui.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                C8286b.m31066p(C8286b.this.f27342ud);
                C8286b.m31081b(C8286b.this, (View) null);
                if (C8286b.this.f27346uh) {
                    return;
                }
                C8286b c8286b = C8286b.this;
                c8286b.m31091a(c8286b.f27348uj);
            }
        });
        this.f27348uj.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                C8286b c8286b = C8286b.this;
                c8286b.m31091a(c8286b.f27349uk);
                C8286b.m31066p(C8286b.this.f27343ue);
                C8286b.m31066p(C8286b.this.f27344uf);
                C8286b.m31078c(C8286b.this, null);
                C8286b.m31076d(C8286b.this, null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                C8286b.m31080b(C8286b.this, true);
            }
        });
        this.f27349uk.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                C8286b c8286b = C8286b.this;
                c8286b.m31091a(c8286b.f27349uk);
            }
        });
        m31091a(this.f27347ui);
    }

    /* renamed from: o */
    private Animator m31067o(View view) {
        if (this.f27352un == null || this.f27353uo == null) {
            m31071hR();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", -(C10751a.getScreenHeight(getContext()) + ((this.f27353uo.getHeight() + this.f27352un.getHeight()) / 2)));
        float m23952MG = this.f27353uo.m23952MG() / this.f27352un.m23952MG();
        float m23951MH = this.f27353uo.m23951MH() / this.f27352un.m23951MH();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, m23952MG);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, m23951MH);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000L);
        animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat, ofFloat4);
        animatorSet.setInterpolator(this.f27354up);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static void m31066p(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable th) {
                C10331c.printStackTraceOnly(th);
            }
        }
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26957qo.f26529oJ.m31828a(this.f27337gO);
        FrameLayout m31845O = this.f26957qo.f26529oJ.m31819jO().m31845O(getContext());
        this.f27341uc = m31845O;
        if (m31845O.getParent() != null) {
            return;
        }
        ((FrameLayout) findViewById(C9659R.C9662id.ksad_reward_play_layout)).addView(this.f27341uc, -1, -1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = -this.f27352un.getHeight();
        FrameLayout frameLayout = (FrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
        View m31070hS = m31070hS();
        this.f27342ud = m31070hS;
        frameLayout.addView(m31070hS, -1, -1);
        View m31092a = m31092a(C9659R.C9661drawable.ksad_image_player_sweep1, frameLayout);
        this.f27343ue = m31092a;
        frameLayout.addView(m31092a, layoutParams);
        View m31092a2 = m31092a(C9659R.C9661drawable.ksad_image_player_sweep2, frameLayout);
        this.f27344uf = m31092a2;
        frameLayout.addView(m31092a2, layoutParams);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        m31071hR();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.f27341uc = null;
        C8019b m31819jO = this.f26957qo.f26529oJ.m31819jO();
        if (m31819jO != null) {
            m31819jO.release();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f27345ug = true;
        Animator animator = this.f27348uj;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f27347ui;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.f27349uk;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.f26957qo.f26529oJ.m31826b(this.f27337gO);
    }

    /* renamed from: a */
    static /* synthetic */ Animator m31087a(C8286b c8286b, Animator animator) {
        c8286b.f27350ul = null;
        return null;
    }

    /* renamed from: c */
    static /* synthetic */ View m31078c(C8286b c8286b, View view) {
        c8286b.f27343ue = null;
        return null;
    }

    /* renamed from: d */
    static /* synthetic */ View m31076d(C8286b c8286b, View view) {
        c8286b.f27344uf = null;
        return null;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m31080b(C8286b c8286b, boolean z) {
        c8286b.f27346uh = true;
        return true;
    }

    /* renamed from: a */
    private View m31092a(@DrawableRes int i, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(C9659R.C9663layout.ksad_image_player_sweep, viewGroup, false);
        imageView.setImageDrawable(getContext().getResources().getDrawable(i));
        return imageView;
    }

    /* renamed from: b */
    private Animator m31084b(View view, long j) {
        Animator m31090a = m31090a(view, 1600L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setDuration(5000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(m31090a, ofFloat);
        animatorSet.setDuration(1600L);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m31091a(@NonNull Animator animator) {
        if (!this.f27345ug) {
            animator.start();
        } else {
            this.f27350ul = animator;
        }
    }

    /* renamed from: a */
    private Animator m31089a(View view, View view2) {
        Animator m31067o = m31067o(view);
        Animator m31067o2 = m31067o(view2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f);
        ofFloat.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, m31067o2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(m31067o, animatorSet);
        return animatorSet2;
    }

    /* renamed from: a */
    private Animator m31090a(View view, long j) {
        float[] fArr = {1.0f, 1.106f, 1.0f, 1.106f, 1.0f};
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        View view2 = this.f27342ud;
        if (view2 != null) {
            animatorSet.playTogether(ofFloat, ofFloat2, ObjectAnimator.ofFloat(view2, "alpha", 0.2f, 0.0f));
        } else {
            animatorSet.playTogether(ofFloat, ofFloat2);
        }
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(this.f27354up);
        return animatorSet;
    }
}
