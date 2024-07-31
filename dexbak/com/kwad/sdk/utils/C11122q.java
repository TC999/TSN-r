package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10737a;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.crash.utils.C10747h;
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
import kotlinx.coroutines.internal.C15104v;

/* renamed from: com.kwad.sdk.utils.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11122q {
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
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(C15104v.f43115o));
        aOV = multiply5;
        aOW = valueOf.multiply(multiply5);
        aOX = new File[0];
        aOY = Character.toString('.');
        aOZ = File.separatorChar;
        if (m23749Lr()) {
            aOU = '/';
        } else {
            aOU = '\\';
        }
    }

    /* renamed from: L */
    public static boolean m23750L(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    /* renamed from: Lr */
    private static boolean m23749Lr() {
        return aOZ == '\\';
    }

    /* renamed from: M */
    public static boolean m23748M(File file) {
        return file.exists();
    }

    /* renamed from: N */
    private static FileInputStream m23746N(File file) {
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

    /* renamed from: O */
    private static FileOutputStream m23745O(File file) {
        return m23728a(file, false);
    }

    /* renamed from: P */
    public static void m23744P(File file) {
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

    /* renamed from: Q */
    private static void m23743Q(File file) {
        if (file.exists()) {
            if (!m23734Z(file)) {
                m23740T(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    /* renamed from: R */
    public static boolean m23742R(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                m23740T(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    /* renamed from: S */
    public static boolean m23741S(File file) {
        return m23742R(file);
    }

    /* renamed from: T */
    public static void m23740T(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    IOException e = null;
                    for (File file2 : listFiles) {
                        try {
                            m23737W(file2);
                        } catch (IOException e2) {
                            e = e2;
                        }
                    }
                    if (e != null) {
                        throw e;
                    }
                    return;
                }
                throw new IOException("Failed to list contents of " + file);
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    /* renamed from: U */
    public static byte[] m23739U(File file) {
        return m23738V(file).getBytes();
    }

    /* renamed from: V */
    public static String m23738V(File file) {
        return m23729a(file, Charset.defaultCharset());
    }

    /* renamed from: W */
    private static void m23737W(File file) {
        if (file.isDirectory()) {
            m23743Q(file);
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

    /* renamed from: X */
    public static void m23736X(File file) {
        if (file != null) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return;
                }
                if (m23742R(file)) {
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

    /* renamed from: Y */
    public static void m23735Y(File file) {
        m23742R(file);
        m23714s(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    /* renamed from: Z */
    private static boolean m23734Z(File file) {
        C11023ap.checkNotNull(file);
        if (m23749Lr()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    /* renamed from: a */
    public static FileOutputStream m23728a(File file, boolean z) {
        m23744P(file);
        return new FileOutputStream(file, z);
    }

    /* renamed from: aa */
    public static boolean m23727aa(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        m23722e(file, file2);
        return m23742R(file2);
    }

    /* renamed from: b */
    private static void m23726b(File file, File file2, boolean z) {
        C11023ap.m24087g(file, "Source");
        C11023ap.m24087g(file2, "Destination");
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new IOException("Destination '" + parentFile + "' directory cannot be created");
                    } else if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    } else {
                        m23724c(file, file2, true);
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
    /* renamed from: c */
    private static void m23724c(File file, File file2, boolean z) {
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
            C10738b.closeQuietly(fileChannel2);
            C10738b.closeQuietly((Closeable) r4);
            C10738b.closeQuietly(fileChannel);
            C10738b.closeQuietly(fileInputStream);
            throw th;
        }
        try {
            fileChannel2 = r4.getChannel();
            long size = fileChannel.size();
            long j = 0;
            while (j < size) {
                long j2 = size - j;
                j += fileChannel2.transferFrom(fileChannel, j, j2 > 31457280 ? 31457280L : j2);
            }
            C10738b.closeQuietly(fileChannel2);
            C10738b.closeQuietly((Closeable) r4);
            C10738b.closeQuietly(fileChannel);
            C10738b.closeQuietly(fileInputStream);
            if (file.length() == file2.length()) {
                if (z) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
        } catch (Throwable th4) {
            th = th4;
            C10738b.closeQuietly(fileChannel2);
            C10738b.closeQuietly((Closeable) r4);
            C10738b.closeQuietly(fileChannel);
            C10738b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    /* renamed from: d */
    private static void m23723d(File file, File file2, boolean z) {
        m23732a(file, file2, (FileFilter) null, true);
    }

    public static boolean delete(String str) {
        return m23742R(new File(str));
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

    /* renamed from: e */
    private static boolean m23722e(File file, File file2) {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            m23721f(file, file2);
            try {
                file.delete();
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
            return true;
        } catch (Exception e2) {
            C10331c.printStackTraceOnly(e2);
            return false;
        }
    }

    /* renamed from: f */
    public static void m23721f(File file, File file2) {
        m23726b(file, file2, true);
    }

    /* renamed from: g */
    public static void m23720g(File file, File file2) {
        m23723d(file, file2, true);
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int m23715gv = m23715gv(str);
        return m23715gv == -1 ? "" : str.substring(m23715gv + 1);
    }

    /* renamed from: gr */
    public static BufferedInputStream m23719gr(String str) {
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

    /* renamed from: gs */
    public static boolean m23718gs(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    /* renamed from: gt */
    public static boolean m23717gt(String str) {
        return !TextUtils.isEmpty(str) && m23750L(new File(str));
    }

    /* renamed from: gu */
    private static int m23716gu(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    /* renamed from: gv */
    private static int m23715gv(String str) {
        int lastIndexOf;
        if (str != null && m23716gu(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    /* renamed from: s */
    private static void m23714s(File file) {
        if (!file.exists()) {
            C10738b.closeQuietly(m23745O(file));
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + file);
    }

    /* renamed from: a */
    private static void m23732a(File file, File file2, FileFilter fileFilter, boolean z) {
        ArrayList arrayList;
        File[] listFiles;
        C11023ap.m24087g(file, "Source");
        C11023ap.m24087g(file2, "Destination");
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
                    m23731a(file, file2, null, z, arrayList);
                    return;
                }
                throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
            }
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    /* renamed from: N */
    public static String m23747N(@NonNull Context context, String str) {
        return "/data/data/" + context.getPackageName() + "/" + str + "/";
    }

    /* renamed from: b */
    private static void m23725b(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = m23745O(file);
            try {
                C10747h.m24941g(inputStream, fileOutputStream);
                C10738b.closeQuietly(fileOutputStream);
                C10738b.closeQuietly(inputStream);
            } catch (Throwable th) {
                th = th;
                C10738b.closeQuietly(fileOutputStream);
                C10738b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    /* renamed from: a */
    private static void m23731a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) {
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
                            m23731a(file3, file4, fileFilter, z, list);
                        } else {
                            m23724c(file3, file4, z);
                        }
                    }
                }
                if (z) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        throw new IOException("Failed to list contents of " + file);
    }

    /* renamed from: a */
    public static void m23733a(Context context, String str, File file) {
        if (!TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                m23725b(inputStream, file);
                return;
            } finally {
                C10738b.closeQuietly(inputStream);
            }
        }
        throw new IllegalArgumentException("Asset path is empty.");
    }

    /* renamed from: a */
    public static String m23729a(File file, Charset charset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = m23746N(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            String m24950a = C10747h.m24950a(fileInputStream, C10737a.m25008a(charset));
            C10738b.closeQuietly(fileInputStream);
            return m24950a;
        } catch (Throwable th2) {
            th = th2;
            C10738b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m23730a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = m23728a(file, false);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            C10747h.m24946a(str, fileOutputStream, charset);
            C10738b.closeQuietly(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            C10738b.closeQuietly(fileOutputStream);
            throw th;
        }
    }
}
