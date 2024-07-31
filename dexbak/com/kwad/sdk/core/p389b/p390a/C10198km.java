package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.request.model.C10481g;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.km */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10198km implements InterfaceC10273d<C10481g> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10481g c10481g, JSONObject jSONObject) {
        m26692a(c10481g, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10481g c10481g, JSONObject jSONObject) {
        return m26691b(c10481g, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26692a(C10481g c10481g, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10481g.azQ = jSONObject.optString("thirdUserId");
        if (JSONObject.NULL.toString().equals(c10481g.azQ)) {
            c10481g.azQ = "";
        }
        c10481g.azR = jSONObject.optString("thirdUserName");
        if (JSONObject.NULL.toString().equals(c10481g.azR)) {
            c10481g.azR = "";
        }
        c10481g.thirdAge = jSONObject.optInt("thirdAge");
        c10481g.thirdGender = jSONObject.optInt("thirdGender");
        c10481g.thirdInterest = jSONObject.optString("thirdInterest");
        if (JSONObject.NULL.toString().equals(c10481g.thirdInterest)) {
            c10481g.thirdInterest = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26691b(C10481g c10481g, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10481g.azQ;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "thirdUserId", c10481g.azQ);
        }
        String str2 = c10481g.azR;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "thirdUserName", c10481g.azR);
        }
        int i = c10481g.thirdAge;
        if (i != 0) {
            C11126t.putValue(jSONObject, "thirdAge", i);
        }
        int i2 = c10481g.thirdGender;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "thirdGender", i2);
        }
        String str3 = c10481g.thirdInterest;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "thirdInterest", c10481g.thirdInterest);
        }
        return jSONObject;
    }
}
