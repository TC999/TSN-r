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

/* renamed from: com.bytedance.pangle.util.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6251g {

    /* renamed from: a */
    static String f22236a = null;

    /* renamed from: b */
    static String f22237b = null;

    /* renamed from: c */
    static int f22238c = 8192;

    /* renamed from: a */
    public static void m36896a(String str) {
        m36899a(new File(str));
    }

    /* renamed from: b */
    public static String m36893b(Context context) {
        File parentFile;
        if (f22237b == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            try {
                f22237b = parentFile.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return f22237b;
    }

    /* renamed from: a */
    public static void m36899a(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                m36899a(file2);
            }
        }
        file.delete();
    }

    /* renamed from: b */
    public static void m36891b(String str, String str2) {
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
                                } catch (Exception e) {
                                    e = e;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    m36900a(bufferedOutputStream);
                                    m36900a(zipInputStream);
                                    throw e;
                                }
                            }
                        }
                    } else {
                        zipInputStream.close();
                        return;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            zipInputStream = null;
        }
    }

    /* renamed from: a */
    public static void m36900a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m36894a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static String m36901a(Context context) {
        File parentFile;
        if (f22236a == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            f22236a = parentFile.getAbsolutePath();
        }
        return f22236a;
    }

    /* renamed from: a */
    public static void m36895a(String str, String str2) {
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
                            m36895a(file3.getAbsolutePath(), str3);
                        } else if (!new File(str3).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file3));
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                            byte[] bArr = new byte[f22238c];
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
                throw new Exception("目标文件夹不是目录");
            }
            throw new Exception("源文件夹不是目录");
        }
        throw new Exception("文件夹不存在");
    }

    /* renamed from: b */
    public static boolean m36892b(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            m36900a((Closeable) null);
            return false;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
        }
        try {
            byte[] bArr = new byte[6];
            if (fileInputStream.read(bArr) != 6) {
                m36900a(fileInputStream);
                return false;
            }
            byte[] bArr2 = {80, 75, 3, 4};
            for (int i = 0; i < 4; i++) {
                if (bArr2[i] != bArr[i]) {
                    m36900a(fileInputStream);
                    return false;
                }
            }
            if (bArr[4] == 0 && bArr[5] == 0) {
                m36900a(fileInputStream);
                return false;
            }
            if (bArr[4] == 20) {
                if (bArr[5] == 3) {
                    m36900a(fileInputStream);
                    return true;
                }
            }
            m36900a(fileInputStream);
            return false;
        } catch (Throwable unused2) {
            fileInputStream2 = fileInputStream;
            m36900a(fileInputStream2);
            return false;
        }
    }

    /* renamed from: a */
    public static void m36897a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) {
        byte[] bArr;
        long j3 = 0;
        if (j < 0 || j2 < 0 || j > j2) {
            throw new IOException("invalid offsets  ".concat(String.valueOf(str)));
        }
        if (j == j2) {
            return;
        }
        randomAccessFile.seek(j);
        long j4 = j2 - j;
        int i = f22238c;
        if (j4 < i) {
            bArr = new byte[(int) j4];
        } else {
            bArr = new byte[i];
        }
        while (true) {
            int read = randomAccessFile.read(bArr);
            if (read == -1) {
                return;
            }
            randomAccessFile2.write(bArr, 0, read);
            j3 += read;
            if (j3 == j4) {
                return;
            }
            if (bArr.length + j3 > j4) {
                bArr = new byte[(int) (j4 - j3)];
            }
        }
    }

    /* renamed from: a */
    public static void m36898a(InputStream inputStream, OutputStream outputStream) {
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
