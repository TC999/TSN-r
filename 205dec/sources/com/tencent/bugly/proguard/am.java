package com.tencent.bugly.proguard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class am {
    public static boolean a(File file, String str, long j4, boolean z3) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, z3));
            boolean a4 = a(bufferedWriter, str.toCharArray(), str.length(), file.length(), j4);
            bufferedWriter.close();
            return a4;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    private static List<File> b(String str, final String str2, final String str3, long j4) {
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
                        return a(listFiles, str2, str3, currentTimeMillis - j4);
                    }
                    return arrayList;
                } catch (Throwable th) {
                    al.a(th);
                    return arrayList;
                }
            }
            return arrayList;
        }
        al.d("prefix %s and/or postfix %s is null.", str2, str3);
        return arrayList;
    }

    private static boolean a(Writer writer, char[] cArr, int i4, long j4, long j5) {
        if (j4 >= j5) {
            return false;
        }
        try {
            if ((i4 * 2) + j4 <= j5) {
                writer.write(cArr, 0, i4);
            } else {
                writer.write(cArr, 0, (int) ((j5 - j4) / 2));
            }
            writer.flush();
            return true;
        } catch (IOException e4) {
            al.a(e4);
            return false;
        }
    }

    public static void a(String str, String str2, String str3, long j4) {
        try {
            int i4 = 0;
            for (File file : b(str, str2, str3, j4)) {
                al.c("File %s is to be deleted.", file.getName());
                if (file.delete()) {
                    i4++;
                }
            }
            al.c("Number of overdue trace files that has deleted: ".concat(String.valueOf(i4)), new Object[0]);
        } catch (Throwable th) {
            al.a(th);
        }
    }

    private static List<File> a(File[] fileArr, String str, String str2, long j4) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            long a4 = a(file.getName(), str, str2);
            if (a4 >= 0 && 0 <= a4 && a4 <= j4) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public static long a(String str, String str2, String str3) {
        if (str == null) {
            al.d("File name is null.", new Object[0]);
            return -1L;
        }
        try {
            if (str.startsWith(str2) && str.endsWith(str3)) {
                return Long.parseLong(str.substring(str2.length(), str.indexOf(str3)));
            }
        } catch (Throwable th) {
            al.a(th);
        }
        return -1L;
    }

    public static boolean a(String str, String str2, int i4) {
        boolean z3 = true;
        al.c("rqdp{  sv sd start} %s", str);
        if (str2 != null && str2.trim().length() > 0) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    if (file.getParentFile() != null) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                long j4 = i4;
                if (file.length() >= j4) {
                    z3 = false;
                }
                return a(file, str2, j4, z3);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }
}
