package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.t */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9223t implements InterfaceC10625a {

    /* renamed from: ZQ */
    private InterfaceC9224a f29302ZQ;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.t$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9224a {
        /* renamed from: b */
        void mo28992b(C9259t c9259t);
    }

    /* renamed from: a */
    public final void m29176a(InterfaceC9224a interfaceC9224a) {
        this.f29302ZQ = interfaceC9224a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "skipVideo";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29302ZQ = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f29302ZQ != null) {
            C9259t c9259t = new C9259t();
            try {
                try {
                    c9259t.parseJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } finally {
                this.f29302ZQ.mo28992b(c9259t);
            }
        }
    }
}
