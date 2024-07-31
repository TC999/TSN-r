package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.network.C10424i;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.kwad.sdk.core.b.a.gy */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10102gy implements InterfaceC10273d<C10424i> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10424i c10424i, JSONObject jSONObject) {
        m26884a(c10424i, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10424i c10424i, JSONObject jSONObject) {
        return m26883b(c10424i, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26884a(C10424i c10424i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10424i.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c10424i.url)) {
            c10424i.url = "";
        }
        c10424i.host = jSONObject.optString("host");
        if (JSONObject.NULL.toString().equals(c10424i.host)) {
            c10424i.host = "";
        }
        c10424i.httpCode = jSONObject.optInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_HTTP_CODE);
        c10424i.avO = jSONObject.optString("req_type");
        if (JSONObject.NULL.toString().equals(c10424i.avO)) {
            c10424i.avO = "";
        }
        c10424i.avP = jSONObject.optInt("use_ip");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26883b(C10424i c10424i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10424i.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", c10424i.url);
        }
        String str2 = c10424i.host;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "host", c10424i.host);
        }
        int i = c10424i.httpCode;
        if (i != 0) {
            C11126t.putValue(jSONObject, IjkMediaPlayer.OnNativeInvokeListener.ARG_HTTP_CODE, i);
        }
        String str3 = c10424i.avO;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "req_type", c10424i.avO);
        }
        int i2 = c10424i.avP;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "use_ip", i2);
        }
        return jSONObject;
    }
}
