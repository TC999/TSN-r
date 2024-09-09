package q.rorbin.badgeview;

import android.graphics.PointF;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MathUtil.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final double f62000a = 6.283185307179586d;

    public static void a(PointF pointF, float f4, Double d4, List<PointF> list) {
        float f5;
        if (d4 != null) {
            double atan = (float) Math.atan(d4.doubleValue());
            double cos = Math.cos(atan);
            double d5 = f4;
            Double.isNaN(d5);
            double sin = Math.sin(atan);
            Double.isNaN(d5);
            f5 = (float) (sin * d5);
            f4 = (float) (cos * d5);
        } else {
            f5 = 0.0f;
        }
        list.add(new PointF(pointF.x + f4, pointF.y + f5));
        list.add(new PointF(pointF.x - f4, pointF.y - f5));
    }

    public static float b(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }

    public static int c(PointF pointF, PointF pointF2) {
        float f4 = pointF.x;
        float f5 = pointF2.x;
        if (f4 > f5) {
            float f6 = pointF.y;
            float f7 = pointF2.y;
            if (f6 > f7) {
                return 4;
            }
            return f6 < f7 ? 1 : -1;
        } else if (f4 < f5) {
            float f8 = pointF.y;
            float f9 = pointF2.y;
            if (f8 > f9) {
                return 3;
            }
            return f8 < f9 ? 2 : -1;
        } else {
            return -1;
        }
    }

    public static double d(double d4, int i4) {
        if (d4 < 0.0d) {
            d4 += 1.5707963267948966d;
        }
        double d5 = i4 - 1;
        Double.isNaN(d5);
        return d4 + (d5 * 1.5707963267948966d);
    }

    public static double e(double d4) {
        return (d4 / 6.283185307179586d) * 360.0d;
    }
}
