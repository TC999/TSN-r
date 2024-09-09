package com.github.barteksc.pdfviewer.util;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: FileUtils.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {
    private c() {
    }

    public static void a(InputStream inputStream, File file) throws IOException {
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

    public static File b(Context context, String str) throws IOException {
        File cacheDir = context.getCacheDir();
        File file = new File(cacheDir, str + "-pdfview.pdf");
        if (str.contains(TTPathConst.sSeparator)) {
            file.getParentFile().mkdirs();
        }
        a(context.getAssets().open(str), file);
        return file;
    }
}
