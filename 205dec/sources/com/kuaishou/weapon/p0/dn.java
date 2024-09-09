package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class dn {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    public static void b(String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
        }
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        c(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static boolean a(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    public static boolean a(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || !a(str)) {
            return false;
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("chmod " + str2 + " " + str + "\n").waitFor();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(String str, Boolean bool) {
        if (bool.booleanValue()) {
            a("771", new File(str).getParentFile().getAbsolutePath());
        }
    }

    public static boolean b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                for (int i4 = 0; i4 < split.length && i4 < split2.length; i4++) {
                    int intValue = Integer.valueOf(split[i4]).intValue() - Integer.valueOf(split2[i4]).intValue();
                    if (intValue != 0) {
                        return intValue > 0;
                    }
                }
                if (split.length > split2.length) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
