package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.umeng.analytics.pro.UMCommonContent;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ex */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10047ex implements InterfaceC10273d<HybridLoadMsg> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        m26994a(hybridLoadMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        return m26993b(hybridLoadMsg, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26994a(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hybridLoadMsg.sceneId = jSONObject.optString("scene_id");
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.sceneId)) {
            hybridLoadMsg.sceneId = "";
        }
        hybridLoadMsg.h5Version = jSONObject.optString("h5_version");
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.h5Version)) {
            hybridLoadMsg.h5Version = "";
        }
        hybridLoadMsg.loadType = jSONObject.optInt("load_type");
        hybridLoadMsg.state = jSONObject.optInt("state");
        hybridLoadMsg.interval = jSONObject.optString(UMCommonContent.f37794aX);
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.interval)) {
            hybridLoadMsg.interval = "";
        }
        hybridLoadMsg.failState = jSONObject.optInt("fail_state");
        hybridLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.failReason)) {
            hybridLoadMsg.failReason = "";
        }
        hybridLoadMsg.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.url)) {
            hybridLoadMsg.url = "";
        }
        hybridLoadMsg.packageUrl = jSONObject.optString("package_url");
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.packageUrl)) {
            hybridLoadMsg.packageUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26993b(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = hybridLoadMsg.sceneId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "scene_id", hybridLoadMsg.sceneId);
        }
        String str2 = hybridLoadMsg.h5Version;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "h5_version", hybridLoadMsg.h5Version);
        }
        int i = hybridLoadMsg.loadType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "load_type", i);
        }
        int i2 = hybridLoadMsg.state;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "state", i2);
        }
        String str3 = hybridLoadMsg.interval;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, UMCommonContent.f37794aX, hybridLoadMsg.interval);
        }
        int i3 = hybridLoadMsg.failState;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "fail_state", i3);
        }
        String str4 = hybridLoadMsg.failReason;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "fail_reason", hybridLoadMsg.failReason);
        }
        String str5 = hybridLoadMsg.url;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "url", hybridLoadMsg.url);
        }
        String str6 = hybridLoadMsg.packageUrl;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "package_url", hybridLoadMsg.packageUrl);
        }
        return jSONObject;
    }
}
