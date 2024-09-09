package com.autonavi.amap.mapcore.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLAnimationSet extends GLAnimation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private boolean mDirty;
    private boolean mHasAlpha;
    private long mLastEnd;
    private int mFlags = 0;
    private ArrayList<GLAnimation> mAnimations = new ArrayList<>();
    private GLTransformation mTempTransformation = new GLTransformation();

    public GLAnimationSet(boolean z3) {
        setFlag(16, z3);
        init();
    }

    private void init() {
        this.mStartTime = 0L;
    }

    private void setFlag(int i4, boolean z3) {
        if (z3) {
            this.mFlags = i4 | this.mFlags;
            return;
        }
        this.mFlags = (i4 ^ (-1)) & this.mFlags;
    }

    public void addAnimation(Animation animation) {
        this.mAnimations.add(animation.glAnimation);
        if (((this.mFlags & 64) == 0) && animation.glAnimation.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        if (((this.mFlags & 128) == 0) && animation.glAnimation.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) == 32) {
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else if (this.mAnimations.size() == 1) {
            long startOffset = animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration();
            this.mDuration = startOffset;
            this.mLastEnd = this.mStartOffset + startOffset;
        } else {
            long max = Math.max(this.mLastEnd, animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration());
            this.mLastEnd = max;
            this.mDuration = max - this.mStartOffset;
        }
        this.mDirty = true;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long computeDurationHint() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j4 = 0;
        for (int i4 = size - 1; i4 >= 0; i4--) {
            long computeDurationHint = arrayList.get(i4).computeDurationHint();
            if (computeDurationHint > j4) {
                j4 = computeDurationHint;
            }
        }
        return j4;
    }

    public List<GLAnimation> getAnimations() {
        return this.mAnimations;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getDuration() {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        if ((this.mFlags & 32) == 32) {
            return this.mDuration;
        }
        long j4 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            j4 = Math.max(j4, arrayList.get(i4).getDuration());
        }
        return j4;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getStartTime() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j4 = Long.MAX_VALUE;
        for (int i4 = 0; i4 < size; i4++) {
            j4 = Math.min(j4, arrayList.get(i4).getStartTime());
        }
        return j4;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean getTransformation(long j4, GLTransformation gLTransformation) {
        if (!this.mInitialized) {
            initialize();
        }
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        GLTransformation gLTransformation2 = this.mTempTransformation;
        gLTransformation.clear();
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = true;
        for (int i4 = size - 1; i4 >= 0; i4--) {
            GLAnimation gLAnimation = arrayList.get(i4);
            gLTransformation2.clear();
            z4 = gLAnimation.getTransformation(j4, gLTransformation, getScaleFactor()) || z4;
            z3 = z3 || gLAnimation.hasStarted();
            z5 = gLAnimation.hasEnded() && z5;
        }
        if (z3) {
            try {
                if (!this.mStarted) {
                    Animation.AnimationListener animationListener = this.mListener;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                    this.mStarted = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (z5 != this.mEnded) {
            Animation.AnimationListener animationListener2 = this.mListener;
            if (animationListener2 != null) {
                animationListener2.onAnimationEnd();
            }
            this.mEnded = z5;
        }
        return z4;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean hasAlpha() {
        if (this.mDirty) {
            int i4 = 0;
            this.mHasAlpha = false;
            this.mDirty = false;
            int size = this.mAnimations.size();
            ArrayList<GLAnimation> arrayList = this.mAnimations;
            while (true) {
                if (i4 >= size) {
                    break;
                } else if (arrayList.get(i4).hasAlpha()) {
                    this.mHasAlpha = true;
                    break;
                } else {
                    i4++;
                }
            }
        }
        return this.mHasAlpha;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void initialize() {
        boolean z3;
        boolean z4;
        super.initialize();
        int i4 = this.mFlags;
        boolean z5 = (i4 & 32) == 32;
        boolean z6 = (i4 & 1) == 1;
        boolean z7 = (i4 & 2) == 2;
        boolean z8 = (i4 & 4) == 4;
        boolean z9 = (i4 & 16) == 16;
        boolean z10 = (i4 & 8) == 8;
        if (z9) {
            ensureInterpolator();
        }
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        long j4 = this.mDuration;
        boolean z11 = this.mFillAfter;
        boolean z12 = this.mFillBefore;
        int i5 = this.mRepeatMode;
        Interpolator interpolator = this.mInterpolator;
        boolean z13 = z10;
        long j5 = this.mStartOffset;
        int i6 = 0;
        while (i6 < size) {
            ArrayList<GLAnimation> arrayList2 = arrayList;
            GLAnimation gLAnimation = arrayList.get(i6);
            if (z5) {
                gLAnimation.setDuration(j4);
            }
            if (z6) {
                gLAnimation.setFillAfter(z11);
            }
            if (z7) {
                gLAnimation.setFillBefore(z12);
            }
            if (z8) {
                gLAnimation.setRepeatMode(i5);
            }
            if (z9) {
                gLAnimation.setInterpolator(interpolator);
            }
            if (z13) {
                z3 = z5;
                z4 = z6;
                gLAnimation.setStartOffset(gLAnimation.getStartOffset() + j5);
            } else {
                z3 = z5;
                z4 = z6;
            }
            gLAnimation.initialize();
            i6++;
            z5 = z3;
            arrayList = arrayList2;
            z6 = z4;
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void reset() {
        super.reset();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void restrictDuration(long j4) {
        super.restrictDuration(j4);
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.get(i4).restrictDuration(j4);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void scaleCurrentDuration(float f4) {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.get(i4).scaleCurrentDuration(f4);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setDuration(long j4) {
        this.mFlags |= 32;
        super.setDuration(j4);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillAfter(boolean z3) {
        this.mFlags |= 1;
        super.setFillAfter(z3);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillBefore(boolean z3) {
        this.mFlags |= 2;
        super.setFillBefore(z3);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setRepeatMode(int i4) {
        this.mFlags |= 4;
        super.setRepeatMode(i4);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartOffset(long j4) {
        this.mFlags |= 8;
        super.setStartOffset(j4);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartTime(long j4) {
        super.setStartTime(j4);
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.get(i4).setStartTime(j4);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    /* renamed from: clone */
    public GLAnimationSet mo55clone() throws CloneNotSupportedException {
        GLAnimationSet gLAnimationSet = (GLAnimationSet) super.mo55clone();
        gLAnimationSet.mTempTransformation = new GLTransformation();
        gLAnimationSet.mAnimations = new ArrayList<>();
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i4 = 0; i4 < size; i4++) {
            gLAnimationSet.mAnimations.add(arrayList.get(i4).mo55clone());
        }
        return gLAnimationSet;
    }
}
