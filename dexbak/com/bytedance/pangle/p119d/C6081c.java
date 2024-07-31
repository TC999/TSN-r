package com.bytedance.pangle.p119d;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.C6158h;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.p120e.C6096b;
import com.bytedance.pangle.util.C6253i;
import java.io.File;

/* renamed from: com.bytedance.pangle.d.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6081c {

    /* renamed from: a */
    private static File f21917a;

    /* renamed from: b */
    private static File f21918b;

    /* renamed from: c */
    private static File f21919c;

    /* renamed from: a */
    private static String m37233a(File file) {
        if (file != null) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
        return null;
    }

    /* renamed from: b */
    public static String m37229b() {
        Application appApplication = Zeus.getAppApplication();
        if (f21919c == null) {
            File filesDir = appApplication.getFilesDir();
            f21919c = new File(filesDir, ".pangle" + C6158h.f22052a);
        }
        return m37233a(f21919c);
    }

    /* renamed from: c */
    public static String m37227c() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + C6158h.f22053b);
                if (externalFilesDir != null) {
                    return m37233a(externalFilesDir);
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    private static void m37225d() {
        if (f21917a == null) {
            File filesDir = Zeus.getAppApplication().getFilesDir();
            File file = new File(filesDir, "pangle" + C6158h.f22054c);
            f21917a = file;
            m37233a(file);
        }
    }

    /* renamed from: e */
    public static String m37223e(String str, int i) {
        return new File(m37230a(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    /* renamed from: f */
    public static String m37222f(String str, int i) {
        return new File(m37230a(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    /* renamed from: g */
    public static String m37221g(String str, int i) {
        return new File(m37230a(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    /* renamed from: h */
    public static String m37220h(String str, int i) {
        return C6253i.m36879i() ? m37230a(str, "version-".concat(String.valueOf(i)), "apk", "temp", "oat", C6096b.m37199a()) : m37230a(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    /* renamed from: i */
    public static String m37219i(String str, int i) {
        return m37230a(str, "version-".concat(String.valueOf(i)), "secondary-dexes");
    }

    /* renamed from: a */
    private static String m37230a(String... strArr) {
        m37225d();
        File file = f21917a;
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return m37233a(file);
    }

    /* renamed from: d */
    public static String m37224d(String str, int i) {
        return m37230a(str, "version-".concat(String.valueOf(i)), "lib");
    }

    /* renamed from: b */
    public static String m37228b(String str, int i) {
        return new File(m37230a(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    /* renamed from: c */
    public static String m37226c(String str, int i) {
        return C6253i.m36879i() ? m37230a(str, "version-".concat(String.valueOf(i)), "apk", "oat", C6096b.m37199a()) : m37230a(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    /* renamed from: a */
    public static String m37234a() {
        Application appApplication = Zeus.getAppApplication();
        if (f21918b == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                File filesDir = appApplication.getFilesDir();
                downloadDir = new File(filesDir, ".pangle" + C6158h.f22053b);
            }
            f21918b = downloadDir;
        }
        return m37233a(f21918b);
    }

    /* renamed from: a */
    public static String m37231a(String str, int i) {
        m37225d();
        File file = f21917a;
        String[] strArr = {str, "version-".concat(String.valueOf(i))};
        for (int i2 = 0; i2 < 2; i2++) {
            String str2 = strArr[i2];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    /* renamed from: a */
    public static String m37232a(String str) {
        return m37230a(str);
    }
}
