package com.kwad.library.solder.lib.p363d;

import android.text.TextUtils;
import com.kwad.library.solder.lib.C9603a;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.utils.C11122q;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.kwad.library.solder.lib.d.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9621c {
    /* renamed from: a */
    public static File m28186a(File file, String str, File file2) {
        String m28188xK = C9619a.m28188xK();
        if (!TextUtils.isEmpty(m28188xK)) {
            StringBuilder sb = new StringBuilder("lib");
            String str2 = File.separator;
            sb.append(str2);
            sb.append(m28188xK);
            sb.append(str2);
            sb.append(str);
            File file3 = new File(file, sb.toString());
            if (file3.exists()) {
                File file4 = new File(file2, str);
                if (file3.renameTo(file4)) {
                    file3.getAbsolutePath();
                    file4.getAbsolutePath();
                    return file4;
                }
                throw new IOException("Rename soLib fail.");
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* renamed from: b */
    public static Set<String> m28185b(File file, File file2) {
        ZipFile zipFile;
        OutputStream outputStream;
        ZipFile zipFile2;
        ZipFile zipFile3;
        ?? r7;
        if (file != null && file.exists()) {
            HashSet hashSet = new HashSet(4);
            C11122q.m23736X(file2);
            file2.getAbsolutePath();
            file.getName();
            ZipFile zipFile4 = null;
            try {
                zipFile = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    outputStream = null;
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            String name = nextElement.getName();
                            if (name != null && !name.contains("../")) {
                                if (!name.startsWith("lib" + File.separator)) {
                                    continue;
                                } else if (nextElement.isDirectory()) {
                                    File file3 = new File(file2, name);
                                    file3.getAbsolutePath();
                                    C11122q.m23736X(file3);
                                } else {
                                    File file4 = new File(file2, name);
                                    file4.getAbsolutePath();
                                    C11122q.m23735Y(file4);
                                    byte[] bArr = new byte[4096];
                                    FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                    try {
                                        FileDescriptor fd = fileOutputStream.getFD();
                                        OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                        try {
                                            r7 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                            while (true) {
                                                try {
                                                    int read = r7.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    bufferedOutputStream.write(bArr, 0, read);
                                                } catch (IOException e) {
                                                    e = e;
                                                    zipFile4 = zipFile;
                                                    outputStream = bufferedOutputStream;
                                                    zipFile2 = r7;
                                                    try {
                                                        C9603a.m28250e("plugin.so", e);
                                                        throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        zipFile = zipFile4;
                                                        zipFile4 = zipFile2;
                                                        C10738b.closeQuietly((Closeable) zipFile4);
                                                        C10738b.closeQuietly(outputStream);
                                                        C10738b.closeQuietly(zipFile);
                                                        throw th;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    zipFile4 = r7;
                                                    outputStream = bufferedOutputStream;
                                                    C10738b.closeQuietly((Closeable) zipFile4);
                                                    C10738b.closeQuietly(outputStream);
                                                    C10738b.closeQuietly(zipFile);
                                                    throw th;
                                                }
                                            }
                                            bufferedOutputStream.flush();
                                            fd.sync();
                                            C10738b.closeQuietly((Closeable) r7);
                                            C10738b.closeQuietly(bufferedOutputStream);
                                            hashSet.add(file4.getName());
                                            zipFile4 = r7;
                                            outputStream = bufferedOutputStream;
                                        } catch (IOException e2) {
                                            e = e2;
                                            r7 = zipFile4;
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    } catch (IOException e3) {
                                        e = e3;
                                        outputStream = fileOutputStream;
                                        zipFile3 = zipFile4;
                                        zipFile4 = zipFile;
                                        zipFile2 = zipFile3;
                                        C9603a.m28250e("plugin.so", e);
                                        throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        outputStream = fileOutputStream;
                                    }
                                }
                            }
                        } catch (IOException e4) {
                            e = e4;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    C10738b.closeQuietly((Closeable) zipFile4);
                    C10738b.closeQuietly(outputStream);
                    C10738b.closeQuietly(zipFile);
                    return hashSet;
                } catch (IOException e5) {
                    e = e5;
                    outputStream = null;
                    zipFile3 = null;
                } catch (Throwable th6) {
                    th = th6;
                    outputStream = null;
                }
            } catch (IOException e6) {
                e = e6;
                outputStream = null;
                zipFile2 = null;
            } catch (Throwable th7) {
                th = th7;
                zipFile = null;
                outputStream = null;
            }
        } else {
            throw new IOException("Apk file not found.");
        }
    }
}
