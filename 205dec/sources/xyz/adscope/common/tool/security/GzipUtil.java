package xyz.adscope.common.tool.security;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class GzipUtil {
    public static byte[] compress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String compressByteToString(String str) {
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr = null;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(str.getBytes("ISO-8859-1"));
                    gZIPOutputStream.close();
                } catch (IOException e5) {
                    e = e5;
                    gZIPOutputStream2 = gZIPOutputStream;
                    e.printStackTrace();
                    if (gZIPOutputStream2 != null) {
                        gZIPOutputStream2.close();
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    return new String(bArr, StandardCharsets.ISO_8859_1);
                } catch (Throwable th) {
                    th = th;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
            bArr = byteArrayOutputStream.toByteArray();
            return new String(bArr, StandardCharsets.ISO_8859_1);
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream = bArr;
        }
    }

    public static String compressForGzip(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return Base64.encodeToString(byteArray, 2);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return "";
        }
    }

    public static String decompressForGzip(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 1024);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toString();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return null;
        }
    }

    public static byte[] uncompress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[2048];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0056, code lost:
        if (r2 == null) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String uncompressByteToString(java.lang.String r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            byte[] r7 = r7.getBytes(r2)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.util.zip.GZIPInputStream r7 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L5d
        L1d:
            int r4 = r7.read(r3)     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L5d
            r5 = -1
            if (r4 == r5) goto L29
            r5 = 0
            r1.write(r3, r5, r4)     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L5d
            goto L1d
        L29:
            java.lang.String r3 = "ISO-8859-1"
            java.lang.String r0 = r1.toString(r3)     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L5d
            r7.close()     // Catch: java.io.IOException -> L32
        L32:
            r2.close()     // Catch: java.io.IOException -> L59
            goto L59
        L36:
            r3 = move-exception
            goto L45
        L38:
            r7 = move-exception
            goto L61
        L3a:
            r7 = move-exception
            r3 = r7
            r7 = r0
            goto L45
        L3e:
            r7 = move-exception
            r2 = r0
            goto L61
        L41:
            r7 = move-exception
            r3 = r7
            r7 = r0
            r2 = r7
        L45:
            java.lang.String r4 = "common_log"
            java.lang.String r5 = "\u89e3\u538b\u5931\u8d25,eventCode:{},errorCode:{} : 2200 : 22001"
            xyz.adscope.common.tool.LogUtil.e(r4, r5)     // Catch: java.lang.Throwable -> L5d
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L5d
            if (r7 == 0) goto L56
            r7.close()     // Catch: java.io.IOException -> L55
            goto L56
        L55:
        L56:
            if (r2 == 0) goto L59
            goto L32
        L59:
            r1.close()     // Catch: java.io.IOException -> L5c
        L5c:
            return r0
        L5d:
            r0 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
        L61:
            if (r0 == 0) goto L68
            r0.close()     // Catch: java.io.IOException -> L67
            goto L68
        L67:
        L68:
            if (r2 == 0) goto L6d
            r2.close()     // Catch: java.io.IOException -> L6d
        L6d:
            r1.close()     // Catch: java.io.IOException -> L70
        L70:
            goto L72
        L71:
            throw r7
        L72:
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.tool.security.GzipUtil.uncompressByteToString(java.lang.String):java.lang.String");
    }
}
