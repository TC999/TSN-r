package com.ss.android.downloadlib.r;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class k {
    public static void c(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.k ia = com.ss.android.downloadlib.addownload.k.ia();
        if (ia != null) {
            ia.c(2, str, str2, jSONObject);
        }
    }

    public static void w(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.k ia = com.ss.android.downloadlib.addownload.k.ia();
        if (ia != null) {
            ia.c(3, str, str2, jSONObject);
        }
    }

    public static void xv(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.k ia = com.ss.android.downloadlib.addownload.k.ia();
        if (ia != null) {
            ia.c(6, str, str2, jSONObject);
        }
    }

    public static void c(String str, String str2) {
        xv(str, str2, null);
    }

    public static void c(String str) {
        xv(null, str, null);
    }
}
