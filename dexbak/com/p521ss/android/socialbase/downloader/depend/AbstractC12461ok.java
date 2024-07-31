package com.p521ss.android.socialbase.downloader.depend;

import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;

/* renamed from: com.ss.android.socialbase.downloader.depend.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractC12461ok extends AbsDownloadListener implements InterfaceC12485zz {

    /* renamed from: ok */
    private static final String f35037ok = "ok";

    /* renamed from: ok */
    public void mo16647ok(DownloadInfo downloadInfo) {
        if (!C12409ok.m17899ok() || downloadInfo == null) {
            return;
        }
        String str = f35037ok;
        C12409ok.m17904a(str, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
