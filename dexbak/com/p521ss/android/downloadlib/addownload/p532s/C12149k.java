package com.p521ss.android.downloadlib.addownload.p532s;

import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.s.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12149k implements InterfaceC12156q {
    /* renamed from: a */
    private boolean m18894a(int i) {
        return C12534ok.m17599ok(i).m17593ok("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12156q
    /* renamed from: ok */
    public boolean mo18882ok(C11998a c11998a, int i, InterfaceC12155p interfaceC12155p) {
        if (c11998a != null && m18894a(c11998a.mo19285zz())) {
            if (System.currentTimeMillis() - c11998a.m19460qx() <= m18893ok(c11998a.mo19285zz())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "mistake_click");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                C12270ok.m18539ok().m18521ok("pause_optimise", jSONObject, c11998a);
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: ok */
    private long m18893ok(int i) {
        return C12534ok.m17599ok(i).m17593ok("pause_optimise_mistake_click_interval", 300);
    }
}
