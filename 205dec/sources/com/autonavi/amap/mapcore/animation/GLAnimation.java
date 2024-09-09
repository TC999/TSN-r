package com.autonavi.amap.mapcore.animation;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLAnimation implements Cloneable {
    public static final int ABSOLUTE = 0;
    public static final int INFINITE = -1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    public static final int ZORDER_BOTTOM = -1;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    private int mBackgroundColor;
    Interpolator mInterpolator;
    Animation.AnimationListener mListener;
    private Handler mListenerHandler;
    private Runnable mOnEnd;
    private Runnable mOnStart;
    long mStartOffset;
    private int mZAdjustment;
    boolean mEnded = false;
    boolean mStarted = false;
    boolean mCycleFlip = false;
    boolean mInitialized = false;
    boolean mFillBefore = true;
    boolean mFillAfter = false;
    boolean mFillEnabled = false;
    long mStartTime = -1;
    long mDuration = 500;
    int mRepeatCount = 0;
    int mRepeated = 0;
    int mRepeatMode = 1;
    private float mScaleFactor = 1.0f;
    private boolean mDetachWallpaper = false;
    private boolean mMore = true;
    private boolean mOneMoreTime = true;
    RectF mPreviousRegion = new RectF();
    RectF mRegion = new RectF();
    GLTransformation mPreviousTransformation = new GLTransformation();

    public GLAnimation() {
        try {
            ensureInterpolator();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void fireAnimationEnd() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationEnd();
            } else {
                handler.postAtFrontOfQueue(this.mOnEnd);
            }
        }
    }

    private void fireAnimationRepeat() {
    }

    private void fireAnimationStart() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationStart();
            } else {
                handler.postAtFrontOfQueue(this.mOnStart);
            }
        }
    }

    protected void applyTransformation(float f4, GLTransformation gLTransformation) {
    }

    public void cancel() {
        if (this.mStarted && !this.mEnded) {
            fireAnimationEnd();
            this.mEnded = true;
        }
        this.mStartTime = Long.MIN_VALUE;
        this.mOneMoreTime = false;
        this.mMore = false;
    }

    public long computeDurationHint() {
        return (getStartOffset() + getDuration()) * (getRepeatCount() + 1);
    }

    public void detach() {
        if (!this.mStarted || this.mEnded) {
            return;
        }
        this.mEnded = true;
        fireAnimationEnd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ensureInterpolator() {
        if (this.mInterpolator == null) {
            this.mInterpolator = new AccelerateDecelerateInterpolator();
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean getDetachWallpaper() {
        return this.mDetachWallpaper;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public boolean getFillAfter() {
        return this.mFillAfter;
    }

    public boolean getFillBefore() {
        return this.mFillBefore;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getScaleFactor() {
        return this.mScaleFactor;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean getTransformation(long j4, GLTransformation gLTransformation) {
        float f4;
        if (this.mStartTime == -1) {
            this.mStartTime = j4;
        }
        long startOffset = getStartOffset();
        long j5 = this.mDuration;
        if (j5 != 0) {
            f4 = ((float) (j4 - (this.mStartTime + startOffset))) / ((float) j5);
        } else {
            f4 = j4 < this.mStartTime ? 0.0f : 1.0f;
        }
        boolean z3 = f4 >= 1.0f;
        this.mMore = !z3;
        if (!this.mFillEnabled) {
            f4 = Math.max(Math.min(f4, 1.0f), 0.0f);
        }
        if ((f4 >= 0.0f || this.mFillBefore) && (f4 <= 1.0f || this.mFillAfter)) {
            if (!this.mStarted) {
                try {
                    fireAnimationStart();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.mStarted = true;
            }
            if (this.mFillEnabled) {
                f4 = Math.max(Math.min(f4, 1.0f), 0.0f);
            }
            if (this.mCycleFlip) {
                f4 = 1.0f - f4;
            }
            applyTransformation(this.mInterpolator.getInterpolation(f4), gLTransformation);
        }
        if (z3) {
            int i4 = this.mRepeatCount;
            int i5 = this.mRepeated;
            if (i4 == i5) {
                if (!this.mEnded) {
                    this.mEnded = true;
                    fireAnimationEnd();
                }
            } else {
                if (i4 > 0) {
                    this.mRepeated = i5 + 1;
                }
                if (this.mRepeatMode == 2) {
                    this.mCycleFlip = !this.mCycleFlip;
                }
                this.mStartTime = -1L;
                this.mMore = true;
                fireAnimationRepeat();
            }
        }
        boolean z4 = this.mMore;
        if (z4 || !this.mOneMoreTime) {
            return z4;
        }
        this.mOneMoreTime = false;
        return true;
    }

    public int getZAdjustment() {
        return this.mZAdjustment;
    }

    public boolean hasAlpha() {
        return false;
    }

    public boolean hasEnded() {
        return this.mEnded;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasStarted() {
        return this.mStarted;
    }

    public void initialize() {
        reset();
        this.mInitialized = true;
    }

    public boolean isFillEnabled() {
        return this.mFillEnabled;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void reset() {
        this.mPreviousRegion.setEmpty();
        this.mPreviousTransformation.clear();
        this.mInitialized = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
        this.mOneMoreTime = true;
        this.mListenerHandler = null;
    }

    public void restrictDuration(long j4) {
        long j5 = this.mStartOffset;
        if (j5 > j4) {
            this.mStartOffset = j4;
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        long j6 = this.mDuration + j5;
        if (j6 > j4) {
            this.mDuration = j4 - j5;
            j6 = j4;
        }
        if (this.mDuration <= 0) {
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        int i4 = this.mRepeatCount;
        if (i4 < 0 || i4 > j4 || i4 * j6 > j4) {
            int i5 = ((int) (j4 / j6)) - 1;
            this.mRepeatCount = i5;
            if (i5 < 0) {
                this.mRepeatCount = 0;
            }
        }
    }

    public void scaleCurrentDuration(float f4) {
        this.mDuration = ((float) this.mDuration) * f4;
        this.mStartOffset = ((float) this.mStartOffset) * f4;
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int i4) {
        this.mBackgroundColor = i4;
    }

    public void setDetachWallpaper(boolean z3) {
        this.mDetachWallpaper = z3;
    }

    public void setDuration(long j4) {
        if (j4 < 0) {
            j4 = 0;
        }
        this.mDuration = j4;
    }

    public void setFillAfter(boolean z3) {
        this.mFillAfter = z3;
    }

    public void setFillBefore(boolean z3) {
        this.mFillBefore = z3;
    }

    public void setFillEnabled(boolean z3) {
        this.mFillEnabled = z3;
    }

    public void setInterpolator(Context context, int i4) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i4));
    }

    public void setRepeatCount(int i4) {
        if (i4 < 0) {
            i4 = -1;
        }
        this.mRepeatCount = i4;
    }

    public void setRepeatMode(int i4) {
        this.mRepeatMode = i4;
    }

    public void setStartOffset(long j4) {
        this.mStartOffset = j4;
    }

    public void setStartTime(long j4) {
        this.mStartTime = j4;
        this.mEnded = false;
        this.mStarted = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
    }

    public void setZAdjustment(int i4) {
        this.mZAdjustment = i4;
    }

    public void start() {
        setStartTime(-1L);
    }

    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    public boolean willChangeBounds() {
        return true;
    }

    public boolean willChangeTransformationMatrix() {
        return true;
    }

    @Override // 
    /* renamed from: clone */
    public GLAnimation mo55clone() throws CloneNotSupportedException {
        GLAnimation gLAnimation = (GLAnimation) super.clone();
        gLAnimation.mPreviousRegion = new RectF();
        gLAnimation.mRegion = new RectF();
        gLAnimation.mPreviousTransformation = new GLTransformation();
        return gLAnimation;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public boolean getTransformation(long j4, GLTransformation gLTransformation, float f4) {
        this.mScaleFactor = f4;
        return getTransformation(j4, gLTransformation);
    }
}
