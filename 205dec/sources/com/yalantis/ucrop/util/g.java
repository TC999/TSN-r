package com.yalantis.ucrop.util;

import android.graphics.RectF;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: RectUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class g {
    public static float[] a(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static float[] b(RectF rectF) {
        float f4 = rectF.left;
        float f5 = rectF.top;
        float f6 = rectF.right;
        float f7 = rectF.bottom;
        return new float[]{f4, f5, f6, f5, f6, f7, f4, f7};
    }

    public static float[] c(float[] fArr) {
        return new float[]{(float) Math.sqrt(Math.pow(fArr[0] - fArr[2], 2.0d) + Math.pow(fArr[1] - fArr[3], 2.0d)), (float) Math.sqrt(Math.pow(fArr[2] - fArr[4], 2.0d) + Math.pow(fArr[3] - fArr[5], 2.0d))};
    }

    public static RectF d(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i4 = 1; i4 < fArr.length; i4 += 2) {
            float round = Math.round(fArr[i4 - 1] * 10.0f) / 10.0f;
            float round2 = Math.round(fArr[i4] * 10.0f) / 10.0f;
            float f4 = rectF.left;
            if (round < f4) {
                f4 = round;
            }
            rectF.left = f4;
            float f5 = rectF.top;
            if (round2 < f5) {
                f5 = round2;
            }
            rectF.top = f5;
            float f6 = rectF.right;
            if (round <= f6) {
                round = f6;
            }
            rectF.right = round;
            float f7 = rectF.bottom;
            if (round2 <= f7) {
                round2 = f7;
            }
            rectF.bottom = round2;
        }
        rectF.sort();
        return rectF;
    }
}
