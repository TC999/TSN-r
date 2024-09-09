package com.beizi.fusion.model;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FreqItem {
    @JsonNode(key = "componentType")
    private int componentType;
    @JsonNode(key = "eventCode")
    private String eventCode;
    @JsonNode(key = "interval")
    private long interval = Long.MAX_VALUE;
    @JsonNode(key = "count")
    private int count = Integer.MAX_VALUE;

    public int getComponentType() {
        return this.componentType;
    }

    public int getCount() {
        return this.count;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public long getInterval() {
        return this.interval;
    }

    public void setComponentType(int i4) {
        this.componentType = i4;
    }

    public void setCount(int i4) {
        this.count = i4;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setInterval(long j4) {
        this.interval = j4;
    }

    @NonNull
    public String toString() {
        return "FreqItem{interval=" + this.interval + ", count=" + this.count + ", eventCode='" + this.eventCode + "', componentType=" + this.componentType + '}';
    }
}
