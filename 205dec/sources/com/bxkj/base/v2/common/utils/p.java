package com.bxkj.base.v2.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PhotoBitmapUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18631a = "/MyPhoto";

    /* renamed from: b  reason: collision with root package name */
    public static final String f18632b = "yyyyMMddHHmmss";

    /* renamed from: c  reason: collision with root package name */
    public static final String f18633c = ".png";

    private p() {
    }

    public static String a(String str, Context context) {
        return h(f(e(str), b(str)), context);
    }

    public static Bitmap b(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = 10;
        return BitmapFactory.decodeFile(str, options);
    }

    private static String c(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted") && Environment.isExternalStorageRemovable()) {
            return context.getCacheDir().getPath();
        }
        return context.getExternalCacheDir().getPath();
    }

    public static String d(Context context) {
        File file = new File(c(context) + f18631a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file + (TTPathConst.sSeparator + new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date(System.currentTimeMillis())) + ".png");
    }

    public static int e(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static Bitmap f(int i4, Bitmap bitmap) {
        Bitmap bitmap2;
        Matrix matrix = new Matrix();
        matrix.postRotate(i4);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0035: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0035 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0040 A[Catch: Exception -> 0x003c, TRY_LEAVE, TryCatch #1 {Exception -> 0x003c, blocks: (B:29:0x0038, B:33:0x0040), top: B:37:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g(java.lang.String r4, android.graphics.Bitmap r5) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L34
            r3 = 100
            r5.compress(r2, r3, r1)     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L34
            r1.close()     // Catch: java.lang.Exception -> L14
            r5.recycle()     // Catch: java.lang.Exception -> L14
            goto L18
        L14:
            r5 = move-exception
            r5.printStackTrace()
        L18:
            return r4
        L19:
            r4 = move-exception
            goto L1f
        L1b:
            r4 = move-exception
            goto L36
        L1d:
            r4 = move-exception
            r1 = r0
        L1f:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L2a
            r1.close()     // Catch: java.lang.Exception -> L28
            goto L2a
        L28:
            r4 = move-exception
            goto L30
        L2a:
            if (r5 == 0) goto L33
            r5.recycle()     // Catch: java.lang.Exception -> L28
            goto L33
        L30:
            r4.printStackTrace()
        L33:
            return r0
        L34:
            r4 = move-exception
            r0 = r1
        L36:
            if (r0 == 0) goto L3e
            r0.close()     // Catch: java.lang.Exception -> L3c
            goto L3e
        L3c:
            r5 = move-exception
            goto L44
        L3e:
            if (r5 == 0) goto L47
            r5.recycle()     // Catch: java.lang.Exception -> L3c
            goto L47
        L44:
            r5.printStackTrace()
        L47:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.common.utils.p.g(java.lang.String, android.graphics.Bitmap):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0044 A[Catch: Exception -> 0x0040, TRY_LEAVE, TryCatch #0 {Exception -> 0x0040, blocks: (B:29:0x003c, B:33:0x0044), top: B:37:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String h(android.graphics.Bitmap r4, android.content.Context r5) {
        /*
            java.lang.String r5 = d(r5)
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Exception -> L1d java.lang.Throwable -> L38
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.lang.Exception -> L1d java.lang.Throwable -> L38
            r1.close()     // Catch: java.lang.Exception -> L18
            r4.recycle()     // Catch: java.lang.Exception -> L18
            goto L1c
        L18:
            r4 = move-exception
            r4.printStackTrace()
        L1c:
            return r5
        L1d:
            r5 = move-exception
            goto L23
        L1f:
            r5 = move-exception
            goto L3a
        L21:
            r5 = move-exception
            r1 = r0
        L23:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L2e
            r1.close()     // Catch: java.lang.Exception -> L2c
            goto L2e
        L2c:
            r4 = move-exception
            goto L34
        L2e:
            if (r4 == 0) goto L37
            r4.recycle()     // Catch: java.lang.Exception -> L2c
            goto L37
        L34:
            r4.printStackTrace()
        L37:
            return r0
        L38:
            r5 = move-exception
            r0 = r1
        L3a:
            if (r0 == 0) goto L42
            r0.close()     // Catch: java.lang.Exception -> L40
            goto L42
        L40:
            r4 = move-exception
            goto L48
        L42:
            if (r4 == 0) goto L4b
            r4.recycle()     // Catch: java.lang.Exception -> L40
            goto L4b
        L48:
            r4.printStackTrace()
        L4b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.common.utils.p.h(android.graphics.Bitmap, android.content.Context):java.lang.String");
    }
}
