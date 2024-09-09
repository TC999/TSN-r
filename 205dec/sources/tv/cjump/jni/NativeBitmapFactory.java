package tv.cjump.jni;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class NativeBitmapFactory {

    /* renamed from: a  reason: collision with root package name */
    static Field f64408a;

    /* renamed from: b  reason: collision with root package name */
    static boolean f64409b;

    /* renamed from: c  reason: collision with root package name */
    static boolean f64410c;

    public static Bitmap a(int i4, int i5, Bitmap.Config config) {
        return b(i4, i5, config, config.equals(Bitmap.Config.ARGB_4444) || config.equals(Bitmap.Config.ARGB_8888));
    }

    public static synchronized Bitmap b(int i4, int i5, Bitmap.Config config, boolean z3) {
        synchronized (NativeBitmapFactory.class) {
            if (f64409b && f64408a != null) {
                return c(i4, i5, config, z3);
            }
            return Bitmap.createBitmap(i4, i5, config);
        }
    }

    private static Bitmap c(int i4, int i5, Bitmap.Config config, boolean z3) {
        int d4 = d(config);
        return Build.VERSION.SDK_INT == 19 ? createBitmap19(i4, i5, d4, z3) : createBitmap(i4, i5, d4, z3);
    }

    private static native Bitmap createBitmap(int i4, int i5, int i6, boolean z3);

    private static native Bitmap createBitmap19(int i4, int i5, int i6, boolean z3);

    public static int d(Bitmap.Config config) {
        try {
            Field field = f64408a;
            if (field == null) {
                return 0;
            }
            return field.getInt(config);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    static void e() {
        try {
            Field declaredField = Bitmap.Config.class.getDeclaredField("nativeInt");
            f64408a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e4) {
            f64408a = null;
            e4.printStackTrace();
        }
    }

    public static boolean f() {
        return f64409b && f64408a != null;
    }

    public static void g() {
        if (f64410c) {
            return;
        }
        if (!DeviceUtils.h() && !DeviceUtils.i()) {
            f64410c = true;
            f64409b = false;
        } else if (f64409b) {
        } else {
            try {
                if (Build.VERSION.SDK_INT < 23) {
                    System.loadLibrary("ndkbitmap");
                    f64409b = true;
                } else {
                    f64410c = true;
                    f64409b = false;
                }
            } catch (Error e4) {
                e4.printStackTrace();
                f64410c = true;
                f64409b = false;
            } catch (Exception e5) {
                e5.printStackTrace();
                f64410c = true;
                f64409b = false;
            }
            if (f64409b) {
                if (!init()) {
                    release();
                    f64410c = true;
                    f64409b = false;
                } else {
                    e();
                    if (!j()) {
                        release();
                        f64410c = true;
                        f64409b = false;
                    }
                }
            }
            Log.e("NativeBitmapFactory", "loaded" + f64409b);
        }
    }

    public static void h(Bitmap bitmap) {
        bitmap.recycle();
    }

    public static synchronized void i() {
        synchronized (NativeBitmapFactory.class) {
            boolean z3 = f64409b;
            f64408a = null;
            f64409b = false;
            if (z3) {
                release();
            }
        }
    }

    private static native boolean init();

    @SuppressLint({"NewApi"})
    private static boolean j() {
        if (f64408a == null) {
            return false;
        }
        Bitmap bitmap = null;
        try {
            try {
                bitmap = c(2, 2, Bitmap.Config.ARGB_8888, true);
                boolean z3 = bitmap != null && bitmap.getWidth() == 2 && bitmap.getHeight() == 2;
                if (z3) {
                    if (!bitmap.isPremultiplied()) {
                        bitmap.setPremultiplied(true);
                    }
                    Canvas canvas = new Canvas(bitmap);
                    Paint paint = new Paint();
                    paint.setColor(-65536);
                    paint.setTextSize(20.0f);
                    canvas.drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), paint);
                    canvas.drawText("TestLib", 0.0f, 0.0f, paint);
                    z3 = bitmap.isPremultiplied();
                }
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return z3;
            } catch (Error unused) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return false;
            } catch (Exception e4) {
                Log.e("NativeBitmapFactory", "exception:" + e4.toString());
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return false;
            }
        } catch (Throwable th) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    private static native boolean release();
}
