package com.amap.api.col.p047s;

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

/* compiled from: FileStorageModel.java */
/* renamed from: com.amap.api.col.s.w1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2192w1 {

    /* renamed from: a */
    public static final String f6628a = C2079j1.m52857t("SYmFja3Vwcw");

    /* renamed from: b */
    public static final String f6629b = C2079j1.m52857t("SLmFkaXU");

    /* renamed from: c */
    public static final String f6630c = C2079j1.m52857t("JIw");

    /* renamed from: a */
    private static String m52363a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 31 && (context.getApplicationInfo().targetSdkVersion < 30 || i < 30)) {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            try {
                Class<?> cls = Class.forName(C2079j1.m52857t("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
                Method method = storageManager.getClass().getMethod(C2079j1.m52857t("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
                Method method2 = cls.getMethod(C2079j1.m52857t("ZZ2V0UGF0aA"), new Class[0]);
                Method method3 = cls.getMethod(C2079j1.m52857t("AaXNSZW1vdmFibGUK"), new Class[0]);
                Object invoke = method.invoke(storageManager, new Object[0]);
                int length = Array.getLength(invoke);
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = Array.get(invoke, i2);
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

    /* renamed from: b */
    public static synchronized void m52362b(Context context, String str, String str2) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        synchronized (C2192w1.class) {
            if (Build.VERSION.SDK_INT < 19 || (context != null && context.checkCallingOrSelfPermission(C2079j1.m52857t("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX0VYVEVSTkFMX1NUT1JBR0U=")) == 0 && context.checkCallingOrSelfPermission(C2079j1.m52857t("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) == 0)) {
                String m52363a = m52363a(context);
                if (TextUtils.isEmpty(m52363a)) {
                    return;
                }
                String str3 = str + f6630c + str2;
                File file = new File(m52363a + File.separator + f6628a);
                File file2 = new File(file, f6629b);
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
                    m52361c(randomAccessFile);
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
                    m52361c(randomAccessFile);
                }
            }
        }
    }

    /* renamed from: c */
    private static void m52361c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
