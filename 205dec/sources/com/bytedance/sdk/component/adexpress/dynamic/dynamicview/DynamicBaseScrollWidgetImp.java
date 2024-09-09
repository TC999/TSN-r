package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicBaseScrollWidgetImp extends DynamicBaseWidgetImp implements ux {

    /* renamed from: c  reason: collision with root package name */
    ObjectAnimator f29121c;

    /* renamed from: i  reason: collision with root package name */
    private Runnable f29122i;

    /* renamed from: u  reason: collision with root package name */
    private int f29123u;

    /* renamed from: w  reason: collision with root package name */
    ObjectAnimator f29124w;

    public DynamicBaseScrollWidgetImp(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        this.f29123u = 0;
        this.f29122i = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseScrollWidgetImp.this.gd();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd() {
        final View childAt = getChildAt(this.f29123u);
        final View childAt2 = getChildAt((this.f29123u + 1) % getChildCount());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.ev + getChildAt(this.f29123u).getHeight())) / 2);
        this.f29121c = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f29121c.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (this.ev + childAt2.getHeight()) / 2, 0.0f);
        this.f29124w = ofFloat2;
        ofFloat2.setInterpolator(new LinearInterpolator());
        this.f29124w.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp.3
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
                childAt2.setVisibility(0);
            }
        });
        this.f29121c.setDuration(500L);
        this.f29124w.setDuration(500L);
        this.f29121c.start();
        this.f29124w.start();
        int i4 = this.f29123u + 1;
        this.f29123u = i4;
        this.f29123u = i4 % getChildCount();
        postDelayed(this.f29122i, 2000L);
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
        postDelayed(this.f29122i, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ux
    public void w() {
        removeCallbacks(this.f29122i);
        ObjectAnimator objectAnimator = this.f29121c;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.f29121c.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f29124w;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.f29124w.cancel();
        }
        super.w();
    }
}
