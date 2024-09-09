package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")

    /* renamed from: c  reason: collision with root package name */
    private me f33440c;
    @com.bytedance.sdk.component.p.w.c(c = "is_market_covert")
    private boolean ev;
    @com.bytedance.sdk.component.p.w.c(c = "convert_from_landing_page")

    /* renamed from: f  reason: collision with root package name */
    private boolean f33441f;
    @com.bytedance.sdk.component.p.w.c(c = "convert_from_downloader")

    /* renamed from: r  reason: collision with root package name */
    private boolean f33442r;
    @com.bytedance.sdk.component.p.w.c(c = CampaignEx.JSON_KEY_DEEP_LINK_URL)
    private JSONObject sr;
    @com.bytedance.sdk.component.p.w.c(c = "app_info")
    private JSONObject ux;
    @com.bytedance.sdk.component.p.w.c(c = "context")

    /* renamed from: w  reason: collision with root package name */
    private Context f33443w;
    @com.bytedance.sdk.component.p.w.c(c = "event_tag")
    private String xv;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        com.bytedance.sdk.openadsdk.core.ev.c.c.c.r rVar;
        JSONObject jSONObject = this.ux;
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.core.u.sr w3 = com.bytedance.sdk.openadsdk.core.w.w(jSONObject);
            com.bytedance.sdk.openadsdk.core.ev.c.c.c.ev evVar = new com.bytedance.sdk.openadsdk.core.ev.c.c.c.ev(w3, this.f33443w);
            evVar.c(this.f33440c);
            evVar.c(this.xv);
            rVar = new com.bytedance.sdk.openadsdk.core.ev.c.c.c.r(evVar, w3, this.f33443w, this.xv);
            rVar.c(this.f33440c);
            rVar.c(this.f33441f);
        } else {
            rVar = null;
        }
        com.bytedance.sdk.openadsdk.core.ev.c.c.c.r rVar2 = rVar;
        JSONObject jSONObject2 = this.sr;
        if (jSONObject2 == null) {
            cVar.w(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ev.c.c.c.xv xvVar = new com.bytedance.sdk.openadsdk.core.ev.c.c.c.xv(rVar2, this.f33440c, this.xv, new com.bytedance.sdk.openadsdk.core.u.ys(jSONObject2), this.f33443w);
        xvVar.w(this.f33442r);
        xvVar.c(this.f33441f);
        xvVar.xv(this.ev);
        if (xvVar.c(new HashMap())) {
            cVar.c(map2);
        } else {
            cVar.w(map2);
        }
        return true;
    }
}
