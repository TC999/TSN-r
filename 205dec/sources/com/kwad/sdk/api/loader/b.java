package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.SdkConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class b {

    /* renamed from: com.kwad.sdk.api.loader.b$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    final class AnonymousClass1 extends com.kwad.sdk.api.a.b {
        final /* synthetic */ SdkConfig ant;
        final /* synthetic */ Context gq;

        AnonymousClass1(Context context, SdkConfig sdkConfig) {
            this.gq = context;
            this.ant = sdkConfig;
        }

        public final void doTask() {
            b.c(this.gq, "sdkconfig", this.ant.toJson());
        }
    }

    private static void I(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            h.j(file);
        }
        d(new FileInputStream(str), new FileOutputStream(file, false));
    }

    private static void J(String str, String str2) {
        ZipFile zipFile;
        String str3 = w.is64Bit() ? "lib/arm64-v8a/" : "lib/armeabi-v7a/";
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
                        d(zipFile.getInputStream(nextElement), new FileOutputStream(new File(str2, name.substring(str3.length()))));
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
    public static boolean a(Context context, ClassLoader classLoader, String str, String str2) {
        String q3 = h.q(context, str2);
        h(new File(q3));
        String s3 = h.s(context, str2);
        String t3 = h.t(context, str2);
        String u3 = h.u(context, str2);
        try {
            I(str, s3);
            J(str, u3);
            return k.b(context, classLoader, s3, t3, u3).Af() != null;
        } catch (Exception e4) {
            h(new File(s3));
            h(new File(t3));
            h(new File(u3));
            h(new File(q3));
            throw e4;
        }
    }

    private static void c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    private static void d(InputStream inputStream, OutputStream outputStream) {
        try {
            c(inputStream, outputStream);
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

    private static void h(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            h(file2);
        }
    }
}
