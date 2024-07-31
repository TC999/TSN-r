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
import com.bytedance.pangle.log.C6165b;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p118c.C6073b;
import com.bytedance.pangle.p118c.InterfaceC6072a;
import com.bytedance.pangle.p119d.C6078a;
import com.bytedance.pangle.p119d.C6082d;
import com.bytedance.pangle.p119d.C6083e;
import com.bytedance.pangle.p120e.C6102f;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.C6253i;
import com.bytedance.pangle.util.C6254j;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.pangle.i */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6159i {

    /* renamed from: d */
    private static volatile C6159i f22057d;

    /* renamed from: a */
    boolean f22058a;

    /* renamed from: b */
    public final List<ZeusPluginStateListener> f22059b = new CopyOnWriteArrayList();

    /* renamed from: c */
    final List<ZeusPluginEventCallback> f22060c = new ArrayList();

    /* renamed from: e */
    private final Handler f22061e = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static C6159i m37090a() {
        if (f22057d == null) {
            synchronized (C6159i.class) {
                if (f22057d == null) {
                    f22057d = new C6159i();
                }
            }
        }
        return f22057d;
    }

    /* renamed from: b */
    private static void m37087b() {
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
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    private Object[] m37086c() {
        Object[] array;
        synchronized (this.f22060c) {
            array = !this.f22060c.isEmpty() ? this.f22060c.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void m37088a(Application application, boolean z) {
        if (this.f22058a) {
            ZeusLogger.m37077w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        m37089a(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application != null) {
            ZeusLogger.setDebug(globalParam.isDebug());
            ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
            C6083e.m37212a(new Runnable() { // from class: com.bytedance.pangle.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    C6254j.m36872b();
                }
            });
            if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                C6102f.m37186a();
            }
            if (z) {
                Zeus.onPrivacyAgreed();
            }
            C6073b m37254a = C6073b.m37254a();
            InterfaceC6072a interfaceC6072a = new InterfaceC6072a() { // from class: com.bytedance.pangle.i.2
                @Override // com.bytedance.pangle.p118c.InterfaceC6072a
                /* renamed from: a */
                public final void mo37085a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
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
                        str2 = C6082d.m37216a(C6082d.m37218a());
                    }
                    String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
                    if (str2 == null) {
                        str2 = "unknown";
                    }
                    try {
                        jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, C6165b.m37072a(str2));
                        jSONObject.putOpt("host_package_name", packageName);
                        Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                        jSONObject.putOpt("plugin_api_version", C6165b.m37072a(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                        jSONObject.putOpt("zeus_sdk_version", C6165b.m37072a("0.0.1-beta.4200.115-bugfix.16-pangle"));
                        ZeusLogger.m37079v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
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
                    } catch (JSONException e) {
                        ZeusLogger.m37076w(ZeusLogger.TAG_REPORTER, e.getMessage(), e);
                    }
                }
            };
            synchronized (m37254a.f21875a) {
                m37254a.f21875a.add(interfaceC6072a);
            }
            if (!globalParam.isCloseFlipped()) {
                C6065b.m37267a();
            }
            if (Build.VERSION.SDK_INT == 29) {
                C6083e.m37212a(new Runnable() { // from class: com.bytedance.pangle.i.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
            if (C6253i.m36878j()) {
                try {
                    FieldUtils.writeField(C6078a.m37251a(), "mHiddenApiWarningShown", Boolean.TRUE);
                    ZeusLogger.m37077w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                } catch (Exception e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
                }
            }
            m37087b();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            if (!globalParam.closeHookHuaweiOnInit()) {
                Zeus.hookHuaWeiVerifier(application);
            }
            this.f22058a = true;
            m37089a(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
            return;
        }
        throw new IllegalArgumentException("context must be not null !!!");
    }

    /* renamed from: a */
    public final void m37089a(final int i, final int i2, @Nullable final String str, final int i3, @Nullable final Throwable th) {
        Object[] m37086c;
        for (final Object obj : m37086c()) {
            this.f22061e.post(new Runnable() { // from class: com.bytedance.pangle.i.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i, i2, str, i3, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
