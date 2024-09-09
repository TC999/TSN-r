package com.kwad.components.ad.splashscreen.e;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class d extends com.kwad.components.core.widget.a.b {
    public d(@NonNull View view, int i4) {
        super(view, i4);
    }

    public final boolean dX() {
        com.kwad.sdk.core.c.b.En();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.En();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && super.dX();
        }
        return super.dX();
    }
}
