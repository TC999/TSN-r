package com.beizi.ad.alipay.model;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class AliPayEventBean {
    private String appUserId = "";
    private String appOrderId = "";
    private String transAmount = "";
    private String incentiveConfigVersion = "";
    private String authCode = "";

    public String getAppOrderId() {
        return this.appOrderId;
    }

    public String getAppUserId() {
        return this.appUserId;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public String getIncentiveConfigVersion() {
        return this.incentiveConfigVersion;
    }

    public String getTransAmount() {
        return this.transAmount;
    }

    public void setAppOrderId(String str) {
        this.appOrderId = str;
    }

    public void setAppUserId(String str) {
        this.appUserId = str;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public void setIncentiveConfigVersion(String str) {
        this.incentiveConfigVersion = str;
    }

    public void setTransAmount(String str) {
        this.transAmount = str;
    }

    public String toString() {
        return "{\"appUserId\":\"" + this.appUserId + "\", \"appOrderId\":\"" + this.appOrderId + "\", \"transAmount\":\"" + this.transAmount + "\", \"incentiveConfigVersion\":\"" + this.incentiveConfigVersion + "\", \"authCode\":\"" + this.authCode + "\"}";
    }
}
