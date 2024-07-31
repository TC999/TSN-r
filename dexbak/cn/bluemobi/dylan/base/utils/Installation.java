package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

/* renamed from: cn.bluemobi.dylan.base.utils.l */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Installation {

    /* renamed from: a */
    private static String f1812a = null;

    /* renamed from: b */
    private static final String f1813b = "INSTALLATION";

    /* renamed from: a */
    public static synchronized String m57733a(Context context) {
        String str;
        synchronized (Installation.class) {
            if (f1812a == null) {
                File file = new File(context.getFilesDir(), f1813b);
                try {
                    if (!file.exists()) {
                        m57731c(file);
                    }
                    f1812a = m57732b(file);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            str = f1812a;
        }
        return str;
    }

    /* renamed from: b */
    private static String m57732b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[(int) randomAccessFile.length()];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr);
    }

    /* renamed from: c */
    private static void m57731c(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(UUID.randomUUID().toString().getBytes());
        fileOutputStream.close();
    }
}
