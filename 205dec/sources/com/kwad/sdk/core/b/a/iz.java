package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class iz implements com.kwad.sdk.core.d<StatusInfo.SplashAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        a2(splashAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        return b2(splashAdInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashAdInfo.dailyShowCount = jSONObject.optInt("dailyShowCount");
        StatusInfo.SplashStyleControl splashStyleControl = new StatusInfo.SplashStyleControl();
        splashAdInfo.splashStyleControl = splashStyleControl;
        splashStyleControl.parseJson(jSONObject.optJSONObject("splashStyleControl"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(StatusInfo.SplashAdInfo splashAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = splashAdInfo.dailyShowCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dailyShowCount", i4);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "splashStyleControl", splashAdInfo.splashStyleControl);
        return jSONObject;
    }
}
