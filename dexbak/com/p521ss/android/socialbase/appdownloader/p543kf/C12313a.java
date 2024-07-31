package com.p521ss.android.socialbase.appdownloader.p543kf;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.io.File;

/* renamed from: com.ss.android.socialbase.appdownloader.kf.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12313a {
    /* renamed from: a */
    private static void m18263a(final DownloadInfo downloadInfo) {
        final Context m17807l = C12490bl.m17807l();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || C12293bl.m18438a(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) && C12534ok.m17599ok(downloadInfo.getId()).m17593ok("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int m18422ok = z ? C12293bl.m18422ok(m17807l, downloadInfo.getId(), false) : 2;
        C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.kf.a.1
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC12308s m18079a = C12361s.m18068k().m18079a();
                InterfaceC12427ep downloadNotificationEventListener = Downloader.getInstance(m17807l).getDownloadNotificationEventListener(downloadInfo.getId());
                if (m18079a == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo m18412ok = C12293bl.m18412ok(downloadInfo, file);
                        if (m18412ok != null) {
                            String packageName = (m18422ok == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? m18412ok.packageName : downloadInfo.getPackageName();
                            if (m18079a != null) {
                                m18079a.mo18386ok(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.mo16630ok(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: ok */
    public static void m18262ok(DownloadInfo downloadInfo) {
        m18263a(downloadInfo);
    }
}
