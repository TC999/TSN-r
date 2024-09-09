package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {
    public static void c(DownloadInfo downloadInfo) {
        w(downloadInfo);
    }

    private static void w(final DownloadInfo downloadInfo) {
        final Context gw = com.ss.android.socialbase.downloader.downloader.xv.gw();
        boolean z3 = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.xv.w(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("auto_install_when_resume", 0) != 1) {
            z3 = false;
        }
        final int c4 = z3 ? com.ss.android.socialbase.appdownloader.xv.c(gw, downloadInfo.getId(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.xv.a().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.f.w.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.xv.sr w3 = com.ss.android.socialbase.appdownloader.sr.p().w();
                n downloadNotificationEventListener = Downloader.getInstance(gw).getDownloadNotificationEventListener(downloadInfo.getId());
                if (w3 == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo c5 = com.ss.android.socialbase.appdownloader.xv.c(downloadInfo, file);
                        if (c5 != null) {
                            String packageName = (c4 == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? c5.packageName : downloadInfo.getPackageName();
                            if (w3 != null) {
                                w3.c(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.c(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        });
    }
}
