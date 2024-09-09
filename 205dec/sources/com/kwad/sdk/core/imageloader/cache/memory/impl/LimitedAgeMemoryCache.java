package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class LimitedAgeMemoryCache implements MemoryCache {
    private final MemoryCache cache;
    private final Map<String, Long> loadingDates = Collections.synchronizedMap(new HashMap());
    private final long maxAge;

    public LimitedAgeMemoryCache(MemoryCache memoryCache, long j4) {
        this.cache = memoryCache;
        this.maxAge = j4 * 1000;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.cache.clear();
        this.loadingDates.clear();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult get(String str) {
        Long l4 = this.loadingDates.get(str);
        if (l4 != null && System.currentTimeMillis() - l4.longValue() > this.maxAge) {
            this.cache.remove(str);
            this.loadingDates.remove(str);
        }
        return this.cache.get(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        return this.cache.keys();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        boolean put = this.cache.put(str, decodedResult);
        if (put) {
            this.loadingDates.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return put;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        this.loadingDates.remove(str);
        return this.cache.remove(str);
    }
}
