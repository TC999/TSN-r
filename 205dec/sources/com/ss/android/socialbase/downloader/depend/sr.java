package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class sr extends AbsDownloadListener implements fz {
    private void c(int i4, DownloadInfo downloadInfo, BaseException baseException, boolean z3) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i4 == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.c ux = com.ss.android.socialbase.downloader.notification.w.c().ux(downloadInfo.getId());
        if (ux == null) {
            ux = c();
        }
        ux.w(downloadInfo.getTotalBytes());
        if (i4 == -3) {
            ux.c(downloadInfo.getTotalBytes());
        } else {
            ux.c(downloadInfo.getCurBytes());
        }
        ux.c(i4, baseException, z3);
    }

    private void w(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.c ux = com.ss.android.socialbase.downloader.notification.w.c().ux(downloadInfo.getId());
        if (ux == null) {
            com.ss.android.socialbase.downloader.notification.w.c().c(c());
            return;
        }
        ux.c(downloadInfo);
    }

    private void xv(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.ss.android.socialbase.downloader.notification.c ux = com.ss.android.socialbase.downloader.notification.w.c().ux(downloadInfo.getId());
            if (ux == null) {
                ux = c();
            }
            ux.c(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    protected abstract com.ss.android.socialbase.downloader.notification.c c();

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        c(-1, downloadInfo, baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        c(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        w(downloadInfo);
        c(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        xv(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        c(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        c(-3, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.fz
    public void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        c(11, downloadInfo, null, true);
    }
}
