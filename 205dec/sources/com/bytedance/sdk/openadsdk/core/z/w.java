package com.bytedance.sdk.openadsdk.core.z;

import com.bytedance.sdk.component.utils.a;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class w {

    /* renamed from: c  reason: collision with root package name */
    private boolean f35791c;

    public static w c(JSONObject jSONObject) {
        w wVar = new w();
        if (jSONObject != null) {
            wVar.c(jSONObject.optBoolean("sub_process", false));
        }
        return wVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sub_process", c());
        } catch (Exception e4) {
            a.xv("AppLiveConfig", e4);
        }
        return jSONObject.toString();
    }

    public boolean c() {
        return this.f35791c;
    }

    public void c(boolean z3) {
        this.f35791c = z3;
    }
}
