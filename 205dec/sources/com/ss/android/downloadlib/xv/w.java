package com.ss.android.downloadlib.xv;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.depend.bk;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements bk {
    @Override // com.ss.android.socialbase.downloader.depend.bk
    public void c(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo c4 = com.ss.android.socialbase.appdownloader.xv.c(k.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (c4 != null) {
            downloadInfo.setAppVersionCode(c4.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.bk
    public boolean w(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.r.ux.w() && downloadInfo.getPackageInfo() == null;
    }
}
