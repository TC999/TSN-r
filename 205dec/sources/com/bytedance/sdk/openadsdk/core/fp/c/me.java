package com.bytedance.sdk.openadsdk.core.fp.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.wx;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class me extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private SSWebView f33567c;
    private xk sr;

    /* renamed from: w  reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.r.w> f33568w;
    private String xv;

    public me(SSWebView sSWebView, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.r.w> weakReference, String str, xk xkVar) {
        this.f33567c = sSWebView;
        this.f33568w = weakReference;
        this.xv = str;
        this.sr = xkVar;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, SSWebView sSWebView, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.r.w> weakReference, xk xkVar) {
        sVar.c("closeWebview", (com.bytedance.sdk.component.c.ux<?, ?>) new me(sSWebView, weakReference, "closeWebview", xkVar));
        sVar.c("makeVisible", (com.bytedance.sdk.component.c.ux<?, ?>) new me(sSWebView, weakReference, "makeVisible", xkVar));
        sVar.c("getCurrentVisibleState", (com.bytedance.sdk.component.c.ux<?, ?>) new me(sSWebView, weakReference, "getCurrentVisibleState", xkVar));
        sVar.c("changeSize", (com.bytedance.sdk.component.c.ux<?, ?>) new me(sSWebView, weakReference, "changeSize", xkVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.c.f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.xv;
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -2131947567:
                if (str.equals("changeSize")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1516905438:
                if (str.equals("getCurrentVisibleState")) {
                    c4 = 1;
                    break;
                }
                break;
            case -120664351:
                if (str.equals("closeWebview")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1756338852:
                if (str.equals("makeVisible")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                JSONArray optJSONArray = jSONObject.optJSONArray("size");
                if (optJSONArray != null && optJSONArray.length() == 2) {
                    int optInt = optJSONArray.optInt(0);
                    int optInt2 = optJSONArray.optInt(1);
                    xk xkVar = this.sr;
                    if (xkVar != null) {
                        xkVar.c(optInt, optInt2);
                        break;
                    }
                }
                break;
            case 1:
                jSONObject2.put("visibleState", !wx.c(this.f33567c, 50, 5) ? 1 : 0);
                break;
            case 2:
                this.f33567c.setVisibility(8);
                WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.r.w> weakReference = this.f33568w;
                if (weakReference != null && weakReference.get() != null) {
                    this.f33568w.get().xv();
                    jSONObject2.put("success", true);
                    break;
                } else {
                    jSONObject2.put("success", false);
                    break;
                }
            case 3:
                SSWebView sSWebView = this.f33567c;
                if (sSWebView != null) {
                    sSWebView.setVisibility(0);
                    jSONObject2.put("success", true);
                    break;
                } else {
                    jSONObject2.put("success", false);
                    break;
                }
        }
        return jSONObject2;
    }
}
