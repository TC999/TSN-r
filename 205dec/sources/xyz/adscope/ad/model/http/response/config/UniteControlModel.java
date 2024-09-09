package xyz.adscope.ad.model.http.response.config;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UniteControlModel {
    @JsonNode(key = "duration")
    private long duration;
    @JsonNode(key = "random")
    private int random;

    public long getDuration() {
        return this.duration;
    }

    public int getRandom() {
        return this.random;
    }

    public void setDuration(long j4) {
        this.duration = j4;
    }

    public void setRandom(int i4) {
        this.random = i4;
    }

    public String toString() {
        return "{\"random\":" + this.random + ", \"duration\":" + this.duration + '}';
    }
}
