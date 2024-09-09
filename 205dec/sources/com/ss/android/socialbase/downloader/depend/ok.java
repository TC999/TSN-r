package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class ok extends AbsDownloadListener implements zz {
    private static final String ok = "ok";

    public void ok(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.bl.ok.ok() || downloadInfo == null) {
            return;
        }
        String str = ok;
        com.ss.android.socialbase.downloader.bl.ok.a(str, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
