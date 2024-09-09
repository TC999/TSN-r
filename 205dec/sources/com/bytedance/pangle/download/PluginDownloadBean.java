package com.bytedance.pangle.download;

import androidx.annotation.Keep;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PluginDownloadBean {
    public List<String> mBackupUrlList;
    public int mFlag;
    public long mFollowId;
    public String mMd5;
    public String mPackageName;
    public String mUrl;
    public int mVersionCode;
    public int mApiVersionMin = 0;
    public int mApiVersionMax = Integer.MAX_VALUE;

    public boolean isRevert() {
        return this.mFlag == 3;
    }

    public boolean isUnInstall() {
        return this.mFlag == 1;
    }
}
