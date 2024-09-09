package com.bytedance.sdk.openadsdk.core.fp.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.me f33544c;

    /* renamed from: w  reason: collision with root package name */
    private List<JSONObject> f33545w;

    public ev(com.bytedance.sdk.openadsdk.core.u.me meVar, List<JSONObject> list) {
        this.f33544c = meVar;
        this.f33545w = list;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, com.bytedance.sdk.openadsdk.core.u.me meVar, List<JSONObject> list) {
        sVar.c("getAdsData", (com.bytedance.sdk.component.c.ux<?, ?>) new ev(meVar, list));
    }

    @Override // com.bytedance.sdk.component.c.ux
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.c.f fVar) throws Exception {
        Log.d("interact", "getAdsData: ");
        JSONObject jSONObject2 = new JSONObject();
        int optInt = jSONObject != null ? jSONObject.optInt("ads_num", 3) : -1;
        if (optInt < 0) {
            optInt = 3;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("creatives", new JSONArray().put(this.f33544c.mo()));
        jSONObject2.put("firstRes", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        List<JSONObject> list = this.f33545w;
        if (list != null && list.size() > 0) {
            if (optInt > this.f33545w.size()) {
                optInt = this.f33545w.size();
            }
            int min = Math.min(optInt, 3);
            for (int i4 = 0; i4 < min; i4++) {
                jSONArray.put(i4, this.f33545w.get(i4));
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("creatives", jSONArray);
        jSONObject2.put("secondRes", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("data", jSONObject2);
        return jSONObject5;
    }
}
