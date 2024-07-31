package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.video.p331a.C8974d;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10202kq implements InterfaceC10273d<C8974d.C8977b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C8974d.C8977b c8977b, JSONObject jSONObject) {
        m26684a(c8977b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C8974d.C8977b c8977b, JSONObject jSONObject) {
        return m26683b(c8977b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26684a(C8974d.C8977b c8977b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c8977b.f28946Vq = jSONObject.optLong("start_play_duration_ms");
        c8977b.f28947Vr = jSONObject.optLong("first_frame_duration_ms");
        c8977b.f28948Vs = jSONObject.optLong("block_total_duration_ms");
        c8977b.videoDuration = jSONObject.optLong("video_duration_ms");
        c8977b.f28944UX = jSONObject.optInt("block_times");
        c8977b.videoUrl = jSONObject.optString(CampaignEx.JSON_KEY_VIDEO_URL);
        if (JSONObject.NULL.toString().equals(c8977b.videoUrl)) {
            c8977b.videoUrl = "";
        }
        c8977b.llsid = jSONObject.optLong("llsid");
        c8977b.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        c8977b.f28943Sd = jSONObject.optLong("ad_info_uid");
        c8977b.f28945Vp = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(c8977b.f28945Vp)) {
            c8977b.f28945Vp = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26683b(C8974d.C8977b c8977b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c8977b.f28946Vq;
        if (j != 0) {
            C11126t.putValue(jSONObject, "start_play_duration_ms", j);
        }
        long j2 = c8977b.f28947Vr;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "first_frame_duration_ms", j2);
        }
        long j3 = c8977b.f28948Vs;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "block_total_duration_ms", j3);
        }
        long j4 = c8977b.videoDuration;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "video_duration_ms", j4);
        }
        int i = c8977b.f28944UX;
        if (i != 0) {
            C11126t.putValue(jSONObject, "block_times", i);
        }
        String str = c8977b.videoUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_VIDEO_URL, c8977b.videoUrl);
        }
        long j5 = c8977b.llsid;
        if (j5 != 0) {
            C11126t.putValue(jSONObject, "llsid", j5);
        }
        long j6 = c8977b.creativeId;
        if (j6 != 0) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j6);
        }
        long j7 = c8977b.f28943Sd;
        if (j7 != 0) {
            C11126t.putValue(jSONObject, "ad_info_uid", j7);
        }
        String str2 = c8977b.f28945Vp;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "ad_info_user_name", c8977b.f28945Vp);
        }
        return jSONObject;
    }
}
