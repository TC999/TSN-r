package com.beizi.fusion.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class S2SBiddingConfig {
    @JsonNode(key = "appKey")
    private String appKey;
    @JsonNode(key = "secret")
    private String secret;
    @JsonNode(key = "url")
    private String url;

    public String getAppKey() {
        return this.appKey;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
