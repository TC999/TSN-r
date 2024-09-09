package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends sr {
    public ux(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
    }

    private void sr(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29067w.u())).setDuration((int) (this.f29067w.p() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(c(duration));
    }

    private void w(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29067w.u())).setDuration((int) (this.f29067w.p() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.c.ux.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ux.this.xv.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        list.add(c(duration));
    }

    private void xv(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29067w.u())).setDuration((int) (this.f29067w.p() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.c.ux.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ux.this.xv.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        list.add(c(duration));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    List<ObjectAnimator> c() {
        char c4;
        ArrayList arrayList = new ArrayList();
        String i4 = this.f29067w.i();
        switch (i4.hashCode()) {
            case 3029889:
                if (i4.equals("both")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case 3387192:
                if (i4.equals("none")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 483313230:
                if (i4.equals("forwards")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1356771568:
                if (i4.equals("backwards")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        if (c4 == 0) {
            c(arrayList);
        } else if (c4 == 1) {
            sr(arrayList);
        } else if (c4 != 2) {
            xv(arrayList);
        } else {
            w(arrayList);
        }
        return arrayList;
    }

    private void c(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29067w.u())).setDuration(((int) (this.f29067w.p() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar = this.f29067w;
        cVar.f(cVar.ys() * 2);
        list.add(c(duration));
    }
}
