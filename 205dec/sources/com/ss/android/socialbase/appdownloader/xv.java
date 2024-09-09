package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static int f49258c;

    /* renamed from: w  reason: collision with root package name */
    private static NotificationChannel f49259w;

    /* JADX INFO: Access modifiers changed from: private */
    public static int sr(Context context, int i4, boolean z3) {
        if (com.ss.android.socialbase.downloader.r.c.c(i4).w("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.w.c().f(i4);
        }
        c((Activity) ev.c().w());
        if (com.ss.android.socialbase.downloader.r.c.c(i4).c("install_queue_enable", 0) == 1) {
            return ev.c().c(context, i4, z3);
        }
        return w(context, i4, z3);
    }

    private static String c(long j4, long j5, String str, boolean z3) {
        double d4 = j4;
        if (j5 > 1) {
            double d5 = j5;
            Double.isNaN(d4);
            Double.isNaN(d5);
            d4 /= d5;
        }
        if (!z3 && !"GB".equals(str) && !"TB".equals(str)) {
            return new DecimalFormat("#").format(d4) + " " + str;
        }
        return new DecimalFormat("#.##").format(d4) + " " + str;
    }

    public static String w(long j4) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j4 < 1) {
            return "0 " + strArr[4];
        }
        for (int i4 = 0; i4 < 5; i4++) {
            long j5 = jArr[i4];
            if (j4 >= j5) {
                return c(j4, j5, strArr[i4]);
            }
        }
        return null;
    }

    public static boolean xv(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return w(context, downloadInfo, c(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static boolean xv(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    public static String c(long j4) {
        return c(j4, true);
    }

    public static int w(final Context context, final int i4, final boolean z3) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i4);
        if (downloadInfo != null && "application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.xv.w(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.xv.2
                    @Override // java.lang.Runnable
                    public void run() {
                        sr.p().k();
                        int c4 = xv.c(context, i4, z3, downloadInfo, file);
                        if (c4 == 1 && sr.p().ia() != null) {
                            sr.p().ia().c(downloadInfo, null);
                        }
                        xv.w(downloadInfo, z3, c4);
                    }
                });
                return 1;
            }
        }
        w(downloadInfo, z3, 2);
        return 2;
    }

    public static List<String> xv() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static String c(long j4, boolean z3) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j4 < 1) {
            return "0 " + strArr[4];
        }
        for (int i4 = 0; i4 < 5; i4++) {
            long j5 = jArr[i4];
            if (j4 >= j5) {
                return c(j4, j5, strArr[i4], z3);
            }
        }
        return null;
    }

    private static JSONObject sr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String c(long j4, long j5, String str) {
        double d4 = j4;
        if (j5 > 1) {
            double d5 = j5;
            Double.isNaN(d4);
            Double.isNaN(d5);
            d4 /= d5;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d4) + str;
        }
        return new DecimalFormat("#.##").format(d4) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(DownloadInfo downloadInfo, boolean z3, int i4) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z3 ? 1 : 2);
            jSONObject.put("view_result", i4);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.xv.up().c(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    public static int c(final Context context, final int i4, final boolean z3) {
        com.ss.android.socialbase.appdownloader.xv.p r3 = sr.p().r();
        if (r3 == null) {
            return sr(context, i4, z3);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i4);
        f49258c = 1;
        r3.c(downloadInfo, new com.ss.android.socialbase.appdownloader.xv.gd() { // from class: com.ss.android.socialbase.appdownloader.xv.1
            @Override // com.ss.android.socialbase.appdownloader.xv.gd
            public void c() {
                int unused = xv.f49258c = xv.sr(context, i4, z3);
            }
        });
        return f49258c;
    }

    public static boolean w(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return c(context, downloadInfo, packageInfo, false);
    }

    public static int w(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo c4 = c(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (c4 != null) {
                    int i4 = c4.versionCode;
                    downloadInfo.setAppVersionCode(i4);
                    return i4;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static int c(Context context, int i4, boolean z3, DownloadInfo downloadInfo, File file) {
        PackageInfo packageInfo;
        Intent c4;
        Process process;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
            } catch (Throwable th) {
                th = th;
                process = null;
            }
            try {
                process.waitFor();
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                } finally {
                    if (process != null) {
                        process.destroy();
                    }
                }
            }
        }
        try {
            packageInfo = c(downloadInfo, file);
            if (packageInfo != null) {
                try {
                    downloadInfo.setFilePackageName(packageInfo.packageName);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            th = null;
        } catch (Throwable th4) {
            th = th4;
            packageInfo = null;
        }
        if (sr.p().xv() != null) {
            if (packageInfo == null) {
                BaseException baseException = new BaseException(2001, th);
                sr.p().xv().c(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                sr.p().xv().c(downloadInfo, null, 11);
            }
        }
        if (c(context, downloadInfo, packageInfo)) {
            return 2;
        }
        if (packageInfo != null && com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfo.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (w(context, downloadInfo, packageInfo)) {
            c4 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
        } else if (!z3 && c(context, i4, file)) {
            downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
            return 1;
        } else {
            c4 = c(context, downloadInfo, file, z3, iArr);
        }
        if (c4 == null) {
            return iArr[0] == 1 ? 2 : 0;
        }
        c4.addFlags(268435456);
        if (downloadInfo.getLinkMode() > 0 && com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("app_install_return_result", 0) == 1) {
            c4.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && w.c(context, downloadInfo, c4, z3)) {
            return 1;
        }
        return c(context, c4);
    }

    public static String w() {
        return com.ss.android.socialbase.downloader.gd.f.ux();
    }

    public static boolean w(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(26)
    public static String w(@NonNull Context context) {
        try {
            if (f49259w == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                f49259w = notificationChannel;
                notificationChannel.setSound(null, null);
                f49259w.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(f49259w);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    public static int c(Context context, Intent intent) {
        try {
            if (sr.p().fp() != null) {
                if (sr.p().fp().c(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean c(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.xv.sr w3 = sr.p().w();
        if (w3 != null) {
            w3.c(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (w3.c()) {
                return true;
            }
        }
        com.ss.android.socialbase.downloader.depend.n downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.c(8, downloadInfo, packageInfo.packageName, "");
            com.ss.android.socialbase.appdownloader.xv.xv c4 = sr.p().c();
            return (c4 instanceof com.ss.android.socialbase.appdownloader.xv.c) && ((com.ss.android.socialbase.appdownloader.xv.c) c4).xv();
        }
        return false;
    }

    public static boolean c(Context context, int i4, File file) {
        if (com.ss.android.socialbase.downloader.r.c.c(i4).c("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.f.ux.bk() || com.ss.android.socialbase.appdownloader.f.ux.t()) && com.ss.android.socialbase.downloader.gd.p.c(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    public static int c() {
        return sr.p().f() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri c(int r1, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.getUriForFile(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.sr r2 = com.ss.android.socialbase.appdownloader.sr.p()
            com.ss.android.socialbase.appdownloader.xv.f r2 = r2.ux()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.c(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L37
            r0 = 24
            if (r2 < r0) goto L32
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L32
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L32:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.xv.c(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    private static Intent c(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z3, int[] iArr) {
        Uri c4 = c(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, sr.p().sr(), file);
        if (c4 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(c4, "application/vnd.android.package-archive");
        com.ss.android.socialbase.appdownloader.xv.sr w3 = sr.p().w();
        boolean c5 = w3 != null ? w3.c(downloadInfo.getId(), z3) : 0;
        com.ss.android.socialbase.downloader.depend.n downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        int i4 = c5;
        if (downloadNotificationEventListener != null) {
            i4 = downloadNotificationEventListener.c(z3);
        }
        iArr[0] = i4;
        if (i4 != 0) {
            return null;
        }
        return intent;
    }

    public static boolean c(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && c(com.ss.android.socialbase.downloader.downloader.xv.gw(), downloadInfo, str);
        }
        return true;
    }

    public static boolean c(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize\uff1a" + file.length() + " fileUrl\uff1a" + downloadInfo.getUrl());
                PackageInfo c4 = c(downloadInfo, file);
                if (c4 == null || !c4.packageName.equals(str)) {
                    return false;
                }
                int i4 = c4.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, c());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i4 != packageInfo.versionCode) {
                    return false;
                }
            } else if (!com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("install_callback_error")) {
                return false;
            } else {
                String c5 = com.ss.android.socialbase.downloader.gd.f.c(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int c6 = com.ss.android.socialbase.downloader.gd.f.c(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (c5 == null || TextUtils.isEmpty(c5) || !c5.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, c());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || c6 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean c(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z3) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i4 = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i4);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, c());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i5 = packageInfo2.versionCode;
        return z3 ? i4 < i5 : (downloadInfo == null || com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("install_with_same_version_code", 0) != 1) ? i4 <= i5 : i4 < i5;
    }

    public static boolean c(Context context, DownloadInfo downloadInfo) {
        return c(context, downloadInfo, true);
    }

    public static boolean c(Context context, DownloadInfo downloadInfo, boolean z3) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z3) {
            return xv(context, downloadInfo);
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, c());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        return com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo c(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            Log.e("AppDownloadUtils", "isApkInstalled apkFileSize\uff1afileName:" + file.getPath() + " apkFileSize" + file.length());
            return c(downloadInfo, file);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r0 = "default.apk"
            java.lang.String r2 = ".."
            if (r6 == 0) goto L34
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L5a
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = r4.contains(r2)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            goto L5a
        L32:
            r4 = r0
            goto L5a
        L34:
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L4c
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L4c
            java.lang.String r1 = r3.getLastPathSegment()
        L4c:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L59
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L32
            goto L5a
        L59:
            r4 = r1
        L5a:
            boolean r3 = xv(r5)
            if (r3 == 0) goto L77
            java.lang.String r3 = ".apk"
            boolean r5 = r4.endsWith(r3)
            if (r5 != 0) goto L77
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            java.lang.String r4 = r5.toString()
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.xv.c(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String c(String str, com.ss.android.socialbase.downloader.r.c cVar) {
        JSONObject sr;
        String format;
        if (cVar == null || (sr = cVar.sr("download_dir")) == null) {
            return "";
        }
        String optString = sr.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith(TTPathConst.sSeparator)) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int c(int i4) {
        if (i4 == 0) {
            return 0;
        }
        if (i4 == -2) {
            return 2;
        }
        if (i4 == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i4) || i4 == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i4) ? 3 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r0 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.content.Context r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 20
            if (r0 <= r2) goto L40
            if (r6 != 0) goto La
            goto L40
        La:
            r0 = 0
            int r2 = com.ss.android.socialbase.appdownloader.ux.w()     // Catch: java.lang.Throwable -> L3d
            android.content.res.Resources r3 = r6.getResources()     // Catch: java.lang.Throwable -> L3d
            int r2 = r3.getColor(r2)     // Catch: java.lang.Throwable -> L3d
            int r3 = com.ss.android.socialbase.appdownloader.ux.xv()     // Catch: java.lang.Throwable -> L3d
            int r4 = com.ss.android.socialbase.appdownloader.ux.sr()     // Catch: java.lang.Throwable -> L3d
            r5 = 2
            int[] r5 = new int[r5]     // Catch: java.lang.Throwable -> L3d
            r5[r1] = r3     // Catch: java.lang.Throwable -> L3d
            r3 = 1
            r5[r3] = r4     // Catch: java.lang.Throwable -> L3d
            int r4 = com.ss.android.socialbase.appdownloader.ux.ux()     // Catch: java.lang.Throwable -> L3d
            android.content.res.TypedArray r0 = r6.obtainStyledAttributes(r4, r5)     // Catch: java.lang.Throwable -> L3d
            int r6 = r0.getColor(r1, r1)     // Catch: java.lang.Throwable -> L3d
            if (r2 != r6) goto L39
            r0.recycle()     // Catch: java.lang.Throwable -> L38
        L38:
            return r3
        L39:
            r0.recycle()     // Catch: java.lang.Throwable -> L40
            goto L40
        L3d:
            if (r0 == 0) goto L40
            goto L39
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.xv.c(android.content.Context):boolean");
    }

    public static void c(DownloadInfo downloadInfo, boolean z3, boolean z4) {
        sr.p().c(new f(com.ss.android.socialbase.downloader.downloader.xv.gw(), downloadInfo.getUrl()).c(downloadInfo.getTitle()).w(downloadInfo.getName()).xv(downloadInfo.getSavePath()).c(downloadInfo.isShowNotification()).w(downloadInfo.isAutoInstallWithoutNotification()).xv(downloadInfo.isOnlyWifi() || z4).ux(downloadInfo.getExtra()).f(downloadInfo.getMimeType()).c((List<com.ss.android.socialbase.downloader.model.xv>) downloadInfo.getExtraHeaders()).ux(true).w(downloadInfo.getRetryCount()).xv(downloadInfo.getBackUpUrlRetryCount()).w(downloadInfo.getBackUpUrls()).sr(downloadInfo.getMinProgressTimeMsInterval()).ux(downloadInfo.getMaxProgressCount()).f(z3).sr(downloadInfo.isNeedHttpsToHttpRetry()).r(downloadInfo.getPackageName()).ev(downloadInfo.getMd5()).c(downloadInfo.getExpectFileLength()).gd(downloadInfo.isNeedDefaultHttpServiceBackUp()).p(downloadInfo.isNeedReuseFirstConnection()).a(downloadInfo.isNeedIndependentProcess()).c(downloadInfo.getEnqueueType()).t(downloadInfo.isForce()).bk(downloadInfo.isHeadConnectionAvailable()).r(downloadInfo.isNeedRetryDelay()).gd(downloadInfo.getRetryDelayTimeArray()).c(sr(downloadInfo.getDownloadSettingString())).k(downloadInfo.getIconUrl()).f(downloadInfo.getExecutorGroup()).fp(downloadInfo.isAutoInstall()));
    }

    public static void c(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static PackageInfo c(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.f.c.ux.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), file, c());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo == null) {
            PackageInfo c4 = com.ss.android.socialbase.appdownloader.f.c.ux.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), file, c());
            downloadInfo.setPackageInfo(c4);
            return c4;
        }
        return packageInfo;
    }

    public static int c(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}