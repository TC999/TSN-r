package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cv */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9991cv implements InterfaceC10273d<AdInfo.AdConversionInfo.DeeplinkItemInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        m27100a(deeplinkItemInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        return m27099b(deeplinkItemInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27100a(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        deeplinkItemInfo.sceneConf = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sceneConf");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                deeplinkItemInfo.sceneConf.add((Integer) optJSONArray.opt(i));
            }
        }
        deeplinkItemInfo.areaConf = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("areaConf");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                deeplinkItemInfo.areaConf.add((Integer) optJSONArray2.opt(i2));
            }
        }
        deeplinkItemInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(deeplinkItemInfo.url)) {
            deeplinkItemInfo.url = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27099b(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "sceneConf", deeplinkItemInfo.sceneConf);
        C11126t.putValue(jSONObject, "areaConf", deeplinkItemInfo.areaConf);
        String str = deeplinkItemInfo.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", deeplinkItemInfo.url);
        }
        return jSONObject;
    }
}
