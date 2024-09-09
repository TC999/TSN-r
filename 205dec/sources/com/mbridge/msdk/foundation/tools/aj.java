package com.mbridge.msdk.foundation.tools;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;

/* compiled from: Util.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class aj {

    /* compiled from: Util.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SecureRandom f39779a = new SecureRandom();

        /* renamed from: b  reason: collision with root package name */
        static final char[] f39780b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        byte[] bArr = new byte[16];
        a.f39779a.nextBytes(bArr);
        char[] cArr = new char[32];
        for (int i4 = 0; i4 < 16; i4++) {
            byte b4 = bArr[i4];
            int i5 = i4 << 1;
            char[] cArr2 = a.f39780b;
            cArr[i5] = cArr2[(b4 >> 4) & 15];
            cArr[i5 + 1] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get(null), new Object[0])).intValue();
        } catch (Throwable unused) {
            return 4096;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(File file) {
        try {
            if (file.exists()) {
                d(file);
            }
        } catch (Exception unused) {
        }
    }

    private static void d(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                d(file2);
            }
        }
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(File file) throws IOException {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        return parentFile != null && (parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(File file) throws IOException {
        if (file.isFile()) {
            long length = file.length();
            if ((length >> 32) == 0) {
                int i4 = (int) length;
                byte[] bArr = new byte[i4];
                a(file, bArr, i4);
                return bArr;
            }
            throw new IllegalArgumentException("file too large, path:" + file.getPath());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file, byte[] bArr, int i4) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i5 = 0;
        while (i5 < i4) {
            try {
                int read = randomAccessFile.read(bArr, i5, i4 - i5);
                if (read < 0) {
                    break;
                }
                i5 += read;
            } finally {
                a(randomAccessFile);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(File file, byte[] bArr) {
        File file2;
        try {
            String parent = file.getParent();
            file2 = new File(parent, file.getName() + ".tmp");
        } catch (Exception unused) {
        }
        if (a(file2)) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            randomAccessFile.setLength(bArr.length);
            randomAccessFile.write(bArr);
            a(randomAccessFile);
            if (!file.exists() || file.delete()) {
                return file2.renameTo(file);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
