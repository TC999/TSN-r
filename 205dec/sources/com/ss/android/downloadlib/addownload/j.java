package com.ss.android.downloadlib.addownload;

import com.ss.android.socialbase.downloader.downloader.td;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class j implements td {
    @Override // com.ss.android.socialbase.downloader.downloader.td
    public void ok(DownloadInfo downloadInfo, int i4, int i5) {
        com.ss.android.downloadad.api.ok.a ok = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i5));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i4));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("pause_reserve_wifi", jSONObject, ok);
    }
}
