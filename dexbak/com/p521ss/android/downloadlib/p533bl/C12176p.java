package com.p521ss.android.downloadlib.p533bl;

import androidx.annotation.NonNull;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12265s;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12200kf;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.p545n.C12332bl;
import com.p521ss.android.socialbase.appdownloader.p545n.C12335ok;
import com.p521ss.android.socialbase.appdownloader.p545n.C12336s;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.bl.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12176p {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.bl.p$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12180ok {

        /* renamed from: ok */
        private static C12176p f34436ok = new C12176p();
    }

    /* renamed from: a */
    public void m18857a(C11998a c11998a) {
        if (c11998a == null) {
            return;
        }
        m18856a(c11998a, C12534ok.m17599ok(c11998a.mo19285zz()).m17593ok("noti_continue_delay_secs", 5));
    }

    /* renamed from: bl */
    public void m18855bl(@NonNull C11998a c11998a) {
        m18854bl(c11998a, 5L);
    }

    /* renamed from: kf */
    public void m18853kf(@NonNull C11998a c11998a) {
        m18847ok(c11998a, C12534ok.m17599ok(c11998a.mo19285zz()).m17593ok("noti_open_delay_secs", 5));
    }

    /* renamed from: n */
    public void m18852n(@NonNull C11998a c11998a) {
        m18847ok(c11998a, 5L);
    }

    /* renamed from: s */
    public void m18845s(@NonNull C11998a c11998a) {
        m18854bl(c11998a, C12534ok.m17599ok(c11998a.mo19285zz()).m17593ok("noti_install_delay_secs", 5));
    }

    private C12176p() {
    }

    /* renamed from: a */
    private void m18856a(@NonNull final C11998a c11998a, long j) {
        final int mo19285zz = c11998a.mo19285zz();
        if (C12534ok.m17599ok(mo19285zz).m17607a("notification_opt_2") != 1) {
            return;
        }
        m18850ok(mo19285zz);
        C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.bl.p.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(mo19285zz);
                JSONObject jSONObject = new JSONObject();
                C12197j.m18778ok(jSONObject, "ttdownloader_type", (Object) 1);
                C12200kf.m18759bl(downloadInfo, jSONObject);
                if (downloadInfo != null && -2 == downloadInfo.getRealStatus() && !downloadInfo.isPauseReserveOnWifi()) {
                    C12176p.this.m18849ok(mo19285zz, c11998a, jSONObject);
                } else {
                    C12197j.m18778ok(jSONObject, "error_code", (Object) 1001);
                }
                C12270ok.m18539ok().m18540a("download_notification_try_show", jSONObject, c11998a);
            }
        }, j * 1000);
    }

    /* renamed from: bl */
    private void m18854bl(@NonNull final C11998a c11998a, long j) {
        final int mo19285zz = c11998a.mo19285zz();
        if (C12534ok.m17599ok(mo19285zz).m17607a("notification_opt_2") != 1) {
            return;
        }
        m18850ok(mo19285zz);
        C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.bl.p.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(mo19285zz);
                JSONObject jSONObject = new JSONObject();
                C12197j.m18778ok(jSONObject, "ttdownloader_type", (Object) 2);
                C12200kf.m18759bl(downloadInfo, jSONObject);
                if (!C12197j.m18805a(c11998a)) {
                    C12176p.this.m18849ok(mo19285zz, c11998a, jSONObject);
                } else {
                    C12197j.m18778ok(jSONObject, "error_code", (Object) 1002);
                }
                C12270ok.m18539ok().m18540a("download_notification_try_show", jSONObject, c11998a);
            }
        }, j * 1000);
    }

    /* renamed from: ok */
    public static C12176p m18851ok() {
        return C12180ok.f34436ok;
    }

    /* renamed from: ok */
    public void m18848ok(C11998a c11998a) {
        m18856a(c11998a, 5L);
    }

    /* renamed from: ok */
    public void m18847ok(@NonNull final C11998a c11998a, long j) {
        final int mo19285zz = c11998a.mo19285zz();
        if (C12534ok.m17599ok(mo19285zz).m17607a("notification_opt_2") != 1) {
            return;
        }
        m18850ok(mo19285zz);
        C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.bl.p.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(mo19285zz);
                JSONObject jSONObject = new JSONObject();
                C12197j.m18778ok(jSONObject, "ttdownloader_type", (Object) 3);
                C12200kf.m18759bl(downloadInfo, jSONObject);
                if (!C12197j.m18800bl(c11998a.mo19300n())) {
                    C12176p.this.m18849ok(mo19285zz, c11998a, jSONObject);
                } else {
                    C12197j.m18778ok(jSONObject, "error_code", (Object) 1003);
                }
                C12270ok.m18539ok().m18540a("download_notification_try_show", jSONObject, c11998a);
            }
        }, j * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m18849ok(int i, C11998a c11998a, JSONObject jSONObject) {
        if (!C12336s.m18119ok()) {
            C12197j.m18778ok(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            C12197j.m18778ok(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (C12644a.m16876ok().m16877n(i) != null) {
            C12644a.m16876ok().m16878kf(i);
        }
        C12335ok c12335ok = new C12335ok(C12128r.getContext(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        c12335ok.m16861ok(downloadInfo.getCurBytes());
        c12335ok.m16869a(downloadInfo.getTotalBytes());
        c12335ok.m16862ok(downloadInfo.getStatus(), null, false, false);
        C12644a.m16876ok().m16872ok(c12335ok);
        c12335ok.mo16858ok((BaseException) null, false);
        C12270ok.m18539ok().m18540a("download_notification_show", jSONObject, c11998a);
    }

    /* renamed from: ok */
    public void m18850ok(int i) {
        DownloadInfo downloadInfo;
        if (C12332bl.m18133ok().m18132ok(i) != null || (downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(i)) == null) {
            return;
        }
        C12332bl.m18133ok().m18130ok(i, downloadInfo.getIconUrl());
    }
}
