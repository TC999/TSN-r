package com.ss.android.downloadlib.xv;

import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.downloader.depend.bk;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv implements bk {
    @Override // com.ss.android.socialbase.downloader.depend.bk
    public void c(DownloadInfo downloadInfo) throws BaseException {
        com.ss.android.download.api.config.bk k4 = k.k();
        if (downloadInfo == null || k4 == null) {
            return;
        }
        String packageName = downloadInfo.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        File c4 = c(packageName, targetFilePath);
        com.ss.android.downloadad.api.c.w c5 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo);
        k4.c(packageName, targetFilePath, c4, c5 != null ? a.c(c5.r()) : null);
        downloadInfo.setMimeType("application/vnd.android.package-archive");
        downloadInfo.setName(c4.getName());
        downloadInfo.setMd5(null);
    }

    @Override // com.ss.android.socialbase.downloader.depend.bk
    public boolean w(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.xv.w.c(com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    private File c(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
