package com.bytedance.sdk.openadsdk.core.fp.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33572c;

    public r(xk xkVar) {
        this.f33572c = new WeakReference<>(xkVar);
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, xk xkVar) {
        sVar.c("render_button", (com.bytedance.sdk.component.c.ux<?, ?>) new r(xkVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.c.f fVar) throws Exception {
        WeakReference<xk> weakReference = this.f33572c;
        if (weakReference != null && weakReference.get() != null) {
            WeakReference<xk> weakReference2 = this.f33572c;
            if (weakReference2 == null || weakReference2.get() == null) {
                return null;
            }
            try {
                if (jSONObject.getBoolean("is_direct_download")) {
                    this.f33572c.get().t(false);
                    com.bytedance.sdk.openadsdk.core.w.ux ev = this.f33572c.get().ev();
                    if (ev != null) {
                        ev.w();
                    }
                } else {
                    this.f33572c.get().t(true);
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return new JSONObject();
    }
}
