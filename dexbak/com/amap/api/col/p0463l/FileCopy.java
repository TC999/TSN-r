package com.amap.api.col.p0463l;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.amap.api.col.3l.t0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class FileCopy {

    /* compiled from: FileCopy.java */
    /* renamed from: com.amap.api.col.3l.t0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1944a {
        /* renamed from: a */
        void mo53896a();

        /* renamed from: a */
        void mo53895a(float f);

        /* renamed from: b */
        void mo53894b();
    }

    /* renamed from: a */
    private static float m53898a(long j, long j2) {
        return (((float) j) / ((float) j2)) * 100.0f;
    }

    /* renamed from: b */
    public final long m53897b(File file, File file2, long j, long j2, InterfaceC1944a interfaceC1944a) {
        long j3;
        if (j == 0) {
            if (interfaceC1944a != null) {
                interfaceC1944a.mo53894b();
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
                j3 = j;
                if (list != null) {
                    int i = 0;
                    while (i < list.length) {
                        try {
                            int i2 = i;
                            j3 = m53897b(new File(file, list[i]), new File(new File(file2, file.getName()), list[i]), j3, j2, interfaceC1944a);
                            i = i2 + 1;
                        } catch (Exception e) {
                            e = e;
                        }
                    }
                    return j3;
                }
                return j3;
            }
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("Cannot create dir " + parentFile.getAbsolutePath());
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            long j4 = j;
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    j4 += read;
                    if (interfaceC1944a != null) {
                        interfaceC1944a.mo53895a(m53898a(j4, j2));
                    }
                } catch (Exception e2) {
                    e = e2;
                    j3 = j4;
                }
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            if (interfaceC1944a != null && j4 >= j2 - 1) {
                interfaceC1944a.mo53896a();
            }
            return j4;
        } catch (Exception e3) {
            e = e3;
            j3 = j;
        }
        e.printStackTrace();
        if (interfaceC1944a != null) {
            interfaceC1944a.mo53894b();
            return j3;
        }
        return j3;
    }
}
