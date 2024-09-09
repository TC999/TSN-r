package com.ss.android.downloadlib.addownload.w;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private static volatile ev f48706c;

    private ev() {
    }

    public static ev c() {
        if (f48706c == null) {
            synchronized (sr.class) {
                if (f48706c == null) {
                    f48706c = new ev();
                }
            }
        }
        return f48706c;
    }

    public void c(int i4, int i5, com.ss.android.downloadad.api.c.w wVar) {
        if (wVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(wVar.fz());
        if (c4.c("report_api_hijack", 0) == 0) {
            return;
        }
        int i6 = i5 - i4;
        if (i4 <= 0 || i6 <= c4.c("check_api_hijack_version_code_diff", 500)) {
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
        com.ss.android.downloadlib.sr.c.c().w("api_hijack", jSONObject, wVar);
    }
}
