package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gh */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10085gh implements InterfaceC10273d<AdInfo.MaterialSize> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        m26918a(materialSize, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        return m26917b(materialSize, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26918a(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialSize.width = jSONObject.optInt("width");
        materialSize.height = jSONObject.optInt("height");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26917b(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = materialSize.width;
        if (i != 0) {
            C11126t.putValue(jSONObject, "width", i);
        }
        int i2 = materialSize.height;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "height", i2);
        }
        return jSONObject;
    }
}
