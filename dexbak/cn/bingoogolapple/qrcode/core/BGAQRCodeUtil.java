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
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.baidu.idl.face.platform.FaceEnvironment;

/* renamed from: cn.bingoogolapple.qrcode.core.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class BGAQRCodeUtil {

    /* renamed from: a */
    private static boolean f1610a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Bitmap m57976a(Bitmap bitmap, int i) {
        float height;
        float width;
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        if (i == 90) {
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
    /* renamed from: b */
    public static float m57975b(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static Rect m57974c(float f, float f2, float f3, int i, int i2, int i3, int i4) {
        int i5 = (int) ((i * f) / 2.0f);
        int i6 = (int) ((i2 * f) / 2.0f);
        int i7 = (int) (((f2 / i3) * 2000.0f) - 1000.0f);
        int i8 = (int) (((f3 / i4) * 2000.0f) - 1000.0f);
        RectF rectF = new RectF(m57973d(i7 - i5, -1000, 1000), m57973d(i8 - i6, -1000, 1000), m57973d(i7 + i5, -1000, 1000), m57973d(i8 + i6, -1000, 1000));
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    /* renamed from: d */
    static int m57973d(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    /* renamed from: e */
    public static void m57972e(String str) {
        m57971f("BGAQRCode", str);
    }

    /* renamed from: f */
    public static void m57971f(String str, String str2) {
        if (f1610a) {
            Log.d(str, str2);
        }
    }

    /* renamed from: g */
    public static int m57970g(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    /* renamed from: h */
    public static void m57969h(String str) {
        if (f1610a) {
            Log.e("BGAQRCode", str);
        }
    }

    /* renamed from: i */
    public static Bitmap m57968i(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outHeight / FontStyle.WEIGHT_NORMAL;
            if (i2 > 0) {
                i = i2;
            }
            options.inSampleSize = i;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static Point m57967j(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    /* renamed from: k */
    public static int m57966k(Context context) {
        int identifier;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843277});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (!z && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.f8430OS)) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: l */
    public static boolean m57965l() {
        return f1610a;
    }

    /* renamed from: m */
    public static boolean m57964m(Context context) {
        Point m57967j = m57967j(context);
        return m57967j.y > m57967j.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static Bitmap m57963n(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    /* renamed from: o */
    public static void m57962o(String str, Rect rect) {
        m57971f("BGAQRCodeFocusArea", str + " centerX：" + rect.centerX() + " centerY：" + rect.centerY() + " width：" + rect.width() + " height：" + rect.height() + " rectHalfWidth：" + (rect.width() / 2) + " rectHalfHeight：" + (rect.height() / 2) + " left：" + rect.left + " top：" + rect.top + " right：" + rect.right + " bottom：" + rect.bottom);
    }

    /* renamed from: p */
    public static void m57961p(boolean z) {
        f1610a = z;
    }

    /* renamed from: q */
    public static int m57960q(Context context, float f) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
