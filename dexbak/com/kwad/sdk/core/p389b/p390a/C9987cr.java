package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.crash.C10654a;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cr */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9987cr implements InterfaceC10273d<C10654a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10654a c10654a, JSONObject jSONObject) {
        m27108a(c10654a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10654a c10654a, JSONObject jSONObject) {
        return m27107b(c10654a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27108a(C10654a c10654a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10654a.aEY = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c10654a.aEY.add((String) optJSONArray.opt(i));
            }
        }
        c10654a.aEZ = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                c10654a.aEZ.add((String) optJSONArray2.opt(i2));
            }
        }
        c10654a.aFa = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("stacktraceList");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                c10654a.aFa.add((String) optJSONArray3.opt(i3));
            }
        }
        c10654a.aFb = jSONObject.optDouble("crashUploadRate", new Double("1.0").doubleValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27107b(C10654a c10654a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "appIdList", c10654a.aEY);
        C11126t.putValue(jSONObject, "sdkVersionList", c10654a.aEZ);
        C11126t.putValue(jSONObject, "stacktraceList", c10654a.aFa);
        C11126t.putValue(jSONObject, "crashUploadRate", c10654a.aFb);
        return jSONObject;
    }
}
