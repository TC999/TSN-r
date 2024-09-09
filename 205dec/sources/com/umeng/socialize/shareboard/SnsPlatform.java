package com.umeng.socialize.shareboard;

import com.umeng.socialize.bean.SHARE_MEDIA;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SnsPlatform {
    public String mGrayIcon;
    public String mIcon;
    public int mIndex;
    public String mKeyword;
    public SHARE_MEDIA mPlatform;
    public String mShowWord;

    public SnsPlatform(String str) {
        this.mKeyword = str;
        this.mPlatform = SHARE_MEDIA.convertToEmun(str);
    }

    public SnsPlatform() {
    }
}
