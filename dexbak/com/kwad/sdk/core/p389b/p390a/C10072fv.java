package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fv */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10072fv implements InterfaceC10273d<WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        m26944a(kSAdJSCornerModel, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        return m26943b(kSAdJSCornerModel, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26944a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdJSCornerModel.topLeft = jSONObject.optDouble("topLeft");
        kSAdJSCornerModel.topRight = jSONObject.optDouble("topRight");
        kSAdJSCornerModel.bottomRight = jSONObject.optDouble("bottomRight");
        kSAdJSCornerModel.bottomLeft = jSONObject.optDouble("bottomLeft");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26943b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = kSAdJSCornerModel.topLeft;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "topLeft", d);
        }
        double d2 = kSAdJSCornerModel.topRight;
        if (d2 != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "topRight", d2);
        }
        double d3 = kSAdJSCornerModel.bottomRight;
        if (d3 != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "bottomRight", d3);
        }
        double d4 = kSAdJSCornerModel.bottomLeft;
        if (d4 != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "bottomLeft", d4);
        }
        return jSONObject;
    }
}
