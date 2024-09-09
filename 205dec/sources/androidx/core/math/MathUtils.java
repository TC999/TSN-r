package androidx.core.math;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static double clamp(double d4, double d5, double d6) {
        return d4 < d5 ? d5 : d4 > d6 ? d6 : d4;
    }

    public static float clamp(float f4, float f5, float f6) {
        return f4 < f5 ? f5 : f4 > f6 ? f6 : f4;
    }

    public static int clamp(int i4, int i5, int i6) {
        return i4 < i5 ? i5 : i4 > i6 ? i6 : i4;
    }

    public static long clamp(long j4, long j5, long j6) {
        return j4 < j5 ? j5 : j4 > j6 ? j6 : j4;
    }
}
