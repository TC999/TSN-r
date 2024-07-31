package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.C3770j;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.bumptech.glide.load.resource.bitmap.z */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TransformationUtils {

    /* renamed from: a */
    private static final String f14174a = "TransformationUtils";

    /* renamed from: b */
    public static final int f14175b = 6;

    /* renamed from: d */
    private static final int f14177d = 7;

    /* renamed from: f */
    private static final Paint f14179f;

    /* renamed from: g */
    private static final Set<String> f14180g;

    /* renamed from: h */
    private static final Lock f14181h;

    /* renamed from: c */
    private static final Paint f14176c = new Paint(6);

    /* renamed from: e */
    private static final Paint f14178e = new Paint(7);

    /* compiled from: TransformationUtils.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.z$a  reason: invalid class name */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class locksLockC3726a implements Lock {
        locksLockC3726a() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f14180g = hashSet;
        f14181h = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new locksLockC3726a();
        Paint paint = new Paint(7);
        f14179f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private TransformationUtils() {
    }

    /* renamed from: a */
    private static void m44901a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = f14181h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f14176c);
            m44897e(canvas);
            lock.unlock();
        } catch (Throwable th) {
            f14181h.unlock();
            throw th;
        }
    }

    /* renamed from: b */
    public static Bitmap m44900b(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            f = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f + 0.5f), (int) (height + 0.5f));
        Bitmap mo45373e = bitmapPool.mo45373e(i, i2, m44891k(bitmap));
        m44884r(bitmap, mo45373e);
        m44901a(bitmap, mo45373e, matrix);
        return mo45373e;
    }

    /* renamed from: c */
    public static Bitmap m44899c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
            if (Log.isLoggable(f14174a, 2)) {
                Log.v(f14174a, "requested target size larger or equal to input, returning input");
            }
            return bitmap;
        }
        if (Log.isLoggable(f14174a, 2)) {
            Log.v(f14174a, "requested target size too big for input, fit centering instead");
        }
        return m44896f(bitmapPool, bitmap, i, i2);
    }

    /* renamed from: d */
    public static Bitmap m44898d(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        int min = Math.min(i, i2);
        float f = min;
        float f2 = f / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f / width, f / height);
        float f3 = width * max;
        float f4 = max * height;
        float f5 = (f - f3) / 2.0f;
        float f6 = (f - f4) / 2.0f;
        RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
        Bitmap m44895g = m44895g(bitmapPool, bitmap);
        Bitmap mo45373e = bitmapPool.mo45373e(min, min, m44894h(bitmap));
        mo45373e.setHasAlpha(true);
        Lock lock = f14181h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(mo45373e);
            canvas.drawCircle(f2, f2, f2, f14178e);
            canvas.drawBitmap(m44895g, (Rect) null, rectF, f14179f);
            m44897e(canvas);
            lock.unlock();
            if (!m44895g.equals(bitmap)) {
                bitmapPool.mo44924d(m44895g);
            }
            return mo45373e;
        } catch (Throwable th) {
            f14181h.unlock();
            throw th;
        }
    }

    /* renamed from: e */
    private static void m44897e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    /* renamed from: f */
    public static Bitmap m44896f(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable(f14174a, 2)) {
                Log.v(f14174a, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable(f14174a, 2)) {
                Log.v(f14174a, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap mo45373e = bitmapPool.mo45373e((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), m44891k(bitmap));
        m44884r(bitmap, mo45373e);
        if (Log.isLoggable(f14174a, 2)) {
            Log.v(f14174a, "request: " + i + "x" + i2);
            Log.v(f14174a, "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v(f14174a, "toReuse: " + mo45373e.getWidth() + "x" + mo45373e.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v(f14174a, sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        m44901a(bitmap, mo45373e, matrix);
        return mo45373e;
    }

    /* renamed from: g */
    private static Bitmap m44895g(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap) {
        Bitmap.Config m44894h = m44894h(bitmap);
        if (m44894h.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap mo45373e = bitmapPool.mo45373e(bitmap.getWidth(), bitmap.getHeight(), m44894h);
        new Canvas(mo45373e).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return mo45373e;
    }

    @NonNull
    /* renamed from: h */
    private static Bitmap.Config m44894h(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    /* renamed from: i */
    public static Lock m44893i() {
        return f14181h;
    }

    /* renamed from: j */
    public static int m44892j(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return BitmapUtils.ROTATE270;
            default:
                return 0;
        }
    }

    @NonNull
    /* renamed from: k */
    private static Bitmap.Config m44891k(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    @VisibleForTesting
    /* renamed from: l */
    static void m44890l(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    /* renamed from: m */
    public static boolean m44889m(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: n */
    public static Bitmap m44888n(@NonNull Bitmap bitmap, int i) {
        if (i != 0) {
            try {
                Matrix matrix = new Matrix();
                matrix.setRotate(i);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e) {
                if (Log.isLoggable(f14174a, 6)) {
                    Log.e(f14174a, "Exception when trying to orient image", e);
                    return bitmap;
                }
                return bitmap;
            }
        }
        return bitmap;
    }

    /* renamed from: o */
    public static Bitmap m44887o(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i) {
        if (m44889m(i)) {
            Matrix matrix = new Matrix();
            m44890l(i, matrix);
            RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            matrix.mapRect(rectF);
            Bitmap mo45373e = bitmapPool.mo45373e(Math.round(rectF.width()), Math.round(rectF.height()), m44891k(bitmap));
            matrix.postTranslate(-rectF.left, -rectF.top);
            mo45373e.setHasAlpha(bitmap.hasAlpha());
            m44901a(bitmap, mo45373e, matrix);
            return mo45373e;
        }
        return bitmap;
    }

    /* renamed from: p */
    public static Bitmap m44886p(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i) {
        C3770j.m44395a(i > 0, "roundingRadius must be greater than 0.");
        Bitmap.Config m44894h = m44894h(bitmap);
        Bitmap m44895g = m44895g(bitmapPool, bitmap);
        Bitmap mo45373e = bitmapPool.mo45373e(m44895g.getWidth(), m44895g.getHeight(), m44894h);
        mo45373e.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(m44895g, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, mo45373e.getWidth(), mo45373e.getHeight());
        Lock lock = f14181h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(mo45373e);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            float f = i;
            canvas.drawRoundRect(rectF, f, f, paint);
            m44897e(canvas);
            lock.unlock();
            if (!m44895g.equals(bitmap)) {
                bitmapPool.mo44924d(m44895g);
            }
            return mo45373e;
        } catch (Throwable th) {
            f14181h.unlock();
            throw th;
        }
    }

    @Deprecated
    /* renamed from: q */
    public static Bitmap m44885q(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2, int i3) {
        return m44886p(bitmapPool, bitmap, i3);
    }

    /* renamed from: r */
    public static void m44884r(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
