package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.gd;
import com.ss.android.download.api.config.i;
import com.ss.android.download.api.config.ia;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.c.c;
import com.ss.android.socialbase.downloader.depend.me;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux implements com.ss.android.download.api.c {
    @Override // com.ss.android.download.api.c
    public com.ss.android.download.api.c c(@NonNull gd gdVar) {
        k.c(gdVar);
        return this;
    }

    @Override // com.ss.android.download.api.c
    public com.ss.android.download.api.c c(@NonNull com.ss.android.download.api.config.r rVar) {
        k.c(rVar);
        return this;
    }

    @Override // com.ss.android.download.api.c
    public com.ss.android.download.api.c c(@NonNull com.ss.android.download.api.config.a aVar) {
        k.c(aVar);
        return this;
    }

    @Override // com.ss.android.download.api.c
    public com.ss.android.download.api.c c(@NonNull com.ss.android.download.api.config.ev evVar) {
        k.c(evVar);
        return this;
    }

    @Override // com.ss.android.download.api.c
    public com.ss.android.download.api.c c(@NonNull com.ss.android.download.api.config.p pVar) {
        k.c(pVar);
        return this;
    }

    @Override // com.ss.android.download.api.c
    public com.ss.android.download.api.c c(@NonNull com.ss.android.download.api.model.c cVar) {
        k.c(cVar);
        return this;
    }

    @Override // com.ss.android.download.api.c
    public com.ss.android.download.api.c c(String str) {
        k.c(str);
        return this;
    }

    @Override // com.ss.android.download.api.c
    public com.ss.android.download.api.c c(@NonNull final com.ss.android.download.api.config.w wVar) {
        k.c(wVar);
        com.ss.android.socialbase.downloader.c.c.c().c(new c.xv() { // from class: com.ss.android.downloadlib.ux.1
        });
        return this;
    }

    @Override // com.ss.android.download.api.c
    public com.ss.android.download.api.c c(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new me() { // from class: com.ss.android.downloadlib.ux.2
                private boolean sr(DownloadInfo downloadInfo) {
                    String c4;
                    i fz = k.fz();
                    if (fz != null) {
                        com.ss.android.downloadad.api.c.w c5 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo);
                        if (c5 != null && c5.xv()) {
                            c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("ad_notification_jump_url", (String) null);
                        } else {
                            c4 = com.ss.android.downloadlib.addownload.gd.c(downloadInfo);
                        }
                        if (TextUtils.isEmpty(c4)) {
                            return false;
                        }
                        return fz.c(k.getContext(), c4);
                    }
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.me
                public boolean c(DownloadInfo downloadInfo) {
                    com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId());
                    if (c4.w("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.c(k.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.sr.p().w(), Downloader.getInstance(k.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean sr = sr(downloadInfo);
                    if (c4.c("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return sr;
                }

                @Override // com.ss.android.socialbase.downloader.depend.me
                public boolean w(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.me
                public boolean xv(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.c.w c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo);
                    if (c4 != null) {
                        com.ss.android.downloadlib.w.c.c(c4);
                    } else {
                        com.ss.android.downloadlib.r.gd.w(k.getContext(), downloadInfo.getPackageName());
                    }
                    com.ss.android.socialbase.downloader.notification.w.c().f(downloadInfo.getId());
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.xv.xv());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.c
    public com.ss.android.download.api.c c(ia iaVar) {
        k.c(iaVar);
        return this;
    }

    @Override // com.ss.android.download.api.c
    public void c() {
        if (!k.j()) {
            com.ss.android.downloadlib.ux.xv.c().c("ttdownloader init error");
        }
        k.c(com.ss.android.downloadlib.ux.xv.c());
        try {
            com.ss.android.socialbase.appdownloader.sr.p().w(k.q());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.sr.p().c(c.c());
        sr.c().w(new Runnable() { // from class: com.ss.android.downloadlib.ux.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.f.ux.c("");
                if (com.ss.android.socialbase.appdownloader.f.ux.ys()) {
                    com.ss.android.socialbase.downloader.downloader.xv.c(true);
                }
                if (com.ss.android.socialbase.downloader.r.c.xv().c("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.f.f.c(k.getContext());
                }
            }
        });
    }
}
