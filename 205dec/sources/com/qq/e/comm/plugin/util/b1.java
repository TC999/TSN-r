package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipFile;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46379a = "b1";

    public static void a(File file) {
        File[] listFiles;
        if (file == null || !file.isDirectory()) {
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                a(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    public static long b(File file) {
        File[] listFiles;
        long length;
        long j4 = 0;
        if (file != null && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = b(file2);
                } else {
                    length = file2.length();
                }
                j4 += length;
            }
        }
        return j4;
    }

    public static boolean c(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return c(file, str.getBytes(com.qq.e.comm.plugin.k.a.f44515a));
    }

    public static String d(File file) {
        byte[] e4 = e(file);
        if (e4 != null) {
            return new String(e4, com.qq.e.comm.plugin.k.a.f44515a);
        }
        return null;
    }

    public static byte[] e(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return bArr;
                } catch (IOException unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused5) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static File f(String str) {
        return new File(h(str).getAbsolutePath() + File.separator + "preload");
    }

    public static File g(String str) {
        return new File(j() + File.separator + str);
    }

    public static File h(String str) {
        return new File(k().getAbsolutePath() + File.separator + str);
    }

    public static File i() {
        File file = new File(k(), "tpl4native");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File j() {
        return new File(k().getAbsolutePath() + File.separator + "preload2");
    }

    public static File k() {
        return com.qq.e.comm.plugin.d0.a.d().a().getDir("adnet", 0);
    }

    public static File l() {
        return new File(n().getAbsolutePath() + File.separator + "report_cgi");
    }

    public static File m() {
        File file = new File(com.qq.e.comm.plugin.d0.a.d().a().getCacheDir(), "resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File n() {
        File file = new File(k().getAbsolutePath() + File.separator + AdLogEventRepo.COL_RETRY_COUNT);
        file.mkdirs();
        return file;
    }

    public static File o() {
        File file = new File(k(), "dynamic");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File p() {
        File file = new File(e(), "video");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File q() {
        File file = new File(e(), "wxapkg");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File f() {
        File file = new File(k(), "eascript");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File g() {
        return com.qq.e.comm.plugin.d0.a.d().a().getDir(a("e_qq_com_eyes"), 0);
    }

    public static File h() {
        File e4 = e();
        if (e4 == null) {
            return null;
        }
        File file = new File(e4, RewardPlus.ICON);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean c(File file, byte[] bArr) {
        if (file != null && bArr != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public static String d(String str) {
        return s0.a(str);
    }

    public static File d() {
        File externalCacheDir = com.qq.e.comm.plugin.d0.a.d().a().getApplicationContext().getExternalCacheDir();
        return externalCacheDir != null ? externalCacheDir : com.qq.e.comm.plugin.d0.a.d().a().getApplicationContext().getCacheDir();
    }

    public static File c(String str) {
        try {
            File p3 = p();
            String d4 = d(str);
            if (TextUtils.isEmpty(d4)) {
                return null;
            }
            File file = new File(p3, d4 + "_complete");
            File file2 = new File(p3, d4);
            if (file.exists()) {
                if (file2.exists()) {
                    file2.setLastModified(System.currentTimeMillis());
                    file.setLastModified(System.currentTimeMillis());
                    d1.a(f46379a, "getDownloadVideoFile success, file name: %s", file2.getName());
                    return file2;
                }
                file.delete();
                return null;
            }
            return null;
        } catch (Exception e4) {
            d1.a(f46379a, "getDownloadVideoFile error", e4);
            return null;
        }
    }

    public static void b(File file, String str) throws Exception {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        a(file, str.getBytes(com.qq.e.comm.plugin.k.a.f44515a));
    }

    public static boolean a(File file, String str) {
        if (file != null && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                try {
                    fileOutputStream2.write(str.getBytes(Charset.forName("UTF-8")));
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Exception unused2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    private static void b(File file, byte[] bArr) throws Exception {
        if (file == null || bArr == null || bArr.length == 0) {
            return;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bufferedOutputStream2.write(bArr);
                bufferedOutputStream2.flush();
                bufferedOutputStream2.close();
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static File e() {
        File file = new File(d(), "com_qq_e_download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String e(String str) {
        return s0.a(str);
    }

    public static File c() {
        File file = new File(k(), "other");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "gdtadmobwebdatabase");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void a(File file, byte[] bArr) throws Exception {
        if (file == null || bArr == null || bArr.length == 0) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            File file2 = new File(parentFile, file.getName() + "_tmp_" + Thread.currentThread().getName() + "_" + System.nanoTime());
            b(file2, bArr);
            file2.renameTo(file);
            return;
        }
        b(file, bArr);
    }

    public static boolean c(File file) {
        try {
            new ZipFile(file).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static File b(String str) {
        try {
            File a4 = a();
            if (!TextUtils.isEmpty(str) && a4 != null && a4.exists()) {
                File file = new File(a4, str);
                if (file.exists()) {
                    file.setLastModified(System.currentTimeMillis());
                }
                return file;
            }
            return null;
        } catch (Exception e4) {
            d1.a(f46379a, "get apk file error", e4);
            return null;
        }
    }

    public static File b() {
        return new File(com.qq.e.comm.plugin.d0.a.d().a().getCacheDir(), "GDTDOWNLOAD/image");
    }

    public static File a(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "gdtadmobwebcache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean b(File file, File file2) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            return a(new FileInputStream(file), file2);
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    public static File a() {
        File e4 = e();
        if (e4 == null) {
            return null;
        }
        File file = new File(e4, "apk");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String a(String str) {
        return a(str, com.qq.e.comm.plugin.d0.a.d().b().e());
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        boolean endsWith = str2.endsWith("_");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(endsWith ? "" : "_");
        sb.append(s0.a(str2));
        return sb.toString();
    }

    public static boolean a(File file, File file2) {
        if (file != null && file.exists()) {
            try {
                a(new FileInputStream(file), file2);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(InputStream inputStream, File file) {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                return false;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    }
                }
            } catch (Throwable unused) {
                fileOutputStream = fileOutputStream2;
                try {
                    GDTLogger.d(String.format("Exception while copy from InputStream to File %s", file.getAbsolutePath()));
                    return false;
                } finally {
                    a(inputStream);
                    a(fileOutputStream);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static String a(com.qq.e.comm.plugin.i0.n.g gVar, File file) throws IOException, NoSuchAlgorithmException {
        InputStream inputStream;
        MessageDigest messageDigest;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            inputStream = gVar.a();
            try {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    a(inputStream);
                    a(fileOutputStream);
                    String a4 = s0.a(messageDigest.digest());
                    a(inputStream);
                    a(fileOutputStream);
                    return a4;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            a(inputStream);
            a(fileOutputStream2);
            throw th;
        }
    }
}
