package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.component.c.sr;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends com.bytedance.sdk.component.c.sr<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33546c;

    public f(xk xkVar) {
        this.f33546c = new WeakReference<>(xkVar);
    }

    @Override // com.bytedance.sdk.component.c.sr
    protected void sr() {
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, final xk xkVar) {
        sVar.c("newClickEvent", new sr.w() { // from class: com.bytedance.sdk.openadsdk.core.fp.c.f.1
            @Override // com.bytedance.sdk.component.c.sr.w
            public com.bytedance.sdk.component.c.sr c() {
                return new f(xk.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.sr
    public void c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        xk xkVar = this.f33546c.get();
        if (xkVar == null) {
            xv();
        } else {
            xkVar.p(jSONObject);
        }
    }
}
