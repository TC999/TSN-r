package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.monitor.RewardWebViewInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ii implements com.kwad.sdk.core.d<RewardWebViewInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        a2(rewardWebViewInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        return b2(rewardWebViewInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
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
        rewardWebViewInfo.source = jSONObject.optString("source");
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
    private static JSONObject b2(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardWebViewInfo.event;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "event", rewardWebViewInfo.event);
        }
        int i4 = rewardWebViewInfo.status;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i4);
        }
        String str2 = rewardWebViewInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", rewardWebViewInfo.url);
        }
        String str3 = rewardWebViewInfo.source;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "source", rewardWebViewInfo.source);
        }
        String str4 = rewardWebViewInfo.sceneId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "scene_id", rewardWebViewInfo.sceneId);
        }
        String str5 = rewardWebViewInfo.pageType;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "page_type", rewardWebViewInfo.pageType);
        }
        long j4 = rewardWebViewInfo.durationMs;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration_ms", j4);
        }
        int i5 = rewardWebViewInfo.timeType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "time_type", i5);
        }
        return jSONObject;
    }
}
