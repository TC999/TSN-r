package com.p518qq.p519e.comm.managers.status;

import com.p518qq.p519e.comm.managers.C11815a;

/* renamed from: com.qq.e.comm.managers.status.SDKStatus */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
        if (C11815a.m20349b().m20347d()) {
            return C11815a.m20349b().m20348c().getPluginVersion();
        }
        return 0;
    }

    public static final String getSDKVersion() {
        return "4.562";
    }
}
