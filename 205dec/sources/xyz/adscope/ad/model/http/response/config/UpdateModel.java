package xyz.adscope.ad.model.http.response.config;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UpdateModel {
    private int checkInterval;
    private long expireTime;
    private long maxExpireTime;

    public int getCheckInterval() {
        return this.checkInterval;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public long getMaxExpireTime() {
        return this.maxExpireTime;
    }

    public void setCheckInterval(int i4) {
        this.checkInterval = i4;
    }

    public void setExpireTime(long j4) {
        this.expireTime = j4;
    }

    public void setMaxExpireTime(long j4) {
        this.maxExpireTime = j4;
    }

    public String toString() {
        return "{\"expireTime\":" + this.expireTime + ", \"maxExpireTime\":" + this.maxExpireTime + ", \"checkInterval\":" + this.checkInterval + '}';
    }
}
