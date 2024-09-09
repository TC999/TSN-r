package com.bytedance.sdk.openadsdk.core.ls;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f33879c;

    public f(JSONObject jSONObject) {
        this.f33879c = jSONObject;
    }

    public int c() {
        JSONObject jSONObject = this.f33879c;
        if (jSONObject != null) {
            return jSONObject.optInt("code", -1);
        }
        return -1;
    }

    @NonNull
    public String toString() {
        JSONObject jSONObject = this.f33879c;
        return jSONObject != null ? jSONObject.toString() : "pitaya error is null";
    }
}
