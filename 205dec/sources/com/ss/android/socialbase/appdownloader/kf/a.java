package com.ss.android.socialbase.appdownloader.kf;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    private static void a(final DownloadInfo downloadInfo) {
        final Context l4 = com.ss.android.socialbase.downloader.downloader.bl.l();
        boolean z3 = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.bl.a(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("auto_install_when_resume", 0) != 1) {
            z3 = false;
        }
        final int ok = z3 ? com.ss.android.socialbase.appdownloader.bl.ok(l4, downloadInfo.getId(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.kf.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.bl.s a4 = com.ss.android.socialbase.appdownloader.s.k().a();
                ep downloadNotificationEventListener = Downloader.getInstance(l4).getDownloadNotificationEventListener(downloadInfo.getId());
                if (a4 == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo ok2 = com.ss.android.socialbase.appdownloader.bl.ok(downloadInfo, file);
                        if (ok2 != null) {
                            String packageName = (ok == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? ok2.packageName : downloadInfo.getPackageName();
                            if (a4 != null) {
                                a4.ok(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.ok(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        });
    }

    public static void ok(DownloadInfo downloadInfo) {
        a(downloadInfo);
    }
}
