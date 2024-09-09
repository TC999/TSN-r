package com.bykv.vk.openvk.component.video.c.ux;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    public static long c(String str, String str2) {
        File xv = xv(str, str2);
        if (xv.exists()) {
            return xv.length();
        }
        File w3 = w(str, str2);
        if (w3.exists()) {
            return w3.length();
        }
        return 0L;
    }

    public static File w(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static File xv(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static void c(RandomAccessFile randomAccessFile, byte[] bArr, int i4, int i5, String str) throws IOException {
        try {
            randomAccessFile.seek(i4);
            randomAccessFile.write(bArr, 0, i5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
