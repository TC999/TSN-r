package com.ss.android.downloadlib.addownload.bl;

import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.downloadlib.addownload.a.q;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements Runnable {
    private DownloadInfo ok;

    public a(DownloadInfo downloadInfo) {
        this.ok = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.downloadad.api.ok.a ok;
        if (this.ok == null || (ok = kf.ok().ok(this.ok)) == null) {
            return;
        }
        com.ss.android.downloadlib.s.ok.ok().ok("cleanspace_task", ok);
        double totalBytes = this.ok.getTotalBytes();
        Double.isNaN(totalBytes);
        long longValue = Double.valueOf((com.ss.android.downloadlib.h.n.ok(this.ok.getId()) + 1.0d) * totalBytes).longValue() - this.ok.getCurBytes();
        long a4 = j.a(0L);
        if (r.z() != null) {
            r.z().n();
        }
        bl.ok();
        bl.a();
        if (com.ss.android.downloadlib.h.n.h(ok.zz())) {
            bl.ok(r.getContext());
        }
        long a5 = j.a(0L);
        if (a5 >= longValue) {
            ok.j("1");
            q.ok().ok(ok);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(a5 - a4));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            com.ss.android.downloadlib.s.ok.ok().ok("cleanspace_download_after_quite_clean", jSONObject, ok);
            Downloader.getInstance(r.getContext()).restart(this.ok.getId());
        } else if (r.z() != null) {
            ok.s(false);
            s.ok().ok(ok.ok(), new n() { // from class: com.ss.android.downloadlib.addownload.bl.a.1
            });
            if (r.z().ok(this.ok.getId(), this.ok.getUrl(), true, longValue)) {
                ok.n(true);
            }
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("show_dialog_result", 3);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            com.ss.android.downloadlib.s.ok.ok().ok("cleanspace_window_show", jSONObject2, ok);
        }
    }
}
