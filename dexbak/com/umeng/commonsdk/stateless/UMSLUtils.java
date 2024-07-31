package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.zip.Deflater;

/* renamed from: com.umeng.commonsdk.stateless.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMSLUtils {

    /* renamed from: a */
    public static int f38910a;

    /* renamed from: b */
    private static Object f38911b = new Object();

    /* renamed from: a */
    public static boolean m13865a(long j, long j2) {
        return j > j2;
    }

    /* renamed from: a */
    public static boolean m13859a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!m13859a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0101, code lost:
        if (r2 == null) goto L37;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m13855b(android.content.Context r8, java.lang.String r9, java.lang.String r10, byte[] r11) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.UMSLUtils.m13855b(android.content.Context, java.lang.String, java.lang.String, byte[]):boolean");
    }

    /* renamed from: c */
    public static File[] m13852c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f38911b) {
                String str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + UMSLConfig.f38888f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f38911b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.3
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file2, File file3) {
                                long lastModified = file2.lastModified() - file3.lastModified();
                                if (lastModified > 0) {
                                    return 1;
                                }
                                return lastModified == 0 ? 0 : -1;
                            }
                        });
                        return listFiles;
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    /* renamed from: d */
    public static String m13850d(String str) {
        int lastIndexOf;
        int lastIndexOf2;
        return (!TextUtils.isEmpty(str) && str.indexOf("envelope") < 0 && (lastIndexOf = str.lastIndexOf("_")) >= 0 && (lastIndexOf2 = str.lastIndexOf(".")) >= 0) ? str.substring(lastIndexOf + 1, lastIndexOf2) : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        if (r1 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
        if (r1 == null) goto L42;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m13861a(android.content.Context r6, java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            r0 = 101(0x65, float:1.42E-43)
            if (r6 == 0) goto L75
            r1 = 0
            java.lang.Object r2 = com.umeng.commonsdk.stateless.UMSLUtils.f38911b     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L67
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L67
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r4.<init>()     // Catch: java.lang.Throwable -> L5a
            java.io.File r5 = r6.getFilesDir()     // Catch: java.lang.Throwable -> L5a
            r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Throwable -> L5a
            r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            r4.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L5a
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L5a
            boolean r7 = r3.isDirectory()     // Catch: java.lang.Throwable -> L5a
            if (r7 != 0) goto L2e
            r3.mkdir()     // Catch: java.lang.Throwable -> L5a
        L2e:
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r4.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L5a
            r4.append(r3)     // Catch: java.lang.Throwable -> L5a
            r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            r4.append(r8)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L5a
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L5a
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5a
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L5a
            r8.write(r9)     // Catch: java.lang.Throwable -> L57
            r8.close()     // Catch: java.lang.Throwable -> L57
            r0 = 0
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5a
            goto L75
        L57:
            r7 = move-exception
            r1 = r8
            goto L5b
        L5a:
            r7 = move-exception
        L5b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5a
            throw r7     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L67
        L5d:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L75
        L63:
            r1.close()     // Catch: java.lang.Throwable -> L75
            goto L75
        L67:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L75
            goto L63
        L6e:
            r6 = move-exception
            if (r1 == 0) goto L74
            r1.close()     // Catch: java.lang.Throwable -> L74
        L74:
            throw r6
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.UMSLUtils.m13861a(android.content.Context, java.lang.String, java.lang.String, byte[]):int");
    }

    /* renamed from: c */
    public static String m13851c(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static byte[] m13858a(String str) throws IOException {
        byte[] bArr;
        synchronized (f38911b) {
            try {
                FileChannel channel = new RandomAccessFile(str, "r").getChannel();
                MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                bArr = new byte[(int) channel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    channel.close();
                } catch (Throwable unused) {
                }
            } catch (IOException e) {
                ULog.m13781i("walle", "[stateless] write envelope, e is " + e.getMessage());
                throw e;
            }
        }
        return bArr;
    }

    /* renamed from: b */
    public static File m13856b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f38911b) {
                String str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + UMSLConfig.f38888f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f38911b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.2
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file2, File file3) {
                                long lastModified = file2.lastModified() - file3.lastModified();
                                if (lastModified > 0) {
                                    return 1;
                                }
                                return lastModified == 0 ? 0 : -1;
                            }
                        });
                        return listFiles[0];
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    /* renamed from: a */
    public static File m13864a(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File file = null;
        try {
            synchronized (f38911b) {
                ULog.m13781i("walle", "get last envelope begin, thread is " + Thread.currentThread());
                if (context != null && StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                    String str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + UMSLConfig.f38887e;
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                            for (File file3 : listFiles) {
                                if (file3 != null && file3.isDirectory() && (listFiles2 = file3.listFiles()) != null && listFiles2.length > 0) {
                                    Arrays.sort(listFiles2, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.1
                                        @Override // java.util.Comparator
                                        /* renamed from: a */
                                        public int compare(File file4, File file5) {
                                            long lastModified = file4.lastModified() - file5.lastModified();
                                            if (lastModified > 0) {
                                                return 1;
                                            }
                                            return lastModified == 0 ? 0 : -1;
                                        }
                                    });
                                    File file4 = listFiles2[0];
                                    if (file4 != null && (file == null || file.lastModified() > file4.lastModified())) {
                                        file = file4;
                                    }
                                }
                            }
                        }
                    }
                }
                ULog.m13781i("walle", "get last envelope end, thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return file;
    }

    /* renamed from: b */
    public static String m13853b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    /* renamed from: b */
    public static String m13854b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m13860a(Context context, boolean z) {
        String str;
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (z) {
                str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + UMSLConfig.f38887e;
            } else {
                str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + UMSLConfig.f38888f;
            }
            str2 = str;
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* renamed from: a */
    public static void m13863a(Context context, String str, int i) {
        try {
            if (str == null) {
                ULog.m13781i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.m13781i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (f38911b) {
                File[] listFiles = file.listFiles();
                ULog.m13781i("AmapLBS", "[lbs-build] delete file begin " + listFiles.length + ", thread is " + Thread.currentThread());
                if (listFiles.length >= i) {
                    ULog.m13781i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i) {
                        Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.4
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file3, File file4) {
                                if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                    return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                }
                                return -1;
                            }
                        });
                        if (ULog.DEBUG) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                ULog.m13781i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i2)).getPath());
                            }
                        }
                        for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                            if (arrayList.get(i3) != null) {
                                ULog.m13781i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i3)).getPath());
                                try {
                                    ((File) arrayList.get(i3)).delete();
                                    arrayList.remove(i3);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                } else {
                    ULog.m13781i("AmapLBS", "[lbs-build] file size < max");
                }
                ULog.m13781i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* renamed from: a */
    public static void m13862a(Context context, String str, final String str2, int i) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.isDirectory()) {
                synchronized (f38911b) {
                    File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.umeng.commonsdk.stateless.d.5
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file2, String str3) {
                            return str3.startsWith(str2);
                        }
                    });
                    if (listFiles != null && listFiles.length >= i) {
                        ULog.m13781i("AmapLBS", "[lbs-build] file size >= max");
                        ArrayList arrayList = new ArrayList();
                        for (File file2 : listFiles) {
                            if (file2 != null) {
                                arrayList.add(file2);
                            }
                        }
                        if (arrayList.size() >= i) {
                            Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.6
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(File file3, File file4) {
                                    if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                        return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                    }
                                    return -1;
                                }
                            });
                            if (ULog.DEBUG) {
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    ULog.m13781i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i2)).getPath());
                                }
                            }
                            for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                                if (arrayList.get(i3) != null) {
                                    ULog.m13781i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i3)).getPath());
                                    try {
                                        ((File) arrayList.get(i3)).delete();
                                        arrayList.remove(i3);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    } else {
                        ULog.m13781i("AmapLBS", "[lbs-build] file size < max");
                    }
                    ULog.m13781i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* renamed from: a */
    public static byte[] m13857a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f38910a = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    f38910a += deflate;
                    byteArrayOutputStream2.write(bArr2, 0, deflate);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
