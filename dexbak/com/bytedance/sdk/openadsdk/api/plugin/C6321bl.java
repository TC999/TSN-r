package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.api.plugin.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6321bl {

    /* renamed from: a */
    private long f22442a;

    /* renamed from: bl */
    private long f22443bl;

    /* renamed from: ok */
    private String f22444ok;

    /* renamed from: s */
    private Map<String, Long> f22445s = new HashMap();

    private C6321bl(String str, long j) {
        this.f22444ok = str;
        this.f22442a = j;
        this.f22443bl = j;
    }

    /* renamed from: ok */
    public static C6321bl m36604ok(String str) {
        return new C6321bl(str, SystemClock.elapsedRealtime());
    }

    /* renamed from: a */
    public long m36606a(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f22443bl;
        this.f22443bl = SystemClock.elapsedRealtime();
        this.f22445s.put(str, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    /* renamed from: ok */
    public long m36605ok() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f22442a;
        this.f22445s.put(this.f22444ok, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    /* renamed from: a */
    public long m36607a() {
        return this.f22442a;
    }

    /* renamed from: ok */
    public void m36603ok(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.f22445s.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
