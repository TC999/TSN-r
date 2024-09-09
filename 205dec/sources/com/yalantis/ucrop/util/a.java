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
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BitmapLoadUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f54410a = "BitmapLoadUtils";

    public static int a(@NonNull BitmapFactory.Options options, int i4, int i5) {
        int i6 = options.outHeight;
        int i7 = options.outWidth;
        int i8 = 1;
        if (i6 > i5 || i7 > i4) {
            while (true) {
                if (i6 / i8 <= i5 && i7 / i8 <= i4) {
                    break;
                }
                i8 *= 2;
            }
        }
        return i8;
    }

    public static int b(@NonNull Context context) {
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
        int c4 = c.c();
        if (c4 > 0) {
            sqrt = Math.min(sqrt, c4);
        }
        Log.d("BitmapLoadUtils", "maxBitmapSize: " + sqrt);
        return sqrt;
    }

    public static void c(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i4, int i5, c1.b bVar) {
        new com.yalantis.ucrop.task.b(context, uri, uri2, i4, i5, bVar).execute(new Void[0]);
    }

    public static int e(int i4) {
        switch (i4) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int f(int i4) {
        return (i4 == 2 || i4 == 7 || i4 == 4 || i4 == 5) ? -1 : 1;
    }

    public static int g(@NonNull Context context, @NonNull Uri uri) {
        int i4 = 0;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return 0;
            }
            i4 = new f(openInputStream).c();
            c(openInputStream);
            return i4;
        } catch (IOException e4) {
            Log.e("BitmapLoadUtils", "getExifOrientation: " + uri.toString(), e4);
            return i4;
        }
    }

    public static Bitmap h(@NonNull Bitmap bitmap, @NonNull Matrix matrix) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !bitmap.sameAs(createBitmap) ? createBitmap : bitmap;
        } catch (OutOfMemoryError e4) {
            Log.e("BitmapLoadUtils", "transformBitmap: ", e4);
            return bitmap;
        }
    }
}
