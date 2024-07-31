package com.p521ss.android.download.api.p523bl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.download.api.bl.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C11951a {
    /* renamed from: ok */
    public static long m19662ok(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    /* renamed from: ok */
    public static boolean m19664ok(C12534ok c12534ok, String str) {
        if (c12534ok == null || c12534ok.m17593ok("apk_update_handler_enable", 1) != 1) {
            return false;
        }
        return "application/ttpatch".equals(str);
    }

    /* renamed from: ok */
    public static JSONObject m19661ok(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    @NonNull
    /* renamed from: ok */
    public static JSONObject m19663ok(JSONObject jSONObject) {
        return m19661ok(jSONObject, new JSONObject());
    }

    @NonNull
    /* renamed from: ok */
    public static JSONObject m19659ok(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null && jSONObjectArr.length != 0) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    m19661ok(jSONObject2, jSONObject);
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: ok */
    public static String m19660ok(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }
}
