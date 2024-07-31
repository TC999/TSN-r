package com.p521ss.android.downloadlib.addownload.p529bl;

import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12038q;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.bl.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RunnableC12047a implements Runnable {

    /* renamed from: ok */
    private DownloadInfo f34111ok;

    public RunnableC12047a(DownloadInfo downloadInfo) {
        this.f34111ok = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        final C11998a m19315ok;
        if (this.f34111ok == null || (m19315ok = C12032kf.m19324ok().m19315ok(this.f34111ok)) == null) {
            return;
        }
        C12270ok.m18539ok().m18526ok("cleanspace_task", m19315ok);
        double totalBytes = this.f34111ok.getTotalBytes();
        Double.isNaN(totalBytes);
        long longValue = Double.valueOf((C12201n.m18739ok(this.f34111ok.getId()) + 1.0d) * totalBytes).longValue() - this.f34111ok.getCurBytes();
        long m18808a = C12197j.m18808a(0L);
        if (C12128r.m18937z() != null) {
            C12128r.m18937z().m19643n();
        }
        C12049bl.m19257ok();
        C12049bl.m19258a();
        if (C12201n.m18744h(m19315ok.mo19285zz())) {
            C12049bl.m19256ok(C12128r.getContext());
        }
        long m18808a2 = C12197j.m18808a(0L);
        if (m18808a2 >= longValue) {
            m19315ok.m19492j("1");
            C12038q.m19278ok().m19277ok(m19315ok);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(m18808a2 - m18808a));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            C12270ok.m18539ok().m18521ok("cleanspace_download_after_quite_clean", jSONObject, m19315ok);
            Downloader.getInstance(C12128r.getContext()).restart(this.f34111ok.getId());
        } else if (C12128r.m18937z() != null) {
            m19315ok.m19450s(false);
            C12052s.m19245ok().m19241ok(m19315ok.mo19298ok(), new InterfaceC12050n() { // from class: com.ss.android.downloadlib.addownload.bl.a.1
            });
            if (C12128r.m18937z().m19641ok(this.f34111ok.getId(), this.f34111ok.getUrl(), true, longValue)) {
                m19315ok.m19475n(true);
            }
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("show_dialog_result", 3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            C12270ok.m18539ok().m18521ok("cleanspace_window_show", jSONObject2, m19315ok);
        }
    }
}
