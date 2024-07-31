package tv.cjump.jni;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import java.lang.reflect.Field;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class NativeBitmapFactory {

    /* renamed from: a */
    static Field f47132a;

    /* renamed from: b */
    static boolean f47133b;

    /* renamed from: c */
    static boolean f47134c;

    /* renamed from: a */
    public static Bitmap m267a(int i, int i2, Bitmap.Config config) {
        return m266b(i, i2, config, config.equals(Bitmap.Config.ARGB_4444) || config.equals(Bitmap.Config.ARGB_8888));
    }

    /* renamed from: b */
    public static synchronized Bitmap m266b(int i, int i2, Bitmap.Config config, boolean z) {
        synchronized (NativeBitmapFactory.class) {
            if (f47133b && f47132a != null) {
                return m265c(i, i2, config, z);
            }
            return Bitmap.createBitmap(i, i2, config);
        }
    }

    /* renamed from: c */
    private static Bitmap m265c(int i, int i2, Bitmap.Config config, boolean z) {
        int m264d = m264d(config);
        return Build.VERSION.SDK_INT == 19 ? createBitmap19(i, i2, m264d, z) : createBitmap(i, i2, m264d, z);
    }

    private static native Bitmap createBitmap(int i, int i2, int i3, boolean z);

    private static native Bitmap createBitmap19(int i, int i2, int i3, boolean z);

    /* renamed from: d */
    public static int m264d(Bitmap.Config config) {
        try {
            Field field = f47132a;
            if (field == null) {
                return 0;
            }
            return field.getInt(config);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* renamed from: e */
    static void m263e() {
        try {
            Field declaredField = Bitmap.Config.class.getDeclaredField("nativeInt");
            f47132a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            f47132a = null;
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public static boolean m262f() {
        return f47133b && f47132a != null;
    }

    /* renamed from: g */
    public static void m261g() {
        if (f47134c) {
            return;
        }
        if (!DeviceUtils.m272h() && !DeviceUtils.m271i()) {
            f47134c = true;
            f47133b = false;
        } else if (f47133b) {
        } else {
            try {
                if (Build.VERSION.SDK_INT < 23) {
                    System.loadLibrary("ndkbitmap");
                    f47133b = true;
                } else {
                    f47134c = true;
                    f47133b = false;
                }
            } catch (Error e) {
                e.printStackTrace();
                f47134c = true;
                f47133b = false;
            } catch (Exception e2) {
                e2.printStackTrace();
                f47134c = true;
                f47133b = false;
            }
            if (f47133b) {
                if (!init()) {
                    release();
                    f47134c = true;
                    f47133b = false;
                } else {
                    m263e();
                    if (!m258j()) {
                        release();
                        f47134c = true;
                        f47133b = false;
                    }
                }
            }
            Log.e("NativeBitmapFactory", "loaded" + f47133b);
        }
    }

    /* renamed from: h */
    public static void m260h(Bitmap bitmap) {
        bitmap.recycle();
    }

    /* renamed from: i */
    public static synchronized void m259i() {
        synchronized (NativeBitmapFactory.class) {
            boolean z = f47133b;
            f47132a = null;
            f47133b = false;
            if (z) {
                release();
            }
        }
    }

    private static native boolean init();

    @SuppressLint({"NewApi"})
    /* renamed from: j */
    private static boolean m258j() {
        if (f47132a == null) {
            return false;
        }
        Bitmap bitmap = null;
        try {
            try {
                bitmap = m265c(2, 2, Bitmap.Config.ARGB_8888, true);
                boolean z = bitmap != null && bitmap.getWidth() == 2 && bitmap.getHeight() == 2;
                if (z) {
                    if (!bitmap.isPremultiplied()) {
                        bitmap.setPremultiplied(true);
                    }
                    Canvas canvas = new Canvas(bitmap);
                    Paint paint = new Paint();
                    paint.setColor(SupportMenu.CATEGORY_MASK);
                    paint.setTextSize(20.0f);
                    canvas.drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), paint);
                    canvas.drawText("TestLib", 0.0f, 0.0f, paint);
                    z = bitmap.isPremultiplied();
                }
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return z;
            } catch (Error unused) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return false;
            } catch (Exception e) {
                Log.e("NativeBitmapFactory", "exception:" + e.toString());
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
