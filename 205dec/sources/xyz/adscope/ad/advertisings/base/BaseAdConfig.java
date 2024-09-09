package xyz.adscope.ad.advertisings.base;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class BaseAdConfig {
    public String apiKey;
    public String bidToken;
    public int countryCN;
    public long intervalTime;
    public boolean isMuted;
    public String spaceId;
    public int testAd;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class Builder<T extends BaseAdConfig, B extends Builder<T, B>> {
        public String apiKey;
        public String bidToken;
        public int countryCN;
        public long intervalTime;
        public boolean isMuted;
        public String spaceId;
        public int testAd;

        public B apiKey(String str) {
            this.apiKey = str;
            return this;
        }

        public B bidToken(String str) {
            this.bidToken = str;
            return this;
        }

        public abstract T build();

        public B countryCn(int i4) {
            this.countryCN = i4;
            return this;
        }

        public B intervalTime(long j4) {
            this.intervalTime = j4;
            return this;
        }

        public B setMuted(boolean z3) {
            this.isMuted = z3;
            return this;
        }

        public B spaceId(String str) {
            this.spaceId = str;
            return this;
        }

        public B testAd(int i4) {
            this.testAd = i4;
            return this;
        }
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public int getCountryCN() {
        return this.countryCN;
    }

    public long getIntervalTime() {
        return this.intervalTime;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public int getTestAd() {
        return this.testAd;
    }

    public boolean isMuted() {
        return this.isMuted;
    }

    public void setApiKey(String str) {
        this.apiKey = str;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public void setCountryCN(int i4) {
        this.countryCN = i4;
    }

    public void setIntervalTime(long j4) {
        this.intervalTime = j4;
    }

    public void setMuted(boolean z3) {
        this.isMuted = z3;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setTestAd(int i4) {
        this.testAd = i4;
    }
}
