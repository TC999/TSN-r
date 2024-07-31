package com.yalantis.ucrop.util;

import android.graphics.RectF;

/* renamed from: com.yalantis.ucrop.util.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RectUtils {
    /* renamed from: a */
    public static float[] m12982a(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    /* renamed from: b */
    public static float[] m12981b(RectF rectF) {
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        return new float[]{f, f2, f3, f2, f3, f4, f, f4};
    }

    /* renamed from: c */
    public static float[] m12980c(float[] fArr) {
        return new float[]{(float) Math.sqrt(Math.pow(fArr[0] - fArr[2], 2.0d) + Math.pow(fArr[1] - fArr[3], 2.0d)), (float) Math.sqrt(Math.pow(fArr[2] - fArr[4], 2.0d) + Math.pow(fArr[3] - fArr[5], 2.0d))};
    }

    /* renamed from: d */
    public static RectF m12979d(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i = 1; i < fArr.length; i += 2) {
            float round = Math.round(fArr[i - 1] * 10.0f) / 10.0f;
            float round2 = Math.round(fArr[i] * 10.0f) / 10.0f;
            float f = rectF.left;
            if (round < f) {
                f = round;
            }
            rectF.left = f;
            float f2 = rectF.top;
            if (round2 < f2) {
                f2 = round2;
            }
            rectF.top = f2;
            float f3 = rectF.right;
            if (round <= f3) {
                round = f3;
            }
            rectF.right = round;
            float f4 = rectF.bottom;
            if (round2 <= f4) {
                round2 = f4;
            }
            rectF.bottom = round2;
        }
        rectF.sort();
        return rectF;
    }
}
