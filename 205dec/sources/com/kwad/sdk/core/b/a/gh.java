package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class gh implements com.kwad.sdk.core.d<AdInfo.MaterialSize> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        a2(materialSize, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        return b2(materialSize, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialSize.width = jSONObject.optInt("width");
        materialSize.height = jSONObject.optInt("height");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = materialSize.width;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i4);
        }
        int i5 = materialSize.height;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i5);
        }
        return jSONObject;
    }
}
