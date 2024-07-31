package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.video.p331a.C8974d;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10201kp implements InterfaceC10273d<C8974d.C8976a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C8974d.C8976a c8976a, JSONObject jSONObject) {
        m26686a(c8976a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C8974d.C8976a c8976a, JSONObject jSONObject) {
        return m26685b(c8976a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26686a(C8974d.C8976a c8976a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c8976a.code = jSONObject.optInt("code");
        c8976a.msg = jSONObject.optString("msg");
        if (JSONObject.NULL.toString().equals(c8976a.msg)) {
            c8976a.msg = "";
        }
        c8976a.videoUrl = jSONObject.optString(CampaignEx.JSON_KEY_VIDEO_URL);
        if (JSONObject.NULL.toString().equals(c8976a.videoUrl)) {
            c8976a.videoUrl = "";
        }
        c8976a.llsid = jSONObject.optLong("llsid");
        c8976a.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        c8976a.f28941Sd = jSONObject.optLong("ad_info_uid");
        c8976a.f28942Vp = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(c8976a.f28942Vp)) {
            c8976a.f28942Vp = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26685b(C8974d.C8976a c8976a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c8976a.code;
        if (i != 0) {
            C11126t.putValue(jSONObject, "code", i);
        }
        String str = c8976a.msg;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "msg", c8976a.msg);
        }
        String str2 = c8976a.videoUrl;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_VIDEO_URL, c8976a.videoUrl);
        }
        long j = c8976a.llsid;
        if (j != 0) {
            C11126t.putValue(jSONObject, "llsid", j);
        }
        long j2 = c8976a.creativeId;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j2);
        }
        long j3 = c8976a.f28941Sd;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "ad_info_uid", j3);
        }
        String str3 = c8976a.f28942Vp;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "ad_info_user_name", c8976a.f28942Vp);
        }
        return jSONObject;
    }
}
