package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w;
import com.kwad.sdk.core.response.p408a.C10482a;

/* renamed from: com.kwad.components.ad.reward.k.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7987n extends AbstractC9230w {

    @KsJson
    /* renamed from: com.kwad.components.ad.reward.k.n$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7988a extends C10482a {
        public int status;
    }

    /* renamed from: Z */
    public final void m31904Z(boolean z) {
        C7988a c7988a = new C7988a();
        c7988a.status = z ? 1 : 0;
        m29171b(c7988a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerNeoStatusListener";
    }
}
