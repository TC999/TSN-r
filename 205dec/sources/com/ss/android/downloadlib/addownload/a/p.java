package com.ss.android.downloadlib.addownload.a;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class p {
    private static volatile p ok;

    private p() {
    }

    public static p ok() {
        if (ok == null) {
            synchronized (s.class) {
                if (ok == null) {
                    ok = new p();
                }
            }
        }
        return ok;
    }

    public void ok(int i4, int i5, com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.h.ok ok2 = com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz());
        if (ok2.ok("report_api_hijack", 0) == 0) {
            return;
        }
        int i6 = i5 - i4;
        if (i4 <= 0 || i6 <= ok2.ok("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i6);
            jSONObject.put("installed_version_code", i5);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().a("api_hijack", jSONObject, aVar);
    }
}
