package com.bytedance.sdk.openadsdk.core.bk;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.ls;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    public static boolean c(String str) {
        String w3;
        int tl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            w3 = ba.c("fsswiper_freq").w(str, "");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(w3) && (tl = ls.w().tl()) > 0) {
            return new JSONObject(w3).optInt(c(), 0) >= tl;
        }
        return false;
    }

    public static void w(String str) {
        xv(str);
    }

    private static void xv(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.f.c c4 = ba.c("fsswiper_freq");
        try {
            String w3 = c4.w(str, "");
            if (TextUtils.isEmpty(w3)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(w3);
            }
            String c5 = c();
            int optInt = jSONObject.optInt(c5, 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(c5, optInt + 1);
            c4.c(str, jSONObject2.toString());
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String c() {
        try {
            return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        } catch (Exception unused) {
            return null;
        }
    }
}
