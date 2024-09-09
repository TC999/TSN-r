package androidx.core.view;

import android.view.VelocityTracker;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class VelocityTrackerCompat {
    private VelocityTrackerCompat() {
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker velocityTracker, int i4) {
        return velocityTracker.getXVelocity(i4);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker velocityTracker, int i4) {
        return velocityTracker.getYVelocity(i4);
    }
}
