package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: BGAQRCodeUtil.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1597a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap a(Bitmap bitmap, int i4) {
        float height;
        float width;
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i4, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        if (i4 == 90) {
            height = bitmap.getHeight();
            width = 0.0f;
        } else {
            height = bitmap.getHeight();
            width = bitmap.getWidth();
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        matrix.postTranslate(height - fArr[2], width - fArr[5]);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint());
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(MotionEvent motionEvent) {
        float x3 = motionEvent.getX(0) - motionEvent.getX(1);
        float y3 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x3 * x3) + (y3 * y3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect c(float f4, float f5, float f6, int i4, int i5, int i6, int i7) {
        int i8 = (int) ((i4 * f4) / 2.0f);
        int i9 = (int) ((i5 * f4) / 2.0f);
        int i10 = (int) (((f5 / i6) * 2000.0f) - 1000.0f);
        int i11 = (int) (((f6 / i7) * 2000.0f) - 1000.0f);
        RectF rectF = new RectF(d(i10 - i8, -1000, 1000), d(i11 - i9, -1000, 1000), d(i10 + i8, -1000, 1000), d(i11 + i9, -1000, 1000));
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    static int d(int i4, int i5, int i6) {
        return Math.min(Math.max(i4, i5), i6);
    }

    public static void e(String str) {
        f("BGAQRCode", str);
    }

    public static void f(String str, String str2) {
        if (f1597a) {
            Log.d(str, str2);
        }
    }

    public static int g(Context context, float f4) {
        return (int) TypedValue.applyDimension(1, f4, context.getResources().getDisplayMetrics());
    }

    public static void h(String str) {
        if (f1597a) {
            Log.e("BGAQRCode", str);
        }
    }

    public static Bitmap i(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i4 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i5 = options.outHeight / 400;
            if (i5 > 0) {
                i4 = i5;
            }
            options.inSampleSize = i4;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Point j(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static int k(Context context) {
        int identifier;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843277});
        boolean z3 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (!z3 && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean l() {
        return f1597a;
    }

    public static boolean m(Context context) {
        Point j4 = j(context);
        return j4.y > j4.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap n(Bitmap bitmap, int i4) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i4, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static void o(String str, Rect rect) {
        f("BGAQRCodeFocusArea", str + " centerX\uff1a" + rect.centerX() + " centerY\uff1a" + rect.centerY() + " width\uff1a" + rect.width() + " height\uff1a" + rect.height() + " rectHalfWidth\uff1a" + (rect.width() / 2) + " rectHalfHeight\uff1a" + (rect.height() / 2) + " left\uff1a" + rect.left + " top\uff1a" + rect.top + " right\uff1a" + rect.right + " bottom\uff1a" + rect.bottom);
    }

    public static void p(boolean z3) {
        f1597a = z3;
    }

    public static int q(Context context, float f4) {
        return (int) TypedValue.applyDimension(2, f4, context.getResources().getDisplayMetrics());
    }
}
