package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;
import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ResultPoint {

    /* renamed from: x */
    private final float f23818x;

    /* renamed from: y */
    private final float f23819y;

    public ResultPoint(float f, float f2) {
        this.f23818x = f;
        this.f23819y = f2;
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f = resultPoint2.f23818x;
        float f2 = resultPoint2.f23819y;
        return ((resultPoint3.f23818x - f) * (resultPoint.f23819y - f2)) - ((resultPoint3.f23819y - f2) * (resultPoint.f23818x - f));
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f23818x, resultPoint.f23819y, resultPoint2.f23818x, resultPoint2.f23819y);
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
            if (this.f23818x == resultPoint.f23818x && this.f23819y == resultPoint.f23819y) {
                return true;
            }
        }
        return false;
    }

    public final float getX() {
        return this.f23818x;
    }

    public final float getY() {
        return this.f23819y;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f23818x) * 31) + Float.floatToIntBits(this.f23819y);
    }

    public final String toString() {
        return "(" + this.f23818x + StringUtil.COMMA + this.f23819y + ')';
    }
}
