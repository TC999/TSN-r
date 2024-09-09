package com.tencent.turingfd.sdk.ams.au;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.continue  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Ccontinue {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static byte[] b(String str) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        long length;
        int i4;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "r");
            try {
                length = randomAccessFile.length();
                i4 = (int) length;
            } catch (Throwable unused) {
                try {
                    bArr = new byte[0];
                    return bArr;
                } finally {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        if (i4 == length) {
            bArr = new byte[i4];
            randomAccessFile.readFully(bArr);
            try {
                randomAccessFile.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return bArr;
        }
        throw new IOException("");
    }

    public static byte[] a(String str, int i4) {
        FileInputStream fileInputStream;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i4];
                int i5 = 0;
                do {
                    int read = fileInputStream.read(bArr, i5, i4 - i5);
                    if (read == -1) {
                        break;
                    }
                    i5 += read;
                } while (i5 < i4);
                if (i5 == 0) {
                    Ara.a(fileInputStream);
                    return null;
                }
                if (i5 < i4) {
                    byte[] bArr2 = new byte[i5];
                    System.arraycopy(bArr, 0, bArr2, 0, i5);
                    bArr = bArr2;
                }
                Ara.a(fileInputStream);
                return bArr;
            } catch (Throwable unused) {
                Ara.a(fileInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    public static byte[] a(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            byteArrayOutputStream = null;
        }
        try {
            Ara.a(fileInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray == null) {
                byteArray = "".getBytes();
            }
            return byteArray;
        } catch (Throwable th4) {
            th = th4;
            try {
                throw th;
            } finally {
                Ara.a(fileInputStream);
                Ara.a(byteArrayOutputStream);
            }
        }
    }

    public static boolean a(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                try {
                    return file.delete();
                } catch (Throwable unused) {
                    return false;
                }
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    a(file2);
                }
            }
            try {
                return file.delete();
            } catch (Throwable unused2) {
                return false;
            }
        }
        return true;
    }
}
