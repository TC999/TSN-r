package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10185k implements InterfaceC10273d<AdStyleInfo.AdBrowseInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        m26718a(adBrowseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        return m26717b(adBrowseInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26718a(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
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
    private static JSONObject m26717b(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adBrowseInfo.enableAdBrowse;
        if (i != 0) {
            C11126t.putValue(jSONObject, "enableAdBrowse", i);
        }
        int i2 = adBrowseInfo.adBrowseDuration;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "adBrowseDuration", i2);
        }
        String str = adBrowseInfo.rewardDescription;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "rewardDescription", adBrowseInfo.rewardDescription);
        }
        return jSONObject;
    }
}
