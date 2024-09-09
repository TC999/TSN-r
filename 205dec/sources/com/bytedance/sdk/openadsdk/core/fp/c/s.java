package com.bytedance.sdk.openadsdk.core.fp.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private xk f33573c;

    /* renamed from: w  reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.r.w> f33574w;

    public s(xk xkVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.r.w> weakReference) {
        this.f33573c = xkVar;
        this.f33574w = weakReference;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, xk xkVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.r.w> weakReference) {
        sVar.c("pauseRewardCountDown", (com.bytedance.sdk.component.c.ux<?, ?>) new s(xkVar, weakReference));
    }

    @Override // com.bytedance.sdk.component.c.ux
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.c.f fVar) throws Exception {
        Log.d("interact", "pauseRewardCountDown: ");
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.r.w> weakReference = this.f33574w;
        if (weakReference != null && weakReference.get() != null) {
            this.f33574w.get().c();
            jSONObject2.put("success", true);
        } else {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
