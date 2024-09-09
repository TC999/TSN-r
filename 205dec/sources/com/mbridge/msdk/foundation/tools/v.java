package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: SameFileTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class v extends f {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r1 == null) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L4c
            r4.<init>()     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L4c
        L13:
            java.lang.String r2 = r1.readLine()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L4c
            if (r2 == 0) goto L2e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L4c
            r3.<init>()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L4c
            r3.append(r2)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L4c
            java.lang.String r2 = "\n"
            r3.append(r2)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L4c
            java.lang.String r2 = r3.toString()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L4c
            r4.append(r2)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L4c
            goto L13
        L2e:
            r1.close()     // Catch: java.io.IOException -> L32
            goto L44
        L32:
            goto L44
        L34:
            r2 = move-exception
            goto L3e
        L36:
            r2 = move-exception
            r4 = r0
            goto L3e
        L39:
            r4 = move-exception
            goto L4e
        L3b:
            r2 = move-exception
            r4 = r0
            r1 = r4
        L3e:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L4c
            if (r1 == 0) goto L44
            goto L2e
        L44:
            if (r4 == 0) goto L4b
            java.lang.String r4 = r4.toString()
            return r4
        L4b:
            return r0
        L4c:
            r4 = move-exception
            r0 = r1
        L4e:
            if (r0 == 0) goto L53
            r0.close()     // Catch: java.io.IOException -> L53
        L53:
            goto L55
        L54:
            throw r4
        L55:
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.v.a(java.io.File):java.lang.String");
    }

    public static File[] b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.listFiles();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static long c(File file) throws Exception {
        long j4 = 0;
        FileInputStream fileInputStream = null;
        try {
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        j4 = fileInputStream2.available();
                        fileInputStream = fileInputStream2;
                    } catch (Exception e5) {
                        e = e5;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return j4;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    file.createNewFile();
                    x.d("\u83b7\u53d6\u6587\u4ef6\u5927\u5c0f", "\u6587\u4ef6\u4e0d\u5b58\u5728!");
                }
            } catch (Exception e7) {
                e = e7;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return j4;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static long d(File file) throws Exception {
        long c4;
        File[] listFiles = file.listFiles();
        long j4 = 0;
        if (listFiles != null) {
            for (int i4 = 0; i4 < listFiles.length; i4++) {
                if (listFiles[i4].isDirectory()) {
                    c4 = d(listFiles[i4]);
                } else {
                    c4 = c(listFiles[i4]);
                }
                j4 += c4;
            }
        }
        return j4;
    }

    private static ArrayList<File> e(File file) {
        File[] listFiles;
        ArrayList<File> arrayList = new ArrayList<>();
        for (File file2 : file.listFiles(new FileFilter() { // from class: com.mbridge.msdk.foundation.tools.v.3
            @Override // java.io.FileFilter
            public final boolean accept(File file3) {
                return !file3.isHidden() || file3.isDirectory();
            }
        })) {
            if (!file2.isDirectory()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(e(file2));
            }
        }
        return arrayList;
    }

    public static void b() {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.v.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
                    if (b4 == null) {
                        b4 = com.mbridge.msdk.c.b.a().b();
                    }
                    v.a(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_RES_MANAGER_DIR), b4.p());
                    v.a(System.currentTimeMillis() - (b4.X() * 1000));
                } catch (Exception e4) {
                    if (MBridgeConstans.DEBUG) {
                        e4.printStackTrace();
                    }
                }
            }
        };
        if (com.mbridge.msdk.foundation.controller.b.a().d()) {
            com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static String d(String str) {
        return !TextUtils.isEmpty(str) ? SameMD5.getMD5(ai.a(str.trim())) : "";
    }

    private static void e(String str) {
        try {
            ArrayList<File> e4 = e(new File(str));
            Collections.sort(e4, new Comparator<File>() { // from class: com.mbridge.msdk.foundation.tools.v.4
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file, File file2) {
                    long lastModified = file.lastModified() - file2.lastModified();
                    if (lastModified > 0) {
                        return 1;
                    }
                    return lastModified == 0 ? 0 : -1;
                }

                @Override // java.util.Comparator
                public final boolean equals(Object obj) {
                    return true;
                }
            });
            int size = (e4.size() - 1) / 2;
            for (int i4 = 0; i4 < size; i4++) {
                File file = e4.get(i4);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            x.d("SameFileTool", "del memory failed");
        }
    }

    public static String b(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        b(file2);
                    }
                    file.delete();
                    return "";
                }
                file.delete();
                return "";
            } else {
                return "";
            }
        } catch (Exception e4) {
            return e4.getMessage();
        }
    }

    public static boolean a(String str) {
        if (com.mbridge.msdk.foundation.same.c.e.a(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public static void c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 == null) {
                b4 = com.mbridge.msdk.c.b.a().b();
            }
            long currentTimeMillis = System.currentTimeMillis() - (b4.X() * 1000);
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.lastModified() + currentTimeMillis < currentTimeMillis2) {
                            b(file2);
                            try {
                                File file3 = new File(str + ".zip");
                                if (file3.exists() && file3.isFile()) {
                                    b(file3);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static void a() {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.v.1
            @Override // java.lang.Runnable
            public final void run() {
                File[] b4;
                try {
                    if (com.mbridge.msdk.foundation.controller.a.f().j() != null) {
                        String b5 = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC);
                        try {
                            File file = new File(b5);
                            if (file.exists() && file.isDirectory()) {
                                for (File file2 : v.b(b5)) {
                                    if (file2.exists() && file2.isFile()) {
                                        file2.delete();
                                    }
                                }
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void a(long j4) {
        try {
            Iterator<File> it = e(new File(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_RES_MANAGER_DIR))).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next.lastModified() < j4 && next.exists() && next.isFile()) {
                    next.delete();
                }
            }
        } catch (Throwable th) {
            x.b("SameFileTool", th.getMessage(), th);
        }
    }

    public static boolean a(byte[] bArr, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return true;
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ed, code lost:
        if (r10 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ef, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f3, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f4, code lost:
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0119, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x011c, code lost:
        if (r10 == null) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x011e, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0122, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0123, code lost:
        r10.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.v.a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(String str, int i4, int i5, int i6) {
        try {
            Class<?> cls = Class.forName("android.os.FileUtils");
            Class<?> cls2 = Integer.TYPE;
            cls.getMethod("setPermissions", String.class, cls2, cls2, cls2).invoke(null, str, Integer.valueOf(i4), -1, -1);
            return true;
        } catch (ClassNotFoundException e4) {
            x.a("SameFileTool", "error when set permissions:", e4);
            return false;
        } catch (IllegalAccessException e5) {
            x.a("SameFileTool", "error when set permissions:", e5);
            return false;
        } catch (IllegalArgumentException e6) {
            x.a("SameFileTool", "error when set permissions:", e6);
            return false;
        } catch (NoSuchMethodException e7) {
            x.a("SameFileTool", "error when set permissions:", e7);
            return false;
        } catch (InvocationTargetException e8) {
            x.a("SameFileTool", "error when set permissions:", e8);
            return false;
        }
    }

    static /* synthetic */ void a(String str, int i4) {
        try {
            if (d(new File(str)) > i4 * 1048576) {
                e(str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        } catch (Throwable unused) {
            x.d("SameFileTool", "clean memory failed");
        }
    }
}
