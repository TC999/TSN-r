package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9256q;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.k.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7982k implements InterfaceC10625a {

    /* renamed from: xl */
    private InterfaceC7983a f26691xl;

    /* renamed from: com.kwad.components.ad.reward.k.k$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7983a {
        /* renamed from: d */
        void mo31341d(C9256q c9256q);
    }

    /* renamed from: a */
    public final void m31907a(InterfaceC7983a interfaceC7983a) {
        this.f26691xl = interfaceC7983a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "showPlayEnd";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f26691xl = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f26691xl != null) {
            C9256q c9256q = new C9256q();
            try {
                c9256q.parseJson(new JSONObject(str));
                this.f26691xl.mo31341d(c9256q);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
