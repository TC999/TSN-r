package com.bytedance.pangle.plugin;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.C6159i;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.dex.C6086a;
import com.bytedance.pangle.log.C6164a;
import com.bytedance.pangle.log.C6165b;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p118c.C6073b;
import com.bytedance.pangle.p119d.C6083e;
import com.bytedance.pangle.p120e.C6096b;
import com.bytedance.pangle.p120e.C6106g;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.C6253i;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.pangle.plugin.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6177c {

    /* renamed from: a */
    private static final C6159i f22098a = C6159i.m37090a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m37044a(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.m37077w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        }
        synchronized (plugin) {
            if (!plugin.isInstalled()) {
                ZeusLogger.m37077w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
                return false;
            } else if (plugin.isLoaded()) {
                return true;
            } else {
                C6159i c6159i = f22098a;
                c6159i.m37089a(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
                C6164a m37073a = C6164a.m37073a(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
                m37043a(C6073b.f21871i, C6073b.C6074a.f21879D, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
                ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
                StringBuilder sb = new StringBuilder();
                boolean m37042a = m37042a(str, plugin, sb);
                m37073a.m37074a("loadPluginInternal:".concat(String.valueOf(m37042a)));
                if (m37042a) {
                    plugin.setLifeCycle(3);
                    m37043a(C6073b.f21872j, C6073b.C6074a.f21880E, plugin.mPkgName, plugin.getVersion(), m37073a.m37075a(), sb.toString());
                    ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                    c6159i.m37089a(2100, 0, plugin.mPkgName, plugin.getVersion(), null);
                } else {
                    sb.append("plugin:");
                    sb.append(plugin.mPkgName);
                    sb.append(" versionCode:");
                    sb.append(plugin.getVersion());
                    sb.append("load failed;");
                    m37043a(C6073b.f21872j, C6073b.C6074a.f21881F, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                    ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                    c6159i.m37089a(2100, -1, plugin.mPkgName, plugin.getVersion(), null);
                }
                ZeusLogger.m37081i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
                if (plugin.isLoaded()) {
                    ZeusLogger.m37083d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
                    return true;
                }
                return false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0182 A[Catch: all -> 0x021a, TryCatch #0 {all -> 0x021a, blocks: (B:39:0x015e, B:41:0x0182, B:47:0x01aa, B:49:0x01b0, B:50:0x01b3, B:52:0x01bb, B:54:0x0214, B:53:0x01f1), top: B:67:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01aa A[Catch: all -> 0x021a, TryCatch #0 {all -> 0x021a, blocks: (B:39:0x015e, B:41:0x0182, B:47:0x01aa, B:49:0x01b0, B:50:0x01b3, B:52:0x01bb, B:54:0x0214, B:53:0x01f1), top: B:67:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01bb A[Catch: all -> 0x021a, TryCatch #0 {all -> 0x021a, blocks: (B:39:0x015e, B:41:0x0182, B:47:0x01aa, B:49:0x01b0, B:50:0x01b3, B:52:0x01bb, B:54:0x0214, B:53:0x01f1), top: B:67:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01f1 A[Catch: all -> 0x021a, TryCatch #0 {all -> 0x021a, blocks: (B:39:0x015e, B:41:0x0182, B:47:0x01aa, B:49:0x01b0, B:50:0x01b3, B:52:0x01bb, B:54:0x0214, B:53:0x01f1), top: B:67:0x015e }] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m37042a(final java.lang.String r22, final com.bytedance.pangle.plugin.Plugin r23, final java.lang.StringBuilder r24) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.C6177c.m37042a(java.lang.String, com.bytedance.pangle.plugin.Plugin, java.lang.StringBuilder):boolean");
    }

    /* renamed from: a */
    private static void m37048a(Plugin plugin, StringBuilder sb, PackageInfo packageInfo) {
        ActivityInfo[] activityInfoArr = packageInfo.activities;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (!TextUtils.isEmpty(activityInfo.processName) && activityInfo.processName.contains(":")) {
                    activityInfo.processName = activityInfo.processName.split(":")[1];
                } else {
                    activityInfo.processName = "main";
                }
                plugin.pluginActivities.put(activityInfo.name, activityInfo);
            }
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.processName) && serviceInfo.processName.contains(":")) {
                    serviceInfo.processName = serviceInfo.processName.split(":")[1];
                } else {
                    serviceInfo.processName = "main";
                }
                plugin.pluginServices.put(serviceInfo.name, serviceInfo);
            }
        }
        ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
        if (activityInfoArr2 != null) {
            for (ActivityInfo activityInfo2 : activityInfoArr2) {
                if (!TextUtils.isEmpty(activityInfo2.processName) && activityInfo2.processName.contains(":")) {
                    activityInfo2.processName = activityInfo2.processName.split(":")[1];
                } else {
                    activityInfo2.processName = "main";
                }
                plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
            }
        }
        ProviderInfo[] providerInfoArr = packageInfo.providers;
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                    providerInfo.processName = providerInfo.processName.split(":")[1];
                } else {
                    providerInfo.processName = "main";
                }
                plugin.pluginProvider.put(providerInfo.name, providerInfo);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, ProviderInfo> hashMap = plugin.pluginProvider;
        if (hashMap != null && hashMap.size() > 0) {
            ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
        }
        sb.append("installProvider cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(";");
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(packageInfo.applicationInfo.className)) {
            ZeusApplication zeusApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageInfo.applicationInfo.className).newInstance();
            plugin.mApplication = zeusApplication;
            zeusApplication.attach(plugin, Zeus.getAppApplication());
        }
        sb.append("makeApplication cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis2);
        sb.append(";");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public PackageInfo m37041a(String str, final Plugin plugin, StringBuilder sb, String str2, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE);
        plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
        ApplicationInfo applicationInfo = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
        plugin.mHostApplicationInfoHookSomeField = applicationInfo;
        applicationInfo.nativeLibraryDir = file.getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.sourceDir = str2;
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
            packageArchiveInfo.applicationInfo.sourceDir = str2;
        }
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
            packageArchiveInfo.applicationInfo.publicSourceDir = str2;
        }
        plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo), str);
        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.bytedance.pangle.plugin.c.3
            @Override // android.content.ComponentCallbacks
            public final void onConfigurationChanged(Configuration configuration) {
                plugin.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
            }

            @Override // android.content.ComponentCallbacks
            public final void onLowMemory() {
            }
        });
        sb.append("makeResources cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(";");
        return packageArchiveInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37049a(final Plugin plugin, String str, File file, File file2, StringBuilder sb) {
        long currentTimeMillis = System.currentTimeMillis();
        m37050a(plugin, str, file, file2);
        sb.append("classLoader cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            C6083e.m37212a(new Runnable() { // from class: com.bytedance.pangle.plugin.c.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        PluginClassLoader pluginClassLoader = plugin.mClassLoader;
                        pluginClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(pluginClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
                    } catch (Throwable unused) {
                    }
                }
            });
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            String str2 = (String) FieldUtils.readStaticField(plugin.mClassLoader.loadClass("com.volcengine.StubConfig"), "actStubV1");
            if (str2 != null) {
                m37051a(plugin, str2);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            sb.append("actStubV1 cost:");
            sb.append(System.currentTimeMillis() - currentTimeMillis2);
            sb.append(";");
            throw th;
        }
        sb.append("actStubV1 cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis2);
        sb.append(";");
    }

    /* renamed from: a */
    private static void m37051a(Plugin plugin, String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mapping");
        HashMap hashMap = new HashMap();
        if (optJSONObject2 != null) {
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject2.getString(next));
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("forceMappings");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                int optInt = jSONObject2.optInt("minApi", 0);
                int optInt2 = jSONObject2.optInt("maxApi", Integer.MAX_VALUE);
                int apiVersionCode = plugin.getApiVersionCode();
                if (apiVersionCode <= optInt2 && apiVersionCode >= optInt && (optJSONObject = jSONObject2.optJSONObject("mapping")) != null) {
                    Iterator<String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        hashMap.put(next2, optJSONObject.getString(next2));
                    }
                }
            }
        }
        for (String str2 : hashMap.keySet()) {
            String str3 = (String) hashMap.get(str2);
            String str4 = plugin.mPkgName;
            StringBuilder sb = new StringBuilder();
            sb.append((str3 == null || !str3.contains(".")) ? plugin.mPkgName + "." : "");
            sb.append((String) hashMap.get(str2));
            ComponentManager.registerActivity(str4, sb.toString(), str2);
        }
    }

    /* renamed from: a */
    private static void m37043a(String str, int i, @NonNull String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", C6165b.m37072a(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", C6165b.m37072a(str2));
            jSONObject.putOpt("version_code", C6165b.m37072a(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(C6165b.m37070b(Long.valueOf(j))));
            jSONObject2.putOpt("message", C6165b.m37072a(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C6073b.m37254a().m37253a(str, jSONObject, jSONObject3, jSONObject2);
    }

    /* renamed from: a */
    private static void m37045a(Object obj, String str) {
        if (str != null) {
            try {
                for (String str2 : str.split(File.pathSeparator)) {
                    new File(str2).setReadOnly();
                }
            } catch (Throwable th) {
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th);
                return;
            }
        }
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
        ZeusLogger.m37081i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
    }

    /* renamed from: a */
    private static void m37050a(Plugin plugin, String str, File file, File file2) {
        if (C6253i.m36877k()) {
            PluginClassLoader pluginClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            plugin.mClassLoader = pluginClassLoader;
            m37045a(pluginClassLoader, str);
        } else if (C6253i.m36886b()) {
            String m37179a = C6106g.m37179a(plugin.mPkgName, plugin.getVersion());
            String[] split = m37179a.split(":");
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = !C6096b.m37194a(file2.getAbsolutePath(), split);
            ZeusLogger.m37083d(ZeusLogger.TAG_LOAD, "useDirect:" + (System.currentTimeMillis() - currentTimeMillis) + " " + z);
            PluginClassLoader pluginClassLoader2 = new PluginClassLoader(z ? "" : m37179a, file2, file.getAbsolutePath(), null);
            plugin.mClassLoader = pluginClassLoader2;
            if (z) {
                C6086a.m37209a(pluginClassLoader2, plugin.mPkgName, plugin.getVersion());
            }
        } else {
            plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
        }
    }
}
