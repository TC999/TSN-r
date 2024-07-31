package com.p521ss.android.socialbase.downloader.p556q;

import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12485zz;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.q.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12667bl {
    /* renamed from: ok */
    public static void m16732ok(int i, SparseArray<IDownloadListener> sparseArray, boolean z, DownloadInfo downloadInfo, BaseException baseException) {
        SparseArray<IDownloadListener> clone;
        if (!z || sparseArray == null) {
            return;
        }
        try {
            if (sparseArray.size() <= 0) {
                return;
            }
            synchronized (sparseArray) {
                clone = sparseArray.clone();
            }
            for (int i2 = 0; i2 < clone.size(); i2++) {
                IDownloadListener iDownloadListener = clone.get(clone.keyAt(i2));
                if (iDownloadListener != null) {
                    if (i == 1) {
                        iDownloadListener.onPrepare(downloadInfo);
                    } else if (i == 2) {
                        iDownloadListener.onStart(downloadInfo);
                    } else if (i == 4) {
                        iDownloadListener.onProgress(downloadInfo);
                    } else if (i == 5) {
                        iDownloadListener.onRetry(downloadInfo, baseException);
                    } else if (i == 6) {
                        iDownloadListener.onFirstStart(downloadInfo);
                    } else if (i == 7) {
                        iDownloadListener.onRetryDelay(downloadInfo, baseException);
                    } else if (i != 11) {
                        switch (i) {
                            case -7:
                                if (iDownloadListener instanceof AbsDownloadListener) {
                                    ((AbsDownloadListener) iDownloadListener).onIntercept(downloadInfo);
                                    break;
                                } else {
                                    continue;
                                }
                            case -6:
                                iDownloadListener.onFirstSuccess(downloadInfo);
                                continue;
                            case -5:
                            case -2:
                                iDownloadListener.onPause(downloadInfo);
                                continue;
                            case -4:
                                iDownloadListener.onCanceled(downloadInfo);
                                continue;
                            case -3:
                                iDownloadListener.onSuccessed(downloadInfo);
                                continue;
                            case -1:
                                iDownloadListener.onFailed(downloadInfo, baseException);
                                continue;
                            default:
                                continue;
                        }
                    } else if (iDownloadListener instanceof InterfaceC12485zz) {
                        ((InterfaceC12485zz) iDownloadListener).mo16647ok(downloadInfo);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
