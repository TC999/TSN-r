package com.bytedance.pangle.sdk.component.log.impl.cache.db;

import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTPathConst {
    public static final String sSeparator = "/";
    private static final String sContent = "content://";
    public static String sPackageName = "com.bytedance.openadsdk";
    private static final String sLast = ".TTMultiProvider";
    public static String sAuthority = sContent + sPackageName + sLast;

    static {
        init();
    }

    public static void init() {
        if (LogInternalManager.getInstance().getContext() != null) {
            sPackageName = LogInternalManager.getInstance().getContext().getPackageName();
            sAuthority = sContent + sPackageName + sLast;
        }
    }
}
