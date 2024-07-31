package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.download.C10296a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9161l implements InterfaceC10625a {

    /* renamed from: Wf */
    C10605b f29252Wf;

    /* renamed from: com.kwad.components.core.webview.jshandler.l$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9162a implements InterfaceC9914b {

        /* renamed from: Jj */
        private String f29253Jj;
        private AdTemplate adTemplate;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f29253Jj = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.m23678a(jSONObject, "adTemplate", this.adTemplate);
            C11126t.putValue(jSONObject, "creativeId", this.f29253Jj);
            return jSONObject;
        }
    }

    public C9161l(C10605b c10605b) {
        this.f29252Wf = c10605b;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            C9162a c9162a = new C9162a();
            c9162a.parseJson(new JSONObject(str));
            C10296a.m26370dx(C10487e.m25641dQ(m29225a(c9162a)).adConversionInfo.appDownloadUrl);
            interfaceC10627c.mo25251a(null);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            interfaceC10627c.onError(-1, th.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "cancelAppDownloadForAd";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    /* renamed from: a */
    private AdTemplate m29225a(C9162a c9162a) {
        if (c9162a.adTemplate != null) {
            return c9162a.adTemplate;
        }
        return this.f29252Wf.m25324cV(c9162a.f29253Jj);
    }
}
