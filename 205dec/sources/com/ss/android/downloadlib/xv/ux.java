package com.ss.android.downloadlib.xv;

import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux implements com.ss.android.socialbase.downloader.sr.xv {
    @Override // com.ss.android.socialbase.downloader.sr.xv
    public void c(int i4, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.c.w c4;
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(i4);
        if (downloadInfo == null || (c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = a.c(jSONObject);
            com.ss.android.downloadlib.c.c(jSONObject, downloadInfo);
            a.c(jSONObject, "model_id", Long.valueOf(c4.w()));
        }
        com.ss.android.downloadlib.sr.c.c().w(str, jSONObject, c4);
    }

    @Override // com.ss.android.socialbase.downloader.sr.xv
    public void w(int i4, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.c.w c4;
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(i4);
        if (downloadInfo == null || (c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.sr.c.c().c(str, jSONObject, c4);
    }
}
