package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i {

    /* renamed from: d  reason: collision with root package name */
    private static volatile i f28818d;

    /* renamed from: a  reason: collision with root package name */
    boolean f28819a;

    /* renamed from: b  reason: collision with root package name */
    public final List<ZeusPluginStateListener> f28820b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    final List<ZeusPluginEventCallback> f28821c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f28822e = new Handler(Looper.getMainLooper());

    public static i a() {
        if (f28818d == null) {
            synchronized (i.class) {
                if (f28818d == null) {
                    f28818d = new i();
                }
            }
        }
        return f28818d;
    }

    private static void b() {
        ProviderInfo[] providerInfoArr;
        String str;
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                            if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                                str = providerInfo.processName.split(":")[1];
                                if (Zeus.getServerManagerHashMap().get(str) != null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                                    Zeus.getServerManagerHashMap().put(str, providerInfo);
                                }
                            }
                            str = "main";
                            if (Zeus.getServerManagerHashMap().get(str) != null) {
                            }
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                return;
            }
            ZeusLogger.errReport("Zeus/init_pangle", "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    private Object[] c() {
        Object[] array;
        synchronized (this.f28821c) {
            array = !this.f28821c.isEmpty() ? this.f28821c.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(Application application, boolean z3) {
        if (this.f28819a) {
            ZeusLogger.w("Zeus/init_pangle", "ZeusManager zeus has been inited!");
            return;
        }
        a(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application != null) {
            ZeusLogger.setDebug(globalParam.isDebug());
            ZeusLogger.i("Zeus/init_pangle", "ZeusManager init, context = " + application + ", hParam = " + globalParam);
            com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    j.b();
                }
            });
            if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                com.bytedance.pangle.e.f.a();
            }
            if (z3) {
                Zeus.onPrivacyAgreed();
            }
            com.bytedance.pangle.c.b a4 = com.bytedance.pangle.c.b.a();
            com.bytedance.pangle.c.a aVar = new com.bytedance.pangle.c.a() { // from class: com.bytedance.pangle.i.2
                @Override // com.bytedance.pangle.c.a
                public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    String str2 = null;
                    if (Zeus.getAppApplication() != null) {
                        Zeus.getAppApplication();
                        str2 = com.bytedance.pangle.d.d.a(com.bytedance.pangle.d.d.a());
                    }
                    String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
                    if (str2 == null) {
                        str2 = "unknown";
                    }
                    try {
                        jSONObject.putOpt("process_name", com.bytedance.pangle.log.b.a(str2));
                        jSONObject.putOpt("host_package_name", packageName);
                        Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                        jSONObject.putOpt("plugin_api_version", com.bytedance.pangle.log.b.a(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                        jSONObject.putOpt("zeus_sdk_version", com.bytedance.pangle.log.b.a("0.0.1-beta.4200.115-bugfix.20-aiqiyi-pangle"));
                        ZeusLogger.v("Zeus/reporter_pangle", "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
                        IZeusReporter reporter = GlobalParam.getInstance().getReporter();
                        if (reporter != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                jSONObject4.putOpt(next, jSONObject.opt(next));
                            }
                            Iterator<String> keys2 = jSONObject2.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                            }
                            Iterator<String> keys3 = jSONObject3.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                            }
                            reporter.report(str, jSONObject4);
                        }
                        ApmUtils.getApmInstance().monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
                    } catch (JSONException e4) {
                        ZeusLogger.w("Zeus/reporter_pangle", e4.getMessage(), e4);
                    }
                }
            };
            synchronized (a4.f28644a) {
                a4.f28644a.add(aVar);
            }
            if (!globalParam.isCloseFlipped()) {
                b.a();
            }
            if (Build.VERSION.SDK_INT == 29) {
                com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.i.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
            if (com.bytedance.pangle.util.i.j()) {
                try {
                    FieldUtils.writeField(com.bytedance.pangle.d.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                    ZeusLogger.w("Zeus/init_pangle", "ZeusManager disableApiWarningShownForAndroidP, true");
                } catch (Exception e4) {
                    ZeusLogger.errReport("Zeus/init_pangle", "disableApiWarningShownForAndroidP failed", e4);
                }
            }
            b();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            if (!globalParam.closeHookHuaweiOnInit()) {
                Zeus.hookHuaWeiVerifier(application);
            }
            this.f28819a = true;
            a(3100, 0, null, -1, null);
            return;
        }
        throw new IllegalArgumentException("context must be not null !!!");
    }

    public final void a(final int i4, final int i5, @Nullable final String str, final int i6, @Nullable final Throwable th) {
        Object[] c4;
        for (final Object obj : c()) {
            this.f28822e.post(new Runnable() { // from class: com.bytedance.pangle.i.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i4, i5, str, i6, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
