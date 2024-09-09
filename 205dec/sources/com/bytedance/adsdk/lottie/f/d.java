package com.bytedance.adsdk.lottie.f;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.xv.w.i;
import com.bytedance.component.sdk.annotation.FloatRange;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final PointF f25611a = new PointF();

    public static float a(float f4, float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return f4 + (f6 * (f5 - f4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(float f4, float f5) {
        return c((int) f4, (int) f5);
    }

    private static int c(int i4, int i5) {
        return i4 - (i5 * i(i4, i5));
    }

    public static int d(int i4, int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return (int) (i4 + (f4 * (i5 - i4)));
    }

    public static int e(int i4, int i5, int i6) {
        return Math.max(i5, Math.min(i6, i4));
    }

    public static PointF f(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void g(i iVar, Path path) {
        path.reset();
        PointF a4 = iVar.a();
        path.moveTo(a4.x, a4.y);
        f25611a.set(a4.x, a4.y);
        for (int i4 = 0; i4 < iVar.f().size(); i4++) {
            com.bytedance.adsdk.lottie.xv.a aVar = iVar.f().get(i4);
            PointF a5 = aVar.a();
            PointF c4 = aVar.c();
            PointF e4 = aVar.e();
            PointF pointF = f25611a;
            if (a5.equals(pointF) && c4.equals(e4)) {
                path.lineTo(e4.x, e4.y);
            } else {
                path.cubicTo(a5.x, a5.y, c4.x, c4.y, e4.x, e4.y);
            }
            pointF.set(e4.x, e4.y);
        }
        if (iVar.e()) {
            path.close();
        }
    }

    public static float h(float f4, float f5, float f6) {
        return Math.max(f5, Math.min(f6, f4));
    }

    private static int i(int i4, int i5) {
        int i6 = i4 / i5;
        return (((i4 ^ i5) >= 0) || i4 % i5 == 0) ? i6 : i6 - 1;
    }

    public static boolean j(float f4, float f5, float f6) {
        return f4 >= f5 && f4 <= f6;
    }
}
