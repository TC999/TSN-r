package com.kwad.sdk.core.b.a;

import com.kwad.components.core.video.a.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class kq implements com.kwad.sdk.core.d<d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Vq = jSONObject.optLong("start_play_duration_ms");
        bVar.Vr = jSONObject.optLong("first_frame_duration_ms");
        bVar.Vs = jSONObject.optLong("block_total_duration_ms");
        bVar.videoDuration = jSONObject.optLong("video_duration_ms");
        bVar.UX = jSONObject.optInt("block_times");
        bVar.videoUrl = jSONObject.optString(CampaignEx.JSON_KEY_VIDEO_URL);
        if (JSONObject.NULL.toString().equals(bVar.videoUrl)) {
            bVar.videoUrl = "";
        }
        bVar.llsid = jSONObject.optLong("llsid");
        bVar.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        bVar.Sd = jSONObject.optLong("ad_info_uid");
        bVar.Vp = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(bVar.Vp)) {
            bVar.Vp = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = bVar.Vq;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "start_play_duration_ms", j4);
        }
        long j5 = bVar.Vr;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "first_frame_duration_ms", j5);
        }
        long j6 = bVar.Vs;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "block_total_duration_ms", j6);
        }
        long j7 = bVar.videoDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_duration_ms", j7);
        }
        int i4 = bVar.UX;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "block_times", i4);
        }
        String str = bVar.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_VIDEO_URL, bVar.videoUrl);
        }
        long j8 = bVar.llsid;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j8);
        }
        long j9 = bVar.creativeId;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j9);
        }
        long j10 = bVar.Sd;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_uid", j10);
        }
        String str2 = bVar.Vp;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_user_name", bVar.Vp);
        }
        return jSONObject;
    }
}
