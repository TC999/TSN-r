package com.bytedance.sdk.gromore.init;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends com.bytedance.sdk.openadsdk.mediation.c.w.w.w {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.ev f31247c;

    public a(com.bytedance.msdk.core.admanager.ev evVar) {
        this.f31247c = evVar;
    }

    public void w(String str, final com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar) {
        com.bytedance.msdk.core.admanager.ev evVar;
        if (!TextUtils.isEmpty(str) && (evVar = this.f31247c) != null && xvVar != null) {
            evVar.c(str, new com.bytedance.msdk.api.sr.c.r.ux() { // from class: com.bytedance.sdk.gromore.init.a.1
                @Override // com.bytedance.msdk.api.sr.c.r.ux
                public void c(List<com.bytedance.msdk.api.sr.c.r.c> list) {
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (com.bytedance.msdk.api.sr.c.r.c cVar : list) {
                            if (cVar != null) {
                                arrayList.add(new com.bytedance.sdk.gromore.c.c.sr.k(a.this.f31247c, cVar));
                            }
                        }
                        xvVar.onFeedAdLoad(arrayList);
                        return;
                    }
                    xvVar.onFeedAdLoad(null);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.ux
                public void c(com.bytedance.msdk.api.c cVar) {
                    if (cVar != null) {
                        xvVar.onError(cVar.f27444c, cVar.f27445w);
                    }
                }
            });
        } else {
            com.bytedance.msdk.adapter.sr.xv.sr("TMe", "adm \u53c2\u6570\u9519\u8bef \u6216\u8005 nativeAdManager is null");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.w.w
    public void c(String str, com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar) {
        w(str, xvVar);
    }
}
