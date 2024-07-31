package com.kwad.sdk.core.webview.p423d;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.request.C10646b;
import com.kwad.sdk.core.webview.request.WebCardGetDataResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.webview.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10637b implements InterfaceC10625a {
    private InterfaceC10627c aEJ;

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.d.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10639a extends C10482a implements InterfaceC9914b {
        public String method;
        public String params;
        public String url;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "requestData";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.aEJ = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.aEJ = interfaceC10627c;
        C10639a c10639a = new C10639a();
        try {
            c10639a.parseJson(new JSONObject(str));
            m25243a(c10639a);
        } catch (JSONException e) {
            InterfaceC10627c interfaceC10627c2 = this.aEJ;
            if (interfaceC10627c2 != null) {
                interfaceC10627c2.onError(-1, "data parse json error.");
            }
            C10331c.printStackTraceOnly(e);
        }
    }

    /* renamed from: a */
    private void m25243a(C10639a c10639a) {
        new C10646b().m25237a(c10639a, new C10646b.InterfaceC10653a() { // from class: com.kwad.sdk.core.webview.d.b.1
            @Override // com.kwad.sdk.core.webview.request.C10646b.InterfaceC10653a
            /* renamed from: a */
            public final void mo25231a(@NonNull WebCardGetDataResponse webCardGetDataResponse) {
                if (C10637b.this.aEJ != null) {
                    C10637b.this.aEJ.mo25251a(webCardGetDataResponse);
                }
            }

            @Override // com.kwad.sdk.core.webview.request.C10646b.InterfaceC10653a
            public final void onError(int i, String str) {
                if (C10637b.this.aEJ != null) {
                    C10637b.this.aEJ.onError(i, str);
                }
            }
        });
    }
}
