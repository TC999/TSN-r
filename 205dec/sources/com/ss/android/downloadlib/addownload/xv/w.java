package com.ss.android.downloadlib.addownload.xv;

import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.w.f;
import com.ss.android.downloadlib.addownload.w.gd;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private DownloadInfo f48739c;

    public w(DownloadInfo downloadInfo) {
        this.f48739c = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.downloadad.api.c.w c4;
        if (this.f48739c == null || (c4 = f.c().c(this.f48739c)) == null) {
            return;
        }
        com.ss.android.downloadlib.sr.c.c().c("cleanspace_task", c4);
        double totalBytes = this.f48739c.getTotalBytes();
        Double.isNaN(totalBytes);
        long longValue = Double.valueOf((com.ss.android.downloadlib.r.ux.c(this.f48739c.getId()) + 1.0d) * totalBytes).longValue() - this.f48739c.getCurBytes();
        long w3 = a.w(0L);
        if (k.bk() != null) {
            k.bk().ux();
        }
        xv.c();
        xv.w();
        if (com.ss.android.downloadlib.r.ux.r(c4.fz())) {
            xv.c(k.getContext());
        }
        long w4 = a.w(0L);
        if (w4 >= longValue) {
            c4.a("1");
            gd.c().c(c4);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(w4 - w3));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            com.ss.android.downloadlib.sr.c.c().c("cleanspace_download_after_quite_clean", jSONObject, c4);
            Downloader.getInstance(k.getContext()).restart(this.f48739c.getId());
        } else if (k.bk() != null) {
            c4.sr(false);
            sr.c().c(c4.c(), new ux() { // from class: com.ss.android.downloadlib.addownload.xv.w.1
            });
            if (k.bk().c(this.f48739c.getId(), this.f48739c.getUrl(), true, longValue)) {
                c4.ux(true);
            }
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("show_dialog_result", 3);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            com.ss.android.downloadlib.sr.c.c().c("cleanspace_window_show", jSONObject2, c4);
        }
    }
}
