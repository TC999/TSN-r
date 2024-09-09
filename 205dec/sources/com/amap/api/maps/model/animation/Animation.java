package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.y2;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @JBindingInclude
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface AnimationListener {
        @JBindingInclude
        void onAnimationEnd();

        @JBindingInclude
        void onAnimationStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @JBindingInclude
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class a implements AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        private final a8 f10759b;

        /* renamed from: c  reason: collision with root package name */
        private final a8 f10760c;

        /* synthetic */ a(Animation animation, AnimationListener animationListener, byte b4) {
            this(animationListener);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationEnd() {
            y2.a().b(this.f10760c);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationStart() {
            y2.a().b(this.f10759b);
        }

        private a(final AnimationListener animationListener) {
            this.f10759b = new a8() { // from class: com.amap.api.maps.model.animation.Animation.a.1
                @Override // com.amap.api.col.p0003l.a8
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
            this.f10760c = new a8() { // from class: com.amap.api.maps.model.animation.Animation.a.2
                @Override // com.amap.api.col.p0003l.a8
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

    private void a(boolean z3) {
        this.mFillEnabled = z3;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillEnabled(z3);
        }
        this.updateFlags.mFillEnabledUpdate = true;
    }

    private void b(boolean z3) {
        this.mFillAfter = z3;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillAfter(z3);
        }
        this.updateFlags.mFillAfterUpdate = true;
    }

    private void c(boolean z3) {
        this.mFillBefore = z3;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillBefore(z3);
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
        this.mListener = new a(this, animationListener, (byte) 0);
        this.glAnimation.setAnimationListener(animationListener);
        this.updateFlags.mListenerUpdate = true;
    }

    public void setDuration(long j4) {
        this.duration = j4;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setDuration(j4);
        }
        this.updateFlags.durationUpdate = true;
    }

    public void setFillMode(int i4) {
        this.fillMode = i4;
        if (i4 == 0) {
            b(true);
            c(false);
            a(false);
        } else {
            b(false);
            a(true);
            c(true);
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

    public void setRepeatCount(int i4) {
        this.mRepeatCount = i4;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatCount(i4);
        }
        this.updateFlags.mRepeatCountUpdate = true;
    }

    public void setRepeatMode(int i4) {
        this.mRepeatMode = i4;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatMode(i4);
        }
        this.updateFlags.mRepeatModeUpdate = true;
    }
}
