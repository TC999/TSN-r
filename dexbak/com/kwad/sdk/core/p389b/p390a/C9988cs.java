package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cs */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9988cs implements InterfaceC10273d<AdInfo.CutRuleInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        m27106a(cutRuleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        return m27105b(cutRuleInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27106a(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cutRuleInfo.picHeight = jSONObject.optInt("picHeight");
        cutRuleInfo.viewTopMargin = jSONObject.optInt("viewTopMargin");
        cutRuleInfo.safeAreaHeight = jSONObject.optInt("safeAreaHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27105b(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = cutRuleInfo.picHeight;
        if (i != 0) {
            C11126t.putValue(jSONObject, "picHeight", i);
        }
        int i2 = cutRuleInfo.viewTopMargin;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "viewTopMargin", i2);
        }
        int i3 = cutRuleInfo.safeAreaHeight;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "safeAreaHeight", i3);
        }
        return jSONObject;
    }
}
