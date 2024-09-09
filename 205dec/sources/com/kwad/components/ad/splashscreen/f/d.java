package com.kwad.components.ad.splashscreen.f;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends com.kwad.components.core.widget.a.b {
    public d(@NonNull View view, int i4) {
        super(view, i4);
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean dW() {
        com.kwad.sdk.core.c.b.DD();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.DD();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && super.dW();
        }
        return super.dW();
    }
}
