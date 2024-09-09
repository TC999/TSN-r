package com.bytedance.sdk.gromore.c.c.sr;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fp implements com.bytedance.sdk.gromore.c.c.ux {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.c.w.c f31178c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.fz.c.w.c.xv f31179w;
    private com.bytedance.msdk.core.admanager.ev xv;

    public fp(Context context, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar) {
        this.f31178c = cVar;
        if (cVar != null) {
            this.xv = new com.bytedance.msdk.core.admanager.ev(context, cVar.f());
            this.f31179w = xvVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux
    public void c() {
        this.xv.c(new com.bytedance.msdk.api.c.w(5, this.f31178c.w()), new com.bytedance.msdk.api.sr.c.r.ux() { // from class: com.bytedance.sdk.gromore.c.c.sr.fp.1
            @Override // com.bytedance.msdk.api.sr.c.r.ux
            public void c(List<com.bytedance.msdk.api.sr.c.r.c> list) {
                if (list != null) {
                    if (fp.this.f31179w != null) {
                        LinkedList linkedList = new LinkedList();
                        for (com.bytedance.msdk.api.sr.c.r.c cVar : list) {
                            linkedList.add(new k(fp.this.xv, cVar));
                        }
                        fp.this.f31179w.onFeedAdLoad(linkedList);
                        return;
                    }
                    return;
                }
                c(new com.bytedance.msdk.api.c(80001, "list is null"));
            }

            @Override // com.bytedance.msdk.api.sr.c.r.ux
            public void c(com.bytedance.msdk.api.c cVar) {
                if (cVar == null || fp.this.f31179w == null) {
                    return;
                }
                fp.this.f31179w.onError(cVar.f27444c, cVar.f27445w);
            }
        });
    }
}
