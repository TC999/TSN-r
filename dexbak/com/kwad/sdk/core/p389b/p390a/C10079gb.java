package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9111ax;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10079gb implements InterfaceC10273d<C9111ax.C9113a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9111ax.C9113a c9113a, JSONObject jSONObject) {
        m26930a(c9113a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9111ax.C9113a c9113a, JSONObject jSONObject) {
        return m26929b(c9113a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26930a(C9111ax.C9113a c9113a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9113a.status = jSONObject.optInt("status");
        c9113a.totalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        c9113a.watchingUserCount = jSONObject.optInt("watchingUserCount");
        c9113a.displayWatchingUserCount = jSONObject.optString("displayWatchingUserCount");
        if (JSONObject.NULL.toString().equals(c9113a.displayWatchingUserCount)) {
            c9113a.displayWatchingUserCount = "";
        }
        c9113a.liveDuration = jSONObject.optLong("liveDuration");
        c9113a.likeUserCount = jSONObject.optInt("likeUserCount");
        c9113a.displayLikeUserCount = jSONObject.optString("displayLikeUserCount");
        if (JSONObject.NULL.toString().equals(c9113a.displayLikeUserCount)) {
            c9113a.displayLikeUserCount = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26929b(C9111ax.C9113a c9113a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9113a.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        long j = c9113a.totalWatchingDuration;
        if (j != 0) {
            C11126t.putValue(jSONObject, "totalWatchingDuration", j);
        }
        int i2 = c9113a.watchingUserCount;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "watchingUserCount", i2);
        }
        String str = c9113a.displayWatchingUserCount;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "displayWatchingUserCount", c9113a.displayWatchingUserCount);
        }
        long j2 = c9113a.liveDuration;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "liveDuration", j2);
        }
        int i3 = c9113a.likeUserCount;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "likeUserCount", i3);
        }
        String str2 = c9113a.displayLikeUserCount;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "displayLikeUserCount", c9113a.displayLikeUserCount);
        }
        return jSONObject;
    }
}
