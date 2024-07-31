package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10050f implements InterfaceC10273d<ActivityInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(ActivityInfo activityInfo, JSONObject jSONObject) {
        m26988a(activityInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(ActivityInfo activityInfo, JSONObject jSONObject) {
        return m26987b(activityInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26988a(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        activityInfo.actTypeId = jSONObject.optInt("actTypeId");
        activityInfo.sceneTypeId = jSONObject.optInt("sceneTypeId");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26987b(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = activityInfo.actTypeId;
        if (i != 0) {
            C11126t.putValue(jSONObject, "actTypeId", i);
        }
        int i2 = activityInfo.sceneTypeId;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "sceneTypeId", i2);
        }
        return jSONObject;
    }
}
