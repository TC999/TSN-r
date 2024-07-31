package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.kwad.sdk.api.loader.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9715b {
    /* renamed from: I */
    private static void m27954I(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            C9724h.m27926j(file);
        }
        m27950d(new FileInputStream(str), new FileOutputStream(file, false));
    }

    /* renamed from: J */
    private static void m27953J(String str, String str2) {
        ZipFile zipFile;
        String str3 = C9764w.is64Bit() ? "lib/arm64-v8a/" : "lib/armeabi-v7a/";
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (!TextUtils.isEmpty(name) && !name.contains("../") && name.endsWith(".so") && name.startsWith(str3)) {
                        m27950d(zipFile.getInputStream(nextElement), new FileOutputStream(new File(str2, name.substring(str3.length()))));
                    }
                }
            }
            try {
                zipFile.close();
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m27952a(Context context, ClassLoader classLoader, String str, String str2) {
        String m27924q = C9724h.m27924q(context, str2);
        m27949h(new File(m27924q));
        String m27922s = C9724h.m27922s(context, str2);
        String m27921t = C9724h.m27921t(context, str2);
        String m27920u = C9724h.m27920u(context, str2);
        try {
            m27954I(str, m27922s);
            m27953J(str, m27920u);
            return C9729k.m27888b(context, classLoader, m27922s, m27921t, m27920u).m27892Af() != null;
        } catch (Exception e) {
            m27949h(new File(m27922s));
            m27949h(new File(m27921t));
            m27949h(new File(m27920u));
            m27949h(new File(m27924q));
            throw e;
        }
    }

    /* renamed from: c */
    private static void m27951c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: d */
    private static void m27950d(InputStream inputStream, OutputStream outputStream) {
        try {
            m27951c(inputStream, outputStream);
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
            try {
                outputStream.close();
            } catch (Exception unused3) {
            }
        }
    }

    /* renamed from: h */
    private static void m27949h(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            m27949h(file2);
        }
    }
}
