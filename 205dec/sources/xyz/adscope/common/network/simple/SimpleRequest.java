package xyz.adscope.common.network.simple;

import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.simple.cache.CacheMode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface SimpleRequest {
    String cacheKey();

    CacheMode cacheMode();

    Converter converter();

    Headers headers();

    Url url();
}
