package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.webview.jshandler.C9157k;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fe */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10055fe implements InterfaceC10273d<C9157k.C9159a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9157k.C9159a c9159a, JSONObject jSONObject) {
        m26978a(c9159a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9157k.C9159a c9159a, JSONObject jSONObject) {
        return m26977b(c9159a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26978a(C9157k.C9159a c9159a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9159a.f29251We = jSONObject.optString("apkUrl");
        if (JSONObject.NULL.toString().equals(c9159a.f29251We)) {
            c9159a.f29251We = "";
        }
        c9159a.packageName = jSONObject.optString(TTDownloadField.TT_PACKAGE_NAME);
        if (JSONObject.NULL.toString().equals(c9159a.packageName)) {
            c9159a.packageName = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26977b(C9157k.C9159a c9159a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9159a.f29251We;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "apkUrl", c9159a.f29251We);
        }
        String str2 = c9159a.packageName;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, c9159a.packageName);
        }
        return jSONObject;
    }
}
