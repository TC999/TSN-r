package com.p521ss.android.downloadlib.p533bl;

import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12238ok;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p557s.InterfaceC12722bl;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.bl.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12173n implements InterfaceC12722bl {
    @Override // com.p521ss.android.socialbase.downloader.p557s.InterfaceC12722bl
    /* renamed from: a */
    public void mo16495a(int i, String str, JSONObject jSONObject) {
        C11998a m19315ok;
        DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo)) == null) {
            return;
        }
        C12270ok.m18539ok().m18521ok(str, jSONObject, m19315ok);
    }

    @Override // com.p521ss.android.socialbase.downloader.p557s.InterfaceC12722bl
    /* renamed from: ok */
    public void mo16494ok(int i, String str, JSONObject jSONObject) {
        C11998a m19315ok;
        DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = C12197j.m18780ok(jSONObject);
            C12238ok.m18610ok(jSONObject, downloadInfo);
            C12197j.m18778ok(jSONObject, "model_id", Long.valueOf(m19315ok.mo19309a()));
        }
        C12270ok.m18539ok().m18540a(str, jSONObject, m19315ok);
    }
}
