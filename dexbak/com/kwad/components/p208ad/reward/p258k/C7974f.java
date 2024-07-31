package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.k.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7974f implements InterfaceC10625a {

    @KsJson
    /* renamed from: com.kwad.components.ad.reward.k.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7976a extends C10482a {

        /* renamed from: xi */
        public boolean f26688xi;
    }

    /* renamed from: U */
    public void mo31343U(boolean z) {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(final String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.k.f.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                boolean z;
                try {
                    C7976a c7976a = new C7976a();
                    c7976a.parseJson(new JSONObject(str));
                    z = c7976a.f26688xi;
                } catch (Exception unused) {
                    z = false;
                }
                C7974f.this.mo31343U(z);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
