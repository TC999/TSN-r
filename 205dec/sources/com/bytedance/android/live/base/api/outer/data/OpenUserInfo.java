package com.bytedance.android.live.base.api.outer.data;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class OpenUserInfo {
    public String avatar;
    private String nickName;

    public OpenUserInfo() {
    }

    public OpenUserInfo(String str, String str2) {
        this.nickName = str;
        this.avatar = str2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNickName() {
        return this.nickName;
    }
}
