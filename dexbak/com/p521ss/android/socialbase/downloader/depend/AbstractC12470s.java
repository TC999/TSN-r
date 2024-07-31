package com.p521ss.android.socialbase.downloader.depend;

import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.AbstractC12645ok;
import com.p521ss.android.socialbase.downloader.notification.C12644a;

/* renamed from: com.ss.android.socialbase.downloader.depend.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractC12470s extends AbsDownloadListener implements InterfaceC12485zz {
    /* renamed from: a */
    private void m17853a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        AbstractC12645ok m16877n = C12644a.m16876ok().m16877n(downloadInfo.getId());
        if (m16877n == null) {
            C12644a.m16876ok().m16872ok(mo17851ok());
            return;
        }
        m16877n.mo16857ok(downloadInfo);
    }

    /* renamed from: bl */
    private void m17852bl(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            AbstractC12645ok m16877n = C12644a.m16876ok().m16877n(downloadInfo.getId());
            if (m16877n == null) {
                m16877n = mo17851ok();
            }
            m16877n.m16860ok(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    /* renamed from: ok */
    private void m17850ok(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i == 4) {
            return;
        }
        AbstractC12645ok m16877n = C12644a.m16876ok().m16877n(downloadInfo.getId());
        if (m16877n == null) {
            m16877n = mo17851ok();
        }
        m16877n.m16869a(downloadInfo.getTotalBytes());
        if (i == -3) {
            m16877n.m16861ok(downloadInfo.getTotalBytes());
        } else {
            m16877n.m16861ok(downloadInfo.getCurBytes());
        }
        m16877n.m16863ok(i, baseException, z);
    }

    /* renamed from: ok */
    protected abstract AbstractC12645ok mo17851ok();

    @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        m17850ok(-1, downloadInfo, baseException, false);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        m17850ok(-2, downloadInfo, null, false);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        m17853a(downloadInfo);
        m17850ok(1, downloadInfo, null, true);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        m17852bl(downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        m17850ok(2, downloadInfo, null, false);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        m17850ok(-3, downloadInfo, null, false);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12485zz
    /* renamed from: ok */
    public void mo16647ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        m17850ok(11, downloadInfo, null, true);
    }
}
