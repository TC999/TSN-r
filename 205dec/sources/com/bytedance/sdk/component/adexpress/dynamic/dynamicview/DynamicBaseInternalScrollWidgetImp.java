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
public class DynamicBaseInternalScrollWidgetImp extends DynamicBaseWidgetImp implements ux {

    /* renamed from: c  reason: collision with root package name */
    ObjectAnimator f29111c;

    /* renamed from: i  reason: collision with root package name */
    private boolean f29112i;

    /* renamed from: q  reason: collision with root package name */
    private Runnable f29113q;

    /* renamed from: u  reason: collision with root package name */
    private int f29114u;

    /* renamed from: w  reason: collision with root package name */
    ObjectAnimator f29115w;

    public DynamicBaseInternalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        this.f29114u = 0;
        this.f29112i = false;
        this.f29113q = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseInternalScrollWidgetImp.this.gd();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd() {
        final View childAt;
        final View childAt2 = getChildAt(this.f29114u);
        int i4 = this.f29114u;
        if (i4 == 0) {
            this.f29112i = false;
        }
        if (i4 + 1 < getChildCount() && ((ViewGroup) getChildAt(this.f29114u + 1)).getChildCount() > 0) {
            childAt = getChildAt(this.f29114u + 1);
            this.f29111c = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.f29138r + getChildAt(this.f29114u).getWidth())) / 2);
        } else {
            this.f29112i = true;
            childAt = getChildAt(this.f29114u - 1);
            this.f29111c = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.f29138r + getChildAt(this.f29114u).getWidth()) / 2);
        }
        this.f29111c.setInterpolator(new LinearInterpolator());
        this.f29111c.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.2
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
        if (this.f29112i) {
            this.f29115w = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.f29138r + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.f29115w = ObjectAnimator.ofFloat(childAt, "translationX", (this.f29138r + childAt.getWidth()) / 2, 0.0f);
        }
        this.f29115w.setInterpolator(new LinearInterpolator());
        this.f29115w.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.3
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
                childAt.setVisibility(0);
            }
        });
        this.f29111c.setDuration(500L);
        this.f29115w.setDuration(500L);
        this.f29111c.start();
        this.f29115w.start();
        if (this.f29112i) {
            this.f29114u--;
        } else {
            this.f29114u++;
        }
        postDelayed(this.f29113q, 2000L);
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
        postDelayed(this.f29113q, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ux
    public void w() {
        removeCallbacks(this.f29113q);
        ObjectAnimator objectAnimator = this.f29111c;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.f29111c.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f29115w;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.f29115w.cancel();
        }
        super.w();
    }
}
