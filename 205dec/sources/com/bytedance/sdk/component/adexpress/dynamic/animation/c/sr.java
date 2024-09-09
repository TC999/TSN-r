package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class sr implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ux {

    /* renamed from: w  reason: collision with root package name */
    com.bytedance.sdk.component.adexpress.dynamic.xv.c f29067w;
    public View xv;
    private Set<ScheduledFuture<?>> sr = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public List<ObjectAnimator> f29066c = c();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        ObjectAnimator f29072c;

        /* renamed from: w  reason: collision with root package name */
        ScheduledFuture<?> f29073w;

        c(ObjectAnimator objectAnimator) {
            this.f29072c = objectAnimator;
        }

        public void c(ScheduledFuture<?> scheduledFuture) {
            this.f29073w = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT < 19 || com.bytedance.sdk.component.adexpress.c.c.c.c().xv() == null) {
                return;
            }
            com.bytedance.sdk.component.adexpress.c.c.c.c().xv().w().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f29072c.resume();
                }
            });
            if (this.f29073w != null) {
                sr.this.sr.remove(this.f29073w);
            }
        }
    }

    public sr(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        this.xv = view;
        this.f29067w = cVar;
    }

    abstract List<ObjectAnimator> c();

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ux
    public void w() {
        List<ObjectAnimator> list = this.f29066c;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        for (ScheduledFuture<?> scheduledFuture : this.sr) {
            scheduledFuture.cancel(true);
        }
    }

    public void xv() {
        List<ObjectAnimator> list = this.f29066c;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.f29067w.ia() > 0.0d && Build.VERSION.SDK_INT >= 19) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        c cVar = new c(objectAnimator);
                        ScheduledFuture<?> c4 = com.bytedance.sdk.component.adexpress.sr.xv.c(cVar, (long) (sr.this.f29067w.ia() * 1000.0d), TimeUnit.MILLISECONDS);
                        cVar.c(c4);
                        sr.this.sr.add(c4);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectAnimator c(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.f29067w.t() * 1000.0d));
        if (this.f29067w.ys() > 0) {
            objectAnimator.setRepeatCount(this.f29067w.ys() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!"normal".equals(this.f29067w.fp())) {
            if (!"alternate".equals(this.f29067w.fp()) && !"alternate-reverse".equals(this.f29067w.fp())) {
                objectAnimator.setRepeatMode(1);
            } else {
                objectAnimator.setRepeatMode(2);
            }
        }
        if ("ease-in-out".equals(this.f29067w.bk())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.f29067w.fp())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.f29067w.fp())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    sr.this.xv.setVisibility(0);
                    if (sr.this.xv.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) sr.this.xv.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }
}
