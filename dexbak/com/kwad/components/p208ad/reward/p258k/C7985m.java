package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w;
import com.kwad.sdk.core.response.p408a.C10482a;

/* renamed from: com.kwad.components.ad.reward.k.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7985m extends AbstractC9230w {

    @KsJson
    /* renamed from: com.kwad.components.ad.reward.k.m$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7986a extends C10482a {
        public String name = "backPressed";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerBackPressedListener";
    }

    /* renamed from: jg */
    public final void m31905jg() {
        m29171b(new C7986a());
    }
}
