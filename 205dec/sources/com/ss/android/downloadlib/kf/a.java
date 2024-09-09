package com.ss.android.downloadlib.kf;

import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.socialbase.appdownloader.bl.k;
import com.ss.android.socialbase.appdownloader.bl.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements k {
    @Override // com.ss.android.socialbase.appdownloader.bl.k
    public void ok(DownloadInfo downloadInfo, q qVar) {
        com.ss.android.downloadad.api.ok.a ok;
        if (downloadInfo != null && (ok = kf.ok().ok(downloadInfo)) != null) {
            downloadInfo.setLinkMode(ok.l());
        }
        if (qVar != null) {
            qVar.ok();
        }
    }
}
