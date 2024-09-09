package com.bytedance.android.openliveplugin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;
import com.bytedance.android.dy.sdk.pangle.PluginStateListener;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.JavaCallsUtils;
import com.bytedance.android.live.base.api.callback.CommonCallback;
import com.bytedance.android.live.base.api.callback.EmptyCallback;
import com.bytedance.android.openliveplugin.stub.logger.TTLogger;
import com.bytedance.sdk.component.gd.sr;
import com.bytedance.sdk.component.gd.sr.xv;
import com.bytedance.sdk.openadsdk.adhost.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LivePluginHelper {
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final String PLAYER_PLUGIN_PACKAGE_NAME = "com.byted.ttm.player";
    private static IOuterLiveService liveRoomService;
    private static ArrayList<ILiveInitCallback> mLiveInitListeners;
    private static EmptyCallback sInstallCallback;
    public static final ScheduledExecutorService sExecutor = sr.xv(new DefaultThreadFactory());
    private static volatile boolean hasLiveInitFinish = false;
    private static boolean runInLiveProcess = false;
    private static boolean stopAppLogOnEnterBackground = false;
    private static WeakReference<Activity> hostActivity = null;
    private static final ILiveInitCallback loadingLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.6
        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(String str) {
            if (!LiveLoadingDialog.dismiss() || LivePluginHelper.hostActivity.get() == null) {
                return;
            }
            Toast.makeText((Context) LivePluginHelper.hostActivity.get(), R.string.live_in_loading_failed, 1).show();
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            if (LiveLoadingDialog.dismiss()) {
                LivePluginHelper.trulyEnterCommerceOrderList();
            }
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class DefaultThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber;

        DefaultThreadFactory() {
            this.threadNumber = new AtomicInteger(1);
            this.group = new ThreadGroup("tob_douyin_live_group");
            this.namePrefix = "tob_douyin_live_thread_init";
        }

        DefaultThreadFactory(String str) {
            this.threadNumber = new AtomicInteger(1);
            this.group = new ThreadGroup("tob_douyin_live_group");
            this.namePrefix = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            xv xvVar = new xv(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (xvVar.isDaemon()) {
                xvVar.setDaemon(false);
            }
            if (xvVar.getPriority() != 10) {
                xvVar.setPriority(10);
            }
            return xvVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class LiveInitCallback implements ILiveInitCallback {
        public static LiveInitCallback INSTANCE = new LiveInitCallback();

        private LiveInitCallback() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(String str) {
            Iterator it = LivePluginHelper.mLiveInitListeners.iterator();
            while (it.hasNext()) {
                ILiveInitCallback iLiveInitCallback = (ILiveInitCallback) it.next();
                if (iLiveInitCallback != null) {
                    try {
                        iLiveInitCallback.onLiveInitFailed(str);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            LivePluginHelper.logVersionInfo();
            TTLogger.d("live init : LiveInitCallbackWrapper onLiveInitFinish called.");
            LivePluginHelper.initLiveCommerce();
            boolean unused = LivePluginHelper.hasLiveInitFinish = true;
            Iterator it = LivePluginHelper.mLiveInitListeners.iterator();
            while (it.hasNext()) {
                ILiveInitCallback iLiveInitCallback = (ILiveInitCallback) it.next();
                if (iLiveInitCallback != null) {
                    try {
                        iLiveInitCallback.onLiveInitFinish();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    private static void adaptEventBus() {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "tryAdaptEventBus", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), ZeusPlatformUtils.getZeusActivityString(), ZeusPlatformUtils.getZeusWrapperString());
    }

    public static void addCustomTag(String str, String str2) {
        ZeusPlatformUtils.addCustomTag(str, str2);
    }

    public static void addInitListener(ILiveInitCallback iLiveInitCallback) {
        if (mLiveInitListeners == null) {
            mLiveInitListeners = new ArrayList<>();
        }
        if (iLiveInitCallback == LiveInitCallback.INSTANCE || mLiveInitListeners.contains(iLiveInitCallback) || iLiveInitCallback == null) {
            return;
        }
        mLiveInitListeners.add(iLiveInitCallback);
    }

    public static void enterCommerceOrderList(Activity activity) {
        hostActivity = new WeakReference<>(activity);
        if (isLiveInited()) {
            trulyEnterCommerceOrderList();
            return;
        }
        ZeusPlatformUtils.registerZeusPluginLoadStateListener("com.byted.live.lite", new PluginStateListener() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.5
            @Override // com.bytedance.android.dy.sdk.pangle.PluginStateListener
            public void onPluginStateChanged(int i4, String str) {
                if ((i4 == 4 || i4 == 7 || i4 == 10) && LiveLoadingDialog.dismiss() && LivePluginHelper.hostActivity.get() != null) {
                    Toast.makeText((Context) LivePluginHelper.hostActivity.get(), R.string.live_in_loading_failed, 1).show();
                }
            }
        });
        addInitListener(loadingLiveInitCallback);
        LiveLoadingDialog.show(hostActivity.get());
    }

    public static boolean getApmEnable() {
        return ZeusPlatformUtils.getApmEnable();
    }

    public static String getLiveArgsJsonStr() {
        return (String) JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "getLiveArgsJsonStr", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), new Object[0]);
    }

    public static IOuterLiveService getLiveRoomService() {
        if (liveRoomService == null) {
            liveRoomService = LiveReflectFacade.getOuterLiveService();
        }
        return liveRoomService;
    }

    public static boolean getStopAppLogOnEnterBackground() {
        return stopAppLogOnEnterBackground;
    }

    public static void init(Application application, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback) {
        init(application, str, builder, iLiveInitCallback, true);
    }

    public static void init(Application application, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z3) {
        init(application, str, builder, iLiveInitCallback, z3, false);
    }

    public static void init(Application application, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z3, boolean z4) {
        if (ZeusPlatformUtils.hasInitZeus) {
            ZeusPlatformUtils.fetchPlugin("com.byted.live.lite");
        } else {
            ZeusPlatformUtils.initZeus(application, z3, "com.byted.live.lite");
        }
        initLive(application, str, builder, iLiveInitCallback, z4);
    }

    public static void initLive(final Application application, final String str, final ILiveHostContextParam.Builder builder, final ILiveInitCallback iLiveInitCallback, final boolean z3) {
        runInLiveProcess = z3;
        sExecutor.execute(new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.2
            @Override // java.lang.Runnable
            public void run() {
                TTLogger.d("live init : async start init live ~~~");
                if (LivePluginHelper.prepare(new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTLogger.d("live init : runnable real init live ---- ");
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        LivePluginHelper.realInitLivePlugin(application, str, builder, iLiveInitCallback, z3);
                    }
                })) {
                    TTLogger.d("live init : prepared-start real init live ---- ");
                    LivePluginHelper.realInitLivePlugin(application, str, builder, iLiveInitCallback, z3);
                }
            }
        });
    }

    public static void initLiveCommerce() {
        try {
            adaptEventBus();
            JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.ecom.live.adapter.ECLiveAdapter", "init", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), new Object[0]);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static boolean isLiveInited() {
        return hasLiveInitFinish;
    }

    public static boolean isRunInLiveProcess() {
        return runInLiveProcess;
    }

    public static void logEventV3(String str, JSONObject jSONObject) {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "onEventV3", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logVersionInfo() {
        Object callStaticMethodWithClassLoader = JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.plugin.LivePluginApplication", "getPluginVersion", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), new Object[0]);
        if (callStaticMethodWithClassLoader == null) {
            return;
        }
        try {
            Pair pair = (Pair) callStaticMethodWithClassLoader;
            long longValue = ((Long) pair.first).longValue();
            Log.i("live init", "version_info: lib_version_name=2.1.1.4-tob-tob-283069386; sdkApiVersionName=2.1.1.4-tob-tob-283069386; pluginVersionCode=" + longValue + "; pluginVersionName=" + ((String) pair.second));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean prepare(Runnable runnable) {
        EmptyCallback emptyCallback;
        TTLogger.d("live init : prepare ---- ");
        ZeusPlatformUtils.registerZeusPluginLoadStateListener("com.byted.live.lite", new PluginStateListener() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.4
            @Override // com.bytedance.android.dy.sdk.pangle.PluginStateListener
            public void onPluginStateChanged(int i4, String str) {
                if (i4 != 6 || LivePluginHelper.sInstallCallback == null) {
                    return;
                }
                LivePluginHelper.sInstallCallback.invoke();
            }
        });
        if (ZeusPlatformUtils.isPluginInstalled("com.byted.live.lite") && (emptyCallback = sInstallCallback) != null) {
            emptyCallback.invoke();
        }
        return ZeusPlatformUtils.checkPluginState(runnable, "com.byted.live.lite");
    }

    private static void preparePlayer(final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (LivePluginHelper.prepare(runnable)) {
                    runnable.run();
                }
            }
        };
        if (ZeusPlatformUtils.checkPluginState(runnable2, "com.byted.ttm.player")) {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void realInitLivePlugin(final Application application, final String str, final ILiveHostContextParam.Builder builder, final ILiveInitCallback iLiveInitCallback, final boolean z3) {
        sExecutor.execute(new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.1
            @Override // java.lang.Runnable
            public void run() {
                LivePluginHelper.addInitListener(ILiveInitCallback.this);
                if (LivePluginHelper.getStopAppLogOnEnterBackground()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("stop_applog_on_background", "1");
                    builder.addHostInitExtra(hashMap);
                }
                LiveReflectFacade.initLiveInPlugin(application, str, builder, z3, LiveInitCallback.INSTANCE);
            }
        });
    }

    public static void setApmEnable(boolean z3) {
        ZeusPlatformUtils.setApmEnable(z3);
    }

    public static void setBoeValue(String str) {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "setBoeValue", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), str);
    }

    public static void setHostVersionCodeTag(long j4) {
        ZeusPlatformUtils.setHostVersionCodeTag(j4);
    }

    public static void setInstallCallback(EmptyCallback emptyCallback) {
        sInstallCallback = emptyCallback;
    }

    public static void setPpeValue(String str) {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "setPpeValue", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), str);
    }

    public static void setStopAppLogOnEnterBackground(boolean z3) {
        stopAppLogOnEnterBackground = z3;
    }

    public static void trulyEnterCommerceOrderList() {
        TTLogger.d("trulyEnterCommerceOrderList start");
        if (liveRoomService == null) {
            getLiveRoomService();
        }
        if (liveRoomService == null) {
            return;
        }
        try {
            TTLogger.d("callExpandMethod enterCommercePage");
            liveRoomService.callExpandMethod("enterCommercePage", new JSONObject().put("request_page", "order_list"), new CommonCallback<String, String>() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.7
                @Override // com.bytedance.android.live.base.api.callback.CommonCallback
                public void onFail(String str) {
                    TTLogger.d("get enterCommercePage fail, error msg = " + str);
                }

                @Override // com.bytedance.android.live.base.api.callback.CommonCallback
                public void onSuccess(String str) {
                    TTLogger.d("get enterCommercePage success, result = " + str);
                    LivePluginHelper.liveRoomService.handleSchema((Context) LivePluginHelper.hostActivity.get(), Uri.parse(str));
                }
            }, 2000L);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
