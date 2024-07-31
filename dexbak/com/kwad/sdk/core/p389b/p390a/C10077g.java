package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10077g implements InterfaceC10273d<AdMatrixInfo.ActivityMiddlePageInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.ActivityMiddlePageInfo activityMiddlePageInfo, JSONObject jSONObject) {
        m26934a(activityMiddlePageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.ActivityMiddlePageInfo activityMiddlePageInfo, JSONObject jSONObject) {
        return m26933b(activityMiddlePageInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26934a(AdMatrixInfo.ActivityMiddlePageInfo activityMiddlePageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        activityMiddlePageInfo.showHeaderBar = jSONObject.optBoolean("showHeaderBar");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26933b(AdMatrixInfo.ActivityMiddlePageInfo activityMiddlePageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = activityMiddlePageInfo.showHeaderBar;
        if (z) {
            C11126t.putValue(jSONObject, "showHeaderBar", z);
        }
        return jSONObject;
    }
}
