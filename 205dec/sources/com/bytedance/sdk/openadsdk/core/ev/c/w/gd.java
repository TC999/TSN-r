package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;
import java.util.Map;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")

    /* renamed from: c  reason: collision with root package name */
    private me f33461c;
    @com.bytedance.sdk.component.p.w.c(c = "dpa_tag")
    private String sr;
    @com.bytedance.sdk.component.p.w.c(c = "context")

    /* renamed from: w  reason: collision with root package name */
    private Context f33462w;
    @com.bytedance.sdk.component.p.w.c(c = "event_tag")
    private String xv;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        if (!c()) {
            cVar.w(map2);
            return true;
        } else if (new com.bytedance.sdk.openadsdk.core.ev.c.c.c.w(new com.bytedance.sdk.openadsdk.core.ev.c.c.c.sr(new com.bytedance.sdk.openadsdk.core.ev.c.c.c.ux(this.f33461c, this.f33462w, this.xv, this.sr), this.f33461c), this.f33462w, this.f33461c, this.xv).c(new HashMap())) {
            cVar.c(map2);
            return false;
        } else {
            cVar.w(map2);
            return false;
        }
    }

    private boolean c() {
        return (this.f33461c == null || this.f33462w == null) ? false : true;
    }
}
