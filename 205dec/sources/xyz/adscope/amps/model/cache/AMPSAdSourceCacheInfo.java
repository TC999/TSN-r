package xyz.adscope.amps.model.cache;

import xyz.adscope.amps.base.AMPSBaseAdapter;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSAdSourceCacheInfo {
    private String appId;
    private AMPSBaseAdapter baseAdapter;
    private long cachedOffersTimeout;
    private long cachedTime;
    private int ecpm;
    private String spaceId;

    public String getAppId() {
        return this.appId;
    }

    public AMPSBaseAdapter getBaseAdapter() {
        return this.baseAdapter;
    }

    public long getCachedOffersTimeout() {
        return this.cachedOffersTimeout;
    }

    public long getCachedTime() {
        return this.cachedTime;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBaseAdapter(AMPSBaseAdapter aMPSBaseAdapter) {
        this.baseAdapter = aMPSBaseAdapter;
    }

    public void setCachedOffersTimeout(long j4) {
        this.cachedOffersTimeout = j4;
    }

    public void setCachedTime(long j4) {
        this.cachedTime = j4;
    }

    public void setEcpm(int i4) {
        this.ecpm = i4;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public String toString() {
        return "AMPSAdSourceCacheInfo{appId='" + this.appId + "', spaceId='" + this.spaceId + "', ecpm=" + this.ecpm + ", baseAdapter=" + this.baseAdapter + ", cachedTime=" + this.cachedTime + ", cachedOffersTimeout=" + this.cachedOffersTimeout + '}';
    }
}
