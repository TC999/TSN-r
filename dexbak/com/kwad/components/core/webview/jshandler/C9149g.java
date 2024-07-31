package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.tachikoma.p334b.C9249j;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11010ad;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9149g implements InterfaceC10625a {

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9150a extends C10482a {
        public String data;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9249j c9249j = new C9249j();
        try {
            c9249j.parseJson(new JSONObject(str));
        } catch (Exception unused) {
        }
        C9150a c9150a = new C9150a();
        if (TextUtils.isEmpty(c9249j.data)) {
            c9150a.data = "";
        } else {
            c9150a.data = C11010ad.m24144bu(c9249j.data);
        }
        interfaceC10627c.mo25251a(c9150a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "md5";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
