package xyz.adscope.ad.model.http.response.config;

import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FrequencyModel {
    private long[] absoluteTime;
    private int count;
    private String eventCode;
    private long relativeTime;

    public long[] getAbsoluteTime() {
        return this.absoluteTime;
    }

    public int getCount() {
        return this.count;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public long getRelativeTime() {
        return this.relativeTime;
    }

    public void setAbsoluteTime(long[] jArr) {
        this.absoluteTime = jArr;
    }

    public void setCount(int i4) {
        this.count = i4;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setRelativeTime(long j4) {
        this.relativeTime = j4;
    }

    public String toString() {
        return "{\"eventCode\":\"" + this.eventCode + "\", \"relativeTime\":" + this.relativeTime + ", \"absoluteTime\":" + Arrays.toString(this.absoluteTime) + ", \"count\":" + this.count + '}';
    }
}
