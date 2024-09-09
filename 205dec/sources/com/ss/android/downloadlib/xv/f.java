package com.ss.android.downloadlib.xv;

import android.content.Context;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f implements com.ss.android.socialbase.appdownloader.xv.sr {

    /* renamed from: c  reason: collision with root package name */
    private Context f49004c;

    public f(Context context) {
        this.f49004c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.sr
    public void c(Context context, String str) {
        com.ss.android.downloadlib.c.c().c(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.sr
    public void c(int i4, int i5, String str, int i6, long j4) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.c.w c4;
        Context context = this.f49004c;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i4)) == null || downloadInfo.getStatus() == 0 || (c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo)) == null) {
            return;
        }
        if (i5 == 1) {
            com.ss.android.downloadlib.c.c(downloadInfo, c4);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.c.c().c(downloadInfo, c4.w(), c4.a(), c4.ux(), downloadInfo.getTitle(), c4.sr(), downloadInfo.getTargetFilePath());
            }
        } else if (i5 == 3) {
            com.ss.android.downloadlib.sr.c.c().c("download_notification", "download_notification_install", com.ss.android.downloadlib.c.w(new JSONObject(), downloadInfo), c4);
        } else if (i5 == 5) {
            com.ss.android.downloadlib.sr.c.c().c("download_notification", "download_notification_pause", c4);
        } else if (i5 == 6) {
            com.ss.android.downloadlib.sr.c.c().c("download_notification", "download_notification_continue", c4);
        } else if (i5 != 7) {
        } else {
            com.ss.android.downloadlib.sr.c.c().c("download_notification", "download_notification_click", c4);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.sr
    public boolean c(int i4, boolean z3) {
        if (k.ys() != null) {
            return k.ys().c(z3);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.sr
    public void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.r.c().c(downloadInfo);
        if (com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.sr.c.c().c(downloadInfo, new BaseException(1012, ""));
        } else {
            com.ss.android.downloadlib.sr.c.c().w(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.sr
    public void c(int i4, int i5, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.f49004c;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i4)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.w.c().c(this.f49004c, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.sr
    public boolean c() {
        return com.ss.android.downloadlib.addownload.w.c().w();
    }
}
