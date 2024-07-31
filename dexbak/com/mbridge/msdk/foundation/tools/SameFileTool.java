package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.SDKController;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.same.p476c.CommonStringUtil;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
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

/* renamed from: com.mbridge.msdk.foundation.tools.v */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SameFileTool extends DomainSameFileTool {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r1 == null) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m21756a(java.io.File r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.SameFileTool.m21756a(java.io.File):java.lang.String");
    }

    /* renamed from: b */
    public static File[] m21748b(String str) {
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

    /* renamed from: c */
    private static long m21747c(File file) throws Exception {
        long j = 0;
        FileInputStream fileInputStream = null;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        j = fileInputStream2.available();
                        fileInputStream = fileInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return j;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    file.createNewFile();
                    SameLogTool.m21733d("获取文件大小", "文件不存在!");
                }
            } catch (Exception e4) {
                e = e4;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: d */
    private static long m21745d(File file) throws Exception {
        long m21747c;
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    m21747c = m21745d(listFiles[i]);
                } else {
                    m21747c = m21747c(listFiles[i]);
                }
                j += m21747c;
            }
        }
        return j;
    }

    /* renamed from: e */
    private static ArrayList<File> m21743e(File file) {
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
                arrayList.addAll(m21743e(file2));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static void m21750b() {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.v.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
                    if (m23252b == null) {
                        m23252b = SettingManager.m23261a().m23253b();
                    }
                    SameFileTool.m21754a(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_RES_MANAGER_DIR), m23252b.m23293p());
                    SameFileTool.m21757a(System.currentTimeMillis() - (m23252b.m23406X() * 1000));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        };
        if (SDKController.m22827a().m22818d()) {
            ThreadPoolUtils.m22309a().execute(runnable);
        } else {
            runnable.run();
        }
    }

    /* renamed from: d */
    public static String m21744d(String str) {
        return !TextUtils.isEmpty(str) ? SameMD5.getMD5(UriUtil.m21950a(str.trim())) : "";
    }

    /* renamed from: e */
    private static void m21742e(String str) {
        try {
            ArrayList<File> m21743e = m21743e(new File(str));
            Collections.sort(m21743e, new Comparator<File>() { // from class: com.mbridge.msdk.foundation.tools.v.4
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
            int size = (m21743e.size() - 1) / 2;
            for (int i = 0; i < size; i++) {
                File file = m21743e.get(i);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            SameLogTool.m21733d("SameFileTool", "del memory failed");
        }
    }

    /* renamed from: b */
    public static String m21749b(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        m21749b(file2);
                    }
                    file.delete();
                    return "";
                }
                file.delete();
                return "";
            } else {
                return "";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /* renamed from: a */
    public static boolean m21755a(String str) {
        if (CommonStringUtil.m22320a(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    /* renamed from: c */
    public static void m21746c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b == null) {
                m23252b = SettingManager.m23261a().m23253b();
            }
            long currentTimeMillis = System.currentTimeMillis() - (m23252b.m23406X() * 1000);
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.lastModified() + currentTimeMillis < currentTimeMillis2) {
                            m21749b(file2);
                            try {
                                File file3 = new File(str + ".zip");
                                if (file3.exists() && file3.isFile()) {
                                    m21749b(file3);
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

    /* renamed from: a */
    public static void m21758a() {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.v.1
            @Override // java.lang.Runnable
            public final void run() {
                File[] m21748b;
                try {
                    if (MBSDKContext.m22865f().m22861j() != null) {
                        String m22347b = MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_VC);
                        try {
                            File file = new File(m22347b);
                            if (file.exists() && file.isDirectory()) {
                                for (File file2 : SameFileTool.m21748b(m22347b)) {
                                    if (file2.exists() && file2.isFile()) {
                                        file2.delete();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /* renamed from: a */
    public static void m21757a(long j) {
        try {
            Iterator<File> it = m21743e(new File(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_RES_MANAGER_DIR))).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next.lastModified() < j && next.exists() && next.isFile()) {
                    next.delete();
                }
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("SameFileTool", th.getMessage(), th);
        }
    }

    /* renamed from: a */
    public static boolean m21751a(byte[] bArr, File file) {
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
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m21752a(java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.SameFileTool.m21752a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static boolean m21753a(String str, int i, int i2, int i3) {
        try {
            Class<?> cls = Class.forName("android.os.FileUtils");
            Class<?> cls2 = Integer.TYPE;
            cls.getMethod("setPermissions", String.class, cls2, cls2, cls2).invoke(null, str, Integer.valueOf(i), -1, -1);
            return true;
        } catch (ClassNotFoundException e) {
            SameLogTool.m21737a("SameFileTool", "error when set permissions:", e);
            return false;
        } catch (IllegalAccessException e2) {
            SameLogTool.m21737a("SameFileTool", "error when set permissions:", e2);
            return false;
        } catch (IllegalArgumentException e3) {
            SameLogTool.m21737a("SameFileTool", "error when set permissions:", e3);
            return false;
        } catch (NoSuchMethodException e4) {
            SameLogTool.m21737a("SameFileTool", "error when set permissions:", e4);
            return false;
        } catch (InvocationTargetException e5) {
            SameLogTool.m21737a("SameFileTool", "error when set permissions:", e5);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m21754a(String str, int i) {
        try {
            if (m21745d(new File(str)) > i * 1048576) {
                m21742e(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable unused) {
            SameLogTool.m21733d("SameFileTool", "clean memory failed");
        }
    }
}
