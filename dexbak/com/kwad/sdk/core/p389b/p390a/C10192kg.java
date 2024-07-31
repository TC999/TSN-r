package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10192kg implements InterfaceC10273d<URLPackage> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(URLPackage uRLPackage, JSONObject jSONObject) {
        m26704a(uRLPackage, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(URLPackage uRLPackage, JSONObject jSONObject) {
        return m26703b(uRLPackage, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26704a(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uRLPackage.page = jSONObject.optInt("page");
        uRLPackage.identity = jSONObject.optString("identity");
        if (JSONObject.NULL.toString().equals(uRLPackage.identity)) {
            uRLPackage.identity = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26703b(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = uRLPackage.page;
        if (i != 0) {
            C11126t.putValue(jSONObject, "page", i);
        }
        String str = uRLPackage.identity;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "identity", uRLPackage.identity);
        }
        return jSONObject;
    }
}
