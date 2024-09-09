package master.flame.danmaku.controller;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DrawHelper.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Paint f60960a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Paint f60961b = null;

    /* renamed from: c  reason: collision with root package name */
    public static RectF f60962c = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f60963d = true;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f60964e = true;

    static {
        Paint paint = new Paint();
        f60960a = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        f60960a.setColor(0);
        f60962c = new RectF();
    }

    public static void a(Canvas canvas) {
        if (f60963d) {
            if (f60964e) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        f60962c.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        c(canvas, f60962c);
    }

    public static void b(Canvas canvas, float f4, float f5, float f6, float f7) {
        f60962c.set(f4, f5, f6, f7);
        c(canvas, f60962c);
    }

    private static void c(Canvas canvas, RectF rectF) {
        if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
            return;
        }
        canvas.drawRect(rectF, f60960a);
    }

    public static void d(Canvas canvas, String str) {
        if (f60961b == null) {
            Paint paint = new Paint();
            f60961b = paint;
            paint.setColor(-65536);
            f60961b.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        b(canvas, 10.0f, height - 50, (int) (f60961b.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, f60961b);
    }

    public static void e(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    public static void f(boolean z3, boolean z4) {
        f60963d = z3;
        f60964e = z4;
    }
}
