package com.ss.android.downloadlib.bl;

import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl implements z {
    @Override // com.ss.android.socialbase.downloader.depend.z
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.bl.a.ok(com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.z
    public void ok(DownloadInfo downloadInfo) throws BaseException {
        com.ss.android.download.api.config.z r3 = r.r();
        if (downloadInfo == null || r3 == null) {
            return;
        }
        String packageName = downloadInfo.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        File ok = ok(packageName, targetFilePath);
        com.ss.android.downloadad.api.ok.a ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        r3.ok(packageName, targetFilePath, ok, ok2 != null ? j.ok(ok2.h()) : null);
        downloadInfo.setMimeType("application/vnd.android.package-archive");
        downloadInfo.setName(ok.getName());
        downloadInfo.setMd5(null);
    }

    private File ok(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
