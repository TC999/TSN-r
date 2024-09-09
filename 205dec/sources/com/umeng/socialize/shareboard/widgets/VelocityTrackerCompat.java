package com.umeng.socialize.shareboard.widgets;

import android.view.VelocityTracker;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class VelocityTrackerCompat {
    private static final VelocityTrackerVersionImpl IMPL = new HoneycombVelocityTrackerVersionImpl();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        private BaseVelocityTrackerVersionImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker velocityTracker, int i4) {
            return velocityTracker.getXVelocity();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        private HoneycombVelocityTrackerVersionImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker velocityTracker, int i4) {
            return velocityTracker.getXVelocity(i4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    interface VelocityTrackerVersionImpl {
        float getXVelocity(VelocityTracker velocityTracker, int i4);
    }

    VelocityTrackerCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float getXVelocity(VelocityTracker velocityTracker, int i4) {
        return IMPL.getXVelocity(velocityTracker, i4);
    }
}
