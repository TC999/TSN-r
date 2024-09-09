package com.bytedance.sdk.component.c;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class fp {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f29660c = new ConcurrentHashMap();

    private fp() {
    }

    public static fp c() {
        return new fp();
    }

    public String w() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.f29660c.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public fp c(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f29660c.put(str, obj);
        }
        return this;
    }
}
