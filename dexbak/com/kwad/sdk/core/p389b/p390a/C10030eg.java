package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.ranger.p447b.p448a.C10953a;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.eg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10030eg implements InterfaceC10273d<C10953a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10953a c10953a, JSONObject jSONObject) {
        m27028a(c10953a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10953a c10953a, JSONObject jSONObject) {
        return m27027b(c10953a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27028a(C10953a c10953a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10953a.key = jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY);
        if (JSONObject.NULL.toString().equals(c10953a.key)) {
            c10953a.key = "";
        }
        c10953a.value = jSONObject.optInt(DomainCampaignEx.LOOPBACK_VALUE);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27027b(C10953a c10953a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10953a.key;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, DomainCampaignEx.LOOPBACK_KEY, c10953a.key);
        }
        int i = c10953a.value;
        if (i != 0) {
            C11126t.putValue(jSONObject, DomainCampaignEx.LOOPBACK_VALUE, i);
        }
        return jSONObject;
    }
}
