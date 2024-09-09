package com.bytedance.sdk.gromore.init;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p extends com.bytedance.sdk.openadsdk.mediation.c.w.w.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.ux f31266c;

    public p(com.bytedance.msdk.core.admanager.ux uxVar) {
        this.f31266c = uxVar;
    }

    public void w(String str, final com.bytedance.sdk.openadsdk.fz.c.w.c.w wVar) {
        com.bytedance.msdk.core.admanager.ux uxVar;
        if (!TextUtils.isEmpty(str) && (uxVar = this.f31266c) != null && wVar != null) {
            uxVar.c(str, new com.bytedance.msdk.api.sr.c.xv.xv() { // from class: com.bytedance.sdk.gromore.init.p.1
                @Override // com.bytedance.msdk.api.sr.c.xv.xv
                public void c(List<com.bytedance.msdk.api.sr.c.xv.c> list) {
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (com.bytedance.msdk.api.sr.c.xv.c cVar : list) {
                            if (cVar != null) {
                                arrayList.add(new com.bytedance.sdk.gromore.c.c.w.w(p.this.f31266c, cVar));
                            }
                        }
                        wVar.onDrawFeedAdLoad(arrayList);
                        return;
                    }
                    wVar.onDrawFeedAdLoad(null);
                }

                @Override // com.bytedance.msdk.api.sr.c.xv.xv
                public void c(com.bytedance.msdk.api.c cVar) {
                    if (cVar != null) {
                        wVar.onError(cVar.f27444c, cVar.f27445w);
                    }
                }
            });
        } else {
            com.bytedance.msdk.adapter.sr.xv.sr("TMe", "adm \u53c2\u6570\u9519\u8bef \u6216\u8005 drawTokenInfo is null");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.w.c
    public void c(String str, com.bytedance.sdk.openadsdk.fz.c.w.c.w wVar) {
        w(str, wVar);
    }
}
