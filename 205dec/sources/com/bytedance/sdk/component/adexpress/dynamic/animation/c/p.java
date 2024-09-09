package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p extends sr {

    /* renamed from: f  reason: collision with root package name */
    private float f29061f;
    private c sr;
    private float ux;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class c {

        /* renamed from: w  reason: collision with root package name */
        private View f29065w;

        public c(View view) {
            this.f29065w = view;
        }

        public void c(int i4) {
            if ("top".equals(p.this.f29067w.c())) {
                if (p.this.xv instanceof ViewGroup) {
                    for (int i5 = 0; i5 < ((ViewGroup) p.this.xv).getChildCount(); i5++) {
                        ((ViewGroup) p.this.xv).getChildAt(i5).setTranslationY(i4 - p.this.ux);
                    }
                }
                p pVar = p.this;
                pVar.xv.setTranslationY(pVar.ux - i4);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f29065w.getLayoutParams();
            layoutParams.height = i4;
            this.f29065w.setLayoutParams(layoutParams);
            this.f29065w.requestLayout();
        }
    }

    public p(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    List<ObjectAnimator> c() {
        int i4;
        String str;
        View view = this.xv;
        if ((view instanceof ImageView) && (view.getParent() instanceof DynamicBaseWidget)) {
            this.xv = (View) this.xv.getParent();
        }
        this.xv.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "alpha", 0.0f, 1.0f).setDuration((int) (this.f29067w.p() * 1000.0d));
        this.sr = new c(this.xv);
        final int i5 = this.xv.getLayoutParams().height;
        this.ux = i5;
        this.f29061f = this.xv.getLayoutParams().width;
        if ("left".equals(this.f29067w.c()) || "right".equals(this.f29067w.c())) {
            i4 = (int) this.f29061f;
            str = "width";
        } else {
            str = "height";
            i4 = i5;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.sr, str, 0, i4).setDuration((int) (this.f29067w.p() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        arrayList.add(c(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.c.p.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                p.this.sr.c(i5);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z3) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z3) {
            }
        });
        return arrayList;
    }
}
