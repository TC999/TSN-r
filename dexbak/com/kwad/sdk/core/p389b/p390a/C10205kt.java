package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kt */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10205kt implements InterfaceC10273d<WebCardVideoPositionHandler.VideoPosition> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        m26678a(videoPosition, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        return m26677b(videoPosition, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26678a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
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
    private static JSONObject m26677b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = videoPosition.leftMarginRation;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "leftMarginRation", d);
        }
        double d2 = videoPosition.topMarginRation;
        if (d2 != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "topMarginRation", d2);
        }
        double d3 = videoPosition.widthRation;
        if (d3 != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "widthRation", d3);
        }
        double d4 = videoPosition.heightWidthRation;
        if (d4 != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "heightWidthRation", d4);
        }
        int i = videoPosition.leftMargin;
        if (i != 0) {
            C11126t.putValue(jSONObject, "leftMargin", i);
        }
        int i2 = videoPosition.topMargin;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "topMargin", i2);
        }
        int i3 = videoPosition.width;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "width", i3);
        }
        int i4 = videoPosition.height;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "height", i4);
        }
        int i5 = videoPosition.borderRadius;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "borderRadius", i5);
        }
        return jSONObject;
    }
}
