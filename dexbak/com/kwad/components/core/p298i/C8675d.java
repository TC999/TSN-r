package com.kwad.components.core.p298i;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInnerAd;

/* renamed from: com.kwad.components.core.i.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8675d {
    @Nullable

    /* renamed from: Me */
    private Object f28345Me;

    public C8675d(Object obj) {
        this.f28345Me = obj;
    }

    /* renamed from: c */
    public final void m30036c(C8674c c8674c) {
        if (this.f28345Me == null || c8674c == null || c8674c.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.f28345Me).onAdClicked((KsInnerAd) c8674c.getHost());
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    public final void m30035d(C8674c c8674c) {
        if (this.f28345Me == null || c8674c == null || c8674c.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.f28345Me).onAdShow((KsInnerAd) c8674c.getHost());
        } catch (Exception unused) {
        }
    }

    public final void destroy() {
        this.f28345Me = null;
    }
}
