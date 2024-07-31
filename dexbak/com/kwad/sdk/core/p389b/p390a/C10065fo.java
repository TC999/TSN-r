package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.kwad.sdk.core.b.a.fo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10065fo implements InterfaceC10273d<HttpDnsInfo.IpInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        m26958a(ipInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        return m26957b(ipInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26958a(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ipInfo.f29585ip = jSONObject.optString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
        if (JSONObject.NULL.toString().equals(ipInfo.f29585ip)) {
            ipInfo.f29585ip = "";
        }
        ipInfo.weight = jSONObject.optInt("weight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26957b(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = ipInfo.f29585ip;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, ipInfo.f29585ip);
        }
        int i = ipInfo.weight;
        if (i != 0) {
            C11126t.putValue(jSONObject, "weight", i);
        }
        return jSONObject;
    }
}
