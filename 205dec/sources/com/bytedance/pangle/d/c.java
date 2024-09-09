package com.bytedance.pangle.d;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.h;
import com.bytedance.pangle.util.i;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static File f28678a;

    /* renamed from: b  reason: collision with root package name */
    private static File f28679b;

    /* renamed from: c  reason: collision with root package name */
    private static File f28680c;

    private static String a(File file) {
        if (file != null) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
        return null;
    }

    public static String b() {
        Application appApplication = Zeus.getAppApplication();
        if (f28680c == null) {
            File filesDir = appApplication.getFilesDir();
            f28680c = new File(filesDir, ".pangle" + h.f28813a);
        }
        return a(f28680c);
    }

    public static String c() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + h.f28814b);
                if (externalFilesDir != null) {
                    return a(externalFilesDir);
                }
                return null;
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static void d() {
        if (f28678a == null) {
            File filesDir = Zeus.getAppApplication().getFilesDir();
            File file = new File(filesDir, "pangle" + h.f28815c);
            f28678a = file;
            a(file);
        }
    }

    public static String e(String str, int i4) {
        return new File(a(str, "version-".concat(String.valueOf(i4)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String f(String str, int i4) {
        return new File(a(str, "version-".concat(String.valueOf(i4)), "apk")).getPath();
    }

    public static String g(String str, int i4) {
        return new File(a(str, "version-".concat(String.valueOf(i4)), "apk", "temp")).getPath();
    }

    public static String h(String str, int i4) {
        return i.i() ? a(str, "version-".concat(String.valueOf(i4)), "apk", "temp", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i4)), "dalvik-cache");
    }

    public static String i(String str, int i4) {
        return a(str, "version-".concat(String.valueOf(i4)), "secondary-dexes");
    }

    private static String a(String... strArr) {
        d();
        File file = f28678a;
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return a(file);
    }

    public static String d(String str, int i4) {
        return a(str, "version-".concat(String.valueOf(i4)), "lib");
    }

    public static String b(String str, int i4) {
        return new File(a(str, "version-".concat(String.valueOf(i4)), "apk"), "base-1.apk").getPath();
    }

    public static String c(String str, int i4) {
        return i.i() ? a(str, "version-".concat(String.valueOf(i4)), "apk", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i4)), "dalvik-cache");
    }

    public static String a() {
        Application appApplication = Zeus.getAppApplication();
        if (f28679b == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                File filesDir = appApplication.getFilesDir();
                downloadDir = new File(filesDir, ".pangle" + h.f28814b);
            }
            f28679b = downloadDir;
        }
        return a(f28679b);
    }

    public static String a(String str, int i4) {
        d();
        File file = f28678a;
        String[] strArr = {str, "version-".concat(String.valueOf(i4))};
        for (int i5 = 0; i5 < 2; i5++) {
            String str2 = strArr[i5];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String a(String str) {
        return a(str);
    }
}
