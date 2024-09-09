package com.ss.android.socialbase.appdownloader.kf.ok;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n {
    private static PackageInfo a(@NonNull Context context, @NonNull File file, int i4) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            ok("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i4);
        } catch (Throwable th) {
            ok("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.PackageInfo ok(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.kf.ok.n.ok(java.io.File):android.content.pm.PackageInfo");
    }

    private static String ok(int i4) {
        return (i4 >>> 24) == 1 ? "android:" : "";
    }

    public static PackageInfo ok(@NonNull Context context, @NonNull File file, int i4) {
        int i5;
        if (com.ss.android.socialbase.downloader.q.ok.ok(268435456) && (i5 = Build.VERSION.SDK_INT) >= 21 && i5 < 26) {
            try {
                return ok(file);
            } catch (Throwable th) {
                ok("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                return a(context, file, i4);
            }
        }
        return a(context, file, i4);
    }

    private static void ok(@NonNull String str, @NonNull String str2) {
        com.ss.android.socialbase.downloader.s.a h4 = com.ss.android.socialbase.downloader.downloader.bl.h();
        if (h4 == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException unused) {
        }
        h4.ok(str, jSONObject, null, null);
    }

    private static String ok(ok okVar, int i4) {
        int a4 = okVar.a(i4);
        int bl = okVar.bl(i4);
        if (a4 == 3) {
            return okVar.s(i4);
        }
        return a4 == 2 ? String.format("?%s%08X", ok(bl), Integer.valueOf(bl)) : (a4 < 16 || a4 > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(bl), Integer.valueOf(a4)) : String.valueOf(bl);
    }

    public static String ok(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e4) {
            ok("getPackageInfo::fail_load_label", e4.getMessage());
            return null;
        }
    }
}
