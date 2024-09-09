package com.bytedance.sdk.gromore.c.c.c;

import android.content.Context;
import android.view.View;
import com.bytedance.msdk.core.admanager.gd;
import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements com.bytedance.sdk.gromore.c.c.ux {

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.mediation.c.w.c f31146c;

    /* renamed from: w  reason: collision with root package name */
    private final sr f31147w;
    private gd xv;

    public xv(Context context, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, sr srVar) {
        this.f31146c = cVar;
        this.f31147w = srVar;
        if (cVar != null) {
            this.xv = new gd(context, cVar.f());
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux
    public void c() {
        final com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.w p3;
        com.bytedance.msdk.api.c.w wVar = new com.bytedance.msdk.api.c.w(1, this.f31146c.w());
        if (this.f31146c.c() != null && (p3 = this.f31146c.c().p()) != null) {
            this.xv.c(new com.bytedance.msdk.api.sr.c.c.sr() { // from class: com.bytedance.sdk.gromore.c.c.c.xv.1
                @Override // com.bytedance.msdk.api.sr.c.c.sr
                public View c(com.bytedance.msdk.api.sr.c.c.xv xvVar) {
                    if (xvVar != null) {
                        return p3.c(new r(xvVar));
                    }
                    return null;
                }
            });
        }
        this.xv.c(wVar, new com.bytedance.msdk.api.sr.c.c.w() { // from class: com.bytedance.sdk.gromore.c.c.c.xv.2
            @Override // com.bytedance.msdk.api.sr.c.c.w
            public void c(com.bytedance.msdk.api.c cVar) {
                if (xv.this.f31147w != null) {
                    xv.this.f31147w.onError(cVar.f27444c, cVar.f27445w);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.c.w
            public void c() {
                if (xv.this.f31147w != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new c(xv.this.xv));
                    xv.this.f31147w.onNativeExpressAdLoad(arrayList);
                }
            }
        });
    }
}
