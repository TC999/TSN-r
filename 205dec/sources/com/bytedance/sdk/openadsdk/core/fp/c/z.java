package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.component.c.sr;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class z extends com.bytedance.sdk.component.c.sr<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33592c;

    public z(xk xkVar) {
        this.f33592c = new WeakReference<>(xkVar);
    }

    @Override // com.bytedance.sdk.component.c.sr
    protected void sr() {
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, final xk xkVar) {
        sVar.c("showAppDetailOrPrivacyDialog", new sr.w() { // from class: com.bytedance.sdk.openadsdk.core.fp.c.z.1
            @Override // com.bytedance.sdk.component.c.sr.w
            public com.bytedance.sdk.component.c.sr c() {
                return new z(xk.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.sr
    public void c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        if (com.bytedance.sdk.openadsdk.core.k.sr().z()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[JSB-REQ] version: 3 data=");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            com.bytedance.sdk.component.utils.a.w("ShowAppDetailOrPrivacyDialogMethod", sb.toString());
        }
        WeakReference<xk> weakReference = this.f33592c;
        if (weakReference == null) {
            return;
        }
        xk xkVar = weakReference.get();
        if (xkVar == null) {
            xv();
        } else if (jSONObject == null) {
        } else {
            int optInt = jSONObject.optInt("show_dialog_style");
            if (optInt == 1) {
                xkVar.gb();
                com.bytedance.sdk.component.utils.a.w("ShowAppDetailOrPrivacyDialogMethod", "ShowAppDetailOrPrivacyDialogMethod showAppDetailDialog ");
            } else if (optInt == 2) {
                xkVar.ls();
                com.bytedance.sdk.component.utils.a.w("ShowAppDetailOrPrivacyDialogMethod", "ShowAppDetailOrPrivacyDialogMethod showAppPrivacyDialog ");
            }
        }
    }
}
