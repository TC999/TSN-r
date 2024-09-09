package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ResultPoint {

    /* renamed from: x  reason: collision with root package name */
    private final float f37341x;

    /* renamed from: y  reason: collision with root package name */
    private final float f37342y;

    public ResultPoint(float f4, float f5) {
        this.f37341x = f4;
        this.f37342y = f5;
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f4 = resultPoint2.f37341x;
        float f5 = resultPoint2.f37342y;
        return ((resultPoint3.f37341x - f4) * (resultPoint.f37342y - f5)) - ((resultPoint3.f37342y - f5) * (resultPoint.f37341x - f4));
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f37341x, resultPoint.f37342y, resultPoint2.f37341x, resultPoint2.f37342y);
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float distance = distance(resultPointArr[0], resultPointArr[1]);
        float distance2 = distance(resultPointArr[1], resultPointArr[2]);
        float distance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (distance3 >= distance2 && distance3 >= distance) {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        } else {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f37341x == resultPoint.f37341x && this.f37342y == resultPoint.f37342y) {
                return true;
            }
        }
        return false;
    }

    public final float getX() {
        return this.f37341x;
    }

    public final float getY() {
        return this.f37342y;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f37341x) * 31) + Float.floatToIntBits(this.f37342y);
    }

    public final String toString() {
        return "(" + this.f37341x + ',' + this.f37342y + ')';
    }
}
