package com.kwad.sdk.utils;

import androidx.annotation.RequiresApi;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m {
    public static void a(File[] fileArr, String str) {
        a(fileArr, str, -1);
    }

    @RequiresApi(api = 19)
    public static byte[] k(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } finally {
                }
            } catch (IOException e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        }
        return bArr2;
    }

    private static void a(File[] fileArr, String str, int i4) {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            try {
                try {
                    byte[] bArr = new byte[4096];
                    int i5 = 0;
                    while (i5 < fileArr.length) {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(fileArr[i5]), 4096);
                        try {
                            String absolutePath = fileArr[i5].getAbsolutePath();
                            zipOutputStream.putNextEntry(new ZipEntry(absolutePath.substring(absolutePath.lastIndexOf(TTPathConst.sSeparator) + 1)));
                            while (true) {
                                int read = bufferedInputStream2.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            bufferedInputStream2.close();
                            i5++;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Exception e4) {
                            e = e4;
                            bufferedInputStream = bufferedInputStream2;
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Exception e6) {
            e = e6;
            zipOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream);
    }
}
