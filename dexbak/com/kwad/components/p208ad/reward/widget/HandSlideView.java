package com.kwad.components.p208ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.reward.widget.HandSlideView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class HandSlideView extends KSFrameLayout {

    /* renamed from: Aa */
    private View f27460Aa;

    /* renamed from: Ab */
    private AnimatorSet f27461Ab;

    /* renamed from: Ac */
    private float f27462Ac;

    /* renamed from: Ad */
    private float f27463Ad;

    /* renamed from: Ae */
    private float f27464Ae;

    /* renamed from: Af */
    private long f27465Af;

    /* renamed from: Ag */
    private long f27466Ag;

    /* renamed from: Ah */
    private int f27467Ah;

    /* renamed from: Ai */
    private int f27468Ai;

    /* renamed from: fi */
    private ImageView f27469fi;
    private boolean started;

    /* renamed from: com.kwad.components.ad.reward.widget.HandSlideView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8327a {
        void onHandSlideLoopEnd();
    }

    public HandSlideView(@NonNull Context context) {
        super(context);
        this.f27465Af = 600L;
        this.f27466Ag = 500L;
        this.f27467Ah = 3;
        this.f27468Ai = 0;
        this.started = false;
    }

    /* renamed from: b */
    static /* synthetic */ int m31001b(HandSlideView handSlideView) {
        int i = handSlideView.f27468Ai;
        handSlideView.f27468Ai = i + 1;
        return i;
    }

    /* renamed from: s */
    private static ValueAnimator.AnimatorUpdateListener m30998s(final View view) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public final void destroy() {
        this.started = false;
        AnimatorSet animatorSet = this.f27461Ab;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.f27461Ab.cancel();
            this.f27461Ab = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        FrameLayout.inflate(getContext(), C9659R.C9663layout.ksad_hand_slide, this);
        this.f27469fi = (ImageView) findViewById(C9659R.C9662id.ksad_hand_slide_hand);
        this.f27460Aa = findViewById(C9659R.C9662id.ksad_hand_slide_tail);
        this.f27462Ac = getContext().getResources().getDimension(C9659R.dimen.ksad_hand_slide_up);
        this.f27463Ad = getContext().getResources().getDimension(C9659R.dimen.ksad_hand_slide_tail_height_start);
        this.f27464Ae = getContext().getResources().getDimension(C9659R.dimen.ksad_hand_slide_tail_height_end);
    }

    public final boolean isStarted() {
        return this.started;
    }

    /* renamed from: b */
    private AnimatorSet m31002b(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -this.f27462Ac);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotation", 30.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat3.setDuration(10L);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(this.f27463Ad, this.f27464Ae);
        ofFloat4.addUpdateListener(m30998s(view2));
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.f27465Af);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        animatorSet.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 0.0f));
        animatorSet2.setDuration(this.f27466Ag);
        animatorSet2.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        return animatorSet3;
    }

    /* renamed from: a */
    public final void m31004a(@Nullable final InterfaceC8327a interfaceC8327a) {
        this.started = true;
        AnimatorSet m31002b = m31002b(this.f27469fi, this.f27460Aa);
        this.f27461Ab = m31002b;
        m31002b.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (HandSlideView.this.f27461Ab == null) {
                    return;
                }
                HandSlideView.m31001b(HandSlideView.this);
                if (HandSlideView.this.f27468Ai < HandSlideView.this.f27467Ah) {
                    HandSlideView.this.f27461Ab.start();
                    return;
                }
                HandSlideView.this.f27461Ab.removeListener(this);
                InterfaceC8327a interfaceC8327a2 = interfaceC8327a;
                if (interfaceC8327a2 != null) {
                    interfaceC8327a2.onHandSlideLoopEnd();
                }
            }
        });
        this.f27461Ab.start();
    }

    public HandSlideView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27465Af = 600L;
        this.f27466Ag = 500L;
        this.f27467Ah = 3;
        this.f27468Ai = 0;
        this.started = false;
    }

    public HandSlideView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27465Af = 600L;
        this.f27466Ag = 500L;
        this.f27467Ah = 3;
        this.f27468Ai = 0;
        this.started = false;
    }
}
