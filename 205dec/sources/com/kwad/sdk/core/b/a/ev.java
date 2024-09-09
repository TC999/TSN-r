package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ai;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ev implements com.kwad.sdk.core.d<ai.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.Xn = jSONObject.optInt("playDuration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = aVar.type;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i4);
        }
        int i5 = aVar.Xn;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", i5);
        }
        return jSONObject;
    }
}
