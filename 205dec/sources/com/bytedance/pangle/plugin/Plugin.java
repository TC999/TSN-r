package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.d.e;
import com.bytedance.pangle.h;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.k;
import com.bytedance.pangle.util.l;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    private int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    private volatile boolean mInitialized;
    private String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    private int mVersionCode;
    public String response;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    private volatile int mLifeCycle = 1;
    public final List<String> mSharedHostSos = new ArrayList();
    final Object installLock = new Object();
    final Object initializeLock = new Object();

    public Plugin(JSONObject jSONObject) {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mPkgName = jSONObject.getString("packageName");
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt("apiVersionCode");
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString("signature", "");
        }
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString("appKey", "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = jSONObject.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = jSONObject.optBoolean("reInstallInternalPluginByMd5", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("sharedHostSo");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                this.mSharedHostSos.add((String) optJSONArray.get(i4));
            }
        }
        setupInternalPlugin();
    }

    private boolean checkValid(File file, String str, int i4) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w("Zeus/install_pangle", "Plugin checkValid " + str + " package name not match !!!");
            return false;
        } else if (i4 >= this.mMinVersionCode && i4 <= this.mMaxVersionCode) {
            if (i4 < this.mVersionCode && isInstalled()) {
                String format = String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i4), Integer.valueOf(this.mVersionCode));
                ZeusLogger.w("Zeus/install_pangle", "Plugin checkValid " + str + format);
                return false;
            } else if (file != null && file.exists()) {
                if (i4 == this.mVersionCode && l.a().f29012a.getString("IDENTITY_".concat(String.valueOf(str)), "").equals(com.bytedance.pangle.util.c.a(file)[0])) {
                    ZeusLogger.w("Zeus/install_pangle", "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
                    return false;
                }
                ZeusLogger.i("Zeus/install_pangle", "Plugin checkValid " + str + ":" + i4 + " true");
                return true;
            } else {
                ZeusLogger.w("Zeus/install_pangle", "Plugin checkValid " + str + " pluginApk not exist.");
                return false;
            }
        } else {
            String format2 = String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i4), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode));
            ZeusLogger.w("Zeus/install_pangle", "Plugin checkValid " + str + " " + format2);
            return false;
        }
    }

    private boolean checkVersionValid(int i4, int i5, boolean z3) {
        int a4 = l.a().a(this.mPkgName);
        boolean z4 = false;
        if (a4 > i5) {
            ZeusLogger.w("Zeus/init_pangle", "Plugin".concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(a4), Integer.valueOf(i5)))));
            return false;
        }
        boolean z5 = i4 >= 0 && i4 >= this.mMinVersionCode && i4 <= this.mMaxVersionCode;
        if (z5 && i5 != -1) {
            l a5 = l.a();
            String str = this.mPkgName;
            SharedPreferences sharedPreferences = a5.f29012a;
            int i6 = sharedPreferences.getInt("API_MIN_" + str + "_" + i4, 0);
            l a6 = l.a();
            String str2 = this.mPkgName;
            SharedPreferences sharedPreferences2 = a6.f29012a;
            int i7 = sharedPreferences2.getInt("API_MAX_" + str2 + "_" + i4, Integer.MAX_VALUE);
            int i8 = i7 != 0 ? i7 : Integer.MAX_VALUE;
            if (i5 < i6 || i5 > i8) {
                ZeusLogger.w("Zeus/init_pangle", "Plugin".concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i8)))));
                z5 = false;
            }
        }
        if (z5 && z3 && com.bytedance.pangle.d.b.b(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i4)))) {
            ZeusLogger.w("Zeus/init_pangle", "Plugin".concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i4)))));
        } else {
            z4 = z5;
        }
        ZeusLogger.i("Zeus/init_pangle", "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z4);
        return z4;
    }

    private void deleteIfNeeded() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (l.a().f29012a.getBoolean("UNINSTALL__".concat(String.valueOf(this.mPkgName)), false)) {
                l a4 = l.a();
                String str = this.mPkgName;
                SharedPreferences.Editor edit = a4.f29012a.edit();
                edit.remove("UNINSTALL__".concat(String.valueOf(str)));
                edit.apply();
                deleteInstalledPlugin();
                ZeusLogger.w("Zeus/init_pangle", "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        g.a(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i4) {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
            }
            final String concat = "version-".concat(String.valueOf(i4));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    if (file != null && !concat.equals(file.getName()) && !"data".equals(file.getName())) {
                        g.a(file.getAbsolutePath());
                        ZeusLogger.w("Zeus/init_pangle", "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void installInternalPlugin() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (this.mReInstallInternalPluginByMd5) {
                if (getVersion() > this.mInternalVersionCode) {
                    return;
                }
            } else if (getVersion() >= this.mInternalVersionCode) {
                return;
            }
            if (TextUtils.isEmpty(this.mInternalPath)) {
                return;
            }
            e.a(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                @Override // java.lang.Runnable
                public final void run() {
                    File file;
                    try {
                        if (Plugin.this.mInternalPath.endsWith(".7z.zip")) {
                            String b4 = com.bytedance.pangle.d.c.b();
                            file = new File(b4, Plugin.this.mPkgName + ".7z.zip");
                        } else {
                            String b5 = com.bytedance.pangle.d.c.b();
                            file = new File(b5, Plugin.this.mPkgName + ".apk");
                        }
                        ZeusLogger.i("Zeus/init_pangle", "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                        g.a(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                        if (file.exists()) {
                            PluginManager.getInstance().asyncInstall(Plugin.this.mPkgName, file);
                            return;
                        }
                        ZeusLogger.w("Zeus/install_pangle", "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                    } catch (Throwable th) {
                        ZeusLogger.w("Zeus/install_pangle", "installInternalPlugin failed. " + th.getMessage());
                    }
                }
            });
        }
    }

    private int modifyResIfNeed(int i4) {
        String a4 = com.bytedance.pangle.util.b.a(Zeus.getAppApplication());
        if (TextUtils.isEmpty(a4) || !TextUtils.equals(l.a().b(this.mPkgName), a4)) {
            if (!this.mUnInstallPluginWhenHostChange && !GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
                ZeusLogger.d("Zeus/init_pangle", "modifyRes by init. " + this.mPkgName + " " + i4);
                int a5 = new com.bytedance.pangle.res.a.c().a(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i4)), true, new StringBuilder());
                if (a5 == 100 || a5 == 200) {
                    return i4;
                }
                return 0;
            }
            ZeusLogger.d("Zeus/init_pangle", "uninstall plugin by host update. " + this.mPkgName + " " + i4);
            return 0;
        }
        return i4;
    }

    private void setupInternalPlugin() {
        String[] list;
        int a4;
        if (l.a().f29012a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
            return;
        }
        if (TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(h.f28816d)) {
                    if (str.startsWith(this.mPkgName + "_") && (a4 = k.a(str.split("_")[1])) != -1) {
                        this.mInternalPath = h.f28816d + TTPathConst.sSeparator + str;
                        this.mInternalVersionCode = a4;
                        return;
                    }
                }
            } catch (IOException e4) {
                ZeusLogger.w("Zeus/install_pangle", "setupInternalPlugin failed.", e4);
            }
        }
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.c a4;
        try {
            if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (a4 = com.bytedance.pangle.servermanager.b.a()) == null || !a4.a(this.mPkgName)) {
                return;
            }
            updateToInstalled(a4.b(this.mPkgName));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
            Zeus.getAppApplication();
            sb.append(com.bytedance.pangle.d.d.a());
            ZeusLogger.w("Zeus/ppm_pangle", sb.toString(), th);
        }
    }

    private void updateToInstalled(int i4) {
        this.mVersionCode = i4;
        this.mLifeCycle = 2;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        int i4 = -1;
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                if (parseInt > i4 && l.a().a(this.mPkgName, parseInt) && new File(com.bytedance.pangle.d.c.b(this.mPkgName, parseInt)).exists()) {
                    i4 = parseInt;
                }
            }
        }
        ZeusLogger.i("Zeus/init_pangle", "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i4);
        return i4;
    }

    public String getInternalPath() {
        return this.mInternalPath;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public String getNativeLibraryDir() {
        int i4 = this.mVersionCode;
        if (i4 > 0) {
            return com.bytedance.pangle.d.c.d(this.mPkgName, i4);
        }
        return com.bytedance.pangle.d.c.a(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        boolean z3;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
                int i4 = 0;
                if (!TextUtils.isEmpty(l.a().f29012a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    l a4 = l.a();
                    String str = this.mPkgName;
                    z3 = !TextUtils.equals(a4.f29012a.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
                    ZeusLogger.i("Zeus/init_pangle", "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + a4.f29012a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z3);
                } else {
                    z3 = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z3)) {
                    i4 = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(i4);
                }
                deleteOtherExpiredVer(i4);
                ZeusLogger.i("Zeus/init_pangle", "Plugin initPlugins result=".concat(String.valueOf(this)));
                l a5 = l.a();
                String str2 = this.mPkgName;
                SharedPreferences.Editor edit = a5.f29012a.edit();
                edit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                edit.apply();
                l a6 = l.a();
                String str3 = this.mPkgName;
                String string = a6.f29012a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor edit2 = a6.f29012a.edit();
                edit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                edit2.apply();
                ZeusLogger.i("Zeus/init_pangle", "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                l a7 = l.a();
                String str4 = this.mPkgName;
                String a8 = com.bytedance.pangle.util.b.a(Zeus.getAppApplication());
                String b4 = a7.b(str4);
                if (!TextUtils.equals(b4, a8)) {
                    SharedPreferences.Editor edit3 = a7.f29012a.edit();
                    edit3.putString("HOST_IDENTITY_".concat(String.valueOf(str4)), a8);
                    edit3.apply();
                }
                ZeusLogger.i("Zeus/init_pangle", "ZeusSpUtils setHostIdentity(" + str4 + ") " + b4 + " --> " + a8);
                l a9 = l.a();
                String str5 = this.mPkgName;
                int i5 = this.mApiVersionCode;
                int a10 = a9.a(str5);
                if (a10 != i5) {
                    SharedPreferences.Editor edit4 = a9.f29012a.edit();
                    edit4.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str5)), i5);
                    edit4.apply();
                }
                ZeusLogger.i("Zeus/init_pangle", "ZeusSpUtils setPluginApiVersion " + a10 + " --> " + i5);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean install(File file, com.bytedance.pangle.f.a.e eVar) {
        boolean z3 = false;
        try {
            ZeusLogger.i("Zeus/install_pangle", "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str = eVar.f28764a;
            int i4 = eVar.f28765b;
            synchronized (this.installLock) {
                ZeusLogger.i("Zeus/install_pangle", "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                boolean checkValid = checkValid(file, str, i4);
                if (checkValid) {
                    String str2 = com.bytedance.pangle.util.c.a(file)[0];
                    z3 = b.a(file, str, i4);
                    if (z3) {
                        l a4 = l.a();
                        String str3 = this.mPkgName;
                        SharedPreferences.Editor edit = a4.f29012a.edit();
                        edit.putString("IDENTITY_".concat(String.valueOf(str3)), str2);
                        edit.apply();
                        l.a().a(this.mPkgName, i4, true);
                        ZeusLogger.i("Zeus/install_pangle", "Plugin markPluginInstalled, " + this.mPkgName + ":" + i4 + " identity=" + str2);
                        g.a(file);
                    }
                }
                synchronized (this) {
                    if (checkValid) {
                        if (this.mLifeCycle == 3) {
                            ZeusLogger.w("Zeus/install_pangle", "Plugin LIFE_LOADED, valid next restart " + str + ":" + i4);
                        } else if (z3) {
                            updateToInstalled(i4);
                            ZeusLogger.i("Zeus/install_pangle", "Plugin INSTALLED " + str + ":" + i4);
                        } else {
                            ZeusLogger.i("Zeus/install_pangle", "Plugin INSTALL_FAILED" + str + ":" + i4);
                            g.a(file);
                            ZeusLogger.w("Zeus/install_pangle", "Plugin delete file by failedCount > 0 " + str + ":" + i4);
                        }
                    } else {
                        g.a(file);
                        ZeusLogger.w("Zeus/install_pangle", "Plugin deleting invalid " + str + ":" + i4);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport("Zeus/install_pangle", "Plugin IMPOSSIBLE!!!", th);
        }
        return z3;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isVersionInstalled(int i4) {
        return l.a().a(this.mPkgName, i4);
    }

    public void setApiCompatVersion(int i4, int i5, int i6) {
        l a4 = l.a();
        String str = this.mPkgName;
        SharedPreferences.Editor edit = a4.f29012a.edit();
        edit.putInt("API_MIN_" + str + "_" + i4, i5);
        edit.putInt("API_MAX_" + str + "_" + i4, i6);
        edit.apply();
    }

    public void setLifeCycle(int i4) {
        this.mLifeCycle = i4;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }
}
