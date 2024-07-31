package com.mbridge.msdk.foundation.same.p476c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.mbridge.msdk.foundation.tools.SameFileTool;

/* renamed from: com.mbridge.msdk.foundation.same.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonBitmapUtil {
    /* renamed from: a */
    public static Bitmap m22345a(String str) {
        Bitmap bitmap = null;
        if (SameFileTool.m21755a(str)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            try {
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inJustDecodeBounds = false;
                options.inPurgeable = true;
                options.inInputShareable = true;
                options.inDither = true;
                return BitmapFactory.decodeFile(str, options);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                System.gc();
                CommonImageLoader.m22336b();
                try {
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    bitmap = BitmapFactory.decodeFile(str, options);
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    return bitmap;
                } catch (OutOfMemoryError e3) {
                    e3.printStackTrace();
                    return bitmap;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0041: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x0041 */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.InputStream m22346a(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            r1.<init>()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L40
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L40
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L40
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L40
            r4.<init>(r2)     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L40
            r1.close()     // Catch: java.lang.Exception -> L1a
            goto L22
        L1a:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L22
            r0.printStackTrace()
        L22:
            r0 = r4
            goto L3f
        L24:
            r4 = move-exception
            goto L2a
        L26:
            r4 = move-exception
            goto L42
        L28:
            r4 = move-exception
            r1 = r0
        L2a:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L31
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L40
        L31:
            if (r1 == 0) goto L3f
            r1.close()     // Catch: java.lang.Exception -> L37
            goto L3f
        L37:
            r4 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L3f
            r4.printStackTrace()
        L3f:
            return r0
        L40:
            r4 = move-exception
            r0 = r1
        L42:
            if (r0 == 0) goto L50
            r0.close()     // Catch: java.lang.Exception -> L48
            goto L50
        L48:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L50
            r0.printStackTrace()
        L50:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.p476c.CommonBitmapUtil.m22346a(android.graphics.Bitmap):java.io.InputStream");
    }
}
