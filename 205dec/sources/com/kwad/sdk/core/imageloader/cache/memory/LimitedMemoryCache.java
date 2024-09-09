package com.kwad.sdk.core.imageloader.cache.memory;

import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class LimitedMemoryCache extends BaseMemoryCache {
    private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
    private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    private final int sizeLimit;
    private final List<DecodedResult> hardCache = Collections.synchronizedList(new LinkedList());
    private final AtomicInteger cacheSize = new AtomicInteger();

    public LimitedMemoryCache(int i4) {
        this.sizeLimit = i4;
        if (i4 > 16777216) {
            L.w("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.hardCache.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    protected abstract int getSize(DecodedResult decodedResult);

    protected int getSizeLimit() {
        return this.sizeLimit;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        boolean z3;
        int size = getSize(decodedResult);
        int sizeLimit = getSizeLimit();
        int i4 = this.cacheSize.get();
        if (size < sizeLimit) {
            while (i4 + size > sizeLimit) {
                DecodedResult removeNext = removeNext();
                if (this.hardCache.remove(removeNext)) {
                    i4 = this.cacheSize.addAndGet(-getSize(removeNext));
                }
            }
            this.hardCache.add(decodedResult);
            this.cacheSize.addAndGet(size);
            z3 = true;
        } else {
            z3 = false;
        }
        super.put(str, decodedResult);
        return z3;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        DecodedResult decodedResult = super.get(str);
        if (decodedResult != null && this.hardCache.remove(decodedResult)) {
            this.cacheSize.addAndGet(-getSize(decodedResult));
        }
        return super.remove(str);
    }

    protected abstract DecodedResult removeNext();
}
