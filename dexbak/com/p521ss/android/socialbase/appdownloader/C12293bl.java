package com.p521ss.android.socialbase.appdownloader;

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
import com.p521ss.android.socialbase.appdownloader.p542bl.C12303ok;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12297bl;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12300k;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12305q;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import com.p521ss.android.socialbase.appdownloader.p543kf.p544ok.C12323n;
import com.p521ss.android.socialbase.downloader.constants.DownloadStatus;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12712k;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.ss.android.socialbase.appdownloader.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12293bl {

    /* renamed from: a */
    private static NotificationChannel f34657a;

    /* renamed from: ok */
    private static int f34658ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static int m18405s(Context context, int i, boolean z) {
        if (C12534ok.m17599ok(i).m17607a("notification_opt_2") == 1) {
            C12644a.m16876ok().m16878kf(i);
        }
        m18426ok((Activity) C12354p.m18098ok().m18104a());
        if (C12534ok.m17599ok(i).m17593ok("install_queue_enable", 0) == 1) {
            return C12354p.m18098ok().m18097ok(context, i, z);
        }
        return m18442a(context, i, z);
    }

    /* renamed from: a */
    public static String m18444a(long j) {
        long[] jArr = {1099511627776L, IjkMediaMeta.AV_CH_STEREO_RIGHT, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return m18429ok(j, j2, strArr[i]);
            }
        }
        return null;
    }

    /* renamed from: bl */
    public static boolean m18435bl(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return m18440a(context, downloadInfo, m18414ok(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    /* renamed from: ok */
    private static String m18428ok(long j, long j2, String str, boolean z) {
        double d = j;
        if (j2 > 1) {
            double d2 = j2;
            Double.isNaN(d);
            Double.isNaN(d2);
            d /= d2;
        }
        if (!z && !"GB".equals(str) && !"TB".equals(str)) {
            return new DecimalFormat("#").format(d) + " " + str;
        }
        return new DecimalFormat("#.##").format(d) + " " + str;
    }

    /* renamed from: bl */
    public static boolean m18434bl(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    /* renamed from: a */
    public static int m18442a(final Context context, final int i, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && "application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                C12490bl.m17836a(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.bl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C12361s.m18068k().m18043r();
                        int m18421ok = C12293bl.m18421ok(context, i, z, downloadInfo, file);
                        if (m18421ok == 1 && C12361s.m18068k().m18037x() != null) {
                            C12361s.m18068k().m18037x().mo17880ok(downloadInfo, null);
                        }
                        C12293bl.m18439a(downloadInfo, z, m18421ok);
                    }
                });
                return 1;
            }
        }
        m18439a(downloadInfo, z, 2);
        return 2;
    }

    /* renamed from: bl */
    public static List<String> m18437bl() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    /* renamed from: ok */
    public static String m18430ok(long j) {
        return m18427ok(j, true);
    }

    /* renamed from: ok */
    public static String m18427ok(long j, boolean z) {
        long[] jArr = {1099511627776L, IjkMediaMeta.AV_CH_STEREO_RIGHT, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return m18428ok(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    /* renamed from: s */
    private static JSONObject m18404s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: ok */
    private static String m18429ok(long j, long j2, String str) {
        double d = j;
        if (j2 > 1) {
            double d2 = j2;
            Double.isNaN(d);
            Double.isNaN(d2);
            d /= d2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d) + str;
        }
        return new DecimalFormat("#.##").format(d) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m18439a(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12490bl.m17752vk().mo16494ok(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    /* renamed from: ok */
    public static int m18422ok(final Context context, final int i, final boolean z) {
        InterfaceC12300k m18072h = C12361s.m18068k().m18072h();
        if (m18072h == null) {
            return m18405s(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        f34658ok = 1;
        m18072h.mo18400ok(downloadInfo, new InterfaceC12305q() { // from class: com.ss.android.socialbase.appdownloader.bl.1
            @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12305q
            /* renamed from: ok */
            public void mo18388ok() {
                int unused = C12293bl.f34658ok = C12293bl.m18405s(context, i, z);
            }
        });
        return f34658ok;
    }

    /* renamed from: a */
    public static boolean m18440a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return m18417ok(context, downloadInfo, packageInfo, false);
    }

    /* renamed from: a */
    public static int m18441a(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo m18414ok = m18414ok(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (m18414ok != null) {
                    int i = m18414ok.versionCode;
                    downloadInfo.setAppVersionCode(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* renamed from: ok */
    public static int m18421ok(Context context, int i, boolean z, DownloadInfo downloadInfo, File file) {
        PackageInfo packageInfo;
        Intent m18416ok;
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
            packageInfo = m18412ok(downloadInfo, file);
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
        if (C12361s.m18068k().m18074bl() != null) {
            if (packageInfo == null) {
                BaseException baseException = new BaseException(2001, th);
                C12361s.m18068k().m18074bl().mo18389ok(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                C12361s.m18068k().m18074bl().mo18389ok(downloadInfo, null, 11);
            }
        }
        if (m18418ok(context, downloadInfo, packageInfo)) {
            return 2;
        }
        if (packageInfo != null && C12534ok.m17599ok(downloadInfo.getId()).m17595ok("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfo.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (m18440a(context, downloadInfo, packageInfo)) {
            m18416ok = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
        } else if (!z && m18423ok(context, i, file)) {
            downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
            return 1;
        } else {
            m18416ok = m18416ok(context, downloadInfo, file, z, iArr);
        }
        if (m18416ok == null) {
            return iArr[0] == 1 ? 2 : 0;
        }
        m18416ok.addFlags(268435456);
        if (downloadInfo.getLinkMode() > 0 && C12534ok.m17599ok(downloadInfo.getId()).m17593ok("app_install_return_result", 0) == 1) {
            m18416ok.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && C12284a.m18463ok(context, downloadInfo, m18416ok, z)) {
            return 1;
        }
        return m18420ok(context, m18416ok);
    }

    /* renamed from: a */
    public static String m18446a() {
        return C12713kf.m16582n();
    }

    /* renamed from: a */
    public static boolean m18438a(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(26)
    /* renamed from: a */
    public static String m18443a(@NonNull Context context) {
        try {
            if (f34657a == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                f34657a = notificationChannel;
                notificationChannel.setSound(null, null);
                f34657a.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(f34657a);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    /* renamed from: ok */
    public static int m18420ok(Context context, Intent intent) {
        try {
            if (C12361s.m18068k().m18071i() != null) {
                if (C12361s.m18068k().m18071i().mo17881ok(intent)) {
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

    /* renamed from: ok */
    public static boolean m18418ok(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        InterfaceC12308s m18079a = C12361s.m18068k().m18079a();
        if (m18079a != null) {
            m18079a.mo18385ok(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (m18079a.mo18387ok()) {
                return true;
            }
        }
        InterfaceC12427ep downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.mo16630ok(8, downloadInfo, packageInfo.packageName, "");
            InterfaceC12297bl m18065ok = C12361s.m18068k().m18065ok();
            return (m18065ok instanceof C12303ok) && ((C12303ok) m18065ok).m18392bl();
        }
        return false;
    }

    /* renamed from: ok */
    public static boolean m18423ok(Context context, int i, File file) {
        if (C12534ok.m17599ok(i).m17593ok("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((C12317n.m18225z() || C12317n.m18231rh()) && C12712k.m16624ok(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static int m18433ok() {
        return C12361s.m18068k().m18067kf() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri m18431ok(int r1, com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.getUriForFile(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.s r2 = com.p521ss.android.socialbase.appdownloader.C12361s.m18068k()
            com.ss.android.socialbase.appdownloader.bl.kf r2 = r2.m18066n()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.m18399ok(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
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
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.appdownloader.C12293bl.m18431ok(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    /* renamed from: ok */
    private static Intent m18416ok(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z, int[] iArr) {
        Uri m18431ok = m18431ok(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, C12361s.m18068k().m18041s(), file);
        if (m18431ok == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(m18431ok, "application/vnd.android.package-archive");
        InterfaceC12308s m18079a = C12361s.m18068k().m18079a();
        boolean mo18384ok = m18079a != null ? m18079a.mo18384ok(downloadInfo.getId(), z) : 0;
        InterfaceC12427ep downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        int i = mo18384ok;
        if (downloadNotificationEventListener != null) {
            i = downloadNotificationEventListener.mo16629ok(z);
        }
        iArr[0] = i;
        if (i != 0) {
            return null;
        }
        return intent;
    }

    /* renamed from: ok */
    public static boolean m18411ok(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && m18415ok(C12490bl.m17807l(), downloadInfo, str);
        }
        return true;
    }

    /* renamed from: ok */
    public static boolean m18415ok(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo m18412ok = m18412ok(downloadInfo, file);
                if (m18412ok == null || !m18412ok.packageName.equals(str)) {
                    return false;
                }
                int i = m18412ok.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, m18433ok());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else if (!C12534ok.m17599ok(downloadInfo.getId()).m17595ok("install_callback_error")) {
                return false;
            } else {
                String m16548ok = C12713kf.m16548ok(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int m16549ok = C12713kf.m16549ok(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (m16548ok == null || TextUtils.isEmpty(m16548ok) || !m16548ok.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, m18433ok());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || m16549ok != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: ok */
    public static boolean m18417ok(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, m18433ok());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        return z ? i < i2 : (downloadInfo == null || C12534ok.m17599ok(downloadInfo.getId()).m17593ok("install_with_same_version_code", 0) != 1) ? i <= i2 : i < i2;
    }

    /* renamed from: ok */
    public static boolean m18419ok(Context context, DownloadInfo downloadInfo) {
        return m18413ok(context, downloadInfo, true);
    }

    /* renamed from: ok */
    public static boolean m18413ok(Context context, DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z) {
            return m18435bl(context, downloadInfo);
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, m18433ok());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        return C12534ok.m17599ok(downloadInfo.getId()).m17593ok("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    /* renamed from: ok */
    public static PackageInfo m18414ok(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            Log.e("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
            return m18412ok(downloadInfo, file);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L15;
     */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m18406ok(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
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
            boolean r3 = m18434bl(r5)
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
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.appdownloader.C12293bl.m18406ok(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: ok */
    public static String m18407ok(String str, C12534ok c12534ok) {
        JSONObject m17588s;
        String format;
        if (c12534ok == null || (m17588s = c12534ok.m17588s("download_dir")) == null) {
            return "";
        }
        String optString = m17588s.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
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

    /* renamed from: ok */
    public static boolean m18408ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    /* renamed from: ok */
    public static int m18432ok(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i) || i == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i) ? 3 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r0 != null) goto L8;
     */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m18425ok(android.content.Context r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 20
            if (r0 <= r2) goto L40
            if (r6 != 0) goto La
            goto L40
        La:
            r0 = 0
            int r2 = com.p521ss.android.socialbase.appdownloader.C12330n.m18157a()     // Catch: java.lang.Throwable -> L3d
            android.content.res.Resources r3 = r6.getResources()     // Catch: java.lang.Throwable -> L3d
            int r2 = r3.getColor(r2)     // Catch: java.lang.Throwable -> L3d
            int r3 = com.p521ss.android.socialbase.appdownloader.C12330n.m18156bl()     // Catch: java.lang.Throwable -> L3d
            int r4 = com.p521ss.android.socialbase.appdownloader.C12330n.m18142s()     // Catch: java.lang.Throwable -> L3d
            r5 = 2
            int[] r5 = new int[r5]     // Catch: java.lang.Throwable -> L3d
            r5[r1] = r3     // Catch: java.lang.Throwable -> L3d
            r3 = 1
            r5[r3] = r4     // Catch: java.lang.Throwable -> L3d
            int r4 = com.p521ss.android.socialbase.appdownloader.C12330n.m18149n()     // Catch: java.lang.Throwable -> L3d
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
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.appdownloader.C12293bl.m18425ok(android.content.Context):boolean");
    }

    /* renamed from: ok */
    public static void m18409ok(DownloadInfo downloadInfo, boolean z, boolean z2) {
        C12361s.m18068k().m18055ok(new C12312kf(C12490bl.m17807l(), downloadInfo.getUrl()).m18306ok(downloadInfo.getTitle()).m18360a(downloadInfo.getName()).m18354bl(downloadInfo.getSavePath()).m18303ok(downloadInfo.isShowNotification()).m18358a(downloadInfo.isAutoInstallWithoutNotification()).m18353bl(downloadInfo.isOnlyWifi() || z2).m18317n(downloadInfo.getExtra()).m18324kf(downloadInfo.getMimeType()).m18305ok(downloadInfo.getExtraHeaders()).m18316n(true).m18361a(downloadInfo.getRetryCount()).m18355bl(downloadInfo.getBackUpUrlRetryCount()).m18359a(downloadInfo.getBackUpUrls()).m18287s(downloadInfo.getMinProgressTimeMsInterval()).m18318n(downloadInfo.getMaxProgressCount()).m18323kf(z).m18285s(downloadInfo.isNeedHttpsToHttpRetry()).m18336h(downloadInfo.getPackageName()).m18301p(downloadInfo.getMd5()).m18312ok(downloadInfo.getExpectFileLength()).m18297q(downloadInfo.isNeedDefaultHttpServiceBackUp()).m18327k(downloadInfo.isNeedReuseFirstConnection()).m18330j(downloadInfo.isNeedIndependentProcess()).m18311ok(downloadInfo.getEnqueueType()).m18290rh(downloadInfo.isForce()).m18265z(downloadInfo.isHeadConnectionAvailable()).m18335h(downloadInfo.isNeedRetryDelay()).m18298q(downloadInfo.getRetryDelayTimeArray()).m18304ok(m18404s(downloadInfo.getDownloadSettingString())).m18293r(downloadInfo.getIconUrl()).m18325kf(downloadInfo.getExecutorGroup()).m18333i(downloadInfo.isAutoInstall()));
    }

    /* renamed from: ok */
    public static void m18426ok(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: ok */
    public static PackageInfo m18412ok(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return C12323n.m18206ok(C12490bl.m17807l(), file, m18433ok());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo == null) {
            PackageInfo m18206ok = C12323n.m18206ok(C12490bl.m17807l(), file, m18433ok());
            downloadInfo.setPackageInfo(m18206ok);
            return m18206ok;
        }
        return packageInfo;
    }

    /* renamed from: ok */
    public static int m18424ok(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
