package cn.bluemobi.dylan.base.utils;

/* renamed from: cn.bluemobi.dylan.base.utils.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DownloadImgUtils {
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0048: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:18:0x0048 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m57756a(java.lang.String r4) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.io.InputStream r2 = r4.getInputStream()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            int r2 = r1.available()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L47
            r1.mark(r2)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L47
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L47
            r2.<init>()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L47
            r3 = 1
            r2.inJustDecodeBounds = r3     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L47
            android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L47
            r3 = 0
            r2.inJustDecodeBounds = r3     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L47
            r1.reset()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L47
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L47
            r4.disconnect()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L47
            r1.close()     // Catch: java.io.IOException -> L37
        L37:
            return r2
        L38:
            r4 = move-exception
            goto L3e
        L3a:
            r4 = move-exception
            goto L49
        L3c:
            r4 = move-exception
            r1 = r0
        L3e:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L46
            r1.close()     // Catch: java.io.IOException -> L46
        L46:
            return r0
        L47:
            r4 = move-exception
            r0 = r1
        L49:
            if (r0 == 0) goto L4e
            r0.close()     // Catch: java.io.IOException -> L4e
        L4e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.base.utils.DownloadImgUtils.m57756a(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0056: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:18:0x0056 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m57755b(java.lang.String r4, android.widget.ImageView r5) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            java.io.InputStream r2 = r4.getInputStream()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            int r2 = r1.available()     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            r1.mark(r2)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            r2.<init>()     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            r3 = 1
            r2.inJustDecodeBounds = r3     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            cn.bluemobi.dylan.base.utils.i$a r5 = cn.bluemobi.dylan.base.utils.ImageSizeUtil.m57738c(r5)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            int r3 = r5.f1809a     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            int r5 = r5.f1810b     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            int r5 = cn.bluemobi.dylan.base.utils.ImageSizeUtil.m57740a(r2, r3, r5)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            r2.inSampleSize = r5     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            r5 = 0
            r2.inJustDecodeBounds = r5     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            r1.reset()     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            r4.disconnect()     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L55
            r1.close()     // Catch: java.io.IOException -> L45
        L45:
            return r5
        L46:
            r4 = move-exception
            goto L4c
        L48:
            r4 = move-exception
            goto L57
        L4a:
            r4 = move-exception
            r1 = r0
        L4c:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L54
            r1.close()     // Catch: java.io.IOException -> L54
        L54:
            return r0
        L55:
            r4 = move-exception
            r0 = r1
        L57:
            if (r0 == 0) goto L5c
            r0.close()     // Catch: java.io.IOException -> L5c
        L5c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.base.utils.DownloadImgUtils.m57755b(java.lang.String, android.widget.ImageView):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m57754c(java.lang.String r4, java.io.File r5) {
        /*
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.net.URLConnection r4 = r2.openConnection()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L38
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L38
            r5 = 512(0x200, float:7.17E-43)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
        L1a:
            int r1 = r4.read(r5)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r3 = -1
            if (r1 == r3) goto L25
            r2.write(r5, r0, r1)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            goto L1a
        L25:
            r2.flush()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r5 = 1
            r4.close()     // Catch: java.io.IOException -> L2c
        L2c:
            r2.close()     // Catch: java.io.IOException -> L2f
        L2f:
            return r5
        L30:
            r5 = move-exception
            goto L36
        L32:
            r5 = move-exception
            goto L3a
        L34:
            r5 = move-exception
            r2 = r1
        L36:
            r1 = r4
            goto L52
        L38:
            r5 = move-exception
            r2 = r1
        L3a:
            r1 = r4
            goto L41
        L3c:
            r5 = move-exception
            r2 = r1
            goto L52
        L3f:
            r5 = move-exception
            r2 = r1
        L41:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L4b
            r1.close()     // Catch: java.io.IOException -> L4a
            goto L4b
        L4a:
        L4b:
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.io.IOException -> L50
        L50:
            return r0
        L51:
            r5 = move-exception
        L52:
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.io.IOException -> L58
            goto L59
        L58:
        L59:
            if (r2 == 0) goto L5e
            r2.close()     // Catch: java.io.IOException -> L5e
        L5e:
            goto L60
        L5f:
            throw r5
        L60:
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.base.utils.DownloadImgUtils.m57754c(java.lang.String, java.io.File):boolean");
    }
}
