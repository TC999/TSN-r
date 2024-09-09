package com.ss.android.downloadlib.bl;

import android.content.Context;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf implements com.ss.android.socialbase.appdownloader.bl.s {
    private Context ok;

    public kf(Context context) {
        this.ok = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public void ok(Context context, String str) {
        com.ss.android.downloadlib.ok.ok().ok(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public void ok(int i4, int i5, String str, int i6, long j4) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.ok.a ok;
        Context context = this.ok;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i4)) == null || downloadInfo.getStatus() == 0 || (ok = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo)) == null) {
            return;
        }
        if (i5 == 1) {
            com.ss.android.downloadlib.ok.ok(downloadInfo, ok);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.ok.ok().ok(downloadInfo, ok.a(), ok.j(), ok.n(), downloadInfo.getTitle(), ok.s(), downloadInfo.getTargetFilePath());
            }
        } else if (i5 == 3) {
            com.ss.android.downloadlib.s.ok.ok().ok("download_notification", "download_notification_install", com.ss.android.downloadlib.ok.a(new JSONObject(), downloadInfo), ok);
        } else if (i5 == 5) {
            com.ss.android.downloadlib.s.ok.ok().ok("download_notification", "download_notification_pause", ok);
        } else if (i5 == 6) {
            com.ss.android.downloadlib.s.ok.ok().ok("download_notification", "download_notification_continue", ok);
        } else if (i5 != 7) {
        } else {
            com.ss.android.downloadlib.s.ok.ok().ok("download_notification", "download_notification_click", ok);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public boolean ok(int i4, boolean z3) {
        if (r.t() != null) {
            return r.t().ok(z3);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public void ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.h.ok().ok(downloadInfo);
        if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.s.ok.ok().ok(downloadInfo, new BaseException(1012, ""));
        } else {
            com.ss.android.downloadlib.s.ok.ok().a(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public void ok(int i4, int i5, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.ok;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i4)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.a.ok().ok(this.ok, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.s
    public boolean ok() {
        return com.ss.android.downloadlib.addownload.a.ok().a();
    }
}
