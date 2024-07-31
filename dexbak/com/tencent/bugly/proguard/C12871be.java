package com.tencent.bugly.proguard;

import android.content.Context;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.be */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12871be {

    /* renamed from: a */
    private static List<File> f36723a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static String m15691a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split(ShellAdbUtils.f33810d);
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append(ShellAdbUtils.f33810d);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static String m15684b(String str, String str2) {
        BufferedReader m15816b = C12828ap.m15816b(str, "reg_record.txt");
        if (m15816b == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = m15816b.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                int i = 18;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    String readLine2 = m15816b.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    if (i2 % 4 == 0) {
                        if (i2 > 0) {
                            sb.append(ShellAdbUtils.f33810d);
                        }
                        sb.append("  ");
                    } else {
                        if (readLine2.length() > 16) {
                            i = 28;
                        }
                        sb.append("                ".substring(0, i - i3));
                    }
                    i3 = readLine2.length();
                    sb.append(readLine2);
                    i2++;
                }
                sb.append(ShellAdbUtils.f33810d);
                return sb.toString();
            }
            try {
                m15816b.close();
            } catch (Exception e) {
                C12820al.m15877a(e);
            }
            return null;
        } catch (Throwable th) {
            try {
                C12820al.m15877a(th);
                try {
                    m15816b.close();
                } catch (Exception e2) {
                    C12820al.m15877a(e2);
                }
                return null;
            } finally {
                try {
                    m15816b.close();
                } catch (Exception e3) {
                    C12820al.m15877a(e3);
                }
            }
        }
    }

    /* renamed from: c */
    private static String m15681c(String str, String str2) {
        BufferedReader m15816b = C12828ap.m15816b(str, "map_record.txt");
        if (m15816b == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = m15816b.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = m15816b.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(readLine2);
                    sb.append(ShellAdbUtils.f33810d);
                }
                return sb.toString();
            }
            try {
                m15816b.close();
            } catch (Exception e) {
                C12820al.m15877a(e);
            }
            return null;
        } catch (Throwable th) {
            try {
                C12820al.m15877a(th);
                try {
                    m15816b.close();
                } catch (Exception e2) {
                    C12820al.m15877a(e2);
                }
                return null;
            } finally {
                try {
                    m15816b.close();
                } catch (Exception e3) {
                    C12820al.m15877a(e3);
                }
            }
        }
    }

    /* renamed from: d */
    private static Map<String, Integer> m15680d(String str) {
        String[] split;
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split2 = str2.split(":");
                if (split2.length != 2) {
                    C12820al.m15872e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e) {
            C12820al.m15872e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static <KeyT, ValueT> ValueT m15687a(Map<KeyT, ValueT> map, KeyT keyt, ValueT valuet) {
        ValueT valuet2;
        try {
            valuet2 = map.get(keyt);
        } catch (Exception e) {
            C12820al.m15877a(e);
        }
        return valuet2 != null ? valuet2 : valuet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
        return null;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m15692a(java.io.BufferedInputStream r4) throws java.io.IOException {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L26
            r2 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L26
        L8:
            int r2 = r4.read()     // Catch: java.lang.Throwable -> L24
            r3 = -1
            if (r2 == r3) goto L2d
            if (r2 != 0) goto L20
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L24
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = "UTf-8"
            r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L24
            r1.close()
            return r4
        L20:
            r1.write(r2)     // Catch: java.lang.Throwable -> L24
            goto L8
        L24:
            r4 = move-exception
            goto L28
        L26:
            r4 = move-exception
            r1 = r0
        L28:
            com.tencent.bugly.proguard.C12820al.m15877a(r4)     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L30
        L2d:
            r1.close()
        L30:
            return r0
        L31:
            r4 = move-exception
            if (r1 == 0) goto L37
            r1.close()
        L37:
            goto L39
        L38:
            throw r4
        L39:
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12871be.m15692a(java.io.BufferedInputStream):java.lang.String");
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* renamed from: a */
    public static CrashDetailBean m15694a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String m15692a;
        BufferedInputStream bufferedInputStream2 = null;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                ?? canRead = file.canRead();
                try {
                    if (canRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        } catch (IOException e) {
                            e = e;
                            bufferedInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            String m15692a2 = m15692a(bufferedInputStream);
                            if (m15692a2 != null && m15692a2.equals("NATIVE_RQD_REPORT")) {
                                HashMap hashMap = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        m15692a = m15692a(bufferedInputStream);
                                        if (m15692a == null) {
                                            break loop0;
                                        } else if (str2 == null) {
                                            str2 = m15692a;
                                        }
                                    }
                                    hashMap.put(str2, m15692a);
                                }
                                if (str2 != null) {
                                    C12820al.m15872e("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean m15693a = m15693a(context, hashMap, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                return m15693a;
                            }
                            C12820al.m15872e("record read fail! %s", m15692a2);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                            return null;
                        } catch (IOException e6) {
                            e = e6;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = canRead;
                }
            }
            return null;
        }
        C12820al.m15872e("get eup record file args error", new Object[0]);
        return null;
    }

    /* renamed from: c */
    public static void m15682c(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        C12820al.m15874c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            C12820al.m15877a(th);
        }
    }

    /* renamed from: b */
    public static String m15685b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* renamed from: b */
    private static long m15683b(Map<String, String> map) {
        String str = map.get("launchTime");
        if (str != null) {
            C12820al.m15874c("[Native record info] launchTime: %s", str);
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e) {
                if (C12820al.m15877a(e)) {
                    return -1L;
                }
                e.printStackTrace();
                return -1L;
            }
        }
        return -1L;
    }

    /* renamed from: a */
    public static String m15689a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String m15684b = m15684b(str, str2);
        if (m15684b != null && !m15684b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(m15684b);
        }
        String m15681c = m15681c(str, str2);
        if (m15681c != null && !m15681c.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(ShellAdbUtils.f33810d);
            }
            sb.append("System SO infos:\n");
            sb.append(m15681c);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m15686a(boolean z, String str) {
        if (str != null) {
            f36723a.add(new File(str, "rqd_record.eup"));
            f36723a.add(new File(str, "reg_record.txt"));
            f36723a.add(new File(str, "map_record.txt"));
            f36723a.add(new File(str, "backup_record.txt"));
            if (z) {
                m15682c(str);
            }
        }
        List<File> list = f36723a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f36723a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                C12820al.m15874c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    /* renamed from: a */
    public static String m15690a(String str, int i, String str2, boolean z) {
        BufferedReader bufferedReader = null;
        if (str != null && i > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                C12820al.m15878a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f36723a.add(file);
                C12820al.m15874c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return C12828ap.m15838a(new File(str), i, z);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (Pattern.compile(str2 + "[ ]*:").matcher(readLine).find()) {
                                    sb.append(readLine);
                                    sb.append(ShellAdbUtils.f33810d);
                                }
                                if (i > 0 && sb.length() > i) {
                                    if (z) {
                                        sb.delete(i, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    C12820al.m15877a(th);
                                    sb.append("\n[error:" + th.toString() + "]");
                                    String sb2 = sb.toString();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                        sb = sb2;
                                        return sb;
                                    }
                                    return sb2;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e) {
                                            C12820al.m15877a(e);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String sb3 = sb.toString();
                        bufferedReader2.close();
                        sb = sb3;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    return sb;
                } catch (Exception e2) {
                    C12820al.m15877a(e2);
                    return sb;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Map<String, String> m15688a(Map<String, String> map) {
        String str = map.get("key-value");
        if (str != null) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(ShellAdbUtils.f33810d)) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
            return hashMap;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tencent.bugly.crashreport.crash.CrashDetailBean m15693a(android.content.Context r25, java.util.Map<java.lang.String, java.lang.String> r26, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler r27) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12871be.m15693a(android.content.Context, java.util.Map, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }
}
