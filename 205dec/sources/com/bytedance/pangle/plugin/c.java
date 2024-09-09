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
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.d.e;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.i;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final i f28859a = i.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.w("Zeus/load_pangle", "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        }
        synchronized (plugin) {
            if (!plugin.isInstalled()) {
                ZeusLogger.w("Zeus/load_pangle", "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
                return false;
            } else if (plugin.isLoaded()) {
                return true;
            } else {
                i iVar = f28859a;
                iVar.a(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
                com.bytedance.pangle.log.a a4 = com.bytedance.pangle.log.a.a("Zeus/load_pangle", "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
                a(com.bytedance.pangle.c.b.f28640i, b.a.D, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
                ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
                StringBuilder sb = new StringBuilder();
                boolean a5 = a(str, plugin, sb);
                a4.a("loadPluginInternal:".concat(String.valueOf(a5)));
                if (a5) {
                    plugin.setLifeCycle(3);
                    a(com.bytedance.pangle.c.b.f28641j, b.a.E, plugin.mPkgName, plugin.getVersion(), a4.a(), sb.toString());
                    ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                    iVar.a(2100, 0, plugin.mPkgName, plugin.getVersion(), null);
                } else {
                    sb.append("plugin:");
                    sb.append(plugin.mPkgName);
                    sb.append(" versionCode:");
                    sb.append(plugin.getVersion());
                    sb.append("load failed;");
                    a(com.bytedance.pangle.c.b.f28641j, b.a.F, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                    ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                    iVar.a(2100, -1, plugin.mPkgName, plugin.getVersion(), null);
                }
                ZeusLogger.i("Zeus/load_pangle", "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
                if (plugin.isLoaded()) {
                    ZeusLogger.d("Zeus/load_pangle", "PluginLoader postResult, LOADED " + plugin.mPkgName);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(final java.lang.String r22, final com.bytedance.pangle.plugin.Plugin r23, final java.lang.StringBuilder r24) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.c.a(java.lang.String, com.bytedance.pangle.plugin.Plugin, java.lang.StringBuilder):boolean");
    }

    private static void a(Plugin plugin, StringBuilder sb, PackageInfo packageInfo) {
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
    public PackageInfo a(String str, final Plugin plugin, StringBuilder sb, String str2, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, 143);
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
    public void a(final Plugin plugin, String str, File file, File file2, StringBuilder sb) {
        long currentTimeMillis = System.currentTimeMillis();
        a(plugin, str, file, file2);
        sb.append("classLoader cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            e.a(new Runnable() { // from class: com.bytedance.pangle.plugin.c.4
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
                a(plugin, str2);
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

    private static void a(Plugin plugin, String str) {
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
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
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

    private static void a(String str, int i4, @NonNull String str2, int i5, long j4, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i4)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i5)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j4))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    private static void a(Object obj, String str) {
        if (str != null) {
            try {
                for (String str2 : str.split(File.pathSeparator)) {
                    new File(str2).setReadOnly();
                }
            } catch (Throwable th) {
                ZeusLogger.errReport("Zeus/load_pangle", "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th);
                return;
            }
        }
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
        ZeusLogger.i("Zeus/load_pangle", "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
    }

    private static void a(Plugin plugin, String str, File file, File file2) {
        if (com.bytedance.pangle.util.i.k()) {
            PluginClassLoader pluginClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            plugin.mClassLoader = pluginClassLoader;
            a(pluginClassLoader, str);
        } else if (com.bytedance.pangle.util.i.b()) {
            String a4 = g.a(plugin.mPkgName, plugin.getVersion());
            String[] split = a4.split(":");
            long currentTimeMillis = System.currentTimeMillis();
            boolean z3 = !com.bytedance.pangle.e.b.a(file2.getAbsolutePath(), split);
            ZeusLogger.d("Zeus/load_pangle", "useDirect:" + (System.currentTimeMillis() - currentTimeMillis) + " " + z3);
            PluginClassLoader pluginClassLoader2 = new PluginClassLoader(z3 ? "" : a4, file2, file.getAbsolutePath(), null);
            plugin.mClassLoader = pluginClassLoader2;
            if (z3) {
                com.bytedance.pangle.dex.a.a(pluginClassLoader2, plugin.mPkgName, plugin.getVersion());
            }
        } else {
            plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
        }
    }
}
