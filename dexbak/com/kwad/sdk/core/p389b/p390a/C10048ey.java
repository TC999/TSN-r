package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.webview.jshandler.C9140c;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ey */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10048ey implements InterfaceC10273d<C9140c.C9142b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9140c.C9142b c9142b, JSONObject jSONObject) {
        m26992a(c9142b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9140c.C9142b c9142b, JSONObject jSONObject) {
        return m26991b(c9142b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26992a(C9140c.C9142b c9142b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9142b.packageName = jSONObject.optString(TTDownloadField.TT_PACKAGE_NAME);
        if (JSONObject.NULL.toString().equals(c9142b.packageName)) {
            c9142b.packageName = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26991b(C9140c.C9142b c9142b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9142b.packageName;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, c9142b.packageName);
        }
        return jSONObject;
    }
}
