package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicVerticalScrollWidgetImp extends DynamicBaseWidgetImp implements ux {

    /* renamed from: c  reason: collision with root package name */
    ObjectAnimator f29207c;

    /* renamed from: i  reason: collision with root package name */
    private boolean f29208i;

    /* renamed from: q  reason: collision with root package name */
    private Runnable f29209q;

    /* renamed from: u  reason: collision with root package name */
    private int f29210u;

    /* renamed from: w  reason: collision with root package name */
    ObjectAnimator f29211w;

    public DynamicVerticalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        this.f29210u = 0;
        this.f29208i = false;
        this.f29209q = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicVerticalScrollWidgetImp.this.gd();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd() {
        View childAt;
        final View view;
        final View childAt2 = getChildAt(this.f29210u);
        int i4 = this.f29210u;
        if (i4 == 0) {
            this.f29208i = false;
        }
        boolean z3 = i4 + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.f29210u + 1)).getChildCount() <= 0;
        if (!this.bk.p().sr().c() && z3) {
            this.f29208i = true;
            view = getChildAt(this.f29210u - 1);
            this.f29207c = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (this.ev + getChildAt(this.f29210u).getHeight()) / 2);
        } else {
            if (z3) {
                childAt = getChildAt((this.f29210u + 2) % getChildCount());
            } else {
                childAt = getChildAt((this.f29210u + 1) % getChildCount());
            }
            this.f29207c = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (-(this.ev + getChildAt(this.f29210u).getHeight())) / 2);
            if (z3) {
                this.f29210u++;
            }
            view = childAt;
        }
        this.f29207c.setInterpolator(new LinearInterpolator());
        this.f29207c.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt2.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        if (this.f29208i) {
            this.f29211w = ObjectAnimator.ofFloat(view, "translationY", (-(this.ev + view.getHeight())) / 2, 0.0f);
        } else {
            this.f29211w = ObjectAnimator.ofFloat(view, "translationY", (this.ev + view.getHeight()) / 2, 0.0f);
        }
        this.f29211w.setInterpolator(new LinearInterpolator());
        this.f29211w.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view.setVisibility(0);
            }
        });
        this.f29207c.setDuration(500L);
        this.f29211w.setDuration(500L);
        this.f29207c.start();
        this.f29211w.start();
        if (this.f29208i) {
            this.f29210u--;
        } else {
            int i5 = this.f29210u + 1;
            this.f29210u = i5;
            this.f29210u = i5 % getChildCount();
        }
        postDelayed(this.f29209q, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.ev - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i4 != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.f29209q, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ux
    public void w() {
        removeCallbacks(this.f29209q);
        ObjectAnimator objectAnimator = this.f29207c;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.f29207c.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f29211w;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.f29211w.cancel();
        }
        super.w();
    }
}
