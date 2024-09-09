package com.bytedance.sdk.openadsdk.ev.c;

import com.bytedance.sdk.component.c.s;
import com.bytedance.sdk.component.c.sr;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.sdk.component.c.sr<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f35845c;

    public c(xk xkVar) {
        this.f35845c = new WeakReference<>(xkVar);
    }

    @Override // com.bytedance.sdk.component.c.sr
    protected void sr() {
    }

    public static void c(s sVar, final xk xkVar) {
        sVar.c("interstitial_webview_close", new sr.w() { // from class: com.bytedance.sdk.openadsdk.ev.c.c.1
            @Override // com.bytedance.sdk.component.c.sr.w
            public com.bytedance.sdk.component.c.sr c() {
                return new c(xk.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.sr
    public void c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        if (k.sr().z()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[JSB-REQ] version: 3 data=");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            a.w("DoInterstitialWebViewCloseMethod", sb.toString());
        }
        a.f("DoInterstitialWebViewCloseMethod", "DoInterstitialWebViewCloseMethod invoke ");
        xk xkVar = this.f35845c.get();
        if (xkVar == null) {
            a.f("DoInterstitialWebViewCloseMethod", "invoke error");
            xv();
            return;
        }
        xkVar.t();
    }
}
