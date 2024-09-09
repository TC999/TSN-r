package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ok;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")

    /* renamed from: c  reason: collision with root package name */
    private me f33471c;
    @com.bytedance.sdk.component.p.w.c(c = "event_tag")
    private String sr;
    @com.bytedance.sdk.component.p.w.c(c = "wc_miniapp_info")
    private JSONObject ux;
    @com.bytedance.sdk.component.p.w.c(c = "context")

    /* renamed from: w  reason: collision with root package name */
    private Context f33472w;
    @com.bytedance.sdk.component.p.w.c(c = "convert_from_landing_page")
    private boolean xv;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        if (!c()) {
            cVar.w(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ev.c.c.c.gd gdVar = new com.bytedance.sdk.openadsdk.core.ev.c.c.c.gd(ok.c(this.ux), this.f33472w, this.xv, this.sr);
        gdVar.c(this.f33471c);
        if (gdVar.c(new HashMap())) {
            cVar.c(map2);
        } else {
            cVar.w(map2);
        }
        return true;
    }

    private boolean c() {
        return (this.f33471c == null || this.f33472w == null || this.ux == null) ? false : true;
    }
}
