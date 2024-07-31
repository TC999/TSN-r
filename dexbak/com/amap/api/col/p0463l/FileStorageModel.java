package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* renamed from: com.amap.api.col.3l.i5 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FileStorageModel {

    /* renamed from: a */
    public static final String f4505a = C1925p4.m54183u("SYmFja3Vwcw");

    /* renamed from: b */
    public static final String f4506b = C1925p4.m54183u("SLmFkaXU");

    /* renamed from: c */
    public static final String f4507c = C1925p4.m54183u("JIw");

    /* renamed from: a */
    private static String m54713a(Context context) {
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static synchronized void m54712b(Context context, String str, String str2) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        synchronized (FileStorageModel.class) {
            if (Build.VERSION.SDK_INT < 19 || (context != null && context.checkCallingOrSelfPermission(C1925p4.m54183u("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) == 0)) {
                String m54713a = m54713a(context);
                if (TextUtils.isEmpty(m54713a)) {
                    return;
                }
                String str3 = str + f4507c + str2;
                File file = new File(m54713a + File.separator + f4505a);
                File file2 = new File(file, f4506b);
                FileLock fileLock = null;
                try {
                    if (!file.exists() || file.isDirectory()) {
                        file.mkdirs();
                    }
                    file2.createNewFile();
                    randomAccessFile = new RandomAccessFile(file2, "rws");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                    } catch (Throwable unused) {
                        fileChannel = null;
                    }
                } catch (Throwable unused2) {
                    fileChannel = null;
                    randomAccessFile = null;
                }
                try {
                    fileLock = fileChannel.tryLock();
                    if (fileLock != null) {
                        fileChannel.write(ByteBuffer.wrap(str3.getBytes("UTF-8")));
                    }
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException unused3) {
                        }
                    }
                    try {
                        fileChannel.close();
                    } catch (IOException unused4) {
                    }
                    m54711c(randomAccessFile);
                } catch (Throwable unused5) {
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException unused6) {
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused7) {
                        }
                    }
                    m54711c(randomAccessFile);
                }
            }
        }
    }

    /* renamed from: c */
    private static void m54711c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
