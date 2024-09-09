package com.bytedance.sdk.openadsdk.core.ev.c.c.c;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ok;
import com.bytedance.sdk.openadsdk.core.w.c.w.p;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd implements com.bytedance.sdk.openadsdk.core.ev.c.c.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ev.c.c.c f33397c;

    /* renamed from: f  reason: collision with root package name */
    private ok f33398f;
    private boolean sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private me f33399w;
    private Context xv;

    public gd(ok okVar, Context context, boolean z3, String str) {
        this.f33398f = okVar;
        this.xv = context;
        this.sr = z3;
        this.ux = str;
    }

    public void c(me meVar) {
        this.f33399w = meVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c
    public boolean c(final Map<String, Object> map) {
        boolean c4 = p.c() ? new p(this.f33399w, this.xv).c(this.ux).w(this.sr).c(new p.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.gd.1
            @Override // com.bytedance.sdk.openadsdk.core.w.c.w.p.c
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.w.c.w.p.c
            public void w() {
                if (gd.this.f33397c != null) {
                    gd.this.f33397c.c(map);
                }
            }
        }) : false;
        p.c(false);
        if (c4) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar = this.f33397c;
        return cVar != null && cVar.c(map);
    }
}
