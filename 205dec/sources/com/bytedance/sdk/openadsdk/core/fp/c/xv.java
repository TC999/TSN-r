package com.bytedance.sdk.openadsdk.core.fp.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33589c;

    public xv(xk xkVar) {
        this.f33589c = new WeakReference<>(xkVar);
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, xk xkVar) {
        sVar.c("changePlaySpeedRatio", (com.bytedance.sdk.component.c.ux<?, ?>) new xv(xkVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.c.f fVar) throws Exception {
        WeakReference<xk> weakReference = this.f33589c;
        if (weakReference != null && weakReference.get() != null) {
            float optDouble = (float) jSONObject.optDouble("ratio");
            if (optDouble > 0.0f && optDouble <= 3.0f) {
                this.f33589c.get().c(optDouble);
            }
            return new JSONObject();
        }
        return new JSONObject();
    }
}
