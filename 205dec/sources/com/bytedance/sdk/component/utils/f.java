package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: com.bytedance.sdk.component.utils.f$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(File file, File file2) {
            long lastModified = file2.lastModified() - file.lastModified();
            if (lastModified == 0) {
                return 0;
            }
            return lastModified < 0 ? -1 : 1;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static final class c implements Comparator<File> {
        private c() {
        }

        private int c(long j4, long j5) {
            if (j4 < j5) {
                return -1;
            }
            return j4 == j5 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(File file, File file2) {
            return c(file.lastModified(), file2.lastModified());
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File c(android.content.Context r1, boolean r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = w(r1)
            if (r2 == 0) goto L1f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = c(r1)
            r2.append(r1)
            java.lang.String r1 = "-"
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            goto L30
        L1f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
        L30:
            if (r0 == 0) goto L4a
            java.lang.String r2 = java.io.File.separator
            boolean r3 = r0.endsWith(r2)
            if (r3 != 0) goto L4a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            goto L4c
        L4a:
            java.lang.String r2 = ""
        L4c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L69
            r2.mkdirs()
        L69:
            java.io.File r2 = new java.io.File
            r2.<init>(r1, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.f.c(android.content.Context, boolean, java.lang.String, java.lang.String):java.io.File");
    }

    private static void f(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r2 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] sr(java.io.File r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L4d
            boolean r1 = r7.isFile()
            if (r1 == 0) goto L4d
            boolean r1 = r7.exists()
            if (r1 == 0) goto L4d
            boolean r1 = r7.canRead()
            if (r1 == 0) goto L4d
            long r1 = r7.length()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L4d
            long r1 = r7.length()     // Catch: java.lang.Throwable -> L49
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L49
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L49
            int r7 = r1.intValue()     // Catch: java.lang.Throwable -> L47
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L47
            int r3 = r2.read(r7)     // Catch: java.lang.Throwable -> L47
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L47
            long r5 = r1.longValue()     // Catch: java.lang.Throwable -> L47
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L43
            r2.close()     // Catch: java.lang.Throwable -> L42
        L42:
            return r7
        L43:
            r2.close()     // Catch: java.lang.Throwable -> L4d
            goto L4d
        L47:
            goto L4a
        L49:
            r2 = r0
        L4a:
            if (r2 == 0) goto L4d
            goto L43
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.f.sr(java.io.File):byte[]");
    }

    private static void ux(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long j4;
        long length = file.length();
        if (length == 0) {
            f(file);
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            j4 = length - 1;
        } catch (Throwable unused) {
        }
        try {
            randomAccessFile.seek(j4);
            byte readByte = randomAccessFile.readByte();
            randomAccessFile.seek(j4);
            randomAccessFile.write(readByte);
            randomAccessFile.close();
        } catch (Throwable unused2) {
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
        }
    }

    public static File w(Context context, boolean z3, String str, String str2) {
        String xv = xv(context);
        if (z3) {
            str = c(context) + "-" + str;
        }
        if (xv != null) {
            String str3 = File.separator;
            if (!xv.endsWith(str3)) {
                xv = xv + str3;
            }
        }
        String str4 = xv + str;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str4, str2);
    }

    private static String xv(Context context) {
        File w3;
        if (context == null || (w3 = com.bytedance.sdk.openadsdk.api.plugin.w.w(context)) == null) {
            return null;
        }
        return w3.getPath();
    }

    public static void xv(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (file.isFile()) {
                file.delete();
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            xv(file2);
                        } else {
                            try {
                                file2.delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
                file.delete();
            }
        } catch (Throwable unused2) {
        }
    }

    public static File w(Context context, boolean z3, String str) {
        String absolutePath = com.bytedance.sdk.openadsdk.api.plugin.w.w(context).getAbsolutePath();
        if (z3) {
            str = c(context) + "-" + str;
        }
        if (absolutePath != null) {
            String str2 = File.separator;
            if (!absolutePath.endsWith(str2)) {
                absolutePath = absolutePath + str2;
            }
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File c(android.content.Context r1, boolean r2, java.lang.String r3) {
        /*
            java.lang.String r0 = w(r1)
            if (r2 == 0) goto L1e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = c(r1)
            r2.append(r1)
            java.lang.String r1 = "-"
            r2.append(r1)
            r2.append(r3)
            java.lang.String r3 = r2.toString()
        L1e:
            if (r0 == 0) goto L38
            java.lang.String r1 = java.io.File.separator
            boolean r2 = r0.endsWith(r1)
            if (r2 != 0) goto L38
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L3a
        L38:
            java.lang.String r1 = ""
        L3a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 != 0) goto L57
            r2.mkdirs()
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.f.c(android.content.Context, boolean, java.lang.String):java.io.File");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (android.os.Environment.isExternalStorageRemovable() == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String w(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            r1 = 0
            java.lang.String r2 = "mounted"
            java.lang.String r3 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Throwable -> L19
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L17
            boolean r2 = android.os.Environment.isExternalStorageRemovable()     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L1d
        L17:
            r1 = 1
            goto L1d
        L19:
            r2 = move-exception
            r2.printStackTrace()
        L1d:
            if (r1 == 0) goto L26
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.w.xv(r4)     // Catch: java.lang.Throwable -> L24
            goto L27
        L24:
            r1 = r0
            goto L2f
        L26:
            r1 = r0
        L27:
            if (r1 != 0) goto L2f
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.w.w(r4)     // Catch: java.lang.Throwable -> L2e
            goto L2f
        L2e:
        L2f:
            if (r1 != 0) goto L32
            goto L36
        L32:
            java.lang.String r0 = r1.getPath()
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.f.w(android.content.Context):java.lang.String");
    }

    public static List<File> c(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> asList = Arrays.asList(listFiles);
            Collections.sort(asList, new c(null));
            return asList;
        }
        return linkedList;
    }

    public static String c(Context context) {
        String c4 = fz.c(context);
        return (TextUtils.isEmpty(c4) || !c4.contains(":")) ? c4 : c4.replace(":", "-");
    }

    public static void w(File file) throws IOException {
        if (file.exists()) {
            a.f("splashLoadAd", "update file modify time");
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            ux(file);
            if (file.lastModified() < currentTimeMillis) {
                a.sr("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }
}
