package com.p521ss.android.downloadlib.p533bl;

import android.content.Context;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12184h;
import com.p521ss.android.downloadlib.C12238ok;
import com.p521ss.android.downloadlib.addownload.C12027a;
import com.p521ss.android.downloadlib.addownload.C12109ok;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.stub.StubApp;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.bl.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12172kf implements InterfaceC12308s {

    /* renamed from: ok */
    private Context f34424ok;

    public C12172kf(Context context) {
        this.f34424ok = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s
    /* renamed from: ok */
    public void mo18383ok(Context context, String str) {
        C12238ok.m18626ok().m18614ok(str);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s
    /* renamed from: ok */
    public void mo18386ok(int i, int i2, String str, int i3, long j) {
        DownloadInfo downloadInfo;
        C11998a m19315ok;
        Context context = this.f34424ok;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() == 0 || (m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo)) == null) {
            return;
        }
        if (i2 == 1) {
            C12238ok.m18616ok(downloadInfo, m19315ok);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                C12109ok.m19046ok().m19044ok(downloadInfo, m19315ok.mo19309a(), m19315ok.mo19304j(), m19315ok.mo19300n(), downloadInfo.getTitle(), m19315ok.mo19293s(), downloadInfo.getTargetFilePath());
            }
        } else if (i2 == 3) {
            C12270ok.m18539ok().m18523ok("download_notification", "download_notification_install", C12238ok.m18630a(new JSONObject(), downloadInfo), m19315ok);
        } else if (i2 == 5) {
            C12270ok.m18539ok().m18525ok("download_notification", "download_notification_pause", m19315ok);
        } else if (i2 == 6) {
            C12270ok.m18539ok().m18525ok("download_notification", "download_notification_continue", m19315ok);
        } else if (i2 != 7) {
        } else {
            C12270ok.m18539ok().m18525ok("download_notification", "download_notification_click", m19315ok);
        }
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s
    /* renamed from: ok */
    public boolean mo18384ok(int i, boolean z) {
        if (C12128r.m18942t() != null) {
            return C12128r.m18942t().m19638ok(z);
        }
        return false;
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s
    /* renamed from: ok */
    public void mo18382ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        C12184h.m18835ok().m18829ok(downloadInfo);
        if (C12534ok.m17599ok(downloadInfo.getId()).m17593ok("report_download_cancel", 1) == 1) {
            C12270ok.m18539ok().m18530ok(downloadInfo, new BaseException(1012, ""));
        } else {
            C12270ok.m18539ok().m18542a(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s
    /* renamed from: ok */
    public void mo18385ok(int i, int i2, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.f34424ok;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        C12027a.m19343ok().m19342ok(this.f34424ok, downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s
    /* renamed from: ok */
    public boolean mo18387ok() {
        return C12027a.m19343ok().m19344a();
    }
}
