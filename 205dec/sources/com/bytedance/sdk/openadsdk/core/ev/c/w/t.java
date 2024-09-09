package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class t implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")

    /* renamed from: c  reason: collision with root package name */
    private me f33510c;
    @com.bytedance.sdk.component.p.w.c(c = "ad_extra_data")
    private JSONObject sr;
    @com.bytedance.sdk.component.p.w.c(c = "event_tag")

    /* renamed from: w  reason: collision with root package name */
    private String f33511w;
    @com.bytedance.sdk.component.p.w.c(c = "label")
    private String xv;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        if (c()) {
            cVar.w(map2);
            return true;
        }
        JSONObject jSONObject = this.sr;
        if (jSONObject == null) {
            com.bytedance.sdk.openadsdk.core.a.xv.w(this.f33510c, this.f33511w, this.xv);
        } else {
            com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f33510c, this.f33511w, this.xv, jSONObject);
        }
        cVar.c(map2);
        return true;
    }

    private boolean c() {
        return (TextUtils.isEmpty(this.f33511w) || TextUtils.isEmpty(this.xv)) ? false : true;
    }
}
