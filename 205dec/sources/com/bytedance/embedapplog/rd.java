package com.bytedance.embedapplog;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class rd {

    /* renamed from: c  reason: collision with root package name */
    final String f26788c;

    /* renamed from: f  reason: collision with root package name */
    final Integer f26789f;

    /* renamed from: r  reason: collision with root package name */
    final Long f26790r;
    final Long sr;
    final Long ux;

    /* renamed from: w  reason: collision with root package name */
    final String f26791w;
    final Boolean xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rd(String str, String str2, Boolean bool, Long l4, Long l5, Integer num, Long l6) {
        this.f26788c = str;
        this.f26791w = str2;
        this.xv = bool;
        this.sr = l4;
        this.ux = l5;
        this.f26789f = num;
        this.f26790r = l6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Map<String, String> c() {
        HashMap hashMap = new HashMap();
        gp.c(hashMap, "id", this.f26788c);
        gp.c(hashMap, "req_id", this.f26791w);
        gp.c(hashMap, "is_track_limited", String.valueOf(this.xv));
        gp.c(hashMap, "take_ms", String.valueOf(this.sr));
        gp.c(hashMap, "time", String.valueOf(this.ux));
        gp.c(hashMap, "query_times", String.valueOf(this.f26789f));
        gp.c(hashMap, "hw_id_version_code", String.valueOf(this.f26790r));
        return hashMap;
    }

    public String toString() {
        return w().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        gp.c(jSONObject, "id", this.f26788c);
        gp.c(jSONObject, "req_id", this.f26791w);
        gp.c(jSONObject, "is_track_limited", this.xv);
        gp.c(jSONObject, "take_ms", this.sr);
        gp.c(jSONObject, "time", this.ux);
        gp.c(jSONObject, "query_times", this.f26789f);
        gp.c(jSONObject, "hw_id_version_code", this.f26790r);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @AnyThread
    public static rd c(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new rd(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e4) {
            be.c(e4);
            return null;
        }
    }
}
