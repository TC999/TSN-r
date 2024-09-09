package com.bytedance.sdk.openadsdk.core.component.splash.c.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.f;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.r;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.ux;
import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private r f32877c = new r();
    private int xv = 3;

    /* renamed from: w  reason: collision with root package name */
    private final ck f32878w = ls.c();

    public void c(final ux uxVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w<f, r> wVar) {
        if (this.f32878w == null || uxVar == null) {
            return;
        }
        this.f32877c.w(false);
        this.f32878w.c(uxVar.sr(), uxVar.ux(), this.xv, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.c.c.xv.1
            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                xv.this.f32877c.w(i4);
                if (TextUtils.isEmpty(str)) {
                    str = "load ad error";
                }
                xv.this.f32877c.c(str);
                wVar.c(xv.this.f32877c);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                if (cVar == null || cVar.w() == null) {
                    xv.this.f32877c.w(r.vc);
                    xv.this.f32877c.c(r.up);
                    wVar.c(xv.this.f32877c);
                    return;
                }
                f fVar = new f(cVar, false);
                fVar.w(wVar2.f());
                fVar.xv(wVar2.r());
                fVar.sr(wVar2.ev());
                fVar.ux(wVar2.gd());
                fVar.c(uxVar.c());
                fVar.c(uxVar.xv());
                wVar.w(fVar);
            }
        });
    }
}
