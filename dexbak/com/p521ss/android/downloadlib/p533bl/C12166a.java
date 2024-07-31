package com.p521ss.android.downloadlib.p533bl;

import android.content.pm.PackageInfo;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.downloadlib.bl.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12166a implements InterfaceC12484z {
    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z
    /* renamed from: a */
    public boolean mo16628a(DownloadInfo downloadInfo) {
        return downloadInfo != null && C12201n.m18753a() && downloadInfo.getPackageInfo() == null;
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z
    /* renamed from: ok */
    public void mo16627ok(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo m18414ok = C12293bl.m18414ok(C12128r.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (m18414ok != null) {
            downloadInfo.setAppVersionCode(m18414ok.versionCode);
        }
    }
}
