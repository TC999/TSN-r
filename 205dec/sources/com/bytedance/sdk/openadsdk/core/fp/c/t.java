package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class t extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<xk> f33577c;

    /* renamed from: w  reason: collision with root package name */
    private final String f33578w;

    public t(xk xkVar, String str) {
        this.f33577c = new WeakReference<>(xkVar);
        this.f33578w = str;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, xk xkVar) {
        sVar.c("interactiveStart", (com.bytedance.sdk.component.c.ux<?, ?>) new t(xkVar, "interactiveStart"));
        sVar.c("interactiveFinish", (com.bytedance.sdk.component.c.ux<?, ?>) new t(xkVar, "interactiveFinish"));
        sVar.c("interactiveEnd", (com.bytedance.sdk.component.c.ux<?, ?>) new t(xkVar, "interactiveEnd"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        char c4;
        JSONObject jSONObject2 = new JSONObject();
        if (this.f33577c.get() == null) {
            return jSONObject2;
        }
        xk xkVar = this.f33577c.get();
        com.bytedance.sdk.openadsdk.core.u.me f4 = xkVar.f();
        String str = this.f33578w;
        str.hashCode();
        int i4 = -1;
        boolean z3 = true;
        switch (str.hashCode()) {
            case -1055587680:
                if (str.equals("interactiveStart")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case 803356313:
                if (str.equals("interactiveEnd")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1254561301:
                if (str.equals("interactiveFinish")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        switch (c4) {
            case 0:
                xkVar.fp();
                break;
            case 1:
                xkVar.ia();
                break;
            case 2:
                try {
                    if (jSONObject.optInt("finish", 1) != 1) {
                        z3 = false;
                    }
                    int optInt = jSONObject.optInt("reduce_duration", -1);
                    int ku = f4 != null ? f4.ku() : 0;
                    if (optInt >= 0 && ku >= 0) {
                        optInt = Math.min(optInt, ku);
                    } else if (optInt < 0) {
                        optInt = ku >= 0 ? ku : 0;
                    }
                    if (m.ux(f4)) {
                        optInt = 0;
                    }
                    if (z3) {
                        xkVar.sr(optInt);
                        i4 = 0;
                    }
                    jSONObject2.put("code", i4);
                    jSONObject2.put("reduce_duration", optInt);
                    break;
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    break;
                }
        }
        return jSONObject2;
    }
}
