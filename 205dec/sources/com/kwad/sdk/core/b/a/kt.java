package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class kt implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        a2(videoPosition, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        return b2(videoPosition, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
        videoPosition.leftMargin = jSONObject.optInt("leftMargin");
        videoPosition.topMargin = jSONObject.optInt("topMargin");
        videoPosition.width = jSONObject.optInt("width");
        videoPosition.height = jSONObject.optInt("height");
        videoPosition.borderRadius = jSONObject.optInt("borderRadius");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d4 = videoPosition.leftMarginRation;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMarginRation", d4);
        }
        double d5 = videoPosition.topMarginRation;
        if (d5 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topMarginRation", d5);
        }
        double d6 = videoPosition.widthRation;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "widthRation", d6);
        }
        double d7 = videoPosition.heightWidthRation;
        if (d7 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "heightWidthRation", d7);
        }
        int i4 = videoPosition.leftMargin;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMargin", i4);
        }
        int i5 = videoPosition.topMargin;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topMargin", i5);
        }
        int i6 = videoPosition.width;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i6);
        }
        int i7 = videoPosition.height;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i7);
        }
        int i8 = videoPosition.borderRadius;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "borderRadius", i8);
        }
        return jSONObject;
    }
}
