package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.tachikoma.p334b.C9249j;
import com.kwad.sdk.core.p385a.C9886c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.crash.utils.C10737a;
import io.netty.handler.codec.http.HttpHeaders;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9143d implements InterfaceC10625a {

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9144a extends C10482a {
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
        C9144a c9144a = new C9144a();
        if (TextUtils.isEmpty(c9249j.data)) {
            c9144a.data = "";
        } else {
            c9144a.data = new String(C9886c.m27444Ds().encode(c9249j.data.getBytes()), C10737a.UTF_8);
        }
        interfaceC10627c.mo25251a(c9144a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return HttpHeaders.Values.BASE64;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
