package com.bytedance.pangle.util;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    static String f29006a = null;

    /* renamed from: b  reason: collision with root package name */
    static String f29007b = null;

    /* renamed from: c  reason: collision with root package name */
    static int f29008c = 8192;

    public static void a(String str) {
        a(new File(str));
    }

    public static String b(Context context) {
        File parentFile;
        if (f29007b == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            try {
                f29007b = parentFile.getCanonicalPath();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        return f29007b;
    }

    public static void a(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static void b(String str, String str2) {
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("..")) {
                            if (nextEntry.isDirectory()) {
                                new File(str2 + File.separator + name).mkdirs();
                            } else {
                                File file = new File(str2 + File.separator + name);
                                if (file.exists()) {
                                    file.delete();
                                } else {
                                    file.getParentFile().mkdirs();
                                }
                                file.createNewFile();
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, read);
                                    }
                                    bufferedOutputStream2.flush();
                                    bufferedOutputStream2.close();
                                    bufferedOutputStream = bufferedOutputStream2;
                                } catch (Exception e4) {
                                    e = e4;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    a(bufferedOutputStream);
                                    a(zipInputStream);
                                    throw e;
                                }
                            }
                        }
                    } else {
                        zipInputStream.close();
                        return;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            }
        } catch (Exception e6) {
            e = e6;
            zipInputStream = null;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String a(Context context) {
        File parentFile;
        if (f29006a == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            f29006a = parentFile.getAbsolutePath();
        }
        return f29006a;
    }

    public static void a(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file2.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        return;
                    }
                    for (File file3 : listFiles) {
                        String str3 = file2 + File.separator + file3.getName();
                        if (file3.isDirectory()) {
                            a(file3.getAbsolutePath(), str3);
                        } else if (!new File(str3).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file3));
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                            byte[] bArr = new byte[f29008c];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            bufferedOutputStream.close();
                            bufferedInputStream.close();
                        }
                    }
                    return;
                }
                throw new Exception("\u76ee\u6807\u6587\u4ef6\u5939\u4e0d\u662f\u76ee\u5f55");
            }
            throw new Exception("\u6e90\u6587\u4ef6\u5939\u4e0d\u662f\u76ee\u5f55");
        }
        throw new Exception("\u6587\u4ef6\u5939\u4e0d\u5b58\u5728");
    }

    public static boolean b(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            a((Closeable) null);
            return false;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
        }
        try {
            byte[] bArr = new byte[6];
            if (fileInputStream.read(bArr) != 6) {
                a(fileInputStream);
                return false;
            }
            byte[] bArr2 = {80, 75, 3, 4};
            for (int i4 = 0; i4 < 4; i4++) {
                if (bArr2[i4] != bArr[i4]) {
                    a(fileInputStream);
                    return false;
                }
            }
            if (bArr[4] == 0 && bArr[5] == 0) {
                a(fileInputStream);
                return false;
            }
            if (bArr[4] == 20) {
                if (bArr[5] == 3) {
                    a(fileInputStream);
                    return true;
                }
            }
            a(fileInputStream);
            return false;
        } catch (Throwable unused2) {
            fileInputStream2 = fileInputStream;
            a(fileInputStream2);
            return false;
        }
    }

    public static void a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j4, long j5, String str) {
        byte[] bArr;
        long j6 = 0;
        if (j4 < 0 || j5 < 0 || j4 > j5) {
            throw new IOException("invalid offsets  ".concat(String.valueOf(str)));
        }
        if (j4 == j5) {
            return;
        }
        randomAccessFile.seek(j4);
        long j7 = j5 - j4;
        int i4 = f29008c;
        if (j7 < i4) {
            bArr = new byte[(int) j7];
        } else {
            bArr = new byte[i4];
        }
        while (true) {
            int read = randomAccessFile.read(bArr);
            if (read == -1) {
                return;
            }
            randomAccessFile2.write(bArr, 0, read);
            j6 += read;
            if (j6 == j7) {
                return;
            }
            if (bArr.length + j6 > j7) {
                bArr = new byte[(int) (j7 - j6)];
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedOutputStream.flush();
                    return;
                }
            }
        } finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }
}
