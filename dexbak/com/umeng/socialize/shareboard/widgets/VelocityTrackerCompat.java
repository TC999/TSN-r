package com.umeng.socialize.shareboard.widgets;

import android.view.VelocityTracker;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
class VelocityTrackerCompat {
    private static final VelocityTrackerVersionImpl IMPL = new HoneycombVelocityTrackerVersionImpl();

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        private BaseVelocityTrackerVersionImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        private HoneycombVelocityTrackerVersionImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity(i);
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    interface VelocityTrackerVersionImpl {
        float getXVelocity(VelocityTracker velocityTracker, int i);
    }

    VelocityTrackerCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float getXVelocity(VelocityTracker velocityTracker, int i) {
        return IMPL.getXVelocity(velocityTracker, i);
    }
}
