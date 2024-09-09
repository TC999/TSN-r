package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class fv implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        a2(kSAdJSCornerModel, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        return b2(kSAdJSCornerModel, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdJSCornerModel.topLeft = jSONObject.optDouble("topLeft");
        kSAdJSCornerModel.topRight = jSONObject.optDouble("topRight");
        kSAdJSCornerModel.bottomRight = jSONObject.optDouble("bottomRight");
        kSAdJSCornerModel.bottomLeft = jSONObject.optDouble("bottomLeft");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d4 = kSAdJSCornerModel.topLeft;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topLeft", d4);
        }
        double d5 = kSAdJSCornerModel.topRight;
        if (d5 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topRight", d5);
        }
        double d6 = kSAdJSCornerModel.bottomRight;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bottomRight", d6);
        }
        double d7 = kSAdJSCornerModel.bottomLeft;
        if (d7 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bottomLeft", d7);
        }
        return jSONObject;
    }
}
