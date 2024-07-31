package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.feed.monitor.FeedWebViewInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dx */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10020dx implements InterfaceC10273d<FeedWebViewInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        m27042a(feedWebViewInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        return m27041b(feedWebViewInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27042a(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedWebViewInfo.event = jSONObject.optString("event");
        if (JSONObject.NULL.toString().equals(feedWebViewInfo.event)) {
            feedWebViewInfo.event = "";
        }
        feedWebViewInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(feedWebViewInfo.url)) {
            feedWebViewInfo.url = "";
        }
        feedWebViewInfo.sceneId = jSONObject.optString("scene_id");
        if (JSONObject.NULL.toString().equals(feedWebViewInfo.sceneId)) {
            feedWebViewInfo.sceneId = "";
        }
        feedWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        feedWebViewInfo.timeType = jSONObject.optInt("time_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27041b(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = feedWebViewInfo.event;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "event", feedWebViewInfo.event);
        }
        String str2 = feedWebViewInfo.url;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "url", feedWebViewInfo.url);
        }
        String str3 = feedWebViewInfo.sceneId;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "scene_id", feedWebViewInfo.sceneId);
        }
        long j = feedWebViewInfo.durationMs;
        if (j != 0) {
            C11126t.putValue(jSONObject, "duration_ms", j);
        }
        int i = feedWebViewInfo.timeType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "time_type", i);
        }
        return jSONObject;
    }
}
