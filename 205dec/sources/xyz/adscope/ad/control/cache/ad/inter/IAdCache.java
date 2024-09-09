package xyz.adscope.ad.control.cache.ad.inter;

import xyz.adscope.ad.control.cache.ad.AdCacheModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IAdCache {
    void addCacheAd(AdCacheModel adCacheModel);

    void deleteCacheAd(String str);

    void deleteOutTimeCacheAd();

    String readCacheAd(String str);
}
