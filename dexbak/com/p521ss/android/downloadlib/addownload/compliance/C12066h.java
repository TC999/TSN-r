package com.p521ss.android.downloadlib.addownload.compliance;

import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ss.android.downloadlib.addownload.compliance.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12066h {
    /* renamed from: a */
    public static void m19213a(String str, long j) {
        m19208ok(str, null, j);
    }

    /* renamed from: ok */
    public static void m19210ok(String str, long j) {
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        if (m19325n.m19287y()) {
            return;
        }
        m19325n.f34077bl.setRefer(str);
        C12270ok.m18539ok().m18541a("lp_app_dialog_click", m19325n);
    }

    /* renamed from: ok */
    public static void m19208ok(String str, JSONObject jSONObject, long j) {
        C12270ok.m18539ok().m18540a(str, jSONObject, C12032kf.m19324ok().m19325n(j));
    }

    /* renamed from: ok */
    public static void m19209ok(String str, C12035n c12035n) {
        C12270ok.m18539ok().m18541a(str, c12035n);
    }

    /* renamed from: ok */
    public static void m19211ok(int i, C12035n c12035n) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18540a("lp_compliance_error", jSONObject, c12035n);
    }

    /* renamed from: ok */
    public static void m19212ok(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18540a("lp_compliance_error", jSONObject, C12032kf.m19324ok().m19325n(j));
    }
}
