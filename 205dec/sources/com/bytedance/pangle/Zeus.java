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
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
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
        new com.bytedance.pangle.res.a().a(resources.getAssets(), str2, false);
    }

    public static void addPluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        i a4 = i.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a4.f28821c) {
                a4.f28821c.add(zeusPluginEventCallback);
            }
        }
    }

    public static void fetchPlugin(final String str) {
        com.bytedance.pangle.download.a a4 = com.bytedance.pangle.download.a.a();
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            if (GlobalParam.getInstance().autoFetch()) {
                final com.bytedance.pangle.download.b a5 = com.bytedance.pangle.download.b.a();
                Runnable runnable = a5.f28696c.get(str);
                if (runnable != null) {
                    a5.f28695b.removeCallbacks(runnable);
                }
                Runnable runnable2 = new Runnable() { // from class: com.bytedance.pangle.download.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        List<ActivityManager.RunningTaskInfo> runningTasks;
                        ComponentName componentName;
                        Application appApplication = Zeus.getAppApplication();
                        String packageName = appApplication.getPackageName();
                        boolean z3 = true;
                        if ((TextUtils.isEmpty(packageName) || (runningTasks = ((ActivityManager) appApplication.getSystemService("activity")).getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : false) {
                            b.this.f28695b.postDelayed(this, 1800000L);
                        }
                    }
                };
                a5.f28696c.put(str, runnable2);
                a5.f28695b.postDelayed(runnable2, 1800000L);
                com.bytedance.pangle.download.b.a();
                if (a4.f28691a.contains(str)) {
                    return;
                }
                a4.f28691a.add(str);
                return;
            }
            com.bytedance.pangle.download.b.a();
        }
    }

    public static Application getAppApplication() {
        if (sApplication == null) {
            b.a();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(com.bytedance.pangle.d.a.a(), "getApplication", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return sApplication;
    }

    public static String getHostAbi() {
        return com.bytedance.pangle.d.b.a();
    }

    public static int getHostAbiBit() {
        return com.bytedance.pangle.d.b.b();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.d("Zeus/download_pangle", " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static int getMaxInstallVer(String str) {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
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
        return i.a().f28819a;
    }

    public static void hookHuaWeiVerifier(Application application) {
        com.bytedance.pangle.receiver.b.a(application);
    }

    public static void init(Application application, boolean z3) {
        i.a().a(application, z3);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
        com.bytedance.pangle.service.a.a b4 = com.bytedance.pangle.service.a.a.b();
        for (Runnable runnable : b4.f28948b) {
            if (runnable != null) {
                b4.f28947a.post(runnable);
            }
        }
        b4.f28948b.clear();
    }

    public static void installFromDownloadDir() {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
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
            c a4 = com.bytedance.pangle.servermanager.b.a();
            if (a4 != null) {
                a4.a(zeusPluginInstallListener.hashCode(), new com.bytedance.pangle.f.b(zeusPluginInstallListener));
            }
        } catch (RemoteException e4) {
            ZeusLogger.w("Zeus/install_pangle", "registerPluginInstallListener error.", e4);
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        i.a().f28820b.add(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        i a4 = i.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a4.f28821c) {
                a4.f28821c.remove(zeusPluginEventCallback);
            }
        }
    }

    public static void setAllowDownloadPlugin(String str, int i4, boolean z3) {
        PluginManager.getInstance().setAllowDownloadPlugin(str, i4, z3);
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
        c a4 = com.bytedance.pangle.servermanager.b.a();
        if (a4 != null) {
            try {
                return a4.a(str, str2);
            } catch (RemoteException e4) {
                ZeusLogger.w("Zeus/install_pangle", "syncInstallPlugin error.", e4);
                return false;
            }
        }
        return false;
    }

    public static void triggerBgDexOpt() {
        com.bytedance.pangle.e.f.a();
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = i.a().f28820b;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public static boolean waitInit(int i4) {
        if (i.a().f28819a) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            if (!i.a().f28819a) {
                try {
                    if (i4 == -1) {
                        obj.wait();
                    } else {
                        obj.wait(i4);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        return i.a().f28819a;
    }

    public void unregisterPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            c a4 = com.bytedance.pangle.servermanager.b.a();
            if (a4 != null) {
                a4.a(zeusPluginInstallListener.hashCode());
            }
        } catch (RemoteException e4) {
            ZeusLogger.w("Zeus/install_pangle", "unregisterPluginInstallListener error.", e4);
        }
    }

    public static Plugin getPlugin(String str, boolean z3) {
        return PluginManager.getInstance().getPlugin(str, z3);
    }
}
