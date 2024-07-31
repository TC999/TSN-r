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
import com.bytedance.pangle.C6158h;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.InterfaceC6069c;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p119d.C6080b;
import com.bytedance.pangle.p119d.C6081c;
import com.bytedance.pangle.p119d.C6082d;
import com.bytedance.pangle.p119d.C6083e;
import com.bytedance.pangle.p121f.p122a.C6118e;
import com.bytedance.pangle.res.p124a.C6204c;
import com.bytedance.pangle.servermanager.C6219b;
import com.bytedance.pangle.util.C6237b;
import com.bytedance.pangle.util.C6247c;
import com.bytedance.pangle.util.C6251g;
import com.bytedance.pangle.util.C6255k;
import com.bytedance.pangle.util.C6256l;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.tencent.open.SocialOperation;
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

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
        this.mPkgName = jSONObject.getString(TTDownloadField.TT_PACKAGE_NAME);
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt(TTLiveConstants.LIVE_API_VERSION_KEY);
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString(SocialOperation.GAME_SIGNATURE, "");
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
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.mSharedHostSos.add((String) optJSONArray.get(i));
            }
        }
        setupInternalPlugin();
    }

    private boolean checkValid(File file, String str, int i) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        } else if (i >= this.mMinVersionCode && i <= this.mMaxVersionCode) {
            if (i < this.mVersionCode && isInstalled()) {
                String format = String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i), Integer.valueOf(this.mVersionCode));
                ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + format);
                return false;
            } else if (file != null && file.exists()) {
                if (i == this.mVersionCode && C6256l.m36869a().f22242a.getString("IDENTITY_".concat(String.valueOf(str)), "").equals(C6247c.m36907a(file)[0])) {
                    ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
                    return false;
                }
                ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i + " true");
                return true;
            } else {
                ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
                return false;
            }
        } else {
            String format2 = String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode));
            ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + format2);
            return false;
        }
    }

    private boolean checkVersionValid(int i, int i2, boolean z) {
        int m36868a = C6256l.m36869a().m36868a(this.mPkgName);
        boolean z2 = false;
        if (m36868a > i2) {
            ZeusLogger.m37077w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(m36868a), Integer.valueOf(i2)))));
            return false;
        }
        boolean z3 = i >= 0 && i >= this.mMinVersionCode && i <= this.mMaxVersionCode;
        if (z3 && i2 != -1) {
            C6256l m36869a = C6256l.m36869a();
            String str = this.mPkgName;
            SharedPreferences sharedPreferences = m36869a.f22242a;
            int i3 = sharedPreferences.getInt("API_MIN_" + str + "_" + i, 0);
            C6256l m36869a2 = C6256l.m36869a();
            String str2 = this.mPkgName;
            SharedPreferences sharedPreferences2 = m36869a2.f22242a;
            int i4 = sharedPreferences2.getInt("API_MAX_" + str2 + "_" + i, Integer.MAX_VALUE);
            int i5 = i4 != 0 ? i4 : Integer.MAX_VALUE;
            if (i2 < i3 || i2 > i5) {
                ZeusLogger.m37077w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5)))));
                z3 = false;
            }
        }
        if (z3 && z && C6080b.m37238b(new File(C6081c.m37228b(this.mPkgName, i)))) {
            ZeusLogger.m37077w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i)))));
        } else {
            z2 = z3;
        }
        ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z2);
        return z2;
    }

    private void deleteIfNeeded() {
        if (C6082d.m37217a(Zeus.getAppApplication())) {
            if (C6256l.m36869a().f22242a.getBoolean("UNINSTALL__".concat(String.valueOf(this.mPkgName)), false)) {
                C6256l m36869a = C6256l.m36869a();
                String str = this.mPkgName;
                SharedPreferences.Editor edit = m36869a.f22242a.edit();
                edit.remove("UNINSTALL__".concat(String.valueOf(str)));
                edit.apply();
                deleteInstalledPlugin();
                ZeusLogger.m37077w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = C6081c.m37232a(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    C6256l.m36869a().m36865a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        C6251g.m36896a(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i) {
        if (C6082d.m37217a(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = C6081c.m37232a(this.mPkgName);
            }
            final String concat = "version-".concat(String.valueOf(i));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    if (file != null && !concat.equals(file.getName()) && !"data".equals(file.getName())) {
                        C6251g.m36896a(file.getAbsolutePath());
                        ZeusLogger.m37077w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            C6256l.m36869a().m36865a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void installInternalPlugin() {
        if (C6082d.m37217a(Zeus.getAppApplication())) {
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
            C6083e.m37212a(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                @Override // java.lang.Runnable
                public final void run() {
                    File file;
                    try {
                        if (Plugin.this.mInternalPath.endsWith(".7z.zip")) {
                            String m37229b = C6081c.m37229b();
                            file = new File(m37229b, Plugin.this.mPkgName + ".7z.zip");
                        } else {
                            String m37229b2 = C6081c.m37229b();
                            file = new File(m37229b2, Plugin.this.mPkgName + ".apk");
                        }
                        ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                        C6251g.m36898a(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                        if (file.exists()) {
                            PluginManager.getInstance().asyncInstall(Plugin.this.mPkgName, file);
                            return;
                        }
                        ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                    } catch (Throwable th) {
                        ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + th.getMessage());
                    }
                }
            });
        }
    }

    private int modifyResIfNeed(int i) {
        String m36928a = C6237b.m36928a(Zeus.getAppApplication());
        if (TextUtils.isEmpty(m36928a) || !TextUtils.equals(C6256l.m36869a().m36864b(this.mPkgName), m36928a)) {
            if (!this.mUnInstallPluginWhenHostChange && !GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
                ZeusLogger.m37083d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i);
                int m36987a = new C6204c().m36987a(new File(C6081c.m37228b(this.mPkgName, i)), true, new StringBuilder());
                if (m36987a == 100 || m36987a == 200) {
                    return i;
                }
                return 0;
            }
            ZeusLogger.m37083d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i);
            return 0;
        }
        return i;
    }

    private void setupInternalPlugin() {
        String[] list;
        int m36870a;
        if (C6256l.m36869a().f22242a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
            return;
        }
        if (TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(C6158h.f22055d)) {
                    if (str.startsWith(this.mPkgName + "_") && (m36870a = C6255k.m36870a(str.split("_")[1])) != -1) {
                        this.mInternalPath = C6158h.f22055d + "/" + str;
                        this.mInternalVersionCode = m36870a;
                        return;
                    }
                }
            } catch (IOException e) {
                ZeusLogger.m37076w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
            }
        }
    }

    private void updateInstallStateFromMainProcess() {
        InterfaceC6069c m36964a;
        try {
            if (C6082d.m37217a(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (m36964a = C6219b.m36964a()) == null || !m36964a.mo37169a(this.mPkgName)) {
                return;
            }
            updateToInstalled(m36964a.mo37166b(this.mPkgName));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
            Zeus.getAppApplication();
            sb.append(C6082d.m37218a());
            ZeusLogger.m37076w(ZeusLogger.TAG_PPM, sb.toString(), th);
        }
    }

    private void updateToInstalled(int i) {
        this.mVersionCode = i;
        this.mLifeCycle = 2;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = C6081c.m37232a(this.mPkgName);
        }
        File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        int i = -1;
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                if (parseInt > i && C6256l.m36869a().m36867a(this.mPkgName, parseInt) && new File(C6081c.m37228b(this.mPkgName, parseInt)).exists()) {
                    i = parseInt;
                }
            }
        }
        ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i);
        return i;
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
        int i = this.mVersionCode;
        if (i > 0) {
            return C6081c.m37224d(this.mPkgName, i);
        }
        return C6081c.m37232a(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        boolean z;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (C6082d.m37217a(Zeus.getAppApplication())) {
                int i = 0;
                if (!TextUtils.isEmpty(C6256l.m36869a().f22242a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    C6256l m36869a = C6256l.m36869a();
                    String str = this.mPkgName;
                    z = !TextUtils.equals(m36869a.f22242a.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
                    ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + m36869a.f22242a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z);
                } else {
                    z = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z)) {
                    i = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(i);
                }
                deleteOtherExpiredVer(i);
                ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                C6256l m36869a2 = C6256l.m36869a();
                String str2 = this.mPkgName;
                SharedPreferences.Editor edit = m36869a2.f22242a.edit();
                edit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                edit.apply();
                C6256l m36869a3 = C6256l.m36869a();
                String str3 = this.mPkgName;
                String string = m36869a3.f22242a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor edit2 = m36869a3.f22242a.edit();
                edit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                edit2.apply();
                ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                C6256l m36869a4 = C6256l.m36869a();
                String str4 = this.mPkgName;
                String m36928a = C6237b.m36928a(Zeus.getAppApplication());
                String m36864b = m36869a4.m36864b(str4);
                if (!TextUtils.equals(m36864b, m36928a)) {
                    SharedPreferences.Editor edit3 = m36869a4.f22242a.edit();
                    edit3.putString("HOST_IDENTITY_".concat(String.valueOf(str4)), m36928a);
                    edit3.apply();
                }
                ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str4 + ") " + m36864b + " --> " + m36928a);
                C6256l m36869a5 = C6256l.m36869a();
                String str5 = this.mPkgName;
                int i2 = this.mApiVersionCode;
                int m36868a = m36869a5.m36868a(str5);
                if (m36868a != i2) {
                    SharedPreferences.Editor edit4 = m36869a5.f22242a.edit();
                    edit4.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str5)), i2);
                    edit4.apply();
                }
                ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + m36868a + " --> " + i2);
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
    public boolean install(File file, C6118e c6118e) {
        boolean z = false;
        try {
            ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str = c6118e.f22003a;
            int i = c6118e.f22004b;
            synchronized (this.installLock) {
                ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                boolean checkValid = checkValid(file, str, i);
                if (checkValid) {
                    String str2 = C6247c.m36907a(file)[0];
                    z = C6171b.m37065a(file, str, i);
                    if (z) {
                        C6256l m36869a = C6256l.m36869a();
                        String str3 = this.mPkgName;
                        SharedPreferences.Editor edit = m36869a.f22242a.edit();
                        edit.putString("IDENTITY_".concat(String.valueOf(str3)), str2);
                        edit.apply();
                        C6256l.m36869a().m36865a(this.mPkgName, i, true);
                        ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i + " identity=" + str2);
                        C6251g.m36899a(file);
                    }
                }
                synchronized (this) {
                    if (checkValid) {
                        if (this.mLifeCycle == 3) {
                            ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i);
                        } else if (z) {
                            updateToInstalled(i);
                            ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i);
                        } else {
                            ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i);
                            C6251g.m36899a(file);
                            ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i);
                        }
                    } else {
                        C6251g.m36899a(file);
                        ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th);
        }
        return z;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isVersionInstalled(int i) {
        return C6256l.m36869a().m36867a(this.mPkgName, i);
    }

    public void setApiCompatVersion(int i, int i2, int i3) {
        C6256l m36869a = C6256l.m36869a();
        String str = this.mPkgName;
        SharedPreferences.Editor edit = m36869a.f22242a.edit();
        edit.putInt("API_MIN_" + str + "_" + i, i2);
        edit.putInt("API_MAX_" + str + "_" + i, i3);
        edit.apply();
    }

    public void setLifeCycle(int i) {
        this.mLifeCycle = i;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }
}
