package com.bytedance.sdk.openadsdk.core.fp.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private Context f33559c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.me f33560w;

    public k(Context context, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        this.f33559c = context;
        this.f33560w = meVar;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, Context context, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        sVar.c("getLiveSaasAuthStatus", (com.bytedance.sdk.component.c.ux<?, ?>) new k(context, meVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.c.f fVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.u.y yVar;
        com.bytedance.sdk.openadsdk.core.u.me meVar;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.f33559c == null) {
                this.f33559c = com.bytedance.sdk.openadsdk.core.ls.getContext();
            }
            com.bytedance.sdk.openadsdk.core.u.ys ysVar = null;
            if (jSONObject != null) {
                yVar = com.bytedance.sdk.openadsdk.core.u.y.c(jSONObject.optJSONObject("live_info"));
                JSONObject optJSONObject = jSONObject.optJSONObject(CampaignEx.JSON_KEY_DEEP_LINK_URL);
                if (optJSONObject != null) {
                    ysVar = new com.bytedance.sdk.openadsdk.core.u.ys(optJSONObject);
                }
            } else {
                yVar = null;
            }
            if (ysVar == null && (meVar = this.f33560w) != null) {
                ysVar = meVar.qu();
            }
            if (yVar == null) {
                yVar = this.f33560w.sk();
            }
            boolean z3 = true;
            jSONObject2.put("has_live_silent_auth", yVar != null && yVar.xv());
            jSONObject2.put("has_install_douyin", com.bytedance.sdk.openadsdk.core.live.sr.c.c(this.f33559c, ysVar));
            jSONObject2.put("has_live_authed", TTLiveCommerceHelper.getInstance().getLiveAuthStatus() == 2);
            boolean z4 = yVar != null && yVar.sr();
            if (z4) {
                if (TTLiveCommerceHelper.getInstance().getLiveSdkStatus() != 2) {
                    z3 = false;
                }
                z4 = z3;
            }
            jSONObject2.put("has_playable_auth_switch", z4);
            JSONObject jSONObject3 = new JSONObject();
            if (yVar != null) {
                jSONObject3.put("aweme_agreements", yVar.ux());
                jSONObject3.put("aweme_privacy", yVar.f());
            }
            jSONObject2.put("aweme_auth_protocol", jSONObject3);
            com.bytedance.sdk.component.utils.a.w("glsas", "hpas:  " + z4);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.f("glsas", "method:" + th.getMessage());
        }
        return jSONObject2;
    }
}
