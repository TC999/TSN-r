package com.bytedance.sdk.openadsdk.core.w.c.w;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.w.c.w.sr;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.sdk.openadsdk.core.w.c.c {

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.w.sr f35350f;
    private String ux;

    public xv() {
    }

    public xv(me meVar, Context context, com.bytedance.sdk.openadsdk.core.w.sr srVar) {
        this.f35278c = meVar;
        this.f35279w = context;
        this.f35350f = srVar;
    }

    public void c(String str) {
        this.ux = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(final Map<String, Object> map) {
        if (com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f35278c) || com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f35278c) || !sr.c(this.f35278c, this.f35279w)) {
            return false;
        }
        return new sr(this.f35278c, this.f35279w).c(this.ux).c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.xv.1
            @Override // com.bytedance.sdk.openadsdk.core.w.c.w.sr.c
            public void c() {
                try {
                    if (xv.this.f35350f == null || ((com.bytedance.sdk.openadsdk.core.w.c.c.w) xv.this.f35350f.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(map)) {
                        return;
                    }
                    ((com.bytedance.sdk.openadsdk.core.w.c.xv.xv) xv.this.f35350f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.xv.class)).c(map);
                    ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) xv.this.f35350f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c(map);
                    ((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) xv.this.f35350f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class)).c(map);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
