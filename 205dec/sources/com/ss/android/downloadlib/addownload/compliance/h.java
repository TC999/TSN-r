package com.ss.android.downloadlib.addownload.compliance;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {
    public static void a(String str, long j4) {
        ok(str, null, j4);
    }

    public static void ok(String str, long j4) {
        com.ss.android.downloadlib.addownload.a.n n4 = com.ss.android.downloadlib.addownload.a.kf.ok().n(j4);
        if (n4.y()) {
            return;
        }
        n4.bl.setRefer(str);
        com.ss.android.downloadlib.s.ok.ok().a("lp_app_dialog_click", n4);
    }

    public static void ok(String str, JSONObject jSONObject, long j4) {
        com.ss.android.downloadlib.s.ok.ok().a(str, jSONObject, com.ss.android.downloadlib.addownload.a.kf.ok().n(j4));
    }

    public static void ok(String str, com.ss.android.downloadlib.addownload.a.n nVar) {
        com.ss.android.downloadlib.s.ok.ok().a(str, nVar);
    }

    public static void ok(int i4, com.ss.android.downloadlib.addownload.a.n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i4));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().a("lp_compliance_error", jSONObject, nVar);
    }

    public static void ok(int i4, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i4));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().a("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.a.kf.ok().n(j4));
    }
}
