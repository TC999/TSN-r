package com.bytedance.sdk.gromore.c.c.w;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements com.bytedance.sdk.gromore.c.c.ux {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.ux f31217c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.c.w.c f31218w;
    private com.bytedance.sdk.openadsdk.fz.c.w.c.w xv;

    public sr(Context context, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, com.bytedance.sdk.openadsdk.fz.c.w.c.w wVar) {
        this.f31218w = cVar;
        if (cVar != null) {
            this.f31217c = new com.bytedance.msdk.core.admanager.ux(context, cVar.f());
            this.xv = wVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux
    public void c() {
        this.f31217c.c(new com.bytedance.msdk.api.c.w(9, this.f31218w.w()), new com.bytedance.msdk.api.sr.c.xv.xv() { // from class: com.bytedance.sdk.gromore.c.c.w.sr.1
            @Override // com.bytedance.msdk.api.sr.c.xv.xv
            public void c(List<com.bytedance.msdk.api.sr.c.xv.c> list) {
                if (list != null) {
                    if (sr.this.xv != null) {
                        ArrayList arrayList = new ArrayList();
                        for (com.bytedance.msdk.api.sr.c.xv.c cVar : list) {
                            arrayList.add(new w(sr.this.f31217c, cVar));
                        }
                        sr.this.xv.onDrawFeedAdLoad(arrayList);
                        return;
                    }
                    return;
                }
                c(new com.bytedance.msdk.api.c(80001, "list is null"));
            }

            @Override // com.bytedance.msdk.api.sr.c.xv.xv
            public void c(com.bytedance.msdk.api.c cVar) {
                if (cVar == null || sr.this.xv == null) {
                    return;
                }
                sr.this.xv.onError(cVar.f27444c, cVar.f27445w);
            }
        });
    }
}
