package com.bytedance.sdk.openadsdk.core.fp.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ia extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private Context f33556c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.me f33557w;

    public ia(Context context, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        this.f33556c = context;
        this.f33557w = meVar;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, Context context, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        sVar.c("openNewCommonWebPage", (com.bytedance.sdk.component.c.ux<?, ?>) new ia(context, meVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.c.f fVar) throws Exception {
        try {
            String optString = jSONObject.optString("web_url");
            String optString2 = jSONObject.optString("web_title");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "";
            }
            TTDelegateActivity.sr(this.f33556c, optString, optString2);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.f("OpenNewWebPageMethod", "method:" + th.getMessage());
            return null;
        }
    }
}
