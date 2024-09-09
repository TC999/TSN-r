package xyz.adscope.ad.control.cache.ad;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdCacheModel {
    public String cacheData;
    public String cacheKey;
    public long cacheTime;
    public long expireTime;

    public String getCacheData() {
        return this.cacheData;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public long getCacheTime() {
        return this.cacheTime;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public void setCacheData(String str) {
        this.cacheData = str;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public void setCacheTime(long j4) {
        this.cacheTime = j4;
    }

    public void setExpireTime(long j4) {
        this.expireTime = j4;
    }
}
