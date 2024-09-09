package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private String f31494c;
    private Map<String, Long> sr = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    private long f31495w;
    private long xv;

    private ux(String str, long j4) {
        this.f31494c = str;
        this.f31495w = j4;
        this.xv = j4;
    }

    public static ux c(String str) {
        return new ux(str, SystemClock.elapsedRealtime());
    }

    public long w(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.xv;
        this.xv = SystemClock.elapsedRealtime();
        this.sr.put(str, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public long c() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f31495w;
        this.sr.put(this.f31494c, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void c(JSONObject jSONObject, long j4) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.sr.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j4) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
