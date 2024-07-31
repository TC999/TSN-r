package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.col.p0463l.ThreadTask;
import com.amap.api.col.p0463l.ThreadUtil;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class Animation {
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    @JBindingInclude
    protected String animationType;
    public GLAnimation glAnimation;
    @JBindingInclude
    private AnimationListener mListener;
    @JBindingInclude
    private int fillMode = 0;
    @JBindingInclude
    private long duration = 500;
    @JBindingInclude
    private Interpolator interpolator = null;
    @JBindingInclude
    private boolean mFillBefore = true;
    @JBindingInclude
    private boolean mFillAfter = false;
    @JBindingInclude
    private boolean mFillEnabled = false;
    @JBindingInclude
    private int mRepeatCount = 0;
    @JBindingInclude
    private int mRepeatMode = 1;
    private AnimationUpdateFlags updateFlags = new AnimationUpdateFlags();

    @JBindingInclude
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface AnimationListener {
        @JBindingInclude
        void onAnimationEnd();

        @JBindingInclude
        void onAnimationStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JBindingInclude
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class AnimationUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean mListenerUpdate = false;
        protected boolean durationUpdate = false;
        protected boolean interpolatorUpdate = false;
        protected boolean fillModeUpdate = false;
        protected boolean mFillEnabledUpdate = false;
        protected boolean mFillAfterUpdate = false;
        protected boolean mFillBeforeUpdate = false;
        protected boolean mRepeatCountUpdate = false;
        protected boolean mRepeatModeUpdate = false;

        protected AnimationUpdateFlags() {
        }

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.mListenerUpdate = false;
            this.durationUpdate = false;
            this.interpolatorUpdate = false;
            this.fillModeUpdate = false;
            this.mFillEnabledUpdate = false;
            this.mFillAfterUpdate = false;
            this.mFillBeforeUpdate = false;
            this.mRepeatCountUpdate = false;
            this.mRepeatModeUpdate = false;
        }
    }

    /* renamed from: com.amap.api.maps.model.animation.Animation$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C2271a implements AnimationListener {

        /* renamed from: b */
        private final ThreadTask f7062b;

        /* renamed from: c */
        private final ThreadTask f7063c;

        /* synthetic */ C2271a(Animation animation, AnimationListener animationListener, byte b) {
            this(animationListener);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationEnd() {
            ThreadUtil.m53406a().m53405b(this.f7063c);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationStart() {
            ThreadUtil.m53406a().m53405b(this.f7062b);
        }

        private C2271a(final AnimationListener animationListener) {
            this.f7062b = new ThreadTask() { // from class: com.amap.api.maps.model.animation.Animation.a.1
                @Override // com.amap.api.col.p0463l.ThreadTask
                public final void runTask() {
                    try {
                        AnimationListener animationListener2 = animationListener;
                        if (animationListener2 != null) {
                            animationListener2.onAnimationStart();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            this.f7063c = new ThreadTask() { // from class: com.amap.api.maps.model.animation.Animation.a.2
                @Override // com.amap.api.col.p0463l.ThreadTask
                public final void runTask() {
                    try {
                        AnimationListener animationListener2 = animationListener;
                        if (animationListener2 != null) {
                            animationListener2.onAnimationEnd();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
        }
    }

    public Animation() {
        this.animationType = "typeAnimtionBase";
        this.glAnimation = null;
        this.glAnimation = new GLAnimation();
        this.animationType = getAnimationType();
    }

    /* renamed from: a */
    private void m52014a(boolean z) {
        this.mFillEnabled = z;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillEnabled(z);
        }
        this.updateFlags.mFillEnabledUpdate = true;
    }

    /* renamed from: b */
    private void m52013b(boolean z) {
        this.mFillAfter = z;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillAfter(z);
        }
        this.updateFlags.mFillAfterUpdate = true;
    }

    /* renamed from: c */
    private void m52012c(boolean z) {
        this.mFillBefore = z;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillBefore(z);
        }
        this.updateFlags.mFillBeforeUpdate = true;
    }

    protected abstract String getAnimationType();

    public int getFillMode() {
        return this.fillMode;
    }

    public int getRepeatCount() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatCount();
        }
        return 0;
    }

    public int getRepeatMode() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatMode();
        }
        return 1;
    }

    @JBindingInclude
    public AnimationUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mListener = new C2271a(this, animationListener, (byte) 0);
        this.glAnimation.setAnimationListener(animationListener);
        this.updateFlags.mListenerUpdate = true;
    }

    public void setDuration(long j) {
        this.duration = j;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setDuration(j);
        }
        this.updateFlags.durationUpdate = true;
    }

    public void setFillMode(int i) {
        this.fillMode = i;
        if (i == 0) {
            m52013b(true);
            m52012c(false);
            m52014a(false);
        } else {
            m52013b(false);
            m52014a(true);
            m52012c(true);
        }
        this.updateFlags.fillModeUpdate = true;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setInterpolator(interpolator);
        }
        this.updateFlags.interpolatorUpdate = true;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatCount(i);
        }
        this.updateFlags.mRepeatCountUpdate = true;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatMode(i);
        }
        this.updateFlags.mRepeatModeUpdate = true;
    }
}
