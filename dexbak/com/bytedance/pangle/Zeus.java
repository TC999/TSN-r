package com.bytedance.pangle;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.download.C6087a;
import com.bytedance.pangle.download.C6089b;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p119d.C6078a;
import com.bytedance.pangle.p119d.C6080b;
import com.bytedance.pangle.p119d.C6082d;
import com.bytedance.pangle.p120e.C6102f;
import com.bytedance.pangle.p121f.BinderC6120b;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.receiver.C6191b;
import com.bytedance.pangle.res.C6199a;
import com.bytedance.pangle.servermanager.C6219b;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.List;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class Zeus {
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();
    static final Object wait = new Object();
    private static volatile boolean onPrivacyAgreed = false;

    public static void addExternalAssetsForPlugin(String str, String str2) {
        Plugin plugin;
        Resources resources;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (plugin = getPlugin(str)) == null || (resources = plugin.mResources) == null) {
            return;
        }
        new C6199a().m37011a(resources.getAssets(), str2, false);
    }

    public static void addPluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        C6159i m37090a = C6159i.m37090a();
        if (zeusPluginEventCallback != null) {
            synchronized (m37090a.f22060c) {
                m37090a.f22060c.add(zeusPluginEventCallback);
            }
        }
    }

    public static void fetchPlugin(final String str) {
        C6087a m37207a = C6087a.m37207a();
        if (C6082d.m37217a(getAppApplication())) {
            if (GlobalParam.getInstance().autoFetch()) {
                final C6089b m37205a = C6089b.m37205a();
                Runnable runnable = m37205a.f21935c.get(str);
                if (runnable != null) {
                    m37205a.f21934b.removeCallbacks(runnable);
                }
                Runnable runnable2 = new Runnable() { // from class: com.bytedance.pangle.download.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        List<ActivityManager.RunningTaskInfo> runningTasks;
                        ComponentName componentName;
                        Application appApplication = Zeus.getAppApplication();
                        String packageName = appApplication.getPackageName();
                        boolean z = true;
                        if ((TextUtils.isEmpty(packageName) || (runningTasks = ((ActivityManager) appApplication.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : false) {
                            C6089b.this.f21934b.postDelayed(this, 1800000L);
                        }
                    }
                };
                m37205a.f21935c.put(str, runnable2);
                m37205a.f21934b.postDelayed(runnable2, 1800000L);
                C6089b.m37205a();
                if (m37207a.f21930a.contains(str)) {
                    return;
                }
                m37207a.f21930a.add(str);
                return;
            }
            C6089b.m37205a();
        }
    }

    public static Application getAppApplication() {
        if (sApplication == null) {
            C6065b.m37267a();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(C6078a.m37251a(), "getApplication", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return sApplication;
    }

    public static String getHostAbi() {
        return C6080b.m37248a();
    }

    public static int getHostAbiBit() {
        return C6080b.m37239b();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.m37083d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static int getMaxInstallVer(String str) {
        if (C6082d.m37217a(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static String getZeusDid() {
        String did = GlobalParam.getInstance().getDid();
        return !TextUtils.isEmpty(did) ? did : ApmUtils.getApmInstance().getDid();
    }

    public static boolean hasInit() {
        return C6159i.m37090a().f22058a;
    }

    public static void hookHuaWeiVerifier(Application application) {
        C6191b.m37022a(application);
    }

    public static void init(Application application, boolean z) {
        C6159i.m37090a().m37088a(application, z);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public static void installFromDownloadDir() {
        if (C6082d.m37217a(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static synchronized void onPrivacyAgreed() {
        synchronized (Zeus.class) {
            if (onPrivacyAgreed) {
                return;
            }
            ApmUtils.getApmInstance().init();
            onPrivacyAgreed = true;
        }
    }

    public static void registerPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            InterfaceC6069c m36964a = C6219b.m36964a();
            if (m36964a != null) {
                m36964a.mo37170a(zeusPluginInstallListener.hashCode(), new BinderC6120b(zeusPluginInstallListener));
            }
        } catch (RemoteException e) {
            ZeusLogger.m37076w(ZeusLogger.TAG_INSTALL, "registerPluginInstallListener error.", e);
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        C6159i.m37090a().f22059b.add(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        C6159i m37090a = C6159i.m37090a();
        if (zeusPluginEventCallback != null) {
            synchronized (m37090a.f22060c) {
                m37090a.f22060c.remove(zeusPluginEventCallback);
            }
        }
    }

    public static void setAllowDownloadPlugin(String str, int i, boolean z) {
        PluginManager.getInstance().setAllowDownloadPlugin(str, i, z);
    }

    public static void setAppContext(Application application) {
        if (application != null && TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (Application) FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (Throwable unused) {
            }
        }
        sApplication = application;
    }

    public static boolean syncInstallPlugin(String str, String str2) {
        InterfaceC6069c m36964a = C6219b.m36964a();
        if (m36964a != null) {
            try {
                return m36964a.mo37168a(str, str2);
            } catch (RemoteException e) {
                ZeusLogger.m37076w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
                return false;
            }
        }
        return false;
    }

    public static void triggerBgDexOpt() {
        C6102f.m37186a();
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = C6159i.m37090a().f22059b;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public static boolean waitInit(int i) {
        if (C6159i.m37090a().f22058a) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            if (!C6159i.m37090a().f22058a) {
                try {
                    if (i == -1) {
                        obj.wait();
                    } else {
                        obj.wait(i);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        return C6159i.m37090a().f22058a;
    }

    public void unregisterPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            InterfaceC6069c m36964a = C6219b.m36964a();
            if (m36964a != null) {
                m36964a.mo37171a(zeusPluginInstallListener.hashCode());
            }
        } catch (RemoteException e) {
            ZeusLogger.m37076w(ZeusLogger.TAG_INSTALL, "unregisterPluginInstallListener error.", e);
        }
    }

    public static Plugin getPlugin(String str, boolean z) {
        return PluginManager.getInstance().getPlugin(str, z);
    }
}
