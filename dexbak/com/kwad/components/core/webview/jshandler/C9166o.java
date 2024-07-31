package com.kwad.components.core.webview.jshandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.crash.C10656b;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.core.webview.jshandler.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9166o implements InterfaceC10625a {

    /* renamed from: Wg */
    private BroadcastReceiver f29255Wg = new BroadcastReceiver() { // from class: com.kwad.components.core.webview.jshandler.o.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("data");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            C9168a c9168a = new C9168a();
            c9168a.message = stringExtra;
            C9166o.this.f29256ns.mo25251a(c9168a);
        }
    };

    /* renamed from: ns */
    private InterfaceC10627c f29256ns;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.o$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9168a extends C10482a {
        public String message;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "onMessage";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        try {
            LocalBroadcastManager.getInstance(ServiceProvider.getContext()).unregisterReceiver(this.f29255Wg);
        } catch (Throwable th) {
            C10656b.m25209n(th);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29256ns = interfaceC10627c;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ksad_webView_local_broadcast");
        try {
            LocalBroadcastManager.getInstance(ServiceProvider.getContext()).registerReceiver(this.f29255Wg, intentFilter);
        } catch (Throwable th) {
            C10656b.m25209n(th);
        }
        interfaceC10627c.mo25251a(null);
    }
}
