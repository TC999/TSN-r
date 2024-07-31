package com.kwad.components.p208ad.splashscreen.p284f;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.sdk.core.p391c.C10232b;

/* renamed from: com.kwad.components.ad.splashscreen.f.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8487d extends C9366b {
    public C8487d(@NonNull View view, int i) {
        super(view, i);
    }

    @Override // com.kwad.components.core.widget.p338a.C9366b, com.kwad.components.core.widget.p338a.AbstractC9364a
    /* renamed from: dW */
    public final boolean mo28897dW() {
        C10232b.m26625DD();
        if (C10232b.isEnable()) {
            C10232b.m26625DD();
            return C10232b.isAppOnForeground() && super.mo28897dW();
        }
        return super.mo28897dW();
    }
}
