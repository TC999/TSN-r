package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9205i implements InterfaceC10625a {

    /* renamed from: ZJ */
    private InterfaceC9206a f29293ZJ;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.i$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9206a {
        /* renamed from: a */
        void mo29185a(C10640a c10640a);
    }

    public C9205i(InterfaceC9206a interfaceC9206a) {
        this.f29293ZJ = interfaceC9206a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C10640a c10640a = new C10640a();
        try {
            c10640a.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
        }
        InterfaceC9206a interfaceC9206a = this.f29293ZJ;
        if (interfaceC9206a != null) {
            interfaceC9206a.mo29185a(c10640a);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "notifyClickAd";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
