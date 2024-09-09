package xyz.adscope.ad.tool.event.model;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ASNPReportDBModel {
    public String eventCode = "";
    public String eventId = "";
    public long eventTime = 0;
    public String eventJsonStr = "";
    public String apiKey = "";

    public String getApiKey() {
        return this.apiKey;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getEventJsonStr() {
        return this.eventJsonStr;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public void setApiKey(String str) {
        this.apiKey = str;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setEventJsonStr(String str) {
        this.eventJsonStr = str;
    }

    public void setEventTime(long j4) {
        this.eventTime = j4;
    }

    public String toString() {
        return "{\"eventCode\":\"" + this.eventCode + "\", \"eventId\":\"" + this.eventId + "\", \"apiKey\":\"" + this.apiKey + "\", \"eventTime\":" + this.eventTime + ", \"eventJsonStr\":\"" + this.eventJsonStr + "\"}";
    }
}
