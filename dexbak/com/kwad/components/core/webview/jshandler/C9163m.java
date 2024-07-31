package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.download.C10296a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9163m implements InterfaceC10625a {

    /* renamed from: Wf */
    C10605b f29254Wf;

    /* renamed from: com.kwad.components.core.webview.jshandler.m$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9164a implements InterfaceC9914b {
        public String url;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.url = jSONObject.optString("url");
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "url", this.url);
            return jSONObject;
        }
    }

    public C9163m(C10605b c10605b) {
        this.f29254Wf = c10605b;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            C9164a c9164a = new C9164a();
            c9164a.parseJson(new JSONObject(str));
            String str2 = c9164a.url;
            if (TextUtils.isEmpty(str2)) {
                interfaceC10627c.onError(-1, "no download url specified");
                return;
            }
            C10296a.m26370dx(str2);
            interfaceC10627c.mo25251a(null);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            interfaceC10627c.onError(-1, th.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "cancelAppDownload";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
