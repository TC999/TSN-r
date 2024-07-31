package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.p332a.C9011b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.ao */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9089ao implements InterfaceC10625a {

    /* renamed from: XJ */
    private InterfaceC9090a f29180XJ;

    /* renamed from: com.kwad.components.core.webview.jshandler.ao$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9090a {
        /* renamed from: a */
        void mo29284a(C9011b c9011b);
    }

    public C9089ao(InterfaceC9090a interfaceC9090a) {
        this.f29180XJ = interfaceC9090a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9011b c9011b = new C9011b();
        try {
            c9011b.parseJson(new JSONObject(str));
            InterfaceC9090a interfaceC9090a = this.f29180XJ;
            if (interfaceC9090a != null) {
                interfaceC9090a.mo29284a(c9011b);
            }
        } catch (Exception e) {
            interfaceC10627c.onError(-1, "");
            C10331c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "openNewPage";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29180XJ = null;
    }
}
