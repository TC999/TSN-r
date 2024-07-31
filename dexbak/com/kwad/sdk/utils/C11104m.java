package com.kwad.sdk.utils;

import androidx.annotation.RequiresApi;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
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

/* renamed from: com.kwad.sdk.utils.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11104m {
    /* renamed from: a */
    public static void m23771a(File[] fileArr, String str) {
        m23770a(fileArr, str, -1);
    }

    @RequiresApi(api = 19)
    /* renamed from: k */
    public static byte[] m23769k(byte[] bArr) {
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
            } catch (IOException e) {
                C10331c.printStackTrace(e);
            }
        }
        return bArr2;
    }

    /* renamed from: a */
    private static void m23770a(File[] fileArr, String str, int i) {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            try {
                try {
                    byte[] bArr = new byte[4096];
                    int i2 = 0;
                    while (i2 < fileArr.length) {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(fileArr[i2]), 4096);
                        try {
                            String absolutePath = fileArr[i2].getAbsolutePath();
                            zipOutputStream.putNextEntry(new ZipEntry(absolutePath.substring(absolutePath.lastIndexOf("/") + 1)));
                            while (true) {
                                int read = bufferedInputStream2.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            bufferedInputStream2.close();
                            i2++;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Exception e) {
                            e = e;
                            bufferedInputStream = bufferedInputStream2;
                            C10331c.printStackTrace(e);
                            C10738b.closeQuietly(bufferedInputStream);
                            C10738b.closeQuietly(zipOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            C10738b.closeQuietly(bufferedInputStream);
                            C10738b.closeQuietly(zipOutputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            zipOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
        C10738b.closeQuietly(bufferedInputStream);
        C10738b.closeQuietly(zipOutputStream);
    }
}
