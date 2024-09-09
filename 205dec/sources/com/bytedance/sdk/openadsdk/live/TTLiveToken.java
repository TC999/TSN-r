package com.bytedance.sdk.openadsdk.live;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class TTLiveToken implements Serializable {
    public String accessToken;
    public long expireAt;
    public String name;
    public String openId;
    public String refreshToken;

    public TTLiveToken(String str, String str2, String str3, long j4, String str4) {
        this.name = str;
        this.accessToken = str2;
        this.openId = str3;
        this.expireAt = j4;
        this.refreshToken = str4;
    }

    public String toString() {
        return "TTLiveToken{accessToken='" + this.accessToken + "', openId='" + this.openId + "', expireAt=" + this.expireAt + ", refreshToken='" + this.refreshToken + "'}";
    }
}
