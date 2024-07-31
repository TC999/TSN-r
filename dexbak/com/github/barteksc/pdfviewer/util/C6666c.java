package com.github.barteksc.pdfviewer.util;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileUtils.java */
/* renamed from: com.github.barteksc.pdfviewer.util.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6666c {
    private C6666c() {
    }

    /* renamed from: a */
    public static void m35311a(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        inputStream.close();
                        return;
                    } finally {
                        fileOutputStream.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } finally {
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                }
            }
            throw th;
        }
    }

    /* renamed from: b */
    public static File m35310b(Context context, String str) throws IOException {
        File cacheDir = context.getCacheDir();
        File file = new File(cacheDir, str + "-pdfview.pdf");
        if (str.contains("/")) {
            file.getParentFile().mkdirs();
        }
        m35311a(context.getAssets().open(str), file);
        return file;
    }
}
