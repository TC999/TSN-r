package com.kwad.components.p208ad.reward.monitor;

import android.os.SystemClock;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;

/* renamed from: com.kwad.components.ad.reward.monitor.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8033d {
    /* renamed from: a */
    public static void m31745a(AdTemplate adTemplate, boolean z, AdVideoPreCacheConfig adVideoPreCacheConfig) {
        adTemplate.setLoadDataTime(SystemClock.elapsedRealtime());
        adTemplate.setLoadFromCache(z);
        long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * 1024;
        if (adVideoPreCacheSize > 0) {
            adTemplate.setDownloadType(3);
            adTemplate.setDownloadSize(adVideoPreCacheSize);
        } else if (adVideoPreCacheSize < 0) {
            adTemplate.setDownloadType(2);
        } else {
            adTemplate.setDownloadType(1);
            adTemplate.setDownloadSize(0L);
        }
    }
}
