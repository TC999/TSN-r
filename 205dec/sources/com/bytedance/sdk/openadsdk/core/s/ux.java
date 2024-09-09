package com.bytedance.sdk.openadsdk.core.s;

import com.bytedance.sdk.openadsdk.core.xk;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements com.bytedance.sdk.openadsdk.bk.xv {

    /* renamed from: c  reason: collision with root package name */
    xk f34525c;

    public ux(xk xkVar) {
        this.f34525c = xkVar;
    }

    @Override // com.bytedance.sdk.openadsdk.bk.xv
    public void c(String str, JSONObject jSONObject) {
        xk xkVar = this.f34525c;
        if (xkVar != null) {
            xkVar.c(str, jSONObject);
        }
    }
}
