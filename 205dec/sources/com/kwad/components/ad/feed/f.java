package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {
    public static String c(@NonNull AdTemplate adTemplate) {
        String au = com.kwad.sdk.core.response.b.a.au(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
        if (com.kwad.components.core.c.b.mw()) {
            String str = adTemplate.fromCache ? "\u3010cache\u3011" : "";
            return str + au;
        }
        return au;
    }
}
