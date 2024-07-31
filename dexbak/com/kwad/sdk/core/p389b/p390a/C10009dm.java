package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dm */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10009dm implements InterfaceC10273d<C9908c.C9911a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9908c.C9911a c9911a, JSONObject jSONObject) {
        m27064a(c9911a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9908c.C9911a c9911a, JSONObject jSONObject) {
        return m27063b(c9911a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27064a(C9908c.C9911a c9911a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9911a.code = jSONObject.optInt("code");
        c9911a.msg = jSONObject.optString("msg");
        if (JSONObject.NULL.toString().equals(c9911a.msg)) {
            c9911a.msg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27063b(C9908c.C9911a c9911a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9911a.code;
        if (i != 0) {
            C11126t.putValue(jSONObject, "code", i);
        }
        String str = c9911a.msg;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "msg", c9911a.msg);
        }
        return jSONObject;
    }
}
