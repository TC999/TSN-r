package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.as */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9934as implements InterfaceC10273d<AdInfo.AdTrackInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        m27206a(adTrackInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        return m27205b(adTrackInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27206a(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackInfo.type = jSONObject.optInt("type");
        adTrackInfo.urls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("url");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                adTrackInfo.urls.add((String) optJSONArray.opt(i));
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27205b(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adTrackInfo.type;
        if (i != 0) {
            C11126t.putValue(jSONObject, "type", i);
        }
        C11126t.putValue(jSONObject, "url", adTrackInfo.urls);
        return jSONObject;
    }
}
