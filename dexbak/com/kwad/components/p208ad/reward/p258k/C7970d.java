package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9255p;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.k.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7970d implements InterfaceC10625a {

    /* renamed from: xe */
    private InterfaceC7971a f26684xe;

    /* renamed from: com.kwad.components.ad.reward.k.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7971a {
        /* renamed from: a */
        void mo31347a(C9255p c9255p);
    }

    /* renamed from: a */
    public final void m31911a(InterfaceC7971a interfaceC7971a) {
        this.f26684xe = interfaceC7971a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "clickCall";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f26684xe = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9255p c9255p = new C9255p();
        try {
            c9255p.parseJson(new JSONObject(str));
            InterfaceC7971a interfaceC7971a = this.f26684xe;
            if (interfaceC7971a != null) {
                interfaceC7971a.mo31347a(c9255p);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
