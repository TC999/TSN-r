package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.C8874a;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w;
import com.kwad.components.p208ad.reward.C7907g;

/* renamed from: com.kwad.components.ad.reward.k.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7989o extends AbstractC9230w implements C9092aq.InterfaceC9095b {
    @Nullable

    /* renamed from: oL */
    private C8874a f26692oL;

    public C7989o(C7907g c7907g) {
        C8874a c8874a = c7907g.f26531oL;
        this.f26692oL = c8874a;
        if (c8874a != null) {
            c8874a.m29699a(this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
    /* renamed from: a */
    public final void mo28994a(C9092aq.C9094a c9094a) {
        m29171b(c9094a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerPlayableStatusListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        super.onDestroy();
        C8874a c8874a = this.f26692oL;
        if (c8874a != null) {
            c8874a.m29690b(this);
            this.f26692oL = null;
        }
    }
}
