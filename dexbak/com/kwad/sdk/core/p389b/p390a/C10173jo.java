package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.ranger.p447b.p448a.C10955c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10173jo implements InterfaceC10273d<C10955c> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10955c c10955c, JSONObject jSONObject) {
        m26742a(c10955c, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10955c c10955c, JSONObject jSONObject) {
        return m26741b(c10955c, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26742a(C10955c c10955c, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10955c.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(c10955c.name)) {
            c10955c.name = "";
        }
        c10955c.aNO = jSONObject.optString("detect_info");
        if (JSONObject.NULL.toString().equals(c10955c.aNO)) {
            c10955c.aNO = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26741b(C10955c c10955c, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10955c.name;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "name", c10955c.name);
        }
        String str2 = c10955c.aNO;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "detect_info", c10955c.aNO);
        }
        return jSONObject;
    }
}
