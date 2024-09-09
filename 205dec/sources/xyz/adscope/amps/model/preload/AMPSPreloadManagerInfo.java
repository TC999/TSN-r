package xyz.adscope.amps.model.preload;

import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSPreloadManagerInfo {
    private AMPSBaseOpenApiManager baseOpenApiManager;
    private long cachedOffersTimeout;
    private long cachedTime;
    private String spaceId;

    public AMPSBaseOpenApiManager getBaseOpenApiManager() {
        return this.baseOpenApiManager;
    }

    public long getCachedOffersTimeout() {
        return this.cachedOffersTimeout;
    }

    public long getCachedTime() {
        return this.cachedTime;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setBaseOpenApiManager(AMPSBaseOpenApiManager aMPSBaseOpenApiManager) {
        this.baseOpenApiManager = aMPSBaseOpenApiManager;
    }

    public void setCachedOffersTimeout(long j4) {
        this.cachedOffersTimeout = j4;
    }

    public void setCachedTime(long j4) {
        this.cachedTime = j4;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }
}
