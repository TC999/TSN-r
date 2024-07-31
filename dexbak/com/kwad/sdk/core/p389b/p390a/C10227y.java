package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.y */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10227y implements InterfaceC10273d<AdLabelImpl> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        m26634a(adLabelImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        return m26633b(adLabelImpl, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26634a(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLabelImpl.thirdAge = jSONObject.optInt("thirdAge");
        adLabelImpl.thirdGender = jSONObject.optInt("thirdGender");
        adLabelImpl.thirdInterest = jSONObject.optString("thirdInterest");
        if (JSONObject.NULL.toString().equals(adLabelImpl.thirdInterest)) {
            adLabelImpl.thirdInterest = "";
        }
        adLabelImpl.prevTitle = jSONObject.optString("prevTitle");
        if (JSONObject.NULL.toString().equals(adLabelImpl.prevTitle)) {
            adLabelImpl.prevTitle = "";
        }
        adLabelImpl.postTitle = jSONObject.optString("postTitle");
        if (JSONObject.NULL.toString().equals(adLabelImpl.postTitle)) {
            adLabelImpl.postTitle = "";
        }
        adLabelImpl.historyTitle = jSONObject.optString("historyTitle");
        if (JSONObject.NULL.toString().equals(adLabelImpl.historyTitle)) {
            adLabelImpl.historyTitle = "";
        }
        adLabelImpl.channel = jSONObject.optString("channel");
        if (JSONObject.NULL.toString().equals(adLabelImpl.channel)) {
            adLabelImpl.channel = "";
        }
        adLabelImpl.cpmBidFloor = jSONObject.optLong("cpmBidFloor");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26633b(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adLabelImpl.thirdAge;
        if (i != 0) {
            C11126t.putValue(jSONObject, "thirdAge", i);
        }
        int i2 = adLabelImpl.thirdGender;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "thirdGender", i2);
        }
        String str = adLabelImpl.thirdInterest;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "thirdInterest", adLabelImpl.thirdInterest);
        }
        String str2 = adLabelImpl.prevTitle;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "prevTitle", adLabelImpl.prevTitle);
        }
        String str3 = adLabelImpl.postTitle;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "postTitle", adLabelImpl.postTitle);
        }
        String str4 = adLabelImpl.historyTitle;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "historyTitle", adLabelImpl.historyTitle);
        }
        String str5 = adLabelImpl.channel;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "channel", adLabelImpl.channel);
        }
        long j = adLabelImpl.cpmBidFloor;
        if (j != 0) {
            C11126t.putValue(jSONObject, "cpmBidFloor", j);
        }
        return jSONObject;
    }
}
