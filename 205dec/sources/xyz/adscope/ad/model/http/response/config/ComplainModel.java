package xyz.adscope.ad.model.http.response.config;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ComplainModel {
    @JsonNode(key = "duration")
    public long duration;

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j4) {
        this.duration = j4;
    }

    public String toString() {
        return "{\"duration\":" + this.duration + '}';
    }
}
