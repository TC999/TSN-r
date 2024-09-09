package com.bytedance.sdk.openadsdk.core.fp.c;

import android.util.Log;
import com.bytedance.sdk.component.c.sr;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends com.bytedance.sdk.component.c.sr<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33581c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.me f33582w;
    private com.bytedance.sdk.openadsdk.core.ia.xv xv;

    public ux(xk xkVar, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        this.f33581c = new WeakReference<>(xkVar);
        this.f33582w = meVar;
    }

    @Override // com.bytedance.sdk.component.c.sr
    protected void sr() {
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, final xk xkVar, final com.bytedance.sdk.openadsdk.core.u.me meVar) {
        sVar.c("getNetworkData", new sr.w() { // from class: com.bytedance.sdk.openadsdk.core.fp.c.ux.1
            @Override // com.bytedance.sdk.component.c.sr.w
            public com.bytedance.sdk.component.c.sr c() {
                return new ux(xk.this, meVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.sr
    public void c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        xk xkVar = this.f33581c.get();
        if (xkVar == null) {
            xv();
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.xv = new com.bytedance.sdk.openadsdk.core.ia.xv() { // from class: com.bytedance.sdk.openadsdk.core.fp.c.ux.2
            @Override // com.bytedance.sdk.openadsdk.core.ia.xv
            public void c(boolean z3, List<com.bytedance.sdk.openadsdk.core.u.me> list, boolean z4) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (z3) {
                        jSONObject2.put("creatives", xk.c(list));
                        jSONObject2.put("is_cache", z4);
                        if (z4) {
                            jSONObject2.put("prefetch_opt_time", currentTimeMillis - com.bytedance.sdk.openadsdk.core.playable.sr.c().xv(ux.this.f33582w));
                        }
                        ux.this.c((ux) jSONObject2);
                    } else {
                        ux.this.c((ux) jSONObject2);
                    }
                    if (com.bytedance.sdk.openadsdk.core.k.sr().z()) {
                        Log.d("DoGetAdsFromNetwork", "[JSB-RSP] version: 3 data=" + jSONObject2.toString());
                    }
                } catch (Throwable th) {
                    Log.e("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        };
        boolean z3 = true;
        if (((jSONObject != null && jSONObject.optBoolean("is_first_request", false)) && com.bytedance.sdk.openadsdk.core.playable.sr.c().c(this.f33582w, this.xv)) ? false : false) {
            return;
        }
        xkVar.c(jSONObject, this.xv);
    }
}
