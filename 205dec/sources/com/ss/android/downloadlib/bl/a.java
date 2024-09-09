package com.ss.android.downloadlib.bl;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements z {
    @Override // com.ss.android.socialbase.downloader.depend.z
    public boolean a(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.h.n.a() && downloadInfo.getPackageInfo() == null;
    }

    @Override // com.ss.android.socialbase.downloader.depend.z
    public void ok(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo ok = com.ss.android.socialbase.appdownloader.bl.ok(r.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (ok != null) {
            downloadInfo.setAppVersionCode(ok.versionCode);
        }
    }
}
