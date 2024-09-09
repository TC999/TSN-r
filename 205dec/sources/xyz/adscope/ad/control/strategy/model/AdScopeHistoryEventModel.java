package xyz.adscope.ad.control.strategy.model;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeHistoryEventModel {
    private String apiKey;
    private String eventCode;
    private long eventTime;
    private String spaceId;

    public String getApiKey() {
        return this.apiKey;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setApiKey(String str) {
        this.apiKey = str;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setEventTime(long j4) {
        this.eventTime = j4;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }
}
