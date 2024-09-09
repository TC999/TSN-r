package com.bytedance.sdk.openadsdk.ev.c;

import com.bytedance.sdk.component.c.s;
import com.bytedance.sdk.component.c.sr;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class xv extends com.bytedance.sdk.component.c.sr<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private static WeakReference<c> f35854c;

    /* renamed from: w  reason: collision with root package name */
    private WeakReference<xk> f35855w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(int i4);
    }

    @Override // com.bytedance.sdk.component.c.sr
    protected void sr() {
    }

    private xv(xk xkVar) {
        this.f35855w = new WeakReference<>(xkVar);
    }

    public static void c(s sVar, final xk xkVar) {
        sVar.c("onClickBrowseCloseCallback", new sr.w() { // from class: com.bytedance.sdk.openadsdk.ev.c.xv.1
            @Override // com.bytedance.sdk.component.c.sr.w
            public com.bytedance.sdk.component.c.sr c() {
                return new xv(xk.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.sr
    public void c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        WeakReference<c> weakReference = f35854c;
        c cVar = weakReference != null ? weakReference.get() : null;
        if (this.f35855w == null || jSONObject == null) {
            if (cVar != null) {
                cVar.c();
                return;
            }
            return;
        }
        int optInt = jSONObject.optInt("remainTime", Integer.MIN_VALUE);
        if (optInt == Integer.MIN_VALUE) {
            if (cVar != null) {
                cVar.c();
            }
        } else if (cVar != null) {
            cVar.c(optInt);
        }
    }

    public static void c(c cVar) {
        f35854c = new WeakReference<>(cVar);
    }
}
