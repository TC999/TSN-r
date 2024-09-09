package com.ss.android.downloadlib.bl;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class p {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {
        private static p ok = new p();
    }

    public void a(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return;
        }
        a(aVar, com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("noti_continue_delay_secs", 5));
    }

    public void bl(@NonNull com.ss.android.downloadad.api.ok.a aVar) {
        bl(aVar, 5L);
    }

    public void kf(@NonNull com.ss.android.downloadad.api.ok.a aVar) {
        ok(aVar, com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("noti_open_delay_secs", 5));
    }

    public void n(@NonNull com.ss.android.downloadad.api.ok.a aVar) {
        ok(aVar, 5L);
    }

    public void s(@NonNull com.ss.android.downloadad.api.ok.a aVar) {
        bl(aVar, com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("noti_install_delay_secs", 5));
    }

    private p() {
    }

    private void a(@NonNull final com.ss.android.downloadad.api.ok.a aVar, long j4) {
        final int zz = aVar.zz();
        if (com.ss.android.socialbase.downloader.h.ok.ok(zz).a("notification_opt_2") != 1) {
            return;
        }
        ok(zz);
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.bl.p.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(zz);
                JSONObject jSONObject = new JSONObject();
                j.ok(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
                if (downloadInfo != null && -2 == downloadInfo.getRealStatus() && !downloadInfo.isPauseReserveOnWifi()) {
                    p.this.ok(zz, aVar, jSONObject);
                } else {
                    j.ok(jSONObject, "error_code", (Object) 1001);
                }
                com.ss.android.downloadlib.s.ok.ok().a("download_notification_try_show", jSONObject, aVar);
            }
        }, j4 * 1000);
    }

    private void bl(@NonNull final com.ss.android.downloadad.api.ok.a aVar, long j4) {
        final int zz = aVar.zz();
        if (com.ss.android.socialbase.downloader.h.ok.ok(zz).a("notification_opt_2") != 1) {
            return;
        }
        ok(zz);
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.bl.p.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(zz);
                JSONObject jSONObject = new JSONObject();
                j.ok(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
                if (!j.a(aVar)) {
                    p.this.ok(zz, aVar, jSONObject);
                } else {
                    j.ok(jSONObject, "error_code", (Object) 1002);
                }
                com.ss.android.downloadlib.s.ok.ok().a("download_notification_try_show", jSONObject, aVar);
            }
        }, j4 * 1000);
    }

    public static p ok() {
        return ok.ok;
    }

    public void ok(com.ss.android.downloadad.api.ok.a aVar) {
        a(aVar, 5L);
    }

    public void ok(@NonNull final com.ss.android.downloadad.api.ok.a aVar, long j4) {
        final int zz = aVar.zz();
        if (com.ss.android.socialbase.downloader.h.ok.ok(zz).a("notification_opt_2") != 1) {
            return;
        }
        ok(zz);
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.bl.p.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(zz);
                JSONObject jSONObject = new JSONObject();
                j.ok(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
                if (!j.bl(aVar.n())) {
                    p.this.ok(zz, aVar, jSONObject);
                } else {
                    j.ok(jSONObject, "error_code", (Object) 1003);
                }
                com.ss.android.downloadlib.s.ok.ok().a("download_notification_try_show", jSONObject, aVar);
            }
        }, j4 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, com.ss.android.downloadad.api.ok.a aVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.n.s.ok()) {
            j.ok(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(i4);
        if (downloadInfo == null) {
            j.ok(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (com.ss.android.socialbase.downloader.notification.a.ok().n(i4) != null) {
            com.ss.android.socialbase.downloader.notification.a.ok().kf(i4);
        }
        com.ss.android.socialbase.appdownloader.n.ok okVar = new com.ss.android.socialbase.appdownloader.n.ok(r.getContext(), i4, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        okVar.ok(downloadInfo.getCurBytes());
        okVar.a(downloadInfo.getTotalBytes());
        okVar.ok(downloadInfo.getStatus(), null, false, false);
        com.ss.android.socialbase.downloader.notification.a.ok().ok(okVar);
        okVar.ok((BaseException) null, false);
        com.ss.android.downloadlib.s.ok.ok().a("download_notification_show", jSONObject, aVar);
    }

    public void ok(int i4) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.n.bl.ok().ok(i4) != null || (downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(i4)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.n.bl.ok().ok(i4, downloadInfo.getIconUrl());
    }
}
