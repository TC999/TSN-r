package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ZipUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class at {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i4 = 0; i4 < bArr.length; i4++) {
                bArr[i4] = (byte) ((bArr[i4] ^ bArr2[i4 % bArr2.length]) ^ (i4 & 255));
            }
        }
        return bArr;
    }

    public static void b(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = null;
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream2.read(bArr2);
                    if (read != -1) {
                        outputStream.write(bArr2, 0, read);
                    } else {
                        ap.a(gZIPInputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                try {
                    UMRTLog.e("MobclickRT", "unGzip error: " + th.getMessage());
                } finally {
                    ap.a(gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream2.write(bArr);
                ap.a(gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    UMRTLog.e("MobclickRT", "gzip error: " + th.getMessage());
                } finally {
                    ap.a(gZIPOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
