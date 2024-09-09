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
import com.bytedance.pangle.d.d;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ContentProviderManager {
    public static final String PLUGIN_PKG_NAME = "plugin_pkg_name";
    public static final String PLUGIN_PROCESS_NAME = "process_name";
    public static final String PROVIDER_PARAM_FEILD = "provider_params";
    public static final String PROVIDER_PLUGIN_AUTHORITY = "provider_params";
    public static final String PROVIDER_PROXY_URI = "provider_proxy_uri";
    public static final String PROVIDER_URI = "uri";
    private static ContentProviderManager sInstance;
    private final Map<b, a> mContentProviderMap = new HashMap();
    private final Map<String, String> mAuthorityProcessNameMap = new HashMap();
    private final Map<String, c> mSystemProviderInfoMap = new HashMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f28878a;

        /* renamed from: b  reason: collision with root package name */
        public final ProviderInfo f28879b;

        /* renamed from: c  reason: collision with root package name */
        public final PluginContentProvider f28880c;

        public a(b bVar, ProviderInfo providerInfo, PluginContentProvider pluginContentProvider) {
            this.f28879b = providerInfo;
            this.f28878a = bVar;
            this.f28880c = pluginContentProvider;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f28881a;

        /* renamed from: b  reason: collision with root package name */
        public final String f28882b;

        /* renamed from: c  reason: collision with root package name */
        public final String f28883c;

        public b(String str, String str2, String str3) {
            this.f28881a = str2;
            this.f28882b = str3;
            this.f28883c = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (TextUtils.equals(this.f28883c, bVar.f28883c) && TextUtils.equals(this.f28882b, bVar.f28882b) && TextUtils.equals(this.f28881a, bVar.f28881a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 19) {
                return Arrays.hashCode(new Object[]{this.f28881a, this.f28882b, this.f28883c});
            }
            return (this.f28881a + this.f28882b + this.f28881a).hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c extends b {

        /* renamed from: d  reason: collision with root package name */
        public final ProviderInfo f28884d;

        public c(String str, String str2, ProviderInfo providerInfo) {
            super(str, str2, providerInfo.authority);
            this.f28884d = providerInfo;
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
            ZeusLogger.w("Zeus/provider_pangle", "ProviderInfo is null !! can not install plugin provider \uff0c plugin-mPkgName\uff1a\u3010" + plugin.mPkgName + "\u3011");
            return;
        }
        if (TextUtils.equals(str, providerInfo.processName)) {
            ZeusLogger.v("Zeus/provider_pangle", "Start install plugin provider [authority:" + providerInfo.authority + "] [className:" + providerInfo.name + "]");
            try {
                PluginContentProvider instantiateProvider = instantiateProvider(plugin, providerInfo);
                if (instantiateProvider == null) {
                    return;
                }
                instantiateProvider.attachInfo(ZeusTransformUtils.wrapperContext(plugin.mHostApplication, plugin.mPkgName), providerInfo);
                ZeusLogger.v("Zeus/provider_pangle", "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + providerInfo.name + "]");
                b bVar = new b(providerInfo.packageName, providerInfo.processName, providerInfo.authority);
                this.mContentProviderMap.put(bVar, new a(bVar, providerInfo, instantiateProvider));
            } catch (Exception e4) {
                ZeusLogger.w("Zeus/provider_pangle", "Instantiating Exception : ", e4);
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
                com.bytedance.pangle.FileProvider.a(plugin, plugin.mResources.getXml(bundle.getInt("android.support.FILE_PROVIDER_PATHS")));
                return null;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data. provider:".concat(String.valueOf(newInstance)));
        }
        return (PluginContentProvider) newInstance;
    }

    public Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, str, str2, bundle, str3);
    }

    public int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, str, strArr, str2);
    }

    public String getPluginProcessNameByAuthority(String str) {
        return this.mAuthorityProcessNameMap.get(str);
    }

    public PluginContentProvider getPluginProvider(b bVar) {
        a aVar = this.mContentProviderMap.get(bVar);
        if (aVar == null) {
            return null;
        }
        return aVar.f28880c;
    }

    public Map<String, c> getSystemProviderInfoMap() {
        return this.mSystemProviderInfoMap;
    }

    public String getType(ContentResolver contentResolver, Uri uri, String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, str);
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
                        ZeusLogger.d("Zeus/provider_pangle", "Need to init system provider info start [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.provider.proxy.")) {
                            String a4 = d.a(providerInfo.processName);
                            this.mSystemProviderInfoMap.put(a4, new c(Zeus.getAppApplication().getPackageName(), a4, providerInfo));
                            ZeusLogger.d("Zeus/provider_pangle", "Init system provider info finish [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        }
                    } catch (Exception e4) {
                        ZeusLogger.errReport("Zeus/provider_pangle", "Init system contentProviderInfo [authority:" + providerInfo.authority + "],exception\uff1a", e4);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport("Zeus/provider_pangle", "init System ContentProviderInfo exception\uff1a", th);
        }
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, str);
    }

    public void installContentProviders(Collection<ProviderInfo> collection, Plugin plugin) {
        if (collection == null || collection.size() == 0 || plugin == null) {
            return;
        }
        Zeus.getAppApplication();
        String a4 = d.a(d.a());
        for (ProviderInfo providerInfo : collection) {
            if (ZeusLogger.isDebug()) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("Install plugin provider [authority:");
                sb.append(providerInfo.authority);
                sb.append("] - [className:");
                sb.append(providerInfo.name);
                sb.append("]");
                ZeusLogger.v("Zeus/provider_pangle", sb.toString());
            }
            installProvider(a4, providerInfo, plugin);
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
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, str, strArr, str2);
    }

    public final Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        return com.bytedance.pangle.provider.a.a(contentResolver, str, str2, str3, bundle, str4);
    }

    public int delete(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, bundle, str);
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, bundle, str);
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, str, strArr2, str2, str3);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return com.bytedance.pangle.provider.a.b(contentResolver, uri, contentValues, bundle, str);
    }

    @RequiresApi(api = 26)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, bundle, cancellationSignal, str);
    }
}
