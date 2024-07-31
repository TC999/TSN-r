package com.p521ss.android.downloadlib.p533bl;

import com.p521ss.android.download.api.config.InterfaceC11972z;
import com.p521ss.android.download.api.p523bl.C11951a;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.io.File;

/* renamed from: com.ss.android.downloadlib.bl.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12167bl implements InterfaceC12484z {
    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z
    /* renamed from: a */
    public boolean mo16628a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return C11951a.m19664ok(C12534ok.m17599ok(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z
    /* renamed from: ok */
    public void mo16627ok(DownloadInfo downloadInfo) throws BaseException {
        InterfaceC11972z m18945r = C12128r.m18945r();
        if (downloadInfo == null || m18945r == null) {
            return;
        }
        String packageName = downloadInfo.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        File m18867ok = m18867ok(packageName, targetFilePath);
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        m18945r.m19635ok(packageName, targetFilePath, m18867ok, m19315ok != null ? C12197j.m18780ok(m19315ok.mo19307h()) : null);
        downloadInfo.setMimeType("application/vnd.android.package-archive");
        downloadInfo.setName(m18867ok.getName());
        downloadInfo.setMd5(null);
    }

    /* renamed from: ok */
    private File m18867ok(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
