package com.kuaishou.weapon.p205p0;

import android.text.TextUtils;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.File;

/* renamed from: com.kuaishou.weapon.p0.dn */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7271dn {
    /* renamed from: a */
    public static boolean m33938a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m33939a(new File(str));
    }

    /* renamed from: b */
    public static void m33935b(String str) {
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

    /* renamed from: c */
    public static void m33933c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        m33933c(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    /* renamed from: a */
    public static boolean m33939a(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    /* renamed from: a */
    public static boolean m33936a(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || !m33938a(str)) {
            return false;
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("chmod " + str2 + " " + str + ShellAdbUtils.f33810d).waitFor();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m33937a(String str, Boolean bool) {
        if (bool.booleanValue()) {
            m33936a("771", new File(str).getParentFile().getAbsolutePath());
        }
    }

    /* renamed from: b */
    public static boolean m33934b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                for (int i = 0; i < split.length && i < split2.length; i++) {
                    int intValue = Integer.valueOf(split[i]).intValue() - Integer.valueOf(split2[i]).intValue();
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
