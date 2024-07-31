package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ig */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10138ig implements InterfaceC10273d<AdMatrixInfo.RewardVideoTaskInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        m26812a(rewardVideoTaskInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        return m26811b(rewardVideoTaskInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26812a(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardVideoTaskInfo.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(rewardVideoTaskInfo.templateId)) {
            rewardVideoTaskInfo.templateId = "";
        }
        rewardVideoTaskInfo.showTime = jSONObject.optInt("showTime", new Integer(Constants.VIA_REPORT_TYPE_WPA_STATE).intValue());
        rewardVideoTaskInfo.duration = jSONObject.optInt("duration", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
        rewardVideoTaskInfo.taskType = jSONObject.optInt("taskType", new Integer("0").intValue());
        rewardVideoTaskInfo.thresholdTime = jSONObject.optInt("thresholdTime", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26811b(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardVideoTaskInfo.templateId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "templateId", rewardVideoTaskInfo.templateId);
        }
        C11126t.putValue(jSONObject, "showTime", rewardVideoTaskInfo.showTime);
        C11126t.putValue(jSONObject, "duration", rewardVideoTaskInfo.duration);
        C11126t.putValue(jSONObject, "taskType", rewardVideoTaskInfo.taskType);
        C11126t.putValue(jSONObject, "thresholdTime", rewardVideoTaskInfo.thresholdTime);
        return jSONObject;
    }
}
