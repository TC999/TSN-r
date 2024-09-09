package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class q {
    public static final BigInteger aOO;
    public static final BigInteger aOP;
    public static final BigInteger aOQ;
    public static final BigInteger aOR;
    public static final BigInteger aOS;
    public static final BigInteger aOT;
    public static final char aOU;
    public static final BigInteger aOV;
    public static final BigInteger aOW;
    public static final File[] aOX;
    public static final String aOY;
    private static final char aOZ;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024L);
        aOO = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        aOP = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        aOQ = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        aOR = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        aOS = multiply4;
        aOT = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
        aOV = multiply5;
        aOW = valueOf.multiply(multiply5);
        aOX = new File[0];
        aOY = Character.toString('.');
        aOZ = File.separatorChar;
        if (Lr()) {
            aOU = '/';
        } else {
            aOU = '\\';
        }
    }

    public static boolean L(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    private static boolean Lr() {
        return aOZ == '\\';
    }

    public static boolean M(File file) {
        return file.exists();
    }

    private static FileInputStream N(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                throw new IOException("File '" + file + "' cannot be read");
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    private static FileOutputStream O(File file) {
        return a(file, false);
    }

    public static void P(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
            file.createNewFile();
            return;
        }
        throw new IOException("Could not find parent directory");
    }

    private static void Q(File file) {
        if (file.exists()) {
            if (!Z(file)) {
                T(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static boolean R(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                T(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean S(File file) {
        return R(file);
    }

    public static void T(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    IOException e4 = null;
                    for (File file2 : listFiles) {
                        try {
                            W(file2);
                        } catch (IOException e5) {
                            e4 = e5;
                        }
                    }
                    if (e4 != null) {
                        throw e4;
                    }
                    return;
                }
                throw new IOException("Failed to list contents of " + file);
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    public static byte[] U(File file) {
        return V(file).getBytes();
    }

    public static String V(File file) {
        return a(file, Charset.defaultCharset());
    }

    private static void W(File file) {
        if (file.isDirectory()) {
            Q(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static void X(File file) {
        if (file != null) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return;
                }
                if (R(file)) {
                    file.mkdir();
                } else {
                    throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
                }
            } else {
                file.mkdirs();
            }
            if (file.exists() && file.isDirectory()) {
                return;
            }
            throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
        }
        throw new IOException("Dir is null.");
    }

    public static void Y(File file) {
        R(file);
        s(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    private static boolean Z(File file) {
        ap.checkNotNull(file);
        if (Lr()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static FileOutputStream a(File file, boolean z3) {
        P(file);
        return new FileOutputStream(file, z3);
    }

    public static boolean aa(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        e(file, file2);
        return R(file2);
    }

    private static void b(File file, File file2, boolean z3) {
        ap.g(file, "Source");
        ap.g(file2, "Destination");
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new IOException("Destination '" + parentFile + "' directory cannot be created");
                    } else if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    } else {
                        c(file, file2, true);
                        return;
                    }
                }
                throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
            }
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable, java.io.FileOutputStream] */
    private static void c(File file, File file2, boolean z3) {
        FileInputStream fileInputStream;
        ?? r4;
        FileChannel fileChannel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            r4 = 0;
        }
        try {
            r4 = new FileOutputStream(file2);
            try {
                fileChannel = fileInputStream.getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            r4 = 0;
            fileChannel = r4;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
        try {
            fileChannel2 = r4.getChannel();
            long size = fileChannel.size();
            long j4 = 0;
            while (j4 < size) {
                long j5 = size - j4;
                j4 += fileChannel2.transferFrom(fileChannel, j4, j5 > 31457280 ? 31457280L : j5);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            if (file.length() == file2.length()) {
                if (z3) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
        } catch (Throwable th4) {
            th = th4;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    private static void d(File file, File file2, boolean z3) {
        a(file, file2, (FileFilter) null, true);
    }

    public static boolean delete(String str) {
        return R(new File(str));
    }

    public static void deleteContents(@NonNull File file) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                file2.delete();
            }
        }
    }

    private static boolean e(File file, File file2) {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            f(file, file2);
            try {
                file.delete();
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            }
            return true;
        } catch (Exception e5) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e5);
            return false;
        }
    }

    public static void f(File file, File file2) {
        b(file, file2, true);
    }

    public static void g(File file, File file2) {
        d(file, file2, true);
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int gv = gv(str);
        return gv == -1 ? "" : str.substring(gv + 1);
    }

    public static BufferedInputStream gr(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                return null;
            }
            return new BufferedInputStream(fileInputStream);
        }
        return null;
    }

    public static boolean gs(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean gt(String str) {
        return !TextUtils.isEmpty(str) && L(new File(str));
    }

    private static int gu(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    private static int gv(String str) {
        int lastIndexOf;
        if (str != null && gu(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    private static void s(File file) {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.closeQuietly(O(file));
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + file);
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z3) {
        ArrayList arrayList;
        File[] listFiles;
        ap.g(file, "Source");
        ap.g(file2, "Destination");
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath()) || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(listFiles.length);
                        for (File file3 : listFiles) {
                            arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                        }
                    }
                    a(file, file2, null, z3, arrayList);
                    return;
                }
                throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
            }
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    public static String N(@NonNull Context context, String str) {
        return "/data/data/" + context.getPackageName() + TTPathConst.sSeparator + str + TTPathConst.sSeparator;
    }

    private static void b(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = O(file);
            try {
                com.kwad.sdk.crash.utils.h.g(inputStream, fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z3, List<String> list) {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles != null) {
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    throw new IOException("Destination '" + file2 + "' exists but is not a directory");
                }
            } else if (!file2.mkdirs() && !file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' directory cannot be created");
            }
            if (file2.canWrite()) {
                for (File file3 : listFiles) {
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            a(file3, file4, fileFilter, z3, list);
                        } else {
                            c(file3, file4, z3);
                        }
                    }
                }
                if (z3) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        throw new IOException("Failed to list contents of " + file);
    }

    public static void a(Context context, String str, File file) {
        if (!TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                b(inputStream, file);
                return;
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }
        throw new IllegalArgumentException("Asset path is empty.");
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = N(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            String a4 = com.kwad.sdk.crash.utils.h.a(fileInputStream, com.kwad.sdk.crash.utils.a.a(charset));
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return a4;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static void a(File file, String str, Charset charset, boolean z3) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = a(file, false);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            com.kwad.sdk.crash.utils.h.a(str, fileOutputStream, charset);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            throw th;
        }
    }
}
