package com.bytedance.android.openliveplugin;

import android.app.Application;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.JavaCallsUtils;
import com.bytedance.android.openliveplugin.LivePluginHelper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LiveReflectFacade {
    public static void addLiveInitListener(Object obj) {
        if (obj instanceof ILiveInitCallback) {
            LivePluginHelper.addInitListener((ILiveInitCallback) obj);
        }
    }

    public static IOuterLiveService getOuterLiveService() {
        try {
            return (IOuterLiveService) Class.forName("com.bytedance.android.openlive.plugin.LivePluginFacade", true, ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite")).getMethod("getOuterLiveRoomService", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static void initLiveInPlugin(Application application, String str, ILiveHostContextParam.Builder builder, boolean z3, ILiveInitCallback iLiveInitCallback) {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.plugin.LivePluginFacade", "initLiveInPlugin", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), application, str, builder, Boolean.valueOf(z3), iLiveInitCallback);
    }

    public static void invokeLiveInitFailed(String str) {
        LivePluginHelper.LiveInitCallback.INSTANCE.onLiveInitFailed(str);
    }

    public static void invokeLiveInitSuccess() {
        LivePluginHelper.LiveInitCallback.INSTANCE.onLiveInitFinish();
    }
}
