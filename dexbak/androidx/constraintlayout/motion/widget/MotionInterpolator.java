package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class MotionInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public abstract float getInterpolation(float f);

    public abstract float getVelocity();
}
