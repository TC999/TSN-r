package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.request.model.C10478d;
import com.kwad.sdk.utils.C11126t;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gx */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10101gx implements InterfaceC10273d<C10478d> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10478d c10478d, JSONObject jSONObject) {
        m26886a(c10478d, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10478d c10478d, JSONObject jSONObject) {
        return m26885b(c10478d, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26886a(C10478d c10478d, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10478d.azF = jSONObject.optString(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
        if (JSONObject.NULL.toString().equals(c10478d.azF)) {
            c10478d.azF = "";
        }
        c10478d.azG = jSONObject.optString("kMac");
        if (JSONObject.NULL.toString().equals(c10478d.azG)) {
            c10478d.azG = "";
        }
        c10478d.azH = jSONObject.optInt("connectionType");
        c10478d.azI = jSONObject.optInt("operatorType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26885b(C10478d c10478d, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10478d.azF;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, SocializeProtocolConstants.PROTOCOL_KEY_MAC, c10478d.azF);
        }
        String str2 = c10478d.azG;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "kMac", c10478d.azG);
        }
        int i = c10478d.azH;
        if (i != 0) {
            C11126t.putValue(jSONObject, "connectionType", i);
        }
        int i2 = c10478d.azI;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "operatorType", i2);
        }
        return jSONObject;
    }
}
