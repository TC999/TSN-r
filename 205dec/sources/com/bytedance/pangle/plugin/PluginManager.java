package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.d.e;
import com.bytedance.pangle.h;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PluginManager {
    private static final String TAG = "PluginManager";
    private static volatile PluginManager sInstance;
    private volatile boolean hasInstallFromDownloadDir;
    private ExecutorService mInstallThreadPool;
    private volatile boolean mIsParsePluginConfig;
    private volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    private final c pluginLoader = new c();

    private PluginManager() {
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin == null || !plugin.isInstalled() || new File(com.bytedance.pangle.d.c.b(plugin.mPkgName, plugin.getVersion())).exists()) {
            return;
        }
        unInstallPackage(plugin.mPkgName);
    }

    public static PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                if (sInstance == null) {
                    sInstance = new PluginManager();
                }
            }
        }
        return sInstance;
    }

    private synchronized void parsePluginConfig() {
        if (this.mIsParsePluginConfig) {
            return;
        }
        ZeusLogger.v("Zeus/init_pangle", "PluginManager parsePluginsJson");
        ArrayList<String> arrayList = new ArrayList();
        try {
            Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
            try {
                for (String str : bundle.keySet()) {
                    String str2 = h.f28817e;
                    if (str2.startsWith("PANGLE_")) {
                        if (str.startsWith(str2) || str.startsWith("ZEUS_PLUGIN_")) {
                            arrayList.add(bundle.getString(str));
                        }
                    } else if (str.startsWith(str2)) {
                        arrayList.add(bundle.getString(str));
                    }
                }
                try {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    for (String str3 : arrayList) {
                        try {
                            Plugin plugin = new Plugin(new JSONObject(str3));
                            concurrentHashMap.put(plugin.mPkgName, plugin);
                            ZeusLogger.i("Zeus/init_pangle", "PluginManagerparsePluginsJson. find " + plugin.mPkgName);
                        } catch (JSONException e4) {
                            ZeusLogger.errReport("Zeus/init_pangle", "PluginManager parsePluginsJson failed. " + str3.trim(), e4);
                        }
                    }
                    this.mPlugins = concurrentHashMap;
                    ZeusLogger.i("Zeus/init_pangle", "PluginManager parsePluginsJson success");
                } catch (Exception e5) {
                    ZeusLogger.errReport("Zeus/init_pangle", "PluginManager parsePluginsJson failed.", e5);
                }
                this.mIsParsePluginConfig = true;
            } catch (Exception e6) {
                ZeusLogger.errReport("Zeus/init_pangle", "PluginManager iterator metaData failed.", e6);
            }
        } catch (Exception e7) {
            ZeusLogger.errReport("Zeus/init_pangle", "PluginManager parsePluginsJson failed.", e7);
        }
    }

    public void asyncInstall(String str, File file) {
        if (file != null) {
            getInstallThreadPool().execute(new a(str, file));
            ZeusLogger.i("Zeus/install_pangle", "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
            return;
        }
        ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
        ZeusLogger.w("Zeus/install_pangle", "PluginManager asyncInstall apk is null !");
    }

    public boolean checkPluginInstalled(String str) {
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        boolean z3 = plugin != null && plugin.isInstalled();
        ZeusLogger.d("Zeus/ppm_pangle", "PluginManager checkPluginInstalled, " + str + " = " + z3);
        return z3;
    }

    public ExecutorService getInstallThreadPool() {
        if (this.mInstallThreadPool == null) {
            this.mInstallThreadPool = e.a(GlobalParam.getInstance().getInstallThreads());
        }
        return this.mInstallThreadPool;
    }

    public Plugin getPlugin(String str, boolean z3) {
        if (!Zeus.hasInit() && com.bytedance.pangle.util.b.a()) {
            throw new RuntimeException("Please init Zeus first!");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Plugin plugin = this.mPlugins.get(str);
        if (z3 && plugin != null) {
            plugin.init();
        }
        return plugin;
    }

    public synchronized void installFromDownloadDir() {
        if (this.hasInstallFromDownloadDir) {
            ZeusLogger.w("Zeus/init_pangle", "PluginManager zeus has been installFromDownloadDir!");
            return;
        }
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            e.a(new d());
        }
        this.hasInstallFromDownloadDir = true;
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        return plugin != null && plugin.isLoaded();
    }

    public boolean loadPlugin(String str) {
        return this.pluginLoader.a(str);
    }

    public void setAllowDownloadPlugin(String str, int i4, boolean z3) {
        ZeusLogger.d("Zeus/ppm_pangle", "PluginManager setAllowDownloadPlugin, " + str + " " + i4 + " " + z3);
        if (getPlugin(str) != null) {
            boolean z4 = !z3;
            SharedPreferences.Editor edit = l.a().f29012a.edit();
            String str2 = "DISABLE_DOWNLOAD_" + str + "_" + i4;
            if (z4) {
                edit.putInt(str2, 0);
            } else {
                edit.remove(str2);
            }
            edit.apply();
            ZeusLogger.i("Zeus/init_pangle", "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i4 + " disable=" + z4);
        }
    }

    public boolean syncInstall(String str, File file) {
        ZeusLogger.i("Zeus/install_pangle", "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new a(str, file).a();
    }

    public void tryOfflineInternalPlugin(String str, int i4) {
        Plugin plugin = getPlugin(str);
        if (plugin == null || plugin.getInternalVersionCode() != i4) {
            return;
        }
        ZeusLogger.d("Zeus/ppm_pangle", "PluginManager offlineInternalPlugin, pkgName:" + str + " pluginVer:" + i4 + " apiVer:" + plugin.getApiVersionCode());
        l a4 = l.a();
        int apiVersionCode = plugin.getApiVersionCode();
        SharedPreferences.Editor edit = a4.f29012a.edit();
        edit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), apiVersionCode);
        edit.apply();
    }

    public void unInstallPackage(String str) {
        ZeusLogger.d("Zeus/ppm_pangle", "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) != null) {
            SharedPreferences.Editor edit = l.a().f29012a.edit();
            edit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
            edit.apply();
            ZeusLogger.i("Zeus/init_pangle", "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
        }
    }

    public Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }
}
