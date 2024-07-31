package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p119d.C6082d;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ContentProviderManager {
    public static final String PLUGIN_PKG_NAME = "plugin_pkg_name";
    public static final String PLUGIN_PROCESS_NAME = "process_name";
    public static final String PROVIDER_PARAM_FEILD = "provider_params";
    public static final String PROVIDER_PLUGIN_AUTHORITY = "provider_params";
    public static final String PROVIDER_PROXY_URI = "provider_proxy_uri";
    public static final String PROVIDER_URI = "uri";
    private static ContentProviderManager sInstance;
    private final Map<C6185b, C6184a> mContentProviderMap = new HashMap();
    private final Map<String, String> mAuthorityProcessNameMap = new HashMap();
    private final Map<String, C6186c> mSystemProviderInfoMap = new HashMap();

    /* renamed from: com.bytedance.pangle.provider.ContentProviderManager$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C6184a {

        /* renamed from: a */
        public final C6185b f22117a;

        /* renamed from: b */
        public final ProviderInfo f22118b;

        /* renamed from: c */
        public final PluginContentProvider f22119c;

        public C6184a(C6185b c6185b, ProviderInfo providerInfo, PluginContentProvider pluginContentProvider) {
            this.f22118b = providerInfo;
            this.f22117a = c6185b;
            this.f22119c = pluginContentProvider;
        }
    }

    /* renamed from: com.bytedance.pangle.provider.ContentProviderManager$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6185b {

        /* renamed from: a */
        public final String f22120a;

        /* renamed from: b */
        public final String f22121b;

        /* renamed from: c */
        public final String f22122c;

        public C6185b(String str, String str2, String str3) {
            this.f22120a = str2;
            this.f22121b = str3;
            this.f22122c = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C6185b) {
                C6185b c6185b = (C6185b) obj;
                if (TextUtils.equals(this.f22122c, c6185b.f22122c) && TextUtils.equals(this.f22121b, c6185b.f22121b) && TextUtils.equals(this.f22120a, c6185b.f22120a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 19) {
                return Arrays.hashCode(new Object[]{this.f22120a, this.f22121b, this.f22122c});
            }
            return (this.f22120a + this.f22121b + this.f22120a).hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.bytedance.pangle.provider.ContentProviderManager$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C6186c extends C6185b {

        /* renamed from: d */
        public final ProviderInfo f22123d;

        public C6186c(String str, String str2, ProviderInfo providerInfo) {
            super(str, str2, providerInfo.authority);
            this.f22123d = providerInfo;
        }
    }

    private ContentProviderManager() {
    }

    public static ContentProviderManager getInstance() {
        if (sInstance == null) {
            synchronized (ContentProviderManager.class) {
                if (sInstance == null) {
                    sInstance = new ContentProviderManager();
                }
            }
        }
        return sInstance;
    }

    private void installProvider(String str, ProviderInfo providerInfo, Plugin plugin) {
        if (providerInfo == null) {
            ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "ProviderInfo is null !! can not install plugin provider ， plugin-mPkgName：【" + plugin.mPkgName + "】");
            return;
        }
        if (TextUtils.equals(str, providerInfo.processName)) {
            ZeusLogger.m37079v(ZeusLogger.TAG_PROVIDER, "Start install plugin provider [authority:" + providerInfo.authority + "] [className:" + providerInfo.name + "]");
            try {
                PluginContentProvider instantiateProvider = instantiateProvider(plugin, providerInfo);
                if (instantiateProvider == null) {
                    return;
                }
                instantiateProvider.attachInfo(ZeusTransformUtils.wrapperContext(plugin.mHostApplication, plugin.mPkgName), providerInfo);
                ZeusLogger.m37079v(ZeusLogger.TAG_PROVIDER, "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + providerInfo.name + "]");
                C6185b c6185b = new C6185b(providerInfo.packageName, providerInfo.processName, providerInfo.authority);
                this.mContentProviderMap.put(c6185b, new C6184a(c6185b, providerInfo, instantiateProvider));
            } catch (Exception e) {
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "Instantiating Exception : ", e);
                return;
            }
        }
        this.mAuthorityProcessNameMap.put(providerInfo.authority, providerInfo.processName);
    }

    private PluginContentProvider instantiateProvider(Plugin plugin, ProviderInfo providerInfo) {
        Object newInstance = plugin.mClassLoader.loadClass(providerInfo.name).newInstance();
        if (newInstance instanceof FileProvider) {
            Bundle bundle = providerInfo.metaData;
            if (bundle != null) {
                com.bytedance.pangle.FileProvider.m37279a(plugin, plugin.mResources.getXml(bundle.getInt("android.support.FILE_PROVIDER_PATHS")));
                return null;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data. provider:".concat(String.valueOf(newInstance)));
        }
        return (PluginContentProvider) newInstance;
    }

    public Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        return C6187a.m37033a(contentResolver, uri, str, str2, bundle, str3);
    }

    public int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        return C6187a.m37032a(contentResolver, uri, str, strArr, str2);
    }

    public String getPluginProcessNameByAuthority(String str) {
        return this.mAuthorityProcessNameMap.get(str);
    }

    public PluginContentProvider getPluginProvider(C6185b c6185b) {
        C6184a c6184a = this.mContentProviderMap.get(c6185b);
        if (c6184a == null) {
            return null;
        }
        return c6184a.f22119c;
    }

    public Map<String, C6186c> getSystemProviderInfoMap() {
        return this.mSystemProviderInfoMap;
    }

    public String getType(ContentResolver contentResolver, Uri uri, String str) {
        return C6187a.m37034a(contentResolver, uri, str);
    }

    public void initSystemContentProviderInfo() {
        String str;
        try {
            ProviderInfo[] providerInfoArr = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers;
            if (providerInfoArr == null || providerInfoArr.length == 0) {
                return;
            }
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (providerInfo != null && (str = providerInfo.authority) != null && str.contains(".pangle.provider.proxy.")) {
                    try {
                        ZeusLogger.m37083d(ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.provider.proxy.")) {
                            String m37216a = C6082d.m37216a(providerInfo.processName);
                            this.mSystemProviderInfoMap.put(m37216a, new C6186c(Zeus.getAppApplication().getPackageName(), m37216a, providerInfo));
                            ZeusLogger.m37083d(ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        }
                    } catch (Exception e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + providerInfo.authority + "],exception：", e);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "init System ContentProviderInfo exception：", th);
        }
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        return C6187a.m37037a(contentResolver, uri, contentValues, str);
    }

    public void installContentProviders(Collection<ProviderInfo> collection, Plugin plugin) {
        if (collection == null || collection.size() == 0 || plugin == null) {
            return;
        }
        Zeus.getAppApplication();
        String m37216a = C6082d.m37216a(C6082d.m37218a());
        for (ProviderInfo providerInfo : collection) {
            if (ZeusLogger.isDebug()) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("Install plugin provider [authority:");
                sb.append(providerInfo.authority);
                sb.append("] - [className:");
                sb.append(providerInfo.name);
                sb.append("]");
                ZeusLogger.m37079v(ZeusLogger.TAG_PROVIDER, sb.toString());
            }
            installProvider(m37216a, providerInfo, plugin);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isPluginProvider(Uri uri) {
        if (uri == null) {
            return true;
        }
        String authority = uri.getAuthority();
        Set<String> keySet = this.mAuthorityProcessNameMap.keySet();
        return keySet != null && keySet.contains(authority);
    }

    @RequiresApi(api = 16)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        return C6187a.m37030a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        return C6187a.m37036a(contentResolver, uri, contentValues, str, strArr, str2);
    }

    public final Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        return C6187a.m37028a(contentResolver, str, str2, str3, bundle, str4);
    }

    public int delete(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        return C6187a.m37035a(contentResolver, uri, bundle, str);
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return C6187a.m37038a(contentResolver, uri, contentValues, bundle, str);
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        return C6187a.m37029a(contentResolver, uri, strArr, str, strArr2, str2, str3);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return C6187a.m37024b(contentResolver, uri, contentValues, bundle, str);
    }

    @RequiresApi(api = 26)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        return C6187a.m37031a(contentResolver, uri, strArr, bundle, cancellationSignal, str);
    }
}
