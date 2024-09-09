package com.bytedance.sdk.openadsdk.core.ev.c.c.c;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.w.c.w.sr;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements com.bytedance.sdk.openadsdk.core.ev.c.c.c {

    /* renamed from: c  reason: collision with root package name */
    private Context f33410c;
    private com.bytedance.sdk.openadsdk.core.ev.c.c.c sr;

    /* renamed from: w  reason: collision with root package name */
    private me f33411w;
    private String xv;

    public w(com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar, Context context, me meVar, String str) {
        this.sr = cVar;
        this.f33410c = context;
        this.f33411w = meVar;
        this.xv = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c
    public boolean c(final Map<String, Object> map) {
        if (!com.bytedance.sdk.openadsdk.core.w.c.w.sr.c(this.f33411w, this.f33410c)) {
            com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar = this.sr;
            return cVar != null && cVar.c(map);
        } else if (com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f33411w)) {
            com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar2 = this.sr;
            return cVar2 != null && cVar2.c(map);
        } else if (com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f33411w)) {
            com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar3 = this.sr;
            return cVar3 != null && cVar3.c(map);
        } else {
            new com.bytedance.sdk.openadsdk.core.w.c.w.sr(this.f33411w, this.f33410c).c(this.xv).c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.w.1
                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.sr.c
                public void c() {
                    w.this.sr.c(map);
                }
            });
            return true;
        }
    }
}
