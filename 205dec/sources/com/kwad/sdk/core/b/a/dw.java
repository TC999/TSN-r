package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.FeedSlideConf;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class dw implements com.kwad.sdk.core.d<FeedSlideConf> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        a2(feedSlideConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        return b2(feedSlideConf, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedSlideConf.maxRange = jSONObject.optInt("maxRange");
        feedSlideConf.minRange = jSONObject.optInt("minRange");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = feedSlideConf.maxRange;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxRange", i4);
        }
        int i5 = feedSlideConf.minRange;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "minRange", i5);
        }
        return jSONObject;
    }
}
