package com.bytedance.sdk.gromore.c.c.sr;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class t implements com.bytedance.sdk.gromore.c.c.ux {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.c.w.c f31202c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.fz.c.w.c.f f31203w;
    private com.bytedance.msdk.core.admanager.ev xv;

    public t(Context context, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar) {
        this.f31202c = cVar;
        if (cVar != null) {
            this.xv = new com.bytedance.msdk.core.admanager.ev(context, cVar.f());
            this.f31203w = fVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux
    public void c() {
        this.xv.c(new com.bytedance.msdk.api.c.w(5, this.f31202c.w()), new com.bytedance.msdk.api.sr.c.r.ux() { // from class: com.bytedance.sdk.gromore.c.c.sr.t.1
            @Override // com.bytedance.msdk.api.sr.c.r.ux
            public void c(List<com.bytedance.msdk.api.sr.c.r.c> list) {
                com.bytedance.sdk.openadsdk.mediation.c.w.w c4;
                if (list != null) {
                    if (t.this.f31203w != null) {
                        com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.w wVar = null;
                        if (t.this.f31202c != null && (c4 = t.this.f31202c.c()) != null) {
                            wVar = c4.p();
                        }
                        LinkedList linkedList = new LinkedList();
                        for (com.bytedance.msdk.api.sr.c.r.c cVar : list) {
                            linkedList.add(new bk(t.this.xv, cVar, wVar));
                        }
                        t.this.f31203w.onNativeExpressAdLoad(linkedList);
                        return;
                    }
                    return;
                }
                c(new com.bytedance.msdk.api.c(80001, "list is null"));
            }

            @Override // com.bytedance.msdk.api.sr.c.r.ux
            public void c(com.bytedance.msdk.api.c cVar) {
                if (cVar == null || t.this.f31203w == null) {
                    return;
                }
                t.this.f31203w.onError(cVar.f27444c, cVar.f27445w);
            }
        });
    }
}
