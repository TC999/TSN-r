package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9140c implements InterfaceC10625a {

    /* renamed from: com.kwad.components.core.webview.jshandler.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9141a extends C10482a {

        /* renamed from: VW */
        public boolean f29235VW;

        @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "isInstalled", this.f29235VW);
            return jSONObject;
        }
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9142b extends C10482a {
        public String packageName;
    }

    /* renamed from: aH */
    private static boolean m29238aH(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return C11017ak.m24114an(ServiceProvider.getContext(), str);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9142b c9142b = new C9142b();
        try {
            c9142b.parseJson(new JSONObject(str));
        } catch (Exception unused) {
        }
        C9141a c9141a = new C9141a();
        c9141a.f29235VW = m29238aH(c9142b.packageName);
        interfaceC10627c.mo25251a(c9141a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "isAppInstalled";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
