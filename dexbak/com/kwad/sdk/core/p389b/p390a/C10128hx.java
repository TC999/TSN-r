package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.ranger.C10957c;
import com.kwad.sdk.ranger.p446a.C10946a;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hx */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10128hx implements InterfaceC10273d<C10957c> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10957c c10957c, JSONObject jSONObject) {
        m26832a(c10957c, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10957c c10957c, JSONObject jSONObject) {
        return m26831b(c10957c, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26832a(C10957c c10957c, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10957c.funcSwitch = jSONObject.optLong("funcSwitch");
        c10957c.aNk = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urlList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c10957c.aNk.add((String) optJSONArray.opt(i));
            }
        }
        c10957c.aNl = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                C10957c.C10958a c10958a = new C10957c.C10958a();
                c10958a.parseJson(optJSONArray2.optJSONObject(i2));
                c10957c.aNl.add(c10958a);
            }
        }
        c10957c.byteCount = jSONObject.optLong("byteCount");
        c10957c.sampleRate = jSONObject.optDouble("sampleRate");
        c10957c.aNm = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                C10946a c10946a = new C10946a();
                c10946a.parseJson(optJSONArray3.optJSONObject(i3));
                c10957c.aNm.add(c10946a);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26831b(C10957c c10957c, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c10957c.funcSwitch;
        if (j != 0) {
            C11126t.putValue(jSONObject, "funcSwitch", j);
        }
        C11126t.putValue(jSONObject, "urlList", c10957c.aNk);
        C11126t.putValue(jSONObject, "actConfigList", c10957c.aNl);
        long j2 = c10957c.byteCount;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "byteCount", j2);
        }
        double d = c10957c.sampleRate;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "sampleRate", d);
        }
        C11126t.putValue(jSONObject, "anchorNodeList", c10957c.aNm);
        return jSONObject;
    }
}
