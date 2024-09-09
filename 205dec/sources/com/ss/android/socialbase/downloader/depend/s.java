package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class s extends AbsDownloadListener implements zz {
    private void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.ok n4 = com.ss.android.socialbase.downloader.notification.a.ok().n(downloadInfo.getId());
        if (n4 == null) {
            com.ss.android.socialbase.downloader.notification.a.ok().ok(ok());
            return;
        }
        n4.ok(downloadInfo);
    }

    private void bl(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.ss.android.socialbase.downloader.notification.ok n4 = com.ss.android.socialbase.downloader.notification.a.ok().n(downloadInfo.getId());
            if (n4 == null) {
                n4 = ok();
            }
            n4.ok(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    private void ok(int i4, DownloadInfo downloadInfo, BaseException baseException, boolean z3) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i4 == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.ok n4 = com.ss.android.socialbase.downloader.notification.a.ok().n(downloadInfo.getId());
        if (n4 == null) {
            n4 = ok();
        }
        n4.a(downloadInfo.getTotalBytes());
        if (i4 == -3) {
            n4.ok(downloadInfo.getTotalBytes());
        } else {
            n4.ok(downloadInfo.getCurBytes());
        }
        n4.ok(i4, baseException, z3);
    }

    protected abstract com.ss.android.socialbase.downloader.notification.ok ok();

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        ok(-1, downloadInfo, baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        ok(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        a(downloadInfo);
        ok(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        bl(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        ok(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        ok(-3, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.zz
    public void ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        ok(11, downloadInfo, null, true);
    }
}
