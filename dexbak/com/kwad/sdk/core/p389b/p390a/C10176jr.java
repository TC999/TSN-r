package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9174s;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jr */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10176jr implements InterfaceC10273d<C9174s.C9175a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9174s.C9175a c9175a, JSONObject jSONObject) {
        m26736a(c9175a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9174s.C9175a c9175a, JSONObject jSONObject) {
        return m26735b(c9175a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26736a(C9174s.C9175a c9175a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9175a.key = jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY);
        if (JSONObject.NULL.toString().equals(c9175a.key)) {
            c9175a.key = "";
        }
        c9175a.value = jSONObject.optString(DomainCampaignEx.LOOPBACK_VALUE);
        if (JSONObject.NULL.toString().equals(c9175a.value)) {
            c9175a.value = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26735b(C9174s.C9175a c9175a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9175a.key;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, DomainCampaignEx.LOOPBACK_KEY, c9175a.key);
        }
        String str2 = c9175a.value;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, DomainCampaignEx.LOOPBACK_VALUE, c9175a.value);
        }
        return jSONObject;
    }
}
