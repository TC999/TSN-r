package com.ss.android.downloadlib.h;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class r {
    public static void a(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.r x3 = com.ss.android.downloadlib.addownload.r.x();
        if (x3 != null) {
            x3.ok(3, str, str2, jSONObject);
        }
    }

    public static void bl(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.r x3 = com.ss.android.downloadlib.addownload.r.x();
        if (x3 != null) {
            x3.ok(6, str, str2, jSONObject);
        }
    }

    public static void ok(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.r x3 = com.ss.android.downloadlib.addownload.r.x();
        if (x3 != null) {
            x3.ok(2, str, str2, jSONObject);
        }
    }

    public static void ok(String str, String str2) {
        bl(str, str2, null);
    }

    public static void ok(String str) {
        bl(null, str, null);
    }
}
