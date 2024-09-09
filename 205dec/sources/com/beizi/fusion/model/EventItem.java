package com.beizi.fusion.model;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class EventItem {
    private String channel;
    private String code;
    private String spaceId;
    private String timeStamp;

    public EventItem(String str, String str2, String str3, String str4) {
        this.code = str;
        this.timeStamp = str2;
        this.channel = str3;
        this.spaceId = str4;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCode() {
        return this.code;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    @NonNull
    public String toString() {
        return "EventItem{code='" + this.code + "', timeStamp='" + this.timeStamp + "', channel='" + this.channel + "', spaceId='" + this.spaceId + "'}";
    }

    public EventItem() {
    }
}
