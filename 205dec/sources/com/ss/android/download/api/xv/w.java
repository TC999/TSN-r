package com.ss.android.download.api.xv;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {
    public static long c(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static boolean c(com.ss.android.socialbase.downloader.r.c cVar, String str) {
        if (cVar == null || cVar.c("apk_update_handler_enable", 1) != 1) {
            return false;
        }
        return "application/ttpatch".equals(str);
    }

    public static JSONObject c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return jSONObject2;
    }

    @NonNull
    public static JSONObject c(JSONObject jSONObject) {
        return c(jSONObject, new JSONObject());
    }

    @NonNull
    public static JSONObject c(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null && jSONObjectArr.length != 0) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    c(jSONObject2, jSONObject);
                }
            }
        }
        return jSONObject;
    }

    public static String c(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }
}
