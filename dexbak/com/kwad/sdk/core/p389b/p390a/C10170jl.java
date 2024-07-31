package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.splashscreen.monitor.SplashWebMonitorInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10170jl implements InterfaceC10273d<SplashWebMonitorInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        m26748a(splashWebMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        return m26747b(splashWebMonitorInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26748a(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashWebMonitorInfo.event = jSONObject.optString("event");
        if (JSONObject.NULL.toString().equals(splashWebMonitorInfo.event)) {
            splashWebMonitorInfo.event = "";
        }
        splashWebMonitorInfo.status = jSONObject.optInt("status");
        splashWebMonitorInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(splashWebMonitorInfo.url)) {
            splashWebMonitorInfo.url = "";
        }
        splashWebMonitorInfo.sceneId = jSONObject.optString("scene_id");
        if (JSONObject.NULL.toString().equals(splashWebMonitorInfo.sceneId)) {
            splashWebMonitorInfo.sceneId = "";
        }
        splashWebMonitorInfo.durationMs = jSONObject.optLong("duration_ms");
        splashWebMonitorInfo.timeType = jSONObject.optInt("time_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26747b(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashWebMonitorInfo.event;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "event", splashWebMonitorInfo.event);
        }
        int i = splashWebMonitorInfo.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        String str2 = splashWebMonitorInfo.url;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "url", splashWebMonitorInfo.url);
        }
        String str3 = splashWebMonitorInfo.sceneId;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "scene_id", splashWebMonitorInfo.sceneId);
        }
        long j = splashWebMonitorInfo.durationMs;
        if (j != 0) {
            C11126t.putValue(jSONObject, "duration_ms", j);
        }
        int i2 = splashWebMonitorInfo.timeType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "time_type", i2);
        }
        return jSONObject;
    }
}
