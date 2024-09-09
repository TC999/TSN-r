package xyz.adscope.ad.model.http.response.config;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdCacheConfigModel {
    private String adType;
    private int enable;
    private long reqAdTimeLimit;

    public String getAdType() {
        return this.adType;
    }

    public int getEnable() {
        return this.enable;
    }

    public long getReqAdTimeLimit() {
        return this.reqAdTimeLimit;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setEnable(int i4) {
        this.enable = i4;
    }

    public void setReqAdTimeLimit(long j4) {
        this.reqAdTimeLimit = j4;
    }

    public String toString() {
        return "{\"adType\":\"" + this.adType + "\", \"enable\":" + this.enable + ", \"reqAdTimeLimit\":" + this.reqAdTimeLimit + '}';
    }
}
