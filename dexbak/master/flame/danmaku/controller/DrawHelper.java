package master.flame.danmaku.controller;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.core.internal.view.SupportMenu;

/* renamed from: master.flame.danmaku.controller.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DrawHelper {

    /* renamed from: a */
    public static Paint f43644a = null;

    /* renamed from: b */
    public static Paint f43645b = null;

    /* renamed from: c */
    public static RectF f43646c = null;

    /* renamed from: d */
    private static boolean f43647d = true;

    /* renamed from: e */
    private static boolean f43648e = true;

    static {
        Paint paint = new Paint();
        f43644a = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        f43644a.setColor(0);
        f43646c = new RectF();
    }

    /* renamed from: a */
    public static void m3299a(Canvas canvas) {
        if (f43647d) {
            if (f43648e) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        f43646c.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        m3297c(canvas, f43646c);
    }

    /* renamed from: b */
    public static void m3298b(Canvas canvas, float f, float f2, float f3, float f4) {
        f43646c.set(f, f2, f3, f4);
        m3297c(canvas, f43646c);
    }

    /* renamed from: c */
    private static void m3297c(Canvas canvas, RectF rectF) {
        if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
            return;
        }
        canvas.drawRect(rectF, f43644a);
    }

    /* renamed from: d */
    public static void m3296d(Canvas canvas, String str) {
        if (f43645b == null) {
            Paint paint = new Paint();
            f43645b = paint;
            paint.setColor(SupportMenu.CATEGORY_MASK);
            f43645b.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        m3298b(canvas, 10.0f, height - 50, (int) (f43645b.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, f43645b);
    }

    /* renamed from: e */
    public static void m3295e(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    /* renamed from: f */
    public static void m3294f(boolean z, boolean z2) {
        f43647d = z;
        f43648e = z2;
    }
}
