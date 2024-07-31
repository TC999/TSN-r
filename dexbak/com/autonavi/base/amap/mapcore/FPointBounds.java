package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FPointBounds {
    private final int mVersionCode;
    public final FPoint northeast;
    public final FPoint southwest;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class Builder {
        private float mSouth = Float.POSITIVE_INFINITY;
        private float mNorth = Float.NEGATIVE_INFINITY;
        private float mWest = Float.POSITIVE_INFINITY;
        private float mEast = Float.NEGATIVE_INFINITY;

        private boolean containsx(double d) {
            float f = this.mWest;
            float f2 = this.mEast;
            return f <= f2 ? ((double) f) <= d && d <= ((double) f2) : ((double) f) <= d || d <= ((double) f2);
        }

        public final FPointBounds build() {
            return new FPointBounds(FPoint.obtain(this.mWest, this.mSouth), FPoint.obtain(this.mEast, this.mNorth));
        }

        public final Builder include(FPoint fPoint) {
            this.mSouth = Math.min(this.mSouth, ((PointF) fPoint).y);
            this.mNorth = Math.max(this.mNorth, ((PointF) fPoint).y);
            this.mWest = Math.min(this.mWest, ((PointF) fPoint).x);
            this.mEast = Math.max(this.mEast, ((PointF) fPoint).x);
            return this;
        }
    }

    FPointBounds(int i, FPoint fPoint, FPoint fPoint2) {
        this.mVersionCode = i;
        this.southwest = fPoint;
        this.northeast = fPoint2;
    }

    public static Builder builder() {
        return new Builder();
    }

    private boolean containsx(double d) {
        float f = ((PointF) this.southwest).x;
        float f2 = ((PointF) this.northeast).x;
        return f <= f2 ? ((double) f) <= d && d <= ((double) f2) : ((double) f) <= d || d <= ((double) f2);
    }

    private boolean containsy(double d) {
        return ((double) ((PointF) this.southwest).y) <= d && d <= ((double) ((PointF) this.northeast).y);
    }

    private boolean intersect(FPointBounds fPointBounds) {
        FPoint fPoint;
        FPoint fPoint2;
        FPoint fPoint3;
        FPoint fPoint4;
        if (fPointBounds != null && (fPoint = fPointBounds.northeast) != null && (fPoint2 = fPointBounds.southwest) != null && (fPoint3 = this.northeast) != null && (fPoint4 = this.southwest) != null) {
            float f = ((PointF) fPoint).x;
            float f2 = ((PointF) fPoint3).x;
            float f3 = ((PointF) fPoint4).x;
            double d = ((f2 - f3) + f) - f3;
            float f4 = ((PointF) fPoint).y;
            float f5 = ((PointF) fPoint2).y;
            float f6 = ((PointF) fPoint3).y;
            float f7 = ((PointF) fPoint4).y;
            double d2 = ((f4 + f5) - f6) - f7;
            double d3 = ((f6 - f7) + f4) - f5;
            if (Math.abs(((((PointF) fPoint2).x + f) - f2) - f3) < d && Math.abs(d2) < d3) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(FPoint fPoint) {
        return containsy((double) ((PointF) fPoint).y) && containsx((double) ((PointF) fPoint).x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FPointBounds) {
            FPointBounds fPointBounds = (FPointBounds) obj;
            return this.southwest.equals(fPointBounds.southwest) && this.northeast.equals(fPointBounds.northeast);
        }
        return false;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean intersects(FPointBounds fPointBounds) {
        if (fPointBounds == null) {
            return false;
        }
        return intersect(fPointBounds) || fPointBounds.intersect(this);
    }

    public String toString() {
        return "southwest = (" + ((PointF) this.southwest).x + "," + ((PointF) this.southwest).y + ") northeast = (" + ((PointF) this.northeast).x + "," + ((PointF) this.northeast).y + ")";
    }

    public boolean contains(FPointBounds fPointBounds) {
        return fPointBounds != null && contains(fPointBounds.southwest) && contains(fPointBounds.northeast);
    }

    public FPointBounds(FPoint fPoint, FPoint fPoint2) {
        this(1, fPoint, fPoint2);
    }
}
