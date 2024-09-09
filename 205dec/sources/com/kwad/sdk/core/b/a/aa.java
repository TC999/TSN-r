package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class aa implements com.kwad.sdk.core.d<WebCardRegisterLiveMessageListener.AdLiveMessageInfoList> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardRegisterLiveMessageListener.AdLiveMessageInfoList adLiveMessageInfoList, JSONObject jSONObject) {
        a2(adLiveMessageInfoList, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardRegisterLiveMessageListener.AdLiveMessageInfoList adLiveMessageInfoList, JSONObject jSONObject) {
        return b2(adLiveMessageInfoList, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(WebCardRegisterLiveMessageListener.AdLiveMessageInfoList adLiveMessageInfoList, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveMessageInfoList.adLiveMessageInfos = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adLiveMessageInfos");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                WebCardRegisterLiveMessageListener.AdLiveMessageInfoList.AdLiveMessageItemInfo adLiveMessageItemInfo = new WebCardRegisterLiveMessageListener.AdLiveMessageInfoList.AdLiveMessageItemInfo();
                adLiveMessageItemInfo.parseJson(optJSONArray.optJSONObject(i4));
                adLiveMessageInfoList.adLiveMessageInfos.add(adLiveMessageItemInfo);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCardRegisterLiveMessageListener.AdLiveMessageInfoList adLiveMessageInfoList, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adLiveMessageInfos", adLiveMessageInfoList.adLiveMessageInfos);
        return jSONObject;
    }
}
