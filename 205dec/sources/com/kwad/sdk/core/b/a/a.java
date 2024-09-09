package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements com.kwad.sdk.core.d<ABParams> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ABParams aBParams, JSONObject jSONObject) {
        a2(aBParams, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ABParams aBParams, JSONObject jSONObject) {
        return b2(aBParams, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ABParams aBParams, JSONObject jSONObject) {
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
    private static JSONObject b2(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = aBParams.videoBlackAreaClick;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoBlackAreaClick", i4);
        }
        int i5 = aBParams.videoBlackAreaNewStyle;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoBlackAreaNewStyle", i5);
        }
        String str = aBParams.drawActionBarTimes;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        }
        int i6 = aBParams.showVideoAtH5;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showVideoAtH5", i6);
        }
        int i7 = aBParams.playableStyle;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableStyle", i7);
        }
        return jSONObject;
    }
}
