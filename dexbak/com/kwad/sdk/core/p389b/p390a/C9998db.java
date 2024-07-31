package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.webview.p332a.C9006a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.db */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9998db implements InterfaceC10273d<C9006a.C9009a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9006a.C9009a c9009a, JSONObject jSONObject) {
        m27086a(c9009a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9006a.C9009a c9009a, JSONObject jSONObject) {
        return m27085b(c9009a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27086a(C9006a.C9009a c9009a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9009a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c9009a.url)) {
            c9009a.url = "";
        }
        c9009a.packageName = jSONObject.optString(TTDownloadField.TT_PACKAGE_NAME);
        if (JSONObject.NULL.toString().equals(c9009a.packageName)) {
            c9009a.packageName = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27085b(C9006a.C9009a c9009a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9009a.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", c9009a.url);
        }
        String str2 = c9009a.packageName;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, c9009a.packageName);
        }
        return jSONObject;
    }
}
