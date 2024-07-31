package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9915a implements InterfaceC10273d<ABParams> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(ABParams aBParams, JSONObject jSONObject) {
        m27244a(aBParams, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(ABParams aBParams, JSONObject jSONObject) {
        return m27243b(aBParams, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27244a(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aBParams.videoBlackAreaClick = jSONObject.optInt("videoBlackAreaClick");
        aBParams.videoBlackAreaNewStyle = jSONObject.optInt("videoBlackAreaNewStyle");
        aBParams.drawActionBarTimes = jSONObject.optString("drawActionBarTimes");
        if (JSONObject.NULL.toString().equals(aBParams.drawActionBarTimes)) {
            aBParams.drawActionBarTimes = "";
        }
        aBParams.showVideoAtH5 = jSONObject.optInt("showVideoAtH5");
        aBParams.playableStyle = jSONObject.optInt("playableStyle");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27243b(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aBParams.videoBlackAreaClick;
        if (i != 0) {
            C11126t.putValue(jSONObject, "videoBlackAreaClick", i);
        }
        int i2 = aBParams.videoBlackAreaNewStyle;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "videoBlackAreaNewStyle", i2);
        }
        String str = aBParams.drawActionBarTimes;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        }
        int i3 = aBParams.showVideoAtH5;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "showVideoAtH5", i3);
        }
        int i4 = aBParams.playableStyle;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "playableStyle", i4);
        }
        return jSONObject;
    }
}
