package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.util.Map;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "type")

    /* renamed from: c  reason: collision with root package name */
    private String f33524c;
    @com.bytedance.sdk.component.p.w.c(c = EventMonitor.EVENT_EXTRA)

    /* renamed from: w  reason: collision with root package name */
    private String f33525w;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        if (c()) {
            cVar.w(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.ys.1
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(ys.this.f33524c).w(ys.this.f33525w);
            }
        }, this.f33524c);
        cVar.c(map2);
        return true;
    }

    private boolean c() {
        return (TextUtils.isEmpty(this.f33524c) || TextUtils.isEmpty(this.f33525w)) ? false : true;
    }
}
