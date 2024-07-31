package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.v */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9228v implements InterfaceC10625a {

    /* renamed from: ZS */
    private InterfaceC9229a f29304ZS;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.v$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9229a {
        /* renamed from: b */
        void mo29004b(C9252m c9252m);
    }

    /* renamed from: a */
    public final void m29173a(InterfaceC9229a interfaceC9229a) {
        this.f29304ZS = interfaceC9229a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "updateVideoMuteState";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29304ZS = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f29304ZS != null) {
            C9252m c9252m = new C9252m();
            try {
                c9252m.parseJson(new JSONObject(str));
                this.f29304ZS.mo29004b(c9252m);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
