package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FPointBounds {
    private final int mVersionCode;
    public final FPoint northeast;
    public final FPoint southwest;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class Builder {
        private float mSouth = Float.POSITIVE_INFINITY;
        private float mNorth = Float.NEGATIVE_INFINITY;
        private float mWest = Float.POSITIVE_INFINITY;
        private float mEast = Float.NEGATIVE_INFINITY;

        private boolean containsx(double d4) {
            float f4 = this.mWest;
            float f5 = this.mEast;
            return f4 <= f5 ? ((double) f4) <= d4 && d4 <= ((double) f5) : ((double) f4) <= d4 || d4 <= ((double) f5);
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

    FPointBounds(int i4, FPoint fPoint, FPoint fPoint2) {
        this.mVersionCode = i4;
        this.southwest = fPoint;
        this.northeast = fPoint2;
    }

    public static Builder builder() {
        return new Builder();
    }

    private boolean containsx(double d4) {
        float f4 = ((PointF) this.southwest).x;
        float f5 = ((PointF) this.northeast).x;
        return f4 <= f5 ? ((double) f4) <= d4 && d4 <= ((double) f5) : ((double) f4) <= d4 || d4 <= ((double) f5);
    }

    private boolean containsy(double d4) {
        return ((double) ((PointF) this.southwest).y) <= d4 && d4 <= ((double) ((PointF) this.northeast).y);
    }

    private boolean intersect(FPointBounds fPointBounds) {
        FPoint fPoint;
        FPoint fPoint2;
        FPoint fPoint3;
        FPoint fPoint4;
        if (fPointBounds != null && (fPoint = fPointBounds.northeast) != null && (fPoint2 = fPointBounds.southwest) != null && (fPoint3 = this.northeast) != null && (fPoint4 = this.southwest) != null) {
            float f4 = ((PointF) fPoint).x;
            float f5 = ((PointF) fPoint3).x;
            float f6 = ((PointF) fPoint4).x;
            double d4 = ((f5 - f6) + f4) - f6;
            float f7 = ((PointF) fPoint).y;
            float f8 = ((PointF) fPoint2).y;
            float f9 = ((PointF) fPoint3).y;
            float f10 = ((PointF) fPoint4).y;
            double d5 = ((f7 + f8) - f9) - f10;
            double d6 = ((f9 - f10) + f7) - f8;
            if (Math.abs(((((PointF) fPoint2).x + f4) - f5) - f6) < d4 && Math.abs(d5) < d6) {
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
