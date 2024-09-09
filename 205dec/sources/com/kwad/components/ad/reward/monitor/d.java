package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public static void a(AdTemplate adTemplate, boolean z3, AdVideoPreCacheConfig adVideoPreCacheConfig) {
        adTemplate.setLoadDataTime(SystemClock.elapsedRealtime());
        adTemplate.setLoadFromCache(z3);
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
