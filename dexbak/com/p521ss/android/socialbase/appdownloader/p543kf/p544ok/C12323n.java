package com.p521ss.android.socialbase.appdownloader.p543kf.p544ok;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import com.p521ss.android.socialbase.downloader.p557s.InterfaceC12721a;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.kf.ok.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12323n {
    /* renamed from: a */
    private static PackageInfo m18209a(@NonNull Context context, @NonNull File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            m18203ok("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            m18203ok("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
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
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.PackageInfo m18204ok(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.appdownloader.p543kf.p544ok.C12323n.m18204ok(java.io.File):android.content.pm.PackageInfo");
    }

    /* renamed from: ok */
    private static String m18208ok(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    /* renamed from: ok */
    public static PackageInfo m18206ok(@NonNull Context context, @NonNull File file, int i) {
        int i2;
        if (C12717ok.m16510ok(268435456) && (i2 = Build.VERSION.SDK_INT) >= 21 && i2 < 26) {
            try {
                return m18204ok(file);
            } catch (Throwable th) {
                m18203ok("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                return m18209a(context, file, i);
            }
        }
        return m18209a(context, file, i);
    }

    /* renamed from: ok */
    private static void m18203ok(@NonNull String str, @NonNull String str2) {
        InterfaceC12721a m17816h = C12490bl.m17816h();
        if (m17816h == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException unused) {
        }
        m17816h.m16496ok(str, jSONObject, null, null);
    }

    /* renamed from: ok */
    private static String m18205ok(C12324ok c12324ok, int i) {
        int m18201a = c12324ok.m18201a(i);
        int m18199bl = c12324ok.m18199bl(i);
        if (m18201a == 3) {
            return c12324ok.m18189s(i);
        }
        return m18201a == 2 ? String.format("?%s%08X", m18208ok(m18199bl), Integer.valueOf(m18199bl)) : (m18201a < 16 || m18201a > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(m18199bl), Integer.valueOf(m18201a)) : String.valueOf(m18199bl);
    }

    /* renamed from: ok */
    public static String m18207ok(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            m18203ok("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }
}
