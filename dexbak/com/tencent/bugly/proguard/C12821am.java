package com.tencent.bugly.proguard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.am */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12821am {
    /* renamed from: a */
    public static boolean m15871a(File file, String str, long j, boolean z) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, z));
            boolean m15870a = m15870a(bufferedWriter, str.toCharArray(), str.length(), file.length(), j);
            bufferedWriter.close();
            return m15870a;
        } catch (Throwable th) {
            C12820al.m15877a(th);
            return false;
        }
    }

    /* renamed from: b */
    private static List<File> m15865b(String str, final String str2, final String str3, long j) {
        ArrayList arrayList = new ArrayList();
        if (str2 != null && str3 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                try {
                    File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.tencent.bugly.proguard.am.1
                        @Override // java.io.FilenameFilter
                        public final boolean accept(File file2, String str4) {
                            return str4 != null && str4.startsWith(str2) && str4.endsWith(str3);
                        }
                    });
                    if (listFiles != null && listFiles.length != 0) {
                        return m15866a(listFiles, str2, str3, currentTimeMillis - j);
                    }
                    return arrayList;
                } catch (Throwable th) {
                    C12820al.m15877a(th);
                    return arrayList;
                }
            }
            return arrayList;
        }
        C12820al.m15873d("prefix %s and/or postfix %s is null.", str2, str3);
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m15870a(Writer writer, char[] cArr, int i, long j, long j2) {
        if (j >= j2) {
            return false;
        }
        try {
            if ((i * 2) + j <= j2) {
                writer.write(cArr, 0, i);
            } else {
                writer.write(cArr, 0, (int) ((j2 - j) / 2));
            }
            writer.flush();
            return true;
        } catch (IOException e) {
            C12820al.m15877a(e);
            return false;
        }
    }

    /* renamed from: a */
    public static void m15867a(String str, String str2, String str3, long j) {
        try {
            int i = 0;
            for (File file : m15865b(str, str2, str3, j)) {
                C12820al.m15874c("File %s is to be deleted.", file.getName());
                if (file.delete()) {
                    i++;
                }
            }
            C12820al.m15874c("Number of overdue trace files that has deleted: ".concat(String.valueOf(i)), new Object[0]);
        } catch (Throwable th) {
            C12820al.m15877a(th);
        }
    }

    /* renamed from: a */
    private static List<File> m15866a(File[] fileArr, String str, String str2, long j) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            long m15868a = m15868a(file.getName(), str, str2);
            if (m15868a >= 0 && 0 <= m15868a && m15868a <= j) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static long m15868a(String str, String str2, String str3) {
        if (str == null) {
            C12820al.m15873d("File name is null.", new Object[0]);
            return -1L;
        }
        try {
            if (str.startsWith(str2) && str.endsWith(str3)) {
                return Long.parseLong(str.substring(str2.length(), str.indexOf(str3)));
            }
        } catch (Throwable th) {
            C12820al.m15877a(th);
        }
        return -1L;
    }

    /* renamed from: a */
    public static boolean m15869a(String str, String str2, int i) {
        boolean z = true;
        C12820al.m15874c("rqdp{  sv sd start} %s", str);
        if (str2 != null && str2.trim().length() > 0) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    if (file.getParentFile() != null) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                long j = i;
                if (file.length() >= j) {
                    z = false;
                }
                return m15871a(file, str2, j, z);
            } catch (Throwable th) {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }
}
