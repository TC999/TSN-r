package com.bytedance.sdk.openadsdk.ev.c;

import com.bytedance.sdk.component.c.s;
import com.bytedance.sdk.component.c.sr;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends com.bytedance.sdk.component.c.sr<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f35851c;

    public ux(xk xkVar) {
        this.f35851c = new WeakReference<>(xkVar);
    }

    @Override // com.bytedance.sdk.component.c.sr
    protected void sr() {
    }

    public static void c(s sVar, final xk xkVar) {
        sVar.c("adInfoDialog", new sr.w() { // from class: com.bytedance.sdk.openadsdk.ev.c.ux.1
            @Override // com.bytedance.sdk.component.c.sr.w
            public com.bytedance.sdk.component.c.sr c() {
                return new ux(xk.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.sr
    public void c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        me f4;
        if (k.sr().z()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[JSB-REQ] version: 3 data=");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            a.w("ShowAdInfoDialogMethod", sb.toString());
        }
        xk xkVar = this.f35851c.get();
        if (xkVar == null || (f4 = xkVar.f()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(fVar.getContext(), f4.py());
    }
}
