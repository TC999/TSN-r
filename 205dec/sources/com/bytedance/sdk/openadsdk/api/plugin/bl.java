package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    private long f31446a;
    private long bl;
    private String ok;

    /* renamed from: s  reason: collision with root package name */
    private Map<String, Long> f31447s = new HashMap();

    private bl(String str, long j4) {
        this.ok = str;
        this.f31446a = j4;
        this.bl = j4;
    }

    public static bl ok(String str) {
        return new bl(str, SystemClock.elapsedRealtime());
    }

    public long a(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.bl;
        this.bl = SystemClock.elapsedRealtime();
        this.f31447s.put(str, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public long ok() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f31446a;
        this.f31447s.put(this.ok, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public long a() {
        return this.f31446a;
    }

    public void ok(JSONObject jSONObject, long j4) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.f31447s.entrySet()) {
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
