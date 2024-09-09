package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ax;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class gb implements com.kwad.sdk.core.d<ax.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ax.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ax.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ax.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.totalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        aVar.watchingUserCount = jSONObject.optInt("watchingUserCount");
        aVar.displayWatchingUserCount = jSONObject.optString("displayWatchingUserCount");
        if (JSONObject.NULL.toString().equals(aVar.displayWatchingUserCount)) {
            aVar.displayWatchingUserCount = "";
        }
        aVar.liveDuration = jSONObject.optLong("liveDuration");
        aVar.likeUserCount = jSONObject.optInt("likeUserCount");
        aVar.displayLikeUserCount = jSONObject.optString("displayLikeUserCount");
        if (JSONObject.NULL.toString().equals(aVar.displayLikeUserCount)) {
            aVar.displayLikeUserCount = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ax.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = aVar.status;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i4);
        }
        long j4 = aVar.totalWatchingDuration;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "totalWatchingDuration", j4);
        }
        int i5 = aVar.watchingUserCount;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "watchingUserCount", i5);
        }
        String str = aVar.displayWatchingUserCount;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayWatchingUserCount", aVar.displayWatchingUserCount);
        }
        long j5 = aVar.liveDuration;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "liveDuration", j5);
        }
        int i6 = aVar.likeUserCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "likeUserCount", i6);
        }
        String str2 = aVar.displayLikeUserCount;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayLikeUserCount", aVar.displayLikeUserCount);
        }
        return jSONObject;
    }
}
