package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.di */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10005di implements InterfaceC10273d<C10819a.C10822b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10819a.C10822b c10822b, JSONObject jSONObject) {
        m27072a(c10822b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10819a.C10822b c10822b, JSONObject jSONObject) {
        return m27071b(c10822b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27072a(C10819a.C10822b c10822b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10822b.sdkVersion = jSONObject.optString("run_sdk_version");
        if (JSONObject.NULL.toString().equals(c10822b.sdkVersion)) {
            c10822b.sdkVersion = "";
        }
        c10822b.aJA = jSONObject.optLong("trigger_count", new Long("0").longValue());
        c10822b.aJB = jSONObject.optLong("fail_count", new Long("0").longValue());
        c10822b.aJC = jSONObject.optLong("real_fail_count", new Long("0").longValue());
        c10822b.aJD = jSONObject.optString("business");
        if (JSONObject.NULL.toString().equals(c10822b.aJD)) {
            c10822b.aJD = "";
        }
        c10822b.stage = jSONObject.optString("stage");
        if (JSONObject.NULL.toString().equals(c10822b.stage)) {
            c10822b.stage = "";
        }
        c10822b.aJE = jSONObject.optString("function");
        if (JSONObject.NULL.toString().equals(c10822b.aJE)) {
            c10822b.aJE = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27071b(C10819a.C10822b c10822b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10822b.sdkVersion;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "run_sdk_version", c10822b.sdkVersion);
        }
        C11126t.putValue(jSONObject, "trigger_count", c10822b.aJA);
        C11126t.putValue(jSONObject, "fail_count", c10822b.aJB);
        C11126t.putValue(jSONObject, "real_fail_count", c10822b.aJC);
        String str2 = c10822b.aJD;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "business", c10822b.aJD);
        }
        String str3 = c10822b.stage;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "stage", c10822b.stage);
        }
        String str4 = c10822b.aJE;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "function", c10822b.aJE);
        }
        return jSONObject;
    }
}
