package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.if */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10137if implements InterfaceC10273d<AdMatrixInfo.RewardVideoInteractInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        m26814a(rewardVideoInteractInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        return m26813b(rewardVideoInteractInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26814a(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardVideoInteractInfo.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(rewardVideoInteractInfo.templateId)) {
            rewardVideoInteractInfo.templateId = "";
        }
        rewardVideoInteractInfo.showTime = jSONObject.optInt("showTime", new Integer(Constants.VIA_REPORT_TYPE_WPA_STATE).intValue());
        rewardVideoInteractInfo.duration = jSONObject.optInt("duration", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
        rewardVideoInteractInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("5").intValue());
        rewardVideoInteractInfo.intervalShow = jSONObject.optInt("intervalShow", new Integer("3").intValue());
        rewardVideoInteractInfo.dayMaxLimit = jSONObject.optInt("dayMaxLimit", new Integer("2").intValue());
        rewardVideoInteractInfo.style = jSONObject.optInt("style");
        rewardVideoInteractInfo.successfulMsg = jSONObject.optString("successfulMsg");
        if (JSONObject.NULL.toString().equals(rewardVideoInteractInfo.successfulMsg)) {
            rewardVideoInteractInfo.successfulMsg = "";
        }
        rewardVideoInteractInfo.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(rewardVideoInteractInfo.errorMsg)) {
            rewardVideoInteractInfo.errorMsg = "";
        }
        AdMatrixInfo.StyleInfo styleInfo = new AdMatrixInfo.StyleInfo();
        rewardVideoInteractInfo.styleInfo = styleInfo;
        styleInfo.parseJson(jSONObject.optJSONObject("styleInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26813b(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardVideoInteractInfo.templateId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "templateId", rewardVideoInteractInfo.templateId);
        }
        C11126t.putValue(jSONObject, "showTime", rewardVideoInteractInfo.showTime);
        C11126t.putValue(jSONObject, "duration", rewardVideoInteractInfo.duration);
        C11126t.putValue(jSONObject, "rewardTime", rewardVideoInteractInfo.rewardTime);
        C11126t.putValue(jSONObject, "intervalShow", rewardVideoInteractInfo.intervalShow);
        C11126t.putValue(jSONObject, "dayMaxLimit", rewardVideoInteractInfo.dayMaxLimit);
        int i = rewardVideoInteractInfo.style;
        if (i != 0) {
            C11126t.putValue(jSONObject, "style", i);
        }
        String str2 = rewardVideoInteractInfo.successfulMsg;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "successfulMsg", rewardVideoInteractInfo.successfulMsg);
        }
        String str3 = rewardVideoInteractInfo.errorMsg;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, rewardVideoInteractInfo.errorMsg);
        }
        C11126t.m23678a(jSONObject, "styleInfo", rewardVideoInteractInfo.styleInfo);
        return jSONObject;
    }
}
