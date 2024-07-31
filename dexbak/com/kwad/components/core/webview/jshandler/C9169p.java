package com.kwad.components.core.webview.jshandler;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.kwad.components.core.webview.jshandler.C9166o;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9169p implements InterfaceC10625a {
    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C9166o.C9168a c9168a = new C9166o.C9168a();
        try {
            c9168a.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
        if (TextUtils.isEmpty(c9168a.message)) {
            return;
        }
        Intent intent = new Intent("ksad_webView_local_broadcast");
        intent.putExtra("data", c9168a.message);
        LocalBroadcastManager.getInstance(ServiceProvider.getContext()).sendBroadcast(intent);
        interfaceC10627c.mo25251a(null);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "postMessage";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
