package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FileStorageModel.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class w1 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10356a = j1.t("SYmFja3Vwcw");

    /* renamed from: b  reason: collision with root package name */
    public static final String f10357b = j1.t("SLmFkaXU");

    /* renamed from: c  reason: collision with root package name */
    public static final String f10358c = j1.t("JIw");

    private static String a(Context context) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 31 && (context.getApplicationInfo().targetSdkVersion < 30 || i4 < 30)) {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            try {
                Class<?> cls = Class.forName(j1.t("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
                Method method = storageManager.getClass().getMethod(j1.t("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
                Method method2 = cls.getMethod(j1.t("ZZ2V0UGF0aA"), new Class[0]);
                Method method3 = cls.getMethod(j1.t("AaXNSZW1vdmFibGUK"), new Class[0]);
                Object invoke = method.invoke(storageManager, new Object[0]);
                int length = Array.getLength(invoke);
                for (int i5 = 0; i5 < length; i5++) {
                    Object obj = Array.get(invoke, i5);
                    String str = (String) method2.invoke(obj, new Object[0]);
                    if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                        return str;
                    }
                }
                return null;
            } catch (Throwable unused) {
                return Environment.getExternalStorageDirectory().getAbsolutePath();
            }
        }
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getExternalFilesDir("").getAbsolutePath();
    }

    public static synchronized void b(Context context, String str, String str2) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        synchronized (w1.class) {
            if (Build.VERSION.SDK_INT < 19 || (context != null && context.checkCallingOrSelfPermission(j1.t("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX0VYVEVSTkFMX1NUT1JBR0U=")) == 0 && context.checkCallingOrSelfPermission(j1.t("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) == 0)) {
                String a4 = a(context);
                if (TextUtils.isEmpty(a4)) {
                    return;
                }
                String str3 = str + f10358c + str2;
                File file = new File(a4 + File.separator + f10356a);
                File file2 = new File(file, f10357b);
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
