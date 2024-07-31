package com.p521ss.android.socialbase.downloader.depend;

import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;

/* renamed from: com.ss.android.socialbase.downloader.depend.AbsDownloadListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    private static final String TAG = "AbsDownloadListener";

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        C12409ok.m17904a(str, " onCanceled -- " + downloadInfo.getName());
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        C12409ok.m17904a(str, String.format("onFailed on %s because of : %s", objArr));
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        C12409ok.m17904a(str, " onFirstStart -- " + downloadInfo.getName());
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        C12409ok.m17904a(str, " onFirstSuccess -- " + downloadInfo.getName());
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        C12409ok.m17904a(str, " onIntercept -- " + downloadInfo.getName());
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        C12409ok.m17904a(str, " onPause -- " + downloadInfo.getName());
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        C12409ok.m17904a(str, " onPrepare -- " + downloadInfo.getName());
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (!C12409ok.m17899ok() || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        C12409ok.m17904a(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((((float) downloadInfo.getCurBytes()) / ((float) downloadInfo.getTotalBytes())) * 100.0f)));
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        C12409ok.m17904a(str, String.format("onRetry on %s because of : %s", objArr));
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        C12409ok.m17904a(str, String.format("onRetryDelay on %s because of : %s", objArr));
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        C12409ok.m17904a(str, " onStart -- " + downloadInfo.getName());
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        C12409ok.m17904a(str, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
    }
}
