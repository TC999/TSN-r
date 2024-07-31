package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.request.model.C10480f;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10175jq implements InterfaceC10273d<StatusInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(StatusInfo statusInfo, JSONObject jSONObject) {
        m26738a(statusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(StatusInfo statusInfo, JSONObject jSONObject) {
        return m26737b(statusInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26738a(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.azK = jSONObject.optInt("personalRecommend");
        statusInfo.azL = jSONObject.optInt("programmaticRecommend");
        StatusInfo.SplashAdInfo splashAdInfo = new StatusInfo.SplashAdInfo();
        statusInfo.azM = splashAdInfo;
        splashAdInfo.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        StatusInfo.NativeAdRequestInfo nativeAdRequestInfo = new StatusInfo.NativeAdRequestInfo();
        statusInfo.azN = nativeAdRequestInfo;
        nativeAdRequestInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        statusInfo.azO = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                C10480f c10480f = new C10480f();
                c10480f.parseJson(optJSONArray.optJSONObject(i));
                statusInfo.azO.add(c10480f);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26737b(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = statusInfo.azK;
        if (i != 0) {
            C11126t.putValue(jSONObject, "personalRecommend", i);
        }
        int i2 = statusInfo.azL;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "programmaticRecommend", i2);
        }
        C11126t.m23678a(jSONObject, "splashAdInfo", statusInfo.azM);
        C11126t.m23678a(jSONObject, "nativeAdInfo", statusInfo.azN);
        C11126t.putValue(jSONObject, "taskStats", statusInfo.azO);
        return jSONObject;
    }
}
