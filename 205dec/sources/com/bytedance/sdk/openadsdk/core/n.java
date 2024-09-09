package com.bytedance.sdk.openadsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    private String f33983c;
    private Map<String, Long> sr = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    private long f33984w;
    private long xv;

    private n(String str, long j4) {
        this.f33983c = str;
        this.f33984w = j4;
        this.xv = j4;
    }

    public static n c(String str) {
        return new n(str, SystemClock.elapsedRealtime());
    }

    public long w(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j4 = elapsedRealtime - this.xv;
        this.xv = elapsedRealtime;
        this.sr.put(str, Long.valueOf(j4));
        return j4;
    }

    public long c() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f33984w;
        this.sr.put(this.f33983c, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void c(String str, long j4) {
        this.sr.put(str, Long.valueOf(j4));
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

    public long w() {
        return SystemClock.elapsedRealtime() - this.f33984w;
    }

    public JSONObject c(long j4) {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject, j4);
        return jSONObject;
    }
}
