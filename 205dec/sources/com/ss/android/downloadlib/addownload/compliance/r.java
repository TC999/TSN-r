package com.ss.android.downloadlib.addownload.compliance;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class r {
    public static void c(String str, long j4) {
        com.ss.android.downloadlib.addownload.w.ux ux = com.ss.android.downloadlib.addownload.w.f.c().ux(j4);
        if (ux.ls()) {
            return;
        }
        ux.xv.setRefer(str);
        com.ss.android.downloadlib.sr.c.c().w("lp_app_dialog_click", ux);
    }

    public static void w(String str, long j4) {
        c(str, null, j4);
    }

    public static void c(String str, JSONObject jSONObject, long j4) {
        com.ss.android.downloadlib.sr.c.c().w(str, jSONObject, com.ss.android.downloadlib.addownload.w.f.c().ux(j4));
    }

    public static void c(String str, com.ss.android.downloadlib.addownload.w.ux uxVar) {
        com.ss.android.downloadlib.sr.c.c().w(str, uxVar);
    }

    public static void c(int i4, com.ss.android.downloadlib.addownload.w.ux uxVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i4));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().w("lp_compliance_error", jSONObject, uxVar);
    }

    public static void c(int i4, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i4));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().w("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.w.f.c().ux(j4));
    }
}
