package cn.jiguang.api.utils;

import android.content.Context;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bq.d;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JCollectionAuth {
    public static void enableAppTerminate(Context context, boolean z3) {
        JCoreManager.onEvent(context, null, 119, null, null, Boolean.valueOf(z3));
    }

    public static void enableAutoWakeup(Context context, boolean z3) {
        d.e("JCollectAuth", "action: enableAutoWakeup: " + z3);
        JCoreManager.onEvent(context, null, 109, null, null, Boolean.valueOf(z3));
    }

    @Deprecated
    public static void enableDynamicLoad(Context context, boolean z3) {
        JCoreManager.onEvent(context, null, 115, null, null, Boolean.valueOf(z3));
    }

    @Deprecated
    public static void setAuth(Context context, boolean z3) {
        d.e("JCollectionAuth", "action:setAuth: " + z3);
        JCoreManager.onEvent(context, null, 96, null, null, Boolean.valueOf(z3));
    }
}
