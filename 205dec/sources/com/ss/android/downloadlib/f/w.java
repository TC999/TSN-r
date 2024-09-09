package com.ss.android.downloadlib.f;

import com.ss.android.downloadlib.addownload.w.f;
import com.ss.android.socialbase.appdownloader.xv.gd;
import com.ss.android.socialbase.appdownloader.xv.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements p {
    @Override // com.ss.android.socialbase.appdownloader.xv.p
    public void c(DownloadInfo downloadInfo, gd gdVar) {
        com.ss.android.downloadad.api.c.w c4;
        if (downloadInfo != null && (c4 = f.c().c(downloadInfo)) != null) {
            downloadInfo.setLinkMode(c4.gw());
        }
        if (gdVar != null) {
            gdVar.c();
        }
    }
}
