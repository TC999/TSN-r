package com.qq.e.comm.plugin.x;

import android.graphics.PointF;
import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {
    public static float a(List<PointF> list, List<PointF> list2, boolean z3) {
        float a4 = a(list, list2);
        if (z3) {
            Collections.reverse(list);
            return Math.max(a4, a(list, list2));
        }
        return a4;
    }

    private static float a(List<PointF> list, List<PointF> list2) {
        if (list == null || list2 == null) {
            return -1.0f;
        }
        int min = Math.min(list.size(), list2.size());
        if (min >= 20) {
            min = 20;
        }
        return a(list, list2, min);
    }

    private static float a(List<PointF> list, List<PointF> list2, int i4) {
        return a(a(a(list, i4)), a(a(list2, i4)));
    }

    private static List<PointF> a(List<PointF> list, int i4) {
        if (i4 <= 1) {
            d1.a("ShapeGestureRecognizer", "sample count <= 1 !");
            return list;
        }
        int size = list.size();
        if (i4 == size) {
            d1.a("ShapeGestureRecognizer", "sample count == path.size, no need resample!");
            return list;
        }
        double d4 = 0.0d;
        PointF pointF = list.get(0);
        for (int i5 = 1; i5 < size; i5++) {
            double a4 = a(pointF, list.get(i5));
            Double.isNaN(a4);
            d4 += a4;
            pointF = list.get(i5);
        }
        double d5 = i4 - 1;
        Double.isNaN(d5);
        List<PointF> a5 = a(list, d4 / d5);
        if (a5.size() < i4) {
            PointF pointF2 = list.get(size - 1);
            a5.add(new PointF(pointF2.x, pointF2.y));
        }
        return a5;
    }

    private static List<PointF> a(List<PointF> list, double d4) {
        int i4;
        double d5;
        int size = list.size();
        char c4 = 0;
        char c5 = 1;
        d1.a("ShapeGestureRecognizer", "point count %d, interval %f", Integer.valueOf(size), Double.valueOf(d4));
        if (size > 1 && d4 >= 1.0d) {
            ArrayList arrayList = new ArrayList();
            PointF pointF = list.get(0);
            arrayList.add(new PointF(pointF.x, pointF.y));
            int i5 = 1;
            double d6 = 0.0d;
            while (i5 < size) {
                PointF pointF2 = list.get(i5);
                double hypot = Math.hypot(pointF2.x - pointF.x, pointF2.y - pointF.y);
                double d7 = hypot + d6;
                Object[] objArr = new Object[3];
                objArr[c4] = Double.valueOf(d7);
                objArr[c5] = Double.valueOf(d4);
                objArr[2] = Double.valueOf(d6);
                d1.a("ShapeGestureRecognizer", "dd %f, interval %f, remain %f", objArr);
                while (true) {
                    int i6 = (d7 > d4 ? 1 : (d7 == d4 ? 0 : -1));
                    if (i6 >= 0) {
                        if (i6 == 0) {
                            i4 = size;
                            pointF = new PointF(pointF2.x, pointF2.y);
                            d5 = hypot;
                            d7 = 0.0d;
                        } else {
                            double d8 = (d4 - d6) / hypot;
                            float f4 = pointF.x;
                            double d9 = f4;
                            i4 = size;
                            double d10 = pointF2.x - f4;
                            Double.isNaN(d10);
                            Double.isNaN(d9);
                            double d11 = d9 + (d10 * d8);
                            float f5 = pointF.y;
                            d5 = hypot;
                            double d12 = f5;
                            double d13 = pointF2.y - f5;
                            Double.isNaN(d13);
                            Double.isNaN(d12);
                            d7 -= d4;
                            pointF = new PointF((float) d11, (float) (d12 + (d13 * d8)));
                        }
                        arrayList.add(pointF);
                        size = i4;
                        hypot = d5;
                    }
                }
                i5++;
                pointF = pointF2;
                d6 = d7;
                c4 = 0;
                c5 = 1;
            }
            return arrayList;
        }
        d1.a("ShapeGestureRecognizer", "point count <= 1 or interval < 1, no need resample!");
        return list;
    }

    private static float a(PointF pointF, PointF pointF2) {
        return (float) Math.hypot(pointF.x - pointF2.x, pointF.y - pointF2.y);
    }

    private static float a(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0 || fArr2.length == 0) {
            return -1.0f;
        }
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        for (int i4 = 0; i4 < fArr.length; i4++) {
            double d7 = fArr[i4] * fArr2[i4];
            Double.isNaN(d7);
            d4 += d7;
            d5 += Math.pow(fArr[i4], 2.0d);
            d6 += Math.pow(fArr2[i4], 2.0d);
        }
        return (float) (d4 / (Math.sqrt(d5) * Math.sqrt(d6)));
    }

    private static float[] a(List<PointF> list) {
        float[] fArr = new float[list.size() * 2];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        for (int i4 = 1; i4 < list.size(); i4++) {
            int i5 = i4 * 2;
            int i6 = i4 - 1;
            fArr[i5] = list.get(i4).x - list.get(i6).x;
            fArr[i5 + 1] = list.get(i4).y - list.get(i6).y;
        }
        return fArr;
    }
}
