package com.p521ss.android.downloadlib.addownload;

import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12518td;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12090j implements InterfaceC12518td {
    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12518td
    /* renamed from: ok */
    public void mo17627ok(DownloadInfo downloadInfo, int i, int i2) {
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18521ok("pause_reserve_wifi", jSONObject, m19315ok);
    }
}
