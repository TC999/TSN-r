package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10019dw implements InterfaceC10273d<FeedSlideConf> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        m27044a(feedSlideConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        return m27043b(feedSlideConf, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27044a(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedSlideConf.maxRange = jSONObject.optInt("maxRange");
        feedSlideConf.minRange = jSONObject.optInt("minRange");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27043b(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = feedSlideConf.maxRange;
        if (i != 0) {
            C11126t.putValue(jSONObject, "maxRange", i);
        }
        int i2 = feedSlideConf.minRange;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "minRange", i2);
        }
        return jSONObject;
    }
}
