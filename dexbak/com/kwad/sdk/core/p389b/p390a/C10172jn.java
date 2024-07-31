package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.webview.jshandler.C9176t;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jn */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10172jn implements InterfaceC10273d<C9176t.C9178b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9176t.C9178b c9178b, JSONObject jSONObject) {
        m26744a(c9178b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9176t.C9178b c9178b, JSONObject jSONObject) {
        return m26743b(c9178b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26744a(C9176t.C9178b c9178b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9178b.packageName = jSONObject.optString(TTDownloadField.TT_PACKAGE_NAME);
        if (JSONObject.NULL.toString().equals(c9178b.packageName)) {
            c9178b.packageName = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26743b(C9176t.C9178b c9178b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9178b.packageName;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, c9178b.packageName);
        }
        return jSONObject;
    }
}
