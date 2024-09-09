package com.kwad.components.core.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j {
    public static boolean d(@NonNull AdTemplate adTemplate, boolean z3) {
        if (!z3 && com.kwad.sdk.core.response.b.b.dj(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            return com.kwad.sdk.core.config.d.CD();
        }
        return false;
    }

    public static void e(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        com.kwad.components.core.e.d.a.a(new a.C0631a(context).am(true).aq(adTemplate));
    }
}
