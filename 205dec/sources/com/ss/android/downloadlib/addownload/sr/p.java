package com.ss.android.downloadlib.addownload.sr;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class p implements gd {
    private boolean w(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.ss.android.downloadlib.addownload.sr.gd
    public boolean c(com.ss.android.downloadad.api.c.w wVar, int i4, ev evVar) {
        if (wVar != null && w(wVar.fz())) {
            if (System.currentTimeMillis() - wVar.au() <= c(wVar.fz())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "mistake_click");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                com.ss.android.downloadlib.sr.c.c().c("pause_optimise", jSONObject, wVar);
                return true;
            }
            return false;
        }
        return false;
    }

    private long c(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("pause_optimise_mistake_click_interval", 300);
    }
}
