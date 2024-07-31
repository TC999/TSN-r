package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ih */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10139ih implements InterfaceC10273d<AdMatrixInfo.RewardWebTaskCloseInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        m26810a(rewardWebTaskCloseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        return m26809b(rewardWebTaskCloseInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26810a(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardWebTaskCloseInfo.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(rewardWebTaskCloseInfo.templateId)) {
            rewardWebTaskCloseInfo.templateId = "";
        }
        rewardWebTaskCloseInfo.webConfirmCardType = jSONObject.optInt("webConfirmCardType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26809b(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardWebTaskCloseInfo.templateId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "templateId", rewardWebTaskCloseInfo.templateId);
        }
        int i = rewardWebTaskCloseInfo.webConfirmCardType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "webConfirmCardType", i);
        }
        return jSONObject;
    }
}
