package com.ss.android.socialbase.appdownloader.f.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux {
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
    public static android.content.pm.PackageInfo c(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.c.ux.c(java.io.File):android.content.pm.PackageInfo");
    }

    private static String c(int i4) {
        return (i4 >>> 24) == 1 ? "android:" : "";
    }

    private static PackageInfo w(@NonNull Context context, @NonNull File file, int i4) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            c("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i4);
        } catch (Throwable th) {
            c("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    public static PackageInfo c(@NonNull Context context, @NonNull File file, int i4) {
        int i5;
        if (com.ss.android.socialbase.downloader.gd.c.c(268435456) && (i5 = Build.VERSION.SDK_INT) >= 21 && i5 < 26) {
            try {
                return c(file);
            } catch (Throwable th) {
                c("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                return w(context, file, i4);
            }
        }
        return w(context, file, i4);
    }

    private static void c(@NonNull String str, @NonNull String str2) {
        com.ss.android.socialbase.downloader.sr.w r3 = com.ss.android.socialbase.downloader.downloader.xv.r();
        if (r3 == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException unused) {
        }
        r3.c(str, jSONObject, null, null);
    }

    private static String c(c cVar, int i4) {
        int w3 = cVar.w(i4);
        int xv = cVar.xv(i4);
        if (w3 == 3) {
            return cVar.sr(i4);
        }
        return w3 == 2 ? String.format("?%s%08X", c(xv), Integer.valueOf(xv)) : (w3 < 16 || w3 > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(xv), Integer.valueOf(w3)) : String.valueOf(xv);
    }

    public static String c(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e4) {
            c("getPackageInfo::fail_load_label", e4.getMessage());
            return null;
        }
    }
}
