package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.yalantis.ucrop.task.BitmapLoadTask;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import p028c1.BitmapLoadCallback;

/* renamed from: com.yalantis.ucrop.util.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BitmapLoadUtils {

    /* renamed from: a */
    private static final String f39874a = "BitmapLoadUtils";

    /* renamed from: a */
    public static int m13019a(@NonNull BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            while (true) {
                if (i3 / i5 <= i2 && i4 / i5 <= i) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    /* renamed from: b */
    public static int m13018b(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int sqrt = (int) Math.sqrt(Math.pow(point.x, 2.0d) + Math.pow(point.y, 2.0d));
        Canvas canvas = new Canvas();
        int min = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (min > 0) {
            sqrt = Math.min(sqrt, min);
        }
        int m13006c = EglUtils.m13006c();
        if (m13006c > 0) {
            sqrt = Math.min(sqrt, m13006c);
        }
        Log.d(f39874a, "maxBitmapSize: " + sqrt);
        return sqrt;
    }

    /* renamed from: c */
    public static void m13017c(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: d */
    public static void m13016d(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        new BitmapLoadTask(context, uri, uri2, i, i2, bitmapLoadCallback).execute(new Void[0]);
    }

    /* renamed from: e */
    public static int m13015e(int i) {
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

    /* renamed from: f */
    public static int m13014f(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    /* renamed from: g */
    public static int m13013g(@NonNull Context context, @NonNull Uri uri) {
        int i = 0;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return 0;
            }
            i = new ImageHeaderParser(openInputStream).m12994c();
            m13017c(openInputStream);
            return i;
        } catch (IOException e) {
            Log.e(f39874a, "getExifOrientation: " + uri.toString(), e);
            return i;
        }
    }

    /* renamed from: h */
    public static Bitmap m13012h(@NonNull Bitmap bitmap, @NonNull Matrix matrix) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !bitmap.sameAs(createBitmap) ? createBitmap : bitmap;
        } catch (OutOfMemoryError e) {
            Log.e(f39874a, "transformBitmap: ", e);
            return bitmap;
        }
    }
}
