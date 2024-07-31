package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.crash.online.monitor.p428a.C10697b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dr */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10014dr implements InterfaceC10273d<C10697b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10697b c10697b, JSONObject jSONObject) {
        m27054a(c10697b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10697b c10697b, JSONObject jSONObject) {
        return m27053b(c10697b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27054a(C10697b c10697b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10697b.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c10697b.appId)) {
            c10697b.appId = "";
        }
        c10697b.aGX = jSONObject.optString("pluginListenerName");
        if (JSONObject.NULL.toString().equals(c10697b.aGX)) {
            c10697b.aGX = "";
        }
        c10697b.aGY = jSONObject.optString("reportMethodName");
        if (JSONObject.NULL.toString().equals(c10697b.aGY)) {
            c10697b.aGY = "";
        }
        c10697b.aGZ = jSONObject.optString("otherProxyClassName");
        if (JSONObject.NULL.toString().equals(c10697b.aGZ)) {
            c10697b.aGZ = "";
        }
        c10697b.aHa = jSONObject.optString("otherFieldName");
        if (JSONObject.NULL.toString().equals(c10697b.aHa)) {
            c10697b.aHa = "";
        }
        c10697b.aHb = jSONObject.optString("otherLevelFieldName");
        if (JSONObject.NULL.toString().equals(c10697b.aHb)) {
            c10697b.aHb = "";
        }
        c10697b.aHc = jSONObject.optString("blockTag");
        if (JSONObject.NULL.toString().equals(c10697b.aHc)) {
            c10697b.aHc = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27053b(C10697b c10697b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10697b.appId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "appId", c10697b.appId);
        }
        String str2 = c10697b.aGX;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "pluginListenerName", c10697b.aGX);
        }
        String str3 = c10697b.aGY;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "reportMethodName", c10697b.aGY);
        }
        String str4 = c10697b.aGZ;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "otherProxyClassName", c10697b.aGZ);
        }
        String str5 = c10697b.aHa;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "otherFieldName", c10697b.aHa);
        }
        String str6 = c10697b.aHb;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "otherLevelFieldName", c10697b.aHb);
        }
        String str7 = c10697b.aHc;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "blockTag", c10697b.aHc);
        }
        return jSONObject;
    }
}
