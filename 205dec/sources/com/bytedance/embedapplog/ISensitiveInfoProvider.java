package com.bytedance.embedapplog;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ISensitiveInfoProvider {
    String getCurrentProcessName(Context context);

    String getImsi();

    String getMac();

    String getSdkBuildModel();

    boolean isDropTime();

    boolean isUseLaunchStrategy();
}
