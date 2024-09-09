package xyz.adscope.ad.model.custom;

import xyz.adscope.ad.model.BaseModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeEventItem extends BaseModel {
    private String channel;
    private String code;
    private String content;
    private String spaceId;
    private String timestamp;

    public String getChannel() {
        return this.channel;
    }

    public String getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }
}
