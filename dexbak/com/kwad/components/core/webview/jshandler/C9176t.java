package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.t */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9176t implements InterfaceC10625a {

    /* renamed from: com.kwad.components.core.webview.jshandler.t$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9177a extends C10482a {

        /* renamed from: Wn */
        public boolean f29263Wn;

        @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "isStarted", this.f29263Wn);
            return jSONObject;
        }
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.t$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9178b extends C10482a {
        public String packageName;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9178b c9178b = new C9178b();
        try {
            c9178b.parseJson(new JSONObject(str));
        } catch (Exception unused) {
        }
        C9177a c9177a = new C9177a();
        c9177a.f29263Wn = C11017ak.m24112ap(ServiceProvider.getContext(), c9178b.packageName);
        interfaceC10627c.mo25251a(c9177a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "startApp";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
