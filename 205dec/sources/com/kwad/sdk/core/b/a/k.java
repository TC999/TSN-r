package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k implements com.kwad.sdk.core.d<AdStyleInfo.AdBrowseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        a2(adBrowseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        return b2(adBrowseInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBrowseInfo.enableAdBrowse = jSONObject.optInt("enableAdBrowse");
        adBrowseInfo.adBrowseDuration = jSONObject.optInt("adBrowseDuration");
        adBrowseInfo.rewardDescription = jSONObject.optString("rewardDescription");
        if (JSONObject.NULL.toString().equals(adBrowseInfo.rewardDescription)) {
            adBrowseInfo.rewardDescription = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = adBrowseInfo.enableAdBrowse;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enableAdBrowse", i4);
        }
        int i5 = adBrowseInfo.adBrowseDuration;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adBrowseDuration", i5);
        }
        String str = adBrowseInfo.rewardDescription;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardDescription", adBrowseInfo.rewardDescription);
        }
        return jSONObject;
    }
}
