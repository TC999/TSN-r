package com.bytedance.android.live.base.api.outer.data;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AnchorInfo {
    String avatar;
    long fansCount;
    String nickname;
    String openId;

    public AnchorInfo() {
    }

    public AnchorInfo(String str, String str2, String str3, long j4) {
        this.openId = str;
        this.nickname = str2;
        this.avatar = str3;
        this.fansCount = j4;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getFansCount() {
        return this.fansCount;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setFansCount(long j4) {
        this.fansCount = j4;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }
}
