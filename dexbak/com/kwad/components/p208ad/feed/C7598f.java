package com.kwad.components.p208ad.feed;

import androidx.annotation.NonNull;
import com.kwad.components.core.p287c.C8546b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.feed.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7598f {
    /* renamed from: c */
    public static String m32829c(@NonNull AdTemplate adTemplate) {
        String m25915au = C10483a.m25915au(C10487e.m25641dQ(adTemplate));
        if (C8546b.m30396mw()) {
            String str = adTemplate.fromCache ? "【cache】" : "";
            return str + m25915au;
        }
        return m25915au;
    }
}
