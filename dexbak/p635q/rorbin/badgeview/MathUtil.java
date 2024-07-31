package p635q.rorbin.badgeview;

import android.graphics.PointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* renamed from: q.rorbin.badgeview.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MathUtil {

    /* renamed from: a */
    public static final double f44596a = 6.283185307179586d;

    /* renamed from: a */
    public static void m2142a(PointF pointF, float f, Double d, List<PointF> list) {
        float f2;
        if (d != null) {
            double atan = (float) Math.atan(d.doubleValue());
            double cos = Math.cos(atan);
            double d2 = f;
            Double.isNaN(d2);
            double sin = Math.sin(atan);
            Double.isNaN(d2);
            f2 = (float) (sin * d2);
            f = (float) (cos * d2);
        } else {
            f2 = 0.0f;
        }
        list.add(new PointF(pointF.x + f, pointF.y + f2));
        list.add(new PointF(pointF.x - f, pointF.y - f2));
    }

    /* renamed from: b */
    public static float m2141b(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }

    /* renamed from: c */
    public static int m2140c(PointF pointF, PointF pointF2) {
        float f = pointF.x;
        float f2 = pointF2.x;
        if (f > f2) {
            float f3 = pointF.y;
            float f4 = pointF2.y;
            if (f3 > f4) {
                return 4;
            }
            return f3 < f4 ? 1 : -1;
        } else if (f < f2) {
            float f5 = pointF.y;
            float f6 = pointF2.y;
            if (f5 > f6) {
                return 3;
            }
            return f5 < f6 ? 2 : -1;
        } else {
            return -1;
        }
    }

    /* renamed from: d */
    public static double m2139d(double d, int i) {
        if (d < Utils.DOUBLE_EPSILON) {
            d += 1.5707963267948966d;
        }
        double d2 = i - 1;
        Double.isNaN(d2);
        return d + (d2 * 1.5707963267948966d);
    }

    /* renamed from: e */
    public static double m2138e(double d) {
        return (d / 6.283185307179586d) * 360.0d;
    }
}
