package com.kwad.components.p208ad.feed.p226b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.ad.feed.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7518d extends FrameLayout {
    private int count;

    /* renamed from: fg */
    private ImageView f25657fg;

    /* renamed from: fh */
    private ImageView f25658fh;

    /* renamed from: fi */
    private ImageView f25659fi;

    /* renamed from: fj */
    private Animator f25660fj;

    /* renamed from: fk */
    private Animator f25661fk;

    /* renamed from: fl */
    private Animation f25662fl;

    /* renamed from: fm */
    private Animation f25663fm;

    public C7518d(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: B */
    private void m33094B(Context context) {
        C10887l.inflate(context, C9659R.C9663layout.ksad_promote_ad_click, this);
        this.f25657fg = (ImageView) findViewById(C9659R.C9662id.ksad_inside_circle);
        this.f25658fh = (ImageView) findViewById(C9659R.C9662id.ksad_outside_circle);
        this.f25659fi = (ImageView) findViewById(C9659R.C9662id.ksad_hand);
    }

    /* renamed from: bp */
    private void m33088bp() {
        this.f25660fj = m33086d(this.f25659fi);
        this.f25661fk = m33084e(this.f25659fi);
        this.f25662fl = m33093a(this.f25657fg, 0.45f, C10751a.m24924a(getContext(), 34.0f));
        this.f25663fm = m33093a(this.f25658fh, 0.5f, C10751a.m24924a(getContext(), 50.0f));
        this.f25660fj.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                C7518d.this.f25657fg.startAnimation(C7518d.this.f25662fl);
                C7518d.this.f25658fh.startAnimation(C7518d.this.f25663fm);
                C7518d.this.f25661fk.start();
            }
        });
        this.f25661fk.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.d.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                C7518d.m33082f(C7518d.this);
                if (C7518d.this.count >= 5) {
                    return;
                }
                C7518d.this.f25660fj.start();
            }
        });
    }

    /* renamed from: f */
    static /* synthetic */ int m33082f(C7518d c7518d) {
        int i = c7518d.count;
        c7518d.count = i + 1;
        return i;
    }

    /* renamed from: bn */
    public final void m33090bn() {
        m33088bp();
        this.f25660fj.start();
    }

    /* renamed from: bo */
    public final void m33089bo() {
        Animator animator = this.f25660fj;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f25661fk;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animation animation = this.f25662fl;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f25663fm;
        if (animation2 != null) {
            animation2.cancel();
        }
    }

    private C7518d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    /* renamed from: a */
    private Animation m33093a(final View view, float f, int i) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, 0.0f);
        float m24924a = i / C10751a.m24924a(getContext(), 10.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, m24924a, 1.0f, m24924a, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ad.feed.b.d.3
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        return animationSet;
    }

    /* renamed from: d */
    private Animator m33086d(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, -10.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -C10751a.m24924a(getContext(), 9.5f));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -C10751a.m24924a(getContext(), 9.5f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    /* renamed from: e */
    private Animator m33084e(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", -10.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", -C10751a.m24924a(getContext(), 9.5f), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", -C10751a.m24924a(getContext(), 9.5f), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private C7518d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.count = 0;
        m33094B(context);
    }
}
