package com.bxkj.student.run.app.utils;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

/* renamed from: com.bxkj.student.run.app.utils.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CountTimerUtil {

    /* renamed from: a */
    private static final int f19579a = 4;

    /* renamed from: b */
    private static final String f19580b = "Go";

    /* renamed from: c */
    private static int f19581c = 4;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CountTimerUtil.java */
    /* renamed from: com.bxkj.student.run.app.utils.f$a  reason: invalid class name */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class animationAnimation$AnimationListenerC5381a implements Animation.AnimationListener {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5382b f19582a;

        /* renamed from: b */
        final /* synthetic */ TextView f19583b;

        animationAnimation$AnimationListenerC5381a(final InterfaceC5382b val$animationState, final TextView val$animationViewTv) {
            this.f19582a = val$animationState;
            this.f19583b = val$animationViewTv;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f19583b.setVisibility(8);
            this.f19582a.m39644b();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            CountTimerUtil.m39648b();
            if (CountTimerUtil.f19581c == 0) {
                this.f19583b.setText(CountTimerUtil.f19580b);
            } else {
                this.f19583b.setText(String.valueOf(CountTimerUtil.f19581c));
            }
            this.f19582a.m39645a();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f19582a.start();
        }
    }

    /* compiled from: CountTimerUtil.java */
    /* renamed from: com.bxkj.student.run.app.utils.f$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC5382b {
        /* renamed from: a */
        void m39645a();

        /* renamed from: b */
        void m39644b();

        void start();
    }

    /* renamed from: b */
    static /* synthetic */ int m39648b() {
        int i = f19581c - 1;
        f19581c = i;
        return i;
    }

    /* renamed from: c */
    private static <T extends TextView> void m39647c(final T animationViewTv, final int repeatCount, InterfaceC5382b animationState) {
        int i = repeatCount - 1;
        f19581c = i;
        animationViewTv.setText(String.valueOf(i));
        animationViewTv.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.3f, 0.1f, 1.3f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(f19581c);
        alphaAnimation.setRepeatCount(f19581c);
        alphaAnimation.setDuration(1000L);
        scaleAnimation.setDuration(1000L);
        scaleAnimation.setAnimationListener(new animationAnimation$AnimationListenerC5381a(animationState, animationViewTv));
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationViewTv.startAnimation(animationSet);
    }

    /* renamed from: d */
    public static <T extends TextView> void m39646d(T animationViewTv, InterfaceC5382b animationState) {
        m39647c(animationViewTv, 4, animationState);
    }
}
