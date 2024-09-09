package com.bytedance.sdk.component.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r1 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L26
            r1.<init>()     // Catch: java.lang.Throwable -> L26
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L27
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.lang.Throwable -> L27
            r1.flush()     // Catch: java.lang.Throwable -> L27
            r1.close()     // Catch: java.lang.Throwable -> L27
            byte[] r4 = r1.toByteArray()     // Catch: java.lang.Throwable -> L27
            r2 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r4, r2)     // Catch: java.lang.Throwable -> L27
        L1f:
            r1.flush()     // Catch: java.lang.Throwable -> L2a
            r1.close()     // Catch: java.lang.Throwable -> L2a
            goto L2a
        L26:
            r1 = r0
        L27:
            if (r1 == 0) goto L2a
            goto L1f
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.sr.c(android.graphics.Bitmap):java.lang.String");
    }

    public static byte[] w(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Bitmap c(Bitmap bitmap, int i4, int i5) {
        if (bitmap == null) {
            return null;
        }
        if (i4 <= 0 || i5 <= 0) {
            return bitmap;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i4 < width && i5 < height) {
                Matrix matrix = new Matrix();
                matrix.postScale(i4 / width, i5 / height);
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
            return bitmap;
        } catch (Throwable th) {
            a.c(th.getMessage());
            return null;
        }
    }
}
