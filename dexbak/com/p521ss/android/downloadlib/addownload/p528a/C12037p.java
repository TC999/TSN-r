package com.p521ss.android.downloadlib.addownload.p528a;

import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.a.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12037p {

    /* renamed from: ok */
    private static volatile C12037p f34089ok;

    private C12037p() {
    }

    /* renamed from: ok */
    public static C12037p m19282ok() {
        if (f34089ok == null) {
            synchronized (C12042s.class) {
                if (f34089ok == null) {
                    f34089ok = new C12037p();
                }
            }
        }
        return f34089ok;
    }

    /* renamed from: ok */
    public void m19281ok(int i, int i2, C11998a c11998a) {
        if (c11998a == null) {
            return;
        }
        C12534ok m17599ok = C12534ok.m17599ok(c11998a.mo19285zz());
        if (m17599ok.m17593ok("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= m17599ok.m17593ok("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i3);
            jSONObject.put("installed_version_code", i2);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18540a("api_hijack", jSONObject, c11998a);
    }
}
