package com.bytedance.sdk.openadsdk.ev.c;

import com.bytedance.sdk.component.c.s;
import com.bytedance.sdk.component.c.sr;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends com.bytedance.sdk.component.c.sr<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f35847c;

    public f(xk xkVar) {
        this.f35847c = new WeakReference<>(xkVar);
    }

    @Override // com.bytedance.sdk.component.c.sr
    protected void sr() {
    }

    public static void c(s sVar, final xk xkVar) {
        sVar.c("openPrivacy", new sr.w() { // from class: com.bytedance.sdk.openadsdk.ev.c.f.1
            @Override // com.bytedance.sdk.component.c.sr.w
            public com.bytedance.sdk.component.c.sr c() {
                return new f(xk.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.sr
    public void c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        xk xkVar;
        me f4;
        WeakReference<xk> weakReference = this.f35847c;
        if (weakReference == null || (xkVar = weakReference.get()) == null || (f4 = xkVar.f()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(fVar.getContext(), f4);
    }
}
