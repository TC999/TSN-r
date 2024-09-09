package com.amap.api.col.p0003l;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FileCopy.java */
/* renamed from: com.amap.api.col.3l.t0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t0 {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: FileCopy.java */
    /* renamed from: com.amap.api.col.3l.t0$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a();

        void a(float f4);

        void b();
    }

    private static float a(long j4, long j5) {
        return (((float) j4) / ((float) j5)) * 100.0f;
    }

    public final long b(File file, File file2, long j4, long j5, a aVar) {
        long j6;
        if (j4 == 0) {
            if (aVar != null) {
                aVar.b();
            }
            return 0L;
        }
        file.getAbsolutePath();
        file2.getAbsolutePath();
        try {
            if (file.isDirectory()) {
                if (!file2.exists() && !file2.mkdirs()) {
                    throw new IOException("Cannot create dir " + file2.getAbsolutePath());
                }
                String[] list = file.list();
                j6 = j4;
                if (list != null) {
                    int i4 = 0;
                    while (i4 < list.length) {
                        try {
                            int i5 = i4;
                            j6 = b(new File(file, list[i4]), new File(new File(file2, file.getName()), list[i4]), j6, j5, aVar);
                            i4 = i5 + 1;
                        } catch (Exception e4) {
                            e = e4;
                        }
                    }
                    return j6;
                }
                return j6;
            }
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("Cannot create dir " + parentFile.getAbsolutePath());
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            long j7 = j4;
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    j7 += read;
                    if (aVar != null) {
                        aVar.a(a(j7, j5));
                    }
                } catch (Exception e5) {
                    e = e5;
                    j6 = j7;
                }
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            if (aVar != null && j7 >= j5 - 1) {
                aVar.a();
            }
            return j7;
        } catch (Exception e6) {
            e = e6;
            j6 = j4;
        }
        e.printStackTrace();
        if (aVar != null) {
            aVar.b();
            return j6;
        }
        return j6;
    }
}
