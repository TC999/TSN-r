package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.monitor.RewardWebViewInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ii */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10140ii implements InterfaceC10273d<RewardWebViewInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        m26808a(rewardWebViewInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        return m26807b(rewardWebViewInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26808a(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardWebViewInfo.event = jSONObject.optString("event");
        if (JSONObject.NULL.toString().equals(rewardWebViewInfo.event)) {
            rewardWebViewInfo.event = "";
        }
        rewardWebViewInfo.status = jSONObject.optInt("status");
        rewardWebViewInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(rewardWebViewInfo.url)) {
            rewardWebViewInfo.url = "";
        }
        rewardWebViewInfo.source = jSONObject.optString(SocialConstants.PARAM_SOURCE);
        if (JSONObject.NULL.toString().equals(rewardWebViewInfo.source)) {
            rewardWebViewInfo.source = "";
        }
        rewardWebViewInfo.sceneId = jSONObject.optString("scene_id");
        if (JSONObject.NULL.toString().equals(rewardWebViewInfo.sceneId)) {
            rewardWebViewInfo.sceneId = "";
        }
        rewardWebViewInfo.pageType = jSONObject.optString("page_type");
        if (JSONObject.NULL.toString().equals(rewardWebViewInfo.pageType)) {
            rewardWebViewInfo.pageType = "";
        }
        rewardWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        rewardWebViewInfo.timeType = jSONObject.optInt("time_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26807b(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardWebViewInfo.event;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "event", rewardWebViewInfo.event);
        }
        int i = rewardWebViewInfo.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        String str2 = rewardWebViewInfo.url;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "url", rewardWebViewInfo.url);
        }
        String str3 = rewardWebViewInfo.source;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, SocialConstants.PARAM_SOURCE, rewardWebViewInfo.source);
        }
        String str4 = rewardWebViewInfo.sceneId;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "scene_id", rewardWebViewInfo.sceneId);
        }
        String str5 = rewardWebViewInfo.pageType;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "page_type", rewardWebViewInfo.pageType);
        }
        long j = rewardWebViewInfo.durationMs;
        if (j != 0) {
            C11126t.putValue(jSONObject, "duration_ms", j);
        }
        int i2 = rewardWebViewInfo.timeType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "time_type", i2);
        }
        return jSONObject;
    }
}
