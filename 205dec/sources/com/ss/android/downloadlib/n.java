package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.io;
import com.ss.android.download.api.config.j;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.x;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n implements com.ss.android.download.api.ok {
    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull q qVar) {
        com.ss.android.downloadlib.addownload.r.ok(qVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull com.ss.android.download.api.config.h hVar) {
        com.ss.android.downloadlib.addownload.r.ok(hVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull j jVar) {
        com.ss.android.downloadlib.addownload.r.ok(jVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull com.ss.android.download.api.config.p pVar) {
        com.ss.android.downloadlib.addownload.r.ok(pVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull k kVar) {
        com.ss.android.downloadlib.addownload.r.ok(kVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull com.ss.android.download.api.model.ok okVar) {
        com.ss.android.downloadlib.addownload.r.ok(okVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(String str) {
        com.ss.android.downloadlib.addownload.r.ok(str);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(@NonNull final com.ss.android.download.api.config.a aVar) {
        com.ss.android.downloadlib.addownload.r.ok(aVar);
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(new ok.bl() { // from class: com.ss.android.downloadlib.n.1
        });
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new v() { // from class: com.ss.android.downloadlib.n.2
                private boolean s(DownloadInfo downloadInfo) {
                    String ok;
                    io zz = com.ss.android.downloadlib.addownload.r.zz();
                    if (zz != null) {
                        com.ss.android.downloadad.api.ok.a ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
                        if (ok2 != null && ok2.bl()) {
                            ok = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("ad_notification_jump_url", (String) null);
                        } else {
                            ok = com.ss.android.downloadlib.addownload.q.ok(downloadInfo);
                        }
                        if (TextUtils.isEmpty(ok)) {
                            return false;
                        }
                        return zz.ok(com.ss.android.downloadlib.addownload.r.getContext(), ok);
                    }
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public boolean a(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public boolean bl(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.ok.a ok = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
                    if (ok != null) {
                        com.ss.android.downloadlib.a.ok.ok(ok);
                    } else {
                        com.ss.android.downloadlib.h.q.a(com.ss.android.downloadlib.addownload.r.getContext(), downloadInfo.getPackageName());
                    }
                    com.ss.android.socialbase.downloader.notification.a.ok().kf(downloadInfo.getId());
                    return true;
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public boolean ok(DownloadInfo downloadInfo) {
                    com.ss.android.socialbase.downloader.h.ok ok = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
                    if (ok.a("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.ok(com.ss.android.downloadlib.addownload.r.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.s.k().a(), Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean s3 = s(downloadInfo);
                    if (ok.ok("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return s3;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.bl.bl());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public com.ss.android.download.api.ok ok(x xVar) {
        com.ss.android.downloadlib.addownload.r.ok(xVar);
        return this;
    }

    @Override // com.ss.android.download.api.ok
    public void ok() {
        if (!com.ss.android.downloadlib.addownload.r.o()) {
            com.ss.android.downloadlib.n.bl.ok().ok("ttdownloader init error");
        }
        com.ss.android.downloadlib.addownload.r.ok(com.ss.android.downloadlib.n.bl.ok());
        try {
            com.ss.android.socialbase.appdownloader.s.k().a(com.ss.android.downloadlib.addownload.r.ul());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.s.k().ok(ok.ok());
        s.ok().a(new Runnable() { // from class: com.ss.android.downloadlib.n.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.kf.n.ok("");
                if (com.ss.android.socialbase.appdownloader.kf.n.t()) {
                    com.ss.android.socialbase.downloader.downloader.bl.ok(true);
                }
                if (com.ss.android.socialbase.downloader.h.ok.bl().ok("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.kf.kf.ok(com.ss.android.downloadlib.addownload.r.getContext());
                }
            }
        });
    }
}
