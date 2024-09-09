package com.ss.android.downloadlib.bl;

import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n implements com.ss.android.socialbase.downloader.s.bl {
    @Override // com.ss.android.socialbase.downloader.s.bl
    public void a(int i4, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.ok.a ok;
        DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(i4);
        if (downloadInfo == null || (ok = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.s.ok.ok().ok(str, jSONObject, ok);
    }

    @Override // com.ss.android.socialbase.downloader.s.bl
    public void ok(int i4, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.ok.a ok;
        DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(i4);
        if (downloadInfo == null || (ok = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = j.ok(jSONObject);
            com.ss.android.downloadlib.ok.ok(jSONObject, downloadInfo);
            j.ok(jSONObject, "model_id", Long.valueOf(ok.a()));
        }
        com.ss.android.downloadlib.s.ok.ok().a(str, jSONObject, ok);
    }
}
