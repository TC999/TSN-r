package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9257r;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9220r implements InterfaceC10625a {
    /* renamed from: a */
    public void mo29003a(C9257r c9257r) {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9257r c9257r = new C9257r();
        try {
            c9257r.parseJson(new JSONObject(str));
            mo29003a(c9257r);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "showTKDialog";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
