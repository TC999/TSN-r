package com.bxkj.student.run.app.utils;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CountTimerUtil.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22809a = 4;

    /* renamed from: b  reason: collision with root package name */
    private static final String f22810b = "Go";

    /* renamed from: c  reason: collision with root package name */
    private static int f22811c = 4;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: CountTimerUtil.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f22812a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f22813b;

        a(final b val$animationState, final TextView val$animationViewTv) {
            this.f22812a = val$animationState;
            this.f22813b = val$animationViewTv;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f22813b.setVisibility(8);
            this.f22812a.b();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            f.b();
            if (f.f22811c == 0) {
                this.f22813b.setText("Go");
            } else {
                this.f22813b.setText(String.valueOf(f.f22811c));
            }
            this.f22812a.a();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f22812a.start();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: CountTimerUtil.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface b {
        void a();

        void b();

        void start();
    }

    static /* synthetic */ int b() {
        int i4 = f22811c - 1;
        f22811c = i4;
        return i4;
    }

    private static <T extends TextView> void c(final T animationViewTv, final int repeatCount, b animationState) {
        int i4 = repeatCount - 1;
        f22811c = i4;
        animationViewTv.setText(String.valueOf(i4));
        animationViewTv.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.3f, 0.1f, 1.3f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(f22811c);
        alphaAnimation.setRepeatCount(f22811c);
        alphaAnimation.setDuration(1000L);
        scaleAnimation.setDuration(1000L);
        scaleAnimation.setAnimationListener(new a(animationState, animationViewTv));
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationViewTv.startAnimation(animationSet);
    }

    public static <T extends TextView> void d(T animationViewTv, b animationState) {
        c(animationViewTv, 4, animationState);
    }
}
