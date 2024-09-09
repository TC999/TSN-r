package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class dq implements com.kwad.sdk.core.d<AdStyleInfo.ExtraDisplayInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        a2(extraDisplayInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        return b2(extraDisplayInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        extraDisplayInfo.exposeTagInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("exposeTagInfoList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                AdStyleInfo.ExposeTagInfo exposeTagInfo = new AdStyleInfo.ExposeTagInfo();
                exposeTagInfo.parseJson(optJSONArray.optJSONObject(i4));
                extraDisplayInfo.exposeTagInfoList.add(exposeTagInfo);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "exposeTagInfoList", extraDisplayInfo.exposeTagInfoList);
        return jSONObject;
    }
}
