package com.ss.android.downloadlib.xv;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ev {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private static ev f49003c = new ev();
    }

    public void f(@NonNull com.ss.android.downloadad.api.c.w wVar) {
        c(wVar, com.ss.android.socialbase.downloader.r.c.c(wVar.fz()).c("noti_open_delay_secs", 5));
    }

    public void sr(@NonNull com.ss.android.downloadad.api.c.w wVar) {
        xv(wVar, com.ss.android.socialbase.downloader.r.c.c(wVar.fz()).c("noti_install_delay_secs", 5));
    }

    public void ux(@NonNull com.ss.android.downloadad.api.c.w wVar) {
        c(wVar, 5L);
    }

    public void w(com.ss.android.downloadad.api.c.w wVar) {
        if (wVar == null) {
            return;
        }
        w(wVar, com.ss.android.socialbase.downloader.r.c.c(wVar.fz()).c("noti_continue_delay_secs", 5));
    }

    public void xv(@NonNull com.ss.android.downloadad.api.c.w wVar) {
        xv(wVar, 5L);
    }

    private ev() {
    }

    public static ev c() {
        return c.f49003c;
    }

    private void w(@NonNull final com.ss.android.downloadad.api.c.w wVar, long j4) {
        final int fz = wVar.fz();
        if (com.ss.android.socialbase.downloader.r.c.c(fz).w("notification_opt_2") != 1) {
            return;
        }
        c(fz);
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.xv.ev.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(fz);
                JSONObject jSONObject = new JSONObject();
                a.c(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.r.f.xv(downloadInfo, jSONObject);
                if (downloadInfo != null && -2 == downloadInfo.getRealStatus() && !downloadInfo.isPauseReserveOnWifi()) {
                    ev.this.c(fz, wVar, jSONObject);
                } else {
                    a.c(jSONObject, "error_code", (Object) 1001);
                }
                com.ss.android.downloadlib.sr.c.c().w("download_notification_try_show", jSONObject, wVar);
            }
        }, j4 * 1000);
    }

    private void xv(@NonNull final com.ss.android.downloadad.api.c.w wVar, long j4) {
        final int fz = wVar.fz();
        if (com.ss.android.socialbase.downloader.r.c.c(fz).w("notification_opt_2") != 1) {
            return;
        }
        c(fz);
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.xv.ev.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(fz);
                JSONObject jSONObject = new JSONObject();
                a.c(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.r.f.xv(downloadInfo, jSONObject);
                if (!a.w(wVar)) {
                    ev.this.c(fz, wVar, jSONObject);
                } else {
                    a.c(jSONObject, "error_code", (Object) 1002);
                }
                com.ss.android.downloadlib.sr.c.c().w("download_notification_try_show", jSONObject, wVar);
            }
        }, j4 * 1000);
    }

    public void c(com.ss.android.downloadad.api.c.w wVar) {
        w(wVar, 5L);
    }

    public void c(@NonNull final com.ss.android.downloadad.api.c.w wVar, long j4) {
        final int fz = wVar.fz();
        if (com.ss.android.socialbase.downloader.r.c.c(fz).w("notification_opt_2") != 1) {
            return;
        }
        c(fz);
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.xv.ev.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(fz);
                JSONObject jSONObject = new JSONObject();
                a.c(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.r.f.xv(downloadInfo, jSONObject);
                if (!a.xv(wVar.ux())) {
                    ev.this.c(fz, wVar, jSONObject);
                } else {
                    a.c(jSONObject, "error_code", (Object) 1003);
                }
                com.ss.android.downloadlib.sr.c.c().w("download_notification_try_show", jSONObject, wVar);
            }
        }, j4 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, com.ss.android.downloadad.api.c.w wVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.ux.sr.c()) {
            a.c(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(i4);
        if (downloadInfo == null) {
            a.c(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (com.ss.android.socialbase.downloader.notification.w.c().ux(i4) != null) {
            com.ss.android.socialbase.downloader.notification.w.c().f(i4);
        }
        com.ss.android.socialbase.appdownloader.ux.c cVar = new com.ss.android.socialbase.appdownloader.ux.c(k.getContext(), i4, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        cVar.c(downloadInfo.getCurBytes());
        cVar.w(downloadInfo.getTotalBytes());
        cVar.c(downloadInfo.getStatus(), null, false, false);
        com.ss.android.socialbase.downloader.notification.w.c().c(cVar);
        cVar.c((BaseException) null, false);
        com.ss.android.downloadlib.sr.c.c().w("download_notification_show", jSONObject, wVar);
    }

    public void c(int i4) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.ux.xv.c().c(i4) != null || (downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(i4)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.ux.xv.c().c(i4, downloadInfo.getIconUrl());
    }
}
