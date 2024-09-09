package com.ss.android.downloadlib.addownload.s;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class k implements q {
    private boolean a(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.ss.android.downloadlib.addownload.s.q
    public boolean ok(com.ss.android.downloadad.api.ok.a aVar, int i4, p pVar) {
        if (aVar != null && a(aVar.zz())) {
            if (System.currentTimeMillis() - aVar.qx() <= ok(aVar.zz())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "mistake_click");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                com.ss.android.downloadlib.s.ok.ok().ok("pause_optimise", jSONObject, aVar);
                return true;
            }
            return false;
        }
        return false;
    }

    private long ok(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("pause_optimise_mistake_click_interval", 300);
    }
}
