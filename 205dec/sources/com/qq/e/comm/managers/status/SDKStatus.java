package com.qq.e.comm.managers.status;

import com.qq.e.comm.managers.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SDKStatus {
    public static final int SDK_CHANNEL = 1;
    public static final String SDK_EX1 = "";
    public static final String SDK_EX2 = "";
    public static final int STUB_IDENTITY = 1;
    public static final boolean isNoPlugin = false;

    public static final int getBuildInPluginVersion() {
        return 1432;
    }

    public static final String getIntegrationSDKVersion() {
        return "4.562." + getBuildInPluginVersion();
    }

    public static final int getPluginVersion() {
        if (a.b().d()) {
            return a.b().c().getPluginVersion();
        }
        return 0;
    }

    public static final String getSDKVersion() {
        return "4.562";
    }
}
