package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.h;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class em implements com.kwad.sdk.core.d<h.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Wb = jSONObject.optInt("playableSrc");
        bVar.Wc = jSONObject.optInt("isMiddleEnd");
        bVar.Md = jSONObject.optInt("adType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = bVar.Wb;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableSrc", i4);
        }
        int i5 = bVar.Wc;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isMiddleEnd", i5);
        }
        int i6 = bVar.Md;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adType", i6);
        }
        return jSONObject;
    }
}
