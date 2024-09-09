package com.tencent.bugly.proguard;

import android.content.Context;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class be {

    /* renamed from: a  reason: collision with root package name */
    private static List<File> f51093a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static String b(String str, String str2) {
        BufferedReader b4 = ap.b(str, "reg_record.txt");
        if (b4 == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = b4.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                int i4 = 18;
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    String readLine2 = b4.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    if (i5 % 4 == 0) {
                        if (i5 > 0) {
                            sb.append("\n");
                        }
                        sb.append("  ");
                    } else {
                        if (readLine2.length() > 16) {
                            i4 = 28;
                        }
                        sb.append("                ".substring(0, i4 - i6));
                    }
                    i6 = readLine2.length();
                    sb.append(readLine2);
                    i5++;
                }
                sb.append("\n");
                return sb.toString();
            }
            try {
                b4.close();
            } catch (Exception e4) {
                al.a(e4);
            }
            return null;
        } catch (Throwable th) {
            try {
                al.a(th);
                try {
                    b4.close();
                } catch (Exception e5) {
                    al.a(e5);
                }
                return null;
            } finally {
                try {
                    b4.close();
                } catch (Exception e6) {
                    al.a(e6);
                }
            }
        }
    }

    private static String c(String str, String str2) {
        BufferedReader b4 = ap.b(str, "map_record.txt");
        if (b4 == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = b4.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = b4.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(readLine2);
                    sb.append("\n");
                }
                return sb.toString();
            }
            try {
                b4.close();
            } catch (Exception e4) {
                al.a(e4);
            }
            return null;
        } catch (Throwable th) {
            try {
                al.a(th);
                try {
                    b4.close();
                } catch (Exception e5) {
                    al.a(e5);
                }
                return null;
            } finally {
                try {
                    b4.close();
                } catch (Exception e6) {
                    al.a(e6);
                }
            }
        }
    }

    private static Map<String, Integer> d(String str) {
        String[] split;
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split2 = str2.split(":");
                if (split2.length != 2) {
                    al.e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e4) {
            al.e("error format intStateStr %s", str);
            e4.printStackTrace();
            return null;
        }
    }

    private static <KeyT, ValueT> ValueT a(Map<KeyT, ValueT> map, KeyT keyt, ValueT valuet) {
        ValueT valuet2;
        try {
            valuet2 = map.get(keyt);
        } catch (Exception e4) {
            al.a(e4);
        }
        return valuet2 != null ? valuet2 : valuet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.io.BufferedInputStream r4) throws java.io.IOException {
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
            com.tencent.bugly.proguard.al.a(r4)     // Catch: java.lang.Throwable -> L31
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.be.a(java.io.BufferedInputStream):java.lang.String");
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String a4;
        BufferedInputStream bufferedInputStream2 = null;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                ?? canRead = file.canRead();
                try {
                    if (canRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        } catch (IOException e4) {
                            e = e4;
                            bufferedInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            String a5 = a(bufferedInputStream);
                            if (a5 != null && a5.equals("NATIVE_RQD_REPORT")) {
                                HashMap hashMap = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        a4 = a(bufferedInputStream);
                                        if (a4 == null) {
                                            break loop0;
                                        } else if (str2 == null) {
                                            str2 = a4;
                                        }
                                    }
                                    hashMap.put(str2, a4);
                                }
                                if (str2 != null) {
                                    al.e("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean a6 = a(context, hashMap, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                                return a6;
                            }
                            al.e("record read fail! %s", a5);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                            return null;
                        } catch (IOException e9) {
                            e = e9;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
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
        al.e("get eup record file args error", new Object[0]);
        return null;
    }

    public static void c(String str) {
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
                        al.c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            al.a(th);
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    private static long b(Map<String, String> map) {
        String str = map.get("launchTime");
        if (str != null) {
            al.c("[Native record info] launchTime: %s", str);
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e4) {
                if (al.a(e4)) {
                    return -1L;
                }
                e4.printStackTrace();
                return -1L;
            }
        }
        return -1L;
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String b4 = b(str, str2);
        if (b4 != null && !b4.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(b4);
        }
        String c4 = c(str, str2);
        if (c4 != null && !c4.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(c4);
        }
        return sb.toString();
    }

    public static void a(boolean z3, String str) {
        if (str != null) {
            f51093a.add(new File(str, "rqd_record.eup"));
            f51093a.add(new File(str, "reg_record.txt"));
            f51093a.add(new File(str, "map_record.txt"));
            f51093a.add(new File(str, "backup_record.txt"));
            if (z3) {
                c(str);
            }
        }
        List<File> list = f51093a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f51093a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                al.c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    public static String a(String str, int i4, String str2, boolean z3) {
        BufferedReader bufferedReader = null;
        if (str != null && i4 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                al.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f51093a.add(file);
                al.c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return ap.a(new File(str), i4, z3);
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
                                    sb.append("\n");
                                }
                                if (i4 > 0 && sb.length() > i4) {
                                    if (z3) {
                                        sb.delete(i4, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i4);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    al.a(th);
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
                                        } catch (Exception e4) {
                                            al.a(e4);
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
                } catch (Exception e5) {
                    al.a(e5);
                    return sb;
                }
            }
        }
        return null;
    }

    private static Map<String, String> a(Map<String, String> map) {
        String str = map.get("key-value");
        if (str != null) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split("\n")) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tencent.bugly.crashreport.crash.CrashDetailBean a(android.content.Context r25, java.util.Map<java.lang.String, java.lang.String> r26, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler r27) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.be.a(android.content.Context, java.util.Map, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }
}
