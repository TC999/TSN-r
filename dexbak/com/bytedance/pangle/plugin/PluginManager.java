package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.C6158h;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p119d.C6081c;
import com.bytedance.pangle.p119d.C6082d;
import com.bytedance.pangle.p119d.C6083e;
import com.bytedance.pangle.util.C6237b;
import com.bytedance.pangle.util.C6256l;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PluginManager {
    private static final String TAG = "PluginManager";
    private static volatile PluginManager sInstance;
    private volatile boolean hasInstallFromDownloadDir;
    private ExecutorService mInstallThreadPool;
    private volatile boolean mIsParsePluginConfig;
    private volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    private final C6177c pluginLoader = new C6177c();

    private PluginManager() {
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin == null || !plugin.isInstalled() || new File(C6081c.m37228b(plugin.mPkgName, plugin.getVersion())).exists()) {
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
        ZeusLogger.m37079v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
        ArrayList<String> arrayList = new ArrayList();
        try {
            Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
            for (String str : bundle.keySet()) {
                String str2 = C6158h.f22056e;
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
                        ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "PluginManagerparsePluginsJson. find " + plugin.mPkgName);
                    } catch (JSONException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str3.trim(), e);
                    }
                }
                this.mPlugins = concurrentHashMap;
                ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e2);
            }
            this.mIsParsePluginConfig = true;
        } catch (Exception e3) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e3);
        }
    }

    public void asyncInstall(String str, File file) {
        if (file != null) {
            getInstallThreadPool().execute(new RunnableC6170a(str, file));
            ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
            return;
        }
        ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
        ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
    }

    public boolean checkPluginInstalled(String str) {
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        boolean z = plugin != null && plugin.isInstalled();
        ZeusLogger.m37083d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
        return z;
    }

    public ExecutorService getInstallThreadPool() {
        if (this.mInstallThreadPool == null) {
            this.mInstallThreadPool = C6083e.m37213a(GlobalParam.getInstance().getInstallThreads());
        }
        return this.mInstallThreadPool;
    }

    public Plugin getPlugin(String str, boolean z) {
        if (!Zeus.hasInit() && C6237b.m36929a()) {
            throw new RuntimeException("Please init Zeus first!");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Plugin plugin = this.mPlugins.get(str);
        if (z && plugin != null) {
            plugin.init();
        }
        return plugin;
    }

    public synchronized void installFromDownloadDir() {
        if (this.hasInstallFromDownloadDir) {
            ZeusLogger.m37077w(ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");
            return;
        }
        if (C6082d.m37217a(Zeus.getAppApplication())) {
            C6083e.m37212a(new RunnableC6182d());
        }
        this.hasInstallFromDownloadDir = true;
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        return plugin != null && plugin.isLoaded();
    }

    public boolean loadPlugin(String str) {
        return this.pluginLoader.m37044a(str);
    }

    public void setAllowDownloadPlugin(String str, int i, boolean z) {
        ZeusLogger.m37083d(ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + str + " " + i + " " + z);
        if (getPlugin(str) != null) {
            boolean z2 = !z;
            SharedPreferences.Editor edit = C6256l.m36869a().f22242a.edit();
            String str2 = "DISABLE_DOWNLOAD_" + str + "_" + i;
            if (z2) {
                edit.putInt(str2, 0);
            } else {
                edit.remove(str2);
            }
            edit.apply();
            ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i + " disable=" + z2);
        }
    }

    public boolean syncInstall(String str, File file) {
        ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new RunnableC6170a(str, file).m37069a();
    }

    public void tryOfflineInternalPlugin(String str, int i) {
        Plugin plugin = getPlugin(str);
        if (plugin == null || plugin.getInternalVersionCode() != i) {
            return;
        }
        ZeusLogger.m37083d(ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + str + " pluginVer:" + i + " apiVer:" + plugin.getApiVersionCode());
        C6256l m36869a = C6256l.m36869a();
        int apiVersionCode = plugin.getApiVersionCode();
        SharedPreferences.Editor edit = m36869a.f22242a.edit();
        edit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), apiVersionCode);
        edit.apply();
    }

    public void unInstallPackage(String str) {
        ZeusLogger.m37083d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) != null) {
            SharedPreferences.Editor edit = C6256l.m36869a().f22242a.edit();
            edit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
            edit.apply();
            ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
        }
    }

    public Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }
}
