package com.github.mikephil.charting.data.filter;

import android.annotation.TargetApi;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class Approximator {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private class Line {
        private float dx;
        private float dy;
        private float exsy;
        private float length;
        private float[] points;
        private float sxey;

        public Line(float f4, float f5, float f6, float f7) {
            float f8 = f4 - f6;
            this.dx = f8;
            float f9 = f5 - f7;
            this.dy = f9;
            this.sxey = f4 * f7;
            this.exsy = f6 * f5;
            this.length = (float) Math.sqrt((f8 * f8) + (f9 * f9));
            this.points = new float[]{f4, f5, f6, f7};
        }

        public float distance(float f4, float f5) {
            return Math.abs((((this.dy * f4) - (this.dx * f5)) + this.sxey) - this.exsy) / this.length;
        }

        public float[] getPoints() {
            return this.points;
        }
    }

    float[] concat(float[]... fArr) {
        int i4 = 0;
        for (float[] fArr2 : fArr) {
            i4 += fArr2.length;
        }
        float[] fArr3 = new float[i4];
        int i5 = 0;
        for (float[] fArr4 : fArr) {
            for (float f4 : fArr4) {
                fArr3[i5] = f4;
                i5++;
            }
        }
        return fArr3;
    }

    @TargetApi(9)
    public float[] reduceWithDouglasPeucker(float[] fArr, float f4) {
        Line line = new Line(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1]);
        float f5 = 0.0f;
        int i4 = 0;
        for (int i5 = 2; i5 < fArr.length - 2; i5 += 2) {
            float distance = line.distance(fArr[i5], fArr[i5 + 1]);
            if (distance > f5) {
                i4 = i5;
                f5 = distance;
            }
        }
        if (f5 > f4) {
            float[] reduceWithDouglasPeucker = reduceWithDouglasPeucker(Arrays.copyOfRange(fArr, 0, i4 + 2), f4);
            float[] reduceWithDouglasPeucker2 = reduceWithDouglasPeucker(Arrays.copyOfRange(fArr, i4, fArr.length), f4);
            return concat(reduceWithDouglasPeucker, Arrays.copyOfRange(reduceWithDouglasPeucker2, 2, reduceWithDouglasPeucker2.length));
        }
        return line.getPoints();
    }
}
