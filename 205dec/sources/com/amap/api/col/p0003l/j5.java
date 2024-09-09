package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003l.h4;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FileStorageModel.java */
/* renamed from: com.amap.api.col.3l.j5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j5 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8217a = q4.u("SYmFja3Vwcw");

    /* renamed from: b  reason: collision with root package name */
    public static final String f8218b = q4.u("SLmFkaXU");

    /* renamed from: c  reason: collision with root package name */
    public static final String f8219c = q4.u("JIw");

    /* compiled from: NetReuestParam.java */
    /* renamed from: com.amap.api.col.3l.j5$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    final class a implements h4.c {

        /* renamed from: a  reason: collision with root package name */
        private j5 f8220a = new j5();

        a() {
        }

        @Override // com.amap.api.col.p0003l.h4.c
        public final String a() {
            return j5.e();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.amap.api.col.3l.if, com.amap.api.col.3l.o6] */
        @Override // com.amap.api.col.p0003l.h4.c
        public final Cif b(byte[] bArr, Map<String, String> map) {
            return new o6(bArr, map);
        }

        @Override // com.amap.api.col.p0003l.h4.c
        public final String a(Context context, String str) {
            return j5.b(context, str);
        }

        @Override // com.amap.api.col.p0003l.h4.c
        public final Map<String, String> b() {
            return this.f8220a.d();
        }

        @Override // com.amap.api.col.p0003l.h4.c
        public final String a(String str, String str2, String str3, String str4) {
            return this.f8220a.c(str, str2, str3, str4);
        }
    }

    private static String a(Context context) {
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

    public static synchronized void b(Context context, String str, String str2) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        synchronized (j5.class) {
            if (Build.VERSION.SDK_INT < 19 || (context != null && context.checkCallingOrSelfPermission(q4.u("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) == 0)) {
                String a4 = a(context);
                if (TextUtils.isEmpty(a4)) {
                    return;
                }
                String str3 = str + f8219c + str2;
                File file = new File(a4 + File.separator + f8217a);
                File file2 = new File(file, f8218b);
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
                    c(randomAccessFile);
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
                    c(randomAccessFile);
                }
            }
        }
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
