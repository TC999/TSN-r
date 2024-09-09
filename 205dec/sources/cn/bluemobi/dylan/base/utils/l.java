package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Installation.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static String f1798a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final String f1799b = "INSTALLATION";

    public static synchronized String a(Context context) {
        String str;
        synchronized (l.class) {
            if (f1798a == null) {
                File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        c(file);
                    }
                    f1798a = b(file);
                } catch (Exception e4) {
                    throw new RuntimeException(e4);
                }
            }
            str = f1798a;
        }
        return str;
    }

    private static String b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[(int) randomAccessFile.length()];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr);
    }

    private static void c(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(UUID.randomUUID().toString().getBytes());
        fileOutputStream.close();
    }
}
