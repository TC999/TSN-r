package com.kwad.sdk.utils;

import com.kwad.sdk.core.response.model.AdTemplate;

/* renamed from: com.kwad.sdk.utils.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11103l {
    public static long aOE = -1;

    /* renamed from: ej */
    public static void m23775ej(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = aOE;
            adTemplate.mOutClickTimeParam = aOE;
        }
    }

    /* renamed from: ek */
    public static void m23774ek(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mOutClickTimeParam = System.currentTimeMillis();
        }
    }

    /* renamed from: el */
    public static void m23773el(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = System.currentTimeMillis();
        }
    }

    /* renamed from: em */
    public static long m23772em(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return System.currentTimeMillis();
        }
        long j = adTemplate.mOutClickTimeParam;
        return j > 0 ? j : adTemplate.mVisibleTimeParam;
    }
}
