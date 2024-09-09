package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class c extends AbsDownloadListener implements fz {

    /* renamed from: c  reason: collision with root package name */
    private static final String f49362c = "c";

    public void c(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.xv.c.c() || downloadInfo == null) {
            return;
        }
        String str = f49362c;
        com.ss.android.socialbase.downloader.xv.c.w(str, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
