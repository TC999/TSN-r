package com.kwad.components.p208ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.splashscreen.widget.KsRotateView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsRotateView extends AbstractC8513b {

    /* renamed from: FV */
    private static int f27922FV = 50;

    /* renamed from: FW */
    private static int f27923FW = -12;

    /* renamed from: FX */
    private static int f27924FX = -25;

    /* renamed from: FY */
    private static int f27925FY = 12;

    /* renamed from: FZ */
    private static int f27926FZ = 25;

    /* renamed from: FU */
    private ImageView f27927FU;
    @DrawableRes

    /* renamed from: Ga */
    private int f27928Ga;

    /* renamed from: fq */
    private ImageView f27929fq;

    public KsRotateView(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.AbstractC8513b
    /* renamed from: a */
    protected final void mo30459a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_KsShakeView, i, 0);
        this.f27928Ga = obtainStyledAttributes.getResourceId(C9659R.styleable.ksad_KsShakeView_ksad_shakeIcon, C9659R.C9661drawable.ksad_ic_rotate_phone);
        obtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.f27927FU = imageView;
        imageView.setImageResource(C9659R.C9661drawable.ksad_ic_rotate_line);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        addView(this.f27927FU, layoutParams);
        this.f27929fq = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = C10751a.m24924a(context, 22.0f);
        layoutParams2.gravity = 1;
        addView(this.f27929fq, layoutParams2);
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.AbstractC8513b
    protected int getAnimationDelayTime() {
        return 500;
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.AbstractC8513b
    protected View getInteractionView() {
        return this.f27929fq;
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.AbstractC8513b
    /* renamed from: lR */
    protected final void mo30456lR() {
        this.f27929fq.setImageResource(this.f27928Ga);
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.AbstractC8513b
    /* renamed from: lS */
    protected final Animator mo30455lS() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, f27924FX).setDuration(500L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, "rotation", f27924FX, 0.0f).setDuration(f27922FV);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, f27925FY).setDuration(f27922FV);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, "rotation", f27925FY, 0.0f).setDuration(f27922FV);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, f27923FW).setDuration(f27922FV);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, "rotation", f27923FW, 0.0f).setDuration(f27922FV);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat2.setDuration(500L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, f27926FZ).setDuration(500L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        animatorSet.playSequentially(duration, ofFloat, duration2, duration3, duration4, duration5, duration6, ofFloat2, duration7, ofFloat3, ObjectAnimator.ofFloat(interactionView, "rotation", f27926FZ, 0.0f).setDuration(f27922FV), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, f27923FW).setDuration(f27922FV), ObjectAnimator.ofFloat(interactionView, "rotation", f27923FW, 0.0f).setDuration(f27922FV), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, f27925FY).setDuration(f27922FV), ObjectAnimator.ofFloat(interactionView, "rotation", f27925FY, 0.0f).setDuration(f27922FV));
        return animatorSet;
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.AbstractC8513b
    /* renamed from: lT */
    protected final void mo30454lT() {
        getInteractionView().setRotation(0.0f);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
