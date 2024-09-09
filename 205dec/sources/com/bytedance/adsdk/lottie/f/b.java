package com.bytedance.adsdk.lottie.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import com.bytedance.adsdk.lottie.c.c.i;
import com.bytedance.adsdk.lottie.c.w.l;
import com.bytedance.adsdk.lottie.s;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<PathMeasure> f25604a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<Path> f25605b = new C0352b();

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<Path> f25606c = new c();

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<float[]> f25607d = new d();

    /* renamed from: e  reason: collision with root package name */
    private static final float f25608e = (float) (Math.sqrt(2.0d) / 2.0d);

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class a extends ThreadLocal<PathMeasure> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* renamed from: com.bytedance.adsdk.lottie.f.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class C0352b extends ThreadLocal<Path> {
        C0352b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Path initialValue() {
            return new Path();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class c extends ThreadLocal<Path> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Path initialValue() {
            return new Path();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class d extends ThreadLocal<float[]> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public float[] initialValue() {
            return new float[4];
        }
    }

    public static float a() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float b(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float c(Matrix matrix) {
        float[] fArr = f25607d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f4 = f25608e;
        fArr[2] = f4;
        fArr[3] = f4;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static int d(float f4, float f5, float f6, float f7) {
        int i4 = f4 != 0.0f ? (int) (527 * f4) : 17;
        if (f5 != 0.0f) {
            i4 = (int) (i4 * 31 * f5);
        }
        if (f6 != 0.0f) {
            i4 = (int) (i4 * 31 * f6);
        }
        return f7 != 0.0f ? (int) (i4 * 31 * f7) : i4;
    }

    public static Bitmap e(Bitmap bitmap, int i4, int i5) {
        if (bitmap.getWidth() == i4 && bitmap.getHeight() == i5) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i4, i5, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static Path f(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f4 = pointF.x;
            float f5 = pointF2.x;
            float f6 = pointF2.y;
            path.cubicTo(pointF3.x + f4, pointF.y + pointF3.y, f5 + pointF4.x, f6 + pointF4.y, f5, f6);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void g(Canvas canvas, RectF rectF, Paint paint) {
        h(canvas, rectF, paint, 31);
    }

    public static void h(Canvas canvas, RectF rectF, Paint paint, int i4) {
        s.b("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i4);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        s.d("Utils#saveLayer");
    }

    public static void i(Path path, float f4, float f5, float f6) {
        s.b("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f25604a.get();
        Path path2 = f25605b.get();
        Path path3 = f25606c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f4 == 1.0f && f5 == 0.0f) {
            s.d("applyTrimPathIfNeeded");
        } else if (length >= 1.0f && Math.abs((f5 - f4) - 1.0f) >= 0.01d) {
            float f7 = f4 * length;
            float f8 = f5 * length;
            float f9 = f6 * length;
            float min = Math.min(f7, f8) + f9;
            float max = Math.max(f7, f8) + f9;
            if (min >= length && max >= length) {
                min = com.bytedance.adsdk.lottie.f.d.b(min, length);
                max = com.bytedance.adsdk.lottie.f.d.b(max, length);
            }
            if (min < 0.0f) {
                min = com.bytedance.adsdk.lottie.f.d.b(min, length);
            }
            if (max < 0.0f) {
                max = com.bytedance.adsdk.lottie.f.d.b(max, length);
            }
            if (min == max) {
                path.reset();
                s.d("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            s.d("applyTrimPathIfNeeded");
        } else {
            s.d("applyTrimPathIfNeeded");
        }
    }

    public static void j(Path path, i iVar) {
        if (iVar == null || iVar.g()) {
            return;
        }
        i(path, ((l) iVar.h()).i() / 100.0f, ((l) iVar.i()).i() / 100.0f, ((l) iVar.f()).i() / 360.0f);
    }

    public static void k(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean l(int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i4 < i7) {
            return false;
        }
        if (i4 > i7) {
            return true;
        }
        if (i5 < i8) {
            return false;
        }
        return i5 > i8 || i6 >= i9;
    }

    public static boolean m(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static boolean n(Matrix matrix) {
        float[] fArr = f25607d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }
}
