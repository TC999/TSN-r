package com.p521ss.android.downloadlib.p535kf;

import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12300k;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12305q;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.downloadlib.kf.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12221a implements InterfaceC12300k {
    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12300k
    /* renamed from: ok */
    public void mo18400ok(DownloadInfo downloadInfo, InterfaceC12305q interfaceC12305q) {
        C11998a m19315ok;
        if (downloadInfo != null && (m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo)) != null) {
            downloadInfo.setLinkMode(m19315ok.m19481l());
        }
        if (interfaceC12305q != null) {
            interfaceC12305q.mo18388ok();
        }
    }
}
